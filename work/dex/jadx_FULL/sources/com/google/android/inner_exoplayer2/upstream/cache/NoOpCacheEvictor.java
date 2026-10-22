package com.google.android.inner_exoplayer2.upstream.cache;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class NoOpCacheEvictor implements CacheEvictor {
    @Override // com.google.android.inner_exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // com.google.android.inner_exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
    }

    @Override // com.google.android.inner_exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
    }

    @Override // com.google.android.inner_exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    @Override // com.google.android.inner_exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache, String str, long j, long j2) {
    }

    @Override // com.google.android.inner_exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return false;
    }
}
