package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c extends r {
    public static final byte[] b = {-1};
    public static final byte[] c = {0};
    public static final c d = new c(false);
    public static final c e = new c(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26610a;

    @Deprecated
    public c(boolean z) {
        this.f26610a = z ? b : c;
    }

    public c(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
        byte b2 = bArr[0];
        if (b2 == 0) {
            this.f26610a = c;
        } else if ((b2 & 255) == 255) {
            this.f26610a = b;
        } else {
            this.f26610a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f26610a, 1);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        return (rVar instanceof c) && this.f26610a[0] == ((c) rVar).f26610a[0];
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return 3;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f26610a[0];
    }

    public final String toString() {
        return this.f26610a[0] != 0 ? "TRUE" : "FALSE";
    }
}
