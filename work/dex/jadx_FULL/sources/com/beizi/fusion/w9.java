package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class w9 implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected x9 f27905a;

    @Override // com.beizi.fusion.va
    public void a() {
    }

    public void a(xa xaVar, View view, Integer num) {
        x9 x9Var = this.f27905a;
        if (x9Var == null || !(xaVar instanceof x9.a)) {
            return;
        }
        if (x9.a.AD_CLOSE == xaVar) {
            x9Var.d(xaVar);
        }
        if (x9.a.COMPLAIN_CONFIRM == xaVar) {
            this.f27905a.f(xaVar);
        }
        if (x9.a.AD_CLICK == xaVar) {
            this.f27905a.a(xaVar, view);
        }
        this.f27905a.a((x9.a) xaVar);
    }

    @Override // com.beizi.fusion.va
    public void a(x9 x9Var) {
        this.f27905a = x9Var;
        x9Var.a(this);
    }
}
