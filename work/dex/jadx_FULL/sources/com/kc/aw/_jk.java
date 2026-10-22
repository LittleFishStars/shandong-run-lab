package com.kc.aw;

import android.view.View;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jk implements PtgNativeExpressAd.ExpressAdInteractionListener, PtgNativeExpressAd.AdInteractionListener {
    public final PtgNativeExpressAd.ExpressAdInteractionListener _a;

    public _jk(_q _qVar, PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this._a = expressAdInteractionListener;
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onAdClicked() {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onAdDismiss() {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener instanceof PtgNativeExpressAd.AdInteractionListener) {
            expressAdInteractionListener = (PtgNativeExpressAd.AdInteractionListener) expressAdInteractionListener;
        } else if (!(expressAdInteractionListener instanceof PtgNativeExpressAd.ExpressAdInteractionListener)) {
            return;
        }
        expressAdInteractionListener.onAdDismiss();
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onAdShow() {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdShow();
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onRenderFail(AdError adError) {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onRenderFail(adError);
        }
    }

    @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
    public final void onRenderSuccess(View view) {
        PtgNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this._a;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onRenderSuccess(view);
        }
    }
}
