package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class n extends r implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f26631a;

    public n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("string cannot be null");
        }
        this.f26631a = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof n) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f26631a, ((n) rVar).f26631a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new ByteArrayInputStream(this.f26631a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new v0(this.f26631a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new v0(this.f26631a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(i());
    }

    public byte[] i() {
        return this.f26631a;
    }

    public final String toString() {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("#");
        byte[] bArr = this.f26631a;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.e eVar = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f26663a;
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            eVar.getClass();
            for (int i = 0; i < 0 + length; i++) {
                int i2 = bArr[i] & 255;
                byteArrayOutputStream.write(eVar.f26664a[i2 >>> 4]);
                byteArrayOutputStream.write(eVar.f26664a[i2 & 15]);
            }
            sbA.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(byteArrayOutputStream.toByteArray()));
            return sbA.toString();
        } catch (Exception e) {
            StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("exception encoding Hex string: ");
            sbA2.append(e.getMessage());
            throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA2.toString(), e);
        }
    }
}
