package com.byazt.ny;

import com.byazt.bb.x;
import com.byazt.cr.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 188, 15})
public class uj implements com.byazt.kkb.ve {
    public final com.byazt.eia.uj c = new com.byazt.eia.uj();

    public interface c {
        void c(boolean z);
    }

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.ppf.ve.c(this.c, cVar.ve(), cVar.tt(), map2);
        if (c(map2)) {
            c(map2, cVar).c(new HashMap());
            return true;
        }
        com.byazt.ppf.ve.c(map2, a.uj);
        cVar.tt(map2, null);
        return true;
    }

    private x c(final Map<String, Object> map, final com.byazt.cq.c cVar) {
        com.byazt.eia.uj ujVar = this.c;
        x xVar = new x(ujVar, ujVar.getContext(), this.c.tt(), this.c.ve(), map, cVar, this.c.uj(), true);
        xVar.c(new c() { // from class: com.byazt.ny.uj.1
            @Override // com.byazt.ny.uj.c
            public void c(boolean z) {
                if (!z) {
                    cVar.tt(map, null);
                } else {
                    com.byazt.ppf.ve.c((Map<String, Object>) map, a.ve);
                    cVar.tt(map);
                }
            }
        });
        return xVar;
    }

    private boolean c(Map<String, Object> map) {
        return (com.byazt.ppf.ve.c(this.c, map) == null || this.c.getContext() == null || this.c.A_() == null) ? false : true;
    }
}
