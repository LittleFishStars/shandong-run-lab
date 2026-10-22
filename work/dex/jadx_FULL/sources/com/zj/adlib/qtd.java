package com.zj.adlib;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qtd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        double dT = 0.0d;
        int iZ = 0;
        int iZ2 = 0;
        boolean zP = false;
        String strG = null;
        String strG2 = null;
        Point[] pointArr = null;
        zzn zznVar = null;
        zzq zzqVar = null;
        zzr zzrVar = null;
        zzt zztVar = null;
        zzs zzsVar = null;
        zzo zzoVar = null;
        zzk zzkVar = null;
        zzl zzlVar = null;
        zzm zzmVar = null;
        byte[] bArrH = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 2:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 3:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    iZ2 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 6:
                    pointArr = (Point[]) SafeParcelReader.K(parcel, iX, Point.CREATOR);
                    break;
                case 7:
                    zznVar = (zzn) SafeParcelReader.C(parcel, iX, zzn.CREATOR);
                    break;
                case 8:
                    zzqVar = (zzq) SafeParcelReader.C(parcel, iX, zzq.CREATOR);
                    break;
                case 9:
                    zzrVar = (zzr) SafeParcelReader.C(parcel, iX, zzr.CREATOR);
                    break;
                case 10:
                    zztVar = (zzt) SafeParcelReader.C(parcel, iX, zzt.CREATOR);
                    break;
                case 11:
                    zzsVar = (zzs) SafeParcelReader.C(parcel, iX, zzs.CREATOR);
                    break;
                case 12:
                    zzoVar = (zzo) SafeParcelReader.C(parcel, iX, zzo.CREATOR);
                    break;
                case 13:
                    zzkVar = (zzk) SafeParcelReader.C(parcel, iX, zzk.CREATOR);
                    break;
                case 14:
                    zzlVar = (zzl) SafeParcelReader.C(parcel, iX, zzl.CREATOR);
                    break;
                case 15:
                    zzmVar = (zzm) SafeParcelReader.C(parcel, iX, zzm.CREATOR);
                    break;
                case 16:
                    bArrH = SafeParcelReader.h(parcel, iX);
                    break;
                case 17:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
                case 18:
                    dT = SafeParcelReader.T(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzu(iZ, strG, strG2, iZ2, pointArr, zznVar, zzqVar, zzrVar, zztVar, zzsVar, zzoVar, zzkVar, zzlVar, zzmVar, bArrH, zP, dT);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }
}
