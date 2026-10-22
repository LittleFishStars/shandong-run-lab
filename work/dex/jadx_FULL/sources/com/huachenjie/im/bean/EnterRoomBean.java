package com.huachenjie.im.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class EnterRoomBean implements Parcelable {
    public static final Parcelable.Creator<EnterRoomBean> CREATOR = new Parcelable.Creator<EnterRoomBean>() { // from class: com.huachenjie.im.bean.EnterRoomBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EnterRoomBean createFromParcel(Parcel parcel) {
            return new EnterRoomBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EnterRoomBean[] newArray(int i) {
            return new EnterRoomBean[i];
        }
    };
    private String enterTeamTime;

    public EnterRoomBean(Parcel parcel) {
        this.enterTeamTime = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEnterTeamTime() {
        return this.enterTeamTime;
    }

    public void setEnterTeamTime(String str) {
        this.enterTeamTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.enterTeamTime);
    }
}
