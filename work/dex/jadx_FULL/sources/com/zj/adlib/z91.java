package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.blankj.utilcode.constant.CacheConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class z91 implements CacheConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, z91> f46213a = new HashMap();
    public static final int e = 256;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LruCache<String, a> f21002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f21003a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f46214a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f21004a;

        public a(long j, Object obj) {
            this.f46214a = j;
            this.f21004a = obj;
        }
    }

    public z91(String str, LruCache<String, a> lruCache) {
        this.f21003a = str;
        this.f21002a = lruCache;
    }

    public static z91 e() {
        return f(256);
    }

    public static z91 f(int i) {
        return g(String.valueOf(i), i);
    }

    public static z91 g(String str, int i) {
        Map<String, z91> map = f46213a;
        z91 z91Var = map.get(str);
        if (z91Var == null) {
            synchronized (z91.class) {
                z91Var = map.get(str);
                if (z91Var == null) {
                    z91Var = new z91(str, new LruCache(i));
                    map.put(str, z91Var);
                }
            }
        }
        return z91Var;
    }

    public void a() {
        this.f21002a.evictAll();
    }

    public <T> T b(@NonNull String str) {
        return (T) c(str, null);
    }

    public <T> T c(@NonNull String str, T t) {
        a aVar = this.f21002a.get(str);
        if (aVar == null) {
            return t;
        }
        long j = aVar.f46214a;
        if (j == -1 || j >= System.currentTimeMillis()) {
            return (T) aVar.f21004a;
        }
        this.f21002a.remove(str);
        return t;
    }

    public int d() {
        return this.f21002a.size();
    }

    public void h(@NonNull String str, Object obj) {
        i(str, obj, -1);
    }

    public void i(@NonNull String str, Object obj, int i) {
        if (obj == null) {
            return;
        }
        this.f21002a.put(str, new a(i < 0 ? -1L : System.currentTimeMillis() + ((long) (i * 1000)), obj));
    }

    public Object j(@NonNull String str) {
        a aVarRemove = this.f21002a.remove(str);
        if (aVarRemove == null) {
            return null;
        }
        return aVarRemove.f21004a;
    }

    public String toString() {
        return this.f21003a + "@" + Integer.toHexString(hashCode());
    }
}
