package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
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
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
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
            int i4 = i3 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                return;
            }
            int i5 = i3 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                float[] fArr = barBuffer.buffer;
                int i6 = i3 + 2;
                canvas.drawRect(fArr[i3], fArr[i5], fArr[i6], fArr[i4], this.mRenderPaint);
                if (z) {
                    float[] fArr2 = barBuffer.buffer;
                    canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i6], fArr2[i4], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Code duplicated, block: B:153:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:154:0x03b7  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        int i;
        MPPointF mPPointF;
        float[] fArr;
        float f;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean zIsDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i2 = 0;
            while (i2 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i2);
                if (shouldDrawValues(iBarDataSet)) {
                    boolean zIsInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f2 = 2.0f;
                    float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0f;
                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer = this.mBarBuffers[i2];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF mPPointF2 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF2.x = Utils.convertDpToPixel(mPPointF2.x);
                    mPPointF2.y = Utils.convertDpToPixel(mPPointF2.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        i = i2;
                        mPPointF = mPPointF2;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i3 = 0;
                        int length = 0;
                        while (i3 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i3);
                            int valueTextColor = iBarDataSet.getValueTextColor(i3);
                            float[] yVals = barEntry.getYVals();
                            if (yVals == null) {
                                int i4 = length + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                                    break;
                                }
                                if (this.mViewPortHandler.isInBoundsX(barBuffer.buffer[length]) && this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i4])) {
                                    String barLabel = valueFormatter.getBarLabel(barEntry);
                                    float fCalcTextWidth = Utils.calcTextWidth(this.mValuePaint, barLabel);
                                    float f3 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth + fConvertDpToPixel);
                                    fArr = yVals;
                                    float f4 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth + fConvertDpToPixel) : fConvertDpToPixel;
                                    if (zIsInverted) {
                                        f3 = (-f3) - fCalcTextWidth;
                                        f4 = (-f4) - fCalcTextWidth;
                                    }
                                    float f5 = f3;
                                    float f6 = f4;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        drawValue(canvas, barLabel, barBuffer.buffer[length + 2] + (barEntry.getY() >= 0.0f ? f5 : f6), barBuffer.buffer[i4] + fCalcTextHeight, valueTextColor);
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon = barEntry.getIcon();
                                        float f7 = barBuffer.buffer[length + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f5 = f6;
                                        }
                                        Utils.drawImage(canvas, icon, (int) (f7 + f5 + mPPointF.x), (int) (barBuffer.buffer[i4] + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i3 = i3;
                                fCalcTextHeight = fCalcTextHeight;
                                fArr = yVals;
                                int length2 = fArr.length * 2;
                                float[] fArr2 = new float[length2];
                                float f8 = -barEntry.getNegativeSum();
                                float f9 = 0.0f;
                                int i5 = 0;
                                int i6 = 0;
                                while (i5 < length2) {
                                    float f10 = fArr[i6];
                                    if (f10 == 0.0f && (f9 == 0.0f || f8 == 0.0f)) {
                                        float f11 = f8;
                                        f8 = f10;
                                        f = f11;
                                    } else if (f10 >= 0.0f) {
                                        f9 += f10;
                                        f = f8;
                                        f8 = f9;
                                    } else {
                                        f = f8 - f10;
                                    }
                                    fArr2[i5] = f8 * phaseY;
                                    i5 += 2;
                                    i6++;
                                    f8 = f;
                                }
                                transformer.pointValuesToPixel(fArr2);
                                int i7 = 0;
                                while (true) {
                                    if (i7 < length2) {
                                        float f12 = fArr[i7 / 2];
                                        String barStackedLabel = valueFormatter.getBarStackedLabel(f12, barEntry);
                                        float fCalcTextWidth2 = Utils.calcTextWidth(this.mValuePaint, barStackedLabel);
                                        float f13 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth2 + fConvertDpToPixel);
                                        int i8 = length2;
                                        float f14 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth2 + fConvertDpToPixel) : fConvertDpToPixel;
                                        if (zIsInverted) {
                                            f13 = (-f13) - fCalcTextWidth2;
                                            f14 = (-f14) - fCalcTextWidth2;
                                        }
                                        boolean z = (f12 == 0.0f && f8 == 0.0f && f9 > 0.0f) || f12 < 0.0f;
                                        float f15 = fArr2[i7];
                                        if (z) {
                                            f13 = f14;
                                        }
                                        float f16 = f15 + f13;
                                        float[] fArr3 = barBuffer.buffer;
                                        float f17 = (fArr3[length + 1] + fArr3[length + 3]) / 2.0f;
                                        if (!this.mViewPortHandler.isInBoundsTop(f17)) {
                                            break;
                                        }
                                        if (this.mViewPortHandler.isInBoundsX(f16) && this.mViewPortHandler.isInBoundsBottom(f17)) {
                                            if (iBarDataSet.isDrawValuesEnabled()) {
                                                drawValue(canvas, barStackedLabel, f16, f17 + fCalcTextHeight, valueTextColor);
                                            }
                                            if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                                Drawable icon2 = barEntry.getIcon();
                                                Utils.drawImage(canvas, icon2, (int) (f16 + mPPointF.x), (int) (f17 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                            }
                                        } else {
                                            i7 = i7;
                                            fArr2 = fArr2;
                                        }
                                        i7 += 2;
                                        length2 = i8;
                                        fArr2 = fArr2;
                                    }
                                }
                                if (fArr == null) {
                                    length += 4;
                                } else {
                                    length += fArr.length * 4;
                                }
                                i3++;
                                fCalcTextHeight = fCalcTextHeight;
                            }
                            if (fArr == null) {
                                length += 4;
                            } else {
                                length += fArr.length * 4;
                            }
                            i3++;
                            fCalcTextHeight = fCalcTextHeight;
                        }
                    } else {
                        int i9 = 0;
                        while (i9 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr4 = barBuffer.buffer;
                            int i10 = i9 + 1;
                            float f18 = fArr4[i10];
                            float f19 = (fArr4[i9 + 3] + f18) / f2;
                            if (!this.mViewPortHandler.isInBoundsTop(f18)) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer.buffer[i9]) && this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i10])) {
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i9 / 4);
                                float y = barEntry2.getY();
                                String barLabel2 = valueFormatter.getBarLabel(barEntry2);
                                float fCalcTextWidth3 = Utils.calcTextWidth(this.mValuePaint, barLabel2);
                                float f20 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth3 + fConvertDpToPixel);
                                float f21 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth3 + fConvertDpToPixel) : fConvertDpToPixel;
                                if (zIsInverted) {
                                    f20 = (-f20) - fCalcTextWidth3;
                                    f21 = (-f21) - fCalcTextWidth3;
                                }
                                float f22 = f20;
                                float f23 = f21;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    drawValue(canvas, barLabel2, barBuffer.buffer[i9 + 2] + (y >= 0.0f ? f22 : f23), f19 + fCalcTextHeight, iBarDataSet.getValueTextColor(i9 / 2));
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry2.getIcon();
                                    float f24 = barBuffer.buffer[i9 + 2];
                                    if (y < 0.0f) {
                                        f22 = f23;
                                    }
                                    Utils.drawImage(canvas, icon3, (int) (f24 + f22 + mPPointF2.x), (int) (f19 + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i9 = i9;
                                barBuffer = barBuffer;
                                dataSets = dataSets;
                                i2 = i2;
                                mPPointF2 = mPPointF2;
                                valueFormatter = valueFormatter;
                            }
                            i9 += 4;
                            mPPointF2 = mPPointF2;
                            valueFormatter = valueFormatter;
                            barBuffer = barBuffer;
                            dataSets = dataSets;
                            i2 = i2;
                            f2 = 2.0f;
                        }
                        list = dataSets;
                        i = i2;
                        mPPointF = mPPointF2;
                    }
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    i = i2;
                }
                i2 = i + 1;
                dataSets = list;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f2, f - f4, f3, f + f4);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
