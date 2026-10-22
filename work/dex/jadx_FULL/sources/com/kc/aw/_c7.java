package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c7 implements _e1 {
    public final Map _a;
    public final _c8 _b;

    public _c7(_c8 _c8Var, HashMap map) {
        this._b = _c8Var;
        this._a = map;
    }

    public final void _a(float f, float f2, float f3) {
        this._a.put("gyrX", String.valueOf(f));
        this._a.put("gyrY", String.valueOf(f2));
        this._a.put("gyrZ", String.valueOf(f3));
        _c8 _c8Var = this._b;
        _c8Var._a = _hj._a(_c8Var._a, this._a);
        _nt _ntVar_a = _nt._a();
        String str = this._b._a;
        _l0 _l0Var = _ntVar_a._b;
        if (_l0Var == null) {
            _l0Var = new _l0();
            _ntVar_a._b = _l0Var;
        }
        _l0Var._a(str);
    }
}
