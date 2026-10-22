package com.kc.aw;

import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ja implements PtgInteractionAd.AdInteractionListener {
    public final PtgInteractionAd.AdInteractionListener _a;

    public _ja(_q _qVar, PtgInteractionAd.AdInteractionListener adInteractionListener) {
        this._a = adInteractionListener;
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onAdClicked() {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onAdDismiss() {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdDismiss();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onAdShow() {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
    public final void onRenderError(AdError adError) {
        PtgInteractionAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onRenderError(adError);
        }
    }
}
