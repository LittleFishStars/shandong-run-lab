package com.byazt.dg;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 46})
public class n extends sp<com.byazt.jx.uj> {
    public final com.byazt.jx.uj uj;

    public n(List<com.byazt.vc.c<com.byazt.jx.uj>> list) {
        super(list);
        com.byazt.jx.uj ujVar = list.get(0).c;
        int iVe = ujVar != null ? ujVar.ve() : 0;
        this.uj = new com.byazt.jx.uj(new float[iVe], new int[iVe]);
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public com.byazt.jx.uj c(com.byazt.vc.c<com.byazt.jx.uj> cVar, float f) {
        this.uj.c(cVar.c, cVar.tt, f);
        return this.uj;
    }
}
