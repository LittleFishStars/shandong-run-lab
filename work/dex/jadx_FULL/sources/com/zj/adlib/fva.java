package com.zj.adlib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import cn.hzjizhun.admin.aaa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class fva implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f41768a = new ArrayList();

    public void a(aaa aaaVar) {
        if (aaaVar == null || !this.f41768a.contains(aaaVar)) {
            return;
        }
        this.f41768a.remove(aaaVar);
    }

    public void b(aaa aaaVar) {
        if (aaaVar == null || this.f41768a.contains(aaaVar)) {
            return;
        }
        this.f41768a.add(aaaVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        try {
            Iterator it = this.f41768a.iterator();
            while (it.hasNext()) {
                if (((aaa) it.next()).a(activity)) {
                    it.remove();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Iterator it = this.f41768a.iterator();
        while (it.hasNext()) {
            ((aaa) it.next()).onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Iterator it = this.f41768a.iterator();
        while (it.hasNext()) {
            ((aaa) it.next()).onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
