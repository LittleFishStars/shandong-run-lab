package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.analytics.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DimensionSet implements Parcelable {
    public static final Parcelable.Creator<DimensionSet> CREATOR = new Parcelable.Creator<DimensionSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DimensionSet createFromParcel(Parcel parcel) {
            return DimensionSet.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DimensionSet[] newArray(int i) {
            return new DimensionSet[i];
        }
    };
    private static final int INIT_SIZE = 3;
    private static final String TAG = "DimensionSet";
    private List<Dimension> dimensions = new ArrayList(3);

    private DimensionSet() {
    }

    public static DimensionSet create() {
        return new DimensionSet();
    }

    public static DimensionSet readFromParcel(Parcel parcel) {
        DimensionSet dimensionSetCreate = create();
        try {
            Parcelable[] parcelableArray = parcel.readParcelableArray(DimensionSet.class.getClassLoader());
            if (parcelableArray != null) {
                if (dimensionSetCreate.dimensions == null) {
                    dimensionSetCreate.dimensions = new ArrayList();
                }
                for (int i = 0; i < parcelableArray.length; i++) {
                    Parcelable parcelable = parcelableArray[i];
                    if (parcelable == null || !(parcelable instanceof Dimension)) {
                        j.d(TAG, "parcelables[i]:", parcelableArray[i]);
                    } else {
                        dimensionSetCreate.dimensions.add((Dimension) parcelable);
                    }
                }
            }
        } catch (Throwable th) {
            j.w(TAG, "[readFromParcel]", th);
        }
        return dimensionSetCreate;
    }

    public DimensionSet addDimension(Dimension dimension) {
        if (this.dimensions.contains(dimension)) {
            return this;
        }
        this.dimensions.add(dimension);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Dimension getDimension(String str) {
        for (Dimension dimension : this.dimensions) {
            if (dimension.getName().equals(str)) {
                return dimension;
            }
        }
        return null;
    }

    public List<Dimension> getDimensions() {
        return this.dimensions;
    }

    public void setConstantValue(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.dimensions;
        if (list == null || dimensionValueSet == null) {
            return;
        }
        for (Dimension dimension : list) {
            if (dimension.getConstantValue() != null && dimensionValueSet.getValue(dimension.getName()) == null) {
                dimensionValueSet.setValue(dimension.getName(), dimension.getConstantValue());
            }
        }
    }

    public boolean valid(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.dimensions;
        if (list == null) {
            return true;
        }
        if (dimensionValueSet != null) {
            Iterator<Dimension> it = list.iterator();
            while (it.hasNext()) {
                if (!dimensionValueSet.containValue(it.next().getName())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Dimension[] dimensionArr;
        List<Dimension> list = this.dimensions;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                if (array != null) {
                    dimensionArr = new Dimension[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        dimensionArr[i2] = (Dimension) array[i2];
                    }
                } else {
                    dimensionArr = null;
                }
                parcel.writeParcelableArray(dimensionArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static DimensionSet create(Collection<String> collection) {
        DimensionSet dimensionSet = new DimensionSet();
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                dimensionSet.addDimension(new Dimension(it.next()));
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(String str) {
        return addDimension(new Dimension(str));
    }

    public static DimensionSet create(String[] strArr) {
        DimensionSet dimensionSet = new DimensionSet();
        if (strArr != null) {
            for (String str : strArr) {
                dimensionSet.addDimension(new Dimension(str));
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(String str, String str2) {
        return addDimension(new Dimension(str, str2));
    }
}
