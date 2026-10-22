package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class InvalidReason implements Parcelable {
    public static final Parcelable.Creator<InvalidReason> CREATOR = new Parcelable.Creator<InvalidReason>() { // from class: com.huachenjie.common.bean.InvalidReason.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InvalidReason createFromParcel(Parcel source) {
            return new InvalidReason(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InvalidReason[] newArray(int size) {
            return new InvalidReason[size];
        }
    };
    private String invalidDetail;
    private int invalidType;

    public InvalidReason() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getInvalidDetail() {
        return this.invalidDetail;
    }

    public int getInvalidType() {
        return this.invalidType;
    }

    public void setInvalidDetail(String invalidDetail) {
        this.invalidDetail = invalidDetail;
    }

    public void setInvalidType(int invalidType) {
        this.invalidType = invalidType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.invalidType);
        dest.writeString(this.invalidDetail);
    }

    public InvalidReason(Parcel in) {
        this.invalidType = in.readInt();
        this.invalidDetail = in.readString();
    }
}
