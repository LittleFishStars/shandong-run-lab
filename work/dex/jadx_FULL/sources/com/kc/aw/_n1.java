package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n1 implements _i4._b {
    public final _mz _a;

    public _n1(_mz _mzVar) {
        this._a = _mzVar;
    }

    @Override // com.kc.aw._i4._b
    public final void _a() {
    }

    @Override // com.kc.aw._i4._b
    public final void _b() {
        _mz _mzVar = this._a;
        _h _hVar = _mzVar._m;
        if (_hVar != null) {
            _hVar._H = true;
        }
        if (_mzVar._i != null && !_mzVar._r) {
            this._a._i.onRenderSuccess();
        }
        this._a._r = true;
    }
}
