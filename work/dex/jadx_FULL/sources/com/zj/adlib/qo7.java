package com.zj.adlib;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class qo7 {

    public static class a implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44257a;

        public a(TextView textView) {
            this.f44257a = textView;
        }

        public void call(CharSequence charSequence) {
            this.f44257a.setText(charSequence);
        }
    }

    public static class b implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44258a;

        public b(TextView textView) {
            this.f44258a = textView;
        }

        public void call(Integer num) {
            this.f44258a.setText(num.intValue());
        }
    }

    public static class c implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44259a;

        public c(TextView textView) {
            this.f44259a = textView;
        }

        public void call(CharSequence charSequence) {
            this.f44259a.setError(charSequence);
        }
    }

    public static class d implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44260a;

        public d(TextView textView) {
            this.f44260a = textView;
        }

        public void call(Integer num) {
            TextView textView = this.f44260a;
            textView.setError(textView.getContext().getResources().getText(num.intValue()));
        }
    }

    public static class e implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44261a;

        public e(TextView textView) {
            this.f44261a = textView;
        }

        public void call(CharSequence charSequence) {
            this.f44261a.setHint(charSequence);
        }
    }

    public static class f implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44262a;

        public f(TextView textView) {
            this.f44262a = textView;
        }

        public void call(Integer num) {
            this.f44262a.setHint(num.intValue());
        }
    }

    public static class g implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f44263a;

        public g(TextView textView) {
            this.f44263a = textView;
        }

        public void call(Integer num) {
            this.f44263a.setTextColor(num.intValue());
        }
    }

    public qo7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<f49> a(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return Observable.h1(new g49(textView));
    }

    @NonNull
    @CheckResult
    public static Observable<h49> b(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return Observable.h1(new i49(textView));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> c(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new g(textView);
    }

    @NonNull
    @CheckResult
    public static Observable<m49> d(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return e(textView, ho3.f17040a);
    }

    @NonNull
    @CheckResult
    public static Observable<m49> e(@NonNull TextView textView, @NonNull Func1<? super m49, Boolean> func1) {
        zw6.b(textView, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new n49(textView, func1));
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> f(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return g(textView, ho3.f17040a);
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> g(@NonNull TextView textView, @NonNull Func1<? super Integer, Boolean> func1) {
        zw6.b(textView, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new o49(textView, func1));
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> h(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new c(textView);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> i(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new d(textView);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> j(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new e(textView);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> k(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new f(textView);
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> l(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new a(textView);
    }

    @NonNull
    @CheckResult
    public static Observable<p49> m(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return Observable.h1(new q49(textView));
    }

    @NonNull
    @CheckResult
    public static Observable<CharSequence> n(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return Observable.h1(new r49(textView));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> o(@NonNull TextView textView) {
        zw6.b(textView, "view == null");
        return new b(textView);
    }
}
