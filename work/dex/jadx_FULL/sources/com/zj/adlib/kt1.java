package com.zj.adlib;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class kt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static volatile kt1 f42902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f17784a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @VisibleForTesting
    public ConcurrentHashMap f17785a = new ConcurrentHashMap();

    @NonNull
    @KeepForSdk
    public static kt1 a() {
        if (f42902a == null) {
            synchronized (f17784a) {
                if (f42902a == null) {
                    f42902a = new kt1();
                }
            }
        }
        kt1 kt1Var = f42902a;
        yw6.l(kt1Var);
        return kt1Var;
    }

    public static void d(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzs);
    }

    public static final boolean g(Context context, Intent intent, ServiceConnection serviceConnection, int i, @Nullable Executor executor) {
        return (!is6.p() || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection);
    }

    @KeepForSdk
    public void b(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i) {
        return e(context, context.getClass().getName(), intent, serviceConnection, i, true, null);
    }

    public final boolean c(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i, @Nullable Executor executor) {
        return e(context, str, intent, serviceConnection, i, true, executor);
    }

    public final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, @Nullable Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((w0a.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f(serviceConnection)) {
            return g(context, intent, serviceConnection, i, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f17785a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zG = g(context, intent, serviceConnection, i, executor);
            if (zG) {
                return zG;
            }
            this.f17785a.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            this.f17785a.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }

    @KeepForSdk
    public void unbindService(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (!f(serviceConnection) || !this.f17785a.containsKey(serviceConnection)) {
            d(context, serviceConnection);
            return;
        }
        try {
            d(context, (ServiceConnection) this.f17785a.get(serviceConnection));
        } finally {
            this.f17785a.remove(serviceConnection);
        }
    }
}
