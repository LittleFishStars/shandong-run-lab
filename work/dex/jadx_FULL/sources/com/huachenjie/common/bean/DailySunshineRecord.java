package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DailySunshineRecord implements Parcelable {
    public static final Parcelable.Creator<DailySunshineRecord> CREATOR = new Parcelable.Creator<DailySunshineRecord>() { // from class: com.huachenjie.common.bean.DailySunshineRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DailySunshineRecord createFromParcel(Parcel source) {
            return new DailySunshineRecord(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DailySunshineRecord[] newArray(int size) {
            return new DailySunshineRecord[size];
        }
    };
    private List<SportRecord> list;
    private String monthDate;
    private long totalCalorie;
    private long totalTime;

    public DailySunshineRecord() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<SportRecord> getList() {
        return this.list;
    }

    public String getMonthDate() {
        return this.monthDate;
    }

    public long getTotalCalorie() {
        return this.totalCalorie;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public void setList(List<SportRecord> list) {
        this.list = list;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }

    public void setTotalCalorie(long totalCalorie) {
        this.totalCalorie = totalCalorie;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.monthDate);
        dest.writeLong(this.totalTime);
        dest.writeLong(this.totalCalorie);
        dest.writeTypedList(this.list);
    }

    public DailySunshineRecord(Parcel in) {
        this.monthDate = in.readString();
        this.totalTime = in.readLong();
        this.totalCalorie = in.readLong();
        this.list = in.createTypedArrayList(SportRecord.CREATOR);
    }
}
