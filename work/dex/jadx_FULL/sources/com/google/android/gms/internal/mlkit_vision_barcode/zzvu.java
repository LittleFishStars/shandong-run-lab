package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.zj.adlib.tec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zzvu extends zza implements zzvw {
    public zzvu(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzvw
    public final zzvt zzd(IObjectWrapper iObjectWrapper, zzvl zzvlVar) throws RemoteException {
        zzvt zzvtVar;
        Parcel parcelZza = zza();
        tec.b(parcelZza, iObjectWrapper);
        tec.a(parcelZza, zzvlVar);
        Parcel parcelZzb = zzb(1, parcelZza);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zzvtVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
            zzvtVar = iInterfaceQueryLocalInterface instanceof zzvt ? (zzvt) iInterfaceQueryLocalInterface : new zzvt(strongBinder);
        }
        parcelZzb.recycle();
        return zzvtVar;
    }
}
