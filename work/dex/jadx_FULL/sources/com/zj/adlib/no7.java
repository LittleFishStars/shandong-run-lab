package com.zj.adlib;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class no7 {

    public static class a implements Action1<CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchView f43574a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f18473a;

        public a(SearchView searchView, boolean z) {
            this.f43574a = searchView;
            this.f18473a = z;
        }

        public void call(CharSequence charSequence) {
            this.f43574a.setQuery(charSequence, this.f18473a);
        }
    }

    public no7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<dz7> a(@NonNull SearchView searchView) {
        zw6.b(searchView, "view == null");
        return Observable.h1(new bz7(searchView));
    }

    @NonNull
    @CheckResult
    public static Observable<CharSequence> b(@NonNull SearchView searchView) {
        zw6.b(searchView, "view == null");
        return Observable.h1(new cz7(searchView));
    }

    @NonNull
    @CheckResult
    public static Action1<? super CharSequence> query(@NonNull SearchView searchView, boolean z) {
        zw6.b(searchView, "view == null");
        return new a(searchView, z);
    }
}
