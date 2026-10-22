package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class LargestLimitedMemoryCache extends LimitedMemoryCache {
    private final Map<DecodedResult, Integer> valueSizes;

    public LargestLimitedMemoryCache(int i) {
        super(i);
        this.valueSizes = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.valueSizes.clear();
        super.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache
    public Reference<DecodedResult> createReference(DecodedResult decodedResult) {
        return new WeakReference(decodedResult);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public int getSize(DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        if (!super.put(str, decodedResult)) {
            return false;
        }
        this.valueSizes.put(decodedResult, Integer.valueOf(getSize(decodedResult)));
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        DecodedResult decodedResult = super.get(str);
        if (decodedResult != null) {
            this.valueSizes.remove(decodedResult);
        }
        return super.remove(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public DecodedResult removeNext() {
        DecodedResult key;
        Set<Map.Entry<DecodedResult, Integer>> setEntrySet = this.valueSizes.entrySet();
        synchronized (this.valueSizes) {
            key = null;
            Integer value = null;
            for (Map.Entry<DecodedResult, Integer> entry : setEntrySet) {
                if (key == null) {
                    key = entry.getKey();
                    value = entry.getValue();
                } else {
                    Integer value2 = entry.getValue();
                    if (value2.intValue() > value.intValue()) {
                        key = entry.getKey();
                        value = value2;
                    }
                }
            }
        }
        this.valueSizes.remove(key);
        return key;
    }
}
