package com.kc.aw;

import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _is extends _it._b<_bh> {
    public final _ck _c;
    public final Error _d;
    public final _it _e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _is(_it _itVar, _it._c _cVar, _ck _ckVar, _ck _ckVar2, Error error) {
        super(_cVar, _ckVar);
        this._e = _itVar;
        this._c = _ckVar2;
        this._d = error;
    }

    @Override // com.kc.aw._it._b
    public final void _a() {
        try {
            _it _itVar = this._e;
            _it._a(_itVar, _itVar._c, this._c, this, this._d);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("ConcurrentHolder", e.getMessage());
        }
    }
}
