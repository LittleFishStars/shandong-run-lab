package com.fl.saas.base.custom.Interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.custom.CustomLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CustomInterstitialAdapter extends AdViewInterstitialAdapter implements BiddingResult {
    protected CustomInterstitialEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        release();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        LogcatUtil.d("YdSDK-Custom-Interstitial", "handle");
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.Interstitial.CustomInterstitialAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-Interstitial", "onSplashAdSuccessLoad");
                CustomInterstitialAdapter.this.onLoadedEvent();
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-Interstitial", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(CustomInterstitialAdapter.this.getAdSource().adv_id);
                sb.append("");
                errorInfo.adv_id = sb.toString();
                errorInfo.tagid = CustomInterstitialAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = str + str2;
                CustomInterstitialAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomInterstitialEventListener() { // from class: com.fl.saas.base.custom.Interstitial.CustomInterstitialAdapter.2
            @Override // com.fl.saas.base.custom.Interstitial.CustomInterstitialEventListener
            public void onInterstitialAdClicked() {
                CustomInterstitialAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.Interstitial.CustomInterstitialEventListener
            public void onInterstitialAdClose() {
                CustomInterstitialAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.Interstitial.CustomInterstitialEventListener
            public void onInterstitialAdShow() {
                CustomInterstitialAdapter.this.onShowEvent();
            }
        };
        HashMap map = new HashMap();
        map.put("appId", getAdSource().app_id);
        map.put(MedProConst.AD_PLACEID, getAdSource().tagid);
        map.put("appKey", getAdSource().app_key);
        if (!TextUtils.isEmpty(getAdSource().customParameJson)) {
            map.clear();
            map.putAll(JsonUtil.jsonObjectToMap(getAdSource().customParameJson));
        }
        loadCustomNetworkAd(activity, map, (Map) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.iz1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((InnerInterstitialBuilder) obj).getLocationMap();
            }
        }).orElse(null));
    }

    public abstract void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2);

    public void release() {
    }

    public abstract void show(Activity activity);

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public final void showInterstitial(Activity activity) {
        show(activity);
    }
}
