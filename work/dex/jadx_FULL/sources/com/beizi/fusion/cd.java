package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class cd implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dd f27139a;
    private volatile boolean b = false;

    public void b() {
        synchronized (this) {
            this.b = false;
        }
    }

    public void a(Object obj) {
        this.b = false;
    }

    @Override // com.beizi.fusion.va
    public void a() {
        synchronized (this) {
            this.b = true;
        }
    }

    public void a(xa xaVar, View view, Object obj) {
        dd ddVar;
        synchronized (this) {
            if (this.b && (ddVar = this.f27139a) != null && (xaVar instanceof dd.a)) {
                ddVar.a(view, (dd.a) xaVar);
            }
        }
    }

    @Override // com.beizi.fusion.va
    public void a(dd ddVar) {
        synchronized (this) {
            this.f27139a = ddVar;
            ddVar.a(this);
        }
    }
}
