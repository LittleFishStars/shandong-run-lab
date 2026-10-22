package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SportRecord implements Parcelable {
    public static final Parcelable.Creator<SportRecord> CREATOR = new Parcelable.Creator<SportRecord>() { // from class: com.huachenjie.common.bean.SportRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportRecord createFromParcel(Parcel in) {
            return new SportRecord(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportRecord[] newArray(int size) {
            return new SportRecord[size];
        }
    };
    private int archiveState;
    private long calorie;
    private long distance;
    private long duration;
    private long endTime;
    private String formatTime;
    private int frequency;
    private boolean morningFlag;
    private int pace;
    private int recheckStatus;
    private String recordImgUrl;
    private String reward;
    private boolean runActivityFlag;
    private String runRecordCode;
    private int runScene;
    private String semesterCode;
    private int sportType;
    private long startTime;
    private int status;
    protected int sunRunRecordStatus;
    private int totalStep;
    private long validDistance;
    private boolean vision;

    public SportRecord() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getArchiveState() {
        return this.archiveState;
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

    public String getFormatTime() {
        return this.formatTime;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getPace() {
        return this.pace;
    }

    public int getRecheckStatus() {
        return this.recheckStatus;
    }

    public String getRecordImgUrl() {
        return this.recordImgUrl;
    }

    public String getReward() {
        return this.reward;
    }

    public boolean getRunActivityFlag() {
        return this.runActivityFlag;
    }

    public String getRunRecordCode() {
        return this.runRecordCode;
    }

    public int getRunScene() {
        return this.runScene;
    }

    public String getSemesterCode() {
        return this.semesterCode;
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

    public int getSunRunRecordStatus() {
        return this.sunRunRecordStatus;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public long getValidDistance() {
        return this.sportType == 2 ? this.distance : this.validDistance;
    }

    public boolean getVision() {
        return this.vision;
    }

    public boolean isMorningFlag() {
        return this.morningFlag;
    }

    public boolean isValid() {
        if (this.sportType == 2) {
            return this.status == 2;
        }
        int i = this.sunRunRecordStatus;
        return i == 1 || i == 6 || i == 10;
    }

    public void setArchiveState(int archiveState) {
        this.archiveState = archiveState;
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

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setMorningFlag(boolean morningFlag) {
        this.morningFlag = morningFlag;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public void setRecheckStatus(int recheckStatus) {
        this.recheckStatus = recheckStatus;
    }

    public void setRecordImgUrl(String recordImgUrl) {
        this.recordImgUrl = recordImgUrl;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public void setRunActivityFlag(boolean runActivityFlag) {
        this.runActivityFlag = runActivityFlag;
    }

    public void setRunRecordCode(String runRecordCode) {
        this.runRecordCode = runRecordCode;
    }

    public void setRunScene(int runScene) {
        this.runScene = runScene;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
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

    public void setSunRunRecordStatus(int sunRunRecordStatus) {
        this.sunRunRecordStatus = sunRunRecordStatus;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
    }

    public void setValidDistance(long validDistance) {
        this.validDistance = validDistance;
    }

    public void setVision(boolean vision) {
        this.vision = vision;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sportType);
        parcel.writeInt(this.totalStep);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.pace);
        parcel.writeLong(this.calorie);
        parcel.writeInt(this.frequency);
        parcel.writeLong(this.validDistance);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.distance);
        parcel.writeString(this.recordImgUrl);
        parcel.writeInt(this.sunRunRecordStatus);
        parcel.writeString(this.runRecordCode);
        parcel.writeString(this.reward);
        parcel.writeByte(this.runActivityFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.morningFlag ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.archiveState);
        parcel.writeString(this.formatTime);
        parcel.writeInt(this.status);
        parcel.writeByte(this.vision ? (byte) 1 : (byte) 0);
        parcel.writeString(this.semesterCode);
        parcel.writeInt(this.recheckStatus);
        parcel.writeInt(this.runScene);
    }

    public SportRecord(Parcel in) {
        this.sportType = in.readInt();
        this.totalStep = in.readInt();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
        this.pace = in.readInt();
        this.calorie = in.readLong();
        this.frequency = in.readInt();
        this.validDistance = in.readLong();
        this.duration = in.readLong();
        this.distance = in.readLong();
        this.recordImgUrl = in.readString();
        this.sunRunRecordStatus = in.readInt();
        this.runRecordCode = in.readString();
        this.reward = in.readString();
        this.runActivityFlag = in.readByte() != 0;
        this.morningFlag = in.readByte() != 0;
        this.archiveState = in.readInt();
        this.formatTime = in.readString();
        this.status = in.readInt();
        this.vision = in.readByte() != 0;
        this.semesterCode = in.readString();
        this.recheckStatus = in.readInt();
        this.runScene = in.readInt();
    }
}
