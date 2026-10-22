package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f26611a;

    public c0(v vVar) {
        this.f26611a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        InputStream inputStreamB = b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStreamB.read(bArr, 0, 4096);
            if (i < 0) {
                return new b0(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return new j0(this.f26611a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("IOException converting stream to byte array: ");
            sbA.append(e.getMessage());
            throw new q(sbA.toString(), e);
        }
    }
}
