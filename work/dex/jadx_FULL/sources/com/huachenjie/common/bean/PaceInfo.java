package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class PaceInfo implements Parcelable {
    public static final Parcelable.Creator<PaceInfo> CREATOR = new Parcelable.Creator<PaceInfo>() { // from class: com.huachenjie.common.bean.PaceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaceInfo createFromParcel(Parcel source) {
            return new PaceInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaceInfo[] newArray(int size) {
            return new PaceInfo[size];
        }
    };
    private boolean isFasePace;
    private int kilometerNo;
    private boolean lessThanKilo;
    private long pace;
    private int percents;
    private long time;

    public PaceInfo() {
        this.lessThanKilo = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getKilometerNo() {
        return this.kilometerNo;
    }

    public long getPace() {
        return this.pace;
    }

    public int getPercents() {
        return this.percents;
    }

    public long getTime() {
        return this.time;
    }

    public boolean isFasePace() {
        return this.isFasePace;
    }

    public boolean isLessThanKilo() {
        return this.lessThanKilo;
    }

    public void setFasePace(boolean fasePace) {
        this.isFasePace = fasePace;
    }

    public void setKilometerNo(int kilometerNo) {
        this.kilometerNo = kilometerNo;
    }

    public void setLessThanKilo(boolean lessThanKilo) {
        this.lessThanKilo = lessThanKilo;
    }

    public void setPace(long pace) {
        this.pace = pace;
    }

    public void setPercents(int percents) {
        this.percents = percents;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.pace);
        parcel.writeLong(this.time);
        parcel.writeInt(this.percents);
        parcel.writeInt(this.kilometerNo);
        parcel.writeByte(this.isFasePace ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.lessThanKilo ? (byte) 1 : (byte) 0);
    }

    public PaceInfo(Parcel in) {
        this.lessThanKilo = true;
        this.pace = in.readLong();
        this.time = in.readLong();
        this.percents = in.readInt();
        this.kilometerNo = in.readInt();
        this.isFasePace = in.readByte() != 0;
        this.lessThanKilo = in.readByte() != 0;
    }
}
