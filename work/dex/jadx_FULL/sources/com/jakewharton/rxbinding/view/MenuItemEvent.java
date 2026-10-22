package com.jakewharton.rxbinding.view;

import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class MenuItemEvent<T extends MenuItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f38631a;

    public MenuItemEvent(@NonNull T t) {
        this.f38631a = t;
    }

    @NonNull
    public T a() {
        return this.f38631a;
    }
}
