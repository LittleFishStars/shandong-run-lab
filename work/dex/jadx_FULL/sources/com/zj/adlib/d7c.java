package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d7c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        boolean zP = false;
        long jC0 = 0;
        long jC1 = 0;
        long jC2 = 0;
        String strG = null;
        ArrayList<String> arrayListI = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        float fV = 0.0f;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 2:
                    jC0 = SafeParcelReader.c0(parcel, iX);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
                case 4:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    iZ3 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 6:
                    arrayListI = SafeParcelReader.I(parcel, iX);
                    break;
                case 8:
                    jC1 = SafeParcelReader.c0(parcel, iX);
                    break;
                case 10:
                    strG3 = SafeParcelReader.G(parcel, iX);
                    break;
                case 11:
                    iZ2 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 12:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 13:
                    strG4 = SafeParcelReader.G(parcel, iX);
                    break;
                case 14:
                    iZ4 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 15:
                    fV = SafeParcelReader.V(parcel, iX);
                    break;
                case 16:
                    jC2 = SafeParcelReader.c0(parcel, iX);
                    break;
                case 17:
                    strG5 = SafeParcelReader.G(parcel, iX);
                    break;
                case 18:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new WakeLockEvent(iZ, jC0, iZ2, strG, iZ3, arrayListI, strG2, jC1, iZ4, strG3, strG4, fV, jC2, strG5, zP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
