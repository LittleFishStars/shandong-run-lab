package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLng latLng5;
        LatLngBounds latLngBounds;
        int i = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                        try {
                            latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                            latLng5 = latLng;
                        } catch (BadParcelableException e) {
                            e = e;
                            e.printStackTrace();
                            latLng5 = latLng;
                            latLngBounds = null;
                        }
                    } catch (BadParcelableException e2) {
                        e = e2;
                        latLng = null;
                    }
                } catch (BadParcelableException e3) {
                    e = e3;
                    latLng = null;
                    latLng4 = null;
                }
            } catch (BadParcelableException e4) {
                e = e4;
                latLng = null;
                latLng3 = null;
                latLng4 = latLng3;
                e.printStackTrace();
                latLng5 = latLng;
                latLngBounds = null;
                return new VisibleRegion(i, latLng2, latLng3, latLng4, latLng5, latLngBounds);
            }
        } catch (BadParcelableException e5) {
            e = e5;
            latLng = null;
            latLng2 = null;
            latLng3 = null;
        }
        return new VisibleRegion(i, latLng2, latLng3, latLng4, latLng5, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
