package com.kc.aw;

import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mp extends _ag {

    @Keep
    public final class _a implements PtgAdNative.SplashAdListener {
        public final AdSlot _a;
        public final _ch _b;
        public final PtgAdNative.SplashAdListener _c;
        public final _eq _d;

        public _a(_ch _chVar, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener, _eq _eqVar) {
            this._a = adSlot;
            this._b = _chVar;
            this._c = splashAdListener;
            this._d = _eqVar;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            int i_b = _ag._b(this._b, this._a);
            if (i_b <= 0) {
                Logger.d("LAYER_REQUEST", "---> req err,return result...");
                this._c.onError(adError);
                return;
            }
            Logger.d("LAYER_REQUEST", "---> req err,req next layer...");
            _ch _chVar = this._b;
            AdSlot adSlot = this._a;
            adSlot.setNextLayer(i_b);
            _mp._a(_chVar, adSlot, this._c, this._d);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
        public final void onSplashAdLoad(PtgSplashAd ptgSplashAd) {
            this._c.onSplashAdLoad(ptgSplashAd);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
        public final void onTimeout() {
            int i_b = _ag._b(this._b, this._a);
            if (i_b <= 0) {
                Logger.d("LAYER_REQUEST", "---> req err,return result...");
                this._c.onTimeout();
                return;
            }
            Logger.d("LAYER_REQUEST", "---> req err,req next layer...");
            _ch _chVar = this._b;
            AdSlot adSlot = this._a;
            adSlot.setNextLayer(i_b);
            _mp._a(_chVar, adSlot, this._c, this._d);
        }
    }

    public static void _a(_ch _chVar, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener, _eq<AdSlot, _mq> _eqVar) {
        _cn _cnVar = _chVar._d;
        if (_cnVar != null && !_cnVar._a()) {
            Logger.e(PtgErrorCode.PACKAGE_NAME_ERROR_STR);
            splashAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_PACKAGE_NAME_ERROR, PtgErrorCode.PACKAGE_NAME_ERROR_STR, (Object) null));
            return;
        }
        _mq _mqVar = new _mq(new _a(_chVar, adSlot, splashAdListener, _eqVar));
        _ck _ckVar_a = _ag._a(_chVar, adSlot, _mqVar);
        if (_ckVar_a == null) {
            return;
        }
        StringBuilder sb_a = _jf._a("start req ... layer: ");
        sb_a.append(adSlot.getCurrentReqLayer());
        Logger.d("LAYER_REQUEST", sb_a.toString());
        _eqVar._a(adSlot, _ckVar_a, _mqVar);
    }
}
