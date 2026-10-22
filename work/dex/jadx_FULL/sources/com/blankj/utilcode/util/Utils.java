package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.p002lifecycle.Lifecycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Application f28214a;

    public interface Consumer<T> {
        void accept(T t);
    }

    public interface Func1<Ret, Par> {
        Ret call(Par par);
    }

    public interface OnAppStatusChangedListener {
        void a(Activity activity);

        void b(Activity activity);
    }

    public interface Supplier<T> {
        T get();
    }

    public static abstract class Task<Result> extends ThreadUtils.SimpleTask<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Consumer<Result> f28215a;

        public Task(Consumer<Result> consumer) {
            this.f28215a = consumer;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void l(Result result) {
            Consumer<Result> consumer = this.f28215a;
            if (consumer != null) {
                consumer.accept(result);
            }
        }
    }

    public static class a {
        public void a(@NonNull Activity activity) {
        }

        public void b(@NonNull Activity activity) {
        }

        public void c(@NonNull Activity activity) {
        }

        public void d(@NonNull Activity activity) {
        }

        public void e(@NonNull Activity activity) {
        }

        public void f(@NonNull Activity activity) {
        }

        public void g(@NonNull Activity activity, Lifecycle.Event event) {
        }
    }

    public Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Application a() {
        Application application = f28214a;
        if (application != null) {
            return application;
        }
        b(i.K());
        if (f28214a == null) {
            throw new NullPointerException("reflect failed.");
        }
        Log.i("Utils", i.M() + " reflect app success.");
        return f28214a;
    }

    public static void b(Application application) {
        if (application == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        Application application2 = f28214a;
        if (application2 == null) {
            f28214a = application;
            i.k0(application);
            i.K0();
        } else {
            if (application2.equals(application)) {
                return;
            }
            i.c1(f28214a);
            f28214a = application;
            i.k0(application);
        }
    }
}
