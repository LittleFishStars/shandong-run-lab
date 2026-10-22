package com.facebook.cache.common;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements CacheErrorLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f29935a;

    public static synchronized a b() {
        if (f29935a == null) {
            f29935a = new a();
        }
        return f29935a;
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void a(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
