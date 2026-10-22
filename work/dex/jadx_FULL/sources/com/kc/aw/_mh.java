package com.kc.aw;

import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.ot.LruDiskUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mh implements _ho {
    public final boolean _a = true;
    public final _ho _b;

    public _mh(_ho _hoVar) {
        this._b = _hoVar;
    }

    @Override // com.kc.aw._ho
    public final void _a(_cj _cjVar, _cn _cnVar) {
        if (this._a) {
            this._b._a(_cjVar, _cnVar);
        }
    }

    @Override // com.kc.aw._ho
    public final void _a(String str) {
        if (this._a) {
            this._b._a(str);
        }
    }

    @Override // com.kc.aw._ho
    public final void _b(String str) throws Throwable {
        LruDiskUtils.get(PtgAdSdk.getContext()).put(LruDiskUtils.CACHE_CONFIG_KEY, str);
        if (this._a) {
            this._b._b(str);
        }
    }

    @Override // com.kc.aw._ho
    public final void _c(String str) {
        if (this._a) {
            this._b._c(str);
        }
    }
}
