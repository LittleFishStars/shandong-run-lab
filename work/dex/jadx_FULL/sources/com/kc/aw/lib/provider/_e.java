package com.kc.aw.lib.provider;

import android.content.Context;
import com.kc.aw._bk;
import com.kc.aw._cl;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e implements Runnable {
    public final _cl _a;
    public final Context _b;
    public final AdSlot _c;
    public final _bk _d;
    public final _c _e;

    public _e(_c _cVar, _cl _clVar, Context context, AdSlot adSlot, _bk _bkVar) {
        this._e = _cVar;
        this._a = _clVar;
        this._b = context;
        this._c = adSlot;
        this._d = _bkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._e._a(this._a).loadBannerExpressAd(this._b, this._c, this._d);
    }
}
