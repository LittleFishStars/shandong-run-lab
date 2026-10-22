package com.kc.aw;

import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gk implements Runnable {
    public final _gl _a;

    public _gk(_gl _glVar) {
        this._a = _glVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _h _hVar = this._a._c;
        if ((_hVar == null || _hVar._r()) ? false : true) {
            return;
        }
        _gl _glVar = this._a;
        _m1._a(_glVar._d, _glVar._c);
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a._g;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
        _gd _gdVar = this._a._l;
        if (_gdVar != null) {
            ((_dl) _gdVar)._a();
        }
    }
}
