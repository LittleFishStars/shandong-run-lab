package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions createFromParcel(Parcel parcel) {
        AMapOptions aMapOptions = new AMapOptions();
        CameraPosition cameraPosition = (CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader());
        aMapOptions.mapType(parcel.readInt());
        aMapOptions.logoPosition(parcel.readInt());
        aMapOptions.camera(cameraPosition);
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        if (zArrCreateBooleanArray != null && zArrCreateBooleanArray.length >= 6) {
            aMapOptions.rotateGesturesEnabled(zArrCreateBooleanArray[0]);
            aMapOptions.scrollGesturesEnabled(zArrCreateBooleanArray[1]);
            aMapOptions.tiltGesturesEnabled(zArrCreateBooleanArray[2]);
            aMapOptions.zoomGesturesEnabled(zArrCreateBooleanArray[3]);
            aMapOptions.zoomControlsEnabled(zArrCreateBooleanArray[4]);
            aMapOptions.zOrderOnTop(zArrCreateBooleanArray[5]);
            aMapOptions.compassEnabled(zArrCreateBooleanArray[6]);
            aMapOptions.scaleControlsEnabled(zArrCreateBooleanArray[7]);
        }
        return aMapOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions[] newArray(int i) {
        return new AMapOptions[i];
    }
}
