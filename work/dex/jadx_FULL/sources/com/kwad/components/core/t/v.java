package com.kwad.components.core.t;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class v {
    public static void c(Window window) {
        int i = Build.VERSION.SDK_INT;
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (i >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public static void d(Window window) {
        View decorView = window.getDecorView();
        decorView.setPadding(0, 0, 0, 0);
        decorView.setBackgroundColor(0);
        window.setLayout(-1, -1);
    }
}
