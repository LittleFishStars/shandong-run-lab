package com.kc.aw;

import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _id {
    public static boolean _a(int i) {
        if (PtgAdSdk.getContext() == null) {
            return false;
        }
        if (i != 1) {
            return i == 2 && _h2._b(PtgAdSdk.getContext()) == 1;
        }
        return -1 != _h2._b(PtgAdSdk.getContext());
    }
}
