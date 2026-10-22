package com.alibaba.triver.request.topApp;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.SyncRequestClient;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetTopAppClient extends SyncRequestClient<getTopAppParam, JSONArray, JSONObject> {

    public static class getTopAppParam extends RequestParams {
        public getTopAppParam(String str, Bundle bundle) {
            super(str, bundle);
            this.api = "mtop.taobao.miniapp.top.get";
            this.version = "1.0";
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("client_code", "taobao");
            return map;
        }
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONArray configSuccessResponse(byte[] bArr) {
        try {
            JSONObject jSONObject = ((JSONObject) JSON.parseObject(bArr, JSONObject.class, new Feature[0])).getJSONObject("data");
            if (jSONObject != null && !jSONObject.isEmpty()) {
                return jSONObject.getJSONArray("result");
            }
            return null;
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "configSuccessResponseError", e);
            return null;
        }
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject configFailureResponse(byte[] bArr) {
        return null;
    }
}
