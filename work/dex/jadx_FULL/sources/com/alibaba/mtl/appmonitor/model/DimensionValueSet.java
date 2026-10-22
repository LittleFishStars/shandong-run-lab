package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.appmonitor.pool.b;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DimensionValueSet implements Parcelable, b {
    public static final Parcelable.Creator<DimensionValueSet> CREATOR = new Parcelable.Creator<DimensionValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionValueSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DimensionValueSet createFromParcel(Parcel parcel) {
            return DimensionValueSet.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DimensionValueSet[] newArray(int i) {
            return new DimensionValueSet[i];
        }
    };
    protected Map<String, String> map;

    @Deprecated
    public DimensionValueSet() {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public static DimensionValueSet create() {
        return (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
    }

    public static DimensionValueSet fromStringMap(Map<String, String> map) {
        DimensionValueSet dimensionValueSet = (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dimensionValueSet.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
        return dimensionValueSet;
    }

    public static DimensionValueSet readFromParcel(Parcel parcel) {
        DimensionValueSet dimensionValueSetCreate;
        try {
            dimensionValueSetCreate = create();
            try {
                dimensionValueSetCreate.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            dimensionValueSetCreate = null;
        }
        return dimensionValueSetCreate;
    }

    public DimensionValueSet addValues(DimensionValueSet dimensionValueSet) {
        Map<String, String> map;
        if (dimensionValueSet != null && (map = dimensionValueSet.getMap()) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
            }
        }
        return this;
    }

    public void clean() {
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
        Map<String, String> map = this.map;
        if (map == null) {
            if (dimensionValueSet.map != null) {
                return false;
            }
        } else if (!map.equals(dimensionValueSet.map)) {
            return false;
        }
        return true;
    }

    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, String> getMap() {
        return this.map;
    }

    public String getValue(String str) {
        return this.map.get(str);
    }

    public int hashCode() {
        Map<String, String> map = this.map;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public void setMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
    }

    public DimensionValueSet setValue(String str, String str2) {
        Map<String, String> map = this.map;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }

    @Deprecated
    public static DimensionValueSet create(int i) {
        return (DimensionValueSet) a.a().a(DimensionValueSet.class, new Object[0]);
    }
}
