package com.alibaba.ariver.jsapi.security;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PermissionConfigExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24175a = "AriverAPI:PermissionConfigExtension";

    private boolean a(App app) {
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        return tinyAppInnerProxy != null && tinyAppInnerProxy.isInner(app);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    @ActionFilter
    @AutoCallback
    public BridgeResponse getPermissionConfig(@BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext) {
        boolean z;
        if (app == null) {
            RVLogger.d(f24175a, "getPermissionConfig app is null !");
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (a(app)) {
            z = true;
        } else {
            if (((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(!TextUtils.equals(NativeCallContext.DOMAIN_APP, apiContext.getContextId()) ? apiContext.getContextId() : null)) {
                z = true;
            } else {
                if (com.alibaba.ariver.jsapi.mtop.a.a(app, (AppModel) app.getData(AppModel.class), !TextUtils.equals(NativeCallContext.DOMAIN_APP, apiContext.getContextId()) ? apiContext.getContextId() : null)) {
                    z = false;
                } else {
                    z = true;
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isInnerApp", (Object) Boolean.valueOf(z));
        JSONArray jSONArrayA = a(app, TextUtils.equals(NativeCallContext.DOMAIN_APP, apiContext.getContextId()) ? null : apiContext.getContextId());
        if (jSONArrayA != null) {
            jSONObject.put("jsapiConfig", (Object) jSONArrayA);
        }
        RVLogger.d(f24175a, "getPermissionConfig result: " + jSONObject);
        return new BridgeResponse(jSONObject);
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

    @Nullable
    private JSONArray a(App app, String str) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            return null;
        }
        if (!TextUtils.equals(appModel.getAppId(), str) && !TextUtils.isEmpty(str)) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                for (PluginModel pluginModel : plugins) {
                    if (TextUtils.equals(pluginModel.getAppId(), str)) {
                        return a(PermissionModel.generateFromJSON(pluginModel.getPermission()));
                    }
                }
            }
            DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
            if (dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
                for (PluginModel pluginModel2 : dynamicPluginInfo.getPluginModels()) {
                    if (TextUtils.equals(pluginModel2.getAppId(), str)) {
                        return a(PermissionModel.generateFromJSON(pluginModel2.getPermission()));
                    }
                }
            }
        }
        return a(appModel.getPermissionModel());
    }

    private JSONArray a(PermissionModel permissionModel) {
        Set<String> jsapiList;
        if (permissionModel == null || (jsapiList = permissionModel.getJsapiList()) == null || jsapiList.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = jsapiList.iterator();
        while (it.hasNext()) {
            jSONArray.add(it.next());
        }
        return jSONArray;
    }
}
