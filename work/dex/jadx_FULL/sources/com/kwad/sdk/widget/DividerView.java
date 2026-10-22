package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class DividerView extends View {
    public static int ORIENTATION_HORIZONTAL = 0;
    public static int ORIENTATION_VERTICAL = 1;
    private int bsU;
    private Paint mPaint;
    private int orientation;

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ksad_DividerView, 0, 0);
        try {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashGap, 5);
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashLength, 5);
            int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashThickness, 3);
            this.bsU = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DividerView_ksad_color, -16777216);
            this.orientation = typedArrayObtainStyledAttributes.getInt(R.styleable.ksad_DividerView_ksad_orientation, ORIENTATION_HORIZONTAL);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(this.bsU);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(dimensionPixelSize3);
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.orientation == ORIENTATION_HORIZONTAL) {
            float height = getHeight() * 0.5f;
            canvas.drawLine(0.0f, height, getWidth(), height, this.mPaint);
        } else {
            float width = getWidth() * 0.5f;
            canvas.drawLine(width, 0.0f, width, getHeight(), this.mPaint);
        }
    }

    public void setDividerColor(int i) {
        this.bsU = i;
        this.mPaint.setColor(i);
        postInvalidate();
    }

    public DividerView(Context context) {
        this(context, null);
    }
}
