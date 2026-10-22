package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ac;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class WebViewCommercialMsg extends com.kwad.sdk.core.response.a.a implements b, Serializable {
    private static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public a mBaseClMsgModel;
    public JSONObject msg;
    public String primaryKey;
    public double rate;
    public SubBusinessType subBiz;
    public String suffixRatio;
    public String tag;
    public com.kwai.adclient.kscommerciallogger.model.b type;

    public WebViewCommercialMsg(AdInfo adInfo) {
        if (adInfo != null) {
            this.mBaseClMsgModel = new a(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        a aVar;
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("sub_biz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("sub_biz"));
            } catch (Exception unused) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has(com.alipay.sdk.m.m.b.l)) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString(com.alipay.sdk.m.m.b.l));
            } catch (Exception unused2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b(jSONObject.optString("type"));
            } catch (Exception unused3) {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b("OTHER");
            }
        }
        JSONObject jSONObject2 = this.msg;
        if (jSONObject2 == null || (aVar = this.mBaseClMsgModel) == null) {
            return;
        }
        ac.a(jSONObject2, aVar.toJson(), false);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        ac.putValue(jSONObject, com.alipay.sdk.m.m.b.l, this.biz.value);
        ac.putValue(jSONObject, "subBiz", this.subBiz.value);
        ac.putValue(jSONObject, "type", this.type.getValue());
    }
}
