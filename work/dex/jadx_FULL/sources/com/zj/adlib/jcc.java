package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jcc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        zzav zzavVar = null;
        String strG = null;
        String strG2 = null;
        zzaw[] zzawVarArr = null;
        zzat[] zzatVarArr = null;
        String[] strArrH = null;
        zzao[] zzaoVarArr = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    zzavVar = (zzav) SafeParcelReader.C(parcel, iX, zzav.CREATOR);
                    break;
                case 2:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 3:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    zzawVarArr = (zzaw[]) SafeParcelReader.K(parcel, iX, zzaw.CREATOR);
                    break;
                case 5:
                    zzatVarArr = (zzat[]) SafeParcelReader.K(parcel, iX, zzat.CREATOR);
                    break;
                case 6:
                    strArrH = SafeParcelReader.H(parcel, iX);
                    break;
                case 7:
                    zzaoVarArr = (zzao[]) SafeParcelReader.K(parcel, iX, zzao.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzar(zzavVar, strG, strG2, zzawVarArr, zzatVarArr, strArrH, zzaoVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzar[i];
    }
}
