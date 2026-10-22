package com.alibaba.triver.appinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AcceleratorConfig;
import com.alibaba.triver.appinfo.storage.AppInfoDao;
import com.alibaba.triver.appinfo.storage.b;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverAppInfoManager implements RVAppInfoManager {
    private void a(AppInfoDao appInfoDao, AppModel appModel) {
        AppInfoDao appInfoDao2 = new AppInfoDao();
        appInfoDao2.appId = appModel.getAppId();
        appInfoDao2.appInfo = appModel;
        long jCurrentTimeMillis = System.currentTimeMillis();
        appInfoDao2.lastRequestTimeStamp = jCurrentTimeMillis;
        appInfoDao2.lastUsedTimeStamp = jCurrentTimeMillis;
        appInfoDao2.version = appModel.getAppVersion();
        if (com.alibaba.triver.appinfo.a.a.a() && appModel.getAppInfoModel() != null) {
            appInfoDao2.version = appModel.getAppInfoModel().getDeveloperVersion();
        }
        b.a().a(appInfoDao2);
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    @Nullable
    public String findUrlMappedAppId(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public AppInfoModel getAppInfoModel(@NonNull AppInfoQuery appInfoQuery) {
        AppModel appModel = getAppModel(appInfoQuery);
        if (appModel != null) {
            return appModel.getAppInfoModel();
        }
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public AppModel getAppModel(@NonNull AppInfoQuery appInfoQuery) {
        AppModel appModel;
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
                com.alibaba.triver.appinfo.a.a.a(appModelA.getAppInfoModel());
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
        AcceleratorConfig.ConfigItem importantConfig;
        AppModel appModelA;
        AcceleratorConfig acceleratorConfigC = b.a().c();
        AppInfoDao appInfoDao = new AppInfoDao();
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (AppModel appModel : list) {
            a(appInfoDao, appModel);
            if (!com.alibaba.triver.appinfo.a.a.d() && (appModelA = a(appModel, hashSet)) != null) {
                a(appInfoDao, appModelA);
            }
            if (acceleratorConfigC != null && (importantConfig = acceleratorConfigC.getImportantConfig(appModel.getAppId())) != null) {
                importantConfig.expired = false;
                z = true;
            }
        }
        if (z) {
            b.a().a(acceleratorConfigC);
        }
    }

    private AppModel a(AppModel appModel, Set<String> set) {
        AppInfoModel appInfoModel = appModel.getAppInfoModel();
        if (appInfoModel == null) {
            return null;
        }
        TemplateConfigModel templateConfig = appInfoModel.getTemplateConfig();
        if (!templateConfig.isTemplateValid()) {
            return null;
        }
        String templateId = templateConfig.getTemplateId();
        if (set.contains(templateId)) {
            return null;
        }
        AppModel appModel2 = (AppModel) JSON.parseObject(JSON.toJSONString(appModel), AppModel.class);
        AppInfoModel appInfoModel2 = appModel2.getAppInfoModel();
        appInfoModel2.setLogo("");
        appInfoModel2.setName("");
        appInfoModel2.setDesc("");
        appInfoModel2.setAppId(templateId);
        appInfoModel2.setAppKey(templateConfig.getAppKey());
        if (appInfoModel2.getVhost().contains(appModel.getAppId())) {
            appInfoModel2.setVhost(appInfoModel2.getVhost().replace(appModel.getAppId(), templateId));
        }
        appInfoModel2.setDeveloperVersion(templateConfig.getTemplateVersion());
        appInfoModel2.getTemplateConfig().setExtModel(new TemplateExtModel());
        appModel2.setAppInfoModel(appInfoModel2);
        JSONObject extendInfos = appModel.getExtendInfos();
        if (extendInfos.containsKey("footPrintEnable")) {
            extendInfos.put("footPrintEnable", (Object) Boolean.FALSE);
        }
        if (extendInfos.containsKey("favorEnable")) {
            extendInfos.put("favorEnable", (Object) Boolean.FALSE);
        }
        extendInfos.remove("sellerInfo");
        appModel2.setExtendInfos(extendInfos);
        set.add(templateId);
        return appModel2;
    }
}
