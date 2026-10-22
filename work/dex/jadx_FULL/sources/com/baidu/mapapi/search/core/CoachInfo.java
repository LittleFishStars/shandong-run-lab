package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new a();
    private double f;
    private String g;
    private String h;
    private String i;

    public static class a implements Parcelable.Creator<CoachInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoachInfo createFromParcel(Parcel parcel) {
            return new CoachInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoachInfo[] newArray(int i) {
            return new CoachInfo[i];
        }
    }

    public CoachInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.g;
    }

    public double getPrice() {
        return this.f;
    }

    public String getProviderName() {
        return this.h;
    }

    public String getProviderUrl() {
        return this.i;
    }

    public void setBooking(String str) {
        this.g = str;
    }

    public void setPrice(double d) {
        this.f = d;
    }

    public void setProviderName(String str) {
        this.h = str;
    }

    public void setProviderUrl(String str) {
        this.i = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f = parcel.readDouble();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
    }
}
