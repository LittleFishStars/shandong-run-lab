package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FaceCheckConfig implements Parcelable {
    public static final Parcelable.Creator<FaceCheckConfig> CREATOR = new Parcelable.Creator<FaceCheckConfig>() { // from class: com.huachenjie.common.bean.FaceCheckConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FaceCheckConfig createFromParcel(Parcel in) {
            return new FaceCheckConfig(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FaceCheckConfig[] newArray(int size) {
            return new FaceCheckConfig[size];
        }
    };
    private int lowerLimit;
    private int upperLimit;

    public FaceCheckConfig(Parcel in) {
        this.lowerLimit = in.readInt();
        this.upperLimit = in.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLowerLimit() {
        return this.lowerLimit;
    }

    public int getUpperLimit() {
        return this.upperLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(this.lowerLimit);
        dest.writeInt(this.upperLimit);
    }
}
