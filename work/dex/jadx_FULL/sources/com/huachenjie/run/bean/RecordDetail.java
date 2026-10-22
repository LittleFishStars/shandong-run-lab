package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.common.bean.TargetPoints;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RecordDetail implements Parcelable {
    public static final Parcelable.Creator<RecordDetail> CREATOR = new Parcelable.Creator<RecordDetail>() { // from class: com.huachenjie.run.bean.RecordDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordDetail createFromParcel(Parcel source) {
            return new RecordDetail(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordDetail[] newArray(int size) {
            return new RecordDetail[size];
        }
    };
    private int appealButtonStatus;
    private int auditStatus;
    private long calorie;
    private long distance;
    private long duration;
    private long endTime;
    private int frequency;
    private List<Float> frequencyGroup;
    private long pace;
    private List<HCJLatLng> points;
    private String runRecordCode;
    private int sportType;
    private long startTime;
    private int status;
    private List<TargetPoints> targetPoints;
    private int totalStep;
    private long validDistance;

    public RecordDetail() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAppealButtonStatus() {
        return this.appealButtonStatus;
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public long getCalorie() {
        return this.calorie;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public List<Float> getFrequencyGroup() {
        return this.frequencyGroup;
    }

    public long getPace() {
        return this.pace;
    }

    public List<HCJLatLng> getPoints() {
        return this.points;
    }

    public String getRunRecordCode() {
        return this.runRecordCode;
    }

    public int getSportType() {
        return this.sportType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public List<TargetPoints> getTargetPoints() {
        return this.targetPoints;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public long getValidDistance() {
        return this.validDistance;
    }

    public void setAppealButtonStatus(int appealButtonStatus) {
        this.appealButtonStatus = appealButtonStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setCalorie(long calorie) {
        this.calorie = calorie;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setFrequencyGroup(List<Float> frequencyGroup) {
        this.frequencyGroup = frequencyGroup;
    }

    public void setPace(long pace) {
        this.pace = pace;
    }

    public void setPoints(List<HCJLatLng> points) {
        this.points = points;
    }

    public void setRunRecordCode(String runRecordCode) {
        this.runRecordCode = runRecordCode;
    }

    public void setSportType(int sportType) {
        this.sportType = sportType;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTargetPoints(List<TargetPoints> targetPoints) {
        this.targetPoints = targetPoints;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
    }

    public void setValidDistance(long validDistance) {
        this.validDistance = validDistance;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.sportType);
        dest.writeInt(this.appealButtonStatus);
        dest.writeInt(this.auditStatus);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
        dest.writeLong(this.pace);
        dest.writeLong(this.calorie);
        dest.writeInt(this.frequency);
        dest.writeLong(this.validDistance);
        dest.writeLong(this.duration);
        dest.writeLong(this.distance);
        dest.writeInt(this.totalStep);
        dest.writeInt(this.status);
        dest.writeString(this.runRecordCode);
        dest.writeTypedList(this.points);
        dest.writeList(this.frequencyGroup);
        dest.writeTypedList(this.targetPoints);
    }

    public RecordDetail(Parcel in) {
        this.sportType = in.readInt();
        this.appealButtonStatus = in.readInt();
        this.auditStatus = in.readInt();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
        this.pace = in.readLong();
        this.calorie = in.readLong();
        this.frequency = in.readInt();
        this.validDistance = in.readLong();
        this.duration = in.readLong();
        this.distance = in.readLong();
        this.totalStep = in.readInt();
        this.status = in.readInt();
        this.runRecordCode = in.readString();
        this.points = in.createTypedArrayList(HCJLatLng.CREATOR);
        ArrayList arrayList = new ArrayList();
        this.frequencyGroup = arrayList;
        in.readList(arrayList, Float.class.getClassLoader());
        this.targetPoints = in.createTypedArrayList(TargetPoints.CREATOR);
    }
}
