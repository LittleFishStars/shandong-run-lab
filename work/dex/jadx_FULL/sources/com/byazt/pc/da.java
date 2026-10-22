package com.byazt.pc;

import android.graphics.Bitmap;
import com.byazt.yj.eo;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 72})
public class da extends c {
    private Bitmap tt(com.byazt.oz.ve veVar) {
        Collection<eo> collectionC = veVar.u().c();
        Bitmap bitmapC = null;
        if (collectionC == null) {
            return null;
        }
        Iterator<eo> it = collectionC.iterator();
        while (it.hasNext() && (bitmapC = it.next().c(veVar.getMemoryCacheKey())) == null) {
        }
        return bitmapC;
    }

    private Bitmap ve(com.byazt.oz.ve veVar) {
        return veVar.u().c(veVar.yp()).c(veVar.getMemoryCacheKey());
    }

    @Override // com.byazt.pc.i
    public String c() {
        return "memory_cache";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        Bitmap bitmapTt;
        int iN = veVar.n();
        if (iN == 2 || iN == 1) {
            bitmapTt = (veVar.z() || veVar.yp().isQueryAll()) ? tt(veVar) : ve(veVar);
        } else {
            bitmapTt = null;
        }
        if (bitmapTt != null) {
            veVar.c(new yp(bitmapTt, null, null, false));
            return;
        }
        com.byazt.yj.tt ttVarYp = veVar.yp();
        if (veVar.i()) {
            if (ttVarYp.isRawMemoryCache()) {
                veVar.c(new t());
                return;
            } else {
                veVar.c(new u());
                return;
            }
        }
        if (ttVarYp.isRawMemoryCache()) {
            veVar.c(new t());
        } else {
            veVar.c(new a());
        }
    }
}
