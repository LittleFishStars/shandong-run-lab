package com.byazt.cv;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 20})
public class c implements com.byazt.oh.uj {
    public com.byazt.pp.tt c;

    public c(com.byazt.pp.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.oh.uj
    public String c() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.tt();
        }
        return null;
    }

    @Override // com.byazt.oh.uj
    public String n() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.a();
        }
        return null;
    }

    @Override // com.byazt.oh.uj
    public String tt() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return TextUtils.isEmpty(ttVar.ve()) ? this.c.uj() : this.c.ve();
        }
        return null;
    }

    @Override // com.byazt.oh.uj
    public int uj() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.n();
        }
        return 0;
    }

    @Override // com.byazt.oh.uj
    public String ve() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.c();
        }
        return null;
    }
}
