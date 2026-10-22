package com.huachenjie.common.widget.ruler;

import androidx.camera.video.AudioStats;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class VerticalRulerHelper {
    private double currentValue;
    private int intervalCount;
    private int mCenterPointY;
    private ScrollChangeListener scrollChangeListener;
    private int currentLine = -1;
    private double bigInterval = 5.0d;
    private List<Double> mScaleValueList = new ArrayList();
    private List<Integer> mScaleYList = new ArrayList();
    private List<String> extraList = new ArrayList();

    public VerticalRulerHelper(ScrollChangeListener listener) {
        this.scrollChangeListener = listener;
    }

    public void addScale(int y) {
        int iIndexOf;
        int iIntValue;
        this.mScaleYList.add(Integer.valueOf(y));
        if (this.mScaleYList.size() != this.mScaleValueList.size() || this.scrollChangeListener == null || (iIndexOf = this.mScaleValueList.indexOf(Double.valueOf(this.currentValue))) < 0 || (iIntValue = this.mScaleYList.get(iIndexOf).intValue()) < 0) {
            return;
        }
        this.scrollChangeListener.startScroll(this.mCenterPointY - iIntValue);
    }

    public void destroy() {
        this.mScaleYList.clear();
        this.mScaleValueList.clear();
        this.mScaleYList = null;
        this.mScaleValueList = null;
        this.scrollChangeListener = null;
    }

    public int getCenterPointY() {
        return this.mCenterPointY;
    }

    public double getCurrentScaleValue() {
        return this.currentValue;
    }

    public List<String> getExtraInfoList() {
        return this.extraList;
    }

    public int getIntervalCount() {
        return this.intervalCount;
    }

    public int getNearestScaleOffset(int y) {
        int i = 0;
        while (i < this.mScaleYList.size()) {
            int iIntValue = this.mScaleYList.get(i).intValue();
            if (i == 0 && y <= iIntValue) {
                setCurrentScaleValue(0);
                return y - iIntValue;
            }
            if (i == this.mScaleYList.size() - 1 && y >= iIntValue) {
                setCurrentScaleValue(this.mScaleValueList.size() - 1);
                return y - iIntValue;
            }
            int i2 = i + 1;
            if (i2 < this.mScaleYList.size()) {
                int iIntValue2 = this.mScaleYList.get(i2).intValue();
                if (y > iIntValue && y <= iIntValue2) {
                    int i3 = (iIntValue2 - iIntValue) / 2;
                    int i4 = y - iIntValue;
                    if (i4 > i3) {
                        setCurrentScaleValue(i2);
                        return y - iIntValue2;
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
        return this.mScaleValueList.size() == this.mScaleYList.size();
    }

    public void setCenterPointY(int pointY) {
        this.mCenterPointY = pointY;
    }

    public void setConfig(double start, double end, double bigInterval) {
        this.bigInterval = bigInterval;
        this.intervalCount = BigDecimal.valueOf(end).subtract(BigDecimal.valueOf(start)).divide(new BigDecimal(bigInterval), 0, 5).intValue();
        this.mScaleValueList.clear();
        while (start <= end) {
            this.mScaleValueList.add(Double.valueOf(start));
            start = BigDecimal.valueOf(start).add(BigDecimal.valueOf(bigInterval)).doubleValue();
        }
    }

    public void setCurrentScaleValue(double scale) {
        this.currentValue = scale;
    }

    public void setExtraInfoList(List<String> extraInfoList) {
        if (extraInfoList == null || extraInfoList.isEmpty() || extraInfoList.size() != extraInfoList.size()) {
            return;
        }
        this.extraList.clear();
        this.extraList.addAll(extraInfoList);
    }

    public void setCurrentScaleValue(int index) {
        if (index < 0 || index >= this.mScaleValueList.size()) {
            return;
        }
        this.currentValue = this.mScaleValueList.get(index).doubleValue();
    }

    public void setConfig(List<Double> valueList, double bigInterval) {
        this.bigInterval = bigInterval;
        this.intervalCount = valueList.size() - 1;
        this.mScaleValueList.clear();
        this.mScaleValueList.addAll(valueList);
    }
}
