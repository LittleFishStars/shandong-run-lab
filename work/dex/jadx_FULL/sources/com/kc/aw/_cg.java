package com.kc.aw;

import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cg implements _ho {
    public final _ch _a;
    public final _ho _b;
    public final _ch _c;

    public _cg(_ch _chVar, _ch _chVar2, _ho _hoVar) {
        this._c = _chVar;
        this._a = _chVar2;
        this._b = _hoVar;
    }

    @Override // com.kc.aw._ho
    public final void _a(_cj _cjVar, _cn _cnVar) {
        StringBuilder sb_a = _jf._a("policy updated, version: ");
        sb_a.append(_cnVar._f);
        Logger.d(sb_a.toString());
        synchronized (this._c._e) {
            _ch _chVar = this._a;
            _chVar._c = _cjVar;
            _chVar._d = _cnVar;
        }
        _ho _hoVar = this._b;
        if (_hoVar != null) {
            _hoVar._a(_cjVar, _cnVar);
        }
    }

    @Override // com.kc.aw._ho
    public final void _a(String str) {
        Logger.d("onSdkConfigRawData:");
        _ho _hoVar = this._b;
        if (_hoVar != null) {
            _hoVar._a(str);
        }
    }

    @Override // com.kc.aw._ho
    public final void _b(String str) {
        Logger.d("OnPolicyRawData:");
        _ho _hoVar = this._b;
        if (_hoVar != null) {
            _hoVar._b(str);
        }
    }

    @Override // com.kc.aw._ho
    public final void _c(String str) {
        Logger.d(String.format("Loader fail: %s", str));
        _ho _hoVar = this._b;
        if (_hoVar != null) {
            _hoVar._c(str);
        }
    }
}
