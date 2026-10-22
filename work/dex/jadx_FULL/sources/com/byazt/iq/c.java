package com.byazt.iq;

import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.h;
import com.byazt.eg.md;
import com.byazt.eg.yv;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 20})
public final class c implements gt {
    public final gu c;

    public c(gu guVar) {
        this.c = guVar;
    }

    @Override // com.byazt.eg.gt
    public h c(gt.c cVar) throws IOException {
        md mdVar;
        com.byazt.yx.sp spVar = (com.byazt.yx.sp) cVar;
        yv yvVarC = spVar.c();
        if (yvVarC != null && (mdVar = yvVarC.f28464a) != null) {
            mdVar.tt();
        }
        sp spVarA = spVar.a();
        com.byazt.yx.ve veVarC = spVarA.c(this.c, cVar, !yvVarC.tt().equals("GET"));
        ve veVarTt = spVarA.tt();
        md mdVar2 = yvVarC.f28464a;
        if (mdVar2 != null) {
            mdVar2.ve();
        }
        return spVar.c(yvVarC, spVarA, veVarC, veVarTt);
    }
}
