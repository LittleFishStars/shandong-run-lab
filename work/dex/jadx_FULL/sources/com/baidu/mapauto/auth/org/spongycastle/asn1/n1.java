package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n1 extends w {
    public n1(boolean z, int i, d dVar) {
        super(z, i, dVar);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        r rVarH = this.c.c().h();
        if (!this.b) {
            pVar.a(rVarH.f() ? 160 : 128, this.f26649a);
            pVar.a(rVarH);
        } else {
            pVar.a(160, this.f26649a);
            pVar.b(rVarH.e());
            pVar.a((d) rVarH);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iE = this.c.c().h().e();
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
        return this.c.c().h().f();
    }
}
