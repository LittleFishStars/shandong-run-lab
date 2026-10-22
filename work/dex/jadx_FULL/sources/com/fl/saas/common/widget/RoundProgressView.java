package com.fl.saas.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RoundProgressView extends View {
    private float mCurrentProgress;
    private float mMaxProgress;
    private int mProgressColor;
    private int mStrokeWidth;

    public RoundProgressView(Context context) {
        this(context, null);
        this.mStrokeWidth = DeviceUtil.dip2px(2.0f);
        this.mProgressColor = Color.parseColor("#CD853F");
        this.mMaxProgress = 100.0f;
        this.mCurrentProgress = 0.0f;
    }

    public RoundProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        if (this.mCurrentProgress == 0.0f) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float f3 = this.mStrokeWidth / 2.0f;
        float f4 = height;
        float f5 = f4 - f3;
        RectF rectF = new RectF(f3, f3, f5, f5);
        int i = width - height;
        float f6 = this.mStrokeWidth;
        float f7 = i - (1.5f * f6);
        float f8 = f6 / 2.0f;
        float f9 = width;
        RectF rectF2 = new RectF(f7, f8, f9 - f8, f4 - f8);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.mStrokeWidth);
        paint.setColor(this.mProgressColor);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        int i2 = (int) ((this.mCurrentProgress * 100.0f) / this.mMaxProgress);
        Path path = new Path();
        if (i2 > 18) {
            if (i2 <= 32) {
                path.moveTo(f9 / 2.0f, f4 - (this.mStrokeWidth / 2.0f));
                path.lineTo(f4 / 2.0f, f4 - (this.mStrokeWidth / 2.0f));
                path.arcTo(rectF, 90.0f, ((i2 - 18) * 180) / 14.0f);
            } else if (i2 <= 68) {
                path.moveTo(f9 / 2.0f, f4 - (this.mStrokeWidth / 2.0f));
                float f10 = f4 / 2.0f;
                path.lineTo(f10, f4 - (this.mStrokeWidth / 2.0f));
                path.arcTo(rectF, 90.0f, 180.0f);
                path.lineTo(f10 + ((i * (i2 - 32)) / 36.0f), this.mStrokeWidth / 2.0f);
            } else if (i2 <= 82) {
                path.moveTo(f9 / 2.0f, f4 - (this.mStrokeWidth / 2.0f));
                float f11 = f4 / 2.0f;
                path.lineTo(f11, f4 - (this.mStrokeWidth / 2.0f));
                path.arcTo(rectF, 90.0f, 180.0f);
                path.lineTo(f9 - f11, this.mStrokeWidth / 2.0f);
                path.arcTo(rectF2, -90.0f, ((i2 - 68) * 180) / 14.0f);
            } else {
                path.moveTo(f9 / 2.0f, f4 - (this.mStrokeWidth / 2.0f));
                float f12 = f4 / 2.0f;
                path.lineTo(f12, f4 - (this.mStrokeWidth / 2.0f));
                path.arcTo(rectF, 90.0f, 180.0f);
                f = f9 - f12;
                path.lineTo(f, this.mStrokeWidth / 2.0f);
                path.arcTo(rectF2, -90.0f, 180.0f);
                f2 = (i * (i2 - 82)) / 36.0f;
            }
            canvas.drawPath(path, paint);
        }
        f2 = (i * i2) / 36.0f;
        f = f9 / 2.0f;
        path.moveTo(f, f4 - (this.mStrokeWidth / 2.0f));
        path.lineTo(f - f2, f4 - (this.mStrokeWidth / 2.0f));
        canvas.drawPath(path, paint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setMaxProgress(float f) {
        this.mMaxProgress = f;
    }

    public void setProgress(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = this.mMaxProgress;
        if (f > f2) {
            f = f2;
        }
        this.mCurrentProgress = f;
        invalidate();
    }
}
