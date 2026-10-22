package com.zj.adlib;

import com.amap.api.col.p0003l.he;
import com.amap.api.col.p0003l.ij;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class pbb extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public he f43945a;

    public pbb() {
        this.f43945a = new b9b();
    }

    @Override // com.amap.api.col.p0003l.ij
    public final byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        return this.f43945a.b(bArr);
    }

    public pbb(ij ijVar) {
        super(ijVar);
        this.f43945a = new b9b();
    }
}
