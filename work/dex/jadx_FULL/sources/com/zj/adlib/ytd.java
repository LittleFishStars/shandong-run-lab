package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzux;
import com.google.android.gms.internal.mlkit_vision_barcode.zzva;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzve;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ytd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        zzve zzveVar = null;
        String strG = null;
        String strG2 = null;
        zzvf[] zzvfVarArr = null;
        zzvc[] zzvcVarArr = null;
        String[] strArrH = null;
        zzux[] zzuxVarArr = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    zzveVar = (zzve) SafeParcelReader.C(parcel, iX, zzve.CREATOR);
                    break;
                case 2:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 3:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    zzvfVarArr = (zzvf[]) SafeParcelReader.K(parcel, iX, zzvf.CREATOR);
                    break;
                case 5:
                    zzvcVarArr = (zzvc[]) SafeParcelReader.K(parcel, iX, zzvc.CREATOR);
                    break;
                case 6:
                    strArrH = SafeParcelReader.H(parcel, iX);
                    break;
                case 7:
                    zzuxVarArr = (zzux[]) SafeParcelReader.K(parcel, iX, zzux.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzva(zzveVar, strG, strG2, zzvfVarArr, zzvcVarArr, strArrH, zzuxVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzva[i];
    }
}
