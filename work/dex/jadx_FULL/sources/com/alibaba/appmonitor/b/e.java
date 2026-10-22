package com.alibaba.appmonitor.b;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("stat_temp")
public class e extends c {

    @com.alibaba.analytics.core.b.a.a("dimension_values")
    private String bm;

    @com.alibaba.analytics.core.b.a.a("measure_values")
    private String bn;

    public e() {
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public MeasureValueSet m140b() {
        if (TextUtils.isEmpty(this.bn)) {
            return null;
        }
        return (MeasureValueSet) JSON.parseObject(this.bn, MeasureValueSet.class);
    }

    @Override // com.alibaba.appmonitor.b.c
    public String toString() {
        return "TempStat{module='" + this.module + "'monitorPoint='" + this.monitorPoint + "'dimension_values='" + this.bm + "', measure_values='" + this.bn + "'}";
    }

    public e(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, String str3, String str4) {
        super(str, str2, str3, str4);
        this.bm = JSON.toJSONString(dimensionValueSet);
        this.bn = JSON.toJSONString(measureValueSet);
    }

    public DimensionValueSet b() {
        if (TextUtils.isEmpty(this.bm)) {
            return null;
        }
        return (DimensionValueSet) JSON.parseObject(this.bm, DimensionValueSet.class);
    }
}
