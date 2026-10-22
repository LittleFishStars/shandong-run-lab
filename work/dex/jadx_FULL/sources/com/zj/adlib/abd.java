package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class abd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrU = null;
        int[] iArrU2 = null;
        boolean zP = false;
        boolean zP2 = false;
        int iZ = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.C(parcel, iX, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
                case 3:
                    zP2 = SafeParcelReader.P(parcel, iX);
                    break;
                case 4:
                    iArrU = SafeParcelReader.u(parcel, iX);
                    break;
                case 5:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 6:
                    iArrU2 = SafeParcelReader.u(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zP, zP2, iArrU, iZ, iArrU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionTelemetryConfiguration[i];
    }
}
