package com.google.android.datatransport.runtime.dagger.internal;

import com.zj.adlib.jb4;
import com.zj.adlib.r52;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a<K, V> extends AbstractMapFactory<K, V, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Provider<Map<Object, Object>> f30434a = jb4.a(Collections.emptyMap());

    public static final class b<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        public a<K, V> c() {
            return new a<>(this.f30433a);
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b<K, V> a(K k, Provider<V> provider) {
            super.a(k, provider);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b<K, V> b(Provider<Map<K, V>> provider) {
            super.b(provider);
            return this;
        }

        public b(int i) {
            super(i);
        }
    }

    public static <K, V> b<K, V> c(int i) {
        return new b<>(i);
    }

    public static <K, V> Provider<Map<K, V>> d() {
        return (Provider<Map<K, V>>) f30434a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Map<K, V> get() {
        LinkedHashMap linkedHashMapD = r52.d(b().size());
        for (Map.Entry<K, Provider<V>> entry : b().entrySet()) {
            linkedHashMapD.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(linkedHashMapD);
    }

    public a(Map<K, Provider<V>> map) {
        super(map);
    }
}
