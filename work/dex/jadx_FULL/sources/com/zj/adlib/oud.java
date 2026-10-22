package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class oud implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        long jC0 = 0;
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 3) {
                iZ3 = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 4) {
                iZ4 = SafeParcelReader.Z(parcel, iX);
            } else if (iO != 5) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                jC0 = SafeParcelReader.c0(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzwc(iZ, iZ2, iZ3, iZ4, jC0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzwc[i];
    }
}
