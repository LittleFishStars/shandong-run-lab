package com.googlecode.mp4parser.util;

import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class RangeStartMap<K extends Comparable, V> implements Map<K, V> {
    TreeMap<K, V> base = new TreeMap<>(new Comparator<K>() { // from class: com.googlecode.mp4parser.util.RangeStartMap.1
        @Override // java.util.Comparator
        public int compare(K k, K k2) {
            return -k.compareTo(k2);
        }
    });

    public RangeStartMap() {
    }

    @Override // java.util.Map
    public void clear() {
        this.base.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.base.get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return this.base.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Comparable comparable = (Comparable) obj;
        if (isEmpty()) {
            return null;
        }
        Iterator<K> it = this.base.keySet().iterator();
        K next = it.next();
        while (true) {
            K k = next;
            if (it.hasNext() && comparable.compareTo(k) < 0) {
                next = it.next();
            }
            return this.base.get(k);
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.base.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.base.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        this.base.putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Comparable comparable = (Comparable) obj;
        if (isEmpty()) {
            return null;
        }
        Iterator<K> it = this.base.keySet().iterator();
        K next = it.next();
        while (true) {
            K k = next;
            if (it.hasNext() && comparable.compareTo(k) < 0) {
                next = it.next();
            }
            return this.base.remove(k);
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.base.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.base.values();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return this.base.put(k, v);
    }

    public RangeStartMap(K k, V v) {
        put((Comparable) k, (Object) v);
    }
}
