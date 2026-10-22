package com.alibaba.appmonitor.event;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.appmonitor.model.a f23804a;
    private Map<DimensionValueSet, a> values;

    public class a {
        private int count = 0;
        private int O = 0;
        private List<MeasureValueSet> j = new ArrayList();

        public a() {
        }

        public void V() {
            this.count++;
        }

        public void W() {
            this.O++;
        }

        public List<Map<String, Map<String, Object>>> c() {
            Map<String, MeasureValue> map;
            List<MeasureValueSet> list = this.j;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                MeasureValueSet measureValueSet = this.j.get(i);
                if (measureValueSet != null && (map = measureValueSet.getMap()) != null && !map.isEmpty()) {
                    HashMap map2 = new HashMap();
                    for (Map.Entry<String, MeasureValue> entry : map.entrySet()) {
                        HashMap map3 = new HashMap();
                        String key = entry.getKey();
                        MeasureValue value = entry.getValue();
                        map3.put("value", Double.valueOf(value.getValue()));
                        if (value.getOffset() != null) {
                            map3.put(TypedValues.CycleType.S_WAVE_OFFSET, value.getOffset());
                        }
                        Map<String, Double> buckets = value.getBuckets();
                        if (buckets != null) {
                            map3.put("buckets", buckets);
                        }
                        map2.put(key, map3);
                    }
                    arrayList.add(map2);
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m143a(MeasureValueSet measureValueSet) {
            if (measureValueSet != null) {
                if (f.this.f23804a != null && f.this.f23804a.x()) {
                    this.j.add(a(measureValueSet));
                    return;
                }
                if (!this.j.isEmpty()) {
                    this.j.get(0).merge(measureValueSet);
                    return;
                }
                MeasureValueSet measureValueSetA = a(measureValueSet);
                if (f.this.f23804a != null && f.this.f23804a.m144a() != null) {
                    measureValueSetA.setBuckets(f.this.f23804a.m144a().getMeasures());
                }
                this.j.add(measureValueSetA);
            }
        }

        private MeasureValueSet a(MeasureValueSet measureValueSet) {
            List<Measure> measures;
            MeasureValueSet measureValueSet2 = (MeasureValueSet) com.alibaba.appmonitor.pool.a.a().a(MeasureValueSet.class, new Object[0]);
            if (f.this.f23804a != null && f.this.f23804a.m144a() != null && (measures = f.this.f23804a.m144a().getMeasures()) != null) {
                int size = measures.size();
                for (int i = 0; i < size; i++) {
                    Measure measure = measures.get(i);
                    if (measure != null) {
                        MeasureValue measureValue = (MeasureValue) com.alibaba.appmonitor.pool.a.a().a(MeasureValue.class, new Object[0]);
                        MeasureValue value = measureValueSet.getValue(measure.getName());
                        if (value.getOffset() != null) {
                            measureValue.setOffset(value.getOffset().doubleValue());
                        }
                        measureValue.setValue(value.getValue());
                        measureValueSet2.setValue(measure.getName(), measureValue);
                    }
                }
            }
            return measureValueSet2;
        }
    }

    @Override // com.alibaba.appmonitor.event.d, com.alibaba.appmonitor.pool.b
    public synchronized void clean() {
        super.clean();
        this.f23804a = null;
        Iterator<DimensionValueSet> it = this.values.keySet().iterator();
        while (it.hasNext()) {
            com.alibaba.appmonitor.pool.a.a().a(it.next());
        }
        this.values.clear();
    }

    @Override // com.alibaba.appmonitor.event.d, com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.values == null) {
            this.values = new HashMap();
        }
        this.f23804a = com.alibaba.appmonitor.model.b.a().a(this.module, this.monitorPoint);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0043 A[Catch: all -> 0x0066, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0012, B:8:0x001a, B:10:0x003f, B:12:0x0043, B:14:0x0049, B:20:0x0060, B:15:0x0050, B:17:0x0057, B:19:0x005d, B:9:0x0023), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0049 A[Catch: all -> 0x0066, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0012, B:8:0x001a, B:10:0x003f, B:12:0x0043, B:14:0x0049, B:20:0x0060, B:15:0x0050, B:17:0x0057, B:19:0x005d, B:9:0x0023), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0050 A[Catch: all -> 0x0066, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0012, B:8:0x001a, B:10:0x003f, B:12:0x0043, B:14:0x0049, B:20:0x0060, B:15:0x0050, B:17:0x0057, B:19:0x005d, B:9:0x0023), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001a A[Catch: all -> 0x0066, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0012, B:8:0x001a, B:10:0x003f, B:12:0x0043, B:14:0x0049, B:20:0x0060, B:15:0x0050, B:17:0x0057, B:19:0x005d, B:9:0x0023), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0023 A[Catch: all -> 0x0066, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0012, B:8:0x001a, B:10:0x003f, B:12:0x0043, B:14:0x0049, B:20:0x0060, B:15:0x0050, B:17:0x0057, B:19:0x005d, B:9:0x0023), top: B:26:0x0004 }] */
    public synchronized void a(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        a aVar;
        com.alibaba.appmonitor.model.a aVar2;
        com.alibaba.appmonitor.model.a aVar3;
        if (dimensionValueSet == null) {
            dimensionValueSet = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().a(DimensionValueSet.class, new Object[0]);
            if (this.values.containsKey(dimensionValueSet)) {
                aVar = this.values.get(dimensionValueSet);
            } else {
                DimensionValueSet dimensionValueSet2 = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().a(DimensionValueSet.class, new Object[0]);
                dimensionValueSet2.addValues(dimensionValueSet);
                a aVar4 = new a();
                this.values.put(dimensionValueSet2, aVar4);
                aVar = aVar4;
            }
            aVar2 = this.f23804a;
            if (aVar2 != null ? aVar2.a(dimensionValueSet, measureValueSet) : false) {
                aVar.V();
                aVar.m143a(measureValueSet);
            } else {
                aVar.W();
                aVar3 = this.f23804a;
                if (aVar3 != null && aVar3.x()) {
                    aVar.m143a(measureValueSet);
                }
            }
            super.c(null);
        } else {
            if (this.values.containsKey(dimensionValueSet)) {
                aVar = this.values.get(dimensionValueSet);
            } else {
                DimensionValueSet dimensionValueSet3 = (DimensionValueSet) com.alibaba.appmonitor.pool.a.a().a(DimensionValueSet.class, new Object[0]);
                dimensionValueSet3.addValues(dimensionValueSet);
                a aVar5 = new a();
                this.values.put(dimensionValueSet3, aVar5);
                aVar = aVar5;
            }
            aVar2 = this.f23804a;
            if (aVar2 != null ? aVar2.a(dimensionValueSet, measureValueSet) : false) {
                aVar.V();
                aVar.m143a(measureValueSet);
            } else {
                aVar.W();
                aVar3 = this.f23804a;
                if (aVar3 != null) {
                    aVar.m143a(measureValueSet);
                }
            }
            super.c(null);
        }
        throw th;
    }

    @Override // com.alibaba.appmonitor.event.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        jSONObjectA = super.a();
        com.alibaba.appmonitor.model.a aVar = this.f23804a;
        if (aVar != null) {
            jSONObjectA.put("isCommitDetail", String.valueOf(aVar.x()));
        }
        JSONArray jSONArray = (JSONArray) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONArray.class, new Object[0]);
        Map<DimensionValueSet, a> map = this.values;
        if (map != null) {
            for (Map.Entry<DimensionValueSet, a> entry : map.entrySet()) {
                JSONObject jSONObject = (JSONObject) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONObject.class, new Object[0]);
                DimensionValueSet key = entry.getKey();
                a value = entry.getValue();
                Integer numValueOf = Integer.valueOf(value.count);
                Integer numValueOf2 = Integer.valueOf(value.O);
                jSONObject.put("count", (Object) numValueOf);
                jSONObject.put("noise", (Object) numValueOf2);
                jSONObject.put("dimensions", (Object) (key != null ? new HashMap(key.getMap()) : null));
                jSONObject.put("measures", (Object) value.c());
                jSONArray.add(jSONObject);
            }
        }
        jSONObjectA.put("values", (Object) jSONArray);
        return jSONObjectA;
    }
}
