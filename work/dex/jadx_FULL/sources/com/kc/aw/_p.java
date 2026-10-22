package com.kc.aw;

import android.view.View;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _p {
    public static final _a _a = new _a();
    public static final _b _b = new _b();

    @Keep
    public final class _a implements PtgNativeExpressAd.AdInteractionListener {
        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked() {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdDismiss() {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow() {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(AdError adError) {
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view) {
        }
    }

    @Keep
    public final class _b implements PtgInteractionAd.AdInteractionListener {
        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdClicked() {
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdDismiss() {
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdShow() {
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onRenderError(AdError adError) {
        }
    }
}
