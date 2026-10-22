package com.zj.adlib;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.zzo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qld implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        IBinder iBinderY = null;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                strG = SafeParcelReader.G(parcel, iX);
            } else if (iO == 2) {
                zP = SafeParcelReader.P(parcel, iX);
            } else if (iO == 3) {
                zP2 = SafeParcelReader.P(parcel, iX);
            } else if (iO == 4) {
                iBinderY = SafeParcelReader.Y(parcel, iX);
            } else if (iO != 5) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                zP3 = SafeParcelReader.P(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzo(strG, zP, zP2, iBinderY, zP3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
