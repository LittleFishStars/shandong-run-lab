package com.alibaba.ariver.kernel.common.utils;

import android.app.Activity;
import android.graphics.Rect;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DisplayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24276a = "DisplayUtils";

    public static int getTitleAndStatusBarHeight(Activity activity) {
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return DimensionUtil.dip2px(activity, 48.0f) + rect.top;
        } catch (Throwable th) {
            RVLogger.e(f24276a, "getTitleAndStatusBarHeight...e=" + th);
            return DimensionUtil.dip2px(activity, 1.0f) * 73;
        }
    }
}
