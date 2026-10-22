package com.google.android.exoplayer2.decoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class Buffer {
    public int K;

    public final void a(int i) {
        this.K = i | this.K;
    }

    public void b() {
        this.K = 0;
    }

    public final void c(int i) {
        this.K = (~i) & this.K;
    }

    public final boolean d() {
        return getFlag(268435456);
    }

    public final boolean e() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean f() {
        return getFlag(4);
    }

    public final boolean g() {
        return getFlag(134217728);
    }

    public final boolean getFlag(int i) {
        return (this.K & i) == i;
    }

    public final boolean h() {
        return getFlag(1);
    }

    public final void i(int i) {
        this.K = i;
    }
}
