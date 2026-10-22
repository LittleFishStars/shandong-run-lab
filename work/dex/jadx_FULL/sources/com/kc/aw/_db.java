package com.kc.aw;

import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _db extends _ag {

    @Keep
    public final class _a implements PtgAdNative.NativeExpressAdListener {
        public final PtgAdNative.NativeExpressAdListener _a;
        public final AdSlot _b;
        public final _ch _c;
        public final _eq _d;

        public _a(_ch _chVar, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, _eq _eqVar) {
            this._a = nativeExpressAdListener;
            this._b = adSlot;
            this._c = _chVar;
            this._d = _eqVar;
        }

        @Override // com.kc.aw.lib.interf.Error
        public final void onError(AdError adError) {
            int i_b = _ag._b(this._c, this._b);
            if (i_b <= 0) {
                Logger.d("LAYER_REQUEST", "---> req err,return result...");
                this._a.onError(adError);
                return;
            }
            Logger.d("LAYER_REQUEST", "---> req err,req next layer...");
            _ch _chVar = this._c;
            AdSlot adSlot = this._b;
            adSlot.setNextLayer(i_b);
            _db._a(_chVar, adSlot, this._a, this._d);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            this._a.onNativeExpressAdLoad(ptgNativeExpressAd);
        }
    }

    public static void _a(_ch _chVar, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, _eq<AdSlot, _dc> _eqVar) {
        _cn _cnVar = _chVar._d;
        if (_cnVar != null && !_cnVar._a()) {
            Logger.e(PtgErrorCode.PACKAGE_NAME_ERROR_STR);
            nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_PACKAGE_NAME_ERROR, PtgErrorCode.PACKAGE_NAME_ERROR_STR, (Object) null));
            return;
        }
        _dc _dcVar = new _dc(new _a(_chVar, adSlot, nativeExpressAdListener, _eqVar));
        _ck _ckVar_a = _ag._a(_chVar, adSlot, _dcVar);
        if (_ckVar_a == null) {
            return;
        }
        StringBuilder sb_a = _jf._a("start req ... layer: ");
        sb_a.append(adSlot.getCurrentReqLayer());
        Logger.d("LAYER_REQUEST", sb_a.toString());
        _eqVar._a(adSlot, _ckVar_a, _dcVar);
    }
}
