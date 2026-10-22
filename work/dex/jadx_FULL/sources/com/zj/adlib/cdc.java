package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cdc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        String strG2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                strG = SafeParcelReader.G(parcel, iX);
            } else if (iO != 2) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                strG2 = SafeParcelReader.G(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzax(strG, strG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzax[i];
    }
}
