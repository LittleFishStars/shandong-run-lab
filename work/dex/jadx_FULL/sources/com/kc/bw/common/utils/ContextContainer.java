package com.kc.bw.common.utils;

import android.content.Context;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ContextContainer {
    public static Context context;

    public static Context getApplicationContext() {
        return context;
    }

    public static void init(Context context2) {
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            DebugLog.common_e(dexg.dexa("DpoufyuDpoubjofs!joju!gbjm-!dpoufyu!jt!ovmm"));
        }
    }
}
