package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class GeoFenceDetail implements Parcelable, Comparable<GeoFenceDetail> {
    public static final Parcelable.Creator<GeoFenceDetail> CREATOR = new Parcelable.Creator<GeoFenceDetail>() { // from class: com.huachenjie.common.bean.GeoFenceDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoFenceDetail createFromParcel(Parcel in) {
            return new GeoFenceDetail(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoFenceDetail[] newArray(int size) {
            return new GeoFenceDetail[size];
        }
    };
    private boolean aliTapEnable;
    private List<HCJLatLng> aliTapPointList;
    private int clockMode;
    private long distance;
    private String fenceCode;
    private List<HCJLatLng> fenceList;
    private String fenceName;
    private double lat;
    private double lng;
    private ArrayList<NewOpenTimesBean> newOpenTimes;
    private boolean openStatus;
    private List<String> openTimes;
    private int optionalPointCounts;
    private int optionalPointGoalCounts;
    private int requiredPointCounts;
    private String schoolCode;
    private String schoolName;
    private String subSchoolCode;
    private String subSchoolName;
    private int totalGoalCounts;

    public GeoFenceDetail() {
    }

    @Override // java.lang.Comparable
    public int compareTo(GeoFenceDetail o) {
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<HCJLatLng> getAliTapPointList() {
        return this.aliTapPointList;
    }

    public int getClockMode() {
        return this.clockMode;
    }

    public long getDistance() {
        return this.distance;
    }

    public String getFenceCode() {
        return this.fenceCode;
    }

    public List<HCJLatLng> getFenceList() {
        return this.fenceList;
    }

    public String getFenceName() {
        return this.fenceName;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public ArrayList<NewOpenTimesBean> getNewOpenTimes() {
        return this.newOpenTimes;
    }

    public List<String> getOpenTimes() {
        return this.openTimes;
    }

    public int getOptionalPointCounts() {
        return this.optionalPointCounts;
    }

    public int getOptionalPointGoalCounts() {
        return this.optionalPointGoalCounts;
    }

    public int getRequiredPointCounts() {
        return this.requiredPointCounts;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public String getSubSchoolCode() {
        return this.subSchoolCode;
    }

    public String getSubSchoolName() {
        return this.subSchoolName;
    }

    public int getTotalGoalCounts() {
        return this.totalGoalCounts;
    }

    public boolean isAliTapEnable() {
        return this.aliTapEnable;
    }

    public boolean isOpenStatus() {
        return this.openStatus;
    }

    public void setAliTapEnable(boolean aliTapEnable) {
        this.aliTapEnable = aliTapEnable;
    }

    public void setAliTapPointList(List<HCJLatLng> aliTapPointList) {
        this.aliTapPointList = aliTapPointList;
    }

    public void setClockMode(int clockMode) {
        this.clockMode = clockMode;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void setFenceCode(String fenceCode) {
        this.fenceCode = fenceCode;
    }

    public void setFenceList(List<HCJLatLng> fenceList) {
        this.fenceList = fenceList;
    }

    public void setFenceName(String fenceName) {
        this.fenceName = fenceName;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setNewOpenTimes(ArrayList<NewOpenTimesBean> newOpenTimes) {
        this.newOpenTimes = newOpenTimes;
    }

    public void setOpenStatus(boolean openStatus) {
        this.openStatus = openStatus;
    }

    public void setOpenTimes(List<String> openTimes) {
        this.openTimes = openTimes;
    }

    public void setOptionalPointCounts(int optionalPointCounts) {
        this.optionalPointCounts = optionalPointCounts;
    }

    public void setOptionalPointGoalCounts(int optionalPointGoalCounts) {
        this.optionalPointGoalCounts = optionalPointGoalCounts;
    }

    public void setRequiredPointCounts(int requiredPointCounts) {
        this.requiredPointCounts = requiredPointCounts;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSubSchoolCode(String subSchoolCode) {
        this.subSchoolCode = subSchoolCode;
    }

    public void setSubSchoolName(String subSchoolName) {
        this.subSchoolName = subSchoolName;
    }

    public void setTotalGoalCounts(int totalGoalCounts) {
        this.totalGoalCounts = totalGoalCounts;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.schoolCode);
        parcel.writeString(this.schoolName);
        parcel.writeString(this.subSchoolCode);
        parcel.writeString(this.subSchoolName);
        parcel.writeString(this.fenceCode);
        parcel.writeString(this.fenceName);
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeTypedList(this.fenceList);
        parcel.writeLong(this.distance);
        parcel.writeInt(this.clockMode);
        parcel.writeInt(this.requiredPointCounts);
        parcel.writeInt(this.optionalPointCounts);
        parcel.writeInt(this.optionalPointGoalCounts);
        parcel.writeInt(this.totalGoalCounts);
        parcel.writeStringList(this.openTimes);
        parcel.writeTypedList(this.newOpenTimes);
        parcel.writeByte(this.openStatus ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.aliTapEnable ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.aliTapPointList);
    }

    public GeoFenceDetail(Parcel in) {
        this.schoolCode = in.readString();
        this.schoolName = in.readString();
        this.subSchoolCode = in.readString();
        this.subSchoolName = in.readString();
        this.fenceCode = in.readString();
        this.fenceName = in.readString();
        this.lat = in.readDouble();
        this.lng = in.readDouble();
        Parcelable.Creator<HCJLatLng> creator = HCJLatLng.CREATOR;
        this.fenceList = in.createTypedArrayList(creator);
        this.distance = in.readLong();
        this.clockMode = in.readInt();
        this.requiredPointCounts = in.readInt();
        this.optionalPointCounts = in.readInt();
        this.optionalPointGoalCounts = in.readInt();
        this.totalGoalCounts = in.readInt();
        this.openTimes = in.createStringArrayList();
        this.newOpenTimes = in.createTypedArrayList(NewOpenTimesBean.CREATOR);
        this.openStatus = in.readByte() != 0;
        this.aliTapEnable = in.readByte() != 0;
        this.aliTapPointList = in.createTypedArrayList(creator);
    }
}
