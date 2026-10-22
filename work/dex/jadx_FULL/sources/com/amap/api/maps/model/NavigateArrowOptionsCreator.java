package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NavigateArrowOptionsCreator implements Parcelable.Creator<NavigateArrowOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NavigateArrowOptions createFromParcel(Parcel parcel) {
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float f = parcel.readFloat();
        int i = parcel.readInt();
        int i2 = parcel.readInt();
        float f2 = parcel.readFloat();
        boolean z = parcel.readByte() == 1;
        boolean z2 = parcel.readByte() == 1;
        navigateArrowOptions.addAll(arrayList);
        navigateArrowOptions.width(f);
        navigateArrowOptions.topColor(i);
        navigateArrowOptions.sideColor(i2);
        navigateArrowOptions.zIndex(f2);
        navigateArrowOptions.visible(z);
        navigateArrowOptions.f26126a = parcel.readString();
        navigateArrowOptions.set3DModel(z2);
        return navigateArrowOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NavigateArrowOptions[] newArray(int i) {
        return new NavigateArrowOptions[i];
    }
}
