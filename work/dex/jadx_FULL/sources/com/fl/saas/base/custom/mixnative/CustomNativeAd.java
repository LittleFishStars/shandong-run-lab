package com.fl.saas.base.custom.mixnative;

import android.content.Context;
import androidx.annotation.NonNull;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.innterNative.BaseNativeAd;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CustomNativeAd<T> extends BaseNativeAd<T> implements C2SBiddingECPM, BiddingResult {
    protected CustomMixNativeEventListener mEventListener;

    public CustomNativeAd(@NonNull Context context, @NonNull T t) {
        super(context, t);
        if (this.mEventListener == null) {
            this.mEventListener = new CustomMixNativeEventListener() { // from class: com.fl.saas.base.custom.mixnative.CustomNativeAd.1
                @Override // com.fl.saas.base.custom.mixnative.CustomMixNativeEventListener
                public void onAdVideoEnd() {
                    CustomNativeAd.this.onAdVideoEndEvent();
                }

                @Override // com.fl.saas.base.custom.mixnative.CustomMixNativeEventListener
                public void onAdVideoStart() {
                    CustomNativeAd.this.onAdVideoStartEvent();
                }

                @Override // com.fl.saas.base.custom.mixnative.CustomMixNativeEventListener
                public void onNativeAdClicked() {
                    CustomNativeAd.this.onAdClickedEvent();
                }

                @Override // com.fl.saas.base.custom.mixnative.CustomMixNativeEventListener
                public void onNativeAdClose() {
                    CustomNativeAd.this.onAdCloseEvent();
                }

                @Override // com.fl.saas.base.custom.mixnative.CustomMixNativeEventListener
                public void onNativeAdError(int i, String str) {
                    CustomNativeAd.this.onAdFailedEvent(YdError.create(i, str));
                }

                @Override // com.fl.saas.base.custom.mixnative.CustomMixNativeEventListener
                public void onNativeAdShow() {
                    CustomNativeAd.this.onAdImpressedEvent();
                }
            };
        }
    }

    public CustomMixNativeEventListener getEventListener() {
        return this.mEventListener;
    }
}
