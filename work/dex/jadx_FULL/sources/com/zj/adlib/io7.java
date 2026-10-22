package com.zj.adlib;

import android.widget.ProgressBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class io7 {

    public static class a implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f42401a;

        public a(ProgressBar progressBar) {
            this.f42401a = progressBar;
        }

        public void call(Integer num) {
            this.f42401a.incrementProgressBy(num.intValue());
        }
    }

    public static class b implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f42402a;

        public b(ProgressBar progressBar) {
            this.f42402a = progressBar;
        }

        public void call(Integer num) {
            this.f42402a.incrementSecondaryProgressBy(num.intValue());
        }
    }

    public static class c implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f42403a;

        public c(ProgressBar progressBar) {
            this.f42403a = progressBar;
        }

        public void call(Boolean bool) {
            this.f42403a.setIndeterminate(bool.booleanValue());
        }
    }

    public static class d implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f42404a;

        public d(ProgressBar progressBar) {
            this.f42404a = progressBar;
        }

        public void call(Integer num) {
            this.f42404a.setMax(num.intValue());
        }
    }

    public static class e implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f42405a;

        public e(ProgressBar progressBar) {
            this.f42405a = progressBar;
        }

        public void call(Integer num) {
            this.f42405a.setProgress(num.intValue());
        }
    }

    public static class f implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressBar f42406a;

        public f(ProgressBar progressBar) {
            this.f42406a = progressBar;
        }

        public void call(Integer num) {
            this.f42406a.setSecondaryProgress(num.intValue());
        }
    }

    public io7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> a(@NonNull ProgressBar progressBar) {
        zw6.b(progressBar, "view == null");
        return new a(progressBar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> b(@NonNull ProgressBar progressBar) {
        zw6.b(progressBar, "view == null");
        return new b(progressBar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> c(@NonNull ProgressBar progressBar) {
        zw6.b(progressBar, "view == null");
        return new c(progressBar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> d(@NonNull ProgressBar progressBar) {
        zw6.b(progressBar, "view == null");
        return new d(progressBar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> e(@NonNull ProgressBar progressBar) {
        zw6.b(progressBar, "view == null");
        return new e(progressBar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> f(@NonNull ProgressBar progressBar) {
        zw6.b(progressBar, "view == null");
        return new f(progressBar);
    }
}
