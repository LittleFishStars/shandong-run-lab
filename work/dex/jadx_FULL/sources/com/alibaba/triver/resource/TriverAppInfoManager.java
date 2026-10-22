package com.alibaba.triver.resource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.triver.utils.CommonUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverAppInfoManager implements RVAppInfoManager {
    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    @Nullable
    public String findUrlMappedAppId(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public AppInfoModel getAppInfoModel(@NonNull AppInfoQuery appInfoQuery) throws Throwable {
        AppModel appModel = getAppModel(appInfoQuery);
        if (appModel != null) {
            return appModel.getAppInfoModel();
        }
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public AppModel getAppModel(@NonNull AppInfoQuery appInfoQuery) throws Throwable {
        AppModel appModel;
        if ("68687029".equals(appInfoQuery.getAppId())) {
            String asset = IOUtils.readAsset(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), appInfoQuery.getAppId() + ".appinfo.json");
            if (asset == null) {
                return null;
            }
            return (AppModel) JSONUtils.parseObject(asset.getBytes(), AppModel.class);
        }
        AppInfoScene scene = appInfoQuery.getScene() != null ? appInfoQuery.getScene() : AppInfoScene.ONLINE;
        try {
            if (appInfoQuery.isDisableCache()) {
                return null;
            }
            if (scene != AppInfoScene.ONLINE && scene != AppInfoScene.TRIAL) {
                return null;
            }
            AppModel appModelA = com.alibaba.triver.appinfo.core.b.a(scene.name(), appInfoQuery.getAppId(), appInfoQuery.getVersion());
            if (appModelA != null) {
                CommonUtils.changeAppInfoVHost(appModelA.getAppInfoModel());
            } else {
                Map<String, AppModel> presetAppInfos = ((RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class)).getPresetAppInfos();
                if (presetAppInfos != null && (appModel = presetAppInfos.get(appInfoQuery.getAppId())) != null && ("*".equals(appInfoQuery.getVersion()) || appInfoQuery.getVersion().equals(appModel.getAppVersion()))) {
                    return appModel;
                }
            }
            return appModelA;
        } catch (Exception e) {
            RVLogger.e("Triver:AppInfoCenter", "getAppModel error", e);
            return null;
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public long getLastUpdateTime(String str) {
        return 0L;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public void refreshUpdateTime(String str, long j) {
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public void saveAppModelList(@NonNull List<AppModel> list) {
    }
}
