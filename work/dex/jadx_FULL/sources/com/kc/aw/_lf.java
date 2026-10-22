package com.kc.aw;

import android.app.Activity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lf implements Runnable {
    public final Activity _a;
    public final _lg _b;

    public _lf(_lg _lgVar, Activity activity) {
        this._b = _lgVar;
        this._a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _lg _lgVar = this._b;
        _m1._a(_lgVar._G, _lgVar._b);
        _la._a()._a(this._b._a2);
        _in _inVar = this._b._E;
        if (_inVar != null) {
            _inVar._a(this._a);
        }
        _lg _lgVar2 = this._b;
        if (_lgVar2._a5 != null || _lgVar2._a3 <= 0) {
            return;
        }
        _lgVar2._a5 = new _lg._i(_lgVar2, _lgVar2._a3);
        this._b._a(true);
    }
}
