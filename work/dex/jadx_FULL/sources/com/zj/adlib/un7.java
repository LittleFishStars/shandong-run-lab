package com.zj.adlib;

import android.widget.AutoCompleteTextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class un7 {

    public static class a implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoCompleteTextView f45186a;

        public a(AutoCompleteTextView autoCompleteTextView) {
            this.f45186a = autoCompleteTextView;
        }

        public void call(CharSequence charSequence) {
            this.f45186a.setCompletionHint(charSequence);
        }
    }

    public static class b implements Action1<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoCompleteTextView f45187a;

        public b(AutoCompleteTextView autoCompleteTextView) {
            this.f45187a = autoCompleteTextView;
        }

        public void call(Integer num) {
            this.f45187a.setThreshold(num.intValue());
        }
    }

    public un7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> a(@NonNull AutoCompleteTextView autoCompleteTextView) {
        zw6.b(autoCompleteTextView, "view == null");
        return new a(autoCompleteTextView);
    }

    @NonNull
    @CheckResult
    public static Observable<u00> b(@NonNull AutoCompleteTextView autoCompleteTextView) {
        zw6.b(autoCompleteTextView, "view == null");
        return Observable.h1(new fi0(autoCompleteTextView));
    }

    @NonNull
    @CheckResult
    public static Action1<? super Integer> c(@NonNull AutoCompleteTextView autoCompleteTextView) {
        zw6.b(autoCompleteTextView, "view == null");
        return new b(autoCompleteTextView);
    }
}
