package com.alibaba.triver.extensions;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.point.GetTopAppPoint;
import com.alibaba.triver.request.topApp.GetTopAppClient;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetTopAppExtension implements GetTopAppPoint {
    @Override // com.alibaba.triver.point.GetTopAppPoint
    public Set<String> getTopApp() {
        HashSet hashSet = new HashSet();
        CommonResponse<JSONArray, JSONObject> commonResponseExecute = new GetTopAppClient().execute(new GetTopAppClient.getTopAppParam(null, null));
        if (commonResponseExecute.success) {
            JSONArray jSONArray = commonResponseExecute.successData;
            if (jSONArray != null && jSONArray.size() > 0) {
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null && !jSONObject.isEmpty()) {
                        String string = jSONObject.getString("app_id");
                        if (!TextUtils.isEmpty(string)) {
                            hashSet.add(string);
                        }
                    }
                }
            }
        } else {
            RVLogger.e(TRiverConstants.TAG, "getTopAppError: " + commonResponseExecute.errorMsg);
        }
        return hashSet;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
