package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ClockInMode implements Parcelable {
    public static final Parcelable.Creator<ClockInMode> CREATOR = new Parcelable.Creator<ClockInMode>() { // from class: com.huachenjie.common.bean.ClockInMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClockInMode createFromParcel(Parcel source) {
            return new ClockInMode(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClockInMode[] newArray(int size) {
            return new ClockInMode[size];
        }
    };
    private int clockMode;
    private int optionalPointCounts;
    private int optionalPointGoalCounts;
    private int requiredPointCounts;
    private int totalGoalCounts;

    public ClockInMode() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getClockMode() {
        return this.clockMode;
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

    public int getTotalGoalCounts() {
        return this.totalGoalCounts;
    }

    public void readFromParcel(Parcel source) {
        this.clockMode = source.readInt();
        this.requiredPointCounts = source.readInt();
        this.optionalPointCounts = source.readInt();
        this.optionalPointGoalCounts = source.readInt();
        this.totalGoalCounts = source.readInt();
    }

    public void setClockMode(int clockMode) {
        this.clockMode = clockMode;
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

    public void setTotalGoalCounts(int totalGoalCounts) {
        this.totalGoalCounts = totalGoalCounts;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.clockMode);
        dest.writeInt(this.requiredPointCounts);
        dest.writeInt(this.optionalPointCounts);
        dest.writeInt(this.optionalPointGoalCounts);
        dest.writeInt(this.totalGoalCounts);
    }

    public ClockInMode(Parcel in) {
        this.clockMode = in.readInt();
        this.requiredPointCounts = in.readInt();
        this.optionalPointCounts = in.readInt();
        this.optionalPointGoalCounts = in.readInt();
        this.totalGoalCounts = in.readInt();
    }
}
