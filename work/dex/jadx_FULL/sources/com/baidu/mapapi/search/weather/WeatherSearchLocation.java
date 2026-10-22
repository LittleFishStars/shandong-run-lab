package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WeatherSearchLocation implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchLocation> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26585a;
    private String b;
    private String c;
    private String d;
    private String e;

    public static class a implements Parcelable.Creator<WeatherSearchLocation> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchLocation createFromParcel(Parcel parcel) {
            return new WeatherSearchLocation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherSearchLocation[] newArray(int i) {
            return new WeatherSearchLocation[i];
        }
    }

    public WeatherSearchLocation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.c;
    }

    public String getCountry() {
        return this.f26585a;
    }

    public String getDistrictID() {
        return this.e;
    }

    public String getDistrictName() {
        return this.d;
    }

    public String getProvince() {
        return this.b;
    }

    public void setCity(String str) {
        this.c = str;
    }

    public void setCountry(String str) {
        this.f26585a = str;
    }

    public void setDistrictID(String str) {
        this.e = str;
    }

    public void setDistrictName(String str) {
        this.d = str;
    }

    public void setProvince(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26585a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public WeatherSearchLocation(Parcel parcel) {
        this.f26585a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }
}
