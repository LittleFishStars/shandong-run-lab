package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class yf extends j3 {
    public yf(Context context, boolean z) {
        this.f27425a = new xi(context);
    }

    public void a(p1 p1Var) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof xi)) {
            ((xi) k3Var).a(p1Var);
        }
    }

    @Override // com.beizi.fusion.j3
    public void w() {
        k3 k3Var = this.f27425a;
        if (k3Var == null) {
            return;
        }
        k3Var.G();
    }

    public void a(Context context) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof xi)) {
            ((xi) k3Var).a(context);
        }
    }
}
