package com.zj.adlib;

import android.widget.Adapter;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class qn7 {
    public qn7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<T> a(@NonNull T t) {
        zw6.b(t, "adapter == null");
        return Observable.h1(new s00(t));
    }
}
