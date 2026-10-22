package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gud implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        int iZ5 = 0;
        int iZ6 = 0;
        boolean zP = false;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 2:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 3:
                    iZ2 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 4:
                    iZ3 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 5:
                    iZ4 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 6:
                    iZ5 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 7:
                    iZ6 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 8:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
                case 9:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzj(iZ, iZ2, iZ3, iZ4, iZ5, iZ6, zP, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
