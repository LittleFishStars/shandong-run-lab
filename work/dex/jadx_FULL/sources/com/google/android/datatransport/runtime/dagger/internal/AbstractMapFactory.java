package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.lk2;
import com.zj.adlib.r52;
import com.zj.adlib.xw6;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, Provider<V>> f30432a;

    public static abstract class Builder<K, V, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<K, Provider<V>> f30433a;

        public Builder(int i) {
            this.f30433a = r52.d(i);
        }

        public Builder<K, V, V2> a(K k, Provider<V> provider) {
            this.f30433a.put((K) xw6.c(k, CachedContentIndex.a.e), (Provider<V>) xw6.c(provider, "provider"));
            return this;
        }

        public Builder<K, V, V2> b(Provider<Map<K, V2>> provider) {
            if (provider instanceof lk2) {
                return b(((lk2) provider).a());
            }
            this.f30433a.putAll(((AbstractMapFactory) provider).f30432a);
            return this;
        }
    }

    public AbstractMapFactory(Map<K, Provider<V>> map) {
        this.f30432a = Collections.unmodifiableMap(map);
    }

    public final Map<K, Provider<V>> b() {
        return this.f30432a;
    }
}
