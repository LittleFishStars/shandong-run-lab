package com.fl.saas.base.custom.spread;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.arch.core.util.Function;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
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
public abstract class CustomSpreadAdapter extends AdViewSpreadAdapter implements BiddingResult {
    protected CustomSplashEventListener mImpressionListener;
    protected CustomLoadListener mLoadListener;

    /* JADX INFO: renamed from: com.fl.saas.base.custom.spread.CustomSpreadAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements CustomLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdDataLoaded$0(ViewGroup viewGroup) {
            CustomSpreadAdapter.this.show(viewGroup);
        }

        @Override // com.fl.saas.base.custom.CustomLoadListener
        public void onAdDataLoaded() {
            LogcatUtil.d("YdSDK-Custom-Spread", "onSplashAdSuccessLoad");
            CustomSpreadAdapter.this.onSpreadLoadedEvent(null, new AdViewSpreadAdapter.AdViewLoadListener() { // from class: com.fl.saas.base.custom.spread.a
                @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter.AdViewLoadListener
                public final void AdViewLoad(ViewGroup viewGroup) {
                    this.f30119a.lambda$onAdDataLoaded$0(viewGroup);
                }
            });
        }

        @Override // com.fl.saas.base.custom.CustomLoadListener
        public void onAdLoadError(String str, String str2) {
            LogcatUtil.d("YdSDK-Custom-Spread", "disposeError, " + str + "___" + str2);
            ErrorInfo errorInfo = new ErrorInfo();
            StringBuilder sb = new StringBuilder();
            sb.append(CustomSpreadAdapter.this.getAdSource().adv_id);
            sb.append("");
            errorInfo.adv_id = sb.toString();
            errorInfo.tagid = CustomSpreadAdapter.this.getAdSource().tagid;
            errorInfo.code = ErrorCodeConstant.CUSTOM_AD_ERROR;
            errorInfo.msg = str + str2;
            CustomSpreadAdapter.this.disposeError(errorInfo);
        }
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
    }

    @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        release();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public final void handle(Activity activity) {
        LogcatUtil.d("YdSDK-Custom-Spread", "handle");
        this.mLoadListener = new AnonymousClass1();
        this.mImpressionListener = new CustomSplashEventListener() { // from class: com.fl.saas.base.custom.spread.CustomSpreadAdapter.2
            @Override // com.fl.saas.base.custom.spread.CustomSplashEventListener
            public void onDeeplinkCallback(boolean z) {
            }

            @Override // com.fl.saas.base.custom.spread.CustomSplashEventListener
            public void onDownloadConfirm(Context context) {
            }

            @Override // com.fl.saas.base.custom.spread.CustomSplashEventListener
            public void onSplashAdClicked() {
                LogcatUtil.d("YdSDK-Custom-Spread", "onADClicked");
                CustomSpreadAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.base.custom.spread.CustomSplashEventListener
            public void onSplashAdDismiss() {
                LogcatUtil.d("YdSDK-Custom-Spread", "onADDismissed");
                CustomSpreadAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.custom.spread.CustomSplashEventListener
            public void onSplashAdShow() {
                CustomSpreadAdapter.this.onShowEvent();
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
        loadCustomNetworkAd(activity, map, (Map) getBuilderFieldOptional(new Function() { // from class: com.zj.adlib.mz1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((InnerSpreadBuilder) obj).getLocationMap();
            }
        }).orElse(null));
    }

    public abstract void loadCustomNetworkAd(Activity activity, Map<String, Object> map, Map<String, Object> map2);

    public void release() {
    }

    public abstract void show(ViewGroup viewGroup);
}
