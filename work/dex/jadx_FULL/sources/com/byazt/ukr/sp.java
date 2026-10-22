package com.byazt.ukr;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 91})
public class sp implements com.byazt.gs.n {
    public com.byazt.hm.tt c;

    public sp(com.byazt.hm.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.gs.n
    public boolean c() {
        com.byazt.hm.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.i();
        }
        return false;
    }

    @Override // com.byazt.gs.n
    public Map<String, String> n() {
        com.byazt.hm.tt ttVar = this.c;
        return ttVar != null ? ttVar.uj() : new HashMap();
    }

    @Override // com.byazt.gs.n
    public String tt() {
        com.byazt.hm.tt ttVar = this.c;
        return ttVar != null ? ttVar.n() : "";
    }

    @Override // com.byazt.gs.n
    public String uj() {
        com.byazt.hm.tt ttVar = this.c;
        return ttVar != null ? ttVar.ve() : "";
    }

    @Override // com.byazt.gs.n
    public int ve() {
        com.byazt.hm.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.tt();
        }
        return -1;
    }
}
