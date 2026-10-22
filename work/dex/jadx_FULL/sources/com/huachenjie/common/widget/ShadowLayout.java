package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huachenjie.common.R;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ShadowLayout extends LinearLayout {
    private static final int DEFAULT_CORNER_RADIUS = 8;
    private static final String DEFAULT_SHADOW_COLOR = "#160A0A9F";
    private static final int DEFAULT_SHADOW_RADIUS = 8;
    private int mBgColor;
    private float mCornerRadius;
    private float mDBottom;
    private float mDLeft;
    private float mDRight;
    private float mDTop;
    private boolean mDrawBottom;
    private boolean mDrawLeft;
    private boolean mDrawRight;
    private boolean mDrawTop;
    private float mDx;
    private float mDy;
    private boolean mInvalidateShadowOnSizeChanged;
    private boolean mIsCircle;
    private int mShadowColor;
    private float mShadowRadius;

    public ShadowLayout(Context context) {
        super(context);
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
            paint.setShadowLayer(shadowRadius, this.mDx, this.mDy, shadowColor);
        }
        if (this.mIsCircle) {
            canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        } else {
            canvas.drawRect(rectF, paint);
        }
        return bitmapCreateBitmap;
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = getTypedArray(context, attrs, R.styleable.ShadowLayout);
        if (typedArray == null) {
            return;
        }
        try {
            this.mCornerRadius = typedArray.getDimension(R.styleable.ShadowLayout_sl_cornerRadius, jj8.a(8.0f));
            this.mShadowRadius = typedArray.getDimension(R.styleable.ShadowLayout_sl_shadowRadius, jj8.a(8.0f));
            this.mDx = typedArray.getDimension(R.styleable.ShadowLayout_sl_dx, 0.0f);
            this.mDy = typedArray.getDimension(R.styleable.ShadowLayout_sl_dy, jj8.a(1.0f));
            this.mDLeft = typedArray.getDimension(R.styleable.ShadowLayout_sl_dLeft, 0.0f);
            this.mDRight = typedArray.getDimension(R.styleable.ShadowLayout_sl_dRight, 0.0f);
            this.mDTop = typedArray.getDimension(R.styleable.ShadowLayout_sl_dTop, 0.0f);
            this.mDBottom = typedArray.getDimension(R.styleable.ShadowLayout_sl_dBottom, 0.0f);
            this.mShadowColor = typedArray.getColor(R.styleable.ShadowLayout_sl_shadowColor, Color.parseColor(DEFAULT_SHADOW_COLOR));
            this.mDrawLeft = typedArray.getBoolean(R.styleable.ShadowLayout_sl_drawLeft, true);
            this.mDrawRight = typedArray.getBoolean(R.styleable.ShadowLayout_sl_drawRight, true);
            this.mDrawTop = typedArray.getBoolean(R.styleable.ShadowLayout_sl_drawTop, true);
            this.mDrawBottom = typedArray.getBoolean(R.styleable.ShadowLayout_sl_drawBottom, true);
            this.mIsCircle = typedArray.getBoolean(R.styleable.ShadowLayout_sl_isCircle, true);
            this.mBgColor = typedArray.getColor(R.styleable.ShadowLayout_sl_bgColor, -1);
        } finally {
            typedArray.recycle();
        }
    }

    private void initView(Context context, AttributeSet attrs) {
        initAttributes(context, attrs);
        int iAbs = (int) (this.mShadowRadius + Math.abs(this.mDLeft) + Math.abs(this.mDx));
        int iAbs2 = (int) (this.mShadowRadius + Math.abs(this.mDBottom) + Math.abs(this.mDy));
        int iAbs3 = (int) (this.mShadowRadius + Math.abs(this.mDTop) + Math.abs(this.mDy));
        int iAbs4 = (int) (this.mShadowRadius + Math.abs(this.mDRight) + Math.abs(this.mDx));
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

    public ShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mIsCircle = true;
        this.mDrawLeft = true;
        this.mDrawRight = true;
        this.mDrawTop = true;
        this.mDrawBottom = true;
        initView(context, attrs);
    }

    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mIsCircle = true;
        this.mDrawLeft = true;
        this.mDrawRight = true;
        this.mDrawTop = true;
        this.mDrawBottom = true;
        initView(context, attrs);
    }
}
