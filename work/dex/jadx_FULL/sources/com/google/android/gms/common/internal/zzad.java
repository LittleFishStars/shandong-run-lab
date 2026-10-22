package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.zj.adlib.rec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zzad extends com.google.android.gms.internal.common.zza implements zzaf {
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq zze(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        rec.d(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(6, parcelZza);
        zzq zzqVar = (zzq) rec.a(parcelZzB, zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq zzf(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        rec.d(parcelZza, zzoVar);
        Parcel parcelZzB = zzB(8, parcelZza);
        zzq zzqVar = (zzq) rec.a(parcelZzB, zzq.CREATOR);
        parcelZzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzg() throws RemoteException {
        Parcel parcelZzB = zzB(9, zza());
        boolean zG = rec.g(parcelZzB);
        parcelZzB.recycle();
        return zG;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzh(com.google.android.gms.common.zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        rec.d(parcelZza, zzsVar);
        rec.f(parcelZza, iObjectWrapper);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zG = rec.g(parcelZzB);
        parcelZzB.recycle();
        return zG;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzB = zzB(7, zza());
        boolean zG = rec.g(parcelZzB);
        parcelZzB.recycle();
        return zG;
    }
}
