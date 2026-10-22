package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.zj.adlib.mi0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
public abstract class Event<T> {
    public static <T> Event<T> d(int i, T t) {
        return new mi0(Integer.valueOf(i), t, Priority.DEFAULT);
    }

    public static <T> Event<T> e(T t) {
        return new mi0(null, t, Priority.DEFAULT);
    }

    public static <T> Event<T> f(int i, T t) {
        return new mi0(Integer.valueOf(i), t, Priority.VERY_LOW);
    }

    public static <T> Event<T> g(T t) {
        return new mi0(null, t, Priority.VERY_LOW);
    }

    public static <T> Event<T> h(int i, T t) {
        return new mi0(Integer.valueOf(i), t, Priority.HIGHEST);
    }

    public static <T> Event<T> i(T t) {
        return new mi0(null, t, Priority.HIGHEST);
    }

    @Nullable
    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}
