package com.zj.adlib;

import cn.hzjizhun.admin.base.r1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class nib extends r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dqb f43534a;

    public nib(dqb dqbVar) {
        this.f43534a = dqbVar;
    }

    @Override // cn.hzjizhun.admin.base.r1
    public final void b() {
        dqb dqbVar = this.f43534a;
        dqbVar.getClass();
        try {
            wtb wtbVar = dqbVar.f16060a;
            if (wtbVar.f20548a && (!wtbVar.d() || dqbVar.f41258a != null)) {
                dqbVar.f16059a.postDelayed(new xjb(dqbVar), dqbVar.f16060a.c);
                if (dqbVar.f16060a.d()) {
                    dqbVar.f16059a.sendEmptyMessageDelayed(3, dqbVar.f16060a.d);
                    dqbVar.f41258a.b();
                } else {
                    wtb wtbVar2 = dqbVar.f16060a;
                    if (wtbVar2.f20548a) {
                        int i = wtbVar2.f45689a;
                        if (i == 2 || i == 10) {
                            dqbVar.d(new bnb(dqbVar), wtbVar2.e);
                        } else if (i == 9) {
                            dqbVar.b();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
