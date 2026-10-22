package com.baidu.b.c.d;

import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f26288a;

    private a() {
    }

    public static a a() throws NoSuchPaddingException {
        a aVar = new a();
        c cVar = new c();
        aVar.f26288a = cVar;
        cVar.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) throws InvalidKeyException {
        this.f26288a.a(i, dVar, b.f26289a);
    }

    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException {
        if (bArr != null) {
            return this.f26288a.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
