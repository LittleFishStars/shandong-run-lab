package com.kc.aw;

import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jc implements _b3<_q> {
    public final PtgAdNative.InteractionExpressAdListener _a;
    public final AdSlot _b;
    public final _jd _c;

    public _jc(_jd _jdVar, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener, AdSlot adSlot) {
        this._c = _jdVar;
        this._a = interactionExpressAdListener;
        this._b = adSlot;
    }

    @Override // com.kc.aw._b3
    public final void _a(_q _qVar) {
        Logger.d("PtgInteractionAdLoader", "loadInteractionAd onSuccess");
        com.kc.aw.lib.utils._d._c(new _jb(this, _qVar));
    }

    @Override // com.kc.aw._b3
    public final void onError(AdError adError) {
        if (this._a != null) {
            StringBuilder sb_a = _jf._a("loadInteractionAd onError error code:");
            sb_a.append(adError.getErrorCode());
            sb_a.append("msg:");
            sb_a.append(adError.getMessage());
            Logger.d("PtgInteractionAdLoader", sb_a.toString());
            PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._a;
            AdErrorImpl adErrorImpl = new AdErrorImpl(10000, AdError.ERROR_NO_AD_STR, (Object) null);
            adErrorImpl._c = PtgApiProvider.providerName;
            interactionExpressAdListener.onError(adErrorImpl);
        }
    }
}
