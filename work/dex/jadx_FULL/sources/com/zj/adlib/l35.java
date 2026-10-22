package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class l35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l35 f42986a = new l35();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LruCache<String, k35> f17869a = new LruCache<>(20);

    @VisibleForTesting
    public l35() {
    }

    public static l35 c() {
        return f42986a;
    }

    public void a() {
        this.f17869a.evictAll();
    }

    @Nullable
    public k35 b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f17869a.get(str);
    }

    public void d(@Nullable String str, k35 k35Var) {
        if (str == null) {
            return;
        }
        this.f17869a.put(str, k35Var);
    }

    public void e(int i) {
        this.f17869a.resize(i);
    }
}
