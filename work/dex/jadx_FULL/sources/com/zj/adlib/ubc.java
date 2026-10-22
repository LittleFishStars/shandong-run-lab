package com.zj.adlib;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaz;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ubc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        String strG = null;
        String strG2 = null;
        byte[] bArrH = null;
        Point[] pointArr = null;
        zzat zzatVar = null;
        zzaw zzawVar = null;
        zzax zzaxVar = null;
        zzaz zzazVar = null;
        zzay zzayVar = null;
        zzau zzauVar = null;
        zzaq zzaqVar = null;
        zzar zzarVar = null;
        zzas zzasVar = null;
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
                    zzatVar = (zzat) SafeParcelReader.C(parcel, iX, zzat.CREATOR);
                    break;
                case 8:
                    zzawVar = (zzaw) SafeParcelReader.C(parcel, iX, zzaw.CREATOR);
                    break;
                case 9:
                    zzaxVar = (zzax) SafeParcelReader.C(parcel, iX, zzax.CREATOR);
                    break;
                case 10:
                    zzazVar = (zzaz) SafeParcelReader.C(parcel, iX, zzaz.CREATOR);
                    break;
                case 11:
                    zzayVar = (zzay) SafeParcelReader.C(parcel, iX, zzay.CREATOR);
                    break;
                case 12:
                    zzauVar = (zzau) SafeParcelReader.C(parcel, iX, zzau.CREATOR);
                    break;
                case 13:
                    zzaqVar = (zzaq) SafeParcelReader.C(parcel, iX, zzaq.CREATOR);
                    break;
                case 14:
                    zzarVar = (zzar) SafeParcelReader.C(parcel, iX, zzar.CREATOR);
                    break;
                case 15:
                    zzasVar = (zzas) SafeParcelReader.C(parcel, iX, zzas.CREATOR);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new zzba(iZ, strG, strG2, bArrH, pointArr, iZ2, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzba[i];
    }
}
