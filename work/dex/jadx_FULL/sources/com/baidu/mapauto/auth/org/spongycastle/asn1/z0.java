package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class z0 extends s {
    public int b;

    public z0() {
        this.b = -1;
    }

    public z0(e eVar) {
        super(eVar);
        this.b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        x0 x0VarA = pVar.a();
        int iJ = j();
        pVar.a(48);
        pVar.b(iJ);
        Enumeration enumerationElements = this.f26641a.elements();
        while (enumerationElements.hasMoreElements()) {
            x0VarA.a((d) enumerationElements.nextElement());
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iJ = j();
        return u1.a(iJ) + 1 + iJ;
    }

    public final int j() throws IOException {
        if (this.b < 0) {
            Enumeration enumerationElements = this.f26641a.elements();
            int iE = 0;
            while (enumerationElements.hasMoreElements()) {
                iE += ((d) enumerationElements.nextElement()).c().g().e();
            }
            this.b = iE;
        }
        return this.b;
    }
}
