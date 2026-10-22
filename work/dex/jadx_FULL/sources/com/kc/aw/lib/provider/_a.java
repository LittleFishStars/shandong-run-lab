package com.kc.aw.lib.provider;

import android.content.Context;
import android.util.Log;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a implements PtgAdNative {
    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final String getName() {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.getName()");
        return "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void init(Context context) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.init(Context)");
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadBannerExpressAd(Context, AdSlot, NativeExpressAdListener)");
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgAdSdk.init is not executed, skip PtgAdNative.loadBannerExpressAd(Context, AdSlot, NativeExpressAdListener)", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadDrawFeedAd(Context, AdSlot, NativeExpressAdListener)");
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgAdSdk.init is not executed, skip PtgAdNative.loadDrawFeedAd(Context, AdSlot, NativeExpressAdListener)", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadInteractionExpressAd(Context, AdSlot, InteractionExpressAdListener)");
        if (interactionExpressAdListener != null) {
            interactionExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgAdSdk.init is not executed, skip PtgAdNative.loadInteractionExpressAd(Context, AdSlot, InteractionExpressAdListener)", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadNativeExpressAd(Context, AdSlot, NativeExpressAdListener)");
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgAdSdk.init is not executed, skip PtgAdNative.loadNativeExpressAd(Context, AdSlot, NativeExpressAdListener)", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadRewardVideoAd(Context, AdSlot, RewardVideoAdListener)");
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgAdSdk.init is not executed, skip PtgAdNative.loadRewardVideoAd(Context, AdSlot, RewardVideoAdListener)", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        Log.e(Logger.ILogger.TAG, "PtgAdSdk.init is not executed, skip PtgAdNative.loadSplashAd(Context, AdSlot, SplashAdListener)");
        if (splashAdListener != null) {
            splashAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgAdSdk.init is not executed, skip PtgAdNative.loadSplashAd(Context, AdSlot, SplashAdListener)", (Object) null));
        }
    }
}
