package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d1 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f26613a;

    public d1(byte[] bArr) {
        this.f26613a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f26613a, 20);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof d1) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f26613a, ((d1) rVar).f26613a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f26613a.length) + 1 + this.f26613a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f26613a);
    }

    public final String toString() {
        return com.baidu.mapauto.auth.org.spongycastle.util.d.a(this.f26613a);
    }
}
