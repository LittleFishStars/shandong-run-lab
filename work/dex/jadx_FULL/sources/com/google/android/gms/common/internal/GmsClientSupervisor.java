package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.bpd;
import com.zj.adlib.chd;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class GmsClientSupervisor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f31289a = 4225;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @VisibleForTesting
    public static HandlerThread f5676a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static bpd f5677a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5678a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f5679a = false;

    @KeepForSdk
    public static int a() {
        return f31289a;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor b(@NonNull Context context) {
        synchronized (f5678a) {
            if (f5677a == null) {
                f5677a = new bpd(context.getApplicationContext(), f5679a ? c().getLooper() : context.getMainLooper());
            }
        }
        return f5677a;
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread c() {
        synchronized (f5678a) {
            HandlerThread handlerThread = f5676a;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f5676a = handlerThread2;
            handlerThread2.start();
            return f5676a;
        }
    }

    @KeepForSdk
    public static void d() {
        synchronized (f5678a) {
            bpd bpdVar = f5677a;
            if (bpdVar != null && !f5679a) {
                bpdVar.k(c().getLooper());
            }
            f5679a = true;
        }
    }

    @KeepForSdk
    public boolean bindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        return zzc(new chd(componentName, a()), serviceConnection, str, null);
    }

    public final void e(@NonNull String str, @NonNull String str2, int i, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z) {
        zza(new chd(str, str2, i, z), serviceConnection, str3);
    }

    @KeepForSdk
    public void unbindService(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        zza(new chd(componentName, a()), serviceConnection, str);
    }

    public abstract void zza(chd chdVar, ServiceConnection serviceConnection, String str);

    public abstract boolean zzc(chd chdVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor);

    @KeepForSdk
    public boolean bindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        return zzc(new chd(str, a(), false), serviceConnection, str2, null);
    }

    @KeepForSdk
    public void unbindService(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        zza(new chd(str, a(), false), serviceConnection, str2);
    }
}
