package com.aliyun.tea.utils;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StringUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String join(String str, Iterable<? extends String> iterable) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(iterable);
        StringBuilder sb = new StringBuilder();
        Iterator<? extends String> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean isEmpty(Object obj) {
        if (obj != null) {
            return isEmpty((CharSequence) String.valueOf(obj));
        }
        return true;
    }
}
