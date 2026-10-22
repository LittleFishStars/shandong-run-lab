package com.zj.adlib;

import android.widget.RadioGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jo7 {

    public static class a implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RadioGroup f42629a;

        public a(RadioGroup radioGroup) {
            this.f42629a = radioGroup;
        }

        public void call(Integer num) {
            if (num.intValue() == -1) {
                this.f42629a.clearCheck();
            } else {
                this.f42629a.check(num.intValue());
            }
        }
    }

    public jo7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> a(@NonNull RadioGroup radioGroup) {
        zw6.b(radioGroup, "view == null");
        return new a(radioGroup);
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> b(@NonNull RadioGroup radioGroup) {
        zw6.b(radioGroup, "view == null");
        return Observable.h1(new i97(radioGroup)).B1();
    }
}
