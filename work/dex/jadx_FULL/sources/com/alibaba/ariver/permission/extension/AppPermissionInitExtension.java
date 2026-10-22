package com.alibaba.ariver.permission.extension;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppPermissionInitExtension implements AppDestroyPoint, PackageParsedPoint, PluginPackageParsedPoint {
    private static final String TAG = "AriverPermission:AppPermissionInitExtension";
    private AuthenticationProxy rvPermissionServiceProxy;

    private Resource getPermissionResources(ResourcePackage resourcePackage) {
        return resourcePackage.get(ResourceQuery.asUrl(RVConstants.FILE_API_PERMISSION).setNeedAutoCompleteHost());
    }

    private boolean loadFromAppConfig(@Nullable AppModel appModel) {
        PermissionModel permissionModel;
        if (appModel == null || (permissionModel = appModel.getPermissionModel()) == null) {
            return false;
        }
        RVLogger.d(TAG, "onResourceParsed, loadFromAppConfig");
        this.rvPermissionServiceProxy.setPermissionModel(appModel.getAppInfoModel().getAppId(), permissionModel);
        return true;
    }

    private boolean loadFromPkgFile(@Nullable AppModel appModel, ResourcePackage resourcePackage) {
        Resource permissionResources;
        if (appModel != null && (permissionResources = getPermissionResources(resourcePackage)) != null && permissionResources.getBytes() != null) {
            RVLogger.d(TAG, "onResourceParsed, loadFromPkgFile");
            if (permissionResources.getBytes() != null) {
                PermissionModel permissionJson = AppPermissionUtils.parsePermissionJson(permissionResources.getBytes());
                RVLogger.debug(TAG, "onResourceParsed: " + permissionJson);
                if (permissionJson != null) {
                    this.rvPermissionServiceProxy.setPermissionModel(appModel.getAppInfoModel().getAppId(), permissionJson);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        this.rvPermissionServiceProxy.clearPermissionModel(app.getAppId(), true);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.rvPermissionServiceProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
    }

    @Override // com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint
    public void onPluginParsed(AppModel appModel, PluginModel pluginModel, ResourcePackage resourcePackage) {
        PermissionModel permissionModelGenerateFromJSON;
        if (appModel == null || TextUtils.isEmpty(appModel.getAppInfoModel().getAppId())) {
            RVLogger.d(TAG, "onPluginParsed appId is null, return");
            return;
        }
        RVLogger.d(TAG, "onPluginParsed getPermission with pluginModel: " + pluginModel + ", permissionModel: " + pluginModel.getPermission());
        if (pluginModel.getPermission() != null) {
            permissionModelGenerateFromJSON = PermissionModel.generateFromJSON(pluginModel.getPermission());
            RVLogger.d(TAG, "onPluginParsed getPermission from appModel");
        } else {
            Resource permissionResources = getPermissionResources(resourcePackage);
            PermissionModel permissionModelGenerateFromJSON2 = permissionResources != null ? PermissionModel.generateFromJSON(permissionResources.getBytes()) : null;
            StringBuilder sb = new StringBuilder();
            sb.append("onPluginParsed getPermission from package (");
            sb.append(permissionResources != null);
            sb.append(")");
            RVLogger.d(TAG, sb.toString());
            permissionModelGenerateFromJSON = permissionModelGenerateFromJSON2;
        }
        if (permissionModelGenerateFromJSON != null) {
            this.rvPermissionServiceProxy.setPluginPermissionModel(appModel.getAppId(), pluginModel, permissionModelGenerateFromJSON);
        }
    }

    @Override // com.alibaba.ariver.resource.api.extension.PackageParsedPoint
    public void onResourceParsed(AppModel appModel, ResourcePackage resourcePackage) {
        if (appModel == null || TextUtils.isEmpty(appModel.getAppInfoModel().getAppId())) {
            RVLogger.d(TAG, "onResourceParsed appId is null, return");
            return;
        }
        RVLogger.d(TAG, "onResourceParsed " + appModel.getAppInfoModel().getAppId());
        if (loadFromAppConfig(appModel) || loadFromPkgFile(appModel, resourcePackage)) {
            return;
        }
        this.rvPermissionServiceProxy.clearPermissionModel(appModel.getAppInfoModel().getAppId(), false);
    }
}
