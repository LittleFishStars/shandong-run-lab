package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class s1 extends s {
    public byte[] b;

    public s1(byte[] bArr) throws IOException {
        this.b = bArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized d a(int i) {
        byte[] bArr = this.b;
        if (bArr != null) {
            r1 r1Var = new r1(bArr);
            while (r1Var.hasMoreElements()) {
                this.f26641a.addElement(r1Var.nextElement());
            }
            this.b = null;
        }
        return super.a(i);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        byte[] bArr = this.b;
        if (bArr != null) {
            pVar.a(bArr, 48);
        } else {
            super.h().a(pVar);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        byte[] bArr = this.b;
        return bArr != null ? u1.a(bArr.length) + 1 + this.b.length : super.h().e();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        byte[] bArr = this.b;
        if (bArr != null) {
            r1 r1Var = new r1(bArr);
            while (r1Var.hasMoreElements()) {
                this.f26641a.addElement(r1Var.nextElement());
            }
            this.b = null;
        }
        return super.g();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        byte[] bArr = this.b;
        if (bArr != null) {
            r1 r1Var = new r1(bArr);
            while (r1Var.hasMoreElements()) {
                this.f26641a.addElement(r1Var.nextElement());
            }
            this.b = null;
        }
        return super.h();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized Enumeration i() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return this.f26641a.elements();
        }
        return new r1(bArr);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.s
    public final synchronized int size() {
        byte[] bArr = this.b;
        if (bArr != null) {
            r1 r1Var = new r1(bArr);
            while (r1Var.hasMoreElements()) {
                this.f26641a.addElement(r1Var.nextElement());
            }
            this.b = null;
        }
        return this.f26641a.size();
    }
}
