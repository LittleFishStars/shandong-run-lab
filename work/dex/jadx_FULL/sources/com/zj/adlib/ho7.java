package com.zj.adlib;

import android.view.MenuItem;
import android.widget.PopupMenu;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ho7 {
    public ho7() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<Void> a(@NonNull PopupMenu popupMenu) {
        zw6.b(popupMenu, "view == null");
        return Observable.h1(new yu6(popupMenu));
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItem> b(@NonNull PopupMenu popupMenu) {
        zw6.b(popupMenu, "view == null");
        return Observable.h1(new zu6(popupMenu));
    }
}
