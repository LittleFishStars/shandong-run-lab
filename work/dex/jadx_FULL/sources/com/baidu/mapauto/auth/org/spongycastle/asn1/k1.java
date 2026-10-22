package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class k1 extends p {
    public k1(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p
    public final void a(d dVar) throws IOException {
        if (dVar == null) {
            throw new IOException("null object detected");
        }
        dVar.c().h().a(this);
    }
}
