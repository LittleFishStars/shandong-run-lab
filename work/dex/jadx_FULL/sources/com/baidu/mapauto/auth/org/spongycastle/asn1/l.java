package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class l implements d {
    public final byte[] a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (str.equals("DER")) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            new x0(byteArrayOutputStream).a(this);
        } else {
            if (!str.equals("DL")) {
                return d();
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            new k1(byteArrayOutputStream).a(this);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public abstract r c();

    public final byte[] d() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new p(byteArrayOutputStream).a(this);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return c().equals(((d) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return c().hashCode();
    }
}
