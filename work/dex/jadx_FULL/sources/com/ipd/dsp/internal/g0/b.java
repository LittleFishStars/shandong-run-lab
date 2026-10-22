package com.ipd.dsp.internal.g0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b implements Runnable {
    public final String f;

    public b(String str) {
        this.f = str;
    }

    public abstract void a() throws InterruptedException;

    public abstract void a(InterruptedException interruptedException);

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f);
        try {
            a();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            a(e);
        } finally {
            Thread.currentThread().setName(name);
            b();
        }
    }
}
