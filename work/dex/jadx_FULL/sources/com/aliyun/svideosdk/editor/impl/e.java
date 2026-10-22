package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.aliyun.svideosdk.common.struct.CanvasInfo;
import com.aliyun.svideosdk.common.struct.project.CanvasAction;
import com.aliyun.svideosdk.editor.AliyunIPaint;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class e extends View implements BitmapGenerator {
    private static final String t = "com.aliyun.svideosdk.editor.impl.e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f25738a;
    private Canvas b;
    private AliyunIPaint c;
    private Paint d;
    private int e;
    private int f;
    private CanvasAction g;
    private int h;
    private List<CanvasAction> i;
    private List<CanvasAction> j;
    private String k;
    private CanvasInfo l;
    private HandlerThread m;
    private Handler n;
    private Handler o;
    private boolean p;
    private Object q;
    private Runnable r;
    private Runnable s;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.invalidate();
            e.this.p = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(e.t, "before undo");
            e.this.f25738a.eraseColor(0);
            if (e.this.i != null && e.this.i.size() > 0) {
                e.this.i.remove((CanvasAction) e.this.i.get(e.this.i.size() - 1));
                e.this.l.remove();
                synchronized (e.this.q) {
                    for (CanvasAction canvasAction : e.this.i) {
                        e.this.b.drawPath(canvasAction.path, canvasAction.paint);
                    }
                }
            }
            e.this.o.post(e.this.r);
            Log.d(e.t, "after undo");
        }
    }

    public e(Context context, int i, int i2) {
        super(context);
        this.c = new i();
        this.d = new Paint();
        this.g = null;
        this.h = 0;
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.l = new CanvasInfo();
        this.o = new Handler(Looper.getMainLooper());
        this.p = false;
        this.q = new Object();
        this.r = new a();
        this.s = new b();
        this.k = com.aliyun.common.utils.p.a(context) + File.separator + "paint.png";
        this.e = i;
        this.f = i2;
        setLayerType(1, null);
        e();
    }

    private void a(float f, float f2) {
        if (this.h != 0) {
            return;
        }
        this.d = this.c.getPaint();
        h();
        this.g = new CanvasAction(f, f2, this.d);
    }

    private void a(List<CanvasAction> list, List<CanvasAction> list2) {
        list2.clear();
        Iterator<CanvasAction> it = list.iterator();
        while (it.hasNext()) {
            list2.add(it.next());
        }
    }

    private void e() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
        this.f25738a = bitmapCreateBitmap;
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(this.f25738a);
        this.b = canvas;
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        this.b.drawColor(0);
    }

    public void a(CanvasInfo canvasInfo) {
        if (canvasInfo == null) {
            return;
        }
        this.l.resore(canvasInfo);
        a(canvasInfo.transfer());
    }

    public void a(List<CanvasAction> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        a(list, this.i);
        a(this.i, this.j);
        this.f25738a.eraseColor(0);
        List<CanvasAction> list2 = this.i;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (CanvasAction canvasAction : this.i) {
            this.b.drawPath(canvasAction.path, canvasAction.paint);
        }
        invalidate();
    }

    public void b() {
        this.f25738a.eraseColor(0);
        List<CanvasAction> list = this.j;
        if (list != null && list.size() > 0) {
            for (CanvasAction canvasAction : this.j) {
                this.b.drawPath(canvasAction.path, canvasAction.paint);
            }
        }
        a(this.j, this.i);
    }

    public void c() {
        this.f25738a.eraseColor(0);
        this.b.setBitmap(this.f25738a);
        this.i.clear();
        this.l.clean();
        invalidate();
    }

    public void d() {
        a(this.i, this.j);
    }

    public void f() {
        Bitmap bitmap = this.f25738a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f25738a.recycle();
        }
        this.f25738a = null;
        this.b = null;
    }

    public void g() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.k));
            this.f25738a.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception unused) {
            Log.d("AliYunLog", "save paint file failed");
        }
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public Bitmap generateBitmap(int i, int i2) {
        return null;
    }

    public int getCanvasHeight() {
        return this.f;
    }

    public CanvasInfo getCanvasInfo() {
        return this.l;
    }

    public int getCanvasWidth() {
        return this.e;
    }

    public String getPath() {
        return this.k;
    }

    public void h() {
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.SOLID);
        Paint paint = this.d;
        if (paint != null) {
            paint.setMaskFilter(blurMaskFilter);
        }
    }

    public void i() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.n.post(this.s);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = new HandlerThread("undo");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new Handler(this.m.getLooper());
        this.p = false;
        a(this.j);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.removeCallbacks(this.s);
        this.o.removeCallbacks(this.r);
        this.m.quit();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        synchronized (this.q) {
            canvas.drawBitmap(this.f25738a, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055  */
    /* JADX WARN: Code duplicated, block: B:26:0x0063  */
    /* JADX WARN: Code duplicated, block: B:29:0x006c  */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != 6) goto L31;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CanvasAction canvasAction;
        CanvasInfo canvasInfo;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked() | motionEvent.getAction();
        if (actionMasked == 0) {
            Log.d(t, "Paint action down");
            a(x, y);
            canvasAction = this.g;
            if (canvasAction != null) {
                canvasAction.point(x, y, this.b);
            }
            canvasInfo = this.l;
            if (canvasInfo != null) {
                canvasInfo.lineStart(x, y);
            }
            invalidate();
        } else if (actionMasked == 1) {
            Log.d(t, "Paint action up");
            CanvasAction canvasAction2 = this.g;
            if (canvasAction2 != null) {
                this.i.add(canvasAction2);
                this.g = null;
            }
            CanvasInfo canvasInfo2 = this.l;
            if (canvasInfo2 != null) {
                canvasInfo2.lineEnd(x, y, this.d);
            }
            invalidate();
        } else if (actionMasked == 2) {
            Log.d(t, "Paint action move");
            CanvasAction canvasAction3 = this.g;
            if (canvasAction3 != null) {
                canvasAction3.move(x, y, this.b);
            }
            CanvasInfo canvasInfo3 = this.l;
            if (canvasInfo3 != null) {
                canvasInfo3.lineMove(x, y);
            }
            invalidate();
        } else if (actionMasked == 5) {
            Log.d(t, "Paint action down");
            a(x, y);
            canvasAction = this.g;
            if (canvasAction != null) {
                canvasAction.point(x, y, this.b);
            }
            canvasInfo = this.l;
            if (canvasInfo != null) {
                canvasInfo.lineStart(x, y);
            }
            invalidate();
        }
        return true;
    }

    public void setAliyunPaint(AliyunIPaint aliyunIPaint) {
        this.c = aliyunIPaint;
    }

    public void setPath(String str) {
        this.k = str;
    }
}
