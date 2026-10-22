package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class VersionUpgrade implements Parcelable {
    public static final Parcelable.Creator<VersionUpgrade> CREATOR = new Parcelable.Creator<VersionUpgrade>() { // from class: com.huachenjie.common.bean.VersionUpgrade.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VersionUpgrade createFromParcel(Parcel source) {
            return new VersionUpgrade(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VersionUpgrade[] newArray(int size) {
            return new VersionUpgrade[size];
        }
    };
    private String downloadUrl;
    private boolean forceUpdate;
    private boolean haveUpdate;
    private String newVersion;
    private String supportVersion;
    private int tipFrequency;
    private String updateDescription;
    private String updateTitle;

    public VersionUpgrade() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getNewVersion() {
        return this.newVersion;
    }

    public String getSupportVersion() {
        return this.supportVersion;
    }

    public int getTipFrequency() {
        return this.tipFrequency;
    }

    public String getUpdateDescription() {
        return this.updateDescription;
    }

    public String getUpdateTitle() {
        return this.updateTitle;
    }

    public boolean isForceUpdate() {
        return this.forceUpdate;
    }

    public boolean isHaveUpdate() {
        return this.haveUpdate;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public void setHaveUpdate(boolean haveUpdate) {
        this.haveUpdate = haveUpdate;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public void setSupportVersion(String supportVersion) {
        this.supportVersion = supportVersion;
    }

    public void setTipFrequency(int tipFrequency) {
        this.tipFrequency = tipFrequency;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public void setUpdateTitle(String updateTitle) {
        this.updateTitle = updateTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.newVersion);
        parcel.writeString(this.supportVersion);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.updateTitle);
        parcel.writeString(this.updateDescription);
        parcel.writeByte(this.haveUpdate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceUpdate ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.tipFrequency);
    }

    public VersionUpgrade(Parcel in) {
        this.newVersion = in.readString();
        this.supportVersion = in.readString();
        this.downloadUrl = in.readString();
        this.updateTitle = in.readString();
        this.updateDescription = in.readString();
        this.haveUpdate = in.readByte() != 0;
        this.forceUpdate = in.readByte() != 0;
        this.tipFrequency = in.readInt();
    }
}
