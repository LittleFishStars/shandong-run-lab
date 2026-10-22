package com.igexin.push.e;

import com.igexin.c.a.b.a.a.d;
import com.igexin.c.a.b.a.a.j;
import com.igexin.c.a.b.e;
import com.igexin.c.a.d.f;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.l;
import com.igexin.push.d.c.c;
import com.igexin.push.d.c.i;
import com.igexin.push.g.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f38112a = "com.igexin.push.e.a";
    public boolean b;

    private int a(String str, c cVar) {
        return a(str, cVar, false);
    }

    public static void a(int i) {
        if (i == j.f37825a) {
            e.a().a(new com.igexin.push.d.b.b());
            e.a().b();
        } else if (i == j.b) {
            e.a().a(new com.igexin.push.d.b.a());
            e.a().b();
        }
    }

    public static void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.igexin.push.core.a.b.d().a(cVar);
    }

    public static void a(boolean z) {
        com.igexin.c.a.c.a.a(f38112a + "|call -> disconnect, reset delay = " + z, new Object[0]);
        if (z) {
            com.igexin.push.core.e.b(0L);
        }
        d.a().d();
    }

    private void b(boolean z) {
        com.igexin.c.a.c.a.a(f38112a, "call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O);
        com.igexin.c.a.c.a.a(f38112a + "|call setActive, param active = " + z + "; this.active = " + this.b + "; reConnectDelayTime=" + com.igexin.push.core.e.O, new Object[0]);
        boolean z2 = this.b;
        if (z2 == z) {
            if (!z2 || com.igexin.push.core.e.u || com.igexin.push.core.e.O <= com.igexin.push.config.c.j) {
                return;
            }
            com.igexin.c.a.c.a.a(f38112a + "|start active again, online = false, reset delay", new Object[0]);
            com.igexin.push.core.e.b(0L);
            c();
            return;
        }
        this.b = z;
        if (z) {
            com.igexin.c.a.c.a.a(f38112a + "|active = true, start connect~~~~", new Object[0]);
            g();
            return;
        }
        com.igexin.c.a.c.a.a(f38112a + "|active = false, disconnect...", new Object[0]);
        a(true);
    }

    public static void c() {
        com.igexin.push.core.e.b(com.igexin.push.d.c.b.f38095a.e.a());
        com.igexin.push.f.b.e.g().a(com.igexin.push.core.e.O);
    }

    public static void d() {
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.d);
        boolean zE = com.igexin.push.g.c.e();
        com.igexin.c.a.c.a.a(f38112a, "network changed, available = " + zE + ", last = " + com.igexin.push.core.e.n);
        com.igexin.c.a.c.a.a(f38112a + "|network changed, available = " + zE + ", last = " + com.igexin.push.core.e.n, new Object[0]);
        com.igexin.push.d.c.b.f38095a.a();
        if (!zE) {
            com.igexin.c.a.c.a.a(f38112a + "|network changed, available = false, do nothing", new Object[0]);
            a(false);
        } else if (!com.igexin.push.core.e.n) {
            com.igexin.c.a.c.a.a(f38112a + "|network changed, try connect reset delay", new Object[0]);
            g();
        }
        if (zE) {
            com.igexin.push.c.c.a().c();
        }
        com.igexin.push.core.e.n = zE;
    }

    public static boolean e() {
        return (com.igexin.push.core.e.p && com.igexin.push.core.e.s) ? false : true;
    }

    private boolean f() {
        return this.b;
    }

    private static void g() {
        com.igexin.c.a.c.a.a(f38112a + "|call -> tryConnect and reset delay = 0", new Object[0]);
        a(true);
    }

    private static void h() {
        com.igexin.push.d.a.c.b = -1;
        if (com.igexin.push.core.e.q) {
            com.igexin.c.a.c.a.a(f38112a, "isAppidWrong = true");
            com.igexin.c.a.c.a.a(f38112a + "|isAppidWrong = true", new Object[0]);
            com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
            return;
        }
        if (!g.a()) {
            com.igexin.c.a.c.a.a(f38112a, "so error ++++++++");
            com.igexin.c.a.c.a.a(f38112a + "|so error ++++++++", new Object[0]);
            return;
        }
        if (com.igexin.push.core.e.az) {
            c();
            return;
        }
        com.igexin.c.a.c.a.a(f38112a, "initSuccess = false");
        com.igexin.c.a.c.a.a(f38112a + "|initSuccess = false", new Object[0]);
    }

    private static void i() {
        com.igexin.push.c.c.a().d().c();
        com.igexin.push.c.a aVarD = com.igexin.push.c.c.a().d();
        com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.c);
        aVarD.f();
        if (e()) {
            com.igexin.c.a.c.a.a(f38112a, "sdkOn = false or pushOn = false, disconnect|user");
            com.igexin.c.a.c.a.a(f38112a + "|sdkOn = false or pushOn = false, disconnect|user", new Object[0]);
        } else {
            com.igexin.c.a.c.a.a(f38112a + "|disconnect by network", new Object[0]);
        }
        com.igexin.c.a.d.e<f> eVar = e.a().s;
        if (eVar != null) {
            eVar.a(com.igexin.c.a.b.a.a.f.class);
        }
        a(false);
    }

    public final int a(String str, c cVar, boolean z) {
        if (str == null || cVar == null) {
            return -1;
        }
        if (!com.igexin.push.core.e.u && !(cVar instanceof com.igexin.push.d.c.g) && !(cVar instanceof i) && !(cVar instanceof com.igexin.push.d.c.d)) {
            com.igexin.c.a.c.a.a("networkLayer|sendData|not online|" + cVar.getClass().getName(), new Object[0]);
            return -3;
        }
        if (this.b) {
            if (z) {
                int i = com.igexin.push.config.d.f;
                if (i <= 0) {
                    i = 10;
                }
                if (e.a().a(SDKUrlConfig.getConnectAddress(), com.igexin.push.core.d.a.f37984a.g, cVar, i, new com.igexin.push.d.f()) == null) {
                    return -2;
                }
            } else if (e.a().a(SDKUrlConfig.getConnectAddress(), com.igexin.push.core.d.a.f37984a.g, cVar) == null) {
                return -2;
            }
        }
        return 0;
    }

    public final void a() {
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.s;
        boolean zA = com.igexin.push.g.c.a();
        if (z && z2 && zA) {
            b(true);
        }
    }

    public final void b() {
        b(false);
        if (com.igexin.push.core.e.u) {
            com.igexin.push.core.e.u = false;
            l.a().b();
        }
        com.igexin.c.a.c.a.a(f38112a + "|stop by user", new Object[0]);
        com.igexin.push.c.c.a().d().f();
    }
}
