package com.alibaba.triver.tblive;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TLiveMiniBridgeExtension implements BridgeExtension {
    public static final String TAOBAO_SHOW_FLOATING_WINDOW = "com.taobao.live.showFloatingWindow.action";
    public static final String TAOLIVE_SHOW_MINILIVE_ACTION = "com.taobao.taolive.miniLiveRoom.action";

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void hideTBMiniLive(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            return;
        }
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        Intent intent = new Intent();
        intent.setAction("com.taobao.taolive.miniLiveRoom.action");
        intent.putExtra("actionType", "hideMiniLive");
        LocalBroadcastManager.getInstance(applicationContext.getApplicationContext()).sendBroadcast(intent);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void isShowingFloatingWindow(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Bundle startParams;
        boolean z = (app == null || (startParams = app.getStartParams()) == null) ? false : startParams.getBoolean("isWindowShow");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isShow", (Object) Boolean.valueOf(z));
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
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

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void showFloatingWindow(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam(name = {"isShow"}) boolean z, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || page.getPageContext() == null) {
            return;
        }
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        Intent intent = new Intent();
        intent.setAction(TAOBAO_SHOW_FLOATING_WINDOW);
        intent.putExtra("actionType", "showFloatingWindow");
        intent.putExtra("isShow", z);
        LocalBroadcastManager.getInstance(applicationContext.getApplicationContext()).sendBroadcast(intent);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void startTBMiniLive(@BindingNode(App.class) App app, @BindingParam(name = {"data"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null) {
            return;
        }
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        app.getAppId();
        Intent intent = new Intent();
        intent.setAction("com.taobao.taolive.miniLiveRoom.action");
        intent.putExtra("actionType", "startMiniLive");
        intent.putExtra("actionDatas", str);
        LocalBroadcastManager.getInstance(applicationContext.getApplicationContext()).sendBroadcast(intent);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void updateTBLivePosition(@BindingNode(App.class) App app, @BindingParam(name = {"data"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || TextUtils.isEmpty(str)) {
            return;
        }
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        Intent intent = new Intent();
        intent.setAction("com.taobao.taolive.miniLiveRoom.action");
        intent.putExtra("actionType", "updateLivePosition");
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("x", jSONObject.getString("x"));
            jSONObject2.put("y", jSONObject.getString("y"));
            intent.putExtra("actionDatas", jSONObject2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(applicationContext.getApplicationContext()).sendBroadcast(intent);
    }
}
