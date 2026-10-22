package com.kc.aw.lib.provider;

import android.content.Context;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b implements PtgAdNative {
    public final PtgAdNative _a;

    public _b(PtgAdNative ptgAdNative) {
        this._a = ptgAdNative;
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        PtgAdNative ptgAdNative = this._a;
        return ptgAdNative != null ? ptgAdNative.getBiddingToken(adSlot, i) : "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getName() {
        PtgAdNative ptgAdNative = this._a;
        return ptgAdNative != null ? ptgAdNative.getName() : "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void init(Context context) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.init(context);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.loadBannerExpressAd(context, adSlot, nativeExpressAdListener);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    @Deprecated
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.loadDrawExpressAd(context, adSlot, nativeExpressAdListener);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.loadInteractionExpressAd(context, adSlot, interactionExpressAdListener);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.loadNativeExpressAd(context, adSlot, nativeExpressAdListener);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.loadRewardVideoAd(context, adSlot, rewardVideoAdListener);
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        PtgAdNative ptgAdNative = this._a;
        if (ptgAdNative != null) {
            ptgAdNative.loadSplashAd(context, adSlot, splashAdListener);
        }
    }
}
