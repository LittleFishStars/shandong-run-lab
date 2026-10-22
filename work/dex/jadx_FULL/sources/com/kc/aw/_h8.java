package com.kc.aw;

import android.view.Window;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h8 {
    public static volatile _h8 _a;

    public static _h8 _a() {
        if (_a == null) {
            synchronized (_h8.class) {
                try {
                    if (_a == null) {
                        _a = new _h8();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return _a;
    }

    public static boolean _a(Window window) {
        if (window == null) {
            return false;
        }
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        return true;
    }
}
