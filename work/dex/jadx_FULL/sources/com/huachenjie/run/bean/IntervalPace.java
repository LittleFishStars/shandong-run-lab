package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Entity(tableName = "run_pace")
public class IntervalPace implements Parcelable {
    public static final Parcelable.Creator<IntervalPace> CREATOR = new Parcelable.Creator<IntervalPace>() { // from class: com.huachenjie.run.bean.IntervalPace.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntervalPace createFromParcel(Parcel source) {
            return new IntervalPace(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntervalPace[] newArray(int size) {
            return new IntervalPace[size];
        }
    };
    private long distance;
    private long endDistance;
    private int endStepCount;
    private long endTime;

    @PrimaryKey(autoGenerate = true)
    @JSONField(name = "index")
    private int id;

    @ColumnInfo(name = "is_uploaded")
    @JSONField(serialize = false)
    private boolean isUploaded;

    @JSONField(serialize = false)
    private boolean isValid;

    @JSONField(serialize = false)
    private String runCode;
    private long startDistance;
    private int startStepCount;
    private long startTime;
    private int stepCount;
    private long time;

    @Ignore
    public IntervalPace() {
        this.isValid = false;
        this.isUploaded = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getEndDistance() {
        return this.endDistance;
    }

    public int getEndStepCount() {
        return this.endStepCount;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getId() {
        return this.id;
    }

    public String getRunCode() {
        return this.runCode;
    }

    public long getStartDistance() {
        return this.startDistance;
    }

    public int getStartStepCount() {
        return this.startStepCount;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStepCount() {
        return this.stepCount;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isUploaded() {
        return this.isUploaded;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.runCode = source.readString();
        this.startTime = source.readLong();
        this.endTime = source.readLong();
        this.startDistance = source.readLong();
        this.endDistance = source.readLong();
        this.startStepCount = source.readInt();
        this.endStepCount = source.readInt();
        this.time = source.readLong();
        this.distance = source.readLong();
        this.stepCount = source.readInt();
        this.isValid = source.readByte() != 0;
        this.isUploaded = source.readByte() != 0;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void setEndDistance(long endDistance) {
        this.endDistance = endDistance;
        this.distance = endDistance - this.startDistance;
    }

    public void setEndStepCount(int endStepCount) {
        this.endStepCount = endStepCount;
        this.stepCount = endStepCount - this.startStepCount;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
        this.time = endTime - this.startTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }

    public void setStartDistance(long startDistance) {
        this.startDistance = startDistance;
    }

    public void setStartStepCount(int startStepCount) {
        this.startStepCount = startStepCount;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setUploaded(boolean uploaded) {
        this.isUploaded = uploaded;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.runCode);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeLong(this.startDistance);
        parcel.writeLong(this.endDistance);
        parcel.writeInt(this.startStepCount);
        parcel.writeInt(this.endStepCount);
        parcel.writeLong(this.time);
        parcel.writeLong(this.distance);
        parcel.writeInt(this.stepCount);
        parcel.writeByte(this.isValid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isUploaded ? (byte) 1 : (byte) 0);
    }

    @Ignore
    public IntervalPace(long time, long distance) {
        this.isValid = false;
        this.isUploaded = false;
        this.time = time;
        this.distance = distance;
    }

    @Ignore
    public IntervalPace(long time, long distance, int step) {
        this.isValid = false;
        this.isUploaded = false;
        this.time = time;
        this.distance = distance;
        this.stepCount = step;
    }

    public IntervalPace(int id, String runCode, long startTime, long endTime, long startDistance, long endDistance, int startStepCount, int endStepCount, long time, long distance, int stepCount, boolean isValid, boolean isUploaded) {
        this.id = id;
        this.runCode = runCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDistance = startDistance;
        this.endDistance = endDistance;
        this.startStepCount = startStepCount;
        this.endStepCount = endStepCount;
        this.time = time;
        this.distance = distance;
        this.stepCount = stepCount;
        this.isValid = isValid;
        this.isUploaded = isUploaded;
    }

    public IntervalPace(Parcel in) {
        this.isValid = false;
        this.isUploaded = false;
        this.id = in.readInt();
        this.runCode = in.readString();
        this.startTime = in.readLong();
        this.endTime = in.readLong();
        this.startDistance = in.readLong();
        this.endDistance = in.readLong();
        this.startStepCount = in.readInt();
        this.endStepCount = in.readInt();
        this.time = in.readLong();
        this.distance = in.readLong();
        this.stepCount = in.readInt();
        this.isValid = in.readByte() != 0;
        this.isUploaded = in.readByte() != 0;
    }
}
