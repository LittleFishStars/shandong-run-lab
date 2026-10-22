package com.byazt.eg;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 512})
public abstract class d implements Closeable {
    public static d c(rl rlVar, byte[] bArr) {
        return c(rlVar, bArr.length, new com.byazt.mk.ve().ve(bArr));
    }

    private Charset sp() {
        rl rlVarC = c();
        return rlVarC != null ? rlVarC.c(com.byazt.kh.ve.n) : com.byazt.kh.ve.n;
    }

    public final String a() throws IOException {
        com.byazt.mk.n nVarVe = ve();
        try {
            return nVarVe.c(com.byazt.kh.ve.c(nVarVe, sp()));
        } catch (OutOfMemoryError unused) {
            return null;
        } finally {
            com.byazt.kh.ve.c(nVarVe);
        }
    }

    public abstract rl c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.byazt.kh.ve.c(ve());
    }

    public final byte[] n() throws IOException {
        long jTt = tt();
        if (jTt > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jTt)));
        }
        com.byazt.mk.n nVarVe = ve();
        try {
            byte[] bArrNu = nVarVe.nu();
            com.byazt.kh.ve.c(nVarVe);
            if (jTt == -1 || jTt == bArrNu.length) {
                return bArrNu;
            }
            throw new IOException("Content-Length (" + jTt + ") and stream length (" + bArrNu.length + ") disagree");
        } catch (Throwable th) {
            com.byazt.kh.ve.c(nVarVe);
            throw th;
        }
    }

    public abstract long tt();

    public final InputStream uj() {
        return ve().a();
    }

    public abstract com.byazt.mk.n ve();

    public static d c(final rl rlVar, final long j, final com.byazt.mk.n nVar) {
        if (nVar != null) {
            return new d() { // from class: com.byazt.eg.d.1
                @Override // com.byazt.eg.d
                public rl c() {
                    return rlVar;
                }

                @Override // com.byazt.eg.d
                public long tt() {
                    return j;
                }

                @Override // com.byazt.eg.d
                public com.byazt.mk.n ve() {
                    return nVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
