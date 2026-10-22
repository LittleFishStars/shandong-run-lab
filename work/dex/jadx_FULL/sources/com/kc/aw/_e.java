package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e implements Runnable {
    public final _c _a;

    public _e(_c _cVar) {
        this._a = _cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = _i2._f._a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str_a = _hj._a(str.replace("__ACTION__", "launchApp").replace("__DATA__", com.kc.aw.lib.utils._a._b("{}")), _c._a(this._a));
        _nt _ntVar_a = _nt._a();
        _l0 _l0Var = _ntVar_a._b;
        if (_l0Var == null) {
            _l0Var = new _l0();
            _ntVar_a._b = _l0Var;
        }
        _l0Var._a(str_a);
    }
}
