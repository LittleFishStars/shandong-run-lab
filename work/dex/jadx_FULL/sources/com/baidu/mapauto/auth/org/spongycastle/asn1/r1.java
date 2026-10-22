package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r1 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f26640a;
    public r b = a();

    public r1(byte[] bArr) {
        this.f26640a = new i(bArr, 0);
    }

    public final r a() {
        try {
            return this.f26640a.a();
        } catch (IOException e) {
            throw new q("malformed DER construction: " + e, e);
        }
    }

    @Override // java.util.Enumeration
    public final boolean hasMoreElements() {
        return this.b != null;
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        r rVar = this.b;
        this.b = a();
        return rVar;
    }
}
