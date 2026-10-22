package com.zj.adlib;

import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.widget.AdapterViewSelectionEvent;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class rn7 {

    public static class a implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdapterView f44489a;

        public a(AdapterView adapterView) {
            this.f44489a = adapterView;
        }

        public void call(Integer num) {
            this.f44489a.setSelection(num.intValue());
        }
    }

    public rn7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<u00> a(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return Observable.h1(new v00(adapterView));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> b(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return Observable.h1(new w00(adapterView));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<x00> c(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return d(adapterView, ho3.f17040a);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<x00> d(@NonNull AdapterView<T> adapterView, @NonNull Func1<? super x00, Boolean> func1) {
        zw6.b(adapterView, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new y00(adapterView, func1));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> e(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return f(adapterView, ho3.f17039a);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> f(@NonNull AdapterView<T> adapterView, @NonNull Func0<Boolean> func0) {
        zw6.b(adapterView, "view == null");
        zw6.b(func0, "handled == null");
        return Observable.h1(new z00(adapterView, func0));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> g(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return Observable.h1(new b10(adapterView));
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Action1<? super Integer> h(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return new a(adapterView);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<AdapterViewSelectionEvent> i(@NonNull AdapterView<T> adapterView) {
        zw6.b(adapterView, "view == null");
        return Observable.h1(new d10(adapterView));
    }
}
