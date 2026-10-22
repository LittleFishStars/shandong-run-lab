package com.fl.saas.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RoundedFrameLayout extends FrameLayout {
    private int borderColor;
    private final Paint borderPaint;
    private float borderWidth;
    private final Path path;
    private float[] radii;
    private final RectF rectF;

    public RoundedFrameLayout(@NonNull Context context) {
        super(context);
        this.path = new Path();
        this.borderPaint = new Paint(1);
        this.rectF = new RectF();
        this.radii = new float[8];
        this.borderColor = 0;
        this.borderWidth = 0.0f;
        init(context, null);
    }

    public RoundedFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.path = new Path();
        this.borderPaint = new Paint(1);
        this.rectF = new RectF();
        this.radii = new float[8];
        this.borderColor = 0;
        this.borderWidth = 0.0f;
        init(context, attributeSet);
    }

    public RoundedFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.path = new Path();
        this.borderPaint = new Paint(1);
        this.rectF = new RectF();
        this.radii = new float[8];
        this.borderColor = 0;
        this.borderWidth = 0.0f;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedFrameLayout);
        float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_yd_radius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_yd_topLeftRadius, dimension);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_yd_topRightRadius, dimension);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_yd_bottomRightRadius, dimension);
        float dimension5 = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_yd_bottomLeftRadius, dimension);
        this.borderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundedFrameLayout_yd_borderColor, 0);
        this.borderWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundedFrameLayout_yd_borderWidth, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        setRadii(dimension2, dimension3, dimension4, dimension5);
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setColor(this.borderColor);
        this.borderPaint.setStrokeWidth(this.borderWidth);
    }

    private void setRadii(float f, float f2, float f3, float f4) {
        float[] fArr = this.radii;
        fArr[1] = f;
        fArr[0] = f;
        fArr[3] = f2;
        fArr[2] = f2;
        fArr[5] = f3;
        fArr[4] = f3;
        fArr[7] = f4;
        fArr[6] = f4;
        updatePath();
    }

    private void updatePath() {
        this.path.reset();
        this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.borderWidth;
        if (f > 0.0f) {
            float f2 = f / 2.0f;
            RectF rectF = new RectF(f2, f2, getWidth() - f2, getHeight() - f2);
            Path path = new Path();
            path.addRoundRect(rectF, this.radii, Path.Direction.CW);
            canvas.drawPath(path, this.borderPaint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.rectF.set(0.0f, 0.0f, i, i2);
        updatePath();
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        this.borderPaint.setColor(i);
        invalidate();
    }

    public void setBorderWidth(float f) {
        this.borderWidth = f;
        this.borderPaint.setStrokeWidth(f);
        invalidate();
    }

    public void setBottomLeftRadius(float f) {
        float[] fArr = this.radii;
        fArr[6] = f;
        fArr[7] = f;
        updatePath();
    }

    public void setBottomRightRadius(float f) {
        float[] fArr = this.radii;
        fArr[4] = f;
        fArr[5] = f;
        updatePath();
    }

    public void setTopLeftRadius(float f) {
        float[] fArr = this.radii;
        fArr[0] = f;
        fArr[1] = f;
        updatePath();
    }

    public void setTopRightRadius(float f) {
        float[] fArr = this.radii;
        fArr[2] = f;
        fArr[3] = f;
        updatePath();
    }
}
