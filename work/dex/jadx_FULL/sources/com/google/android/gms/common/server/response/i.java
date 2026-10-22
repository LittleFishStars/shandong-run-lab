package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        boolean zP = false;
        int iZ3 = 0;
        boolean zP2 = false;
        int iZ4 = 0;
        String strG = null;
        String strG2 = null;
        zaa zaaVar = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 2:
                    iZ2 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 3:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
                case 4:
                    iZ3 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 5:
                    zP2 = SafeParcelReader.P(parcel, iX);
                    break;
                case 6:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 7:
                    iZ4 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 8:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.C(parcel, iX, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new FastJsonResponse.Field(iZ, iZ2, zP, iZ3, zP2, strG, iZ4, strG2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
