package com.kc.aw;

import android.os.Handler;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d4 implements Runnable {
    public final Exception _a;
    public final _d3 _b;

    public _d4(_d3 _d3Var, Exception exc) {
        this._b = _d3Var;
        this._a = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _d3._c _cVar;
        try {
            _d3 _d3Var = this._b;
            if (_d3Var._i > 0) {
                if (_d3Var._k) {
                    return;
                }
                _d3Var._j = false;
                Handler handler = _d3Var._a;
                if (handler != null && (_cVar = _d3Var._l) != null) {
                    handler.removeCallbacks(_cVar);
                }
            }
            _d3._g _gVar = this._b._b;
            if (_gVar != null) {
                ((_d3._d) _gVar)._a(this._a);
                this._b._b = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
