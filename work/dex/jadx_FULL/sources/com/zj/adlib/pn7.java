package com.zj.adlib;

import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class pn7 {
    public pn7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<dr> a(@NonNull AbsListView absListView) {
        zw6.b(absListView, "absListView == null");
        return Observable.h1(new er(absListView));
    }
}
