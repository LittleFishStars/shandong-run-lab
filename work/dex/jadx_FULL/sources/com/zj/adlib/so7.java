package com.zj.adlib;

import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding.view.ViewAttachEvent;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class so7 {

    public static class a implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f44730a;

        public a(View view) {
            this.f44730a = view;
        }

        public void call(Boolean bool) {
            this.f44730a.setActivated(bool.booleanValue());
        }
    }

    public static class b implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f44731a;

        public b(View view) {
            this.f44731a = view;
        }

        public void call(Boolean bool) {
            this.f44731a.setClickable(bool.booleanValue());
        }
    }

    public static class c implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f44732a;

        public c(View view) {
            this.f44732a = view;
        }

        public void call(Boolean bool) {
            this.f44732a.setEnabled(bool.booleanValue());
        }
    }

    public static class d implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f44733a;

        public d(View view) {
            this.f44733a = view;
        }

        public void call(Boolean bool) {
            this.f44733a.setPressed(bool.booleanValue());
        }
    }

    public static class e implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f44734a;

        public e(View view) {
            this.f44734a = view;
        }

        public void call(Boolean bool) {
            this.f44734a.setSelected(bool.booleanValue());
        }
    }

    public static class f implements Action1<Boolean> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f44735a;

        public f(View view, int i) {
            this.f44735a = view;
            this.K = i;
        }

        public void call(Boolean bool) {
            this.f44735a.setVisibility(bool.booleanValue() ? 0 : this.K);
        }
    }

    public so7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> A(@NonNull View view, @NonNull Func1<? super MotionEvent, Boolean> func1) {
        zw6.b(view, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new tr9(view, func1));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> B(@NonNull View view) {
        zw6.b(view, "view == null");
        return C(view, 8);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> C(@NonNull View view, int i) {
        zw6.b(view, "view == null");
        boolean z = true;
        zw6.a(i != 0, "Setting visibility to VISIBLE when false would have no effect.");
        if (i != 4 && i != 8) {
            z = false;
        }
        zw6.a(z, "Must set visibility to INVISIBLE or GONE when false.");
        return new f(view, i);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> a(@NonNull View view) {
        zw6.b(view, "view == null");
        return new a(view);
    }

    @NonNull
    @CheckResult
    public static Observable<ViewAttachEvent> b(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new com.jakewharton.rxbinding.view.b(view));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> c(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new rp9(view, true));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> d(@NonNull View view) {
        zw6.b(view, "view == null");
        return new b(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Void> e(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new sp9(view));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> f(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new rp9(view, false));
    }

    @NonNull
    @CheckResult
    public static Observable<DragEvent> g(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new qq9(view, ho3.f17040a));
    }

    @NonNull
    @CheckResult
    public static Observable<DragEvent> h(@NonNull View view, @NonNull Func1<? super DragEvent, Boolean> func1) {
        zw6.b(view, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new qq9(view, func1));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> i(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new vr9(view));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> j(@NonNull View view) {
        zw6.b(view, "view == null");
        return new c(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Boolean> k(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new tq9(view));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> l(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new wr9(view));
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> m(@NonNull View view) {
        zw6.b(view, "view == null");
        return n(view, ho3.f17040a);
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> n(@NonNull View view, @NonNull Func1<? super MotionEvent, Boolean> func1) {
        zw6.b(view, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new er9(view, func1));
    }

    @NonNull
    @CheckResult
    public static Observable<KeyEvent> o(@NonNull View view) {
        zw6.b(view, "view == null");
        return p(view, ho3.f17040a);
    }

    @NonNull
    @CheckResult
    public static Observable<KeyEvent> p(@NonNull View view, @NonNull Func1<? super KeyEvent, Boolean> func1) {
        zw6.b(view, "view == null");
        zw6.b(func1, "handled == null");
        return Observable.h1(new fr9(view, func1));
    }

    @NonNull
    @CheckResult
    public static Observable<hr9> q(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new ir9(view));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> r(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new jr9(view));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> s(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new kr9(view, ho3.f17039a));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> t(@NonNull View view, @NonNull Func0<Boolean> func0) {
        zw6.b(view, "view == null");
        zw6.b(func0, "handled == null");
        return Observable.h1(new kr9(view, func0));
    }

    @NonNull
    @CheckResult
    public static Observable<Void> u(@NonNull View view, @NonNull Func0<Boolean> func0) {
        zw6.b(view, "view == null");
        zw6.b(func0, "proceedDrawingPass == null");
        return Observable.h1(new xr9(view, func0));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> v(@NonNull View view) {
        zw6.b(view, "view == null");
        return new d(view);
    }

    @NonNull
    @CheckResult
    @RequiresApi(23)
    public static Observable<qr9> w(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new rr9(view));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> x(@NonNull View view) {
        zw6.b(view, "view == null");
        return new e(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> y(@NonNull View view) {
        zw6.b(view, "view == null");
        return Observable.h1(new sr9(view));
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> z(@NonNull View view) {
        zw6.b(view, "view == null");
        return A(view, ho3.f17040a);
    }
}
