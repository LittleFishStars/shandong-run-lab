package com.ipd.dsp.internal.k;

import com.ipd.dsp.Dsp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements a {
    public static final String f = "DiskLruCacheWrapper";
    public static final int g = 1;
    public static final int h = 1;
    public static e i;
    public final File b;
    public final long c;
    public com.ipd.dsp.internal.d.a e;
    public final c d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f38375a = new m();

    @Deprecated
    public e(File file, long j) {
        this.b = file;
        this.c = j;
    }

    public static a a(File file, long j) {
        return new e(file, j);
    }

    @Deprecated
    public static synchronized a b(File file, long j) {
        if (i == null) {
            i = new e(file, j);
        }
        return i;
    }

    @Override // com.ipd.dsp.internal.k.a
    public synchronized void clear() {
        try {
            try {
                a().b();
                b();
            } catch (IOException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(f, "Unable to clear disk cache or disk cache cleared externally", e);
                }
                b();
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public final synchronized com.ipd.dsp.internal.d.a a() throws IOException {
        if (this.e == null) {
            this.e = com.ipd.dsp.internal.d.a.a(this.b, 1, 1, this.c);
        }
        return this.e;
    }

    @Override // com.ipd.dsp.internal.k.a
    public File b(com.ipd.dsp.internal.f.f fVar) {
        String strB = this.f38375a.b(fVar);
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(f, "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            com.ipd.dsp.internal.d.a.e eVarB = a().b(strB);
            if (eVarB != null) {
                return eVarB.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Dsp.isDebugLogEnable()) {
                return null;
            }
            com.ipd.dsp.internal.c2.k.e(f, "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // com.ipd.dsp.internal.k.a
    public void a(com.ipd.dsp.internal.f.f fVar, a.b bVar) {
        String strB = this.f38375a.b(fVar);
        this.d.a(strB);
        try {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(f, "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                com.ipd.dsp.internal.d.a aVarA = a();
                if (aVarA.b(strB) != null) {
                    this.d.b(strB);
                    return;
                }
                com.ipd.dsp.internal.d.a.c cVarA = aVarA.a(strB);
                if (cVarA != null) {
                    try {
                        if (bVar.a(cVarA.a(0))) {
                            cVarA.c();
                        }
                        cVarA.b();
                        this.d.b(strB);
                        return;
                    } catch (Throwable th) {
                        cVarA.b();
                        throw th;
                    }
                }
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            } catch (IOException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(f, "Unable to put to disk cache", e);
                }
            }
        } catch (Throwable th2) {
            this.d.b(strB);
            throw th2;
        }
    }

    public final synchronized void b() {
        this.e = null;
    }

    @Override // com.ipd.dsp.internal.k.a
    public void a(com.ipd.dsp.internal.f.f fVar) {
        try {
            a().d(this.f38375a.b(fVar));
        } catch (IOException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(f, "Unable to delete from disk cache", e);
            }
        }
    }
}
