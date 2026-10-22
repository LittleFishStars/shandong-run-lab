package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26524a;
    private String b;
    private LatLng c;
    private String d;

    public static class a implements Parcelable.Creator<TransitResultNode> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitResultNode createFromParcel(Parcel parcel) {
            return new TransitResultNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitResultNode[] newArray(int i) {
            return new TransitResultNode[i];
        }
    }

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f26524a = i;
        this.b = str;
        this.c = latLng;
        this.d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f26524a;
    }

    public String getCityName() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public String getSearchWord() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26524a);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
    }

    public TransitResultNode(Parcel parcel) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.f26524a = parcel.readInt();
        this.b = parcel.readString();
        this.c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.d = parcel.readString();
    }
}
