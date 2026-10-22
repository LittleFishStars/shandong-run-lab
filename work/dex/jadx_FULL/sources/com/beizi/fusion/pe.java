package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class pe implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qe f27652a;

    @Override // com.beizi.fusion.va
    public void a() {
    }

    public void a(xa xaVar, View view, Integer num) {
        qe qeVar = this.f27652a;
        if (qeVar != null && (xaVar instanceof qe.a) && qe.a.REWARD_CLAIM_EVENT == xaVar) {
            qeVar.g(xaVar);
        }
    }

    @Override // com.beizi.fusion.va
    public void a(qe qeVar) {
        this.f27652a = qeVar;
        qeVar.a(this);
    }
}
