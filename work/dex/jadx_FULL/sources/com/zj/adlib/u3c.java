package com.zj.adlib;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u3c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        String[] strArrH = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                strArrH = SafeParcelReader.H(parcel, iX);
            } else if (iO == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.K(parcel, iX, CursorWindow.CREATOR);
            } else if (iO == 3) {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 4) {
                bundleG = SafeParcelReader.g(parcel, iX);
            } else if (iO != 1000) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                iZ = SafeParcelReader.Z(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        DataHolder dataHolder = new DataHolder(iZ, strArrH, cursorWindowArr, iZ2, bundleG);
        dataHolder.zad();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
