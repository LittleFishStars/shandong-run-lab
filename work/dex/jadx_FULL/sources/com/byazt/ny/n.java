package com.byazt.ny;

import com.byazt.bb.sp;
import com.byazt.eia.a;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 188, 46})
public class n implements com.byazt.kkb.ve {
    public final a c = new a();

    public interface c {
        void c(boolean z);
    }

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.ppf.ve.c(this.c, cVar.ve(), cVar.tt(), map2);
        sp spVar = new sp(this.c.z(), this.c.getContext(), this.c, map2);
        spVar.c(this.c.i());
        c(spVar, map2, cVar).c(map2);
        return true;
    }

    private com.byazt.bb.ve c(sp spVar, final Map<String, Object> map, final com.byazt.cq.c cVar) {
        a aVar = this.c;
        com.byazt.bb.ve veVar = new com.byazt.bb.ve(spVar, aVar, aVar.i(), this.c.yp(), this.c.getContext(), map, true);
        veVar.tt(this.c.sl());
        veVar.c(this.c.da());
        veVar.c(this.c.t());
        veVar.c(this.c.m());
        veVar.ve(this.c.sp());
        veVar.c(new c() { // from class: com.byazt.ny.n.1
            @Override // com.byazt.ny.n.c
            public void c(boolean z) {
                if (!z) {
                    cVar.tt(map, null);
                } else {
                    com.byazt.ppf.ve.c((Map<String, Object>) map, com.byazt.cr.n.ve);
                    cVar.tt(map);
                }
            }
        });
        return veVar;
    }
}
