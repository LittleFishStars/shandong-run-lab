package com.kc.aw;

import android.content.Context;
import android.content.DialogInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cy implements DialogInterface.OnClickListener {
    public final Context _a;
    public final _h _b;
    public final String _c;
    public final String _d;
    public final _eu _e;

    public _cy(Context context, _h _hVar, String str, String str2, _eu _euVar) {
        this._a = context;
        this._b = _hVar;
        this._c = str;
        this._d = str2;
        this._e = _euVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        _in _inVar;
        if (i == -1) {
            _d2._a(this._a, this._b, this._c, this._d);
        }
        _eu _euVar = this._e;
        if (_euVar == null || (_inVar = ((_lg._d) _euVar)._a._E) == null) {
            return;
        }
        _inVar._b();
    }
}
