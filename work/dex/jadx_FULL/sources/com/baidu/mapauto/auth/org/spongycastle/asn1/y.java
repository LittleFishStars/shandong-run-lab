package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class y extends a {
    public y(int i, e eVar) {
        super(true, i, a(eVar));
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.a, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f26605a ? 96 : 64, this.b);
        pVar.a(128);
        pVar.f26634a.write(this.c);
        pVar.a(0);
        pVar.a(0);
    }

    public static byte[] a(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != eVar.f26614a.size(); i++) {
            try {
                byteArrayOutputStream.write(((l) eVar.a(i)).a("BER"));
            } catch (IOException e) {
                throw new q("malformed object: " + e, e);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
