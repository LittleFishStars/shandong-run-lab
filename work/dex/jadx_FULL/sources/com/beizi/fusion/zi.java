package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class zi extends j3 {
    public zi(Context context) {
        this.f27425a = new aj(context);
    }

    public void a(bj bjVar) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof aj)) {
            ((aj) k3Var).a(bjVar);
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
        if (k3Var != null && (k3Var instanceof aj)) {
            ((aj) k3Var).a(context);
        }
    }
}
