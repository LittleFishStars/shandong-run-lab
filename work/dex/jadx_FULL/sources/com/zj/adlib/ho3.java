package com.zj.adlib;

import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ho3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<Boolean> f42168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Func0<Boolean> f17039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Func1<Object, Boolean> f17040a;

    public static final class a<T> implements Func1<Object, T>, Func0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f42169a;

        public a(T t) {
            this.f42169a = t;
        }

        public T call(Object obj) {
            return this.f42169a;
        }

        public T call() {
            return this.f42169a;
        }
    }

    static {
        a<Boolean> aVar = new a<>(Boolean.TRUE);
        f42168a = aVar;
        f17039a = aVar;
        f17040a = aVar;
    }

    public ho3() {
        throw new AssertionError("No instances.");
    }
}
