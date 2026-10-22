package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();
    private int f;
    private int g;
    private List<RouteNode> h;
    private String i;
    private String j;
    private String k;
    private String l;

    public static class a implements Parcelable.Creator<BusInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusInfo createFromParcel(Parcel parcel) {
            return new BusInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusInfo[] newArray(int i) {
            return new BusInfo[i];
        }
    }

    public BusInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirectText() {
        return this.l;
    }

    public String getEndUid() {
        return this.j;
    }

    public String getLineUid() {
        return this.k;
    }

    public List<RouteNode> getPassStopInfoList() {
        return this.h;
    }

    public String getStartUid() {
        return this.i;
    }

    public int getStopNum() {
        return this.g;
    }

    public int getType() {
        return this.f;
    }

    public void setDirectText(String str) {
        this.l = str;
    }

    public void setEndUid(String str) {
        this.j = str;
    }

    public void setLineUid(String str) {
        this.k = str;
    }

    public void setPassStopInfoList(List<RouteNode> list) {
        this.h = list;
    }

    public void setStartUid(String str) {
        this.i = str;
    }

    public void setStopNum(int i) {
        this.g = i;
    }

    public void setType(int i) {
        this.f = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeTypedList(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.createTypedArrayList(RouteNode.CREATOR);
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
    }
}
