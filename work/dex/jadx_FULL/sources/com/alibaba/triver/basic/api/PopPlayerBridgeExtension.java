package com.alibaba.triver.basic.api;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PopPlayerBridgeExtension implements BridgeExtension {
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

    @ActionFilter
    public void showPoplayer(@BindingParam({"event"}) String str, @BindingParam({"params"}) String str2, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            Intent intent = new Intent("com.alibaba.poplayer.PopLayer.action.POP");
            intent.putExtra("event", str);
            intent.putExtra("param", str2);
            LocalBroadcastManager.getInstance(apiContext.getAppContext()).sendBroadcast(intent);
            jSONObject.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            jSONObject.put("status", "error");
        }
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
