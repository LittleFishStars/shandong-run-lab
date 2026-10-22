package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.zj.adlib.tec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zzaj extends zza implements IInterface {
    public zzaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final void zzd() throws RemoteException {
        zzc(3, zza());
    }

    public final zzu[] zze(IObjectWrapper iObjectWrapper, zzan zzanVar) throws RemoteException {
        Parcel parcelZza = zza();
        tec.b(parcelZza, iObjectWrapper);
        tec.a(parcelZza, zzanVar);
        Parcel parcelZzb = zzb(1, parcelZza);
        zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
        parcelZzb.recycle();
        return zzuVarArr;
    }

    public final zzu[] zzf(IObjectWrapper iObjectWrapper, zzan zzanVar) throws RemoteException {
        Parcel parcelZza = zza();
        tec.b(parcelZza, iObjectWrapper);
        tec.a(parcelZza, zzanVar);
        Parcel parcelZzb = zzb(2, parcelZza);
        zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
        parcelZzb.recycle();
        return zzuVarArr;
    }
}
