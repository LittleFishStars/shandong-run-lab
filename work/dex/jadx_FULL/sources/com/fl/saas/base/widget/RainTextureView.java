package com.fl.saas.base.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import com.fl.saas.base.rest.PreResManager;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ListUtils;
import com.fl.saas.common.util.RandomUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.FileHelper;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RainTextureView extends TextureView implements Runnable {
    private static final int MAX_ICON_COUNT = 2;
    private boolean isAutoRemove;
    private boolean isFinish;
    private boolean isPause;
    private boolean isRunnable;
    private final List<Bitmap> mBitmaps;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Matrix mMatrix;
    private final CopyOnWriteArrayList<RainItem> mRainItems;
    private OnStatusListener mStatusListener;
    private SurfaceTexture mSurfaceTexture;
    private final int maxCount;
    private Paint paint;
    private boolean saveClickItem;

    public interface OnStatusListener {
        void onStop();
    }

    public static class RainItem {
        public static final int CLICK_END = 2;
        public static final int CLICK_START = 1;
        public static final int NON_CLICK = 0;
        private static final int PX = DeviceUtil.dip2px(1.0f);
        Bitmap bitmap;
        private int clickStatus = 0;
        private int rotate;
        private int speed;
        private int startX;
        private int startY;

        public static RainItem create(List<Bitmap> list, RainItem rainItem) {
            double d;
            int i;
            if (list == null || list.isEmpty()) {
                return null;
            }
            RainItem rainItem2 = new RainItem();
            Bitmap bitmapCreateRandomBitmap = createRandomBitmap(list);
            if (bitmapCreateRandomBitmap == null) {
                return null;
            }
            while (rainItem != null && rainItem.bitmap != null && list.size() > 1 && rainItem.bitmap == bitmapCreateRandomBitmap) {
                bitmapCreateRandomBitmap = createRandomBitmap(list);
            }
            rainItem2.bitmap = bitmapCreateRandomBitmap;
            double d2 = 3.5d;
            if (RandomUtils.getRandomInt(10) >= 8) {
                d = PX;
                i = (int) (3.5d * d);
                d2 = 4.5d;
            } else {
                d = PX;
                i = (int) (2.8d * d);
            }
            rainItem2.speed = RandomUtils.getRandomInt(i, (int) (d * d2));
            rainItem2.rotate = RandomUtils.getRandomInt(-45, 45);
            rainItem2.startY = 0;
            return rainItem2;
        }

        public static Bitmap createRandomBitmap(List<Bitmap> list) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list.get(RandomUtils.getRandomInt(list.size()));
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public int getHeight() {
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }

        public int getRotate() {
            return this.rotate;
        }

        public int getSpeed() {
            return this.speed;
        }

        public int getStartX() {
            return this.startX;
        }

        public int getStartY() {
            return this.startY;
        }

        public int getWidth() {
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }

        public boolean isClicking() {
            return this.clickStatus == 1;
        }

        public void setClickEnd() {
            if (this.clickStatus == 1) {
                this.clickStatus = 2;
            }
        }

        public void setClickStart() {
            this.clickStatus = 1;
        }

        public void setRotate(int i) {
            this.rotate = i;
        }

        public RainItem setSpeed(int i) {
            this.speed = i;
            return this;
        }

        public void setStartX(int i) {
            this.startX = i;
        }

        public void setStartY(int i) {
            this.startY = i;
        }
    }

    public RainTextureView(Context context) {
        super(context);
        this.mRainItems = new CopyOnWriteArrayList<>();
        this.mBitmaps = new ArrayList();
        this.isRunnable = true;
        this.isFinish = false;
        this.isPause = false;
        this.saveClickItem = true;
        this.isAutoRemove = false;
        this.maxCount = 15;
        init();
    }

    public RainTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRainItems = new CopyOnWriteArrayList<>();
        this.mBitmaps = new ArrayList();
        this.isRunnable = true;
        this.isFinish = false;
        this.isPause = false;
        this.saveClickItem = true;
        this.isAutoRemove = false;
        this.maxCount = 15;
        init();
    }

    public RainTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRainItems = new CopyOnWriteArrayList<>();
        this.mBitmaps = new ArrayList();
        this.isRunnable = true;
        this.isFinish = false;
        this.isPause = false;
        this.saveClickItem = true;
        this.isAutoRemove = false;
        this.maxCount = 15;
        init();
    }

    private void addItem() {
        RainItem rainItemCreateTwoItem;
        if (this.mRainItems.size() >= 15) {
            return;
        }
        for (RainItem rainItem : this.mRainItems) {
            if (rainItem.startY < ((double) rainItem.getBitmap().getHeight()) * 1.25d) {
                return;
            }
        }
        if (this.mBitmaps.isEmpty()) {
            initBitmaps();
        }
        RainItem rainItemCreateOneItem = createOneItem();
        if (rainItemCreateOneItem == null) {
            return;
        }
        this.mRainItems.add(rainItemCreateOneItem);
        if (RandomUtils.getRandomInt(10) < 8 || (rainItemCreateTwoItem = createTwoItem(rainItemCreateOneItem)) == null) {
            return;
        }
        this.mRainItems.add(rainItemCreateTwoItem);
    }

    private boolean checkInRect(float f, float f2) {
        Log.d("Falling", "checkInRect");
        int size = this.mRainItems.size();
        for (int i = 0; i < size; i++) {
            RainItem rainItem = this.mRainItems.get(i);
            if (new Rect(rainItem.startX, rainItem.startY, rainItem.startX + rainItem.getWidth(), rainItem.startY + rainItem.getHeight()).contains(Math.round(f), Math.round(f2))) {
                if (!this.saveClickItem) {
                    return true;
                }
                rainItem.setClickStart();
                return true;
            }
        }
        return false;
    }

    private RainItem createOneItem() {
        int i;
        RainItem rainItemCreate = RainItem.create(this.mBitmaps, (RainItem) ListUtils.getLastElement(this.mRainItems));
        if (rainItemCreate == null) {
            return null;
        }
        if (this.mRainItems.isEmpty()) {
            i = 0;
        } else {
            CopyOnWriteArrayList<RainItem> copyOnWriteArrayList = this.mRainItems;
            i = copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1).startX;
        }
        rainItemCreate.startX = getStartX(i, rainItemCreate.getWidth());
        return rainItemCreate;
    }

    private RainItem createTwoItem(RainItem rainItem) {
        RainItem rainItemCreate = RainItem.create(this.mBitmaps, (RainItem) ListUtils.getLastElement(this.mRainItems));
        if (rainItem == null) {
            return null;
        }
        rainItemCreate.startX = getStartX(rainItem.startX, rainItemCreate.getWidth());
        return rainItemCreate;
    }

    private int getStartX(int i, int i2) {
        return (!RandomUtils.getRandomBoolean() ? i <= i2 : i + i2 < this.mCanvasWidth - i2) ? RandomUtils.getRandomInt(0, i - i2) : RandomUtils.getRandomInt(i + i2, this.mCanvasWidth - i2);
    }

    private void init() {
        setOpaque(false);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.mMatrix = new Matrix();
        setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.fl.saas.base.widget.RainTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (RainTextureView.this.isFinish || RainTextureView.this.isPause) {
                    return;
                }
                RainTextureView.this.isRunnable = true;
                RainTextureView.this.mSurfaceTexture = surfaceTexture;
                RainTextureView.this.startRun();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                RainTextureView.this.isRunnable = false;
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    private void initBitmaps() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int iDip2px = DeviceUtil.dip2px(82.0f);
        List<String> dirInAllFilePath = PreResManager.getDirInAllFilePath(getContext(), PreResManager.RAIN_CACHE);
        while (!dirInAllFilePath.isEmpty() && this.mBitmaps.size() < 2) {
            int randomInt = RandomUtils.getRandomInt(dirInAllFilePath.size());
            String str = dirInAllFilePath.get(randomInt);
            Bitmap bitmapScaleBitmapMaxSize = ImageUtils.scaleBitmapMaxSize(BitmapFactory.decodeFile(str, options), iDip2px);
            if (bitmapScaleBitmapMaxSize != null) {
                this.mBitmaps.add(bitmapScaleBitmapMaxSize);
            } else {
                try {
                    FileHelper.deleteFile(new File(str));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dirInAllFilePath.remove(randomInt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$0() {
        ViewHelper.removeParent(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRun() {
        if (this.isFinish || this.isPause) {
            return;
        }
        ThreadPoolManager.getInstance().addTask(this);
    }

    public boolean hasClickItem() {
        Iterator<RainItem> it = this.mRainItems.iterator();
        while (it.hasNext()) {
            if (it.next().isClicking()) {
                return true;
            }
        }
        return false;
    }

    public boolean isClickItem(float f, float f2) {
        return checkInRect(f, f2);
    }

    public void pause() {
        this.isPause = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mSurfaceTexture == null) {
            return;
        }
        Surface surface = new Surface(this.mSurfaceTexture);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Canvas canvasLockCanvas = null;
        while (this.isRunnable && !this.isFinish) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (!this.isPause && jCurrentTimeMillis2 >= 16) {
                jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    canvasLockCanvas = surface.lockCanvas(null);
                    if (this.mCanvasHeight == 0) {
                        this.mCanvasHeight = canvasLockCanvas.getHeight();
                        this.mCanvasWidth = canvasLockCanvas.getWidth();
                    }
                    canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    boolean z = true;
                    for (int i = 0; i < this.mRainItems.size(); i++) {
                        RainItem rainItem = this.mRainItems.get(i);
                        if (rainItem.startY <= this.mCanvasHeight) {
                            this.mMatrix.setRotate(rainItem.getRotate(), rainItem.getWidth() / 2.0f, rainItem.getHeight() / 2.0f);
                            this.mMatrix.postTranslate(rainItem.startX, rainItem.startY);
                            canvasLockCanvas.drawBitmap(rainItem.getBitmap(), this.mMatrix, this.paint);
                            if (!rainItem.isClicking()) {
                                rainItem.setStartY(rainItem.getStartY() + rainItem.speed);
                            }
                            z = false;
                        }
                    }
                    if (this.isRunnable) {
                        try {
                            surface.unlockCanvasAndPost(canvasLockCanvas);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (z && !this.mRainItems.isEmpty()) {
                        stop();
                        break;
                    }
                    addItem();
                } catch (Exception unused) {
                }
            }
        }
        if (this.isRunnable) {
            try {
                if (canvasLockCanvas == null) {
                    try {
                        canvasLockCanvas = surface.lockCanvas(null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                surface.unlockCanvasAndPost(canvasLockCanvas);
            } finally {
                surface.release();
            }
        }
    }

    public RainTextureView setAutoRemove() {
        this.isAutoRemove = true;
        return this;
    }

    public RainTextureView setOnStatusListener(OnStatusListener onStatusListener) {
        this.mStatusListener = onStatusListener;
        return this;
    }

    public void setSaveClickItem(boolean z) {
        this.saveClickItem = z;
    }

    public void start() {
        this.isPause = false;
        startRun();
    }

    public void stop() {
        this.isFinish = true;
        if (this.isAutoRemove) {
            post(new Runnable() { // from class: com.zj.adlib.j97
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42534a.lambda$stop$0();
                }
            });
        }
        OnStatusListener onStatusListener = this.mStatusListener;
        if (onStatusListener != null) {
            onStatusListener.onStop();
        }
    }
}
