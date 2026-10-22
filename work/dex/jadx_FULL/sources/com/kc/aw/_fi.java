package com.kc.aw;

import android.text.TextUtils;
import android.view.View;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fi implements Runnable {
    public final View _a;
    public final _fj _b;

    public _fi(_fj _fjVar, View view) {
        this._b = _fjVar;
        this._a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        _m1._a(this._a, this._b._c._d);
        _fk _fkVar_a = _fk._a();
        String str = this._b._c._c;
        _fkVar_a.getClass();
        if (!TextUtils.isEmpty(str) && (adInteractionListener = _fkVar_a._d.get(str)) != null) {
            adInteractionListener.onAdShow();
        }
        _fj _fjVar = this._b;
        _in _inVar = _fjVar._c._g;
        if (_inVar != null) {
            _inVar._a(_fjVar._b);
        }
    }
}
