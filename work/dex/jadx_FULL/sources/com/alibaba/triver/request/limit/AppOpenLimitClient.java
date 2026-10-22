package com.alibaba.triver.request.limit;

import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.SyncRequestClient;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppOpenLimitClient extends SyncRequestClient<AppOpenLimitParam, JSONObject, JSONObject> {

    public static class AppOpenLimitParam extends RequestParams {
        private String appId;

        public AppOpenLimitParam(String str, Bundle bundle) {
            super(str, bundle);
            this.api = "mtop.taobao.miniapp.flow.limit.get";
            this.version = "1.0";
            this.appId = str;
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("appId", this.appId);
            return map;
        }
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject configSuccessResponse(byte[] bArr) {
        return ((JSONObject) JSON.parseObject(bArr, JSONObject.class, new Feature[0])).getJSONObject("data");
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject configFailureResponse(byte[] bArr) {
        return null;
    }
}
