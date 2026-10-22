package com.byazt.wc;

import com.byazt.ch.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1692, 13})
public class tt extends ve {
    public com.byazt.dhf.c c;

    public tt(com.byazt.dhf.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.ch.ve
    public void onCancel() {
        com.byazt.dhf.c cVar = this.c;
        if (cVar != null) {
            cVar.tt();
        }
    }

    @Override // com.byazt.ch.ve
    public void onSelected(int i, String str) {
        com.byazt.dhf.c cVar = this.c;
        if (cVar != null) {
            cVar.c(i, str, false);
        }
    }

    @Override // com.byazt.ch.ve
    public void onShow() {
        com.byazt.dhf.c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }
}
