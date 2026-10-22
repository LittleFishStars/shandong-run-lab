package com.igexin.push.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f implements com.igexin.push.f.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38130a = "SilentTask";
    private static f b;
    private boolean c = com.igexin.push.g.c.a(System.currentTimeMillis());

    private f() {
    }

    public static f a() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        d();
    }

    @Override // com.igexin.push.f.b.c
    public final boolean c() {
        return com.igexin.push.config.d.c != 0;
    }

    public final void d() {
        boolean z = this.c;
        boolean zA = com.igexin.push.g.c.a(System.currentTimeMillis());
        this.c = zA;
        if (!z || zA) {
            return;
        }
        com.igexin.c.a.c.a.b(f38130a, "out silence time");
        a.a().a(false);
    }
}
