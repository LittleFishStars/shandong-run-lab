package com.alibaba.ariver.jsapi.mtop;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.storage.PluginStore;
import com.alibaba.ariver.resource.content.PluginResourcePackage;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f24157a = "x-miniapp-id-taobao";
    public static String b = "x-mini-appkey";
    public static String c = "x-req-appkey";
    public static String d = "x-act";
    public static String e = "x-open-biz-data";
    public static String f = "appId";
    public static String g = "invokerAppId";
    public static String h = "x-miniapp-env";
    public static String i = "x-miniapp-version";

    public static Map<String, String> a(@Nullable App app, @Nullable AppModel appModel, ApiContext apiContext) {
        JSONObject jSONObject;
        String pluginId;
        PluginModel pluginModel;
        HashMap map = new HashMap();
        if (appModel != null) {
            AppInfoModel appInfoModel = appModel.getAppInfoModel();
            String appKey = appInfoModel.getAppKey();
            String appId = appModel.getAppId();
            map.put(f, appId);
            map.put(f24157a, appId);
            map.put(b, appKey);
            map.put(i, appInfoModel.getDeveloperVersion());
            TemplateConfigModel templateConfig = appInfoModel.getTemplateConfig();
            if (templateConfig == null || !templateConfig.isTemplateValid()) {
                jSONObject = null;
                pluginId = appId;
            } else {
                pluginId = templateConfig.getTemplateId() != null ? templateConfig.getTemplateId() : appId;
                if (templateConfig.getAppKey() != null) {
                    appKey = templateConfig.getAppKey();
                }
                jSONObject = new JSONObject();
                jSONObject.put("templateVersion", (Object) templateConfig.getTemplateVersion());
                jSONObject.put(RVStartParams.KEY_TEMPLATE_ID, (Object) pluginId);
                jSONObject.put("appKey", (Object) appKey);
            }
            if (apiContext != null && !TextUtils.isEmpty(apiContext.getPluginId())) {
                List<PluginModel> plugins = appInfoModel.getPlugins();
                if (plugins != null) {
                    for (PluginModel pluginModel2 : plugins) {
                        if (pluginModel2 != null && TextUtils.equals(pluginModel2.getAppId(), apiContext.getPluginId())) {
                            String pluginId2 = apiContext.getPluginId();
                            appKey = pluginModel2.getAppKey();
                            pluginId = pluginId2;
                            break;
                        }
                    }
                }
                if (app != null && (pluginModel = ((PluginStore) app.getData(PluginStore.class, true)).getDynamicPluginModelMap().get(apiContext.getPluginId())) != null && TextUtils.equals(pluginModel.getAppId(), apiContext.getPluginId())) {
                    pluginId = apiContext.getPluginId();
                    appKey = pluginModel.getAppKey();
                }
            }
            map.put(c, appKey);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(f, (Object) appId);
            jSONObject2.put(g, (Object) pluginId);
            jSONObject2.put("viaFusionApp", (Object) Boolean.TRUE);
            if (jSONObject != null) {
                jSONObject2.put("templateConfig", (Object) jSONObject);
            }
            map.put(e, jSONObject2.toJSONString());
        }
        return map;
    }

    public static boolean a(App app, @Nullable AppModel appModel, String str) {
        PluginModel pluginModel;
        if (appModel == null || (TextUtils.isEmpty(str) && ((TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class)).isInner(app))) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                for (PluginModel pluginModel2 : plugins) {
                    if (TextUtils.equals(pluginModel2.getAppId(), str)) {
                        return pluginModel2.getPermission() != null;
                    }
                }
            }
            ResourcePackage resourcePackage = ResourcePackagePool.getInstance().getPackage(str);
            if ((resourcePackage instanceof PluginResourcePackage) && (pluginModel = ((PluginResourcePackage) resourcePackage).getPluginModel()) != null && TextUtils.equals(pluginModel.getAppId(), str)) {
                return pluginModel.getPermission() != null;
            }
        }
        return appModel.getPermissionModel() != null;
    }

    public static boolean a(@Nullable AppModel appModel, String str, String str2) {
        PluginModel pluginModel;
        if (appModel == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            if (plugins != null) {
                for (PluginModel pluginModel2 : plugins) {
                    if (TextUtils.equals(pluginModel2.getAppId(), str) && pluginModel2.getPermission() != null && !TextUtils.isEmpty(str2)) {
                        PermissionModel permissionModelGenerateFromJSON = PermissionModel.generateFromJSON(pluginModel2.getPermission());
                        if (permissionModelGenerateFromJSON.getIgnorePermissionCheckMtopApi() != null) {
                            return permissionModelGenerateFromJSON.getIgnorePermissionCheckMtopApi().contains(str2);
                        }
                    }
                }
            }
            ResourcePackage resourcePackage = ResourcePackagePool.getInstance().getPackage(str);
            if ((resourcePackage instanceof PluginResourcePackage) && (pluginModel = ((PluginResourcePackage) resourcePackage).getPluginModel()) != null && TextUtils.equals(pluginModel.getAppId(), str) && pluginModel.getPermission() != null && !TextUtils.isEmpty(str2)) {
                PermissionModel permissionModelGenerateFromJSON2 = PermissionModel.generateFromJSON(pluginModel.getPermission());
                if (permissionModelGenerateFromJSON2.getIgnorePermissionCheckMtopApi() != null) {
                    return permissionModelGenerateFromJSON2.getIgnorePermissionCheckMtopApi().contains(str2);
                }
            }
        }
        if (appModel.getPermissionModel() == null || TextUtils.isEmpty(str2) || appModel.getPermissionModel().getIgnorePermissionCheckMtopApi() == null) {
            return false;
        }
        return appModel.getPermissionModel().getIgnorePermissionCheckMtopApi().contains(str2);
    }
}
