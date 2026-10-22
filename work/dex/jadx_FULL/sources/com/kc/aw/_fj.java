package com.kc.aw;

import android.app.Activity;
import com.kc.aw.activity.PtgInteractionPortraitActivity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fj implements _3 {
    public final _f6 _a;
    public final Activity _b;
    public final _fh _c;

    public _fj(_fh _fhVar, PtgInteractionPortraitActivity._a _aVar, Activity activity) {
        this._c = _fhVar;
        this._a = _aVar;
        this._b = activity;
    }

    public final void _a(String str) {
        _fh _fhVar = this._c;
        _f6 _f6Var = this._a;
        _fhVar.getClass();
        try {
            _fk._a()._a(_fhVar._c, str);
            _fhVar._f = true;
            if (_f6Var != null) {
                ((PtgInteractionPortraitActivity._a) _f6Var)._a.onBackPressed();
            }
            _in _inVar = _fhVar._g;
            if (_inVar != null) {
                _inVar._a(true);
                _inVar._c = null;
                _inVar._d = null;
                _inVar._n = null;
                _fhVar._g = null;
            }
        } catch (Exception unused) {
        }
    }
}
