package com.ipd.dsp.internal.b;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.b.i;
import com.ipd.dsp.internal.b0.j;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.d0.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class i<CHILD extends i<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public com.ipd.dsp.internal.b0.g<? super TranscodeType> f = com.ipd.dsp.internal.b0.e.b();

    @NonNull
    public final CHILD a() {
        return (CHILD) a(com.ipd.dsp.internal.b0.e.b());
    }

    public final com.ipd.dsp.internal.b0.g<? super TranscodeType> b() {
        return this.f;
    }

    public final CHILD c() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return o.b(this.f, ((i) obj).f);
        }
        return false;
    }

    public int hashCode() {
        com.ipd.dsp.internal.b0.g<? super TranscodeType> gVar = this.f;
        if (gVar != null) {
            return gVar.hashCode();
        }
        return 0;
    }

    @NonNull
    public final CHILD a(int i) {
        return (CHILD) a(new com.ipd.dsp.internal.b0.h(i));
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m998clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public final CHILD a(@NonNull j.a aVar) {
        return (CHILD) a(new com.ipd.dsp.internal.b0.i(aVar));
    }

    @NonNull
    public final CHILD a(@NonNull com.ipd.dsp.internal.b0.g<? super TranscodeType> gVar) {
        this.f = (com.ipd.dsp.internal.b0.g) m.a(gVar);
        return (CHILD) c();
    }
}
