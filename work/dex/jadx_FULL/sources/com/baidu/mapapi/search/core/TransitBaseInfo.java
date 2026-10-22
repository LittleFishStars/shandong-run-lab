package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26523a;
    private String b;
    private String c;
    private String d;
    private String e;

    public static class a implements Parcelable.Creator<TransitBaseInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitBaseInfo createFromParcel(Parcel parcel) {
            return new TransitBaseInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitBaseInfo[] newArray(int i) {
            return new TransitBaseInfo[i];
        }
    }

    public TransitBaseInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.c;
    }

    public String getArriveTime() {
        return this.e;
    }

    public String getDepartureStation() {
        return this.b;
    }

    public String getDepartureTime() {
        return this.d;
    }

    public String getName() {
        return this.f26523a;
    }

    public void setArriveStation(String str) {
        this.c = str;
    }

    public void setArriveTime(String str) {
        this.e = str;
    }

    public void setDepartureStation(String str) {
        this.b = str;
    }

    public void setDepartureTime(String str) {
        this.d = str;
    }

    public void setName(String str) {
        this.f26523a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26523a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f26523a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }
}
