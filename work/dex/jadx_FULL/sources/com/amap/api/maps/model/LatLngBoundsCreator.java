package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        int i = parcel.readInt();
        LatLng latLng2 = null;
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (BadParcelableException e2) {
            e = e2;
            latLng = null;
        }
        return new LatLngBounds(i, latLng, latLng2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
