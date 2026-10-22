package com.huachenjie.im.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatUserBean implements Parcelable {
    public static final Parcelable.Creator<ChatUserBean> CREATOR = new Parcelable.Creator<ChatUserBean>() { // from class: com.huachenjie.im.bean.ChatUserBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatUserBean createFromParcel(Parcel parcel) {
            return new ChatUserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChatUserBean[] newArray(int i) {
            return new ChatUserBean[i];
        }
    };
    private String appUserCode;
    private String schoolCode;
    private String studentCode;

    public ChatUserBean(Parcel parcel) {
        this.schoolCode = parcel.readString();
        this.studentCode = parcel.readString();
        this.appUserCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppUserCode() {
        return this.appUserCode;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public String getStudentCode() {
        return this.studentCode;
    }

    public void setAppUserCode(String str) {
        this.appUserCode = str;
    }

    public void setSchoolCode(String str) {
        this.schoolCode = str;
    }

    public void setStudentCode(String str) {
        this.studentCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.schoolCode);
        parcel.writeString(this.studentCode);
        parcel.writeString(this.appUserCode);
    }
}
