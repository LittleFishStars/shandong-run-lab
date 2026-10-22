package com.kc.bw.adIdUtils.oaid;

import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class OAIDLog {
    public static final String TAG = dexg.dexa("PBJE");
    public static boolean enable = false;

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            if (obj == null) {
                obj = dexg.dexa("=ovmm?");
            }
            Log.d(TAG, obj.toString());
        }
    }
}
