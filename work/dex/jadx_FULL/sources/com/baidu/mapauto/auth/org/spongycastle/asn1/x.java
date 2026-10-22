package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class x extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f26651a;

    public x(byte[] bArr) {
        this.f26651a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(23);
        int length = this.f26651a.length;
        pVar.b(length);
        for (int i = 0; i != length; i++) {
            pVar.a(this.f26651a[i]);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof x) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f26651a, ((x) rVar).f26651a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        int length = this.f26651a.length;
        return u1.a(length) + 1 + length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f26651a);
    }

    public final String toString() {
        return com.baidu.mapauto.auth.org.spongycastle.util.d.a(this.f26651a);
    }
}
