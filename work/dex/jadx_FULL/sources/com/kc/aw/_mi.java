package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.ot.LruDiskUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mi implements _hn {
    public final _hn _a;
    public _hm _b;

    public _mi(_gb _gbVar, com.kc.aw.lib._d _dVar) {
        this._a = _gbVar;
        this._b = _dVar;
    }

    @Override // com.kc.aw._hn
    public final void _a(_ho _hoVar) throws Throwable {
        _b(_hoVar);
    }

    @Override // com.kc.aw._hn
    public final void _b(_ho _hoVar) throws Throwable {
        String asString = LruDiskUtils.get(PtgAdSdk.getContext()).getAsString(LruDiskUtils.CACHE_CONFIG_KEY);
        if (TextUtils.isEmpty(asString)) {
            _hm _hmVar = this._b;
            if (_hmVar != null) {
                com.kc.aw.lib.utils._d._c(new com.kc.aw.lib._c((com.kc.aw.lib._d) _hmVar));
                this._b = null;
            }
            _hn _hnVar = this._a;
            if (_hnVar == null) {
                return;
            }
            _hnVar._b(new _mh(_hoVar));
            return;
        }
        _cj _cjVar = new _cj();
        _cn _cnVar = new _cn();
        if (!_cnVar._c(asString) || !_cjVar._a(asString, _cnVar)) {
            _hm _hmVar2 = this._b;
            if (_hmVar2 != null) {
                com.kc.aw.lib.utils._d._c(new com.kc.aw.lib._c((com.kc.aw.lib._d) _hmVar2));
                this._b = null;
            }
            _hn _hnVar2 = this._a;
            if (_hnVar2 == null) {
                return;
            }
            _hnVar2._b(new _mh(_hoVar));
            return;
        }
        _hoVar._a(_cjVar, _cnVar);
        _hm _hmVar3 = this._b;
        if (_hmVar3 != null) {
            com.kc.aw.lib.utils._d._c(new com.kc.aw.lib._c((com.kc.aw.lib._d) _hmVar3));
            this._b = null;
        }
        _hn _hnVar3 = this._a;
        if (_hnVar3 == null) {
            return;
        }
        _hnVar3._b(new _mh(_hoVar));
    }
}
