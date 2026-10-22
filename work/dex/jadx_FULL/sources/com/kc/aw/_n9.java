package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n9 {
    public _n8 _h;
    public boolean _a = false;
    public boolean _b = false;
    public boolean _c = false;
    public boolean _d = false;
    public int _e = 0;
    public final AtomicBoolean _f = new AtomicBoolean(false);
    public final Handler _g = new Handler(Looper.getMainLooper());
    public final AtomicBoolean _i = new AtomicBoolean(false);

    public static void _a(_n9 _n9Var, _ai _aiVar, _h _hVar, String str, View view, int i, _nk _nkVar, boolean z, boolean z2, _j _jVar) {
        _mz._d _dVar;
        _mz _mzVar;
        AdSlot adSlot;
        _h _hVar2;
        _n9Var.getClass();
        if (_aiVar == null || _aiVar._a() || _aiVar._b() || com.kc.aw.lib.utils._a._c()) {
            return;
        }
        if (z) {
            if (_n9Var._i.get()) {
                return;
            } else {
                _n9Var._i.set(true);
            }
        }
        _n9Var._f.set(true);
        _n9Var._c = false;
        _n9Var._d = false;
        _n9Var._b = false;
        _dj._a(_hVar);
        _mg._a(str);
        _n8 _n8Var = _n9Var._h;
        if (_n8Var != null) {
            _n9Var._g.removeCallbacks(_n8Var);
        }
        _jw._a(z, z2);
        if (view != null) {
            _o6._b(view);
        }
        if (_jVar == null || (adSlot = (_mzVar = (_dVar = (_mz._d) _jVar)._a)._n) == null || (_hVar2 = _mzVar._m) == null || !_hVar2._x) {
            return;
        }
        adSlot.setCt(i);
        _h _hVar3 = _dVar._a._m;
        _hVar3._t = _nkVar;
        _m2 _m2Var = _m1._a;
        if (_m2Var != null) {
            _m2Var._a(view, _hVar3, i);
        }
        Context context = _dVar._a.getContext();
        _mz _mzVar2 = _dVar._a;
        _b2._a(context, _mzVar2._m, _mzVar2._n);
        PtgSplashAd.AdInteractionListener adInteractionListener = _dVar._a._i;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    public final boolean _a(_k _kVar) {
        return _kVar != null && _kVar._c() && !this._f.get() && _kVar._c(true);
    }
}
