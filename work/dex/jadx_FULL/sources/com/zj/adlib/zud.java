package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zud implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        zzp zzpVar = null;
        String strG = null;
        String strG2 = null;
        zzq[] zzqVarArr = null;
        zzn[] zznVarArr = null;
        String[] strArrH = null;
        zzi[] zziVarArr = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 2:
                    zzpVar = (zzp) SafeParcelReader.C(parcel, iX, zzp.CREATOR);
                    break;
                case 3:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    zzqVarArr = (zzq[]) SafeParcelReader.K(parcel, iX, zzq.CREATOR);
                    break;
                case 6:
                    zznVarArr = (zzn[]) SafeParcelReader.K(parcel, iX, zzn.CREATOR);
                    break;
                case 7:
                    strArrH = SafeParcelReader.H(parcel, iX);
                    break;
                case 8:
                    zziVarArr = (zzi[]) SafeParcelReader.K(parcel, iX, zzi.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzl(zzpVar, strG, strG2, zzqVarArr, zznVarArr, strArrH, zziVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }
}
