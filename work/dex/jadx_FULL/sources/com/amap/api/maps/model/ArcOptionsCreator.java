package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ArcOptionsCreator implements Parcelable.Creator<ArcOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ArcOptions createFromParcel(Parcel parcel) {
        ArcOptions arcOptions = new ArcOptions();
        Bundle bundle = parcel.readBundle();
        arcOptions.point(new LatLng(bundle.getDouble("startlat"), bundle.getDouble("startlng")), new LatLng(bundle.getDouble("passedlat"), bundle.getDouble("passedlng")), new LatLng(bundle.getDouble("endlat"), bundle.getDouble("endlng")));
        arcOptions.strokeWidth(parcel.readFloat());
        arcOptions.strokeColor(parcel.readInt());
        arcOptions.zIndex(parcel.readFloat());
        arcOptions.visible(parcel.readByte() == 1);
        arcOptions.f26113a = parcel.readString();
        return arcOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ArcOptions[] newArray(int i) {
        return new ArcOptions[i];
    }
}
