package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.utils.ColorTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LegendEntry {
    public Legend.LegendForm form;
    public int formColor;
    public DashPathEffect formLineDashEffect;
    public float formLineWidth;
    public float formSize;
    public String label;

    public LegendEntry() {
        this.form = Legend.LegendForm.DEFAULT;
        this.formSize = Float.NaN;
        this.formLineWidth = Float.NaN;
        this.formLineDashEffect = null;
        this.formColor = ColorTemplate.COLOR_NONE;
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f, float f2, DashPathEffect dashPathEffect, int i) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.DEFAULT;
        this.label = str;
        this.form = legendForm;
        this.formSize = f;
        this.formLineWidth = f2;
        this.formLineDashEffect = dashPathEffect;
        this.formColor = i;
    }
}
