package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rud implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        zzj zzjVar = null;
        zzj zzjVar2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 2:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 3:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    strG3 = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    strG4 = SafeParcelReader.G(parcel, iX);
                    break;
                case 6:
                    strG5 = SafeParcelReader.G(parcel, iX);
                    break;
                case 7:
                    zzjVar = (zzj) SafeParcelReader.C(parcel, iX, zzj.CREATOR);
                    break;
                case 8:
                    zzjVar2 = (zzj) SafeParcelReader.C(parcel, iX, zzj.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzk(strG, strG2, strG3, strG4, strG5, zzjVar, zzjVar2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzk[i];
    }
}
