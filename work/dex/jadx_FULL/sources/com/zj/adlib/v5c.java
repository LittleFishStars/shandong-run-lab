package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zax;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v5c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        Scope[] scopeArr = null;
        int iZ3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                iZ3 = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 3) {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            } else if (iO != 4) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.K(parcel, iX, Scope.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zax(iZ, iZ3, iZ2, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zax[i];
    }
}
