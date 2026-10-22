package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f3 implements _mk {
    public final _bc _a;

    public _f3(_i3 _i3Var) {
        this._a = _i3Var;
    }

    @Override // com.kc.aw._mk
    public final void _a(Object obj) {
        _bc _bcVar = this._a;
        if (_bcVar != null) {
            _i3 _i3Var = (_i3) _bcVar;
            if (obj != null) {
                _i4._b _bVar = _i3Var._a;
                if (_bVar != null) {
                    _bVar._b();
                    return;
                }
                return;
            }
            _i4._b _bVar2 = _i3Var._a;
            if (_bVar2 != null) {
                _bVar2._a();
            }
        }
    }
}
