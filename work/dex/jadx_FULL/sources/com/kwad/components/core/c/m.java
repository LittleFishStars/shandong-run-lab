package com.kwad.components.core.c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bi;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m implements c {
    @Nullable
    @WorkerThread
    public static AdResultData e(com.kwad.components.core.request.model.a aVar) throws Throwable {
        a aVarOI = a.oI();
        if (aVarOI == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<i> listA = aVarOI.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.A(aVar.getPosId()).oR());
        if (com.kwad.sdk.core.config.e.Ks()) {
            l(listA);
        }
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        Collections.sort(listA);
        return i.k(listA.subList(0, Math.min(listA.size(), adNum)));
    }

    private static void l(List<i> list) {
        if (list == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (g.oV().a(next)) {
                com.kwad.sdk.core.d.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.pc());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Od().submit(new bi() { // from class: com.kwad.components.core.c.m.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() throws Throwable {
                AdResultData adResultDataE = m.e(aVar);
                if (adResultDataE != null && !adResultDataE.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adResultDataE, true);
                } else {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    o.a(aVar2, new k(aVar2));
                }
            }
        });
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
