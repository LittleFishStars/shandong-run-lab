package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m {
    private static m b;
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37570a;

    private m() {
    }

    public static m a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new m();
        }
    }

    public void a(Context context) {
        synchronized (c) {
            if (this.f37570a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f37570a = context;
            s.c().b().a(this.f37570a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f37570a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a(com.heytap.mcssdk.constant.b.u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
