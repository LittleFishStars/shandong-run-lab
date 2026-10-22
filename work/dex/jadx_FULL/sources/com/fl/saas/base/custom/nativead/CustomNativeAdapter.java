package com.fl.saas.base.custom.nativead;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.custom.CustomLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.widget.ErrorInfo;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CustomNativeAdapter extends AdViewNativeAdapter implements BiddingResult {
    protected CustomNativeData.CustomNativeEventListener mImpressionEventListener;
    protected CustomLoadListener mLoadListener;

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

    public abstract List<CustomNativeData> getNativeList();

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        this.mLoadListener = new CustomLoadListener() { // from class: com.fl.saas.base.custom.nativead.CustomNativeAdapter.1
            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdDataLoaded() {
                LogcatUtil.d("YdSDK-Custom-Native", "onNativeAdSuccessLoad");
                if (CustomNativeAdapter.this.getNativeList() != null && CustomNativeAdapter.this.getNativeList().size() > 0) {
                    CustomNativeAdapter.this.onLoadedEvent(new ArrayList(CustomNativeAdapter.this.getNativeList()));
                    return;
                }
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.adv_id = CustomNativeAdapter.this.getAdSource().adv_id + "";
                errorInfo.tagid = CustomNativeAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = "custom native return null";
                CustomNativeAdapter.this.disposeError(errorInfo);
            }

            @Override // com.fl.saas.base.custom.CustomLoadListener
            public void onAdLoadError(String str, String str2) {
                LogcatUtil.d("YdSDK-Custom-Native", "disposeError, " + str + "___" + str2);
                ErrorInfo errorInfo = new ErrorInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(CustomNativeAdapter.this.getAdSource().adv_id);
                sb.append("");
                errorInfo.adv_id = sb.toString();
                errorInfo.tagid = CustomNativeAdapter.this.getAdSource().tagid;
                errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
                errorInfo.msg = str + str2;
                CustomNativeAdapter.this.disposeError(errorInfo);
            }
        };
        this.mImpressionEventListener = new CustomNativeData.CustomNativeEventListener() { // from class: com.fl.saas.base.custom.nativead.CustomNativeAdapter.2
            @Override // com.fl.saas.base.custom.nativead.CustomNativeData.CustomNativeEventListener
            public void onNativeAdClicked(int i) {
                CustomNativeAdapter.this.onClickedEvent(i);
            }

            @Override // com.fl.saas.base.custom.nativead.CustomNativeData.CustomNativeEventListener
            public void onNativeAdShow(int i) {
                CustomNativeAdapter.this.onShowEvent(i);
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

    @Override // com.fl.saas.base.adapter.AdViewNativeAdapter
    public void soundControl(boolean z) {
    }
}
