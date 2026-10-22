package com.byazt.lm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1949, 20})
public class c implements Application.ActivityLifecycleCallbacks {
    public static volatile boolean c = false;
    public int tt = 0;
    public InterfaceC0463c uj;
    public volatile WeakReference<Activity> ve;

    /* JADX INFO: renamed from: com.byazt.lm.c$c, reason: collision with other inner class name */
    public interface InterfaceC0463c {
        void c();

        void tt();
    }

    public Boolean c() {
        return Boolean.valueOf(c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.ve = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.tt++;
        c = false;
        InterfaceC0463c interfaceC0463c = this.uj;
        if (interfaceC0463c != null) {
            interfaceC0463c.tt();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.tt - 1;
        this.tt = i;
        if (i == 0) {
            c = true;
            InterfaceC0463c interfaceC0463c = this.uj;
            if (interfaceC0463c != null) {
                interfaceC0463c.c();
            }
        }
    }

    public Activity tt() {
        if (this.ve == null) {
            return null;
        }
        return this.ve.get();
    }

    public void c(InterfaceC0463c interfaceC0463c) {
        this.uj = interfaceC0463c;
    }
}
