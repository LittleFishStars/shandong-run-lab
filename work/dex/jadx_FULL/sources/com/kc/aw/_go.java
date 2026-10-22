package com.kc.aw;

import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _go implements Runnable {
    public final _gp _a;

    public _go(_gp _gpVar) {
        this._a = _gpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _h _hVar = this._a._c;
        if ((_hVar == null || _hVar._r()) ? false : true) {
            return;
        }
        _gp _gpVar = this._a;
        _m1._a(_gpVar._d, _gpVar._c);
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a._i;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
        _gd _gdVar = this._a._n;
        if (_gdVar != null) {
            ((_dl) _gdVar)._a();
        }
    }
}
