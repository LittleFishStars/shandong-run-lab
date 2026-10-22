package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public String getAxisLabel(float f, AxisBase axisBase) {
        return getFormattedValue(f);
    }

    public String getBarLabel(BarEntry barEntry) {
        return getFormattedValue(barEntry.getY());
    }

    public String getBarStackedLabel(float f, BarEntry barEntry) {
        return getFormattedValue(f);
    }

    public String getBubbleLabel(BubbleEntry bubbleEntry) {
        return getFormattedValue(bubbleEntry.getSize());
    }

    public String getCandleLabel(CandleEntry candleEntry) {
        return getFormattedValue(candleEntry.getHigh());
    }

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    @Deprecated
    public String getFormattedValue(float f, AxisBase axisBase) {
        return getFormattedValue(f);
    }

    public String getPieLabel(float f, PieEntry pieEntry) {
        return getFormattedValue(f);
    }

    public String getPointLabel(Entry entry) {
        return getFormattedValue(entry.getY());
    }

    public String getRadarLabel(RadarEntry radarEntry) {
        return getFormattedValue(radarEntry.getY());
    }

    @Override // com.github.mikephil.charting.formatter.IValueFormatter
    @Deprecated
    public String getFormattedValue(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
        return getFormattedValue(f);
    }

    public String getFormattedValue(float f) {
        return String.valueOf(f);
    }
}
