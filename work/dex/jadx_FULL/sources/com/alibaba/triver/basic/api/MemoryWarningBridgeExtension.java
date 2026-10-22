package com.alibaba.triver.basic.api;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MemoryWarningBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ComponentCallbacks2 f24679a = null;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        if (this.f24679a != null) {
            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            if (applicationContext != null) {
                applicationContext.unregisterComponentCallbacks(this.f24679a);
            }
            this.f24679a = null;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public void startMonitorMemoryWarning(@BindingCallback final BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        if (bridgeCallback == null || apiContext == null) {
            return;
        }
        try {
            Context applicationContext = apiContext.getAppContext().getApplicationContext();
            if (this.f24679a == null) {
                ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2() { // from class: com.alibaba.triver.basic.api.MemoryWarningBridgeExtension.1
                    @Override // android.content.ComponentCallbacks
                    public void onConfigurationChanged(Configuration configuration) {
                    }

                    @Override // android.content.ComponentCallbacks
                    public void onLowMemory() {
                    }

                    @Override // android.content.ComponentCallbacks2
                    public void onTrimMemory(int i) {
                        if (i == 10 || i == 15) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.alibaba.ariver.permission.b.b, (Object) Integer.valueOf(i));
                            bridgeCallback.sendJSONResponse(jSONObject);
                        }
                    }
                };
                this.f24679a = componentCallbacks2;
                applicationContext.registerComponentCallbacks(componentCallbacks2);
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @ActionFilter
    public void stopMonitorMemoryWarning(@BindingApiContext ApiContext apiContext) {
        if (apiContext == null) {
            return;
        }
        try {
            if (this.f24679a != null) {
                apiContext.getAppContext().getApplicationContext().unregisterComponentCallbacks(this.f24679a);
                this.f24679a = null;
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }
}
