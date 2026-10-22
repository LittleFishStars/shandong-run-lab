package com.kc.aw;

import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fu {
    public static _bz _a;

    public static void _a(String str, Throwable th) {
        if (_a == null || !Logger.isDebug()) {
            return;
        }
        Logger.e(str, th);
    }

    public static boolean _a() {
        _bz _bzVar = _a;
        if (_bzVar != null) {
            if (Logger.isDebug()) {
                return true;
            }
        }
        return false;
    }
}
