package com.zj.adlib;

import android.content.Context;
import com.gyf.immersionbar.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class yy8 {
    public static int a(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int b(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier(b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
