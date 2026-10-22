package com.fl.saas.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SuppressLint({"AppCompatCustomView"})
public class ShaderRoundImageView extends ImageView {
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;

    public ShaderRoundImageView(Context context) {
        super(context);
        this.mRadius = 0.0f;
        init();
    }

    public ShaderRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public ShaderRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderRoundImageView);
        this.mRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.ShaderRoundImageView_yd_radius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
    }

    private void initBitmapShader() {
        Bitmap bitmapDrawableToBitmap;
        if (this.mRadius == 0.0f || (bitmapDrawableToBitmap = drawableToBitmap(getDrawable())) == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapDrawableToBitmap, tileMode, tileMode);
        float fMax = (bitmapDrawableToBitmap.getWidth() == getWidth() && bitmapDrawableToBitmap.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapDrawableToBitmap.getWidth(), (getHeight() * 1.0f) / bitmapDrawableToBitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(matrix);
        this.mPaint.setShader(bitmapShader);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        if (drawableToBitmap(getDrawable()) == null || this.mRadius == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        initBitmapShader();
        RectF rectF = this.mRectF;
        float f = this.mRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setRadius(float f) {
        if (f < 0.0f) {
            return;
        }
        this.mRadius = f;
        invalidate();
    }
}
