package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDataV2 implements Parcelable {
    public static final Parcelable.Creator<RunDataV2> CREATOR = new Parcelable.Creator<RunDataV2>() { // from class: com.huachenjie.run.bean.RunDataV2.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDataV2 createFromParcel(Parcel in) {
            return new RunDataV2(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDataV2[] newArray(int size) {
            return new RunDataV2[size];
        }
    };
    private long distance;
    private long duration;
    private long endTime;
    private int gpsAbnormalTimes;
    private int lastRecordStep;
    private int lastSegmentStep;
    private int lastSegmentStepExceptionNum;
    private int lastSegmentStepIndex;
    private long lastSegmentStepTime;
    private long lastSegmentStrideDistance;
    private int pace;
    private String runRecordCode;
    private int sportType;
    private boolean startCheckPace;
    private long startTime;
    private int status;
    private int totalStep;

    public RunDataV2() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public int getGpsAbnormalTimes() {
        return this.gpsAbnormalTimes;
    }

    public int getLastRecordStep() {
        return this.lastRecordStep;
    }

    public int getLastSegmentStep() {
        return this.lastSegmentStep;
    }

    public int getLastSegmentStepExceptionNum() {
        return this.lastSegmentStepExceptionNum;
    }

    public int getLastSegmentStepIndex() {
        return this.lastSegmentStepIndex;
    }

    public long getLastSegmentStepTime() {
        return this.lastSegmentStepTime;
    }

    public long getLastSegmentStrideDistance() {
        return this.lastSegmentStrideDistance;
    }

    public int getPace() {
        return this.pace;
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

    public int getTotalStep() {
        return this.totalStep;
    }

    public boolean isStartCheckPace() {
        return this.startCheckPace;
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

    public void setGpsAbnormalTimes(int gpsAbnormalTimes) {
        this.gpsAbnormalTimes = gpsAbnormalTimes;
    }

    public void setLastRecordStep(int lastRecordStep) {
        this.lastRecordStep = lastRecordStep;
    }

    public void setLastSegmentStep(int lastSegmentStep) {
        this.lastSegmentStep = lastSegmentStep;
    }

    public void setLastSegmentStepExceptionNum(int lastSegmentStepExceptionNum) {
        this.lastSegmentStepExceptionNum = lastSegmentStepExceptionNum;
    }

    public void setLastSegmentStepIndex(int lastSegmentStepIndex) {
        this.lastSegmentStepIndex = lastSegmentStepIndex;
    }

    public void setLastSegmentStepTime(long lastSegmentStepTime) {
        this.lastSegmentStepTime = lastSegmentStepTime;
    }

    public void setLastSegmentStrideDistance(long lastSegmentStrideDistance) {
        this.lastSegmentStrideDistance = lastSegmentStrideDistance;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public void setRunRecordCode(String runRecordCode) {
        this.runRecordCode = runRecordCode;
    }

    public void setSportType(int sportType) {
        this.sportType = sportType;
    }

    public void setStartCheckPace(boolean startCheckPace) {
        this.startCheckPace = startCheckPace;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sportType);
        parcel.writeInt(this.totalStep);
        parcel.writeInt(this.lastRecordStep);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.pace);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.distance);
        parcel.writeInt(this.status);
        parcel.writeString(this.runRecordCode);
        parcel.writeByte(this.startCheckPace ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.lastSegmentStepIndex);
        parcel.writeLong(this.lastSegmentStrideDistance);
        parcel.writeInt(this.lastSegmentStep);
        parcel.writeLong(this.lastSegmentStepTime);
        parcel.writeInt(this.lastSegmentStepExceptionNum);
        parcel.writeInt(this.gpsAbnormalTimes);
    }

    public RunDataV2(Parcel in) {
        this.sportType = in.readInt();
        this.totalStep = in.readInt();
        this.lastRecordStep = in.readInt();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
        this.pace = in.readInt();
        this.duration = in.readLong();
        this.distance = in.readLong();
        this.status = in.readInt();
        this.runRecordCode = in.readString();
        this.startCheckPace = in.readByte() != 0;
        this.lastSegmentStepIndex = in.readInt();
        this.lastSegmentStrideDistance = in.readLong();
        this.lastSegmentStep = in.readInt();
        this.lastSegmentStepTime = in.readLong();
        this.lastSegmentStepExceptionNum = in.readInt();
        this.gpsAbnormalTimes = in.readInt();
    }
}
