package cj.mobile.wm;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f3<A, T, Z> {
    public static final dexb dexm = new dexb();
    public final j3 dexa;
    public final int dexb;
    public final int dexc;
    public final y2<A> dexd;
    public final a8<A, T> dexe;
    public final v2<T> dexf;
    public final h7<T, Z> dexg;
    public final dexa dexh;
    public final com.wangmai.insightvision.openadsdk.image.b.n.i.b dexi;
    public final com.wangmai.insightvision.openadsdk.image.b.i dexj;
    public final dexb dexk;
    public volatile boolean dexl;

    public interface dexa {
        y3 a();
    }

    public static class dexb {
        public OutputStream dexa(File file) {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    public class dexc<DataType> implements y3.dexb {
        public final q2<DataType> dexa;
        public final DataType dexb;

        public dexc(q2<DataType> q2Var, DataType datatype) {
            this.dexa = q2Var;
            this.dexb = datatype;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x002a A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1 r4
          0x002a: PHI (r1v3 java.io.OutputStream) = (r1v1 java.io.OutputStream), (r1v4 java.io.OutputStream) binds: [B:14:0x0028, B:4:0x0015] A[DONT_GENERATE, DONT_INLINE]
          0x002a: PHI (r4v4 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:14:0x0028, B:4:0x0015] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        @Override // cj.mobile.wm.y3.dexb
        public boolean a(File file) {
            boolean zDexa;
            OutputStream outputStreamDexa = null;
            try {
                outputStreamDexa = f3.this.dexk.dexa(file);
                zDexa = this.dexa.dexa(this.dexb, outputStreamDexa);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 3)) {
                    f1.dexa(com.ipd.dsp.internal.i.h.L, "Failed to find file to write to disk cache", e);
                }
                zDexa = false;
            } finally {
                if (outputStreamDexa != null) {
                    try {
                        outputStreamDexa.close();
                    } catch (IOException unused) {
                    }
                }
            }
            return zDexa;
        }
    }

    public f3(j3 j3Var, int i, int i2, y2<A> y2Var, a8<A, T> a8Var, v2<T> v2Var, h7<T, Z> h7Var, dexa dexaVar, com.wangmai.insightvision.openadsdk.image.b.n.i.b bVar, com.wangmai.insightvision.openadsdk.image.b.i iVar) {
        this(j3Var, i, i2, y2Var, a8Var, v2Var, h7Var, dexaVar, bVar, iVar, dexm);
    }

    public f3(j3 j3Var, int i, int i2, y2<A> y2Var, a8<A, T> a8Var, v2<T> v2Var, h7<T, Z> h7Var, dexa dexaVar, com.wangmai.insightvision.openadsdk.image.b.n.i.b bVar, com.wangmai.insightvision.openadsdk.image.b.i iVar, dexb dexbVar) {
        this.dexa = j3Var;
        this.dexb = i;
        this.dexc = i2;
        this.dexd = y2Var;
        this.dexe = a8Var;
        this.dexf = v2Var;
        this.dexg = h7Var;
        this.dexh = dexaVar;
        this.dexi = bVar;
        this.dexj = iVar;
        this.dexk = dexbVar;
    }

    private n3<Z> dexa(n3<T> n3Var) {
        if (n3Var == null) {
            return null;
        }
        return this.dexg.dexa(n3Var);
    }

    private n3<T> dexa(r2 r2Var) {
        File fileDexa = this.dexh.a().dexa(r2Var);
        if (fileDexa == null) {
            return null;
        }
        try {
            n3<T> n3VarDexa = this.dexe.a().dexa(fileDexa, this.dexb, this.dexc);
            if (n3VarDexa == null) {
                this.dexh.a().dexb(r2Var);
            }
            return n3VarDexa;
        } catch (Throwable th) {
            this.dexh.a().dexb(r2Var);
            throw th;
        }
    }

    private n3<T> dexa(A a2) {
        long jDexa = a9.dexa();
        this.dexh.a().dexa(this.dexa.dexa(), new dexc(this.dexe.d(), a2));
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Wrote source to cache", jDexa);
        }
        long jDexa2 = a9.dexa();
        n3<T> n3VarDexa = dexa(this.dexa.dexa());
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2) && n3VarDexa != null) {
            dexa("Decoded source from cache", jDexa2);
        }
        return n3VarDexa;
    }

    private void dexa(String str, long j) {
        Log.v(com.ipd.dsp.internal.i.h.L, str + " in " + a9.dexa(j) + ", key: " + this.dexa);
    }

    private n3<T> dexb(n3<T> n3Var) {
        if (n3Var == null) {
            return null;
        }
        n3<T> n3VarDexa = this.dexf.dexa(n3Var, this.dexb, this.dexc);
        if (!n3Var.equals(n3VarDexa)) {
            n3Var.b();
        }
        return n3VarDexa;
    }

    private n3<T> dexb(A a2) {
        if (this.dexi.f()) {
            return dexa(a2);
        }
        long jDexa = a9.dexa();
        n3<T> n3VarDexa = this.dexe.f().dexa(a2, this.dexb, this.dexc);
        if (!Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            return n3VarDexa;
        }
        dexa("Decoded from source", jDexa);
        return n3VarDexa;
    }

    private n3<Z> dexc(n3<T> n3Var) {
        long jDexa = a9.dexa();
        n3<T> n3VarDexb = dexb((n3) n3Var);
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Transformed resource from source", jDexa);
        }
        dexd(n3VarDexb);
        long jDexa2 = a9.dexa();
        n3<Z> n3VarDexa = dexa((n3) n3VarDexb);
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Transcoded transformed from source", jDexa2);
        }
        return n3VarDexa;
    }

    private void dexd(n3<T> n3Var) {
        if (n3Var == null || !this.dexi.a()) {
            return;
        }
        long jDexa = a9.dexa();
        this.dexh.a().dexa(this.dexa, new dexc(this.dexe.c(), n3Var));
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Wrote transformed from source to cache", jDexa);
        }
    }

    private n3<T> dexe() {
        try {
            long jDexa = a9.dexa();
            A aDexa = this.dexd.dexa(this.dexj);
            if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
                dexa("Fetched data", jDexa);
            }
            if (this.dexl) {
                return null;
            }
            return dexb(aDexa);
        } finally {
            this.dexd.a();
        }
    }

    public void dexa() {
        this.dexl = true;
        this.dexd.b();
    }

    public n3<Z> dexb() {
        return dexc(dexe());
    }

    public n3<Z> dexc() {
        if (!this.dexi.a()) {
            return null;
        }
        long jDexa = a9.dexa();
        n3<T> n3VarDexa = dexa((r2) this.dexa);
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Decoded transformed from cache", jDexa);
        }
        long jDexa2 = a9.dexa();
        n3<Z> n3VarDexa2 = dexa((n3) n3VarDexa);
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Transcoded transformed from cache", jDexa2);
        }
        return n3VarDexa2;
    }

    public n3<Z> dexd() {
        if (!this.dexi.f()) {
            return null;
        }
        long jDexa = a9.dexa();
        n3<T> n3VarDexa = dexa(this.dexa.dexa());
        if (Log.isLoggable(com.ipd.dsp.internal.i.h.L, 2)) {
            dexa("Decoded source from cache", jDexa);
        }
        return dexc(n3VarDexa);
    }
}
