package com.kc.aw;

import android.view.View;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gv implements _mg._b {
    public final _mf _a;
    public final _gu _b;

    @Keep
    public final class _a implements Runnable {
        public final _nl _a;
        public final View _b;
        public final float _c;
        public final float _d;
        public final float _e;
        public final double _f;
        public final float _g;
        public final _gv _h;

        public _a(_gv _gvVar, _nl _nlVar, View view, float f, float f2, float f3, double d, float f4) {
            this._h = _gvVar;
            this._a = _nlVar;
            this._b = view;
            this._c = f;
            this._d = f2;
            this._e = f3;
            this._f = d;
            this._g = f4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _nl _nlVar = this._a;
            if (_nlVar == null || this._h._a == null) {
                return;
            }
            _nlVar._f = System.currentTimeMillis();
            _gv _gvVar = this._h;
            _gu _guVar = _gvVar._b;
            View view = this._b;
            _mf _mfVar = _gvVar._a;
            _guVar._b(view, _mfVar._c, _nk._a(this._c, this._d, this._e, this._f, this._g, _mfVar._d), this._h._b._e);
        }
    }

    public _gv(_gu _guVar, _mf _mfVar) {
        this._b = _guVar;
        this._a = _mfVar;
    }

    @Override // com.kc.aw._mg._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        if (!this._b._b(true) || this._a == null) {
            _mg._a(this._b._d);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        _gu _guVar = this._b;
        if (jCurrentTimeMillis - _guVar._o < this._a._e) {
            return;
        }
        List<View> list = _guVar._g;
        View view = (list == null || list.isEmpty()) ? null : _guVar._g.get(0);
        if (view != null && _l5._a(view) && view.hasWindowFocus()) {
            if (!this._b._s.get()) {
                _nl _nlVar = new _nl(view);
                _nlVar._c = System.currentTimeMillis();
                view.setTag(R.id.aw_native_view_tag, _nlVar);
                _fz._a.post(new _a(this, _nlVar, view, f, f2, f3, d, f4));
            }
            this._b._s.set(true);
        }
    }
}
