package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f9c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        int iZ2 = 0;
        int iZ3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                zP = SafeParcelReader.P(parcel, iX);
            } else if (iO == 3) {
                zP2 = SafeParcelReader.P(parcel, iX);
            } else if (iO == 4) {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            } else if (iO != 5) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                iZ3 = SafeParcelReader.Z(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new RootTelemetryConfiguration(iZ, zP, zP2, iZ2, iZ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new RootTelemetryConfiguration[i];
    }
}
