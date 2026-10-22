package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    public BarBuffer(int i, int i2, boolean z) {
        super(i);
        this.mDataSetIndex = 0;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = i2;
        this.mContainsStacks = z;
    }

    public void addBar(float f, float f2, float f3, float f4) {
        float[] fArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        fArr[i] = f;
        int i3 = i2 + 1;
        fArr[i2] = f2;
        int i4 = i3 + 1;
        fArr[i3] = f3;
        this.index = i4 + 1;
        fArr[i4] = f4;
    }

    public void setBarWidth(float f) {
        this.mBarWidth = f;
    }

    public void setDataSet(int i) {
        this.mDataSetIndex = i;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f;
        float fAbs;
        float fAbs2;
        float f2;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f3 = this.mBarWidth / 2.0f;
        for (int i = 0; i < entryCount; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f4 = x - f3;
                    float f5 = x + f3;
                    if (this.mInverted) {
                        f = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    } else {
                        float f6 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                        float f7 = y;
                        y = f6;
                        f = f7;
                    }
                    if (y > 0.0f) {
                        y *= this.phaseY;
                    } else {
                        f *= this.phaseY;
                    }
                    addBar(f4, y, f5, f);
                } else {
                    float f8 = -barEntry.getNegativeSum();
                    float f9 = 0.0f;
                    int i2 = 0;
                    while (i2 < yVals.length) {
                        float f10 = yVals[i2];
                        if (f10 == 0.0f && (f9 == 0.0f || f8 == 0.0f)) {
                            fAbs = f10;
                            fAbs2 = f8;
                            f8 = fAbs;
                        } else if (f10 >= 0.0f) {
                            fAbs = f10 + f9;
                            fAbs2 = f8;
                            f8 = f9;
                            f9 = fAbs;
                        } else {
                            fAbs = Math.abs(f10) + f8;
                            fAbs2 = Math.abs(f10) + f8;
                        }
                        float f11 = x - f3;
                        float f12 = x + f3;
                        if (this.mInverted) {
                            f2 = f8 >= fAbs ? f8 : fAbs;
                            if (f8 > fAbs) {
                                f8 = fAbs;
                            }
                        } else {
                            float f13 = f8 >= fAbs ? f8 : fAbs;
                            if (f8 > fAbs) {
                                f8 = fAbs;
                            }
                            float f14 = f8;
                            f8 = f13;
                            f2 = f14;
                        }
                        float f15 = this.phaseY;
                        addBar(f11, f8 * f15, f12, f2 * f15);
                        i2++;
                        f8 = fAbs2;
                    }
                }
            }
        }
        reset();
    }
}
