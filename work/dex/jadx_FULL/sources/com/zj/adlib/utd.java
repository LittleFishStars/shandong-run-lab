package com.zj.adlib;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzva;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvh;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class utd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        String strG2 = null;
        byte[] bArrH = null;
        Point[] pointArr = null;
        zzvc zzvcVar = null;
        zzvf zzvfVar = null;
        zzvg zzvgVar = null;
        zzvi zzviVar = null;
        zzvh zzvhVar = null;
        zzvd zzvdVar = null;
        zzuz zzuzVar = null;
        zzva zzvaVar = null;
        zzvb zzvbVar = null;
        int iZ = 0;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 2:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 3:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    bArrH = SafeParcelReader.h(parcel, iX);
                    break;
                case 5:
                    pointArr = (Point[]) SafeParcelReader.K(parcel, iX, Point.CREATOR);
                    break;
                case 6:
                    iZ2 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 7:
                    zzvcVar = (zzvc) SafeParcelReader.C(parcel, iX, zzvc.CREATOR);
                    break;
                case 8:
                    zzvfVar = (zzvf) SafeParcelReader.C(parcel, iX, zzvf.CREATOR);
                    break;
                case 9:
                    zzvgVar = (zzvg) SafeParcelReader.C(parcel, iX, zzvg.CREATOR);
                    break;
                case 10:
                    zzviVar = (zzvi) SafeParcelReader.C(parcel, iX, zzvi.CREATOR);
                    break;
                case 11:
                    zzvhVar = (zzvh) SafeParcelReader.C(parcel, iX, zzvh.CREATOR);
                    break;
                case 12:
                    zzvdVar = (zzvd) SafeParcelReader.C(parcel, iX, zzvd.CREATOR);
                    break;
                case 13:
                    zzuzVar = (zzuz) SafeParcelReader.C(parcel, iX, zzuz.CREATOR);
                    break;
                case 14:
                    zzvaVar = (zzva) SafeParcelReader.C(parcel, iX, zzva.CREATOR);
                    break;
                case 15:
                    zzvbVar = (zzvb) SafeParcelReader.C(parcel, iX, zzvb.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzvj(iZ, strG, strG2, bArrH, pointArr, iZ2, zzvcVar, zzvfVar, zzvgVar, zzviVar, zzvhVar, zzvdVar, zzuzVar, zzvaVar, zzvbVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzvj[i];
    }
}
