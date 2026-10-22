package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a2 {
    public static _a2 _a;
    public static String _b;
    public static String _c;

    public static _a2 _a() {
        _a2 _a2Var;
        synchronized (_a2.class) {
            try {
                if (_a == null) {
                    _a = new _a2();
                }
                _a2Var = _a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return _a2Var;
    }
}
