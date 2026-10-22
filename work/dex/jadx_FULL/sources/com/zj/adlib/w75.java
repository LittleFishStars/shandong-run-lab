package com.zj.adlib;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w75<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f45536a;

    public w75(int i) {
        this.f45536a = r52.d(i);
    }

    public static <K, V> w75<K, V> b(int i) {
        return new w75<>(i);
    }

    public Map<K, V> a() {
        return this.f45536a.size() != 0 ? Collections.unmodifiableMap(this.f45536a) : Collections.emptyMap();
    }

    public w75<K, V> c(K k, V v) {
        this.f45536a.put(k, v);
        return this;
    }

    public w75<K, V> d(Map<K, V> map) {
        this.f45536a.putAll(map);
        return this;
    }
}
