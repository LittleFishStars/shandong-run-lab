package com.alibaba.ariver.resource.api.prepare;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PrepareData implements Parcelable {
    public static final Parcelable.Creator<PrepareData> CREATOR = new Parcelable.Creator<PrepareData>() { // from class: com.alibaba.ariver.resource.api.prepare.PrepareData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrepareData createFromParcel(Parcel parcel) {
            return new PrepareData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrepareData[] newArray(int i) {
            return new PrepareData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f24433a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private Bundle p;

    public PrepareData() {
        this.p = new Bundle();
        clear();
    }

    public void clear() {
        this.d = 0L;
        this.c = 0L;
        this.b = 0L;
        this.f24433a = 0L;
        this.h = 0L;
        this.f = 0L;
        this.m = "";
        this.l = "";
        this.o = "";
        this.n = "";
        this.k = "";
        this.j = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.n;
    }

    public String getAppType() {
        return this.i;
    }

    public long getBeginTime() {
        return this.f24433a;
    }

    public Bundle getData() {
        return this.p;
    }

    public long getDownloadEndTime() {
        return this.e;
    }

    public long getDownloadTime() {
        return this.d;
    }

    public long getEndTime() {
        return this.h;
    }

    public long getInstallEndTime() {
        return this.g;
    }

    public long getInstallTime() {
        return this.f;
    }

    public String getNbUrl() {
        return this.m;
    }

    public String getOfflineMode() {
        return this.k;
    }

    public long getRequestBeginTime() {
        return this.b;
    }

    public long getRequestEndTime() {
        return this.c;
    }

    public String getRequestMode() {
        return this.j;
    }

    public String getVersion() {
        return this.o;
    }

    public void setAppId(String str) {
        this.n = str;
    }

    public void setAppType(String str) {
        this.i = str;
    }

    public void setBeginTime(long j) {
        this.f24433a = j;
    }

    public void setDownloadEndTime(long j) {
        this.e = j;
    }

    public void setDownloadTime(long j) {
        long j2 = this.d;
        if (j2 == 0 || j2 > j) {
            this.d = j;
        }
    }

    public void setEndTime(long j) {
        this.h = j;
    }

    public void setInstallEndTime(long j) {
        this.g = j;
    }

    public void setInstallTime(long j) {
        this.f = j;
    }

    public void setNbUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.m = "";
        } else {
            this.m = str;
        }
    }

    public void setOfflineMode(OfflineMode offlineMode) {
        this.k = String.valueOf(offlineMode.value);
    }

    public void setRequestBeginTime(long j) {
        this.b = j;
    }

    public void setRequestEndTime(long j) {
        this.c = j;
    }

    public void setRequestMode(UpdateMode updateMode) {
        this.j = String.valueOf(updateMode.value);
    }

    public void setVersion(String str) {
        this.o = str;
    }

    public String toString() {
        return "PrepareData{beginTime=" + this.f24433a + ", requestBeginTime=" + this.b + ", requestEndTime=" + this.c + ", downloadTime=" + this.d + ", installTime=" + this.f + ", endTime=" + this.h + ", offlineMode=" + this.k + ", errorDetail=" + this.l + ", bundleData=" + this.p + ", nbUrl='" + this.m + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.i);
        parcel.writeLong(this.f24433a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeBundle(this.p);
    }

    public PrepareData(Parcel parcel) {
        this.p = new Bundle();
        this.i = parcel.readString();
        this.f24433a = parcel.readLong();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        this.h = parcel.readLong();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readBundle();
    }
}
