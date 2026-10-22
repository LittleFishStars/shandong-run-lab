package com.byazt.dg;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 54})
public class ve implements c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<Float, Float> f28400a;
    public final c.InterfaceC0385c c;
    public final c<Float, Float> n;
    public boolean sp = true;
    public final c<Integer, Integer> tt;
    public final c<Float, Float> uj;
    public final c<Float, Float> ve;

    public ve(c.InterfaceC0385c interfaceC0385c, com.byazt.zk.ve veVar, com.byazt.fs.da daVar) {
        this.c = interfaceC0385c;
        c<Integer, Integer> cVarC = daVar.c().c();
        this.tt = cVarC;
        cVarC.c(this);
        veVar.c(cVarC);
        c<Float, Float> cVarC2 = daVar.tt().c();
        this.ve = cVarC2;
        cVarC2.c(this);
        veVar.c(cVarC2);
        c<Float, Float> cVarC3 = daVar.ve().c();
        this.uj = cVarC3;
        cVarC3.c(this);
        veVar.c(cVarC3);
        c<Float, Float> cVarC4 = daVar.uj().c();
        this.n = cVarC4;
        cVarC4.c(this);
        veVar.c(cVarC4);
        c<Float, Float> cVarC5 = daVar.n().c();
        this.f28400a = cVarC5;
        cVarC5.c(this);
        veVar.c(cVarC5);
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.sp = true;
        this.c.c();
    }

    public void c(Paint paint) {
        if (this.sp) {
            this.sp = false;
            double dFloatValue = ((double) this.uj.sp().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.n.sp().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.tt.sp().intValue();
            paint.setShadowLayer(this.f28400a.sp().floatValue(), fSin, fCos, Color.argb(Math.round(this.ve.sp().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
