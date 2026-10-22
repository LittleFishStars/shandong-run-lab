package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class r extends l {
    public static r a(byte[] bArr) throws IOException {
        i iVar = new i(bArr);
        try {
            r rVarA = iVar.a();
            if (iVar.available() == 0) {
                return rVarA;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract void a(p pVar) throws IOException;

    public abstract boolean a(r rVar);

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        return this;
    }

    public abstract int e() throws IOException;

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && a(((d) obj).c());
    }

    public abstract boolean f();

    public r g() {
        return this;
    }

    public r h() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public abstract int hashCode();
}
