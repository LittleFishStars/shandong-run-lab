package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.c7c;
import com.zj.adlib.flc;
import com.zj.adlib.jbc;
import com.zj.adlib.oec;
import com.zj.adlib.shc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class GservicesValue<T> {
    public static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Object f31270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final String f5630a;

    @Nullable
    public Object b = null;

    public GservicesValue(@NonNull String str, @NonNull Object obj) {
        this.f5630a = str;
        this.f31270a = obj;
    }

    @KeepForSdk
    public static boolean c() {
        synchronized (c) {
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Float> f(@NonNull String str, @NonNull Float f) {
        return new shc(str, f);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Integer> g(@NonNull String str, @NonNull Integer num) {
        return new oec(str, num);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Long> h(@NonNull String str, @NonNull Long l) {
        return new jbc(str, l);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<String> i(@NonNull String str, @NonNull String str2) {
        return new flc(str, str2);
    }

    @NonNull
    @KeepForSdk
    public static GservicesValue<Boolean> j(@NonNull String str, boolean z) {
        return new c7c(str, Boolean.valueOf(z));
    }

    @NonNull
    @KeepForSdk
    public final T a() {
        T t = (T) this.b;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = c;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th;
            }
        }
        try {
            T t2 = (T) zza(this.f5630a);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return t2;
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                T t3 = (T) zza(this.f5630a);
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return t3;
            } catch (Throwable th2) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th2;
            }
        }
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public final T b() {
        return a();
    }

    @VisibleForTesting
    @KeepForSdk
    public void d(@NonNull T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.b = t;
        Object obj = c;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void e() {
        this.b = null;
    }

    @NonNull
    public abstract Object zza(@NonNull String str);
}
