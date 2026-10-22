package com.byazt.hc;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.ete.l;
import com.byazt.qq.da;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1504, 15})
public class uj extends c {
    public c tt;

    public uj(Activity activity, ic icVar) {
        super(activity, icVar);
    }

    @Override // com.byazt.hc.c, com.byazt.qq.tt
    public com.byazt.qq.tt.c c(da daVar) {
        ArrayList<g> arrayListN = l.n(this.sp);
        if (arrayListN == null) {
            return new com.byazt.qq.tt.c(false, 0, "");
        }
        for (g gVar : arrayListN) {
            if (gVar.ve() == 1) {
                this.tt = new ve(this.x, this.sp, gVar);
            }
            c cVar = this.tt;
            if (cVar != null) {
                cVar.ve(this.t);
                this.tt.uj(this.sl);
                this.tt.c(this.c);
                this.tt.tt(x());
                this.tt.c(this.m);
                com.byazt.qq.tt.c cVarC = this.tt.c(daVar);
                if (cVarC.ve()) {
                    return cVarC;
                }
            }
        }
        return new com.byazt.qq.tt.c(false, 0, "");
    }

    @Override // com.byazt.qq.tt
    public void tt(String str) {
        super.tt(str);
        c cVar = this.tt;
        if (cVar == null) {
            return;
        }
        cVar.tt(str);
    }

    @Override // com.byazt.qq.tt
    public String c() {
        c cVar = this.tt;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }
}
