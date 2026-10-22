package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26525a;
    private int b;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;

    public static class a implements Parcelable.Creator<VehicleInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VehicleInfo createFromParcel(Parcel parcel) {
            return new VehicleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VehicleInfo[] newArray(int i) {
            return new VehicleInfo[i];
        }
    }

    public VehicleInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirectText() {
        return this.i;
    }

    public String getEndTime() {
        return this.g;
    }

    public String getHeadWay() {
        return this.h;
    }

    public int getPassStationNum() {
        return this.b;
    }

    public String getStartTime() {
        return this.f;
    }

    public String getTitle() {
        return this.c;
    }

    public int getTotalPrice() {
        return this.e;
    }

    public String getUid() {
        return this.f26525a;
    }

    public int getZonePrice() {
        return this.d;
    }

    public void setDirectText(String str) {
        this.i = str;
    }

    public void setEndTime(String str) {
        this.g = str;
    }

    public void setHeadWay(String str) {
        this.h = str;
    }

    public void setPassStationNum(int i) {
        this.b = i;
    }

    public void setStartTime(String str) {
        this.f = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setTotalPrice(int i) {
        this.e = i;
    }

    public void setUid(String str) {
        this.f26525a = str;
    }

    public void setZonePrice(int i) {
        this.d = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26525a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }

    public VehicleInfo(Parcel parcel) {
        this.f26525a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
    }
}
