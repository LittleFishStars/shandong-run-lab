package com.fl.saas;

import android.app.Activity;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class K {
    public static void a(Activity activity) {
        try {
            Window window = activity.getWindow();
            window.clearFlags(201327616);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Activity activity, boolean z) {
        try {
            View decorView = activity.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
