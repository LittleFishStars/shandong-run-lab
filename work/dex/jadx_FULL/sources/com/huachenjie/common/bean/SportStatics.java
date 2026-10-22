package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SportStatics implements Parcelable {
    public static final Parcelable.Creator<SportStatics> CREATOR = new Parcelable.Creator<SportStatics>() { // from class: com.huachenjie.common.bean.SportStatics.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportStatics createFromParcel(Parcel source) {
            return new SportStatics(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportStatics[] newArray(int size) {
            return new SportStatics[size];
        }
    };
    private int bestPace;
    private int checkDays;
    private long totalCalorie;
    private long totalDistance;
    private long totalDuration;

    public SportStatics() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBestPace() {
        return this.bestPace;
    }

    public int getCheckDays() {
        return this.checkDays;
    }

    public long getTotalCalorie() {
        return this.totalCalorie;
    }

    public long getTotalDistance() {
        return this.totalDistance;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    public void setBestPace(int bestPace) {
        this.bestPace = bestPace;
    }

    public void setCheckDays(int checkDays) {
        this.checkDays = checkDays;
    }

    public void setTotalCalorie(long totalCalorie) {
        this.totalCalorie = totalCalorie;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.totalCalorie);
        dest.writeInt(this.bestPace);
        dest.writeLong(this.totalDuration);
        dest.writeInt(this.checkDays);
        dest.writeLong(this.totalDistance);
    }

    public SportStatics(Parcel in) {
        this.totalCalorie = in.readLong();
        this.bestPace = in.readInt();
        this.totalDuration = in.readLong();
        this.checkDays = in.readInt();
        this.totalDistance = in.readLong();
    }
}
