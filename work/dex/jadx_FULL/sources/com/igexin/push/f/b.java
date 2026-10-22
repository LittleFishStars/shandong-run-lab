package com.igexin.push.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b {
    private static final String c = "ExtensionTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f38120a = 0;
    protected long b = 0;

    private void a(long j) {
        this.f38120a = j;
    }

    private boolean b() {
        System.currentTimeMillis();
        return System.currentTimeMillis() - this.f38120a > this.b;
    }

    public abstract void a();
}
