package com.byazt.qi;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.bytedance.pangle.annotations.ForbidWrapParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 13})
public class tt implements Application.ActivityLifecycleCallbacks {
    public static volatile tt c;
    public final ve tt;

    private tt(Application application) {
        this.tt = ve.c(application);
    }

    public static tt c(Application application) {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt(application);
                    application.registerActivityLifecycleCallbacks(c);
                }
            }
        }
        return c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@ForbidWrapParam Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@ForbidWrapParam Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        c.c(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        c.c(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@ForbidWrapParam Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@ForbidWrapParam Activity activity) {
        ve veVar = this.tt;
        if (veVar != null) {
            veVar.c(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@ForbidWrapParam Activity activity) {
        ve veVar = this.tt;
        if (veVar != null) {
            veVar.tt(activity);
        }
    }

    public void tt(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public String c(String str, long j, int i, boolean z) {
        ve veVar = this.tt;
        if (veVar != null) {
            return veVar.c(str, j, i, z);
        }
        return null;
    }
}
