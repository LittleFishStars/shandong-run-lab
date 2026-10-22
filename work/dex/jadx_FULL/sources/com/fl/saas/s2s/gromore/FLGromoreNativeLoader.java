package com.fl.saas.s2s.gromore;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.api.YdSDK;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreNativeLoader extends MediationCustomNativeLoader {
    private static final String TAG = CommConstant.getClassTag("FLGromore", FLGromoreNativeLoader.class);
    private NativeAd mNativeAd;

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(final Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        String aDNNetworkSlotId = mediationCustomServiceConfig.getADNNetworkSlotId();
        float expressViewAcceptedWidth = adSlot.getExpressViewAcceptedWidth();
        float expressViewAcceptedHeight = adSlot.getExpressViewAcceptedHeight();
        AdParams.Builder builder = new AdParams.Builder(aDNNetworkSlotId);
        if (expressViewAcceptedWidth > 0.0f) {
            builder.setExpressWidth(expressViewAcceptedWidth);
        }
        if (expressViewAcceptedHeight > 0.0f) {
            builder.setExpressHeight(expressViewAcceptedHeight);
        }
        YdSDK.loadMixNative(context, builder.build(), new NativeLoadListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreNativeLoader.1
            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLGromoreNativeLoader.TAG, "onAdFailed");
                FLGromoreNativeLoader.this.callLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.api.mixNative.NativeLoadListener
            public void onNativeAdLoaded(NativeAd nativeAd) {
                LogcatUtil.d(FLGromoreNativeLoader.TAG, "onNativeAdLoaded");
                FLGromoreNativeLoader.this.mNativeAd = nativeAd;
                if (nativeAd == null) {
                    FLGromoreNativeLoader.this.callLoadFail(-1, "native ad is null");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                FLGromoreFeedNativeAd fLGromoreFeedNativeAd = new FLGromoreFeedNativeAd(nativeAd, context);
                if (FLGromoreNativeLoader.this.isClientBidding()) {
                    double ecpm = nativeAd.getECPM();
                    if (ecpm < AudioStats.AUDIO_AMPLITUDE_NONE) {
                        ecpm = 0.0d;
                    }
                    fLGromoreFeedNativeAd.setBiddingPrice(ecpm);
                }
                arrayList.add(fLGromoreFeedNativeAd);
                FLGromoreNativeLoader.this.callLoadSuccess(arrayList);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        try {
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd != null) {
                nativeAd.biddingResultUpload(z, (int) d, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
