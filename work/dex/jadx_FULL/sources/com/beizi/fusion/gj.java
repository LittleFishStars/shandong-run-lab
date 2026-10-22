package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gj extends j3 {
    public gj(Context context, String str, int i) {
        this.f27425a = new jj(context, str, i != 1 ? i != 2 ? i != 3 ? i != 6 ? null : th.NATIVE : th.INTERSTITIAL : th.NEW_SPLASH : th.REWARDEDVIDEO);
    }

    public void a(ij ijVar) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof jj)) {
            ((jj) k3Var).a(ijVar);
        }
    }

    public void a(View view) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof jj)) {
            ((jj) k3Var).b(view);
        }
    }

    public void a(ViewGroup viewGroup, hj hjVar) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof jj)) {
            ((jj) k3Var).a(viewGroup, hjVar);
        }
    }
}
