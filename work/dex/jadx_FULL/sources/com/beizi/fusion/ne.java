package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ne extends cc {
    @Override // com.beizi.fusion.w9
    public void a(xa xaVar, View view, Integer num) {
        x9 x9Var = this.f27905a;
        if (x9Var != null && (xaVar instanceof x9.a) && (x9Var instanceof oe)) {
            if (x9.a.REWARD_PRIMARY_CLOSE == xaVar) {
                ((oe) x9Var).h(xaVar);
            }
            if (x9.a.REWARD_TO_PRIVILEGE == xaVar) {
                ((oe) this.f27905a).k(xaVar);
            }
            if (x9.a.REWARD_TO_END_CARD == xaVar) {
                ((oe) this.f27905a).b(xaVar);
            }
            if (x9.a.REWARD_TO_RETAIN == xaVar) {
                ((oe) this.f27905a).a(xaVar);
            }
        }
        super.a(xaVar, view, null);
    }
}
