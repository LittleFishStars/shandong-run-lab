package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.android.gms.internal.mlkit_vision_common.zzio;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v1d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzii f45273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzio f20163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f20164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Long f20165a;
    public Integer b;
    public Integer c;
    public Integer d;

    public final v1d b(Long l) {
        this.f20165a = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final v1d c(Integer num) {
        this.f20164a = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final v1d d(zzii zziiVar) {
        this.f45273a = zziiVar;
        return this;
    }

    public final v1d e(Integer num) {
        this.c = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final v1d f(zzio zzioVar) {
        this.f20163a = zzioVar;
        return this;
    }

    public final v1d g(Integer num) {
        this.b = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final v1d h(Integer num) {
        this.d = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final f2d j() {
        return new f2d(this, null);
    }
}
