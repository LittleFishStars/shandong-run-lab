package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n0 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f26632a;
    public j b;
    public r c;
    public int d;
    public r e;

    public n0(e eVar) {
        int i = 0;
        r rVarA = a(0, eVar);
        if (rVarA instanceof m) {
            this.f26632a = (m) rVarA;
            rVarA = a(1, eVar);
            i = 1;
        }
        if (rVarA instanceof j) {
            this.b = (j) rVarA;
            i++;
            rVarA = a(i, eVar);
        }
        if (!(rVarA instanceof w)) {
            this.c = rVarA;
            i++;
            rVarA = a(i, eVar);
        }
        if (eVar.a() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        }
        if (!(rVarA instanceof w)) {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
        w wVar = (w) rVarA;
        a(wVar.j());
        this.e = wVar.i();
    }

    public final void a(int i) {
        if (i >= 0 && i <= 2) {
            this.d = i;
            return;
        }
        throw new IllegalArgumentException("invalid encoding value: " + i);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m mVar = this.f26632a;
        if (mVar != null) {
            byteArrayOutputStream.write(mVar.a("DER"));
        }
        j jVar = this.b;
        if (jVar != null) {
            byteArrayOutputStream.write(jVar.a("DER"));
        }
        r rVar = this.c;
        if (rVar != null) {
            byteArrayOutputStream.write(rVar.a("DER"));
        }
        byteArrayOutputStream.write(new e1(true, this.d, this.e).a("DER"));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        pVar.a(32, 8);
        pVar.b(byteArray.length);
        pVar.f26634a.write(byteArray);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        r rVar2;
        j jVar;
        m mVar;
        if (!(rVar instanceof n0)) {
            return false;
        }
        if (this == rVar) {
            return true;
        }
        n0 n0Var = (n0) rVar;
        m mVar2 = this.f26632a;
        if (mVar2 != null && ((mVar = n0Var.f26632a) == null || !mVar.equals(mVar2))) {
            return false;
        }
        j jVar2 = this.b;
        if (jVar2 != null && ((jVar = n0Var.b) == null || !jVar.equals(jVar2))) {
            return false;
        }
        r rVar3 = this.c;
        if (rVar3 == null || ((rVar2 = n0Var.c) != null && rVar2.equals(rVar3))) {
            return this.e.equals(n0Var.e);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return d().length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        m mVar = this.f26632a;
        int iHashCode = mVar != null ? mVar.f26629a.hashCode() : 0;
        j jVar = this.b;
        if (jVar != null) {
            iHashCode ^= jVar.hashCode();
        }
        r rVar = this.c;
        if (rVar != null) {
            iHashCode ^= rVar.hashCode();
        }
        return iHashCode ^ this.e.hashCode();
    }

    public static r a(int i, e eVar) {
        if (eVar.f26614a.size() > i) {
            return eVar.a(i).c();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }
}
