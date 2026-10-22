package com.byazt.zy;

import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 117})
public class rl implements ve, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.dg.c<?, Float> f29260a;
    public final String c;
    public final com.byazt.dg.c<?, Float> n;
    public final com.byazt.dg.c<?, Float> sp;
    public final boolean tt;
    public final com.byazt.jx.my.c uj;
    public final List<com.byazt.dg.c.InterfaceC0385c> ve = new ArrayList();

    public rl(com.byazt.zk.ve veVar, com.byazt.jx.my myVar) {
        this.c = myVar.c();
        this.tt = myVar.n();
        this.uj = myVar.getType();
        com.byazt.dg.c<Float, Float> cVarC = myVar.ve().c();
        this.n = cVarC;
        com.byazt.dg.c<Float, Float> cVarC2 = myVar.tt().c();
        this.f29260a = cVarC2;
        com.byazt.dg.c<Float, Float> cVarC3 = myVar.uj().c();
        this.sp = cVarC3;
        veVar.c(cVarC);
        veVar.c(cVarC2);
        veVar.c(cVarC3);
        cVarC.c(this);
        cVarC2.c(this);
        cVarC3.c(this);
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        for (int i = 0; i < this.ve.size(); i++) {
            this.ve.get(i).c();
        }
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
    }

    public com.byazt.jx.my.c getType() {
        return this.uj;
    }

    public boolean n() {
        return this.tt;
    }

    public com.byazt.dg.c<?, Float> tt() {
        return this.n;
    }

    public com.byazt.dg.c<?, Float> uj() {
        return this.sp;
    }

    public com.byazt.dg.c<?, Float> ve() {
        return this.f29260a;
    }

    public void c(com.byazt.dg.c.InterfaceC0385c interfaceC0385c) {
        this.ve.add(interfaceC0385c);
    }
}
