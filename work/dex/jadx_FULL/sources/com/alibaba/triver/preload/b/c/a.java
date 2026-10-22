package com.alibaba.triver.preload.b.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.core.AppInfoCenterInternal;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.appinfo.storage.AppInfoDao;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.SPUtils;
import com.alibaba.triver.point.GetTopAppPoint;
import com.alibaba.triver.preload.IDynamicPluginParam;
import com.alibaba.triver.utils.CommonUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IPreloadJob<Object> {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppModel appModel) {
    }

    private static Boolean b() {
        long j = SPUtils.readLong("lastResourcePreloadTimeStamp", -1L);
        long appInfoPreloadCheckTime = CommonUtils.getAppInfoPreloadCheckTime();
        if (j != -1 && j >= System.currentTimeMillis() - (appInfoPreloadCheckTime * 1000)) {
            return Boolean.FALSE;
        }
        SPUtils.writeLong("lastResourcePreloadTimeStamp", System.currentTimeMillis());
        return Boolean.TRUE;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "app-resource-preload";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Object> getResultClazz() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @ThreadType(ExecutorType.NORMAL)
    public Object preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        try {
            if (CommonUtils.closeAppInfoPreload()) {
                return null;
            }
            if (PreloadScheduler.PointType.PRELOAD_RESOURCE.equals(pointType)) {
                if (map != null && b().booleanValue()) {
                    a(map);
                }
            } else if (PreloadScheduler.PointType.CLOSE_APP.equals(pointType) && map.get("appIds") != null && b().booleanValue()) {
                String string = map.get("appIds").toString();
                if (!TextUtils.isEmpty(string)) {
                    a(JSON.parseObject(string));
                }
            }
        } catch (Throwable th) {
            RVLogger.e(TRiverConstants.TAG, "preload resource: ", th);
        }
        return null;
    }

    private void a(final Map<String, Object> map) {
        Set<String> topApp = ((GetTopAppPoint) ExtensionPoint.as(GetTopAppPoint.class).create()).getTopApp();
        if (topApp == null || topApp.isEmpty()) {
            topApp = new HashSet<>();
        }
        Iterator<String> it = topApp.iterator();
        while (it.hasNext()) {
            map.put(it.next(), new JSONArray());
        }
        if (map.size() > 0) {
            final AppRequestParams appRequestParams = new AppRequestParams();
            appRequestParams.extRequest = new HashMap();
            final long jA = a();
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.triver.preload.b.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a((Map<String, Object>) map, jA, appRequestParams, CommonUtils.getDelayTimeSec());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Map<String, Object> map, final long j, final AppRequestParams appRequestParams, final int i) {
        if (map.keySet().size() > 0) {
            final String next = map.keySet().iterator().next();
            AppInfoDao appInfoDaoA = com.alibaba.triver.appinfo.storage.b.a().a(next, "*");
            if (appInfoDaoA != null && appInfoDaoA.lastRequestTimeStamp > j) {
                a(appInfoDaoA.appInfo);
                com.alibaba.triver.appinfo.a.b.a(true, next, (String) null, (String) null, "local");
                map.remove(next);
                a(map, j, appRequestParams, i);
                a(appInfoDaoA.appInfo, appRequestParams.startParams, (JSONArray) map.get(next));
                return;
            }
            a(i);
            Pair<String, String> pair = new Pair<>(next, "*");
            appRequestParams.mainRequest = pair;
            UpdateAppParam updateAppParam = new UpdateAppParam((String) pair.first, (String) pair.second);
            updateAppParam.setForce(true);
            updateAppParam.setUpdateMode(UpdateMode.ASYNC);
            updateAppParam.setRequestApps(appRequestParams.extRequest);
            Bundle bundle = new Bundle();
            bundle.putBoolean("mtopDefault", true);
            updateAppParam.setExtras(bundle);
            IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater((String) appRequestParams.mainRequest.first, new Bundle());
            if (iAppUpdaterCreateUpdater != null) {
                iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.triver.preload.b.c.a.2
                    @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                    public void onError(UpdateAppException updateAppException) {
                        com.alibaba.triver.appinfo.a.b.a(false, next, updateAppException.getCode(), updateAppException.getMessage(), "network");
                        map.remove(next);
                        a.this.a((Map<String, Object>) map, j, appRequestParams, i);
                    }

                    @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                    public void onSuccess(List<AppModel> list) {
                        com.alibaba.triver.appinfo.a.b.a(true, next, (String) null, (String) null, "network");
                        if (list != null) {
                            for (AppModel appModel : list) {
                                try {
                                    a.this.a(appModel);
                                } catch (Exception e) {
                                    RVLogger.e(TRiverConstants.TAG, "checkPackage: ", e);
                                }
                                try {
                                    a.this.a(appModel, appRequestParams.startParams, (JSONArray) map.get(next));
                                } catch (Exception e2) {
                                    RVLogger.w(Log.getStackTraceString(e2));
                                }
                            }
                        }
                        map.remove(next);
                        a.this.a((Map<String, Object>) map, j, appRequestParams, i);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppModel appModel, Bundle bundle, JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        if (appModel.getAppInfoModel().getPlugins() != null) {
            Iterator<PluginModel> it = appModel.getAppInfoModel().getPlugins().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getAppId());
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (!hashSet.contains(jSONObject.getString("pluginId")) && PluginInfoCenter.a(jSONObject.getString("pluginId"), jSONObject.getString("requireVersion")) == null) {
                jSONArray2.add(jSONObject);
            }
        }
        a(appModel, bundle, jSONArray2, ((IDynamicPluginParam) RVProxy.get(IDynamicPluginParam.class)).addParam());
    }

    public void a(AppModel appModel, Bundle bundle, JSONArray jSONArray, JSONObject jSONObject) {
        List<PluginModel> listA = PluginInfoCenter.a(appModel, bundle, jSONArray, jSONObject);
        if (listA != null) {
            Iterator<PluginModel> it = listA.iterator();
            while (it.hasNext()) {
                PluginInfoCenter.a(it.next());
            }
            RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
            if (rVPluginResourceManager.isAvailable(listA)) {
                return;
            }
            rVPluginResourceManager.downloadPlugins(listA, new PluginDownloadCallback() { // from class: com.alibaba.triver.preload.b.c.a.3
                @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                public void onFailed(int i, String str) {
                }

                @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                public void onSingleFailed(PluginModel pluginModel, int i, String str) {
                }

                @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                public void onSuccess() {
                }
            });
        }
    }

    private long a() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        long j = -1;
        if (configsByGroup != null && !configsByGroup.isEmpty()) {
            try {
                String str = configsByGroup.get(com.alibaba.triver.appinfo.core.c.d);
                if (!TextUtils.isEmpty(str)) {
                    j = Long.parseLong(str);
                }
            } catch (Exception e) {
                RVLogger.e("AriverTriver:AppInfoCenter", "updateLoadSeconds error", e);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j <= 0) {
            j = AppInfoCenterInternal.f24637a;
        }
        return jCurrentTimeMillis - (j * 1000);
    }

    private void a(int i) {
        try {
            Thread.sleep((long) (new Random().nextDouble() * ((double) i) * 1000.0d));
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "delay error", e);
        }
    }
}
