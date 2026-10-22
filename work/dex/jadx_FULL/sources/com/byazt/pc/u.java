package com.byazt.pc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 67})
public class u extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "spec_file_cache";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        String rawCacheKey = veVar.getRawCacheKey();
        com.byazt.yj.tt ttVarYp = veVar.yp();
        byte[] bArrC = com.byazt.in.c.c(veVar);
        if (bArrC == null) {
            veVar.c(new x(1006, "not image cache", null));
            return;
        }
        veVar.c(new tt(bArrC, null));
        if (ttVarYp.isRawMemoryCache()) {
            veVar.u().tt(ttVarYp).c(rawCacheKey, bArrC);
        }
    }
}
