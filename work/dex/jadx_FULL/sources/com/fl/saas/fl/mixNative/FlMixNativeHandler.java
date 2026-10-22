package com.fl.saas.fl.mixNative;

import androidx.arch.core.util.Function;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.FLSDK;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.base.adapter.MixNativeAPI;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.fl.config.FlAdManagerHolder;
import com.fl.spi.SPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(keyClass = {NativeAd.class}, value = 22)
@SPI({MixNativeAPI.class})
public class FlMixNativeHandler extends MixNativeHandler {
    private static final String TAG = CommConstant.getClassTag("FL", FlMixNativeHandler.class);

    /* JADX INFO: renamed from: com.fl.saas.fl.mixNative.FlMixNativeHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ com.fl.saas.api.mixNative.NativeAd lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return new FlNative(FlMixNativeHandler.this.getContext(), nativeAd);
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(FLError fLError) {
            FlMixNativeHandler.this.onAdFailed(new YdError(fLError.getCode(), fLError.getMsg()));
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(NativeAd nativeAd) {
            if (FlMixNativeHandler.this.getContext() != null) {
                FlMixNativeHandler.this.handleAd(nativeAd, new Function() { // from class: com.fl.saas.fl.mixNative.a
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return this.f30168a.lambda$onNativeAdLoaded$0((NativeAd) obj);
                    }
                });
            } else {
                FlMixNativeHandler.this.onAdFailed(new YdError(ErrorCodeConstant.UNION_ERROR, "context is null"));
            }
        }
    }

    @MixNativeLoad
    public void handle() {
        LogcatUtil.d(TAG, "handle");
        FLSDK.loadMixNative(getContext(), new AdParams.Builder(getPosId()).setExpressHeight(getAdParams().getExpressHeight()).setExpressWidth(getAdParams().getExpressWidth()).setLinkId(getAdSource().req_id).build(), new AnonymousClass1());
    }

    @Override // com.fl.saas.base.adapter.MixNativeHandler
    public void init() {
        LogcatUtil.d(TAG, "init");
        FlAdManagerHolder.init(getContext(), getAppId());
    }
}
