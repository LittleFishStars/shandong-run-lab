package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MeasureSet implements Parcelable {
    public static final Parcelable.Creator<MeasureSet> CREATOR = new Parcelable.Creator<MeasureSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureSet createFromParcel(Parcel parcel) {
            return MeasureSet.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureSet[] newArray(int i) {
            return new MeasureSet[i];
        }
    };
    private static final int INIT_SIZE = 3;
    private List<Measure> measures = new ArrayList(3);

    private MeasureSet() {
    }

    public static MeasureSet create() {
        return new MeasureSet();
    }

    public static MeasureSet readFromParcel(Parcel parcel) {
        MeasureSet measureSetCreate = create();
        try {
            Parcelable[] parcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((Measure) parcelable);
                }
                measureSetCreate.measures = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return measureSetCreate;
    }

    public MeasureSet addMeasure(Measure measure) {
        if (!this.measures.contains(measure)) {
            this.measures.add(measure);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Measure getMeasure(String str) {
        for (Measure measure : this.measures) {
            if (measure.getName().equals(str)) {
                return measure;
            }
        }
        return null;
    }

    public List<Measure> getMeasures() {
        return this.measures;
    }

    public void setConstantValue(MeasureValueSet measureValueSet) {
        List<Measure> list = this.measures;
        if (list == null || measureValueSet == null) {
            return;
        }
        for (Measure measure : list) {
            if (measure.getConstantValue() != null && measureValueSet.getValue(measure.getName()) == null) {
                measureValueSet.setValue(measure.getName(), measure.getConstantValue().doubleValue());
            }
        }
    }

    public void upateMeasure(Measure measure) {
        int size = this.measures.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.measures.get(i).name, measure.name)) {
                this.measures.get(i).setRange(measure.getMin(), measure.getMax());
                this.measures.get(i).setConstantValue(measure.getConstantValue());
            }
        }
    }

    public void upateMeasures(List<Measure> list) {
        int size = this.measures.size();
        int size2 = list.size();
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (TextUtils.equals(this.measures.get(i).name, list.get(i2).name)) {
                    this.measures.get(i).setRange(list.get(i2).getMin(), list.get(i2).getMax());
                }
            }
        }
    }

    public boolean valid(MeasureValueSet measureValueSet) {
        if (this.measures == null) {
            return true;
        }
        if (measureValueSet == null) {
            return false;
        }
        for (int i = 0; i < this.measures.size(); i++) {
            Measure measure = this.measures.get(i);
            if (measure != null) {
                String name = measure.getName();
                if (!measureValueSet.containValue(name) || !measure.valid(measureValueSet.getValue(name))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Measure[] measureArr;
        List<Measure> list = this.measures;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                if (array != null) {
                    measureArr = new Measure[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        measureArr[i2] = (Measure) array[i2];
                    }
                } else {
                    measureArr = null;
                }
                parcel.writeParcelableArray(measureArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static MeasureSet create(Collection<String> collection) {
        MeasureSet measureSet = new MeasureSet();
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                measureSet.addMeasure(it.next());
            }
        }
        return measureSet;
    }

    public MeasureSet addMeasure(String str) {
        return addMeasure(new Measure(str));
    }

    public static MeasureSet create(String[] strArr) {
        MeasureSet measureSet = new MeasureSet();
        if (strArr != null) {
            for (String str : strArr) {
                measureSet.addMeasure(str);
            }
        }
        return measureSet;
    }
}
