package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzpj f40994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f15854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Long f15855a;
    public Boolean b;
    public Boolean c;

    public final cld a(Boolean bool) {
        this.b = bool;
        return this;
    }

    public final cld b(Boolean bool) {
        this.c = bool;
        return this;
    }

    public final cld c(Long l) {
        this.f15855a = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final cld d(zzpj zzpjVar) {
        this.f40994a = zzpjVar;
        return this;
    }

    public final cld e(Boolean bool) {
        this.f15854a = bool;
        return this;
    }

    public final gld f() {
        return new gld(this, null);
    }
}
