package com.zj.adlib;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ibc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        String strG = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                strG = SafeParcelReader.G(parcel, iX);
            } else if (iO == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.C(parcel, iX, PendingIntent.CREATOR);
            } else if (iO == 4) {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, iX, ConnectionResult.CREATOR);
            } else if (iO != 1000) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                iZ = SafeParcelReader.Z(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new Status(iZ, iZ2, strG, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
