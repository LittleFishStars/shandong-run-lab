package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzls;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zcd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzlm f46234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzls f21019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public led f21020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Long f21021a;
    public Long b;
    public Long c;

    public final zcd b(Long l) {
        this.c = l;
        return this;
    }

    public final zcd c(zzls zzlsVar) {
        this.f21019a = zzlsVar;
        return this;
    }

    public final zcd d(zzlm zzlmVar) {
        this.f46234a = zzlmVar;
        return this;
    }

    public final zcd e(Long l) {
        this.b = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zcd f(led ledVar) {
        this.f21020a = ledVar;
        return this;
    }

    public final zcd g(Long l) {
        this.f21021a = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final hdd i() {
        return new hdd(this, null);
    }
}
