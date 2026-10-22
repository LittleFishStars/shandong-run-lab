package com.igexin.push.core.a.a;

import com.igexin.push.d.c.q;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e extends com.igexin.push.core.a.a {
    private static final String b = com.igexin.push.config.c.f37909a + "_RegisterFailResultAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if ((obj instanceof q) && ((q) obj).b == 1) {
            String str = b;
            com.igexin.c.a.c.a.a(str, "Register failed because of the wrong appid");
            com.igexin.c.a.c.a.a(str + "|Register failed because of the wrong appid", new Object[0]);
            com.igexin.c.a.c.a.d.a().a("Register failed because of the wrong appid = " + com.igexin.push.core.e.f38001a);
            com.igexin.push.core.e.q = true;
            com.igexin.push.core.d.a.f37984a.h.b();
        }
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
