package com.ipd.dsp.internal.l0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.h;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38396a;
    public boolean b;
    public com.ipd.dsp.internal.i0.b c;
    public long d;

    @NonNull
    public final com.ipd.dsp.internal.f0.f e;

    @NonNull
    public final com.ipd.dsp.internal.h0.b f;

    public b(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar) {
        this.e = fVar;
        this.f = bVar;
    }

    public void a() throws IOException {
        g gVarF = h.j().f();
        c cVarB = b();
        cVarB.a();
        boolean zF = cVarB.f();
        boolean zG = cVarB.g();
        long jB = cVarB.b();
        String strD = cVarB.d();
        String strE = cVarB.e();
        int iC = cVarB.c();
        gVarF.a(strE, this.e, this.f);
        this.f.a(zG);
        this.f.a(strD);
        if (h.j().e().h(this.e)) {
            throw com.ipd.dsp.internal.m0.b.f;
        }
        com.ipd.dsp.internal.i0.b bVarA = gVarF.a(iC, this.f.i() != 0, this.f, strD);
        boolean z = bVarA == null;
        this.b = z;
        this.c = bVarA;
        this.d = jB;
        this.f38396a = zF;
        if (a(iC, jB, z)) {
            return;
        }
        if (gVarF.a(iC, this.f.i() != 0)) {
            throw new com.ipd.dsp.internal.m0.h(iC, this.f.i());
        }
    }

    public boolean a(int i, long j, boolean z) {
        return i == 416 && j >= 0 && z;
    }

    public c b() {
        return new c(this.e, this.f);
    }

    @Nullable
    public com.ipd.dsp.internal.i0.b c() {
        return this.c;
    }

    @NonNull
    public com.ipd.dsp.internal.i0.b d() {
        com.ipd.dsp.internal.i0.b bVar = this.c;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.b);
    }

    public long e() {
        return this.d;
    }

    public boolean f() {
        return this.f38396a;
    }

    public boolean g() {
        return this.b;
    }

    public String toString() {
        return "acceptRange[" + this.f38396a + "] resumable[" + this.b + "] failedCause[" + this.c + "] instanceLength[" + this.d + "] " + super.toString();
    }
}
