package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class gu5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public T f41987a;

    @Nullable
    public T b;

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.f41987a = t;
        this.b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return a(pair.first, this.f41987a) && a(pair.second, this.b);
    }

    public int hashCode() {
        T t = this.f41987a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f41987a + " " + this.b + "}";
    }
}
