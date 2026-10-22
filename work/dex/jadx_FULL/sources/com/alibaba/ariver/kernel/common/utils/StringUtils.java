package com.alibaba.ariver.kernel.common.utils;

import com.zj.adlib.bv9;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StringUtils {
    public static <T> String array2String(T[] tArr) {
        StringBuilder sb = new StringBuilder();
        if (tArr != null && tArr.length > 0) {
            sb.append("[");
            for (T t : tArr) {
                if (t != null) {
                    sb.append(t.toString());
                    sb.append(",");
                }
            }
            int iLastIndexOf = sb.lastIndexOf(",");
            if (-1 != iLastIndexOf) {
                sb.deleteCharAt(iLastIndexOf);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public static <T> String collection2String(Collection<T> collection) {
        StringBuilder sb = new StringBuilder();
        if (collection != null && !collection.isEmpty()) {
            sb.append(bv9.b);
            for (T t : collection) {
                if (t != null) {
                    sb.append(t.toString());
                    sb.append(",");
                }
            }
            int iLastIndexOf = sb.lastIndexOf(",");
            if (-1 != iLastIndexOf) {
                sb.deleteCharAt(iLastIndexOf);
            }
            sb.append("}");
        }
        return sb.toString();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static <K, V> String map2String(Map<K, V> map) {
        return (map == null || map.isEmpty()) ? "" : collection2String(map.entrySet());
    }
}
