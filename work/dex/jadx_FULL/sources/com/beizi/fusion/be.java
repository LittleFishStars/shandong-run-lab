package com.beizi.fusion;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class be extends cb {
    public be(Runnable runnable) {
        super(runnable);
    }

    @Override // com.beizi.fusion.cb
    public ScheduledExecutorService b() {
        fb fbVar = (fb) cn.a().b(null);
        if (fbVar instanceof bn) {
            return ((bn) fbVar).c();
        }
        return null;
    }
}
