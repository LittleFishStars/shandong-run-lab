package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d0 extends s {
    public d0() {
    }

    public d0(e eVar) {
        super(eVar);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(48);
        pVar.a(128);
        Enumeration enumerationElements = this.f26641a.elements();
        while (enumerationElements.hasMoreElements()) {
            pVar.a((d) enumerationElements.nextElement());
        }
        pVar.a(0);
        pVar.a(0);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        Enumeration enumerationElements = this.f26641a.elements();
        int iE = 0;
        while (enumerationElements.hasMoreElements()) {
            iE += ((d) enumerationElements.nextElement()).c().e();
        }
        return iE + 2 + 2;
    }
}
