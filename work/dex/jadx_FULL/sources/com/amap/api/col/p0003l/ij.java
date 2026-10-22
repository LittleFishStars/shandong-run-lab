package com.amap.api.col.p0003l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ij f25974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f928a = null;

    public ij() {
    }

    public final byte[] a() throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        byte[] bArrA = a(this.f928a);
        ij ijVar = this.f25974a;
        if (ijVar == null) {
            return bArrA;
        }
        ijVar.f928a = bArrA;
        return ijVar.a();
    }

    public abstract byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException;

    public void b(byte[] bArr) {
    }

    public ij(ij ijVar) {
        this.f25974a = ijVar;
    }
}
