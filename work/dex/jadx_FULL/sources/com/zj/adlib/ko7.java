package com.zj.adlib;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ko7 {

    public static class a implements Action1<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RatingBar f42870a;

        public a(RatingBar ratingBar) {
            this.f42870a = ratingBar;
        }

        public void call(Float f) {
            this.f42870a.setRating(f.floatValue());
        }
    }

    public static class b implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RatingBar f42871a;

        public b(RatingBar ratingBar) {
            this.f42871a = ratingBar;
        }

        public void call(Boolean bool) {
            this.f42871a.setIsIndicator(bool.booleanValue());
        }
    }

    public ko7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> a(@NonNull RatingBar ratingBar) {
        zw6.b(ratingBar, "view == null");
        return new b(ratingBar);
    }

    @NonNull
    @CheckResult
    public static Action1<? super Float> b(@NonNull RatingBar ratingBar) {
        zw6.b(ratingBar, "view == null");
        return new a(ratingBar);
    }

    @NonNull
    @CheckResult
    public static Observable<ab7> c(@NonNull RatingBar ratingBar) {
        zw6.b(ratingBar, "view == null");
        return Observable.h1(new bb7(ratingBar));
    }

    @NonNull
    @CheckResult
    public static Observable<Float> d(@NonNull RatingBar ratingBar) {
        zw6.b(ratingBar, "view == null");
        return Observable.h1(new cb7(ratingBar));
    }
}
