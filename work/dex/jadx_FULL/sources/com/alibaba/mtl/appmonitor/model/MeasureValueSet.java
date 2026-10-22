package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.appmonitor.pool.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MeasureValueSet implements Parcelable, b {
    public static final Parcelable.Creator<MeasureValueSet> CREATOR = new Parcelable.Creator<MeasureValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValueSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureValueSet createFromParcel(Parcel parcel) {
            return MeasureValueSet.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureValueSet[] newArray(int i) {
            return new MeasureValueSet[i];
        }
    };
    private Map<String, MeasureValue> map = new LinkedHashMap();

    @Deprecated
    public MeasureValueSet() {
    }

    public static MeasureValueSet create() {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    public static MeasureValueSet fromStringMap(Map<String, String> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Double d = toDouble(entry.getValue());
                if (d != null) {
                    measureValueSet.map.put(entry.getKey(), (MeasureValue) a.a().a(MeasureValue.class, d));
                }
            }
        }
        return measureValueSet;
    }

    private Measure getMeasure(List<Measure> list, String str) {
        for (Measure measure : list) {
            if (str.equalsIgnoreCase(measure.getName())) {
                return measure;
            }
        }
        return null;
    }

    public static MeasureValueSet readFromParcel(Parcel parcel) {
        try {
            MeasureValueSet measureValueSetCreate = create();
            try {
                measureValueSetCreate.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
                return measureValueSetCreate;
            } catch (Throwable unused) {
                return measureValueSetCreate;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        Iterator<MeasureValue> it = this.map.values().iterator();
        while (it.hasNext()) {
            a.a().a(it.next());
        }
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, MeasureValue> getMap() {
        return this.map;
    }

    public MeasureValue getValue(String str) {
        return this.map.get(str);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void setBuckets(List<Measure> list) {
        if (list == null) {
            return;
        }
        for (String str : this.map.keySet()) {
            this.map.get(str).setBuckets(getMeasure(list, str));
        }
    }

    public void setMap(Map<String, MeasureValue> map) {
        this.map = map;
    }

    public MeasureValueSet setValue(String str, double d) {
        this.map.put(str, (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf(d)));
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }

    @Deprecated
    public static MeasureValueSet create(int i) {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    public void merge(MeasureValueSet measureValueSet) {
        for (String str : this.map.keySet()) {
            this.map.get(str).merge(measureValueSet.getValue(str));
        }
    }

    public void setValue(String str, MeasureValue measureValue) {
        this.map.put(str, measureValue);
    }

    public static MeasureValueSet create(Map<String, Double> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (String str : map.keySet()) {
                Double d = map.get(str);
                if (d != null) {
                    measureValueSet.map.put(str, (MeasureValue) a.a().a(MeasureValue.class, d));
                }
            }
        }
        return measureValueSet;
    }
}
