package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e1 extends w {
    public e1(boolean z, int i, d dVar) {
        super(z, i, dVar);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        r rVarG = this.c.c().g();
        if (!this.b) {
            pVar.a(rVarG.f() ? 160 : 128, this.f26649a);
            pVar.a(rVarG);
        } else {
            pVar.a(160, this.f26649a);
            pVar.b(rVarG.e());
            pVar.a((d) rVarG);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int iE = this.c.c().g().e();
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
