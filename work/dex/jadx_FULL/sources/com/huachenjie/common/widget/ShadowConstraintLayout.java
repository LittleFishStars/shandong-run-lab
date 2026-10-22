package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huachenjie.common.R;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ShadowConstraintLayout extends ConstraintLayout {
    private static final int DEFAULT_CORNER_RADIUS = 8;
    private static final String DEFAULT_SHADOW_COLOR = "#160A0A9F";
    private static final int DEFAULT_SHADOW_RADIUS = 8;
    private int mBgColor;
    private float mCornerRadius;
    private float mCornerRadiusLB;
    private float mCornerRadiusLT;
    private float mCornerRadiusRB;
    private float mCornerRadiusRT;
    private float mDBottom;
    private float mDLeft;
    private float mDRight;
    private float mDTop;
    private boolean mDrawBottom;
    private boolean mDrawLeft;
    private boolean mDrawRight;
    private boolean mDrawTop;
    private boolean mInvalidateShadowOnSizeChanged;
    private boolean mIsCircle;
    private int mShadowColor;
    private float mShadowRadius;
    float[] radii;

    public ShadowConstraintLayout(Context context) {
        super(context);
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mInvalidateShadowOnSizeChanged = true;
        this.mIsCircle = true;
        this.mDrawLeft = true;
        this.mDrawRight = true;
        this.mDrawTop = true;
        this.mDrawBottom = true;
        initView(context, null);
    }

    private Bitmap createShadowBitmap(int shadowWidth, int shadowHeight, float cornerRadius, float shadowRadius, float dLeft, float dTop, float dRight, float dBottom, int shadowColor, int fillColor) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(shadowWidth, shadowHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(this.mDrawLeft ? shadowRadius : 0.0f, this.mDrawTop ? shadowRadius : 0.0f, shadowWidth - (this.mDrawRight ? shadowRadius : 0.0f), shadowHeight - (this.mDrawBottom ? shadowRadius : 0.0f));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(fillColor);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(shadowRadius, 0.0f, jj8.a(1.0f), shadowColor);
        }
        new Paint().setColor(fillColor);
        if (this.mIsCircle) {
            Path path = new Path();
            path.addRoundRect(rectF, this.radii, Path.Direction.CW);
            canvas.drawPath(path, paint);
        } else {
            canvas.drawRect(rectF, paint);
        }
        return bitmapCreateBitmap;
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = getTypedArray(context, attrs, R.styleable.ShadowConstraintLayout);
        if (typedArray == null) {
            return;
        }
        try {
            this.mCornerRadius = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_cornerRadius, 0.0f);
            this.mCornerRadiusLT = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_cornerRadiusLT, 0.0f);
            this.mCornerRadiusRT = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_cornerRadiusRT, 0.0f);
            this.mCornerRadiusLB = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_cornerRadiusLB, 0.0f);
            float dimension = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_cornerRadiusRB, 0.0f);
            this.mCornerRadiusRB = dimension;
            float f = this.mCornerRadius;
            if (f > 0.0f) {
                this.radii = new float[]{f, f, f, f, f, f, f, f};
            } else {
                float f2 = this.mCornerRadiusLT;
                float f3 = this.mCornerRadiusRT;
                float f4 = this.mCornerRadiusLB;
                this.radii = new float[]{f2, f2, f3, f3, dimension, dimension, f4, f4};
            }
            this.mShadowRadius = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_shadowRadius, jj8.a(8.0f));
            this.mDLeft = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_dLeft, 0.0f);
            this.mDRight = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_dRight, 0.0f);
            this.mDTop = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_dTop, 0.0f);
            this.mDBottom = typedArray.getDimension(R.styleable.ShadowConstraintLayout_sl_dBottom, 0.0f);
            this.mShadowColor = typedArray.getColor(R.styleable.ShadowConstraintLayout_sl_shadowColor, Color.parseColor(DEFAULT_SHADOW_COLOR));
            this.mDrawLeft = typedArray.getBoolean(R.styleable.ShadowConstraintLayout_sl_drawLeft, true);
            this.mDrawRight = typedArray.getBoolean(R.styleable.ShadowConstraintLayout_sl_drawRight, true);
            this.mDrawTop = typedArray.getBoolean(R.styleable.ShadowConstraintLayout_sl_drawTop, true);
            this.mDrawBottom = typedArray.getBoolean(R.styleable.ShadowConstraintLayout_sl_drawBottom, true);
            this.mIsCircle = typedArray.getBoolean(R.styleable.ShadowConstraintLayout_sl_isCircle, true);
            this.mBgColor = typedArray.getColor(R.styleable.ShadowConstraintLayout_sl_bgColor, -1);
        } finally {
            typedArray.recycle();
        }
    }

    private void initView(Context context, AttributeSet attrs) {
        initAttributes(context, attrs);
        int iAbs = (int) (this.mShadowRadius + Math.abs(this.mDLeft));
        int iAbs2 = (int) (this.mShadowRadius + Math.abs(this.mDBottom));
        int iAbs3 = (int) (this.mShadowRadius + Math.abs(this.mDTop));
        int iAbs4 = (int) (this.mShadowRadius + Math.abs(this.mDRight));
        if (!this.mDrawLeft) {
            iAbs = 0;
        }
        if (!this.mDrawTop) {
            iAbs3 = 0;
        }
        if (!this.mDrawRight) {
            iAbs4 = 0;
        }
        if (!this.mDrawBottom) {
            iAbs2 = 0;
        }
        setPadding(iAbs, iAbs3, iAbs4, iAbs2);
    }

    private void setBackgroundCompat(int w, int h) {
        setBackground(new BitmapDrawable(getResources(), createShadowBitmap(w, h, this.mCornerRadius, this.mShadowRadius, this.mDLeft, this.mDTop, this.mDRight, this.mDBottom, this.mShadowColor, this.mBgColor)));
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return 0;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return 0;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        if (getBackground() == null || this.mInvalidateShadowOnSizeChanged) {
            setBackgroundCompat(w, h);
        }
    }

    public void setBgColor(@ColorInt int bgColor) {
        this.mBgColor = bgColor;
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        setBackgroundCompat(getWidth(), getHeight());
    }

    public void setDrawBottom(boolean mDrawBottom) {
        this.mDrawBottom = mDrawBottom;
    }

    public void setDrawLeft(boolean mDrawLeft) {
        this.mDrawLeft = mDrawLeft;
    }

    public void setDrawRight(boolean mDrawRight) {
        this.mDrawRight = mDrawRight;
    }

    public void setDrawTop(boolean mDrawTop) {
        this.mDrawTop = mDrawTop;
    }

    public void setShadowColor(int mShadowColor) {
        this.mShadowColor = mShadowColor;
    }

    public ShadowConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mInvalidateShadowOnSizeChanged = true;
        this.mIsCircle = true;
        this.mDrawLeft = true;
        this.mDrawRight = true;
        this.mDrawTop = true;
        this.mDrawBottom = true;
        initView(context, attrs);
    }

    public ShadowConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mInvalidateShadowOnSizeChanged = true;
        this.mIsCircle = true;
        this.mDrawLeft = true;
        this.mDrawRight = true;
        this.mDrawTop = true;
        this.mDrawBottom = true;
        initView(context, attrs);
    }
}
