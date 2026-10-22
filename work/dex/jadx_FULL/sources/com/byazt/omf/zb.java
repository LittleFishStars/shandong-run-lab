package com.byazt.omf;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.pf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 184})
public class zb {
    public static String c(int i) {
        switch (i) {
            case 1:
                return "view不可见";
            case 2:
            case 5:
            default:
                return "";
            case 3:
                return "view可见区域比例不够";
            case 4:
                return "屏幕关闭";
            case 6:
                return "view可见宽高不够";
            case 7:
                return "show检测发生崩溃";
            case 8:
                return "设置为了不需要检测";
            case 9:
                return "没有在检测";
            case 10:
                return "没有在检测，已show";
        }
    }

    private static boolean c(View view, int i) {
        float fTt = tt(view);
        return fTt > 0.0f && fTt >= ((float) i) / 100.0f;
    }

    private static boolean tt(View view, int i) {
        return view.getWidth() >= ve(view, i) && view.getHeight() >= uj(view, i);
    }

    private static int uj(View view, int i) {
        if (i == 3) {
            return pf.n(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static boolean ve(View view) {
        return view != null && view.isShown();
    }

    public static boolean c(View view, Rect rect, Point point) {
        if (view == null) {
            return false;
        }
        int right = view.getRight() - view.getLeft();
        int bottom = view.getBottom() - view.getTop();
        if (right <= 0 || bottom <= 0) {
            return false;
        }
        rect.set(0, 0, right, bottom);
        if (point != null) {
            point.set(-view.getScrollX(), -view.getScrollY());
        }
        return view.getParent() == null || view.getParent().getChildVisibleRect(view, rect, point);
    }

    private static int ve(View view, int i) {
        if (i == 3) {
            return (int) (((double) pf.uj(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    public static boolean tt(View view, int i, int i2) {
        try {
            return c(view, i, i2) == 0;
        } catch (Throwable unused) {
        }
    }

    public static float tt(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect) && (!gt.tt().lt() || !c(view, new Rect(), (Point) null))) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    public static int c(View view, int i, int i2) throws Throwable {
        if (!DeviceUtils.c()) {
            return 4;
        }
        if (!ve(view)) {
            return 1;
        }
        if (tt(view, i2)) {
            return !c(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean c(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            return c(view, 20);
        }
        return false;
    }
}
