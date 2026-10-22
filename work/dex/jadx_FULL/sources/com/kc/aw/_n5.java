package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n5 implements View.OnClickListener {
    public final _ai _a;
    public final _h _b;
    public final String _c;
    public final _j _d;
    public final _n9 _e;

    public _n5(_n9 _n9Var, _aj _ajVar, _h _hVar, String str, _j _jVar) {
        this._e = _n9Var;
        this._a = _ajVar;
        this._b = _hVar;
        this._c = str;
        this._d = _jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        _n9 _n9Var = this._e;
        if (_n9Var._b) {
            _n9._a(_n9Var, this._a, this._b, this._c, view, 4, null, true, false, this._d);
        }
    }
}
