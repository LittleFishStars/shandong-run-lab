package com.acse.ottn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m1 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile m1 e = null;
    public static String f = "HelpShopActivityManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f23079a;
    public c b;
    public final BroadcastReceiver c = new a();
    public final BroadcastReceiver d = new b();

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23080a = MediationConstant.KEY_REASON;
        public final String b = "homekey";
        public final String c = "recentapps";

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 21)
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            h2.a(m1.f, "收到注册广播");
            if (!action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON)) == null) {
                return;
            }
            if (m1.this.f23079a != null) {
                m1 m1Var = m1.this;
                if (m1Var.a(m1Var.f23079a, true)) {
                    h2.a(m1.f, "结束当前activity1");
                    m1.this.f23079a.finishAndRemoveTask();
                }
            } else {
                h2.a(m1.f, "结束当前activity1 ==null");
            }
            if (stringExtra.equals("homekey")) {
                return;
            }
            stringExtra.equals("recentapps");
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        @RequiresApi(api = 21)
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            h2.a(m1.f, "收到注册广播2");
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                if (m1.this.f23079a == null) {
                    h2.a(m1.f, "结束当前activity2 ==null");
                } else {
                    h2.a(m1.f, "结束当前activity2");
                    m1.this.f23079a.finishAndRemoveTask();
                }
            }
        }
    }

    public class c implements Application.ActivityLifecycleCallbacks {
        public c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            p.m.add(new WeakReference<>(activity));
            h2.a(m1.f, "onActivityCreated=" + activity.getLocalClassName());
            m1.this.f23079a = activity;
            if (m1.this.a(activity, true)) {
                m1.this.e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            for (int size = p.m.size() - 1; size >= 0; size--) {
                if (p.m.get(size).get() == activity) {
                    p.m.remove(size);
                }
            }
            try {
                activity.unregisterReceiver(m1.this.c);
                activity.unregisterReceiver(m1.this.d);
            } catch (Exception e) {
                h2.a(m1.f, e.getMessage());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            m1.this.f23079a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            m1.this.f23079a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @RequiresApi(api = 21)
        public void onActivityStopped(Activity activity) {
            if (m1.this.a(activity, false)) {
                h2.a(m1.f, " current activity stop=开始结束");
                activity.finishAndRemoveTask();
            }
        }

        public /* synthetic */ c(m1 m1Var, a aVar) {
            this();
        }
    }

    public m1(Application application) {
        c cVar = new c(this, null);
        this.b = cVar;
        application.registerActivityLifecycleCallbacks(cVar);
    }

    public final void e() {
        this.f23079a.registerReceiver(this.c, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        this.f23079a.registerReceiver(this.d, new IntentFilter("android.intent.action.SCREEN_OFF"));
        h2.a(f, "注册");
    }

    public static m1 c() {
        if (e != null) {
            return e;
        }
        throw new Error("PGYER Analytic SDK init PgyerActivityManager is error.");
    }

    public static boolean d() {
        return e != null;
    }

    public Activity b() {
        return this.f23079a;
    }

    public static void a(Application application) {
        if (e == null) {
            synchronized (m1.class) {
                if (e == null) {
                    for (int size = p.m.size() - 1; size >= 0; size--) {
                        p.m.remove(size);
                    }
                    e = new m1(application);
                }
            }
        }
    }

    public final boolean a(Activity activity, boolean z) {
        try {
            return "com.acse.ottn.activity.ExcessActivity".contains(activity.getLocalClassName()) || "com.acse.ottn.activity.SeedingLoadingActivity".contains(activity.getLocalClassName()) || "com.acse.ottn.activity.WhiteActivity".contains(activity.getLocalClassName());
        } catch (Exception e2) {
            h2.a(f, e2.getMessage());
            return false;
        }
    }
}
