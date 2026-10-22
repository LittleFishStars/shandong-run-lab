package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d implements com.ipd.dsp.internal.f.f {
    public final com.ipd.dsp.internal.f.f c;
    public final com.ipd.dsp.internal.f.f d;

    public d(com.ipd.dsp.internal.f.f fVar, com.ipd.dsp.internal.f.f fVar2) {
        this.c = fVar;
        this.d = fVar2;
    }

    public com.ipd.dsp.internal.f.f a() {
        return this.c;
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.c.equals(dVar.c) && this.d.equals(dVar.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return (this.c.hashCode() * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.c + ", signature=" + this.d + '}';
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.c.a(messageDigest);
        this.d.a(messageDigest);
    }
}
