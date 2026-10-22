package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n4 implements View.OnClickListener {
    public final _ai _a;
    public final _h _b;
    public final String _c;
    public final _j _d;
    public final _n9 _e;

    public _n4(_n9 _n9Var, _aj _ajVar, _h _hVar, String str, _j _jVar) {
        this._e = _n9Var;
        this._a = _ajVar;
        this._b = _hVar;
        this._c = str;
        this._d = _jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i_a = _o6._a(view);
        boolean z = i_a == 6 || i_a == 4;
        _n9._a(this._e, this._a, this._b, this._c, view, z ? _o6._a(view) : 0, null, z, z, this._d);
    }
}
