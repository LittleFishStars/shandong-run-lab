package com.byazt.pc;

import android.graphics.Bitmap;
import com.byazt.yj.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 46})
public class n extends c {
    public byte[] c;
    public com.byazt.yj.sp tt;

    public n(byte[] bArr, com.byazt.yj.sp spVar) {
        this.c = bArr;
        this.tt = spVar;
    }

    @Override // com.byazt.pc.i
    public String c() {
        return "decode";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        com.byazt.oz.a aVarU = veVar.u();
        com.byazt.ib.c cVarC = aVarU.c(veVar);
        try {
            gt gtVarM = veVar.m();
            if (gtVarM != null) {
                gtVarM.onStep(10, null);
            }
            Bitmap bitmapC = cVarC.c(this.c);
            if (bitmapC != null) {
                veVar.c(new yp(bitmapC, this.c, this.tt, false));
                String memoryCacheKey = veVar.getMemoryCacheKey();
                if (!veVar.i() || veVar.yp().isMemoryCache()) {
                    aVarU.c(veVar.yp()).c(memoryCacheKey, bitmapC);
                }
            } else {
                c(1002, "decode failed bitmap null", null, veVar);
            }
            if (gtVarM != null) {
                gtVarM.onStep(11, bitmapC);
            }
        } catch (Throwable th) {
            c(1002, "decode failed:" + th.getMessage(), th, veVar);
        }
    }

    private void c(int i, String str, Throwable th, com.byazt.oz.ve veVar) {
        if (this.tt == null) {
            veVar.c(new sl());
        } else {
            veVar.c(new x(i, str, th));
        }
    }
}
