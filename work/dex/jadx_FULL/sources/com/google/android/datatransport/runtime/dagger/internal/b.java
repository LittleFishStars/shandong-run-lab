package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.dagger.internal.b$b, reason: collision with other inner class name */
    public static final class C0670b<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        public b<K, V> c() {
            return new b<>(this.f30433a);
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public C0670b<K, V> a(K k, Provider<V> provider) {
            super.a(k, provider);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public C0670b<K, V> b(Provider<Map<K, Provider<V>>> provider) {
            super.b(provider);
            return this;
        }

        public C0670b(int i) {
            super(i);
        }
    }

    public static <K, V> C0670b<K, V> c(int i) {
        return new C0670b<>(i);
    }

    @Override // com.google.android.datatransport.runtime.dagger.Lazy
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Map<K, Provider<V>> get() {
        return b();
    }

    public b(Map<K, Provider<V>> map) {
        super(map);
    }
}
