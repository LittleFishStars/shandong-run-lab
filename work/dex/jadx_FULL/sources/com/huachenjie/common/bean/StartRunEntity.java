package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class StartRunEntity implements Parcelable {
    public static final Parcelable.Creator<StartRunEntity> CREATOR = new Parcelable.Creator<StartRunEntity>() { // from class: com.huachenjie.common.bean.StartRunEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartRunEntity createFromParcel(Parcel in) {
            return new StartRunEntity(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartRunEntity[] newArray(int size) {
            return new StartRunEntity[size];
        }
    };
    public ActivityRunDetailBean activityInfo;
    private int cheatLevel;
    private int clockMode;
    private String runRecordCode;
    private List<TargetPoints> targetPoints;
    private boolean whiteFlag;

    public StartRunEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityRunDetailBean getActivityInfo() {
        return this.activityInfo;
    }

    public int getCheatLevel() {
        return this.cheatLevel;
    }

    public int getClockMode() {
        return this.clockMode;
    }

    public String getRunRecordCode() {
        return this.runRecordCode;
    }

    public List<TargetPoints> getTargetPoints() {
        return this.targetPoints;
    }

    public boolean isRunActivityFlag() {
        return this.activityInfo != null;
    }

    public boolean isWhiteFlag() {
        return this.whiteFlag;
    }

    public void setActivityInfo(ActivityRunDetailBean activityInfo) {
        this.activityInfo = activityInfo;
    }

    public void setCheatLevel(int cheatLevel) {
        this.cheatLevel = cheatLevel;
    }

    public void setClockMode(int clockMode) {
        this.clockMode = clockMode;
    }

    public void setRunRecordCode(String runRecordCode) {
        this.runRecordCode = runRecordCode;
    }

    public void setTargetPoints(List<TargetPoints> targetPoints) {
        this.targetPoints = targetPoints;
    }

    public void setWhiteFlag(boolean whiteFlag) {
        this.whiteFlag = whiteFlag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.runRecordCode);
        parcel.writeTypedList(this.targetPoints);
        parcel.writeInt(this.clockMode);
        parcel.writeInt(this.cheatLevel);
        parcel.writeParcelable(this.activityInfo, i);
        parcel.writeByte(this.whiteFlag ? (byte) 1 : (byte) 0);
    }

    public StartRunEntity(Parcel in) {
        this.runRecordCode = in.readString();
        this.targetPoints = in.createTypedArrayList(TargetPoints.CREATOR);
        this.clockMode = in.readInt();
        this.cheatLevel = in.readInt();
        this.activityInfo = (ActivityRunDetailBean) in.readParcelable(ActivityRunDetailBean.class.getClassLoader());
        this.whiteFlag = in.readByte() != 0;
    }
}
