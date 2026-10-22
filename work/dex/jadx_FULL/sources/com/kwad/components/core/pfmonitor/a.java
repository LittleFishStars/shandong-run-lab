package com.kwad.components.core.pfmonitor;

import com.kwad.components.core.pfmonitor.model.e;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class a implements b.InterfaceC1227b, Runnable {
    private e aig;
    private com.kwad.components.core.pfmonitor.model.c aih;
    private int aii = 0;
    private final int aij;

    public a(e eVar, int i) {
        this.aij = i;
        this.aig = eVar;
    }

    public final int getStatus() {
        return this.aii;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.aii = 1;
        try {
            com.kwad.components.core.pfmonitor.model.c cVarA = b.a(new File(this.aig.vv()), null, this.aij, this);
            this.aih = cVarA;
            cVarA.a(this.aig);
            this.aii = 2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.aii = 3;
        }
        if (this.aih == null) {
            this.aii = 3;
        }
    }

    public final com.kwad.components.core.pfmonitor.model.c vr() {
        if (this.aii == 2) {
            return this.aih;
        }
        return null;
    }
}
