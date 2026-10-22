package com.byazt.pm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1355, 46})
public class n implements ve {
    @Override // com.byazt.pm.ve
    public List<tt> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new tt("update") { // from class: com.byazt.pm.n.1
            @Override // com.byazt.pm.tt
            public com.byazt.vd.c c(com.byazt.xj.ve veVar, String str, a.c cVar) {
                return new com.byazt.vd.a(veVar, str, cVar);
            }
        });
        arrayList.add(new tt("emit") { // from class: com.byazt.pm.n.2
            @Override // com.byazt.pm.tt
            public com.byazt.vd.c c(com.byazt.xj.ve veVar, String str, a.c cVar) {
                return new com.byazt.vd.tt(veVar, str, cVar);
            }
        });
        arrayList.add(new tt("startAnimate") { // from class: com.byazt.pm.n.3
            @Override // com.byazt.pm.tt
            public com.byazt.vd.c c(com.byazt.xj.ve veVar, String str, a.c cVar) {
                return new com.byazt.vd.uj(veVar, str, cVar);
            }
        });
        arrayList.add(new tt("startTimer") { // from class: com.byazt.pm.n.4
            @Override // com.byazt.pm.tt
            public com.byazt.vd.c c(com.byazt.xj.ve veVar, String str, a.c cVar) {
                return new com.byazt.vd.n(veVar, str, cVar);
            }
        });
        return arrayList;
    }
}
