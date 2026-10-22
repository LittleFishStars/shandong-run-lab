package com.kc.aw;

import android.widget.LinearLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n7 implements _mg._b {
    public final LinearLayout _a;
    public final _mf _b;
    public final long _c;
    public final _ai _d;
    public final _h _e;
    public final String _f;
    public final _k _g;
    public final boolean _h;
    public final _j _i;
    public final _n9 _j;

    public _n7(_n9 _n9Var, LinearLayout linearLayout, _mf _mfVar, long j, _ai _aiVar, _h _hVar, String str, _k _kVar, boolean z, _j _jVar) {
        this._j = _n9Var;
        this._a = linearLayout;
        this._b = _mfVar;
        this._c = j;
        this._d = _aiVar;
        this._e = _hVar;
        this._f = str;
        this._g = _kVar;
        this._h = z;
        this._i = _jVar;
    }

    @Override // com.kc.aw._mg._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        if (this._a == null || this._b == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this._c;
        _mf _mfVar = this._b;
        if (jCurrentTimeMillis - j < _mfVar._e) {
            return;
        }
        _n9._a(this._j, this._d, this._e, this._f, this._a, _mfVar._c, _nk._a(f, f2, f3, d, f4, _mfVar._d), this._g._c(), this._h, this._i);
    }
}
