package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class cb {
    public static boolean a(View view, int i, boolean z) {
        return view != null && b(view, i, z) && dL(view.getContext());
    }

    private static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(view.getContext());
        if ((activityFromContext != null && activityFromContext.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z && !view.hasWindowFocus())) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long jHeight = ((long) rect.height()) * ((long) rect.width());
            long height = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height > 0 && jHeight * 100 >= ((long) i) * height) {
                return true;
            }
        }
        return false;
    }

    private static boolean dL(Context context) {
        return ay.VX().dL(context);
    }

    public static double k(View view, boolean z) {
        if (view == null) {
            return -1.0d;
        }
        if (!dL(view.getContext())) {
            return -2.0d;
        }
        if (view.getParent() == null) {
            return -3.0d;
        }
        Activity activityFromContext = com.kwad.sdk.wrapper.m.getActivityFromContext(view.getContext());
        if (activityFromContext != null && activityFromContext.isFinishing()) {
            return -4.0d;
        }
        if (!view.isShown() || view.getVisibility() != 0) {
            return -5.0d;
        }
        if (!view.hasWindowFocus()) {
            return -6.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return -8.0d;
        }
        long jHeight = ((long) rect.height()) * ((long) rect.width());
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height <= 0) {
            return -7.0d;
        }
        return (jHeight * 100.0d) / height;
    }

    public static boolean r(View view, int i) {
        return view != null && b(view, i, true) && view.hasWindowFocus() && dL(view.getContext());
    }
}
