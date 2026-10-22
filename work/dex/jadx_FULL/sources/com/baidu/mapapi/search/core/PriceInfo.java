package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26515a;
    private double b;

    public static class a implements Parcelable.Creator<PriceInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PriceInfo createFromParcel(Parcel parcel) {
            return new PriceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PriceInfo[] newArray(int i) {
            return new PriceInfo[i];
        }
    }

    public PriceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.b;
    }

    public int getTicketType() {
        return this.f26515a;
    }

    public void setTicketPrice(double d) {
        this.b = d;
    }

    public void setTicketType(int i) {
        this.f26515a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26515a);
        parcel.writeDouble(this.b);
    }

    public PriceInfo(Parcel parcel) {
        this.f26515a = parcel.readInt();
        this.b = parcel.readDouble();
    }
}
