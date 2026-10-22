package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ct implements Runnable {
    public final _cw._a _a;
    public final int _b;
    public final int _c;
    public final String _d;

    public _ct(_cw._a _aVar, int i, int i2, String str) {
        this._a = _aVar;
        this._b = i;
        this._c = i2;
        this._d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _cw._a _aVar = this._a;
        if (_aVar != null) {
            _d6 _d6Var = (_d6) _aVar;
            _d6Var._d._a(this._b, this._c, this._d, _d6Var._a, _d6Var._b, _d6Var._c);
        }
    }
}
