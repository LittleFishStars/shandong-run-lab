package com.zj.adlib;

import com.android.internal.util.Predicate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a60 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static class a<T> implements Predicate<T> {
        public boolean apply(T t) {
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static class b<T> implements Predicate<T> {
        public boolean apply(T t) {
            return false;
        }
    }

    public static <T> Predicate<T> a() {
        return new b();
    }

    public static <T> Predicate<T> b() {
        return new a();
    }
}
