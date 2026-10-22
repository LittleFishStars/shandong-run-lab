package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Poi implements Parcelable {
    public static final Parcelable.Creator<Poi> CREATOR = new Parcelable.Creator<Poi>() { // from class: com.baidu.location.Poi.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Poi createFromParcel(Parcel parcel) {
            return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Poi[] newArray(int i) {
            return new Poi[i];
        }
    };
    private final String mAddr;
    private final String mId;
    private final String mName;
    private final double mRank;
    private final String mTags;

    public Poi(String str, String str2, double d, String str3, String str4) {
        this.mId = str;
        this.mName = str2;
        this.mRank = d;
        this.mTags = str3;
        this.mAddr = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddr() {
        return this.mAddr;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public double getRank() {
        return this.mRank;
    }

    public String getTags() {
        return this.mTags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeDouble(this.mRank);
        parcel.writeString(this.mTags);
        parcel.writeString(this.mAddr);
    }
}
