package com.ipd.dsp.internal.o0;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.f0.h;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f38478a;
    public final byte[] b;
    public final com.ipd.dsp.internal.n0.d c;
    public final int d;
    public final f e;
    public final com.ipd.dsp.internal.k0.a f = h.j().b();

    public b(int i, @NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.n0.d dVar, f fVar) {
        this.d = i;
        this.f38478a = inputStream;
        this.b = new byte[fVar.q()];
        this.c = dVar;
        this.e = fVar;
    }

    @Override // com.ipd.dsp.internal.o0.c.b
    public long b(com.ipd.dsp.internal.l0.f fVar) throws IOException {
        if (fVar.d().f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        h.j().f().a(fVar.k());
        int i = this.f38478a.read(this.b);
        if (i == -1) {
            return i;
        }
        this.c.a(this.d, this.b, i);
        long j = i;
        fVar.a(j);
        if (this.f.a(this.e)) {
            fVar.b();
        }
        return j;
    }
}
