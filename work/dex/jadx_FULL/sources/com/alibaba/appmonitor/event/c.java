package com.alibaba.appmonitor.event;

import com.alibaba.analytics.a.j;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Long f23802a = 300000L;
    private Map<String, MeasureValue> E;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.appmonitor.model.a f673a;
    private MeasureValueSet b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Long f674b;
    private DimensionValueSet dimensionValues;

    public void N(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.E.isEmpty()) {
            this.f674b = Long.valueOf(jCurrentTimeMillis);
        }
        this.E.put(str, (MeasureValue) com.alibaba.appmonitor.pool.a.a().a(MeasureValue.class, Double.valueOf(jCurrentTimeMillis), Double.valueOf(jCurrentTimeMillis - this.f674b.longValue())));
        super.c(null);
    }

    public void a(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.dimensionValues;
        if (dimensionValueSet2 == null) {
            this.dimensionValues = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    @Override // com.alibaba.appmonitor.event.d, com.alibaba.appmonitor.pool.b
    public void clean() {
        super.clean();
        this.f673a = null;
        this.f674b = null;
        Iterator<MeasureValue> it = this.E.values().iterator();
        while (it.hasNext()) {
            com.alibaba.appmonitor.pool.a.a().a(it.next());
        }
        this.E.clear();
        if (this.b != null) {
            com.alibaba.appmonitor.pool.a.a().a(this.b);
            this.b = null;
        }
        if (this.dimensionValues != null) {
            com.alibaba.appmonitor.pool.a.a().a(this.dimensionValues);
            this.dimensionValues = null;
        }
    }

    @Override // com.alibaba.appmonitor.event.d, com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.E == null) {
            this.E = new HashMap();
        }
        com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(this.module, this.monitorPoint);
        this.f673a = aVarA;
        if (aVarA.a() != null) {
            this.dimensionValues = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().a(DimensionValueSet.class, new Object[0]);
            this.f673a.a().setConstantValue(this.dimensionValues);
        }
        this.b = (MeasureValueSet) com.alibaba.appmonitor.pool.a.a().a(MeasureValueSet.class, new Object[0]);
    }

    public boolean g(String str) {
        MeasureValue measureValue = this.E.get(str);
        if (measureValue != null) {
            double dCurrentTimeMillis = System.currentTimeMillis();
            j.d("DurationEvent", "statEvent consumeTime. module:", this.module, " monitorPoint:", this.monitorPoint, " measureName:", str, " time:", Double.valueOf(dCurrentTimeMillis - measureValue.getValue()));
            measureValue.setValue(dCurrentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.b.setValue(str, measureValue);
            if (this.f673a.m144a().valid(this.b)) {
                return true;
            }
        }
        super.c(null);
        return false;
    }

    public boolean w() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.f673a.m144a().getMeasures();
        if (measures != null) {
            int size = measures.size();
            for (int i = 0; i < size; i++) {
                Measure measure = measures.get(i);
                if (measure != null) {
                    double dDoubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : f23802a.longValue();
                    MeasureValue measureValue = this.E.get(measure.getName());
                    if (measureValue != null && !measureValue.isFinish() && jCurrentTimeMillis - measureValue.getValue() > dDoubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public MeasureValueSet m141a() {
        return this.b;
    }

    public DimensionValueSet a() {
        return this.dimensionValues;
    }
}
