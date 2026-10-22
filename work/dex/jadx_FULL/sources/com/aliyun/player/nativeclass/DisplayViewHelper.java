package com.aliyun.player.nativeclass;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.aliyun.player.IPlayer;
import com.aliyun.player.videoview.AliDisplayView;
import com.aliyun.player.videoview.a.a;
import com.aliyun.player.videoview.a.b;
import com.aliyun.player.videoview.a.c;
import com.cicada.player.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DisplayViewHelper {
    private static final String TAG = "AliDisplayView_" + DisplayViewHelper.class.getSimpleName();
    private AliDisplayView mAliView;
    private a mDisPlayView = null;
    private View mClearScreenView = null;
    private int oldWith = -1;
    private int oldHeight = -1;
    private boolean surfaceValid = false;
    private List<a> mOldDisplayViews = new ArrayList();
    private int mBackgroundColor = -16777216;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private int mVideoRotate = 0;
    private IPlayer.ScaleMode mScaleMode = IPlayer.ScaleMode.SCALE_ASPECT_FIT;
    private IPlayer.MirrorMode mMirrorMode = IPlayer.MirrorMode.MIRROR_MODE_NONE;
    private IPlayer.RotateMode mRotateMode = IPlayer.RotateMode.ROTATE_0;
    private boolean mDirectRender = false;
    private a.h mListener = null;
    private boolean mReuseSurface = true;

    public DisplayViewHelper(AliDisplayView aliDisplayView) {
        this.mAliView = aliDisplayView;
        init();
    }

    private void init() {
        this.mClearScreenView = new View(this.mAliView.getContext());
        this.mAliView.addView(this.mClearScreenView, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(Color.parseColor("#FF000000"));
        this.mAliView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.aliyun.player.nativeclass.DisplayViewHelper.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int measuredWidth = DisplayViewHelper.this.mAliView.getMeasuredWidth();
                int measuredHeight = DisplayViewHelper.this.mAliView.getMeasuredHeight();
                if (measuredWidth == DisplayViewHelper.this.oldWith && measuredHeight == DisplayViewHelper.this.oldHeight) {
                    return;
                }
                DisplayViewHelper.this.oldWith = measuredWidth;
                DisplayViewHelper.this.oldHeight = measuredHeight;
                if (DisplayViewHelper.this.mDisPlayView != null) {
                    DisplayViewHelper.this.mDisPlayView.d();
                }
            }
        });
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mClearScreenView.post(runnable);
        }
    }

    public void clearScreen() {
        Logger.i(TAG, "clearScreen ");
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.nativeclass.DisplayViewHelper.3
            @Override // java.lang.Runnable
            public void run() {
                DisplayViewHelper.this.mClearScreenView.setVisibility(0);
                for (a aVar : DisplayViewHelper.this.mOldDisplayViews) {
                    if (aVar != null) {
                        aVar.b();
                    }
                }
                DisplayViewHelper.this.mOldDisplayViews.clear();
                if (DisplayViewHelper.this.mDisPlayView != null) {
                    DisplayViewHelper.this.mDisPlayView.b();
                    DisplayViewHelper.this.mDisPlayView = null;
                }
            }
        });
    }

    public synchronized void createDisplayView(AliDisplayView.DisplayViewType displayViewType, boolean z) {
        a bVar;
        AliDisplayView.DisplayViewType preferDisplayViewType = this.mAliView.getPreferDisplayViewType();
        if (displayViewType == null || displayViewType == AliDisplayView.DisplayViewType.Either) {
            displayViewType = preferDisplayViewType;
        }
        a aVar = this.mDisPlayView;
        if (displayViewType == AliDisplayView.DisplayViewType.TextureView) {
            bVar = new c(this.mAliView);
            this.mDisPlayView = bVar;
        } else {
            bVar = new b(this.mAliView);
            this.mDisPlayView = bVar;
        }
        bVar.c();
        a.h hVar = this.mListener;
        if (hVar != null) {
            hVar.onViewCreated(displayViewType);
        }
        final AliDisplayView.OnViewStatusListener onViewStatusListener = this.mAliView.getOnViewStatusListener();
        if (onViewStatusListener != null) {
            onViewStatusListener.onViewCreated(displayViewType);
        }
        a aVar2 = this.mDisPlayView;
        if (aVar2 != null) {
            aVar2.a(new a.h() { // from class: com.aliyun.player.nativeclass.DisplayViewHelper.2
                @Override // com.aliyun.player.videoview.a.a.h
                public void onSurfaceCreated(Surface surface) {
                    DisplayViewHelper.this.surfaceValid = true;
                    if (DisplayViewHelper.this.mListener != null) {
                        DisplayViewHelper.this.mListener.onSurfaceCreated(surface);
                    }
                    AliDisplayView.OnViewStatusListener onViewStatusListener2 = onViewStatusListener;
                    if (onViewStatusListener2 != null) {
                        onViewStatusListener2.onSurfaceCreated();
                    }
                }

                @Override // com.aliyun.player.videoview.a.a.h
                public void onSurfaceDestroy() {
                    DisplayViewHelper.this.surfaceValid = false;
                    if (DisplayViewHelper.this.mListener != null) {
                        DisplayViewHelper.this.mListener.onSurfaceDestroy();
                    }
                    AliDisplayView.OnViewStatusListener onViewStatusListener2 = onViewStatusListener;
                    if (onViewStatusListener2 != null) {
                        onViewStatusListener2.onSurfaceDestroy();
                    }
                }

                @Override // com.aliyun.player.videoview.a.a.h
                public void onSurfaceSizeChanged() {
                    if (DisplayViewHelper.this.mListener != null) {
                        DisplayViewHelper.this.mListener.onSurfaceSizeChanged();
                    }
                    AliDisplayView.OnViewStatusListener onViewStatusListener2 = onViewStatusListener;
                    if (onViewStatusListener2 != null) {
                        onViewStatusListener2.onSurfaceSizeChanged();
                    }
                }

                @Override // com.aliyun.player.videoview.a.a.h
                public void onViewCreated(AliDisplayView.DisplayViewType displayViewType2) {
                }
            });
            this.mDisPlayView.b(this.mReuseSurface);
            setRenderFlagChanged(z);
            this.mDisPlayView.a(this.mVideoWidth, this.mVideoHeight, this.mVideoRotate);
            this.mDisPlayView.b(this.mMirrorMode);
            this.mDisPlayView.b(this.mRotateMode);
            this.mDisPlayView.a(this.mScaleMode);
            this.mDisPlayView.a();
            if (aVar != null) {
                aVar.a((a.h) null);
                this.mOldDisplayViews.add(aVar);
            }
        }
    }

    public void firstFrameRender(final boolean z) {
        Logger.i(TAG, "firstFrameRender , hasVideo = " + z);
        runOnUiThread(new Runnable() { // from class: com.aliyun.player.nativeclass.DisplayViewHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    for (a aVar : DisplayViewHelper.this.mOldDisplayViews) {
                        if (aVar != null) {
                            aVar.b();
                        }
                    }
                    DisplayViewHelper.this.mOldDisplayViews.clear();
                }
                DisplayViewHelper.this.mClearScreenView.setVisibility(4);
            }
        });
    }

    public boolean needUpdateView(AliDisplayView.DisplayViewType displayViewType) {
        return true;
    }

    public void setBackgroundColor(int i) {
        Logger.i(TAG, "setBackgroundColor " + i);
        this.mBackgroundColor = i;
        View view = this.mClearScreenView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
        this.mAliView.setBackgroundColor(i);
    }

    public void setMirrorMode(IPlayer.MirrorMode mirrorMode) {
        Logger.i(TAG, "setMirrorMode " + mirrorMode);
        this.mMirrorMode = mirrorMode;
        a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.b(mirrorMode);
        }
    }

    public void setOnViewStatusListener(a.h hVar) {
        this.mListener = hVar;
    }

    public void setRenderFlagChanged(boolean z) {
        Logger.i(TAG, "setRenderFlagChanged = " + z);
        this.mDirectRender = z;
        a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setRotateMode(IPlayer.RotateMode rotateMode) {
        Logger.i(TAG, "setRotateMode " + rotateMode);
        this.mRotateMode = rotateMode;
        a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.b(rotateMode);
        }
    }

    public void setScaleMode(IPlayer.ScaleMode scaleMode) {
        Logger.i(TAG, "setScaleMode " + scaleMode);
        this.mScaleMode = scaleMode;
        a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.a(scaleMode);
        }
    }

    public void setSurfaceReuse(boolean z) {
        this.mReuseSurface = z;
        a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void setVideoSize(int i, int i2, int i3) {
        Logger.i(TAG, "setVideoSize " + i + " , " + i2);
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.mVideoRotate = i3;
        a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.a(i, i2, i3);
        }
    }

    public Bitmap snapshot() {
        Bitmap bitmapF;
        a aVar = this.mDisPlayView;
        if (aVar == null || (bitmapF = aVar.f()) == null) {
            return null;
        }
        this.mAliView.buildDrawingCache();
        Bitmap drawingCache = this.mAliView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache.getWidth(), drawingCache.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(drawingCache, 0.0f, 0.0f, new Paint());
        drawingCache.recycle();
        canvas.drawBitmap(bitmapF, (drawingCache.getWidth() - bitmapF.getWidth()) / 2.0f, (drawingCache.getHeight() - bitmapF.getHeight()) / 2.0f, new Paint());
        bitmapF.recycle();
        if (this.mClearScreenView.getVisibility() == 0) {
            this.mClearScreenView.buildDrawingCache();
            Bitmap drawingCache2 = this.mClearScreenView.getDrawingCache();
            if (drawingCache2 != null) {
                canvas.drawBitmap(drawingCache2, 0.0f, 0.0f, new Paint());
                drawingCache2.recycle();
            }
        }
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }
}
