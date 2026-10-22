package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RouteStep implements Parcelable {
    public static final Parcelable.Creator<RouteStep> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f26521a;
    int b;
    String c;
    int d;
    protected List<LatLng> mWayPoints;

    public static class a implements Parcelable.Creator<RouteStep> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteStep createFromParcel(Parcel parcel) {
            return new RouteStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteStep[] newArray(int i) {
            return new RouteStep[i];
        }
    }

    public RouteStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f26521a;
    }

    public int getDuration() {
        return this.b;
    }

    public String getName() {
        return this.c;
    }

    public int getTransType() {
        return this.d;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i) {
        this.f26521a = i;
    }

    public void setDuration(int i) {
        this.b = i;
    }

    public void setName(String str) {
        this.c = str;
    }

    public void setTransType(int i) {
        this.d = i;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26521a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.d);
        parcel.writeString(this.c);
        parcel.writeList(this.mWayPoints);
    }

    public RouteStep(Parcel parcel) {
        this.f26521a = parcel.readInt();
        this.b = parcel.readInt();
        this.d = parcel.readInt();
        this.c = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.mWayPoints = arrayList;
        parcel.readList(arrayList, LatLng.class.getClassLoader());
        if (this.mWayPoints.size() == 0) {
            this.mWayPoints = null;
        }
    }
}
