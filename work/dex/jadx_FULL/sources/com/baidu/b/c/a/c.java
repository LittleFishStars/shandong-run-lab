package com.baidu.b.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecureRandom f26279a = new SecureRandom();
    private e b;

    public c() {
        this.b = null;
        this.b = new e(new b(), 16);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public void a(int i, byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.b.a(i, bArr, bArr2, f26279a);
    }

    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        if (bArr != null) {
            return this.b.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
