package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ParcelItem implements Parcelable {
    public static final Parcelable.Creator<ParcelItem> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f26798a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.f26798a;
    }

    public void setBundle(Bundle bundle) {
        this.f26798a = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f26798a);
    }

    public static class a implements Parcelable.Creator<ParcelItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelItem createFromParcel(Parcel parcel) {
            ParcelItem parcelItem = new ParcelItem();
            parcelItem.setBundle(parcel.readBundle());
            return parcelItem;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelItem[] newArray(int i) {
            return new ParcelItem[i];
        }
    }
}
