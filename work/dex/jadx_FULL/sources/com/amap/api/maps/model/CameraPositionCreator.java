package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition createFromParcel(Parcel parcel) {
        float f = parcel.readFloat();
        float f2 = parcel.readFloat();
        float f3 = parcel.readFloat();
        return new CameraPosition(new LatLng(f2, f3), parcel.readFloat(), parcel.readFloat(), f);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
