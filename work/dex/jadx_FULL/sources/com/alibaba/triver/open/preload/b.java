package com.alibaba.triver.open.preload;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppInfoCenterInternal;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements IPreloadJob<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25077a = "AriverTriver:PluginPreload";

    private long a() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        long j = -1;
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            try {
                String str = configsByGroup.get(com.alibaba.triver.appinfo.core.c.c);
                if (!TextUtils.isEmpty(str)) {
                    j = Long.parseLong(str);
                }
            } catch (Exception e) {
                RVLogger.e("AriverTriver:AppInfoCenter", "updateLoadSeconds error", e);
            }
        }
        return j <= 0 ? AppInfoCenterInternal.c : j;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "dynamic-plugin-preload";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Object> getResultClazz() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Object preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        App app;
        DynamicPluginInfo dynamicPluginInfo;
        try {
            if (PreloadScheduler.PointType.CLOSE_APP.equals(pointType) && (app = (App) map.get(NativeCallContext.DOMAIN_APP)) != null && (dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class)) != null) {
                List<PluginModel> pluginModels = dynamicPluginInfo.getPluginModels();
                JSONArray jSONArray = new JSONArray();
                if (pluginModels != null) {
                    for (PluginModel pluginModel : pluginModels) {
                        if (PluginInfoCenter.a(pluginModel.getAppId(), pluginModel.getDeveloperVersion(), a()) == null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pluginId", (Object) pluginModel.getAppId());
                            jSONObject.put("requireVersion", (Object) pluginModel.getDeveloperVersion());
                            jSONArray.add(jSONObject);
                        }
                    }
                }
                new com.alibaba.triver.preload.b.c.a().a((AppModel) app.getData(AppModel.class), app.getStartParams(), jSONArray, (JSONObject) null);
            }
        } catch (Throwable th) {
            RVLogger.w(th.getLocalizedMessage());
        }
        return null;
    }
}
