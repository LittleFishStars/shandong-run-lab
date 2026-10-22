package com.zj.adlib;

import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewGroupHierarchyChangeEvent;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class to7 {
    public to7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<ViewGroupHierarchyChangeEvent> a(@NonNull ViewGroup viewGroup) {
        zw6.b(viewGroup, "viewGroup == null");
        return Observable.h1(new uq9(viewGroup));
    }
}
