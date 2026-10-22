package com.byazt.pc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 66})
public class t extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "raw_cache";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        byte[] bArrC = veVar.u().tt(veVar.yp()).c(veVar.getRawCacheKey());
        if (bArrC != null) {
            veVar.c(new tt(bArrC, null));
        } else if (veVar.i()) {
            veVar.c(new u());
        } else {
            veVar.c(new a());
        }
    }
}
