package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzl extends zzj {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    public zzl(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzf() {
        byte[] bArrZzb;
        synchronized (this) {
            bArrZzb = (byte[]) this.zzb.get();
            if (bArrZzb == null) {
                bArrZzb = zzb();
                this.zzb = new WeakReference(bArrZzb);
            }
        }
        return bArrZzb;
    }
}
