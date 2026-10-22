package com.alipay.android.phone.mobilesdk.socketcraft.e;

import com.ali.auth.third.login.LoginConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alipay.android.phone.mobilesdk.socketcraft.a.b f25295a;
    private e b;

    public b(com.alipay.android.phone.mobilesdk.socketcraft.a.b bVar) {
        this.f25295a = bVar;
    }

    public void a() {
        c().b = System.currentTimeMillis();
        d dVarA = a(c.d);
        dVarA.k(String.valueOf(c().j));
        dVarA.l(String.valueOf(c().k));
        dVarA.m(String.valueOf(c().l));
        dVarA.n(String.valueOf(c().m));
        dVarA.o(c().i);
        dVarA.c(String.valueOf(c().a()));
        dVarA.a(true);
        com.alipay.android.phone.mobilesdk.socketcraft.f.b.c.a().a(dVarA);
    }

    public void b() {
        c().d = System.currentTimeMillis();
        d dVarA = a(c.e);
        dVarA.h(String.valueOf(c().e));
        dVarA.j(String.valueOf(c().g));
        dVarA.g(String.valueOf(c().f));
        dVarA.i(String.valueOf(c().h));
        dVarA.f(String.valueOf(c().b()));
        com.alipay.android.phone.mobilesdk.socketcraft.f.b.c.a().a(dVarA);
        this.b = null;
    }

    public e c() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        this.b = eVar2;
        return eVar2;
    }

    public void d() {
        c().f25298a = System.currentTimeMillis();
    }

    public void e() {
        c().c = System.currentTimeMillis();
    }

    public void d(long j) {
        if (j <= 0) {
            return;
        }
        c().m = j;
    }

    public void c(long j) {
        if (j <= 0) {
            return;
        }
        c().l = j;
    }

    public void b(int i) {
        e eVarC = c();
        eVarC.f++;
        String str = eVarC.h;
        if (str != null && str.length() > 0) {
            eVarC.h += LoginConstants.UNDER_LINE + i;
            return;
        }
        eVarC.h = String.valueOf(i);
    }

    public void a(String str, String str2) {
        d dVarA = a("error");
        dVarA.d(str);
        dVarA.e(str2);
        com.alipay.android.phone.mobilesdk.socketcraft.f.b.c.a().a(dVarA);
    }

    public d a(String str) {
        d dVar = new d();
        dVar.f25297a = str;
        dVar.a(this.f25295a.t());
        dVar.b(this.f25295a.s());
        return dVar;
    }

    public void b(String str) {
        if (com.alipay.android.phone.mobilesdk.socketcraft.g.c.a(str) || "null".equals(str)) {
            return;
        }
        c().i = str;
    }

    public void b(long j) {
        if (j <= 0) {
            return;
        }
        c().k = j;
    }

    public void a(int i) {
        e eVarC = c();
        eVarC.e++;
        String str = eVarC.g;
        if (str != null && str.length() > 0) {
            eVarC.g += LoginConstants.UNDER_LINE + i;
            return;
        }
        eVarC.g = String.valueOf(i);
    }

    public void a(long j) {
        if (j <= 0) {
            return;
        }
        c().j = j;
    }

    public final void a(a aVar) {
        com.alipay.android.phone.mobilesdk.socketcraft.f.b.c.a().a(aVar);
    }
}
