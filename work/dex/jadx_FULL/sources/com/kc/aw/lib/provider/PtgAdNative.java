package com.kc.aw.lib.provider;

import android.content.Context;
import com.kc.aw._j7;
import com.kc.aw._jg;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgAdNative {

    @Keep
    public interface FeedAdListener extends Error {
        void onFeedAdLoad(_j7 _j7Var);
    }

    @Keep
    public interface InteractionExpressAdListener extends Error {
        void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd);
    }

    @Keep
    public interface InteractiveActivityAdListener extends Error {
        void onInteractiveActivityAdLoad(_jg _jgVar);
    }

    @Keep
    public interface NativeExpressAdListener extends Error {
        void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd);
    }

    @Keep
    public interface RewardVideoAdListener extends Error {
        void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd);
    }

    @Keep
    public interface SplashAdListener extends Error {
        void onSplashAdLoad(PtgSplashAd ptgSplashAd);

        void onTimeout();
    }

    String getBiddingToken(AdSlot adSlot, int i);

    String getName();

    void init(Context context);

    void loadBannerExpressAd(Context context, AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    @Deprecated
    void loadDrawExpressAd(Context context, AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadInteractionExpressAd(Context context, AdSlot adSlot, InteractionExpressAdListener interactionExpressAdListener);

    void loadNativeExpressAd(Context context, AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(Context context, AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(Context context, AdSlot adSlot, SplashAdListener splashAdListener);
}
