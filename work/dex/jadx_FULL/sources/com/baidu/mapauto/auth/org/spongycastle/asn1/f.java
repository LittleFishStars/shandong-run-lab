package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f extends r {
    public static f[] b = new f[12];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26616a;

    public f(byte[] bArr) {
        if (!com.baidu.mapauto.auth.org.spongycastle.util.c.a() && j.b(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        this.f26616a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f26616a, 10);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof f) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f26616a, ((f) rVar).f26616a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f26616a.length) + 1 + this.f26616a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f26616a);
    }
}
