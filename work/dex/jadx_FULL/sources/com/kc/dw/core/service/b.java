package com.kc.dw.core.service;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        boolean unused = c.c = false;
        try {
            List<com.kc.dw.core.router.service.a.InterfaceC1044a> list = c.f39313a;
            if (list.isEmpty()) {
                return;
            }
            Iterator<com.kc.dw.core.router.service.a.InterfaceC1044a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityPause(activity);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        boolean unused = c.c = true;
        try {
            List<com.kc.dw.core.router.service.a.InterfaceC1044a> list = c.f39313a;
            if (list.isEmpty()) {
                return;
            }
            Iterator<com.kc.dw.core.router.service.a.InterfaceC1044a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResume(activity);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (c.b.incrementAndGet() == 1) {
            c.a(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (c.b.decrementAndGet() == 0) {
            c.a(false);
        }
    }
}
