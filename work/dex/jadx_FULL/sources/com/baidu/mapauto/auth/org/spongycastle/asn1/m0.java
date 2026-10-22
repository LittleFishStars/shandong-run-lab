package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class m0 extends b {
    public m0(byte[] bArr, int i) {
        super(bArr, i);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        byte[] bArr = this.f26608a;
        int i = this.b;
        byte[] bArrA = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        if (i > 0) {
            int length = bArr.length - 1;
            bArrA[length] = (byte) ((255 << i) & bArrA[length]);
        }
        int length2 = bArrA.length + 1;
        byte[] bArr2 = new byte[length2];
        bArr2[0] = (byte) this.b;
        System.arraycopy(bArrA, 0, bArr2, 1, length2 - 1);
        pVar.a(bArr2, 3);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f26608a.length + 1) + 1 + this.f26608a.length + 1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    public static m0 a(Object obj) {
        if (obj == null || (obj instanceof m0)) {
            return (m0) obj;
        }
        if (obj instanceof j1) {
            j1 j1Var = (j1) obj;
            return new m0(j1Var.f26608a, j1Var.b);
        }
        if (obj instanceof byte[]) {
            try {
                return (m0) r.a((byte[]) obj);
            } catch (Exception e) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("encoding error in getInstance: ");
                sbA.append(e.toString());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
        sbA2.append(obj.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
