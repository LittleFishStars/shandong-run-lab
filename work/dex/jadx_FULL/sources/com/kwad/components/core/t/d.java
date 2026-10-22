package com.kwad.components.core.t;

import android.R;
import android.app.Activity;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    private static void b(@NonNull Activity activity, int i, boolean z) {
        int i2;
        Window window = activity.getWindow();
        if (z) {
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
            window.addFlags(Integer.MIN_VALUE);
            if (bd.Wb()) {
                a(activity, true);
            } else if (bd.Wc()) {
                p.b(activity, true);
            }
            i2 = 9472;
        } else {
            i2 = 1280;
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean wJ() {
        return true;
    }

    public static void a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        if (wJ()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z) {
        try {
            int iIntValue = ((Integer) ab.au("android.view.MiuiWindowManager$LayoutParams", com.gyf.immersionbar.b.o)).intValue();
            ab.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
