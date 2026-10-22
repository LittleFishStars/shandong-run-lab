package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lcc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        String strG6 = null;
        String strG7 = null;
        String strG8 = null;
        String strG9 = null;
        String strG10 = null;
        String strG11 = null;
        String strG12 = null;
        String strG13 = null;
        String strG14 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 2:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 3:
                    strG3 = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    strG4 = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    strG5 = SafeParcelReader.G(parcel, iX);
                    break;
                case 6:
                    strG6 = SafeParcelReader.G(parcel, iX);
                    break;
                case 7:
                    strG7 = SafeParcelReader.G(parcel, iX);
                    break;
                case 8:
                    strG8 = SafeParcelReader.G(parcel, iX);
                    break;
                case 9:
                    strG9 = SafeParcelReader.G(parcel, iX);
                    break;
                case 10:
                    strG10 = SafeParcelReader.G(parcel, iX);
                    break;
                case 11:
                    strG11 = SafeParcelReader.G(parcel, iX);
                    break;
                case 12:
                    strG12 = SafeParcelReader.G(parcel, iX);
                    break;
                case 13:
                    strG13 = SafeParcelReader.G(parcel, iX);
                    break;
                case 14:
                    strG14 = SafeParcelReader.G(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzas(strG, strG2, strG3, strG4, strG5, strG6, strG7, strG8, strG9, strG10, strG11, strG12, strG13, strG14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzas[i];
    }
}
