package com.kc.openset.view.rounded;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f40009a = new RectF();
    private final RectF b = new RectF();
    private final RectF c;
    private final Bitmap d;
    private final Paint e;
    private final int f;
    private final int g;
    private final RectF h;
    private final Paint i;
    private final Matrix j;
    private final RectF k;
    private Shader.TileMode l;
    private Shader.TileMode m;
    private boolean n;
    private float o;
    private final boolean[] p;
    private boolean q;
    private float r;
    private ColorStateList s;
    private ImageView.ScaleType t;

    /* JADX INFO: renamed from: com.kc.openset.view.rounded.a$a, reason: collision with other inner class name */
    @Keep
    public static /* synthetic */ class C1128a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f40010a;

        static {
            OSETSDKProtected.interface11(5082);
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f40010a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40010a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40010a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40010a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40010a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40010a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40010a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        OSETSDKProtected.interface11(5083);
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.c = rectF;
        this.h = new RectF();
        this.j = new Matrix();
        this.k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.l = tileMode;
        this.m = tileMode;
        this.n = true;
        this.o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.d = bitmap;
        int width = bitmap.getWidth();
        this.f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.r);
    }

    public static native Bitmap a(Drawable drawable);

    public static native a a(Bitmap bitmap);

    private native void a();

    private native void a(Canvas canvas);

    private static native boolean a(boolean[] zArr);

    public static native Drawable b(Drawable drawable);

    private native void b(Canvas canvas);

    private static native boolean b(boolean[] zArr);

    public native a a(float f);

    public native a a(float f, float f2, float f3, float f4);

    public native a a(ColorStateList colorStateList);

    public native a a(Shader.TileMode tileMode);

    public native a a(ImageView.ScaleType scaleType);

    public native a a(boolean z);

    public native a b(Shader.TileMode tileMode);

    @Override // android.graphics.drawable.Drawable
    public native void draw(Canvas canvas);

    @Override // android.graphics.drawable.Drawable
    public native int getAlpha();

    @Override // android.graphics.drawable.Drawable
    public native ColorFilter getColorFilter();

    @Override // android.graphics.drawable.Drawable
    public native int getIntrinsicHeight();

    @Override // android.graphics.drawable.Drawable
    public native int getIntrinsicWidth();

    @Override // android.graphics.drawable.Drawable
    public native int getOpacity();

    @Override // android.graphics.drawable.Drawable
    public native boolean isStateful();

    @Override // android.graphics.drawable.Drawable
    public native void onBoundsChange(Rect rect);

    @Override // android.graphics.drawable.Drawable
    public native boolean onStateChange(int[] iArr);

    @Override // android.graphics.drawable.Drawable
    public native void setAlpha(int i);

    @Override // android.graphics.drawable.Drawable
    public native void setColorFilter(ColorFilter colorFilter);

    @Override // android.graphics.drawable.Drawable
    public native void setDither(boolean z);

    @Override // android.graphics.drawable.Drawable
    public native void setFilterBitmap(boolean z);
}
