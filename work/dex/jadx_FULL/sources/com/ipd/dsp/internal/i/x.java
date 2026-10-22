package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class x implements com.ipd.dsp.internal.f.f {
    public static final com.ipd.dsp.internal.d0.j<Class<?>, byte[]> k = new com.ipd.dsp.internal.d0.j<>(50);
    public final com.ipd.dsp.internal.j.b c;
    public final com.ipd.dsp.internal.f.f d;
    public final com.ipd.dsp.internal.f.f e;
    public final int f;
    public final int g;
    public final Class<?> h;
    public final com.ipd.dsp.internal.f.i i;
    public final com.ipd.dsp.internal.f.m<?> j;

    public x(com.ipd.dsp.internal.j.b bVar, com.ipd.dsp.internal.f.f fVar, com.ipd.dsp.internal.f.f fVar2, int i, int i2, com.ipd.dsp.internal.f.m<?> mVar, Class<?> cls, com.ipd.dsp.internal.f.i iVar) {
        this.c = bVar;
        this.d = fVar;
        this.e = fVar2;
        this.f = i;
        this.g = i2;
        this.j = mVar;
        this.h = cls;
        this.i = iVar;
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.c.a(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f).putInt(this.g).array();
        this.e.a(messageDigest);
        this.d.a(messageDigest);
        messageDigest.update(bArr);
        com.ipd.dsp.internal.f.m<?> mVar = this.j;
        if (mVar != null) {
            mVar.a(messageDigest);
        }
        this.i.a(messageDigest);
        messageDigest.update(a());
        this.c.put(bArr);
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.g == xVar.g && this.f == xVar.f && com.ipd.dsp.internal.d0.o.b(this.j, xVar.j) && this.h.equals(xVar.h) && this.d.equals(xVar.d) && this.e.equals(xVar.e) && this.i.equals(xVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        int iHashCode = (((((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g;
        com.ipd.dsp.internal.f.m<?> mVar = this.j;
        if (mVar != null) {
            iHashCode = (iHashCode * 31) + mVar.hashCode();
        }
        return (((iHashCode * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.d + ", signature=" + this.e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }

    public final byte[] a() {
        com.ipd.dsp.internal.d0.j<Class<?>, byte[]> jVar = k;
        byte[] bArrB = jVar.b(this.h);
        if (bArrB != null) {
            return bArrB;
        }
        byte[] bytes = this.h.getName().getBytes(com.ipd.dsp.internal.f.f.b);
        jVar.b(this.h, bytes);
        return bytes;
    }
}
