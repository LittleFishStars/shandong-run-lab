package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.ex4;
import com.zj.adlib.yw6;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public final LifecycleFragment f31226a;

    @KeepForSdk
    public LifecycleCallback(@NonNull LifecycleFragment lifecycleFragment) {
        this.f31226a = lifecycleFragment;
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment b(@NonNull Activity activity) {
        return getFragment(new ex4(activity));
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment c(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(ex4 ex4Var) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @NonNull
    @KeepForSdk
    public static LifecycleFragment getFragment(@NonNull ex4 ex4Var) {
        if (ex4Var.d()) {
            return zzd.zzc(ex4Var.b());
        }
        if (ex4Var.c()) {
            return zzb.c(ex4Var.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @KeepForSdk
    @MainThread
    public void a(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
    }

    @KeepForSdk
    @MainThread
    public void d(int i, int i2, @NonNull Intent intent) {
    }

    @KeepForSdk
    @MainThread
    public void e(@Nullable Bundle bundle) {
    }

    @KeepForSdk
    @MainThread
    public void f() {
    }

    @KeepForSdk
    @MainThread
    public void g() {
    }

    @NonNull
    @KeepForSdk
    public Activity getActivity() {
        Activity lifecycleActivity = this.f31226a.getLifecycleActivity();
        yw6.l(lifecycleActivity);
        return lifecycleActivity;
    }

    @KeepForSdk
    @MainThread
    public void h(@NonNull Bundle bundle) {
    }

    @KeepForSdk
    @MainThread
    public void i() {
    }

    @KeepForSdk
    @MainThread
    public void j() {
    }
}
