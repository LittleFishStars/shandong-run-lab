package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle bundle = parcel.readBundle();
        circleOptions.center(new LatLng(bundle.getDouble("lat"), bundle.getDouble("lng")));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readFloat());
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.f26117a = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, BaseHoleOptions.class.getClassLoader());
        circleOptions.addHoles(arrayList);
        circleOptions.setStrokeDottedLineType(parcel.readInt());
        circleOptions.usePolylineStroke(parcel.readByte() == 1);
        return circleOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
