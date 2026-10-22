package com.beizi.fusion;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class yp {
    public static boolean a(View view) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !(q1.h().v() || view.hasWindowFocus())) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int iHeight = rect.height() * rect.width();
        int height = (int) (((double) (view.getHeight() * view.getWidth())) * 0.95d);
        return height > 0 && iHeight >= height;
    }

    public static boolean b(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    Rect rect = new Rect();
                    return view.getGlobalVisibleRect(rect) && rect.height() * rect.width() > 0;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(View view, double d) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return false;
            }
            int iHeight = rect.height() * rect.width();
            int height = (int) (((double) (view.getHeight() * view.getWidth())) * d);
            if (height > 0 && iHeight >= height) {
                return true;
            }
        }
        return false;
    }
}
