package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26605a;
    public final int b;
    public final byte[] c;

    public a(boolean z, int i, byte[] bArr) {
        this.f26605a = z;
        this.b = i;
        this.c = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public void a(p pVar) throws IOException {
        int i = this.f26605a ? 96 : 64;
        int i2 = this.b;
        byte[] bArr = this.c;
        pVar.a(i, i2);
        pVar.b(bArr.length);
        pVar.f26634a.write(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof a)) {
            return false;
        }
        a aVar = (a) rVar;
        return this.f26605a == aVar.f26605a && this.b == aVar.b && com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.c, aVar.c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return u1.a(this.c.length) + u1.b(this.b) + this.c.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return this.f26605a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        boolean z = this.f26605a;
        return ((z ? 1 : 0) ^ this.b) ^ com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.c);
    }
}
