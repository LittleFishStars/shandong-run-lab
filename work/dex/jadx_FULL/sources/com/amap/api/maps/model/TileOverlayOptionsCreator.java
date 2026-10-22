package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TileOverlayOptionsCreator implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        int i = parcel.readInt();
        TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
        boolean z = parcel.readByte() != 0;
        float f = parcel.readFloat();
        int i2 = parcel.readInt();
        int i3 = parcel.readInt();
        String string = parcel.readString();
        boolean z2 = parcel.readByte() != 0;
        boolean z3 = parcel.readByte() != 0;
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions(i, z, f);
        if (tileProvider != null) {
            tileOverlayOptions.tileProvider(tileProvider);
        }
        tileOverlayOptions.memCacheSize(i2);
        tileOverlayOptions.diskCacheSize(i3);
        tileOverlayOptions.diskCacheDir(string);
        tileOverlayOptions.memoryCacheEnabled(z2);
        tileOverlayOptions.diskCacheEnabled(z3);
        return tileOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
