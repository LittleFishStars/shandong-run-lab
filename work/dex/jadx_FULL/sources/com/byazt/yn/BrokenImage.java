package com.byazt.yn;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.byazt.sa.uj;
import com.bytedance.component.sdk.annotation.Keep;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1357, 2155})
public class BrokenImage extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f29210a;
    public uj c;
    public Rect da;
    public boolean i;
    public float m;
    public int n;
    public Rect sl;
    public Point[][] sp;
    public Rect t;
    public final Paint tt;
    public int u;
    public int uj;
    public final Path ve;
    public boolean x;
    public final Random yp;
    public float z;

    public BrokenImage(Context context) {
        super(context);
        this.tt = new Paint();
        this.ve = new Path();
        this.x = false;
        this.i = true;
        this.u = 0;
        this.yp = new SecureRandom();
    }

    private void tt(int i, int i2) {
        this.ve.reset();
        Path path = this.ve;
        Point point = this.sp[i][i2];
        path.moveTo(point.x, point.y);
        Path path2 = this.ve;
        int i3 = i2 + 1;
        Point point2 = this.sp[i][i3];
        path2.lineTo(point2.x, point2.y);
        Path path3 = this.ve;
        int i4 = i + 1;
        Point point3 = this.sp[i4][i3];
        path3.lineTo(point3.x, point3.y);
        Path path4 = this.ve;
        Point point4 = this.sp[i4][i2];
        path4.lineTo(point4.x, point4.y);
        this.ve.close();
    }

    public void c(int i, int i2) {
        this.uj = i;
        this.n = i2;
        this.t = new Rect(0, 0, getWidth(), getHeight());
        int width = getWidth() / i;
        int height = getHeight() / i2;
        this.sp = (Point[][]) Array.newInstance((Class<?>) Point.class, i2 + 1, i + 1);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * width;
                int i6 = i3 * height;
                Rect rect = new Rect(i5, i6, i5 + width, i6 + height);
                if (i3 == 0 || i4 == 0) {
                    this.sp[i3][i4] = new Point(rect.left, rect.top);
                }
                if (i3 == 0 || i4 == i - 1) {
                    this.sp[i3][i4 + 1] = new Point(rect.right, rect.top);
                }
                int i7 = i2 - 1;
                if (i3 == i7 || i4 == 0) {
                    this.sp[i3 + 1][i4] = new Point(rect.left, rect.bottom);
                }
                if (i3 == i7 || i4 == i - 1) {
                    this.sp[i3 + 1][i4 + 1] = new Point(rect.right, rect.bottom);
                } else {
                    this.sp[i3 + 1][i4 + 1] = new Point((int) (rect.right + ((this.yp.nextFloat() - 0.5f) * width)), (int) (rect.bottom + ((this.yp.nextFloat() - 0.5f) * height)));
                }
            }
        }
        this.x = true;
        invalidate();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
        }
        Bitmap bitmap = this.f29210a;
        if (bitmap == null || this.t == null || bitmap.isRecycled()) {
            return;
        }
        if (this.x) {
            for (int i = 0; i < this.n; i++) {
                int i2 = 0;
                while (i2 < this.uj) {
                    canvas.save();
                    int i3 = this.u;
                    int i4 = i3 < 5 ? -i3 : i3 - 5;
                    Point[][] pointArr = this.sp;
                    int i5 = i2 + 1;
                    int i6 = i + 1;
                    int iMax = Math.max(pointArr[i][i5].x, pointArr[i6][i5].x);
                    Point[][] pointArr2 = this.sp;
                    canvas.translate((((iMax + Math.min(pointArr2[i][i2].x, pointArr2[i6][i2].x)) / 2) - this.z) * 0.01f * this.u * 0.05f, i6 * i4);
                    canvas.save();
                    tt(i, i2);
                    canvas.clipPath(this.ve);
                    canvas.drawBitmap(this.f29210a, this.sl, this.t, this.tt);
                    canvas.restore();
                    canvas.restore();
                    i2 = i5;
                }
            }
        }
        if (!this.i || this.da == null || (rect = this.sl) == null) {
            return;
        }
        canvas.drawBitmap(this.f29210a, rect, this.t, this.tt);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.t = new Rect(0, 0, i, i2);
        this.z = i / 2.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.z = motionEvent.getX();
            this.m = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f29210a = bitmap;
        this.da = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.sl = new Rect(0, 0, this.f29210a.getWidth(), this.f29210a.getHeight());
        invalidate();
    }

    @Keep
    public void setBrokenProgress(int i) {
        this.u = i;
        try {
            invalidate();
        } catch (Exception unused) {
        }
    }

    public void c(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "brokenProgress", 0, getHeight());
        objectAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfInt.setDuration(i <= 0 ? 600L : i);
        objectAnimatorOfInt.start();
        this.i = false;
    }

    public void c(uj ujVar) {
        this.c = ujVar;
    }
}
