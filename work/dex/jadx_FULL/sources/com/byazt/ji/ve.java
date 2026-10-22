package com.byazt.ji;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 222, 54})
public class ve extends tt implements com.byazt.vt.uj {
    public com.byazt.vt.ve sl;

    public ve(Context context) {
        super(context);
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        com.byazt.vt.c cVarBx = this.tt.bx();
        if (cVarBx == null) {
            return false;
        }
        com.byazt.vt.ve veVarC = cVarBx.c(this.f28697a);
        this.sl = veVarC;
        if (veVarC != null) {
            veVarC.c(this);
            return false;
        }
        cVarBx.c(this.f28697a, new com.byazt.vt.tt());
        return false;
    }

    @Override // com.byazt.vt.uj
    public void c(String str) {
        this.c.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
    }
}
