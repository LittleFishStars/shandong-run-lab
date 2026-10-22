package com.zj.adlib;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class e72 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static class a<T> implements Supplier<DataSource<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f41361a;

        public a(Throwable th) {
            this.f41361a = th;
        }

        @Override // com.facebook.common.internal.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataSource<T> get() {
            return e72.c(this.f41361a);
        }
    }

    public static <T> Supplier<DataSource<T>> a(Throwable th) {
        return new a(th);
    }

    public static <T> DataSource<T> b(T t) {
        ng8 ng8VarL = ng8.l();
        ng8VarL.setResult(t);
        return ng8VarL;
    }

    public static <T> DataSource<T> c(Throwable th) {
        ng8 ng8VarL = ng8.l();
        ng8VarL.setFailure(th);
        return ng8VarL;
    }
}
