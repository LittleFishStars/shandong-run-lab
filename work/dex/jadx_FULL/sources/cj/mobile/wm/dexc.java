package cj.mobile.wm;

import cj.mobile.wm.appsdkdex.crypt.WMStringFogImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class dexc {
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
