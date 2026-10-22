package com.kc.dw.core.loader.strategy;

import com.kc.dw.core.router.log.bean.CodeErrorNoMsg;
import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.core.loader.loadbean.a f39270a;
    public final e b;

    public c(e eVar, com.kc.dw.core.loader.loadbean.a aVar) {
        this.b = eVar;
        this.f39270a = aVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        int i;
        com.kc.dw.core.loader.b next;
        com.kc.dw.core.loader.loadbean.a aVar = this.f39270a;
        if (aVar != null && ((i = aVar.c) == 1 || i == 4)) {
            synchronized (aVar) {
                aVar.c = 5;
            }
            com.kc.dw.core.loader.loadbean.a aVar2 = this.f39270a;
            aVar2.d = 2;
            if (!this.b.b(aVar2)) {
                e eVar = this.b;
                com.kc.dw.core.loader.loadbean.a aVar3 = this.f39270a;
                eVar.getClass();
                try {
                    Iterator<com.kc.dw.core.loader.b> it = eVar.q.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (aVar3.f39268a.getReq_uid() != next.getSdkAdInfo().getReq_uid());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.kc.dw.core.service.logrecord.a.a(5, "f2", next, new CodeErrorNoMsg().setData(1, com.kc.dw.core.exception.b.f39252a.intValue(), ""));
            }
        }
        this.b.n.remove(this.f39270a);
        this.b.g();
    }
}
