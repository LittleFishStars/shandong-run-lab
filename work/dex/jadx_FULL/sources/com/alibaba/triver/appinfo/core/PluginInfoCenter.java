package com.alibaba.triver.appinfo.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.appinfo.storage.PluginInfoDao;
import com.alibaba.triver.appinfo.storage.d;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.network.SyncRequestClient;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.SPUtils;
import com.huawei.hms.push.AttributionReporter;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginInfoCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f24640a = 86400;
    private static final String b = "PluginInfoCenter";

    public static class PluginMtopSyncRequestClient extends SyncRequestClient<PluginMtopRequestParam, String, String> {

        public static class PluginMtopRequestParam extends RequestParams {
            private String loadType;
            private String params;
            private String scene;
            private Map<String, String> templateParam;

            public PluginMtopRequestParam(String str, Bundle bundle, String str2, Map<String, String> map, JSONObject jSONObject) {
                super(str, bundle);
                this.scene = "default";
                this.loadType = "default";
                this.params = str2;
                this.api = "mtop.taobao.miniapp.dynamic.plugin.get";
                this.needLogin = false;
                this.version = "1.0";
                this.templateParam = map;
                this.scene = jSONObject != null ? jSONObject.getString("scene") : "default";
                this.loadType = jSONObject != null ? jSONObject.getString("loadType") : "default";
            }

            @Override // com.alibaba.triver.kit.api.model.RequestParams
            public Map<String, Object> toMap() {
                HashMap map = new HashMap();
                map.put("params", this.params);
                map.putAll(this.templateParam);
                map.put("scene", this.scene);
                map.put("loadType", this.loadType);
                return map;
            }
        }

        @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String configSuccessResponse(byte[] bArr) {
            return (bArr == null || bArr.length <= 0) ? "" : new String(bArr);
        }

        @Override // com.alibaba.triver.kit.api.network.SyncRequestClient
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String configFailureResponse(byte[] bArr) {
            return (bArr == null || bArr.length <= 0) ? "" : new String(bArr);
        }
    }

    @WorkerThread
    public static PluginModel a(String str, String str2) {
        return a(str, str2, b());
    }

    private static long b() {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return 86400L;
            }
            String str = configsByGroup.get("maxPluginSyncSeconds");
            if (TextUtils.isEmpty(str)) {
                return 86400L;
            }
            return Long.parseLong(str);
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "getDefMaxSyncTime error", e);
            return 86400L;
        }
    }

    @WorkerThread
    public static PluginModel a(String str, String str2, long j) {
        PluginModel pluginModel;
        try {
            PluginInfoDao pluginInfoDaoA = d.a().a(str, str2);
            if (pluginInfoDaoA != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - pluginInfoDaoA.lastRequestTimeStamp;
                long jA = a(str);
                if (jA > -1) {
                    j = jA;
                }
                if (jCurrentTimeMillis < j * 1000 && (pluginModel = pluginInfoDaoA.pluginInfo) != null) {
                    return pluginModel;
                }
                d.a().b(str, str2);
            }
        } catch (Exception e) {
            RVLogger.e(b, "getPluginInfo error", e);
        }
        if (com.alibaba.triver.appinfo.a.a.g()) {
            return com.alibaba.triver.appinfo.a.a.a(str, str2);
        }
        return null;
    }

    @WorkerThread
    public static void a(PluginModel pluginModel) {
        if (pluginModel == null || TextUtils.isEmpty(pluginModel.getAppId()) || TextUtils.isEmpty(pluginModel.getVersion())) {
            return;
        }
        PluginInfoDao pluginInfoDao = new PluginInfoDao();
        pluginInfoDao.pluginInfo = pluginModel;
        pluginInfoDao.lastRequestTimeStamp = System.currentTimeMillis();
        pluginInfoDao.pluginId = pluginModel.getAppId();
        pluginInfoDao.lastUsedTimeStamp = System.currentTimeMillis();
        pluginInfoDao.version = pluginModel.getDeveloperVersion();
        d.a().a(pluginInfoDao);
    }

    @WorkerThread
    public static List<PluginModel> a(AppModel appModel, Bundle bundle, JSONArray jSONArray) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        if (appModel != null && jSONArray != null && !jSONArray.isEmpty()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(appModel.getAppId(), (Object) jSONArray);
                HashMap map = new HashMap();
                TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
                if (templateConfig != null) {
                    map.put("templateVersion", templateConfig.getTemplateVersion());
                    map.put(RVStartParams.KEY_TEMPLATE_ID, templateConfig.getTemplateId());
                    map.put("templateAppKey", templateConfig.getAppKey());
                }
                CommonResponse<String, String> commonResponseExecute = new PluginMtopSyncRequestClient().execute(new PluginMtopSyncRequestClient.PluginMtopRequestParam(appModel.getAppId(), bundle, jSONObject2.toString(), map, null));
                if (commonResponseExecute.success && (jSONObject = JSON.parseObject(commonResponseExecute.successData).getJSONObject("data")) != null && !jSONObject.isEmpty()) {
                    for (Object obj : jSONObject.getJSONArray("result")) {
                        if (obj instanceof JSONObject) {
                            JSONObject jSONObject3 = (JSONObject) obj;
                            PluginModel pluginModel = new PluginModel();
                            pluginModel.setAppId(jSONObject3.getString("appId"));
                            pluginModel.setAppKey(jSONObject3.getString("appKey"));
                            pluginModel.setDeveloperVersion(jSONObject3.getString("developerVersion"));
                            pluginModel.setVersion(jSONObject3.getString("deployVersion"));
                            pluginModel.setExtendInfo(jSONObject3.getJSONObject("extendInfo"));
                            pluginModel.setPackageSize(jSONObject3.getString("packageSize"));
                            pluginModel.setPackageUrl(jSONObject3.getString("packageUrl"));
                            pluginModel.setRequireVersion(jSONObject3.getString("requireVersion"));
                            pluginModel.setPermission(jSONObject3.getJSONObject(AttributionReporter.SYSTEM_PERMISSION));
                            arrayList.add(pluginModel);
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                RVLogger.e("PluginResourceManager", "requestPluginModel error : " + e.getMessage());
            }
        }
        return arrayList;
    }

    @WorkerThread
    public static PluginModel a(String str, String str2, String str3, App app, ApiContext apiContext, HashMap<String, String> map) {
        PluginModel pluginModel;
        AppModel appModel;
        if (str != null && str2 != null && str3 != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pluginId", (Object) str2);
                jSONObject.put("requireVersion", (Object) str3);
                jSONArray.add(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str, (Object) jSONArray);
                HashMap map2 = new HashMap();
                if (app != null && (appModel = (AppModel) app.getData(AppModel.class)) != null) {
                    TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
                    if (templateConfig != null) {
                        map2.put("templateVersion", templateConfig.getTemplateVersion());
                        map2.put(RVStartParams.KEY_TEMPLATE_ID, templateConfig.getTemplateId());
                        map2.put("templateAppKey", templateConfig.getAppKey());
                    }
                    JSONObject extendInfos = appModel.getExtendInfos();
                    if (extendInfos != null) {
                        String string = extendInfos.getString("openType");
                        if (!TextUtils.isEmpty(string)) {
                            map2.put("openType", string);
                        }
                    }
                }
                CommonResponse<String, String> commonResponseExecute = new PluginMtopSyncRequestClient().execute(new PluginMtopSyncRequestClient.PluginMtopRequestParam(str, app != null ? app.getStartParams() : null, jSONObject2.toString(), map2, null));
                if (!commonResponseExecute.success) {
                    if (map == null) {
                        return null;
                    }
                    map.put("errorCode", commonResponseExecute.errorCode);
                    map.put("errorMsg", commonResponseExecute.errorMsg);
                    return null;
                }
                JSONObject jSONObject3 = JSON.parseObject(commonResponseExecute.successData).getJSONObject("data");
                if (jSONObject3 != null && !jSONObject3.isEmpty()) {
                    for (Object obj : jSONObject3.getJSONArray("result")) {
                        if (obj instanceof JSONObject) {
                            JSONObject jSONObject4 = (JSONObject) obj;
                            if (str2.equals(jSONObject4.getString("appId"))) {
                                PluginModel pluginModel2 = new PluginModel();
                                try {
                                    pluginModel2.setAppId(jSONObject4.getString("appId"));
                                    pluginModel2.setAppKey(jSONObject4.getString("appKey"));
                                    pluginModel2.setDeveloperVersion(jSONObject4.getString("developerVersion"));
                                    pluginModel2.setVersion(jSONObject4.getString("deployVersion"));
                                    pluginModel2.setExtendInfo(jSONObject4.getJSONObject("extendInfo"));
                                    pluginModel2.setPackageSize(jSONObject4.getString("packageSize"));
                                    pluginModel2.setPackageUrl(jSONObject4.getString("packageUrl"));
                                    pluginModel2.setRequireVersion(jSONObject4.getString("requireVersion"));
                                    pluginModel2.setPermission(jSONObject4.getJSONObject(AttributionReporter.SYSTEM_PERMISSION));
                                    return pluginModel2;
                                } catch (Exception e) {
                                    e = e;
                                    pluginModel = pluginModel2;
                                    RVLogger.w(Log.getStackTraceString(e));
                                    RVLogger.e("PluginResourceManager", "requestPluginModel error : " + e.getMessage());
                                    if (map == null) {
                                        return pluginModel;
                                    }
                                    map.put("errorCode", "Exception");
                                    map.put("errorMsg", Log.getStackTraceString(e));
                                    return pluginModel;
                                }
                            }
                        }
                    }
                    return null;
                }
                if (map == null) {
                    return null;
                }
                map.put("errorCode", "data is null");
                map.put("errorMsg", "data is null");
                return null;
            } catch (Exception e2) {
                e = e2;
                pluginModel = null;
            }
        } else {
            RVLogger.d(b, str + c49.f40900a + str2 + c49.f40900a + str3);
            if (map == null) {
                return null;
            }
            map.put("errorCode", "updateParam is null");
            map.put("errorMsg", "updateParam is " + str + c49.f40900a + str2 + c49.f40900a + str3);
            return null;
        }
    }

    @WorkerThread
    public static List<PluginModel> a(AppModel appModel, Bundle bundle, JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        ArrayList arrayList = new ArrayList();
        if (appModel != null && jSONArray != null && !jSONArray.isEmpty()) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(appModel.getAppId(), (Object) jSONArray);
                HashMap map = new HashMap();
                TemplateConfigModel templateConfig = appModel.getAppInfoModel().getTemplateConfig();
                if (templateConfig != null) {
                    map.put("templateVersion", templateConfig.getTemplateVersion());
                    map.put(RVStartParams.KEY_TEMPLATE_ID, templateConfig.getTemplateId());
                    map.put("templateAppKey", templateConfig.getAppKey());
                }
                CommonResponse<String, String> commonResponseExecute = new PluginMtopSyncRequestClient().execute(new PluginMtopSyncRequestClient.PluginMtopRequestParam(appModel.getAppId(), bundle, jSONObject3.toString(), map, jSONObject));
                if (commonResponseExecute.success && (jSONObject2 = JSON.parseObject(commonResponseExecute.successData).getJSONObject("data")) != null && !jSONObject2.isEmpty()) {
                    for (Object obj : jSONObject2.getJSONArray("result")) {
                        if (obj instanceof JSONObject) {
                            JSONObject jSONObject4 = (JSONObject) obj;
                            PluginModel pluginModel = new PluginModel();
                            pluginModel.setAppId(jSONObject4.getString("appId"));
                            pluginModel.setAppKey(jSONObject4.getString("appKey"));
                            pluginModel.setDeveloperVersion(jSONObject4.getString("developerVersion"));
                            pluginModel.setVersion(jSONObject4.getString("deployVersion"));
                            pluginModel.setExtendInfo(jSONObject4.getJSONObject("extendInfo"));
                            pluginModel.setPackageSize(jSONObject4.getString("packageSize"));
                            pluginModel.setPackageUrl(jSONObject4.getString("packageUrl"));
                            pluginModel.setRequireVersion(jSONObject4.getString("requireVersion"));
                            pluginModel.setPermission(jSONObject4.getJSONObject(AttributionReporter.SYSTEM_PERMISSION));
                            arrayList.add(pluginModel);
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                RVLogger.e("PluginResourceManager", "requestPluginModel error : " + e.getMessage());
            }
        }
        return arrayList;
    }

    @WorkerThread
    public static void a() {
        d.a().b();
    }

    @WorkerThread
    public static void a(long j) {
        long j2 = SPUtils.readLong("lastClearPluginTimeStamp", -1L);
        if (j2 == -1) {
            SPUtils.writeLong("lastClearPluginTimeStamp", System.currentTimeMillis());
            return;
        }
        long j3 = j * 1000;
        if (j2 < System.currentTimeMillis() - j3) {
            d.a().a(j3, (List<String>) null);
            SPUtils.writeLong("lastClearPluginTimeStamp", System.currentTimeMillis());
            RVLogger.d(b, "clearUnusedCache finish!");
        }
    }

    private static long a(String str) {
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            if (configsByGroup == null) {
                return -1L;
            }
            String str2 = configsByGroup.get("plugin_mst_" + str);
            if (TextUtils.isEmpty(str2)) {
                return -1L;
            }
            return Long.parseLong(str2);
        } catch (Exception e) {
            RVLogger.e(TriverLogProxyImpl.TLOG_MODULE, "getDefMaxSyncTime error", e);
            return -1L;
        }
    }
}
