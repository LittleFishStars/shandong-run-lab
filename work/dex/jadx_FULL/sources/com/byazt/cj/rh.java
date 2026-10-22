package com.byazt.cj;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 115})
public class rh implements com.byazt.kkb.ve {

    @com.byazt.ls.c(c = "reward_dialog_callback")
    public com.byazt.qq.da c;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.qq.da daVar = this.c;
        if (daVar == null) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        daVar.c();
        cVar.c(map2);
        return true;
    }
}
