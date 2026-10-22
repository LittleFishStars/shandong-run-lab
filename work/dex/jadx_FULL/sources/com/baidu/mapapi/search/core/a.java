package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0269a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26526a;
    private int b;

    /* JADX INFO: renamed from: com.baidu.mapapi.search.core.a$a, reason: collision with other inner class name */
    public static class C0269a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    public a() {
        this.f26526a = -1;
        this.b = -1;
    }

    public int a() {
        return this.f26526a;
    }

    public int b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26526a);
        parcel.writeInt(this.b);
    }

    public void a(int i) {
        this.f26526a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public a(Parcel parcel) {
        this.f26526a = -1;
        this.b = -1;
        this.f26526a = parcel.readInt();
        this.b = parcel.readInt();
    }
}
