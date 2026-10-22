package com.byazt.eg;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 350})
public abstract class p {
    public static p c(rl rlVar, String str) {
        Charset charset = com.byazt.kh.ve.n;
        if (rlVar != null) {
            Charset charsetVe = rlVar.ve();
            if (charsetVe == null) {
                rlVar = rl.c(rlVar + "; charset=utf-8");
            } else {
                charset = charsetVe;
            }
        }
        return c(rlVar, str.getBytes(charset));
    }

    public abstract rl c();

    public abstract void c(com.byazt.mk.uj ujVar) throws IOException;

    public long tt() throws IOException {
        return -1L;
    }

    public static p c(rl rlVar, byte[] bArr) {
        return c(rlVar, bArr, 0, bArr.length);
    }

    public static p c(final rl rlVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            com.byazt.kh.ve.c(bArr.length, i, i2);
            return new p() { // from class: com.byazt.eg.p.1
                @Override // com.byazt.eg.p
                public rl c() {
                    return rlVar;
                }

                @Override // com.byazt.eg.p
                public long tt() {
                    return i2;
                }

                @Override // com.byazt.eg.p
                public void c(com.byazt.mk.uj ujVar) throws IOException {
                    ujVar.ve(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
