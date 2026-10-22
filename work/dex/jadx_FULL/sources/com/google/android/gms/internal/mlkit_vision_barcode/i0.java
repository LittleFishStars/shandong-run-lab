package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ktd;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i0 extends g0 implements RunnableFuture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public volatile zzeu f31350a;

    public i0(ktd ktdVar) {
        this.f31350a = new zzex(this, ktdVar);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzeu zzeuVar = this.f31350a;
        if (zzeuVar != null) {
            zzeuVar.run();
        }
        this.f31350a = null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec
    @CheckForNull
    public final String zze() {
        zzeu zzeuVar = this.f31350a;
        if (zzeuVar == null) {
            return super.zze();
        }
        return "task=[" + zzeuVar.toString() + "]";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec
    public final void zzk() {
        zzeu zzeuVar;
        if (zzn() && (zzeuVar = this.f31350a) != null) {
            zzeuVar.zze();
        }
        this.f31350a = null;
    }
}
