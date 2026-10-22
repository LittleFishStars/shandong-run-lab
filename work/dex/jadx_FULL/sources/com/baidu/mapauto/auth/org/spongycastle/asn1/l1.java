package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class l1 extends s {
    public int b;

    public l1() {
        this.b = -1;
    }

    public l1(e eVar) {
        super(eVar);
        this.b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        p pVarB = pVar.b();
        if (this.b < 0) {
            Enumeration enumerationElements = this.f26641a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.b = iE;
        }
        int i = this.b;
        pVar.a(48);
        pVar.b(i);
        Enumeration enumerationElements2 = this.f26641a.elements();
        while (enumerationElements2.hasMoreElements()) {
            pVarB.a((d) enumerationElements2.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.b < 0) {
            Enumeration enumerationElements = this.f26641a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().h().e();
            }
            this.b = iE;
        }
        int i = this.b;
        return u1.a(i) + 1 + i;
    }
}
