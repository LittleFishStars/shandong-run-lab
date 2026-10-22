package com.kc.aw;

import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _ld implements PtgAdNative.RewardVideoAdListener {
    public final PtgAdNative.RewardVideoAdListener _a;

    @Keep
    public final class _a implements Runnable {
        public final AdError _a;
        public final _ld _b;

        public _a(_ld _ldVar, AdError adError) {
            this._b = _ldVar;
            this._a = adError;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._b._a.onError(this._a);
        }
    }

    @Keep
    public final class _b implements Runnable {
        public final PtgRewardVideoAd _a;
        public final _ld _b;

        public _b(_ld _ldVar, PtgRewardVideoAd ptgRewardVideoAd) {
            this._b = _ldVar;
            this._a = ptgRewardVideoAd;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this._b._a.onRewardVideoAdLoad(this._a);
        }
    }

    public _ld(PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this._a = rewardVideoAdListener;
    }

    @Override // com.kc.aw.lib.interf.Error
    public void onError(AdError adError) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _a(this, adError));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative.RewardVideoAdListener
    public final void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd) {
        if (this._a != null) {
            com.kc.aw.lib.utils._d._c(new _b(this, ptgRewardVideoAd));
        }
    }
}
