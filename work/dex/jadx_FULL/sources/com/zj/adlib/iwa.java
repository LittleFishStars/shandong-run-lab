package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import com.bwt.top.AdSdk;
import com.bwt.top.kdsksdda.ddksa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class iwa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile iwa f42458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public bhb f17294a = new bhb();

    public iwa() {
        Context context = AdSdk.getInstance().getContext();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.f17294a);
        }
    }

    public static iwa a() {
        if (f42458a == null) {
            synchronized (ddksa.class) {
                if (f42458a == null) {
                    f42458a = new iwa();
                }
            }
        }
        return f42458a;
    }

    public void b(ddksa ddksaVar) {
        this.f17294a.a(ddksaVar);
    }
}
