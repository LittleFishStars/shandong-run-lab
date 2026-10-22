package com.huawei.hms.framework.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    /* JADX WARN: Code duplicated, block: B:18:0x003a A[RETURN] */
    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        boolean z;
        if (map == map2) {
            return true;
        }
        if (map != null && map2 != null && map.size() == map2.size()) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (map2.get(entry.getKey()) != entry.getValue()) {
                    z = true;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = false;
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey().toString());
            sb.append("=");
            sb.append(entry.getValue().toString());
            i = i2;
        }
        return sb.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (K k : set) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append("&");
            }
            sb.append(k.toString());
            i = i2;
        }
        return sb.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (K k : list) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append("&");
            }
            sb.append(k.toString());
            i = i2;
        }
        return sb.toString();
    }
}
