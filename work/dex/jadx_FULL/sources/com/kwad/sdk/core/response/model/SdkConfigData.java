package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.c;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SdkConfigData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int DEFAULT_CAN_USE_THRESHOLD = 300;
    public static final int DEFAULT_GOOD_IDC_THRESHOLD = 200;
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    private static final long serialVersionUID = -7796837168148055391L;
    private JSONObject abConfig;
    private JSONObject adxConfig;
    private JSONObject appConfig;
    private JSONObject mDataJsonObj;
    public long requestInterval = 3600;
    public List<com.kwad.sdk.h.a.a> h5PreloadConfigs = new ArrayList();
    public TemplateConfig templateConfig = new TemplateConfig();
    public TemplateConfigMap templateConfigMap = new TemplateConfigMap();
    public CouponActiveConfig couponActiveConfig = new CouponActiveConfig();
    public HttpDnsInfo httpDnsInfo = new HttpDnsInfo();
    public int goodIdcThresholdMs = 200;
    public int canUseThresholdMs = 300;

    @KsJson
    public static class CouponActiveConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 6375241669684789095L;
        public ActivityInfo activityInfo;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public int popUpShowTimeSeconds;
        public int videoSeconds;
        public int videoThreshold;
        public String title = "抽红包兑奖";
        public String secondTitle = "累计到100元可兑换京东卡";
        public String bottomTitle = "刷满5个视频抽红包，每个视频观看>5秒";
    }

    @KsJson
    public static class TemplateConfigMap extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6512236636350788192L;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
    }

    public JSONObject getAbConfig() {
        return this.abConfig;
    }

    public JSONObject getAdxConfig() {
        return this.adxConfig;
    }

    public JSONObject getAppConfig() {
        return this.appConfig;
    }

    public <T> T getAppConfigData(T t, com.kwad.sdk.g.b<JSONObject, T> bVar) {
        JSONObject jSONObject = this.appConfig;
        return jSONObject != null ? bVar.apply(jSONObject) : t;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(d.getResponseData(jSONObject.optString("data")));
            this.mDataJsonObj = jSONObject2;
            this.requestInterval = jSONObject2.optLong("requestInterval");
            this.goodIdcThresholdMs = this.mDataJsonObj.optInt("goodIdcThresholdMs", 200);
            this.canUseThresholdMs = this.mDataJsonObj.optInt("canUseThresholdMs", 300);
            com.kwad.sdk.core.config.b.k(this.mDataJsonObj);
            JSONObject jSONObjectOptJSONObject = this.mDataJsonObj.optJSONObject("abConfig");
            this.abConfig = jSONObjectOptJSONObject;
            com.kwad.sdk.core.config.b.k(jSONObjectOptJSONObject);
            JSONObject jSONObjectOptJSONObject2 = this.mDataJsonObj.optJSONObject("adxConfig");
            this.adxConfig = jSONObjectOptJSONObject2;
            com.kwad.sdk.core.config.b.k(jSONObjectOptJSONObject2);
            this.appConfig = this.mDataJsonObj.optJSONObject("appConfig");
            this.h5PreloadConfigs = ac.a(this.mDataJsonObj.optString("h5PreloadConfigs"), new c<com.kwad.sdk.h.a.a>() { // from class: com.kwad.sdk.core.response.model.SdkConfigData.1
                private static com.kwad.sdk.h.a.a NH() {
                    return new com.kwad.sdk.h.a.a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ com.kwad.sdk.core.b IA() {
                    return NH();
                }
            });
            com.kwad.sdk.core.config.b.k(this.appConfig);
            this.templateConfig.parseJson(this.mDataJsonObj.optJSONObject("templateConfig"));
            this.templateConfigMap.parseJson(this.mDataJsonObj.optJSONObject("templateConfigMap"));
            this.couponActiveConfig.parseJson(this.mDataJsonObj.optJSONObject("couponActiveConfig"));
            this.httpDnsInfo.parseJson(this.mDataJsonObj.optJSONObject("httpDnsInfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = this.mDataJsonObj;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
