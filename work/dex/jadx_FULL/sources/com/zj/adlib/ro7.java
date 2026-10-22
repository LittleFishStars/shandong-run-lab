package com.zj.adlib;

import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(21)
public final class ro7 {

    public static class a implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f44495a;

        public a(Toolbar toolbar) {
            this.f44495a = toolbar;
        }

        public void call(CharSequence charSequence) {
            this.f44495a.setTitle(charSequence);
        }
    }

    public static class b implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f44496a;

        public b(Toolbar toolbar) {
            this.f44496a = toolbar;
        }

        public void call(Integer num) {
            this.f44496a.setTitle(num.intValue());
        }
    }

    public static class c implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f44497a;

        public c(Toolbar toolbar) {
            this.f44497a = toolbar;
        }

        public void call(CharSequence charSequence) {
            this.f44497a.setSubtitle(charSequence);
        }
    }

    public static class d implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f44498a;

        public d(Toolbar toolbar) {
            this.f44498a = toolbar;
        }

        public void call(Integer num) {
            this.f44498a.setSubtitle(num.intValue());
        }
    }

    public ro7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItem> a(@NonNull Toolbar toolbar) {
        zw6.b(toolbar, "view == null");
        return Observable.h1(new u89(toolbar));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> b(@NonNull Toolbar toolbar) {
        zw6.b(toolbar, "view == null");
        return Observable.h1(new v89(toolbar));
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> c(@NonNull Toolbar toolbar) {
        zw6.b(toolbar, "view == null");
        return new c(toolbar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> d(@NonNull Toolbar toolbar) {
        zw6.b(toolbar, "view == null");
        return new d(toolbar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> e(@NonNull Toolbar toolbar) {
        zw6.b(toolbar, "view == null");
        return new a(toolbar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> f(@NonNull Toolbar toolbar) {
        zw6.b(toolbar, "view == null");
        return new b(toolbar);
    }
}
