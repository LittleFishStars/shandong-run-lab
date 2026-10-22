package com.kc.aw;

import android.widget.TextView;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n0 implements _bw._a {
    public final _mz _a;

    public _n0(_mz _mzVar) {
        this._a = _mzVar;
    }

    public final void _a() {
        _mz _mzVar = this._a;
        _mzVar._b = 0L;
        TextView textView = _mzVar._e;
        if (textView != null) {
            textView.setText("");
        }
        _mz _mzVar2 = this._a;
        _c._a()._a(_hj._a(this._a._m), (_mzVar2._a - _mzVar2._b) / 1000);
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a._i;
        if (adInteractionListener != null) {
            adInteractionListener.onAdTimeOver();
        }
        PtgSplashAd.AdInteractionListener adInteractionListener2 = this._a._i;
        if (adInteractionListener2 != null) {
            adInteractionListener2.onDismiss(2);
        }
        this._a._a();
    }
}
