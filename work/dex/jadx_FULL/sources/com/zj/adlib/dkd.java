package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f41222a;
    public Long b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;

    public final dkd a(Long l) {
        this.c = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final dkd b(Long l) {
        this.d = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final dkd c(Long l) {
        this.f41222a = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final dkd d(Long l) {
        this.e = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final dkd e(Long l) {
        this.b = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final dkd f(Long l) {
        this.f = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final hkd g() {
        return new hkd(this, null);
    }
}
