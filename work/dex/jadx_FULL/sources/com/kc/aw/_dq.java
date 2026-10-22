package com.kc.aw;

import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _dq implements Runnable {
    public final _dp _a;

    public _dq(_dp _dpVar) {
        this._a = _dpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._a._a();
        _dp _dpVar = this._a;
        _m1._a(_dpVar, _dpVar._c);
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }
}
