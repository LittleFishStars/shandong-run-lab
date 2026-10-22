package com.byazt.cf;

import android.content.Context;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 18, 91})
public class sp extends ve {
    public static final sp ve = new sp(gt.getContext());

    private sp(Context context) {
        super(context);
    }

    public static sp c() {
        return ve;
    }

    @Override // com.byazt.cf.ve
    public int tt() {
        return 7;
    }

    public void c(com.byazt.dj.tt ttVar, String str, int i, uj ujVar) {
        com.byazt.cjm.ve veVar = new com.byazt.cjm.ve();
        veVar.c(str);
        veVar.c(i + 1);
        c(ttVar, ujVar, veVar, null, null, null);
    }
}
