package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class StudentDoneRule implements Parcelable {
    public static final Parcelable.Creator<StudentDoneRule> CREATOR = new Parcelable.Creator<StudentDoneRule>() { // from class: com.huachenjie.common.bean.StudentDoneRule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StudentDoneRule createFromParcel(Parcel source) {
            return new StudentDoneRule(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StudentDoneRule[] newArray(int size) {
            return new StudentDoneRule[size];
        }
    };
    public Integer awardDistance;
    public Integer awardTimes;
    public Float completionRate;
    private long doneDistance;
    private int doneTargetTimes;
    private Integer morningTimes;

    public StudentDoneRule() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDoneDistance() {
        return this.doneDistance;
    }

    public int getDoneTargetTimes() {
        return this.doneTargetTimes;
    }

    public Integer getMorningTimes() {
        return this.morningTimes;
    }

    public void readFromParcel(Parcel source) {
        this.doneDistance = source.readLong();
        this.doneTargetTimes = source.readInt();
        int i = source.readInt();
        this.morningTimes = i <= 0 ? null : Integer.valueOf(i);
    }

    public StudentDoneRule setDoneDistance(long doneDistance) {
        this.doneDistance = doneDistance;
        return this;
    }

    public StudentDoneRule setDoneTargetTimes(int doneTargetTimes) {
        this.doneTargetTimes = doneTargetTimes;
        return this;
    }

    public void setMorningTimes(Integer morningTimes) {
        this.morningTimes = morningTimes;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.doneDistance);
        dest.writeInt(this.doneTargetTimes);
        Integer num = this.morningTimes;
        dest.writeInt(num == null ? -1 : num.intValue());
    }

    public StudentDoneRule(Parcel in) {
        this.doneDistance = in.readLong();
        this.doneTargetTimes = in.readInt();
        int i = in.readInt();
        this.morningTimes = i <= 0 ? null : Integer.valueOf(i);
    }
}
