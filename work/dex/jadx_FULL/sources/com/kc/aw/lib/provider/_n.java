package com.kc.aw.lib.provider;

import com.kc.aw._g1;
import com.kc.aw._ld;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _n extends _ld {
    public final AdSlot _b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _n(PtgAdNative.RewardVideoAdListener rewardVideoAdListener, AdSlot adSlot) {
        super(rewardVideoAdListener);
        this._b = adSlot;
    }

    @Override // com.kc.aw._ld, com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        _g1._a(adError, this._b);
        super.onError(adError);
    }
}
