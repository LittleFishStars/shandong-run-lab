package com.igexin.push.core.a.a;

import com.igexin.push.core.k;
import com.igexin.push.d.c.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends com.igexin.push.core.a.a {
    private static final String b = "KeyNegotiateResultAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            boolean z = hVar.b == 0;
            com.igexin.c.a.c.a.a("KeyNegotiateResultAction|KeyNego result = " + ((int) hVar.b), new Object[0]);
            if (z) {
                com.igexin.c.a.c.a.a("KeyNegotiateResultAction|KeyNego success and login", new Object[0]);
                k.a();
                k.c();
            }
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
