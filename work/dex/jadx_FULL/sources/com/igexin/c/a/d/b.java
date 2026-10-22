package com.igexin.c.a.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b implements com.igexin.c.a.d.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f37839a;
    private long b;
    protected String y = getClass().getName();

    @Override // com.igexin.c.a.d.a.e
    public final void a(boolean z) {
        this.f37839a = !z;
    }

    @Override // com.igexin.c.a.d.a.e
    public final void b(long j) {
        this.b = j;
    }

    @Override // com.igexin.c.a.d.a.e
    public final boolean j() {
        return this.f37839a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final long k() {
        return this.b;
    }
}
