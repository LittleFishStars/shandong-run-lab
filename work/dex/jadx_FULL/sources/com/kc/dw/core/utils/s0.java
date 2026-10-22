package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class s0 {
    public static int a(int i, int i2, int i3, int i4) {
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > 100) {
            i3 = 100;
        }
        int iMax = Math.max(i2, i4);
        return iMax >= i ? i : Math.round(((i - iMax) * i3) / 100.0f) + iMax;
    }
}
