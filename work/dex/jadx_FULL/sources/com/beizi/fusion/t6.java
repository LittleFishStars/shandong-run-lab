package com.beizi.fusion;

import android.app.Application;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f27776a = false;

    public static void a(Application application) {
        if (f27776a) {
            return;
        }
        synchronized (t6.class) {
            if (!f27776a) {
                r6.a(application);
                f27776a = true;
            }
        }
    }
}
