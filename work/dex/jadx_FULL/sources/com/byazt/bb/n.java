package com.byazt.bb;

import com.byazt.eia.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 46})
public class n implements com.byazt.hl.c {
    public com.byazt.hl.c c;
    public i n;
    public com.byazt.cq.c tt;
    public String uj;
    public Map<String, Object> ve;

    public n(com.byazt.hl.c cVar, i iVar, com.byazt.cq.c cVar2, Map<String, Object> map, String str) {
        this.n = iVar;
        this.c = cVar;
        this.tt = cVar2;
        this.ve = map;
        this.uj = str;
    }

    @Override // com.byazt.hl.c
    public boolean c(final Map<String, Object> map) {
        int iC = com.byazt.apd.tt.c().c(this.n, new com.byazt.ysz.ve() { // from class: com.byazt.bb.n.1
            @Override // com.byazt.ysz.ve
            public void c(int i) {
                if (n.this.c != null && n.this.c.c(map)) {
                    return;
                }
                n.this.tt.c(n.this.ve, (com.byazt.qb.c) null);
            }
        }, this.uj, this.ve);
        if (iC == 1 || iC == 2) {
            c();
            return true;
        }
        com.byazt.hl.c cVar = this.c;
        return cVar != null && cVar.c(map);
    }

    private void c() {
        Map<String, Object> map;
        Map<String, Object> map2 = this.ve;
        if (map2 != null) {
            Object obj = map2.get("click_chain");
            Object obj2 = this.ve.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.byazt.zo.ve)) {
                return;
            }
            com.byazt.zo.ve veVar = (com.byazt.zo.ve) obj;
            com.byazt.vis.c cVar = (com.byazt.vis.c) veVar.c(com.byazt.vis.c.class);
            if (cVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    map = (Map) obj2;
                } else {
                    map = new HashMap<>();
                }
                cVar.c(map, veVar);
            }
        }
    }
}
