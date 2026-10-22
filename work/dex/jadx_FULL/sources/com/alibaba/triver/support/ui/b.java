package com.alibaba.triver.support.ui;

import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25190a = "SupportUiUtils";
    private static AtomicInteger b = new AtomicInteger(1);

    public static int a() {
        return b.addAndGet(1);
    }

    public static Set<String> a(AppModel appModel, DynamicPluginInfo dynamicPluginInfo) {
        PermissionModel permissionModelGenerateFromJSON;
        JSONObject nativeApiScopeConfig;
        PermissionModel permissionModelGenerateFromJSON2;
        JSONObject nativeApiScopeConfig2;
        JSONObject nativeApiScopeConfig3;
        HashSet hashSet = new HashSet();
        PermissionModel permissionModel = appModel.getPermissionModel();
        if (permissionModel != null && (nativeApiScopeConfig3 = permissionModel.getNativeApiScopeConfig()) != null) {
            hashSet.addAll(nativeApiScopeConfig3.keySet());
        }
        if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null) {
            for (PluginModel pluginModel : appModel.getAppInfoModel().getPlugins()) {
                if (pluginModel != null && (permissionModelGenerateFromJSON2 = PermissionModel.generateFromJSON(pluginModel.getPermission())) != null && (nativeApiScopeConfig2 = permissionModelGenerateFromJSON2.getNativeApiScopeConfig()) != null) {
                    hashSet.addAll(nativeApiScopeConfig2.keySet());
                }
            }
        }
        if (dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
            for (PluginModel pluginModel2 : dynamicPluginInfo.getPluginModels()) {
                if (pluginModel2 != null && (permissionModelGenerateFromJSON = PermissionModel.generateFromJSON(pluginModel2.getPermission())) != null && (nativeApiScopeConfig = permissionModelGenerateFromJSON.getNativeApiScopeConfig()) != null) {
                    hashSet.addAll(nativeApiScopeConfig.keySet());
                }
            }
        }
        return hashSet;
    }
}
