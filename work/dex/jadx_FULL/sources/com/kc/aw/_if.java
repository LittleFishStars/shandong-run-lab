package com.kc.aw;

import android.content.Context;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _if implements _b3<_q> {
    public final PtgAdNative.NativeExpressAdListener _a;
    public final AdSlot _b;
    public final Context _c;
    public final _ig _d;

    public _if(_ig _igVar, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot, Context context) {
        this._d = _igVar;
        this._a = nativeExpressAdListener;
        this._b = adSlot;
        this._c = context;
    }

    @Override // com.kc.aw._b3
    public final void _a(_q _qVar) {
        com.kc.aw.lib.utils._d._c(new _ie(this, _qVar));
    }

    @Override // com.kc.aw._b3
    public final void onError(AdError adError) {
        PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._a;
        AdErrorImpl adErrorImpl = new AdErrorImpl(adError.getErrorCode(), adError.getMessage(), (Object) null);
        adErrorImpl._c = PtgApiProvider.providerName;
        nativeExpressAdListener.onError(adErrorImpl);
    }
}
