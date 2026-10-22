package com.kc.aw;

import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lc extends _ag {

    @Keep
    public final class _a implements PtgAdNative.RewardVideoAdListener {
        public final PtgAdNative.RewardVideoAdListener _a;
        public final AdSlot _b;
        public final _ch _c;
        public final _eq _d;

        public _a(_ch _chVar, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener, _eq _eqVar) {
            this._a = rewardVideoAdListener;
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
            _lc._a(_chVar, adSlot, this._a, this._d);
        }

        @Override // com.kc.aw.lib.provider.PtgAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
            this._a.onRewardVideoAdLoad(ptgRewardVideoAd);
        }
    }

    public static void _a(_ch _chVar, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener, _eq<AdSlot, _ld> _eqVar) {
        _cn _cnVar = _chVar._d;
        if (_cnVar != null && !_cnVar._a()) {
            Logger.e(PtgErrorCode.PACKAGE_NAME_ERROR_STR);
            rewardVideoAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_PACKAGE_NAME_ERROR, PtgErrorCode.PACKAGE_NAME_ERROR_STR, (Object) null));
            return;
        }
        _ld _ldVar = new _ld(new _a(_chVar, adSlot, rewardVideoAdListener, _eqVar));
        _ck _ckVar_a = _ag._a(_chVar, adSlot, _ldVar);
        if (_ckVar_a == null) {
            return;
        }
        StringBuilder sb_a = _jf._a("start req ... layer: ");
        sb_a.append(adSlot.getCurrentReqLayer());
        Logger.d("LAYER_REQUEST", sb_a.toString());
        _eqVar._a(adSlot, _ckVar_a, _ldVar);
    }
}
