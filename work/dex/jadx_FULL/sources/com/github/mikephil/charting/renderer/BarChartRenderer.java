package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    private RectF mBarShadowRectBuffer;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.mBarShadowRectBuffer = new RectF();
        this.mChart = barDataProvider;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.mShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.mBarBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int iMin = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < iMin; i2++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i2)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = iBarDataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i3 = 0; i3 < barBuffer.size(); i3 += 4) {
            int i4 = i3 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i4])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i3])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    float f = fArr[i3];
                    paint.setShader(new LinearGradient(f, fArr[i3 + 3], f, fArr[i3 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f2 = fArr2[i3];
                    float f3 = fArr2[i3 + 3];
                    float f4 = fArr2[i3 + 1];
                    int i5 = i3 / 4;
                    paint2.setShader(new LinearGradient(f2, f3, f2, f4, iBarDataSet.getGradientColor(i5).getStartColor(), iBarDataSet.getGradientColor(i5).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i6 = i3 + 1;
                int i7 = i3 + 3;
                canvas.drawRect(fArr3[i3], fArr3[i6], fArr3[i4], fArr3[i7], this.mRenderPaint);
                if (z) {
                    float[] fArr4 = barBuffer.buffer;
                    canvas.drawRect(fArr4[i3], fArr4[i6], fArr4[i4], fArr4[i7], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y;
        float f;
        float f2;
        float f3;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.mChart.isHighlightFullBarEnabled()) {
                            y = barEntry.getPositiveSum();
                            f = -barEntry.getNegativeSum();
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            f3 = range.from;
                            f2 = range.to;
                        }
                        prepareBarHighlight(barEntry.getX(), f3, f2, barData.getBarWidth() / 2.0f, transformer);
                        setHighlightDrawPos(highlight, this.mBarRect);
                        canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                    } else {
                        y = barEntry.getY();
                        f = 0.0f;
                    }
                    f2 = f;
                    f3 = y;
                    prepareBarHighlight(barEntry.getX(), f3, f2, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        float[] fArr;
        BarEntry barEntry;
        float f;
        float f2;
        float f3;
        float f4;
        boolean z;
        float f5;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean zIsDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i = 0;
            while (i < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean zIsInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, PrepareException.ERROR_AUTH_FAIL);
                    float f6 = zIsDrawValueAboveBarEnabled ? -fConvertDpToPixel : fCalcTextHeight + fConvertDpToPixel;
                    float f7 = zIsDrawValueAboveBarEnabled ? fCalcTextHeight + fConvertDpToPixel : -fConvertDpToPixel;
                    if (zIsInverted) {
                        f6 = (-f6) - fCalcTextHeight;
                        f7 = (-f7) - fCalcTextHeight;
                    }
                    float f8 = f6;
                    float f9 = f7;
                    BarBuffer barBuffer = this.mBarBuffers[i];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF2 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF2.x = Utils.convertDpToPixel(mPPointF2.x);
                    mPPointF2.y = Utils.convertDpToPixel(mPPointF2.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        mPPointF = mPPointF2;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i2 = 0;
                        int length = 0;
                        while (i2 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i2);
                            float[] yVals = barEntry2.getYVals();
                            float[] fArr2 = barBuffer.buffer;
                            float f10 = (fArr2[length] + fArr2[length + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i2);
                            if (yVals != null) {
                                BarEntry barEntry3 = barEntry2;
                                i2 = i2;
                                fConvertDpToPixel = fConvertDpToPixel;
                                zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer;
                                float f11 = f10;
                                int length2 = fArr.length * 2;
                                float[] fArr3 = new float[length2];
                                float f12 = -barEntry3.getNegativeSum();
                                float f13 = 0.0f;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length2) {
                                    float f14 = fArr[i4];
                                    if (f14 == 0.0f && (f13 == 0.0f || f12 == 0.0f)) {
                                        float f15 = f12;
                                        f12 = f14;
                                        f2 = f15;
                                    } else if (f14 >= 0.0f) {
                                        f13 += f14;
                                        f2 = f12;
                                        f12 = f13;
                                    } else {
                                        f2 = f12 - f14;
                                    }
                                    fArr3[i3 + 1] = f12 * phaseY;
                                    i3 += 2;
                                    i4++;
                                    f12 = f2;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i5 = 0;
                                while (i5 < length2) {
                                    float f16 = fArr[i5 / 2];
                                    float f17 = fArr3[i5 + 1] + (((f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) == 0 && (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1)) == 0 && (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1)) > 0) || (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) < 0 ? f9 : f8);
                                    int i6 = i5;
                                    if (!this.mViewPortHandler.isInBoundsRight(f11)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f17) && this.mViewPortHandler.isInBoundsLeft(f11)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry4 = barEntry3;
                                            f = f17;
                                            barEntry = barEntry4;
                                            drawValue(canvas, valueFormatter.getBarStackedLabel(f16, barEntry4), f11, f, valueTextColor);
                                        } else {
                                            f = f17;
                                            barEntry = barEntry3;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon = barEntry.getIcon();
                                            Utils.drawImage(canvas, icon, (int) (f11 + mPPointF.x), (int) (f + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                        }
                                    } else {
                                        length2 = length2;
                                        f11 = f11;
                                        i6 = i6;
                                        barEntry = barEntry3;
                                        fArr3 = fArr3;
                                    }
                                    i5 = i6 + 2;
                                    fArr3 = fArr3;
                                    barEntry3 = barEntry;
                                    length2 = length2;
                                    f11 = f11;
                                }
                            } else {
                                if (!this.mViewPortHandler.isInBoundsRight(f10)) {
                                    break;
                                }
                                fArr = yVals;
                                int i7 = length + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i7]) && this.mViewPortHandler.isInBoundsLeft(f10)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f3 = f10;
                                        drawValue(canvas, valueFormatter.getBarLabel(barEntry2), f3, barBuffer.buffer[i7] + (barEntry2.getY() >= 0.0f ? f8 : f9), valueTextColor);
                                    } else {
                                        f3 = f10;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        Utils.drawImage(canvas, icon2, (int) (mPPointF.x + f3), (int) (barBuffer.buffer[i7] + (barEntry2.getY() >= 0.0f ? f8 : f9) + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer = transformer;
                                    zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
                                    fConvertDpToPixel = fConvertDpToPixel;
                                    i2 = i2;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i2++;
                            transformer = transformer;
                            zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
                            fConvertDpToPixel = fConvertDpToPixel;
                        }
                    } else {
                        int i8 = 0;
                        while (i8 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr4 = barBuffer.buffer;
                            float f18 = (fArr4[i8] + fArr4[i8 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f18)) {
                                break;
                            }
                            int i9 = i8 + 1;
                            if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i9]) && this.mViewPortHandler.isInBoundsLeft(f18)) {
                                int i10 = i8 / 4;
                                BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i10);
                                float y = barEntry5.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter.getBarLabel(barEntry5);
                                    float[] fArr5 = barBuffer.buffer;
                                    f5 = f18;
                                    drawValue(canvas, barLabel, f5, y >= 0.0f ? fArr5[i9] + f8 : fArr5[i8 + 3] + f9, iBarDataSet.getValueTextColor(i10));
                                } else {
                                    f5 = f18;
                                }
                                if (barEntry5.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry5.getIcon();
                                    Utils.drawImage(canvas, icon3, (int) (f5 + mPPointF2.x), (int) ((y >= 0.0f ? barBuffer.buffer[i9] + f8 : barBuffer.buffer[i8 + 3] + f9) + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i8 = i8;
                                valueFormatter = valueFormatter;
                                dataSets = dataSets;
                                mPPointF2 = mPPointF2;
                            }
                            i8 += 4;
                            mPPointF2 = mPPointF2;
                            valueFormatter = valueFormatter;
                            dataSets = dataSets;
                        }
                        list = dataSets;
                        mPPointF = mPPointF2;
                    }
                    f4 = fConvertDpToPixel;
                    z = zIsDrawValueAboveBarEnabled;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f4 = fConvertDpToPixel;
                    z = zIsDrawValueAboveBarEnabled;
                }
                i++;
                zIsDrawValueAboveBarEnabled = z;
                dataSets = list;
                fConvertDpToPixel = f4;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    public void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f - f4, f2, f + f4, f3);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
