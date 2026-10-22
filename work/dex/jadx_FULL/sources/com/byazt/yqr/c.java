package com.byazt.yqr;

import android.content.Context;
import com.byazt.fk.da;
import com.byazt.fk.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 982, 20})
public class c implements da {
    @Override // com.byazt.fk.da
    public void execVideoPreload(Context context, u uVar, da.c cVar) {
        ve.c(context, uVar, cVar);
        com.byazt.lt.tt.c("Exec clear video cache-- Pre");
        com.byazt.ri.c.c();
    }
}
