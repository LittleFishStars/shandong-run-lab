package com.alibaba.triver.embed.video.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f24905a = 24.0f;
    private static final float b = 14.0f;
    private static final int c = -13388315;
    private static final int d = -13388315;
    private final float e;
    private Bitmap f;
    private Bitmap g;
    private final float h;
    private final float i;
    private final float j;
    private final float k;
    private boolean l = false;
    private final float m;
    private float n;
    private Paint o;
    private Paint p;
    private float q;
    private boolean r;
    private int s;
    private int t;

    public f(Context context, float f, int i, int i2, float f2, int i3, int i4) {
        Resources resources = context.getResources();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i3);
        this.f = a(bitmapDecodeResource, bitmapDecodeResource.getWidth() / 2, bitmapDecodeResource.getHeight());
        this.g = a(bitmapDecodeResource, bitmapDecodeResource.getWidth() / 2, bitmapDecodeResource.getHeight());
        if (f2 == -1.0f && i == -1 && i2 == -1) {
            this.r = true;
        } else {
            this.r = false;
            if (f2 == -1.0f) {
                this.q = TypedValue.applyDimension(1, b, resources.getDisplayMetrics());
            } else {
                this.q = TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
            }
            if (i == -1) {
                this.s = -13388315;
            } else {
                this.s = i;
            }
            if (i2 == -1) {
                this.t = -13388315;
            } else {
                this.t = i2;
            }
            Paint paint = new Paint();
            this.o = paint;
            paint.setColor(this.s);
            this.o.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.p = paint2;
            paint2.setColor(this.t);
            this.p.setAntiAlias(true);
        }
        float width = this.f.getWidth() / 2.0f;
        this.h = width;
        this.i = this.f.getHeight() / 2.0f;
        this.j = this.g.getWidth() / 2.0f;
        this.k = this.g.getHeight() / 2.0f;
        this.e = TypedValue.applyDimension(1, (int) Math.max(24.0f, f2), resources.getDisplayMetrics());
        this.n = width;
        this.m = f;
    }

    public static float a() {
        return 24.0f;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static float b() {
        return b;
    }

    public static int c() {
        return -13388315;
    }

    public static int d() {
        return -13388315;
    }

    public float e() {
        return this.e;
    }

    public Bitmap f() {
        return this.f;
    }

    public Bitmap g() {
        return this.g;
    }

    public float h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public float j() {
        return this.j;
    }

    public float k() {
        return this.k;
    }

    public boolean l() {
        return this.l;
    }

    public float m() {
        return this.m;
    }

    public float n() {
        return this.n;
    }

    public Paint o() {
        return this.o;
    }

    public Paint p() {
        return this.p;
    }

    public float q() {
        return this.q;
    }

    public boolean r() {
        return this.r;
    }

    public int s() {
        return this.s;
    }

    public int t() {
        return this.t;
    }

    public float u() {
        return this.h;
    }

    public float v() {
        return this.i;
    }

    public float w() {
        return this.n;
    }

    public boolean x() {
        return this.l;
    }

    public void y() {
        this.l = true;
    }

    public void z() {
        this.l = false;
    }

    public void a(float f) {
        this.n = f;
    }

    public boolean a(float f, float f2) {
        return Math.abs(f - this.n) <= this.e && Math.abs(f2 - this.m) <= this.e;
    }

    public void a(Canvas canvas) {
        if (this.r) {
            boolean z = this.l;
            Bitmap bitmap = z ? this.g : this.f;
            if (z) {
                canvas.drawBitmap(bitmap, this.n - this.j, this.m - this.k, (Paint) null);
                return;
            } else {
                canvas.drawBitmap(bitmap, this.n - this.h, this.m - this.i, (Paint) null);
                return;
            }
        }
        if (this.l) {
            canvas.drawCircle(this.n, this.m, this.q, this.p);
        } else {
            canvas.drawCircle(this.n, this.m, this.q, this.o);
        }
    }
}
