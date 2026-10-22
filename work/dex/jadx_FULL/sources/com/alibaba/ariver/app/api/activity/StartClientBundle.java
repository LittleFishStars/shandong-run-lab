package com.alibaba.ariver.app.api.activity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StartClientBundle implements Parcelable {
    public static final Parcelable.Creator<StartClientBundle> CREATOR = new Parcelable.Creator<StartClientBundle>() { // from class: com.alibaba.ariver.app.api.activity.StartClientBundle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartClientBundle createFromParcel(Parcel parcel) {
            return new StartClientBundle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartClientBundle[] newArray(int i) {
            return new StartClientBundle[i];
        }
    };
    public String appId;
    public String appType;
    public boolean needWaitIpc;
    public Bundle sceneParams;
    public StartAction startAction;
    public Bundle startParams;
    public long startToken;

    public StartClientBundle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StartClientBundle{appId=" + this.appId + ", appType=" + this.appType + ", startToken=" + this.startToken + ", needWaitIpc=" + this.needWaitIpc + ", startAction=" + this.startAction + ", startParams=" + this.startParams + ", sceneParams=" + this.sceneParams + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appType);
        parcel.writeLong(this.startToken);
        parcel.writeString(this.startAction.name());
        parcel.writeByte(this.needWaitIpc ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.startParams);
        parcel.writeBundle(this.sceneParams);
    }

    public StartClientBundle(Parcel parcel) {
        this.appId = parcel.readString();
        this.appType = parcel.readString();
        this.startToken = parcel.readLong();
        this.startAction = StartAction.valueOf(parcel.readString());
        this.needWaitIpc = parcel.readByte() != 0;
        this.startParams = parcel.readBundle(StartClientBundle.class.getClassLoader());
        this.sceneParams = parcel.readBundle(StartClientBundle.class.getClassLoader());
    }
}
