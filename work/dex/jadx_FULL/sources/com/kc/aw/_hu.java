package com.kc.aw;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _hu {
    public static _eg _a;

    public static _eg _a(Context context) {
        _eg _egVar = _a;
        if (_egVar != null) {
            return _egVar;
        }
        Context applicationContext = context.getApplicationContext();
        _c2 _c2Var = new _c2(applicationContext);
        _eg _egVar2 = new _eg(new _bo(_na._a(applicationContext), new _g0(), new _no(), _c2Var, new _dh()));
        _a = _egVar2;
        return _egVar2;
    }
}
