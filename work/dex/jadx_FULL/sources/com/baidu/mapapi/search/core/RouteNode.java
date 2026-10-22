package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26520a;
    private LatLng b;
    private String c;

    public static class a implements Parcelable.Creator<RouteNode> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteNode createFromParcel(Parcel parcel) {
            return new RouteNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteNode[] newArray(int i) {
            return new RouteNode[i];
        }
    }

    public RouteNode() {
    }

    public static RouteNode location(LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setLocation(latLng);
        return routeNode;
    }

    public static RouteNode titleAndLocation(String str, LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(str);
        routeNode.setLocation(latLng);
        return routeNode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getLocation() {
        return this.b;
    }

    public String getTitle() {
        return this.f26520a;
    }

    public String getUid() {
        return this.c;
    }

    public void setLocation(LatLng latLng) {
        this.b = latLng;
    }

    public void setTitle(String str) {
        this.f26520a = str;
    }

    public void setUid(String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26520a);
        parcel.writeValue(this.b);
        parcel.writeString(this.c);
    }

    public RouteNode(Parcel parcel) {
        this.f26520a = parcel.readString();
        this.b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.c = parcel.readString();
    }
}
