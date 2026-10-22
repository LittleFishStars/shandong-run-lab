package com.igexin.push.core.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f37924a;

    private void d() {
        if (this.f37924a) {
            return;
        }
        this.f37924a = true;
    }

    private boolean e() {
        return this.f37924a;
    }

    public abstract void a();

    public boolean a(Object obj) {
        return true;
    }

    public abstract void b();

    public boolean c() {
        return true;
    }
}
