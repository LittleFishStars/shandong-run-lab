package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ktd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzex extends zzeu {
    final /* synthetic */ i0 zza;
    private final ktd zzb;

    public zzex(i0 i0Var, ktd ktdVar) {
        this.zza = i0Var;
        this.zzb = ktdVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        return this.zzb.a();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    public final void zzc(Throwable th) {
        this.zza.zzl(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    public final /* synthetic */ void zzd(Object obj) {
        this.zza.zzm(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeu
    public final boolean zzf() {
        return this.zza.isDone();
    }
}
