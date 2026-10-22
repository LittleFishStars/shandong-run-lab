package cj.mobile.wm.common.utils;

import android.content.Context;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ContextContainer {
    public static Context context;

    public static Context getApplicationContext() {
        return context;
    }

    public static void init(Context context2) {
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            DebugLog.common_e(dexc.dexa("DpoufyuDpoubjofs!joju!gbjm-!dpoufyu!jt!ovmm"));
        }
    }
}
