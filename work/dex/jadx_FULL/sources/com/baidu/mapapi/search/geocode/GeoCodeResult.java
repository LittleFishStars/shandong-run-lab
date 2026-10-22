package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f26528a;
    private String b;
    private int c;
    private int d;
    private String e;

    public static class a implements Parcelable.Creator<GeoCodeResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeoCodeResult createFromParcel(Parcel parcel) {
            return new GeoCodeResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeoCodeResult[] newArray(int i) {
            return new GeoCodeResult[i];
        }
    }

    public GeoCodeResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.b;
    }

    public int getConfidence() {
        return this.d;
    }

    public String getLevel() {
        return this.e;
    }

    public LatLng getLocation() {
        return this.f26528a;
    }

    public int getPrecise() {
        return this.c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.b = str;
    }

    public void setConfidence(int i) {
        this.d = i;
    }

    public void setLevel(String str) {
        this.e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f26528a = latLng;
    }

    public void setPrecise(int i) {
        this.c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f26528a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f26528a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
    }

    public GeoCodeResult(Parcel parcel) {
        this.f26528a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
    }
}
