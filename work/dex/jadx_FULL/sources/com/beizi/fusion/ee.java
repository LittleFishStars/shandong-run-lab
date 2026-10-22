package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ee implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fe f27232a;
    private boolean b = false;

    public void b() {
        this.b = false;
        this.f27232a = null;
    }

    public void a(Object obj) {
        this.b = false;
    }

    @Override // com.beizi.fusion.va
    public void a() {
        this.b = true;
    }

    public void a(xa xaVar, View view, ab abVar) {
        fe feVar;
        if (!this.b || (feVar = this.f27232a) == null) {
            return;
        }
        if (xaVar == fe.a.RENDER_FAILED) {
            feVar.f();
        }
        if (xaVar == fe.a.RENDER_SUCCESS) {
            this.f27232a.a();
        }
        if (xaVar == fe.a.SINGLE_VIEW_RENDERED) {
            this.f27232a.a(abVar);
        }
    }

    @Override // com.beizi.fusion.va
    public void a(fe feVar) {
        this.f27232a = feVar;
        feVar.a(this);
    }
}
