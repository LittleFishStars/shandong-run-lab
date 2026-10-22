package com.byazt.tg;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gq.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 66})
public class t implements i {
    @Override // com.byazt.tg.i
    public boolean c(com.byazt.dd.tt ttVar, int i, x xVar) {
        if (ttVar == null) {
            return false;
        }
        return z.c(ttVar, !TextUtils.isEmpty(ttVar.oz()) ? com.byazt.di.da.c((Context) null).c(ttVar.oz(), null, true) : com.byazt.di.da.c((Context) null).tt(ttVar.c()), i, xVar, false, null);
    }
}
