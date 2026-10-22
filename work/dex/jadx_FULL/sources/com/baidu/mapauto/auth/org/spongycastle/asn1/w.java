package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class w extends r implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26649a;
    public boolean b;
    public d c;

    public w(boolean z, int i, d dVar) {
        this.c = null;
        this.b = z;
        this.f26649a = i;
        if (!z) {
            boolean z2 = dVar.c() instanceof u;
        }
        this.c = dVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof w)) {
            return false;
        }
        w wVar = (w) rVar;
        if (this.f26649a != wVar.f26649a || this.b != wVar.b) {
            return false;
        }
        d dVar = this.c;
        if (dVar == null) {
            return wVar.c == null;
        }
        return dVar.c().equals(wVar.c.c());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new e1(this.b, this.f26649a, this.c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new n1(this.b, this.f26649a, this.c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int i = this.f26649a;
        d dVar = this.c;
        return dVar != null ? i ^ dVar.hashCode() : i;
    }

    public final r i() {
        d dVar = this.c;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public final int j() {
        return this.f26649a;
    }

    public final String toString() {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("[");
        sbA.append(this.f26649a);
        sbA.append("]");
        sbA.append(this.c);
        return sbA.toString();
    }
}
