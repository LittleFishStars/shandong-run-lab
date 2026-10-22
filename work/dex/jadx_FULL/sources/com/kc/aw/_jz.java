package com.kc.aw;

import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jz implements PtgSplashAd.AdInteractionListener {
    public final PtgSplashAd.AdInteractionListener _a;

    public _jz(_q _qVar, PtgSplashAd.AdInteractionListener adInteractionListener) {
        this._a = adInteractionListener;
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdClicked() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdShow() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdSkip() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdSkip();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onAdTimeOver() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdTimeOver();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onDismiss(int i) {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onDismiss(i);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onRenderError(AdError adError) {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onRenderError(adError);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
    public final void onRenderSuccess() {
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onRenderSuccess();
        }
    }
}
