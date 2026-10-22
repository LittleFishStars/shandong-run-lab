package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLTFOverlayOptionsCreator implements Parcelable.Creator<GLTFOverlayOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions[] newArray(int i) {
        return new GLTFOverlayOptions[0];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions createFromParcel(Parcel parcel) {
        LatLng latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        double d = parcel.readDouble();
        double d2 = parcel.readDouble();
        double d3 = parcel.readDouble();
        GLTFOverlayOptions gLTFOverlayOptions = new GLTFOverlayOptions(latLng, parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readArrayList(GLTFResourceIterm.class.getClassLoader()));
        gLTFOverlayOptions.rotationDegree(d2, d3, d);
        return gLTFOverlayOptions;
    }
}
