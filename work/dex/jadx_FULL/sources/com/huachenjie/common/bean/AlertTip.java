package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class AlertTip implements Parcelable {
    public static final Parcelable.Creator<AlertTip> CREATOR = new Parcelable.Creator<AlertTip>() { // from class: com.huachenjie.common.bean.AlertTip.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlertTip createFromParcel(Parcel source) {
            return new AlertTip(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlertTip[] newArray(int size) {
            return new AlertTip[size];
        }
    };
    private int code;
    private String content;
    public String subContent;
    public String subTitle;
    private String title;

    public AlertTip() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.content = source.readString();
        this.code = source.readInt();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeInt(this.code);
    }

    public AlertTip(Parcel in) {
        this.title = in.readString();
        this.content = in.readString();
        this.code = in.readInt();
    }
}
