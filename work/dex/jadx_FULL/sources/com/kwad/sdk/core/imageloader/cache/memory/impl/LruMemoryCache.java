package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.utils.az;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class LruMemoryCache implements MemoryCache {
    private final LinkedHashMap<String, DecodedResult> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int sizeOf(String str, DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    private void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                }
                if (this.size > i && !this.map.isEmpty()) {
                    Map.Entry<String, DecodedResult> next = this.map.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    DecodedResult value = next.getValue();
                    this.map.remove(key);
                    this.size -= sizeOf(key, value);
                }
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        trimToSize(-1);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult get(String str) {
        DecodedResult decodedResult;
        az.aC(str, CachedContentIndex.a.e);
        synchronized (this) {
            decodedResult = this.map.get(str);
        }
        return decodedResult;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final boolean put(String str, DecodedResult decodedResult) {
        az.aC(str, CachedContentIndex.a.e);
        az.g(decodedResult, "value");
        synchronized (this) {
            this.size += sizeOf(str, decodedResult);
            DecodedResult decodedResultPut = this.map.put(str, decodedResult);
            if (decodedResultPut != null) {
                this.size -= sizeOf(str, decodedResultPut);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult remove(String str) {
        DecodedResult decodedResultRemove;
        az.aC(str, CachedContentIndex.a.e);
        synchronized (this) {
            decodedResultRemove = this.map.remove(str);
            if (decodedResultRemove != null) {
                this.size -= sizeOf(str, decodedResultRemove);
            }
        }
        return decodedResultRemove;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
