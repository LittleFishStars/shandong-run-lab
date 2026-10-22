package cj.mobile.wm;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p1 {
    public static boolean dexa(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager != null && powerManager.isScreenOn();
    }

    public static boolean dexa(View view) {
        return view.getWidth() >= dexd(view) && view.getHeight() >= dexc(view);
    }

    public static boolean dexa(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        long jHeight = ((long) rect.height()) * ((long) rect.width());
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        return height > 0 && jHeight >= (((long) i) * height) / 100;
    }

    public static boolean dexb(View view) {
        return view != null && view.isShown();
    }

    public static boolean dexb(View view, int i) {
        try {
            return dexc(view, i) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int dexc(View view) {
        return 1;
    }

    public static int dexc(View view, int i) {
        if (!dexa(view.getContext())) {
            return 1;
        }
        if (!dexb(view)) {
            return 2;
        }
        if (dexa(view)) {
            return !dexa(view, i) ? 4 : 0;
        }
        return 3;
    }

    public static int dexd(View view) {
        return 1;
    }
}
