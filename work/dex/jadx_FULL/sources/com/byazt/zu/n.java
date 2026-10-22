package com.byazt.zu;

import android.content.Context;
import com.byazt.hz.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 919, 46})
public class n implements com.byazt.oh.n {
    public com.byazt.ch.c c;
    public com.byazt.nh.a tt;
    public boolean uj;
    public i ve;

    public n(Context context, com.byazt.ch.c cVar, com.byazt.nh.a aVar, boolean z) {
        this.c = cVar;
        this.uj = z;
        if (cVar != null) {
            this.ve = new i(context);
            this.tt = aVar;
        }
    }

    @Override // com.byazt.oh.n
    public void c() {
        com.byazt.ll.tt ttVar = new com.byazt.ll.tt(5, this.c.eo(), this.c.or());
        ttVar.c(this.uj);
        this.ve.c(ttVar, new com.byazt.me.uj() { // from class: com.byazt.zu.n.1
            @Override // com.byazt.me.uj
            public void c(List<com.byazt.yl.ve> list) {
                com.byazt.ch.tt ttVarMd;
                if (list == null) {
                    c(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
                    return;
                }
                if (n.this.tt != null) {
                    com.byazt.am.tt ttVarDa = (n.this.c == null || (ttVarMd = n.this.c.md()) == null) ? null : ttVarMd.da();
                    LinkedList linkedList = new LinkedList();
                    Iterator<com.byazt.yl.ve> it = list.iterator();
                    while (it.hasNext()) {
                        linkedList.add(new uj(n.this.ve, it.next(), n.this.ve.my(), ttVarDa));
                    }
                    n.this.tt.c(linkedList);
                }
            }

            @Override // com.byazt.me.uj
            public void c(com.byazt.pp.c cVar) {
                if (cVar == null || n.this.tt == null) {
                    return;
                }
                n.this.tt.c(cVar.c, cVar.tt);
            }
        });
    }
}
