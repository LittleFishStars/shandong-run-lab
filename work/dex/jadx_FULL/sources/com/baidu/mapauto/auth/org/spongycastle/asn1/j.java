package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class j extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f26626a;

    public j(BigInteger bigInteger) {
        this.f26626a = bigInteger.toByteArray();
    }

    public j(byte[] bArr) {
        if (!com.baidu.mapauto.auth.org.spongycastle.util.c.a() && b(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f26626a = bArr;
    }

    public static j a(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (!(obj instanceof byte[])) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("illegal object in getInstance: ");
            sbA.append(obj.getClass().getName());
            throw new IllegalArgumentException(sbA.toString());
        }
        try {
            return (j) r.a((byte[]) obj);
        } catch (Exception e) {
            StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("encoding error in getInstance: ");
            sbA2.append(e.toString());
            throw new IllegalArgumentException(sbA2.toString());
        }
    }

    public static boolean b(byte[] bArr) {
        if (bArr.length > 1) {
            byte b = bArr[0];
            if (b == 0 && (bArr[1] & UnsignedBytes.f32243a) == 0) {
                return true;
            }
            if (b == -1 && (bArr[1] & UnsignedBytes.f32243a) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f26626a, 2);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (rVar instanceof j) {
            return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f26626a, ((j) rVar).f26626a);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return u1.a(this.f26626a.length) + 1 + this.f26626a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f26626a;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    public final BigInteger i() {
        return new BigInteger(1, this.f26626a);
    }

    public final String toString() {
        return new BigInteger(this.f26626a).toString();
    }
}
