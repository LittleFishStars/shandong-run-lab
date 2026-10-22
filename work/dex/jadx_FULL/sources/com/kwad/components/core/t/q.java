package com.kwad.components.core.t;

import android.app.Activity;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class q {
    public static boolean e(Activity activity) {
        int iG = com.kwad.sdk.c.a.a.g(activity);
        if (isInMultiWindowMode(activity) && com.kwad.sdk.c.a.a.bA(activity) - iG < com.kwad.sdk.c.a.a.a(activity, 100.0f)) {
            iG = com.kwad.sdk.c.a.a.k(activity);
        }
        return ((float) iG) / ((float) com.kwad.sdk.c.a.a.h(activity)) < 1.2f;
    }

    public static boolean isInMultiWindowMode(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return activity.isInMultiWindowMode();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
