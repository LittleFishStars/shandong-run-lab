package com.byazt.pc;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 34})
public class a extends c {
    private byte[] tt(com.byazt.oz.ve veVar, String str) {
        com.byazt.yj.uj ujVarVe = veVar.u().ve(veVar.yp());
        if (ujVarVe == null) {
            return null;
        }
        return ujVarVe.c(str);
    }

    @Override // com.byazt.pc.i
    public String c() {
        return "disk_cache";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        String rawCacheKey = veVar.getRawCacheKey();
        com.byazt.yj.tt ttVarYp = veVar.yp();
        byte[] bArrC = (veVar.z() || ttVarYp.isQueryAll()) ? c(veVar, rawCacheKey) : tt(veVar, rawCacheKey);
        if (bArrC == null) {
            veVar.c(new sl());
            return;
        }
        veVar.c(new tt(bArrC, null));
        if (ttVarYp.isRawMemoryCache()) {
            veVar.u().tt(ttVarYp).c(rawCacheKey, bArrC);
        }
    }

    private byte[] c(com.byazt.oz.ve veVar, String str) {
        veVar.u().ve(veVar.yp());
        Collection<com.byazt.yj.uj> collectionVe = veVar.u().ve();
        if (collectionVe == null) {
            return null;
        }
        Iterator<com.byazt.yj.uj> it = collectionVe.iterator();
        while (it.hasNext()) {
            byte[] bArrC = it.next().c(str);
            if (bArrC != null) {
                return bArrC;
            }
        }
        return null;
    }
}
