package com.igexin.push.core.a.a;

import com.igexin.push.core.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends com.igexin.push.core.a.a {
    private static final String b = "HeartbeatAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (!(obj instanceof com.igexin.push.d.c.f)) {
            return true;
        }
        com.igexin.push.d.c.b.f38095a.d();
        com.igexin.c.a.c.a.a("heartbeatRsp", new Object[0]);
        j.a().a(j.a.f38072a);
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
