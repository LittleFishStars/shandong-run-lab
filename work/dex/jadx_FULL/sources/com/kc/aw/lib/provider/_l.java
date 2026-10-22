package com.kc.aw.lib.provider;

import com.kc.aw._g1;
import com.kc.aw._gj;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l extends _gj {
    public final AdSlot _b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _l(PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot) {
        super(nativeExpressAdListener);
        this._b = adSlot;
    }

    @Override // com.kc.aw._gj, com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        _g1._a(adError, this._b);
        super.onError(adError);
    }
}
