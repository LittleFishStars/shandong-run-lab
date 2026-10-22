package com.fl.saas.base.custom.fullvideo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdViewFullVideoAdapter;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.custom.CustomLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CustomFullVideoAdapter extends AdViewFullVideoAdapter implements BiddingResult {
    protected CustomFullVideoEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        release();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        LogcatUtil.d("YdSDK-Custom-FullVideo", "handle");
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.fullvideo.CustomFullVideoAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onSplashAdSuccessLoad");
                CustomFullVideoAdapter.this.onLoadedEvent();
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(CustomFullVideoAdapter.this.getAdSource().adv_id);
                sb.append("");
                errorInfo.adv_id = sb.toString();
                errorInfo.tagid = CustomFullVideoAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = str + str2;
                CustomFullVideoAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomFullVideoEventListener() { // from class: com.fl.saas.base.custom.fullvideo.CustomFullVideoAdapter.2
            @Override // com.fl.saas.base.custom.fullvideo.CustomFullVideoEventListener
            public void onFullVideoAdClicked() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onAdClicked");
                CustomFullVideoAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.fullvideo.CustomFullVideoEventListener
            public void onFullVideoAdClose() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onPageDismiss");
                CustomFullVideoAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.fullvideo.CustomFullVideoEventListener
            public void onFullVideoAdShow() {
                LogcatUtil.d("YdSDK-Custom-FullVideo", "onVideoPlayStart");
                CustomFullVideoAdapter.this.onShowEvent();
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

    public abstract void show(Activity activity);

    @Override // com.fl.saas.base.adapter.AdViewFullVideoAdapter
    public final void showRewardVideo() {
        super.showRewardVideo();
        LogcatUtil.d("YdSDK-Custom-FullVideo", "showRewardVideo");
        getActivityValid().ifPresent(new Consumer() { // from class: com.zj.adlib.gz1
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f42012a.show((Activity) obj);
            }
        });
    }
}
