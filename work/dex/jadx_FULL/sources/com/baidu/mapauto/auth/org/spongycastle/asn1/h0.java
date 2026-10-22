package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class h0 extends w {
    public h0(boolean z, int i, d dVar) {
        super(z, i, dVar);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        Enumeration enumerationElements;
        pVar.a(160, this.f26649a);
        pVar.a(128);
        if (this.b) {
            pVar.a(this.c);
        } else {
            d dVar = this.c;
            if (dVar instanceof n) {
                enumerationElements = dVar instanceof b0 ? ((b0) dVar).j() : new b0(((n) dVar).i()).j();
            } else if (dVar instanceof s) {
                enumerationElements = ((s) dVar).i();
            } else {
                if (!(dVar instanceof u)) {
                    StringBuilder sbA = com.baidu.mapauto.auth.a.a("not implemented: ");
                    sbA.append(this.c.getClass().getName());
                    throw new g(sbA.toString());
                }
                enumerationElements = ((u) dVar).f26645a.elements();
            }
            while (enumerationElements.hasMoreElements()) {
                pVar.a((d) enumerationElements.nextElement());
            }
        }
        pVar.a(0);
        pVar.a(0);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iE = this.c.c().e();
        if (this.b) {
            return u1.a(iE) + u1.b(this.f26649a) + iE;
        }
        return u1.b(this.f26649a) + (iE - 1);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        if (this.b) {
            return true;
        }
        return this.c.c().g().f();
    }
}
