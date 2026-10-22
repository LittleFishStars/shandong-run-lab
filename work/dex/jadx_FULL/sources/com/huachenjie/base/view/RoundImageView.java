package com.huachenjie.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class RoundImageView extends AppCompatImageView {
    public static final int V = 2;
    public static final int W = 0;
    public static final int X = 0;
    public static final int Y = -16777216;
    public static final int Z = 0;
    public static final boolean j = false;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f7279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BitmapShader f7280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f7281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f7282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f7284a;
    public final Paint d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f7285d;
    public final RectF e;
    public final RectF f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f7286f;
    public final Paint g;
    public final Paint h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ImageView.ScaleType f7278a = ImageView.ScaleType.CENTER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f32972a = Bitmap.Config.ARGB_8888;

    public RoundImageView(Context context) {
        super(context);
        this.e = new RectF();
        this.f = new RectF();
        this.f7282a = new Matrix();
        this.d = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.K = -16777216;
        this.L = 0;
        this.M = 0;
        this.f7284a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        init();
    }

    private void setBottomLeftRadius(int roundRadius) {
        float[] fArr = this.f7284a;
        float f = roundRadius;
        fArr[6] = f;
        fArr[7] = f;
    }

    private void setBottomRightRadius(int roundRadius) {
        float[] fArr = this.f7284a;
        float f = roundRadius;
        fArr[4] = f;
        fArr[5] = f;
    }

    private void setTopLeftRadius(int roundRadius) {
        float[] fArr = this.f7284a;
        float f = roundRadius;
        fArr[0] = f;
        fArr[1] = f;
    }

    private void setTopRightRadius(int roundRadius) {
        float[] fArr = this.f7284a;
        float f = roundRadius;
        fArr[2] = f;
        fArr[3] = f;
    }

    public final Bitmap d(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f32972a) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f32972a);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void e(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        setTopLeftRadius(topLeft);
        setTopRightRadius(topRight);
        setBottomLeftRadius(bottomLeft);
        setBottomRightRadius(bottomRight);
    }

    public int getBorderColor() {
        return this.K;
    }

    public int getBorderWidth() {
        return this.L;
    }

    public int getFillColor() {
        return this.M;
    }

    public int getRadius() {
        return this.P;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f7278a;
    }

    public final void init() {
        super.setScaleType(f7278a);
        this.f7285d = true;
        if (this.f7286f) {
            o();
            this.f7286f = false;
        }
    }

    public boolean isBorderOverlay() {
        return this.f7283a;
    }

    public final void o() {
        if (!this.f7285d) {
            this.f7286f = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.f7279a == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.f7279a;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f7280a = new BitmapShader(bitmap, tileMode, tileMode);
        this.d.setAntiAlias(true);
        this.d.setShader(this.f7280a);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setAntiAlias(true);
        this.g.setColor(this.K);
        this.g.setStrokeWidth(this.L);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setStrokeJoin(Paint.Join.ROUND);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
        this.h.setColor(this.M);
        this.O = this.f7279a.getHeight();
        this.N = this.f7279a.getWidth();
        this.f.set(0.0f, 0.0f, getWidth(), getHeight());
        this.e.set(this.f);
        if (!this.f7283a) {
            RectF rectF = this.e;
            int i = this.L;
            rectF.inset(i, i);
        }
        p();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f7279a == null) {
            return;
        }
        int i = this.L;
        RectF rectF = new RectF(i / 2.0f, i / 2.0f, getWidth() - (this.L / 2.0f), getHeight() - (this.L / 2.0f));
        if (q()) {
            if (this.M != 0) {
                canvas.drawRect(rectF, this.h);
            }
            Path path = new Path();
            path.addRoundRect(rectF, this.f7284a, Path.Direction.CW);
            canvas.drawPath(path, this.d);
            if (this.L != 0) {
                canvas.drawPath(path, this.g);
                return;
            }
            return;
        }
        if (this.M != 0) {
            int i2 = this.P;
            canvas.drawRoundRect(rectF, i2, i2, this.h);
        }
        int i3 = this.P;
        canvas.drawRoundRect(rectF, i3, i3, this.d);
        if (this.L != 0) {
            int i4 = this.P;
            canvas.drawRoundRect(rectF, i4, i4, this.g);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        o();
    }

    public final void p() {
        float fWidth;
        float fHeight;
        this.f7282a.set(null);
        float fWidth2 = 0.0f;
        if (this.N * this.e.height() > this.e.width() * this.O) {
            fWidth = this.e.height() / this.O;
            fHeight = 0.0f;
            fWidth2 = (this.e.width() - (this.N * fWidth)) * 0.5f;
        } else {
            fWidth = this.e.width() / this.N;
            fHeight = (this.e.height() - (this.O * fWidth)) * 0.5f;
        }
        this.f7282a.setScale(fWidth, fWidth);
        Matrix matrix = this.f7282a;
        RectF rectF = this.e;
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF.left, ((int) (fHeight + 0.5f)) + rectF.top);
        this.f7280a.setLocalMatrix(this.f7282a);
    }

    public final boolean q() {
        int i = 0;
        boolean z = false;
        while (true) {
            float[] fArr = this.f7284a;
            if (i >= fArr.length) {
                return z;
            }
            float f = fArr[i];
            if (f > 0.0f) {
                z = true;
            }
            if (f < 0.0f) {
                fArr[i] = 0.0f;
            }
            i++;
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        if (adjustViewBounds) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int borderColor) {
        if (borderColor == this.K) {
            return;
        }
        this.K = borderColor;
        this.g.setColor(borderColor);
        invalidate();
    }

    public void setBorderColorResource(@ColorRes int borderColorRes) {
        setBorderColor(getContext().getResources().getColor(borderColorRes));
    }

    public void setBorderOverlay(boolean borderOverlay) {
        if (borderOverlay == this.f7283a) {
            return;
        }
        this.f7283a = borderOverlay;
        o();
    }

    public void setBorderWidth(int borderWidth) {
        if (borderWidth == this.L) {
            return;
        }
        this.L = borderWidth;
        o();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter cf) {
        if (cf == this.f7281a) {
            return;
        }
        this.f7281a = cf;
        this.d.setColorFilter(cf);
        invalidate();
    }

    public void setFillColor(@ColorInt int fillColor) {
        if (fillColor == this.M) {
            return;
        }
        this.M = fillColor;
        this.h.setColor(fillColor);
        invalidate();
    }

    public void setFillColorResource(@ColorRes int fillColorRes) {
        setFillColor(getContext().getResources().getColor(fillColorRes));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.f7279a = bm;
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f7279a = d(drawable);
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        this.f7279a = d(getDrawable());
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f7279a = uri != null ? d(getDrawable()) : null;
        o();
    }

    public void setRadius(int mCornerRadius) {
        this.P = mCornerRadius;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(f7278a);
    }

    public void setRadius(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        this.Q = topLeft;
        this.R = topRight;
        this.S = bottomLeft;
        this.T = bottomRight;
        e(topLeft, topRight, bottomLeft, bottomRight);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.e = new RectF();
        this.f = new RectF();
        this.f7282a = new Matrix();
        this.d = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.K = -16777216;
        this.L = 0;
        this.M = 0;
        this.f7284a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView, defStyle, 0);
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_border_width, 0);
        this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundImageView_riv_border_color, -16777216);
        this.f7283a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.RoundImageView_riv_border_overlay, false);
        this.M = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundImageView_riv_fill_color, 0);
        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_corner_radius, 0);
        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_corner_topLeftRadius, 0);
        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_corner_topRightRadius, 0);
        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_corner_bottomLeftRadius, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_riv_corner_bottomRightRadius, 0);
        this.T = dimensionPixelSize;
        e(this.Q, this.R, this.S, dimensionPixelSize);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }
}
