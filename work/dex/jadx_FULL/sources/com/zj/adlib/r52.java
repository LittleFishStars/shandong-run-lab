package com.zj.adlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44374a = 1073741824;

    public static int a(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean b(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        return list.size() != new HashSet(list).size();
    }

    public static <T> HashSet<T> c(int i) {
        return new HashSet<>(a(i));
    }

    public static <K, V> LinkedHashMap<K, V> d(int i) {
        return new LinkedHashMap<>(a(i));
    }

    public static <T> List<T> e(int i) {
        return i == 0 ? Collections.emptyList() : new ArrayList(i);
    }
}
