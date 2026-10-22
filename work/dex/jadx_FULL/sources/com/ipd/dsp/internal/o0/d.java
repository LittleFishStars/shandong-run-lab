package com.ipd.dsp.internal.o0;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.l0.f;
import com.ipd.dsp.internal.m0.g;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements c.a, c.b {
    @Override // com.ipd.dsp.internal.o0.c.a
    @NonNull
    public com.ipd.dsp.internal.j0.a.InterfaceC0886a a(f fVar) throws IOException {
        com.ipd.dsp.internal.l0.d dVarD = fVar.d();
        while (true) {
            try {
                if (dVarD.f()) {
                    throw com.ipd.dsp.internal.m0.c.f;
                }
                return fVar.n();
            } catch (IOException e) {
                if (!(e instanceof g)) {
                    fVar.d().a(e);
                    fVar.i().a(fVar.c());
                    throw e;
                }
                fVar.r();
            }
        }
    }

    @Override // com.ipd.dsp.internal.o0.c.b
    public long b(f fVar) throws IOException {
        try {
            return fVar.o();
        } catch (IOException e) {
            fVar.d().a(e);
            throw e;
        }
    }
}
