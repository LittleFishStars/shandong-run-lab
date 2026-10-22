package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RecommendStopInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendStopInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26517a;
    private LatLng b;
    private double c;
    private String d;
    private String e;

    public static class a implements Parcelable.Creator<RecommendStopInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopInfo createFromParcel(Parcel parcel) {
            return new RecommendStopInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopInfo[] newArray(int i) {
            return new RecommendStopInfo[i];
        }
    }

    public RecommendStopInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.e;
    }

    public double getDistance() {
        return this.c;
    }

    public String getId() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.b;
    }

    public String getName() {
        return this.f26517a;
    }

    public void setAddress(String str) {
        this.e = str;
    }

    public void setDistance(double d) {
        this.c = d;
    }

    public void setId(String str) {
        this.d = str;
    }

    public void setLocation(LatLng latLng) {
        this.b = latLng;
    }

    public void setName(String str) {
        this.f26517a = str;
    }

    public String toString() {
        return "RecommendStopInfo{mName='" + this.f26517a + "', mLocation=" + this.b + ", mDistance=" + this.c + ", mId='" + this.d + "', mAddress='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26517a);
        parcel.writeParcelable(this.b, i);
        parcel.writeDouble(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
    }

    public RecommendStopInfo(Parcel parcel) {
        this.f26517a = parcel.readString();
        this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = parcel.readDouble();
        this.e = parcel.readString();
        this.d = parcel.readString();
    }
}
