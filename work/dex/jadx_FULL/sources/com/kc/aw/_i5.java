package com.kc.aw;

import com.kc.aw.lib.interf.PtgAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i5 implements _oe<PtgAd> {
    public final _of _a;
    public ArrayList _b = new ArrayList();
    public WeakReference<PtgAd> _c;

    public _i5(_w _wVar, PtgAd ptgAd) {
        new WeakReference(_wVar);
        this._c = new WeakReference<>(ptgAd);
        _of _ofVar = new _of();
        this._a = _ofVar;
        _ofVar._a(_wVar, this);
    }

    @Override // com.kc.aw._oe
    public final _oe _a(_og _ogVar) {
        synchronized (this._b) {
            if (!this._b.contains(_ogVar)) {
                this._b.add(_ogVar);
            }
        }
        this._a._a(_ogVar);
        return this;
    }

    @Override // com.kc.aw._oe
    public final _of _a() {
        return this._a;
    }
}
