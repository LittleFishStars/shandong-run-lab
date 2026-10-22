package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class n implements com.ipd.dsp.internal.f.f {
    public final Object c;
    public final int d;
    public final int e;
    public final Class<?> f;
    public final Class<?> g;
    public final com.ipd.dsp.internal.f.f h;
    public final Map<Class<?>, com.ipd.dsp.internal.f.m<?>> i;
    public final com.ipd.dsp.internal.f.i j;
    public int k;

    public n(Object obj, com.ipd.dsp.internal.f.f fVar, int i, int i2, Map<Class<?>, com.ipd.dsp.internal.f.m<?>> map, Class<?> cls, Class<?> cls2, com.ipd.dsp.internal.f.i iVar) {
        this.c = com.ipd.dsp.internal.d0.m.a(obj);
        this.h = (com.ipd.dsp.internal.f.f) com.ipd.dsp.internal.d0.m.a(fVar, "Signature must not be null");
        this.d = i;
        this.e = i2;
        this.i = (Map) com.ipd.dsp.internal.d0.m.a(map);
        this.f = (Class) com.ipd.dsp.internal.d0.m.a(cls, "Resource class must not be null");
        this.g = (Class) com.ipd.dsp.internal.d0.m.a(cls2, "Transcode class must not be null");
        this.j = (com.ipd.dsp.internal.f.i) com.ipd.dsp.internal.d0.m.a(iVar);
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.c.equals(nVar.c) && this.h.equals(nVar.h) && this.e == nVar.e && this.d == nVar.d && this.i.equals(nVar.i) && this.f.equals(nVar.f) && this.g.equals(nVar.g) && this.j.equals(nVar.j)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        if (this.k == 0) {
            int iHashCode = this.c.hashCode();
            this.k = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.h.hashCode()) * 31) + this.d) * 31) + this.e;
            this.k = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.i.hashCode();
            this.k = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f.hashCode();
            this.k = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.g.hashCode();
            this.k = iHashCode5;
            this.k = (iHashCode5 * 31) + this.j.hashCode();
        }
        return this.k;
    }

    public String toString() {
        return "EngineKey{model=" + this.c + ", width=" + this.d + ", height=" + this.e + ", resourceClass=" + this.f + ", transcodeClass=" + this.g + ", signature=" + this.h + ", hashCode=" + this.k + ", transformations=" + this.i + ", options=" + this.j + '}';
    }
}
