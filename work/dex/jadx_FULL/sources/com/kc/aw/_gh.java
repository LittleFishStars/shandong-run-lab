package com.kc.aw;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gh implements _mg._b {
    public final _mf _a;
    public final _gg _b;

    @Keep
    public final class _a implements Runnable {
        public final _nl _a;
        public final float _b;
        public final float _c;
        public final float _d;
        public final double _e;
        public final float _f;
        public final _gh _g;

        public _a(_gh _ghVar, _nl _nlVar, float f, float f2, float f3, double d, float f4) {
            this._g = _ghVar;
            this._a = _nlVar;
            this._b = f;
            this._c = f2;
            this._d = f3;
            this._e = d;
            this._f = f4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _nl _nlVar = this._a;
            if (_nlVar == null || this._g._a == null) {
                return;
            }
            _nlVar._f = System.currentTimeMillis();
            _gg _ggVar = this._g._b;
            View cView = _ggVar.getCView();
            _mf _mfVar = this._g._a;
            _ggVar._b(cView, _mfVar._c, _nk._a(this._b, this._c, this._d, this._e, this._f, _mfVar._d));
        }
    }

    public _gh(_gg _ggVar, _mf _mfVar) {
        this._b = _ggVar;
        this._a = _mfVar;
    }

    @Override // com.kc.aw._mg._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        if (this._a == null) {
            _mg._a(this._b._e);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        _gg _ggVar = this._b;
        if (jCurrentTimeMillis - _ggVar._p >= this._a._e && _l5._a(_ggVar) && this._b._b()) {
            if (this._b._x.get()) {
                _gg _ggVar2 = this._b;
                if (_ggVar2._i) {
                    View cView = _ggVar2.getCView();
                    _mf _mfVar = this._a;
                    _ggVar2._a(cView, _mfVar._c, _nk._a(f, f2, f3, d, f4, _mfVar._d));
                }
            } else {
                _nl _nlVar = new _nl(this._b.getCView());
                _nlVar._c = System.currentTimeMillis();
                this._b.setOnTouchAction(_nlVar);
                _fz._a.post(new _a(this, _nlVar, f, f2, f3, d, f4));
            }
            this._b._x.set(true);
        }
    }
}
