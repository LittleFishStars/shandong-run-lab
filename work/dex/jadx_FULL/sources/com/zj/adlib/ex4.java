package com.zj.adlib;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class ex4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f41544a;

    public ex4(@NonNull Activity activity) {
        yw6.m(activity, "Activity must not be null");
        this.f41544a = activity;
    }

    @NonNull
    public final Activity a() {
        return (Activity) this.f41544a;
    }

    @NonNull
    public final FragmentActivity b() {
        return (FragmentActivity) this.f41544a;
    }

    public final boolean c() {
        return this.f41544a instanceof Activity;
    }

    public final boolean d() {
        return this.f41544a instanceof FragmentActivity;
    }

    @KeepForSdk
    public ex4(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
