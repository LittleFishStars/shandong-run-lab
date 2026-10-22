package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PoiChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<PoiChildrenInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26511a;
    private String b;
    private String c;
    private String d;
    private LatLng e;
    private String f;

    public static class a implements Parcelable.Creator<PoiChildrenInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiChildrenInfo createFromParcel(Parcel parcel) {
            return new PoiChildrenInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiChildrenInfo[] newArray(int i) {
            return new PoiChildrenInfo[i];
        }
    }

    public PoiChildrenInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f;
    }

    public LatLng getLocation() {
        return this.e;
    }

    public String getName() {
        return this.b;
    }

    public String getShowName() {
        return this.c;
    }

    public String getTag() {
        return this.d;
    }

    public String getUid() {
        return this.f26511a;
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setLocation(LatLng latLng) {
        this.e = latLng;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setShowName(String str) {
        this.c = str;
    }

    public void setTag(String str) {
        this.d = str;
    }

    public void setUid(String str) {
        this.f26511a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PoiChildrenInfo: ");
        stringBuffer.append("uid = ");
        stringBuffer.append(this.f26511a);
        stringBuffer.append("; name = ");
        stringBuffer.append(this.b);
        stringBuffer.append("; showName = ");
        stringBuffer.append(this.c);
        stringBuffer.append("; tag = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; location = ");
        LatLng latLng = this.e;
        if (latLng != null) {
            stringBuffer.append(latLng.toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append("; address = ");
        stringBuffer.append(this.f);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26511a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeString(this.f);
    }

    public PoiChildrenInfo(Parcel parcel) {
        this.f26511a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f = parcel.readString();
    }
}
