package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.MenuItemActionViewEvent;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class go7 {

    public static class a implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41947a;

        public a(MenuItem menuItem) {
            this.f41947a = menuItem;
        }

        public void call(Boolean bool) {
            this.f41947a.setChecked(bool.booleanValue());
        }
    }

    public static class b implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41948a;

        public b(MenuItem menuItem) {
            this.f41948a = menuItem;
        }

        public void call(Boolean bool) {
            this.f41948a.setEnabled(bool.booleanValue());
        }
    }

    public static class c implements Action1<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41949a;

        public c(MenuItem menuItem) {
            this.f41949a = menuItem;
        }

        public void call(Drawable drawable) {
            this.f41949a.setIcon(drawable);
        }
    }

    public static class d implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41950a;

        public d(MenuItem menuItem) {
            this.f41950a = menuItem;
        }

        public void call(Integer num) {
            this.f41950a.setIcon(num.intValue());
        }
    }

    public static class e implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41951a;

        public e(MenuItem menuItem) {
            this.f41951a = menuItem;
        }

        public void call(CharSequence charSequence) {
            this.f41951a.setTitle(charSequence);
        }
    }

    public static class f implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41952a;

        public f(MenuItem menuItem) {
            this.f41952a = menuItem;
        }

        public void call(Integer num) {
            this.f41952a.setTitle(num.intValue());
        }
    }

    public static class g implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem f41953a;

        public g(MenuItem menuItem) {
            this.f41953a = menuItem;
        }

        public void call(Boolean bool) {
            this.f41953a.setVisible(bool.booleanValue());
        }
    }

    public go7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItemActionViewEvent> a(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return Observable.h1(new com.jakewharton.rxbinding.view.a(menuItem, ho3.f17040a));
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItemActionViewEvent> b(@NonNull MenuItem menuItem, @NonNull Func1<? super MenuItemActionViewEvent, Boolean> func1) {
        zw6.b(menuItem, "menuItem == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new com.jakewharton.rxbinding.view.a(menuItem, func1));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> c(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new a(menuItem);
    }

    @NonNull
    @CheckResult
    public static Observable<Void> d(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return Observable.h1(new yl5(menuItem, ho3.f17040a));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> e(@NonNull MenuItem menuItem, @NonNull Func1<? super MenuItem, Boolean> func1) {
        zw6.b(menuItem, "menuItem == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new yl5(menuItem, func1));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> f(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new b(menuItem);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Drawable> g(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new c(menuItem);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> h(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new d(menuItem);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> i(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new e(menuItem);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> j(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new f(menuItem);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> k(@NonNull MenuItem menuItem) {
        zw6.b(menuItem, "menuItem == null");
        return new g(menuItem);
    }
}
