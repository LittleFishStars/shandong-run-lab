package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.is6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BackgroundDetector f31221a = new BackgroundDetector();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f5489a = new AtomicBoolean();
    public final AtomicBoolean b = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("sInstance")
    public final ArrayList f5488a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("sInstance")
    public boolean f5490a = false;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void a(boolean z);
    }

    @KeepForSdk
    public BackgroundDetector() {
    }

    @NonNull
    @KeepForSdk
    public static BackgroundDetector b() {
        return f31221a;
    }

    @KeepForSdk
    public static void c(@NonNull Application application) {
        BackgroundDetector backgroundDetector = f31221a;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.f5490a) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.f5490a = true;
            }
        }
    }

    @KeepForSdk
    public void a(@NonNull BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f31221a) {
            this.f5488a.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean d() {
        return this.f5489a.get();
    }

    @KeepForSdk
    @TargetApi(16)
    public boolean e(boolean z) {
        if (!this.b.get()) {
            if (!is6.e()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f5489a.set(true);
            }
        }
        return d();
    }

    public final void f(boolean z) {
        synchronized (f31221a) {
            Iterator it = this.f5488a.iterator();
            while (it.hasNext()) {
                ((BackgroundStateChangeListener) it.next()).a(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        boolean zCompareAndSet = this.f5489a.compareAndSet(true, false);
        this.b.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull Activity activity) {
        boolean zCompareAndSet = this.f5489a.compareAndSet(true, false);
        this.b.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f5489a.compareAndSet(false, true)) {
            this.b.set(true);
            f(true);
        }
    }
}
