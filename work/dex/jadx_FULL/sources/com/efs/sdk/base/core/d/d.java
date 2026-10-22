package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends a {
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    private AtomicInteger f = new AtomicInteger(0);
    public AtomicInteger c = new AtomicInteger(0);

    @Override // com.efs.sdk.base.core.d.a
    public final void a() {
        if ((this.d.get() == 0 && this.e.get() == 0 && this.b.get() == 0 && this.c.get() == 0 && this.f.get() == 0) || this.f29600a == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            return;
        }
        ControllerCenter controllerCenter = this.f29600a;
        int i = this.d.get();
        int i2 = this.e.get();
        int i3 = this.b.get();
        int i4 = this.c.get();
        int i5 = this.f.get();
        b bVar = new b("efs_core", "lf_st", f.a.f29604a.f29603a.c);
        bVar.put("create_cnt", Integer.valueOf(i));
        bVar.put("cache_cnt", Integer.valueOf(i2));
        bVar.put("req_cnt", Integer.valueOf(i3));
        bVar.put("err_cnt", Integer.valueOf(i4));
        bVar.put("expire_cnt", Integer.valueOf(i5));
        this.d.addAndGet(i * (-1));
        this.e.addAndGet(i2 * (-1));
        this.b.addAndGet(i3 * (-1));
        this.c.addAndGet(i4 * (-1));
        this.f.addAndGet(i5 * (-1));
        controllerCenter.send(bVar);
    }

    public final void b() {
        this.d.incrementAndGet();
    }

    public final void c() {
        this.e.incrementAndGet();
    }

    public final void d() {
        this.f.incrementAndGet();
    }
}
