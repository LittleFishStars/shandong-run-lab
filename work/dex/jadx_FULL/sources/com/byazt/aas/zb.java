package com.byazt.aas;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 184})
public class zb<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public zb<String, Object> c(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zb<String, Object> c(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
