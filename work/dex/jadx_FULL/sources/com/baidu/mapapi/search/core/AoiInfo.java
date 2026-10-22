package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AoiInfo implements Parcelable {
    public static final Parcelable.Creator<AoiInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26509a;
    private String b;
    private String c;
    private AoiType d;
    private int e;
    private int f;
    private int g;

    public enum AoiType {
        AOI_TYPE_UNKNOWN(0),
        AOI_TYPE_AIRPORT(1),
        AOI_TYPE_RAILWAT_STATION(2),
        AOI_TYPE_SHOPPINGMALL(3),
        AOI_TYPE_GAS_STATION(4),
        AOI_TYPE_SCHOOL(5),
        AOI_TYPE_HOSPITAL(6),
        AOI_TYPE_RESIDENTIAL_DISTRICT(7),
        AOI_TYPE_SCENIC_AREA(8),
        AOI_TYPE_PARK(9),
        AOI_TYPE_FREEWAY_SERVICE(10),
        AOI_TYPE_WATER(11);

        private final int b;

        AoiType(int i) {
            this.b = i;
        }

        public int toInt() {
            return this.b;
        }

        public static AoiType valueOf(int i) {
            switch (i) {
                case 1:
                    return AOI_TYPE_AIRPORT;
                case 2:
                    return AOI_TYPE_RAILWAT_STATION;
                case 3:
                    return AOI_TYPE_SHOPPINGMALL;
                case 4:
                    return AOI_TYPE_GAS_STATION;
                case 5:
                    return AOI_TYPE_SCHOOL;
                case 6:
                    return AOI_TYPE_HOSPITAL;
                case 7:
                    return AOI_TYPE_RESIDENTIAL_DISTRICT;
                case 8:
                    return AOI_TYPE_SCENIC_AREA;
                case 9:
                    return AOI_TYPE_PARK;
                case 10:
                    return AOI_TYPE_FREEWAY_SERVICE;
                case 11:
                    return AOI_TYPE_WATER;
                default:
                    return AOI_TYPE_UNKNOWN;
            }
        }
    }

    public static class a implements Parcelable.Creator<AoiInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiInfo createFromParcel(Parcel parcel) {
            return new AoiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiInfo[] newArray(int i) {
            return new AoiInfo[i];
        }
    }

    public AoiInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAoiName() {
        return this.b;
    }

    public AoiType getAoiType() {
        return this.d;
    }

    public int getNearestDistance() {
        return this.e;
    }

    public int getOrder() {
        return this.f;
    }

    public String getPolygon() {
        return this.c;
    }

    public int getRelation() {
        return this.g;
    }

    public String getUid() {
        return this.f26509a;
    }

    public void setAoiName(String str) {
        this.b = str;
    }

    public void setAoiType(AoiType aoiType) {
        this.d = aoiType;
    }

    public void setNearestDistance(int i) {
        this.e = i;
    }

    public void setOrder(int i) {
        this.f = i;
    }

    public void setPolygon(String str) {
        this.c = str;
    }

    public void setRelation(int i) {
        this.g = i;
    }

    public void setUid(String str) {
        this.f26509a = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiInfo: \n");
        stringBuffer.append("; uid = ");
        stringBuffer.append(this.f26509a);
        stringBuffer.append("; polygon = ");
        stringBuffer.append(this.c);
        stringBuffer.append("; aoiName = ");
        stringBuffer.append(this.b);
        stringBuffer.append("; aoiType = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; nearestDistance= ");
        stringBuffer.append(this.e);
        stringBuffer.append("; order= ");
        stringBuffer.append(this.f);
        stringBuffer.append("; relation= ");
        stringBuffer.append(this.g);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26509a);
        parcel.writeString(this.c);
        parcel.writeString(this.b);
        parcel.writeInt(this.d.ordinal());
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
    }

    public AoiInfo(Parcel parcel) {
        this.c = parcel.readString();
        this.b = parcel.readString();
    }
}
