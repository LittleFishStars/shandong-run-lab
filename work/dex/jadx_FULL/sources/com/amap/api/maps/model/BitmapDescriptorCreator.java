package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null, parcel.readString());
        bitmapDescriptor.mBitmap = parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.f26114a = parcel.readInt();
        bitmapDescriptor.b = parcel.readInt();
        return bitmapDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor[] newArray(int i) {
        return new BitmapDescriptor[i];
    }
}
