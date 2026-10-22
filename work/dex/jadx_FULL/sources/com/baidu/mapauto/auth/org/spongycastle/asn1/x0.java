package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class x0 extends p {
    public x0(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final x0 a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final void a(d dVar) throws IOException {
        if (dVar == null) {
            throw new IOException("null object detected");
        }
        dVar.c().g().a(this);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final p b() {
        return this;
    }
}
