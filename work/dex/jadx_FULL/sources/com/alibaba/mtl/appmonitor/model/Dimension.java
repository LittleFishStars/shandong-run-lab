package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Dimension implements Parcelable {
    public static final Parcelable.Creator<Dimension> CREATOR = new Parcelable.Creator<Dimension>() { // from class: com.alibaba.mtl.appmonitor.model.Dimension.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Dimension createFromParcel(Parcel parcel) {
            return Dimension.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Dimension[] newArray(int i) {
            return new Dimension[i];
        }
    };
    static final String DEFAULT_NULL_VALUE = "null";
    protected String constantValue;
    protected String name;

    public Dimension() {
        this.constantValue = "null";
    }

    public static Dimension readFromParcel(Parcel parcel) {
        try {
            return new Dimension(parcel.readString(), parcel.readString());
        } catch (Throwable unused) {
            return null;
        }
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
        Dimension dimension = (Dimension) obj;
        String str = this.name;
        if (str == null) {
            if (dimension.name != null) {
                return false;
            }
        } else if (!str.equals(dimension.name)) {
            return false;
        }
        return true;
    }

    public String getConstantValue() {
        return this.constantValue;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setConstantValue(String str) {
        this.constantValue = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.constantValue);
        parcel.writeString(this.name);
    }

    public Dimension(String str) {
        this(str, null);
    }

    public Dimension(String str, String str2) {
        this.constantValue = "null";
        this.name = str;
        this.constantValue = str2 == null ? "null" : str2;
    }
}
