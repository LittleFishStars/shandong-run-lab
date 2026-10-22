package com.facebook.cache.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b implements CacheEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f29936a;

    public static synchronized b g() {
        if (f29936a == null) {
            f29936a = new b();
        }
        return f29936a;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void a() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void b() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void c(CacheEventListener.EvictionReason evictionReason, int i, long j) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void d() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void e() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void f() {
    }
}
