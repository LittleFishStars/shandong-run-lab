package com.kc.aw.lib.provider;

import android.content.Context;
import com.kc.aw._bi;
import com.kc.aw._cl;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _i implements Runnable {
    public final _cl _a;
    public final Context _b;
    public final AdSlot _c;
    public final _bi _d;
    public final _c _e;

    public _i(_c _cVar, _cl _clVar, Context context, AdSlot adSlot, _bi _biVar) {
        this._e = _cVar;
        this._a = _clVar;
        this._b = context;
        this._c = adSlot;
        this._d = _biVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this._e._a(this._a).loadDrawExpressAd(this._b, this._c, this._d);
    }
}
