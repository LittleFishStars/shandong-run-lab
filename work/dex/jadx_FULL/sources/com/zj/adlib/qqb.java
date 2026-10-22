package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.aaa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class qqb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile qqb f44283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fva f19166a = new fva();

    public qqb() {
        Context context = JZAdSdk.getInstance().getContext();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.f19166a);
        }
    }

    public static qqb b() {
        if (f44283a == null) {
            synchronized (aaa.class) {
                if (f44283a == null) {
                    f44283a = new qqb();
                }
            }
        }
        return f44283a;
    }

    public void a(aaa aaaVar) {
        this.f19166a.a(aaaVar);
    }

    public void c(aaa aaaVar) {
        this.f19166a.b(aaaVar);
    }
}
