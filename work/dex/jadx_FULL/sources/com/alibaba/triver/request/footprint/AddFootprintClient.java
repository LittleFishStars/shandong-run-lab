package com.alibaba.triver.request.footprint;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.network.SyncRequestClient;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFootprintClient extends SyncRequestClient<AddFootprintParam, String, JSONObject> {

    public static class AddFootprintParam extends RequestParams {
        public AddFootprintParam(String str, Bundle bundle) {
            super(str, bundle);
            this.api = "mtop.taobao.miniapp.user.track.record";
            this.version = "1.0";
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("miniapp_id", getAppId());
            map.put("page_name", "miniapp_client_container");
            map.put("app_name", "miniapp_client_container");
            return map;
        }
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String configSuccessResponse(byte[] bArr) {
        JSONObject jSONObject = ((JSONObject) JSON.parseObject(bArr, JSONObject.class, new Feature[0])).getJSONObject("data");
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        return jSONObject.getString("result");
    }

    @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject configFailureResponse(byte[] bArr) {
        return null;
    }

    public static void a(final String str, final Bundle bundle) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.request.footprint.AddFootprintClient.1
            @Override // java.lang.Runnable
            public void run() {
                CommonResponse<String, JSONObject> commonResponseExecute = new AddFootprintClient().execute(new AddFootprintParam(str, bundle));
                if (commonResponseExecute.success) {
                    RVLogger.d("AddFootprintClient", "addFootPrint success result：" + commonResponseExecute.successData);
                    return;
                }
                RVLogger.d("AddFootprintClient", "addFootPrint fail result：" + commonResponseExecute.errorMsg);
            }
        });
    }
}
