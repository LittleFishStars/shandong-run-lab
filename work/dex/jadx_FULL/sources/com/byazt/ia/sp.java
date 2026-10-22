package com.byazt.ia;

import android.content.Context;
import com.byazt.mg.sl;
import com.byazt.uy.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 515, 91})
public class sp extends ve {
    public sp(Context context, tt ttVar, uj ujVar) {
        super(com.byazt.uy.ve.JAVA, context, ttVar, ujVar);
    }

    @Override // com.byazt.ia.ve
    public com.byazt.xz.c c(com.byazt.xz.c cVar) {
        com.byazt.xz.c cVarC = super.c(cVar);
        cVarC.c("app_count", (Object) 1);
        cVarC.c("magic_tag", "ss_app_log");
        ve(cVarC);
        com.byazt.xz.tt ttVarC = com.byazt.xz.tt.c(this.tt);
        ttVarC.c(x.c().c());
        ttVarC.c(x.ve().c());
        ttVarC.tt(this.ve.ve());
        cVarC.c(ttVarC);
        sl.c(cVarC, ttVarC, this.c);
        return cVarC;
    }
}
