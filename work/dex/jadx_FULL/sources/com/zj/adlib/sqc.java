package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class sqc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public crc f44755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hkd f19626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f19627a;

    public final sqc a(Integer num) {
        this.f19627a = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final sqc b(hkd hkdVar) {
        this.f19626a = hkdVar;
        return this;
    }

    public final sqc c(crc crcVar) {
        this.f44755a = crcVar;
        return this;
    }

    public final jrc e() {
        return new jrc(this, null);
    }
}
