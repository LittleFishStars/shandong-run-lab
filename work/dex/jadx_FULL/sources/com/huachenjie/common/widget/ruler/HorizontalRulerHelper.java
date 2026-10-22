package com.huachenjie.common.widget.ruler;

import androidx.camera.video.AudioStats;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class HorizontalRulerHelper {
    private double currentValue;
    private int intervalCount;
    private int mCenterPointX;
    private ScrollChangeListener scrollChangeListener;
    private int currentLine = -1;
    private double bigInterval = 5.0d;
    private double smallInterval = 1.0d;
    private int intervalCountInBig = 1;
    private List<Double> mScaleValueList = new ArrayList();
    private List<Integer> mScaleXList = new ArrayList();

    public HorizontalRulerHelper(ScrollChangeListener listener) {
        this.scrollChangeListener = listener;
    }

    public void addScale(int x) {
        int iIndexOf;
        int iIntValue;
        this.mScaleXList.add(Integer.valueOf(x));
        if (this.mScaleXList.size() != this.mScaleValueList.size() || this.scrollChangeListener == null || (iIndexOf = this.mScaleValueList.indexOf(Double.valueOf(this.currentValue))) < 0 || (iIntValue = this.mScaleXList.get(iIndexOf).intValue()) < 0) {
            return;
        }
        this.scrollChangeListener.startScroll(this.mCenterPointX - iIntValue);
    }

    public void destroy() {
        this.mScaleXList.clear();
        this.mScaleValueList.clear();
        this.mScaleXList = null;
        this.mScaleValueList = null;
        this.scrollChangeListener = null;
    }

    public int getCenterPointX() {
        return this.mCenterPointX;
    }

    public double getCurrentScaleValue() {
        return this.currentValue;
    }

    public int getIntervalCount() {
        return this.intervalCount;
    }

    public int getIntervalCountInBig() {
        return this.intervalCountInBig;
    }

    public int getNearestScaleOffset(int x) {
        int i = 0;
        while (i < this.mScaleXList.size()) {
            int iIntValue = this.mScaleXList.get(i).intValue();
            if (i == 0 && x <= iIntValue) {
                setCurrentScaleValue(0);
                return x - iIntValue;
            }
            if (i == this.mScaleXList.size() - 1 && x >= iIntValue) {
                setCurrentScaleValue(this.mScaleValueList.size() - 1);
                return x - iIntValue;
            }
            int i2 = i + 1;
            if (i2 < this.mScaleXList.size()) {
                int iIntValue2 = this.mScaleXList.get(i2).intValue();
                if (x > iIntValue && x <= iIntValue2) {
                    int i3 = (iIntValue2 - iIntValue) / 2;
                    int i4 = x - iIntValue;
                    if (i4 > i3) {
                        setCurrentScaleValue(i2);
                        return x - iIntValue2;
                    }
                    setCurrentScaleValue(i);
                    return i4;
                }
            }
            i = i2;
        }
        return 0;
    }

    public double getScaleValueByIndex(int index) {
        return (index < 0 || index >= this.mScaleValueList.size()) ? AudioStats.AUDIO_AMPLITUDE_NONE : this.mScaleValueList.get(index).doubleValue();
    }

    public boolean isAddFull() {
        return this.mScaleValueList.size() == this.mScaleXList.size();
    }

    public boolean isLongLine(int index) {
        int i = index / this.intervalCountInBig;
        if (this.currentLine == i) {
            return false;
        }
        this.currentLine = i;
        return true;
    }

    public void setCenterPointX(int pointX) {
        this.mCenterPointX = pointX;
    }

    public void setConfig(double start, double end, double bigInterval, double smallInterval) {
        this.bigInterval = bigInterval;
        this.smallInterval = Math.min(bigInterval, smallInterval);
        this.intervalCountInBig = BigDecimal.valueOf(bigInterval).divide(BigDecimal.valueOf(smallInterval)).intValue();
        this.intervalCount = BigDecimal.valueOf(end).subtract(BigDecimal.valueOf(start)).divide(new BigDecimal(smallInterval), 0, 5).intValue();
        this.mScaleValueList.clear();
        while (start <= end) {
            this.mScaleValueList.add(Double.valueOf(start));
            start = BigDecimal.valueOf(start).add(BigDecimal.valueOf(smallInterval)).doubleValue();
        }
    }

    public void setCurrentScaleValue(double scale) {
        this.currentValue = scale;
    }

    public void setCurrentScaleValue(int index) {
        if (index < 0 || index >= this.mScaleValueList.size()) {
            return;
        }
        this.currentValue = this.mScaleValueList.get(index).doubleValue();
    }
}
