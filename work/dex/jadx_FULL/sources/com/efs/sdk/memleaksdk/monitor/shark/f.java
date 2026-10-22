package com.efs.sdk.memleaksdk.monitor.shark;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f29873a = new f();
    private boolean b = true;
    private String c = "";
    private int d;
    private boolean e;

    private f() {
    }

    public static f a() {
        return f29873a;
    }

    public String b() {
        return TextUtils.isEmpty(this.c) ? "null" : this.c;
    }

    public boolean c() {
        return this.b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.c = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.c = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.c = activity.getComponentName().flattenToShortString();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i = this.d + 1;
        this.d = i;
        if (i == 1 && !this.e) {
            this.b = true;
            y.b.e();
        }
        this.c = activity.getComponentName().flattenToShortString();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        boolean zIsChangingConfigurations = activity.isChangingConfigurations();
        this.e = zIsChangingConfigurations;
        int i = this.d - 1;
        this.d = i;
        if (i == 0 && !zIsChangingConfigurations) {
            this.b = false;
            y.b.e();
        }
        this.c = "";
    }

    public void a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }
}
