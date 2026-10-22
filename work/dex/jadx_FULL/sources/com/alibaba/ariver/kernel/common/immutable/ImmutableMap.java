package com.alibaba.ariver.kernel.common.immutable;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ImmutableMap<K, V> implements Immutable<Map<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<K, V> f24240a;

    public ImmutableMap(Map<K, V> map) {
        this.f24240a = map;
    }

    public boolean containsKey(K k) {
        Map<K, V> map = this.f24240a;
        return map != null && map.containsKey(k);
    }

    public boolean containsValue(V v) {
        Map<K, V> map = this.f24240a;
        return map != null && map.containsValue(v);
    }

    public V get(K k, V v) {
        Map<K, V> map = this.f24240a;
        return map != null ? map.get(k) : v;
    }

    public boolean isEmpty() {
        Map<K, V> map = this.f24240a;
        return map == null || map.isEmpty();
    }

    public ImmutableSet<K> keySet() {
        if (this.f24240a != null) {
            return new ImmutableSet<>(this.f24240a.keySet());
        }
        return null;
    }

    public int size() {
        Map<K, V> map = this.f24240a;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public ImmutableSet<V> values() {
        if (this.f24240a != null) {
            return new ImmutableSet<>(this.f24240a.values());
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.immutable.Immutable
    public Map<K, V> mutable() {
        return new HashMap(this.f24240a);
    }
}
