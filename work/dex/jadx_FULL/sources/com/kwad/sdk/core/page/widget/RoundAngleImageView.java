package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class RoundAngleImageView extends ImageView {
    private float[] aUS;
    private Path mPath;
    private RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.aUS;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.aUS;
        float f = fArr2[0] + fArr2[3];
        float f2 = fArr2[1] + fArr2[7];
        this.mPath.rewind();
        float f3 = measuredWidth;
        if (f3 >= f) {
            float f4 = measuredHeight;
            if (f4 > f2) {
                this.mRectF.set(0.0f, 0.0f, f3, f4);
                this.mPath.addRoundRect(this.mRectF, this.aUS, Path.Direction.CW);
                canvas.clipPath(this.mPath);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.aUS = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.aUS;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = f;
            i++;
        }
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public void setRadius(float[] fArr) {
        this.aUS = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.aUS;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }
}
