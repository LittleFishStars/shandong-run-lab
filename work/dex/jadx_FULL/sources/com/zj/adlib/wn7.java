package com.zj.adlib;

import android.widget.CompoundButton;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class wn7 {

    public static class a implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompoundButton f45637a;

        public a(CompoundButton compoundButton) {
            this.f45637a = compoundButton;
        }

        public void call(Boolean bool) {
            this.f45637a.setChecked(bool.booleanValue());
        }
    }

    public static class b implements Action1<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompoundButton f45638a;

        public b(CompoundButton compoundButton) {
            this.f45638a = compoundButton;
        }

        public void call(Object obj) {
            this.f45638a.toggle();
        }
    }

    public wn7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Boolean> a(@NonNull CompoundButton compoundButton) {
        zw6.b(compoundButton, "view == null");
        return new a(compoundButton);
    }

    @NonNull
    @CheckResult
    public static Observable<Boolean> b(@NonNull CompoundButton compoundButton) {
        zw6.b(compoundButton, "view == null");
        return Observable.h1(new zr1(compoundButton));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Object> c(@NonNull CompoundButton compoundButton) {
        zw6.b(compoundButton, "view == null");
        return new b(compoundButton);
    }
}
