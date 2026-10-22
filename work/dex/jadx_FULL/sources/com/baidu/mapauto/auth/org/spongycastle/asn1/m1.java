package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class m1 extends u {
    public int c;

    public m1() {
        this.c = -1;
    }

    public m1(e eVar) {
        super(eVar);
        this.c = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        p pVarB = pVar.b();
        if (this.c < 0) {
            Enumeration enumerationElements = this.f26645a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.c = iE;
        }
        int i = this.c;
        pVar.a(49);
        pVar.b(i);
        Enumeration enumerationElements2 = this.f26645a.elements();
        while (enumerationElements2.hasMoreElements()) {
            pVarB.a((d) enumerationElements2.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.c < 0) {
            Enumeration enumerationElements = this.f26645a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.c = iE;
        }
        int i = this.c;
        return u1.a(i) + 1 + i;
    }
}
