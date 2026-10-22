package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.NonNull;
import com.zj.adlib.zw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class ViewEvent<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f38633a;

    public ViewEvent(@NonNull T t) {
        this.f38633a = (T) zw6.b(t, "view == null");
    }

    @NonNull
    public T a() {
        return this.f38633a;
    }
}
