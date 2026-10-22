package com.fl.saas.base.inner.reward;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeRewardVideoAdapter extends AdViewVideoAdapter implements InnerNativeAdapter, AdChangeCacheData, InnerRewardVideoListener {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.reward.InnerNativeRewardVideoAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeRewardVideoAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeRewardVideoAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeRewardVideoAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.reward.a
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    return this.f1749a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeRewardVideoAdapter.this.mNativeAd = nativeAd;
            InnerNativeRewardVideoAdapter.this.onLoadedEvent();
        }
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public AdSource getRewardVideoAdSource() {
        return getAdSource();
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public NativeAd getRewardVideoNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.NATIVE);
        this.handler.init();
        this.handler.load(activity);
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public void onClick() {
        onClickedEvent();
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public void onClose() {
        onClosedEvent();
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public void onError(YdError ydError) {
        disposeError(ydError);
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public void onReward() {
        onRewardEvent();
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public void onShow() {
        onShowEvent();
    }

    @Override // com.fl.saas.base.inner.reward.InnerRewardVideoListener
    public void onVideoComplete() {
        onVideoCompletedEvent();
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }

    @Override // com.fl.saas.base.adapter.AdViewVideoAdapter
    public void showRewardVideo() {
        Activity activityOrNull = getActivityOrNull();
        if (this.mNativeAd == null || activityOrNull == null) {
            onAdFailed(new YdError(20404, "rewardvideo show error"));
        } else {
            YdInnerRewardVideoActivity.setRewardVideoListener(this);
            activityOrNull.startActivity(new Intent(activityOrNull, (Class<?>) YdInnerRewardVideoActivity.class));
        }
    }
}
