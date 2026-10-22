package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class trc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        long jC0 = 0;
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
                jC0 = SafeParcelReader.c0(parcel, iX);
            } else if (iO != 5) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                iZ4 = SafeParcelReader.Z(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new VisionImageMetadataParcel(iZ, iZ2, iZ3, jC0, iZ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new VisionImageMetadataParcel[i];
    }
}
