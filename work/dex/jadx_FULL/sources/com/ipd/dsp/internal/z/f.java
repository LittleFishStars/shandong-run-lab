package com.ipd.dsp.internal.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface f {

    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        public final boolean f;

        a(boolean z) {
            this.f = z;
        }

        public boolean a() {
            return this.f;
        }
    }

    void a(e eVar);

    boolean a();

    boolean b(e eVar);

    boolean d(e eVar);

    boolean e(e eVar);

    void f(e eVar);

    f getRoot();
}
