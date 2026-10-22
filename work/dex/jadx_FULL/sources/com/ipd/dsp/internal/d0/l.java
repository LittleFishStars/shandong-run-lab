package com.ipd.dsp.internal.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f38280a;
    public Class<?> b;
    public Class<?> c;

    public l() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f38280a.equals(lVar.f38280a) && this.b.equals(lVar.b) && o.b(this.c, lVar.c);
    }

    public int hashCode() {
        int iHashCode = ((this.f38280a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class<?> cls = this.c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f38280a + ", second=" + this.b + '}';
    }

    public l(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f38280a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public l(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
