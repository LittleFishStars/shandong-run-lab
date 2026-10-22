package com.zj.adlib;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f0c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                iZ = SafeParcelReader.Z(parcel, iX);
            } else if (iO == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.C(parcel, iX, ParcelFileDescriptor.CREATOR);
            } else if (iO != 3) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                iZ2 = SafeParcelReader.Z(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new BitmapTeleporter(iZ, parcelFileDescriptor, iZ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
