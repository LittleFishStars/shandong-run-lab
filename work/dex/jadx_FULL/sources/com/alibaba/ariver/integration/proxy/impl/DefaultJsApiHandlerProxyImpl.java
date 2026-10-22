package com.alibaba.ariver.integration.proxy.impl;

import android.os.Bundle;
import com.alibaba.ariver.engine.api.proxy.RVJSApiHandlerProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultJsApiHandlerProxyImpl implements RVJSApiHandlerProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24089a = "tyroRequest";
    private static final String b = "AriverInt:DefaultJsApiHandlerProxyImpl";

    private int a(String str, Bundle bundle, JSONObject jSONObject) {
        try {
            if (!a(BundleUtils.getString(bundle, "appId"))) {
                RVLogger.d(b, "getTyroBlockTime disable!");
                return -1;
            }
        } catch (Throwable th) {
            RVLogger.d(b, th.getMessage());
        }
        if (jSONObject == null) {
            RVLogger.d(b, "getTyroBlockTime data is null");
            return -1;
        }
        if (!f24089a.equals(str)) {
            RVLogger.d(b, "getTyroBlockTime " + str + " not " + f24089a);
            return -1;
        }
        if (bundle == null) {
            RVLogger.d(b, "getTyroBlockTime params or realJson is null");
            return -1;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
        if (jSONObject2 == null) {
            return -1;
        }
        AppInfoScene appInfoSceneExtractScene = AppInfoScene.extractScene(bundle);
        boolean z = appInfoSceneExtractScene == AppInfoScene.DEBUG || appInfoSceneExtractScene == AppInfoScene.INSPECT;
        RVLogger.d(b, "getTyroBlockTime isDebugOrInspect " + z);
        if (!z) {
            return -1;
        }
        int i = JSONUtils.getInt(jSONObject2, "blockTimeout", -1);
        RVLogger.d(b, "getTyroBlockTime result: " + i);
        return i;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVJSApiHandlerProxy
    public int getSyncTimeout(String str, Bundle bundle, JSONObject jSONObject) {
        return a(str, bundle, jSONObject);
    }

    private static boolean a(String str) {
        return ((RVRemoteDebugProxy) RVProxy.get(RVRemoteDebugProxy.class)).enableTyroBlock(str);
    }
}
