package com.kc.aw;

import android.view.View;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ip implements _mg._b {
    public final _mf _a;
    public final _in _b;

    @Keep
    public final class _a implements Runnable {
        public final _nl _a;
        public final float _b;
        public final float _c;
        public final float _d;
        public final double _e;
        public final float _f;
        public final _ip _g;

        public _a(_ip _ipVar, _nl _nlVar, float f, float f2, float f3, double d, float f4) {
            this._g = _ipVar;
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
            _ip _ipVar = this._g;
            _in _inVar = _ipVar._b;
            _in._b _bVar = _inVar._n;
            if (_bVar != null) {
                View view = _inVar._d;
                _mf _mfVar = _ipVar._a;
                _bVar._a(view, _mfVar._c, _nk._a(this._b, this._c, this._d, this._e, this._f, _mfVar._d));
            }
        }
    }

    public _ip(_in _inVar, _mf _mfVar) {
        this._b = _inVar;
        this._a = _mfVar;
    }

    @Override // com.kc.aw._mg._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        _in._b _bVar;
        _in _inVar = this._b;
        if (_inVar._c == null || this._a == null) {
            _mg._a(_inVar._b);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        _in _inVar2 = this._b;
        if (jCurrentTimeMillis - _inVar2._e >= this._a._e && _inVar2._c.getWindowVisibility() == 0) {
            if (this._b._q.get()) {
                _in _inVar3 = this._b;
                if (!_inVar3._h || (_bVar = _inVar3._n) == null) {
                    return;
                }
                View view = _inVar3._d;
                _mf _mfVar = this._a;
                _bVar._b(view, _mfVar._c, _nk._a(f, f2, f3, d, f4, _mfVar._d));
                return;
            }
            this._b._q.set(true);
            View view2 = this._b._d;
            if (view2 != null) {
                _nl _nlVar = new _nl(view2);
                _nlVar._c = System.currentTimeMillis();
                this._b._d.setTag(R.id.aw_native_view_tag, _nlVar);
                this._b._d.post(new _a(this, _nlVar, f, f2, f3, d, f4));
            }
        }
    }
}
