package com.kwad.components.core.innerEc.live.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LiveGradientBackgroundView extends View {
    private static final float[] ZN = {0.0f, 1.0f};
    private Path ZO;
    private LinearGradient ZP;
    private int[] ZQ;
    private float[] ZR;
    private Paint ZS;
    private float ZU;
    private LinearGradient ZV;
    private int[] ZW;
    private float[] ZX;
    private float ZY;
    private com.kwad.sdk.g.b<RectF, RectF> ZZ;
    private Paint mPaint;

    public LiveGradientBackgroundView(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPaint = new Paint();
        this.ZS = new Paint();
        this.mPaint.setAntiAlias(true);
        this.ZS.setAntiAlias(true);
        this.ZQ = new int[]{1716650237, 859570429};
        this.ZR = ZN;
    }

    private void te() {
        this.ZO = null;
        postInvalidateDelayed(20L);
    }

    private void tf() {
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (height - getPaddingTop()) - getPaddingBottom();
        if (this.ZO == null) {
            RectF rectF = new RectF(0.0f, 0.0f, paddingLeft + 0, paddingTop + 0);
            Path path = new Path();
            this.ZO = path;
            float f = this.ZY;
            path.addRoundRect(rectF, f, f, Path.Direction.CCW);
            RectF rectFApply = this.ZZ.apply(rectF);
            this.ZP = new LinearGradient(rectFApply.left, rectFApply.top, rectFApply.right, rectFApply.bottom, this.ZQ, this.ZR, Shader.TileMode.CLAMP);
            if (this.ZW == null || this.ZX == null) {
                this.ZV = null;
            } else {
                this.ZV = new LinearGradient(rectFApply.left, rectFApply.top, rectFApply.right, rectFApply.bottom, this.ZW, this.ZX, Shader.TileMode.CLAMP);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ZO == null) {
            tf();
        }
        canvas.save();
        this.mPaint.setShader(this.ZP);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.clipPath(this.ZO);
        canvas.drawPath(this.ZO, this.mPaint);
        LinearGradient linearGradient = this.ZV;
        if (linearGradient != null) {
            this.ZS.setShader(linearGradient);
            this.ZS.setStyle(Paint.Style.STROKE);
            this.ZS.setStrokeWidth(this.ZU);
            canvas.drawPath(this.ZO, this.ZS);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        te();
    }

    public void setBackgroundCornerRadius(float f) {
        this.ZY = f;
        te();
    }

    public void setBorderWidth(float f) {
        this.ZU = f;
        te();
    }

    public void setGradientRectFMapper(com.kwad.sdk.g.b<RectF, RectF> bVar) {
        this.ZZ = bVar;
        te();
    }

    public LiveGradientBackgroundView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveGradientBackgroundView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZU = com.kwad.sdk.c.a.a.a(getContext(), 1.0f) + 0.0f;
        this.ZY = 100.0f;
        this.ZZ = new com.kwad.sdk.g.b<RectF, RectF>() { // from class: com.kwad.components.core.innerEc.live.widget.LiveGradientBackgroundView.1
            private static RectF a(RectF rectF) {
                return rectF;
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ RectF apply(RectF rectF) {
                return a(rectF);
            }
        };
        init();
    }
}
