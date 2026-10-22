package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ff implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gf f27295a;
    private boolean b;

    public void b() {
        this.b = false;
    }

    @Override // com.beizi.fusion.va
    public void a() {
        this.b = true;
    }

    public void a(xa xaVar, View view, Integer num) {
        if (this.b) {
            if (xaVar == gf.a.VIDEO_START) {
                this.f27295a.c(xaVar);
            }
            if (xaVar == gf.a.VIDEO_PROCESS) {
                this.f27295a.a(xaVar, num.intValue());
            }
            if (xaVar == gf.a.VIDEO_FINISHED) {
                this.f27295a.e(xaVar);
            }
            if (xaVar == gf.a.VIDEO_ERROR) {
                this.f27295a.j(xaVar);
            }
            if (xaVar == gf.a.VIDEO_PREPARED) {
                this.f27295a.b(xaVar, num.intValue());
            }
            if (xaVar == gf.a.VIDEO_CACHE_FAILED) {
                this.f27295a.i(xaVar);
            }
        }
    }

    @Override // com.beizi.fusion.va
    public void a(gf gfVar) {
        this.f27295a = gfVar;
        gfVar.a(this);
    }
}
