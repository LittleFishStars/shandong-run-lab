package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.bkc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class s extends r implements zzfp {
    public s(zzdz zzdzVar) {
        super(zzdzVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.r
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final zzdz K1() {
        if (!((zzdz) this.b).q()) {
            return (zzdz) this.b;
        }
        ((zzdz) this.b).zza.g();
        return (zzdz) super.K1();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.r
    public final void zzn() {
        super.zzn();
        if (((zzdz) this.b).zza != bkc.d()) {
            zzdz zzdzVar = (zzdz) this.b;
            zzdzVar.zza = zzdzVar.zza.clone();
        }
    }
}
