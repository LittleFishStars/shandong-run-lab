package com.byazt.ydv;

import com.byazt.gqp.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 842, 34})
public class a extends c {
    public m ve;

    public a(m mVar, n nVar) {
        com.byazt.gqp.a aVarSp;
        this.ve = mVar;
        this.c = new ArrayList();
        if (mVar != null && (aVarSp = mVar.sp()) != null) {
            for (int i = 0; i < aVarSp.c(); i++) {
                this.c.add(new com.byazt.utw.a.tt(aVarSp.c(i), aVarSp.tt(i)));
            }
        }
        this.tt = nVar;
    }

    @Override // com.byazt.ydv.c
    public int c() {
        return this.ve.ve();
    }

    @Override // com.byazt.ydv.c
    public boolean tt() {
        return this.ve.ve() >= 200 && this.ve.ve() < 300;
    }

    @Override // com.byazt.ydv.c
    public InputStream uj() {
        return this.ve.a().ve();
    }

    @Override // com.byazt.ydv.c
    public List<com.byazt.utw.a.tt> ve() {
        return this.c;
    }

    @Override // com.byazt.ydv.c
    public String c(String str, String str2) {
        return c(str) != null ? c(str).tt : str2;
    }
}
