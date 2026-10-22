package com.huachenjie.im.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class IMTokenBean implements Parcelable {
    public static final Parcelable.Creator<IMTokenBean> CREATOR = new Parcelable.Creator<IMTokenBean>() { // from class: com.huachenjie.im.bean.IMTokenBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IMTokenBean createFromParcel(Parcel parcel) {
            return new IMTokenBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IMTokenBean[] newArray(int i) {
            return new IMTokenBean[i];
        }
    };
    private String accid;
    private int muted;
    private String token;

    public IMTokenBean(Parcel parcel) {
        this.token = "";
        this.muted = 0;
        this.accid = "";
        this.token = parcel.readString();
        this.muted = parcel.readInt();
        this.accid = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccid() {
        return this.accid;
    }

    public int getMuted() {
        return this.muted;
    }

    public String getToken() {
        return this.token;
    }

    public void setAccid(String str) {
        this.accid = str;
    }

    public void setMuted(int i) {
        this.muted = i;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
        parcel.writeInt(this.muted);
        parcel.writeString(this.accid);
    }
}
