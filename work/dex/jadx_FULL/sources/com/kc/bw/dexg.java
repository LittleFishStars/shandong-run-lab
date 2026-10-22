package com.kc.bw;

import com.kc.bw.appsdkdex.crypt.WMStringFogImpl;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class dexg {
    public static final WMStringFogImpl dexa = new WMStringFogImpl();

    public static String dexa(String str) {
        return dexa.decrypt(str, "WM");
    }

    public static String dexb(String str) {
        return dexa.encrypt(str, "WM");
    }

    public static boolean dexc(String str) {
        return dexa.overflow(str, "WM");
    }
}
