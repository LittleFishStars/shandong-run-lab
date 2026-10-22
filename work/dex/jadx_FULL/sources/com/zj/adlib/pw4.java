package com.zj.adlib;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pw4 implements CacheEvictor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TreeSet<aa1> f18947a = new TreeSet<>(new Comparator() { // from class: com.zj.adlib.ow4
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return pw4.f((aa1) obj, (aa1) obj2);
        }
    });
    public long b;

    public pw4(long j) {
        this.f44072a = j;
    }

    public static int f(aa1 aa1Var, aa1 aa1Var2) {
        long j = aa1Var.c;
        long j2 = aa1Var2.c;
        if (j - j2 == 0) {
            return aa1Var.compareTo(aa1Var2);
        }
        return j < j2 ? -1 : 1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void a(Cache cache, aa1 aa1Var) {
        this.f18947a.add(aa1Var);
        this.b += aa1Var.b;
        g(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void b(Cache cache, aa1 aa1Var) {
        this.f18947a.remove(aa1Var);
        this.b -= aa1Var.b;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void c(Cache cache, aa1 aa1Var, aa1 aa1Var2) {
        b(cache, aa1Var);
        a(cache, aa1Var2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void d(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            g(cache, j2);
        }
    }

    public final void g(Cache cache, long j) {
        while (this.b + j > this.f44072a && !this.f18947a.isEmpty()) {
            cache.h(this.f18947a.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return true;
    }
}
