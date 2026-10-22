package com.byazt.hw;

import com.byazt.gqp.i;
import com.byazt.gqp.m;
import com.byazt.gqp.yp;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 77, 34})
public class a implements i {
    public int c;

    public void c(int i) {
        this.c = i;
    }

    @Override // com.byazt.gqp.i
    public m c(i.c cVar) throws IOException {
        IOException iOException;
        yp ypVarC = cVar.c();
        if (sp.c().c(this.c).tt() != null) {
            sp.c().c(this.c).tt().n();
        }
        String string = ypVarC.tt().toString();
        String strC = sp.c().c(this.c).c(string);
        if (!string.equals(strC)) {
            ypVarC = ypVarC.sp().c(strC).tt();
        }
        m mVarC = null;
        try {
            iOException = null;
            mVarC = cVar.c(ypVarC);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            sp.c().c(this.c).c(ypVarC, e);
        }
        sp.c().c(this.c).c(ypVarC, mVarC);
        if (iOException == null) {
            return mVarC == null ? cVar.c(ypVarC) : mVarC;
        }
        throw iOException;
    }
}
