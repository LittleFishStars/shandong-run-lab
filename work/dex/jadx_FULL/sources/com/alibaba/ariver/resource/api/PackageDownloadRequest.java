package com.alibaba.ariver.resource.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PackageDownloadRequest implements Parcelable {
    public static final Parcelable.Creator<PackageDownloadRequest> CREATOR = new Parcelable.Creator<PackageDownloadRequest>() { // from class: com.alibaba.ariver.resource.api.PackageDownloadRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageDownloadRequest createFromParcel(Parcel parcel) {
            return new PackageDownloadRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PackageDownloadRequest[] newArray(int i) {
            return new PackageDownloadRequest[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24417a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;

    public PackageDownloadRequest() {
    }

    public static boolean isInDownloadPath(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("nebulaDownload");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.d;
    }

    public String getDownloadUrl() {
        return this.f24417a;
    }

    public String getFileName() {
        return this.b;
    }

    public String getFilePath() {
        return this.c;
    }

    public String getVersion() {
        return this.e;
    }

    public boolean isAutoInstall() {
        return this.f;
    }

    public boolean isUrgentResource() {
        return this.g;
    }

    public void setAppId(String str) {
        this.d = str;
    }

    public void setAutoInstall(boolean z) {
        this.f = z;
    }

    public void setDownloadUrl(String str) {
        this.f24417a = str;
    }

    public void setFileName(String str) {
        this.b = str;
    }

    public void setFilePath(String str) {
        this.c = str;
    }

    public void setIsUrgentResource(boolean z) {
        this.g = z;
    }

    public void setVersion(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24417a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
    }

    public PackageDownloadRequest(Parcel parcel) {
        this.f24417a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
    }
}
