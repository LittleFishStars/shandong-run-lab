package com.alibaba.alibctriver.proxy;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.open.proxy.IMtopParamProxy;
import com.alibaba.triver.prefetch.mtop.c;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcMtopParamProxy implements IMtopParamProxy {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        JSONObject f23689a;

        private a(JSONObject jSONObject) {
            this.f23689a = jSONObject;
        }
    }

    @Override // com.alibaba.triver.open.proxy.IMtopParamProxy
    public void parseMtopParam(JSONObject jSONObject, Bundle bundle, String str, AppModel appModel) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        Bundle bundle2;
        try {
            if ("3000000003738161".equals(str)) {
                if (jSONObject.get("refpid") == null && (bundle2 = (Bundle) bundle.get(TRiverConstants.KEY_OVER_PARAMS)) != null) {
                    String strValueOf = String.valueOf(bundle2.get("pid"));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        jSONObject.put("refpid", (Object) strValueOf);
                    }
                }
                HashMap map = new HashMap();
                map.put("hostAppId", appModel.getAppId());
                String strA = c.a("mtop.baichuan.suite.app.ext.get", "1.0", map);
                if (TextUtils.isEmpty(strA) || (jSONArray = new a(JSON.parseObject(strA, Feature.OrderedField).getJSONObject("data").getJSONObject("data")).f23689a.getJSONArray("pages")) == null || jSONArray.size() <= 0) {
                    return;
                }
                for (Object obj : jSONArray) {
                    if (str.equals(((JSONObject) obj).getString(MediationConstant.KEY_USE_POLICY_PAGE_ID)) && (jSONObject2 = ((JSONObject) obj).getJSONObject("customFields")) != null) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("$default$");
                        String jSONString = jSONObject3 != null ? jSONObject3.toJSONString() : "";
                        if (!TextUtils.isEmpty(jSONString)) {
                            jSONObject.put("variableMap", (Object) jSONString);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e(th.getMessage());
        }
    }
}
