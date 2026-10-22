package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u4c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        long jC0 = 0;
        long jC1 = 0;
        String strG = null;
        String strG2 = null;
        int iZ5 = -1;
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
                    iZ3 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 4:
                    jC0 = SafeParcelReader.c0(parcel, iX);
                    break;
                case 5:
                    jC1 = SafeParcelReader.c0(parcel, iX);
                    break;
                case 6:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 7:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 8:
                    iZ4 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 9:
                    iZ5 = SafeParcelReader.Z(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new MethodInvocation(iZ, iZ2, iZ3, jC0, jC1, strG, strG2, iZ4, iZ5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new MethodInvocation[i];
    }
}
