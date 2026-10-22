package com.kc.aw.provider;

import android.content.Context;
import com.kc.aw.PtgAdProxy;
import com.kc.aw._if;
import com.kc.aw._ig;
import com.kc.aw._jc;
import com.kc.aw._jd;
import com.kc.aw._jm;
import com.kc.aw._jn;
import com.kc.aw._jr;
import com.kc.aw._js;
import com.kc.aw._k1;
import com.kc.aw._k2;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgApiProvider implements PtgAdNative {
    public static final String providerName = "ptgapi";
    private final String TAG = "PtgApiProvider";
    private AtomicBoolean mHasInit = new AtomicBoolean();

    private void checkInit() {
        if (this.mHasInit.get()) {
            return;
        }
        init(PtgAdSdk.getContext());
    }

    private boolean checkInitConditions(Error error) {
        if (PtgAdSdk.getContext() != null) {
            return true;
        }
        if (error == null) {
            return false;
        }
        Logger.d("PtgApiProvider", "checkInitConditions context unInitialize");
        error.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "context unInitialize", (Object) null));
        return false;
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public String getName() {
        return providerName;
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void init(Context context) {
        if (this.mHasInit.compareAndSet(false, true)) {
            PtgAdProxy.initialize(context);
            Logger.d("PtgApiProvider", "init PtgApiProvider");
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (checkInitConditions(nativeExpressAdListener)) {
            checkInit();
            PtgAdProxy.getBannerAd(context, adSlot, new _if(new _ig(), nativeExpressAdListener, adSlot, context));
        } else {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgApi 初始化条件失败", (Object) null));
            }
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (checkInitConditions(nativeExpressAdListener)) {
            checkInit();
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_NOT_SUPPORT, "Ptgapi does not support DrawFeedAd ", (Object) null));
                return;
            }
            return;
        }
        Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgApi 初始化条件失败", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        if (checkInitConditions(interactionExpressAdListener)) {
            checkInit();
            _jd _jdVar = new _jd();
            Logger.d("PtgInteractionAdLoader", "loadInteractionAd start loading...");
            PtgAdProxy.getInteractionAd(context, adSlot, new _jc(_jdVar, interactionExpressAdListener, adSlot));
            return;
        }
        Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
        if (interactionExpressAdListener != null) {
            interactionExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgApi 初始化条件失败", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (checkInitConditions(nativeExpressAdListener)) {
            checkInit();
            PtgAdProxy.getFeedAd(context, adSlot, new _jm(new _jn(), nativeExpressAdListener, adSlot, context));
        } else {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgApi 初始化条件失败", (Object) null));
            }
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (checkInitConditions(rewardVideoAdListener)) {
            checkInit();
            _js _jsVar = new _js();
            _jsVar._a = rewardVideoAdListener;
            PtgAdProxy.getRewardVideoAd(context, adSlot, new _jr(_jsVar, adSlot));
            return;
        }
        Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgApi 初始化条件失败", (Object) null));
        }
    }

    @Override // com.kc.aw.lib.provider.PtgAdNative
    public void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        if (!checkInitConditions(splashAdListener)) {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (splashAdListener != null) {
                splashAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_INIT, "PtgApi 初始化条件失败", (Object) null));
                return;
            }
            return;
        }
        checkInit();
        _k2 _k2Var = new _k2();
        if (context != null) {
            PtgAdProxy.getSplashAd(context, adSlot, new _k1(_k2Var, splashAdListener, adSlot, context));
        } else if (splashAdListener != null) {
            splashAdListener.onError(new AdErrorImpl(PtgErrorCode.SDK_NOT_READY, "Context unavailable", (Object) null));
        }
    }
}
