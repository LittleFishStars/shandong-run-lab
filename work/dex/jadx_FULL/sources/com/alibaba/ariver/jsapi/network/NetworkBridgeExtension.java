package com.alibaba.ariver.jsapi.network;

import android.app.Activity;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkBridgeExtension implements BridgeExtension {
    @ActionFilter
    @AutoCallback
    public JSONObject getNetworkType(@BindingApiContext ApiContext apiContext) {
        Activity activity = apiContext.getActivity();
        if (activity == null) {
            return BridgeResponse.UNKNOWN_ERROR.get();
        }
        String simpleNetworkType = NetworkUtil.getSimpleNetworkType(activity);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("err_msg", (Object) ("network_type:" + simpleNetworkType));
        jSONObject.put("networkType", (Object) simpleNetworkType);
        jSONObject.put("networkInfo", (Object) NetworkUtil.getDetailNetworkType(activity));
        jSONObject.put("networkAvailable", (Object) Boolean.valueOf(!"fail".equals(simpleNetworkType)));
        return jSONObject;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
