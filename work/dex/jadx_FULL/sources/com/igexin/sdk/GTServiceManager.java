package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.getui.gtc.base.GtcProvider;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.ServiceManager.AnonymousClass4;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GTServiceManager {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final GTServiceManager f38162a = new GTServiceManager();

        private a() {
        }
    }

    private GTServiceManager() {
    }

    public static GTServiceManager getInstance() {
        return a.f38162a;
    }

    public void onActivityCreate(Activity activity) {
        ServiceManager serviceManager = ServiceManager.getInstance();
        try {
            Context applicationContext = activity.getApplicationContext();
            ServiceManager.b = applicationContext;
            GtcProvider.setContext(applicationContext);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String name = activity.getClass().getName();
            com.igexin.b.a.a().a("gd").execute(serviceManager.new AnonymousClass4(activity.getIntent(), jCurrentTimeMillis, activity, name));
        } catch (Throwable th) {
            activity.finish();
            com.igexin.c.a.c.a.a(th);
        }
    }

    public void onServiceCreate(Context context, Intent intent) {
        ServiceManager.getInstance().a(context, intent);
    }
}
