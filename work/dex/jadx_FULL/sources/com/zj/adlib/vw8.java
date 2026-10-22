package com.zj.adlib;

import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class vw8 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static class a<T> implements Supplier<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f45474a;

        public a(Object obj) {
            this.f45474a = obj;
        }

        @Override // com.facebook.common.internal.Supplier
        public T get() {
            return (T) this.f45474a;
        }
    }

    public static <T> Supplier<T> a(T t) {
        return new a(t);
    }
}
