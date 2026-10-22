package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j0c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        String strG = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                strG = SafeParcelReader.G(parcel, iX);
            } else if (iO != 3) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new FavaDiagnosticsEntity(iZ, strG, iZ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FavaDiagnosticsEntity[i];
    }
}
