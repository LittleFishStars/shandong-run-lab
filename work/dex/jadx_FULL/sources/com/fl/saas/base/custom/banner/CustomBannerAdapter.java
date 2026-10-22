package com.fl.saas.base.custom.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
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
public abstract class CustomBannerAdapter extends AdViewBannerAdapter implements BiddingResult {
    protected CustomBannerEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;
    private long reqTime;

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        release();
    }

    public abstract View getBannerView();

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.banner.CustomBannerAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-Banner", "onBannerAdSuccessLoad");
                View bannerView = CustomBannerAdapter.this.getBannerView();
                if (bannerView != null) {
                    CustomBannerAdapter.this.onLoadedEvent(bannerView);
                    return;
                }
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CustomBannerAdapter.this.getAdSource().adv_id + "";
                errorInfo.tagid = CustomBannerAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = "custom banner return null";
                CustomBannerAdapter.this.disposeError(errorInfo);
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-Banner", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(CustomBannerAdapter.this.getAdSource().adv_id);
                sb.append("");
                errorInfo.adv_id = sb.toString();
                errorInfo.tagid = CustomBannerAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = str + str2;
                CustomBannerAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomBannerEventListener() { // from class: com.fl.saas.base.custom.banner.CustomBannerAdapter.2
            @Override // com.fl.saas.base.custom.banner.CustomBannerEventListener
            public void onBannerAdClicked() {
                LogcatUtil.d("YdSDK-Custom-Banner", "onADClicked");
                CustomBannerAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.banner.CustomBannerEventListener
            public void onBannerAdClose() {
                LogcatUtil.d("YdSDK-Custom-Banner", "onADClosed");
                CustomBannerAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.banner.CustomBannerEventListener
            public void onBannerAdShow() {
                LogcatUtil.d("YdSDK-Custom-Banner", "onADExposure");
                CustomBannerAdapter.this.onShowEvent();
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
        loadCustomNetworkAd(activity, map, null);
    }

    public abstract void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2);

    public void release() {
    }
}
