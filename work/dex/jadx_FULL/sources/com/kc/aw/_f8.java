package com.kc.aw;

import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _f8 implements PtgAdNative.InteractionExpressAdListener {
    public final PtgAdNative.InteractionExpressAdListener _a;

    @Keep
    public final class _a implements Runnable {
        public final PtgInteractionAd _a;
        public final _f8 _b;

        public _a(_f8 _f8Var, PtgInteractionAd ptgInteractionAd) {
            this._b = _f8Var;
            this._a = ptgInteractionAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._b._a.onInteractionAdLoad(this._a);
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final AdError _a;
        public final _f8 _b;

        public _b(_f8 _f8Var, AdError adError) {
            this._b = _f8Var;
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._b._a.onError(this._a);
        }
    }

    public _f8(PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        this._a = interactionExpressAdListener;
    }

    @Override // com.kc.aw.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _b(this, adError));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.InteractionExpressAdListener
    public final void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _a(this, ptgInteractionAd));
        }
    }
}
