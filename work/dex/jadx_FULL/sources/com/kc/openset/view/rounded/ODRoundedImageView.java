package com.kc.openset.view.rounded;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ODRoundedImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Shader.TileMode f40007a;
    private static final ImageView.ScaleType[] b;
    static final boolean c;
    private final float[] d;
    private Drawable e;
    private ColorStateList f;
    private float g;
    private ColorFilter h;
    private boolean i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private ImageView.ScaleType p;
    private Shader.TileMode q;
    private Shader.TileMode r;

    @Keep
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f40008a;

        static {
            OSETSDKProtected.interface11(5080);
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f40008a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40008a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40008a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40008a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40008a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40008a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40008a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        OSETSDKProtected.interface11(5081);
        c = true;
        f40007a = Shader.TileMode.CLAMP;
        b = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public ODRoundedImageView(Context context) {
        super(context);
        this.d = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f = ColorStateList.valueOf(-16777216);
        this.g = 0.0f;
        this.h = null;
        this.i = false;
        this.k = false;
        this.l = false;
        this.m = false;
        Shader.TileMode tileMode = f40007a;
        this.q = tileMode;
        this.r = tileMode;
    }

    public ODRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ODRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.d = fArr;
        this.f = ColorStateList.valueOf(-16777216);
        this.g = 0.0f;
        this.h = null;
        this.i = false;
        this.k = false;
        this.l = false;
        this.m = false;
        Shader.TileMode tileMode = f40007a;
        this.q = tileMode;
        this.r = tileMode;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSETRoundedImageView, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.OSETRoundedImageView_android_scaleType, -1);
        setScaleType(i2 >= 0 ? b[i2] : ImageView.ScaleType.FIT_CENTER);
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSETRoundedImageView_oset_riv_corner_radius, -1);
        fArr[0] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSETRoundedImageView_oset_riv_corner_radius_top_left, -1);
        fArr[1] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSETRoundedImageView_oset_riv_corner_radius_top_right, -1);
        fArr[2] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSETRoundedImageView_oset_riv_corner_radius_bottom_right, -1);
        fArr[3] = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSETRoundedImageView_oset_riv_corner_radius_bottom_left, -1);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            float[] fArr2 = this.d;
            if (fArr2[i3] < 0.0f) {
                fArr2[i3] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length = this.d.length;
            for (int i4 = 0; i4 < length; i4++) {
                this.d[i4] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSETRoundedImageView_oset_riv_border_width, -1);
        this.g = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.g = 0.0f;
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.OSETRoundedImageView_oset_riv_border_color);
        this.f = colorStateList;
        if (colorStateList == null) {
            this.f = ColorStateList.valueOf(-16777216);
        }
        this.m = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSETRoundedImageView_oset_riv_mutate_background, false);
        this.l = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSETRoundedImageView_oset_riv_oval, false);
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.OSETRoundedImageView_oset_riv_tile_mode, -2);
        if (i5 != -2) {
            setTileModeX(a(i5));
            setTileModeY(a(i5));
        }
        int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.OSETRoundedImageView_oset_riv_tile_mode_x, -2);
        if (i6 != -2) {
            setTileModeX(a(i6));
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.OSETRoundedImageView_oset_riv_tile_mode_y, -2);
        if (i7 != -2) {
            setTileModeY(a(i7));
        }
        d();
        a(true);
        if (this.m) {
            super.setBackgroundDrawable(this.e);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private static native Shader.TileMode a(int i);

    private native void a();

    private native void a(Drawable drawable, ImageView.ScaleType scaleType);

    private native void a(boolean z);

    private native Drawable b();

    private native Drawable c();

    private native void d();

    public native void a(float f, float f2, float f3, float f4);

    @Override // android.widget.ImageView, android.view.View
    public native void drawableStateChanged();

    public native int getBorderColor();

    public native ColorStateList getBorderColors();

    public native float getBorderWidth();

    public native float getCornerRadius();

    public native float getMaxCornerRadius();

    @Override // android.widget.ImageView
    public native ImageView.ScaleType getScaleType();

    public native Shader.TileMode getTileModeX();

    public native Shader.TileMode getTileModeY();

    @Override // android.view.View
    public native void setBackground(Drawable drawable);

    @Override // android.view.View
    public native void setBackgroundColor(int i);

    @Override // android.view.View
    @Deprecated
    public native void setBackgroundDrawable(Drawable drawable);

    @Override // android.view.View
    public native void setBackgroundResource(int i);

    public native void setBorderColor(int i);

    public native void setBorderColor(ColorStateList colorStateList);

    public native void setBorderWidth(float f);

    public native void setBorderWidth(int i);

    @Override // android.widget.ImageView
    public native void setColorFilter(ColorFilter colorFilter);

    public native void setCornerRadius(float f);

    public native void setCornerRadiusDimen(int i);

    @Override // android.widget.ImageView
    public native void setImageBitmap(Bitmap bitmap);

    @Override // android.widget.ImageView
    public native void setImageDrawable(Drawable drawable);

    @Override // android.widget.ImageView
    public native void setImageResource(int i);

    @Override // android.widget.ImageView
    public native void setImageURI(Uri uri);

    public native void setOval(boolean z);

    @Override // android.widget.ImageView
    public native void setScaleType(ImageView.ScaleType scaleType);

    public native void setTileModeX(Shader.TileMode tileMode);

    public native void setTileModeY(Shader.TileMode tileMode);
}
