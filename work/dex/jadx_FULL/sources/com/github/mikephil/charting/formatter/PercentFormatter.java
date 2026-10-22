package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PercentFormatter extends ValueFormatter {
    public DecimalFormat mFormat;
    private PieChart pieChart;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        return this.mFormat.format(f) + " %";
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getPieLabel(float f, PieEntry pieEntry) {
        PieChart pieChart = this.pieChart;
        return (pieChart == null || !pieChart.isUsePercentValuesEnabled()) ? this.mFormat.format(f) : getFormattedValue(f);
    }

    public PercentFormatter(PieChart pieChart) {
        this();
        this.pieChart = pieChart;
    }
}
