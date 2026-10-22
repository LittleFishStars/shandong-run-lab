package com.zj.adlib;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s5c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        IBinder iBinderY = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                iBinderY = SafeParcelReader.Y(parcel, iX);
            } else if (iO == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, iX, ConnectionResult.CREATOR);
            } else if (iO == 4) {
                zP = SafeParcelReader.P(parcel, iX);
            } else if (iO != 5) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                zP2 = SafeParcelReader.P(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zav(iZ, iBinderY, connectionResult, zP, zP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zav[i];
    }
}
