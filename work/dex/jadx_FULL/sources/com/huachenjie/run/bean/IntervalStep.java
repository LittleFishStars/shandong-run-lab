package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Entity(tableName = "run_step")
public class IntervalStep implements Parcelable {
    public static final Parcelable.Creator<IntervalStep> CREATOR = new Parcelable.Creator<IntervalStep>() { // from class: com.huachenjie.run.bean.IntervalStep.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntervalStep createFromParcel(Parcel source) {
            return new IntervalStep(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntervalStep[] newArray(int size) {
            return new IntervalStep[size];
        }
    };
    private int endStep;
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
    private int startStep;
    private long startTime;
    private int step;
    private long time;

    @Ignore
    public IntervalStep() {
        this.isValid = false;
        this.isUploaded = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEndStep() {
        return this.endStep;
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

    public int getStartStep() {
        return this.startStep;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStep() {
        return this.step;
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
        this.startStep = source.readInt();
        this.endTime = source.readLong();
        this.endStep = source.readInt();
        this.time = source.readLong();
        this.step = source.readInt();
        this.isValid = source.readByte() != 0;
        this.isUploaded = source.readByte() != 0;
    }

    public void setEndStep(int endStep) {
        this.endStep = endStep;
        this.step = endStep - this.startStep;
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

    public void setStartStep(int startStep) {
        this.startStep = startStep;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStep(int step) {
        this.step = step;
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

    public String toString() {
        return "IntervalStep{id=" + this.id + ", startTime=" + this.startTime + ", startStep=" + this.startStep + ", endTime=" + this.endTime + ", endStep=" + this.endStep + ", time=" + this.time + ", step=" + this.step + ", isValid=" + this.isValid + ", isUploaded=" + this.isUploaded + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.runCode);
        parcel.writeLong(this.startTime);
        parcel.writeInt(this.startStep);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.endStep);
        parcel.writeLong(this.time);
        parcel.writeInt(this.step);
        parcel.writeByte(this.isValid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isUploaded ? (byte) 1 : (byte) 0);
    }

    @Ignore
    public IntervalStep(long time, int step) {
        this.isValid = false;
        this.isUploaded = false;
        this.time = time;
        this.step = step;
    }

    @Ignore
    public IntervalStep(long startTime, int startStep, long endTime, int endStep) {
        this.isValid = false;
        this.isUploaded = false;
        this.startTime = startTime;
        this.startStep = startStep;
        this.endTime = endTime;
        this.endStep = endStep;
        this.time = endTime - startTime;
        this.step = endStep - startStep;
    }

    public IntervalStep(int id, String runCode, long startTime, int startStep, long endTime, int endStep, long time, int step, boolean isValid, boolean isUploaded) {
        this.id = id;
        this.runCode = runCode;
        this.startTime = startTime;
        this.startStep = startStep;
        this.endTime = endTime;
        this.endStep = endStep;
        this.time = time;
        this.step = step;
        this.isValid = isValid;
        this.isUploaded = isUploaded;
    }

    public IntervalStep(Parcel in) {
        this.isValid = false;
        this.isUploaded = false;
        this.id = in.readInt();
        this.runCode = in.readString();
        this.startTime = in.readLong();
        this.startStep = in.readInt();
        this.endTime = in.readLong();
        this.endStep = in.readInt();
        this.time = in.readLong();
        this.step = in.readInt();
        this.isValid = in.readByte() != 0;
        this.isUploaded = in.readByte() != 0;
    }
}
