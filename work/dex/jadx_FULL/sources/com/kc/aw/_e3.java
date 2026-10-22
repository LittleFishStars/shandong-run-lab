package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e3 implements Runnable {
    public final _e2 _a;

    public _e3(_e2 _e2Var) {
        this._a = _e2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _e1 _e1Var = this._a._d;
        if (_e1Var != null) {
            ((_c7) _e1Var)._a(0.0f, 0.0f, 0.0f);
        }
        _e2 _e2Var = this._a;
        _e2Var.getClass();
        com.kc.aw.lib.utils._d._b(new _e4(_e2Var));
        _e3 _e3Var = _e2Var._f;
        if (_e3Var != null) {
            _e2Var._e.removeCallbacks(_e3Var);
        }
    }
}
