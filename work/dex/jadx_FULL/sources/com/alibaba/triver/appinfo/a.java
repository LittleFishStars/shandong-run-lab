package com.alibaba.triver.appinfo;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginParam;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.appinfo.channel.TriverAppModel;
import com.alibaba.triver.appinfo.core.AppInfoStrategy;
import com.alibaba.triver.appinfo.core.AppRequestParams;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.appinfo.core.b;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.trace.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IAppUpdater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24627a = "AppInfoCenter";

    public static List<String> a() {
        if (TROrangeController.closeAppInfoParamsOptimization()) {
            return null;
        }
        List<String> listAsList = Arrays.asList(AppInfoScene.PARAM_SCENE, AppInfoScene.PARAM_SOURCE, AppInfoScene.PARAM_SCENE_VERSION, "query");
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
        if (configsByGroup != null) {
            String str = configsByGroup.get("requestParamsList");
            if (!TextUtils.isEmpty(str)) {
                try {
                    List<String> list = (List) JSON.parseObject(str, new TypeReference<List<String>>() { // from class: com.alibaba.triver.appinfo.a.2
                    }, new Feature[0]);
                    if (list != null) {
                        list.addAll(listAsList);
                        return list;
                    }
                } catch (Exception e) {
                    RVLogger.e("AppInfoCenter", "getRequestParamsList parse error", e);
                }
            }
        }
        return listAsList;
    }

    public static List<String> b() {
        List<String> listAsList = Arrays.asList("ANDROID_SYS_NO_NETWORK", "ANDROID_SYS_NETWORK_ERROR", "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "ANDROID_SYS_JSONDATA_PARSE_ERROR", "101");
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
        if (configsByGroup != null) {
            String str = configsByGroup.get("offlineErrorCodeList");
            if (!TextUtils.isEmpty(str)) {
                try {
                    List<String> list = (List) JSON.parseObject(str, new TypeReference<List<String>>() { // from class: com.alibaba.triver.appinfo.a.3
                    }, new Feature[0]);
                    if (list != null) {
                        list.addAll(listAsList);
                        return list;
                    }
                } catch (Exception e) {
                    RVLogger.e("AppInfoCenter", "getOfflineErrorCode parse error", e);
                }
            }
        }
        return listAsList;
    }

    @Override // com.alibaba.ariver.resource.api.appinfo.IAppUpdater
    public void updateApp(final UpdateAppParam updateAppParam, @Nullable final UpdateAppCallback updateAppCallback) {
        final String str;
        final String str2;
        String queryParameter;
        if (updateAppParam == null) {
            if (updateAppCallback != null) {
                updateAppCallback.onError(null);
                return;
            }
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final AppRequestParams appRequestParams = new AppRequestParams();
        if (updateAppParam.getRequestMainPackage() != null) {
            Pair<String, String> pair = new Pair<>(updateAppParam.getRequestMainPackage().first, updateAppParam.getRequestMainPackage().second);
            appRequestParams.mainRequest = pair;
            String str3 = (String) pair.first;
            str2 = (String) pair.second;
            str = str3;
        } else {
            str = null;
            str2 = null;
        }
        appRequestParams.extRequest = updateAppParam.getRequestApps();
        if (!TextUtils.equals(RVConstants.TINY_WEB_COMMON_APPID, str) && updateAppParam.getExtras() != null) {
            String string = updateAppParam.getExtras().getString(TRiverConstants.KEY_ORI_URL);
            appRequestParams.oriUrl = string;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", (Object) string);
            List<String> listA = a();
            if (TextUtils.isEmpty(string)) {
                for (String str4 : updateAppParam.getExtras().keySet()) {
                    Object obj = updateAppParam.getExtras().get(str4);
                    if (obj != null && (listA == null || listA.contains(str4))) {
                        jSONObject.put(str4, (Object) obj.toString());
                    }
                }
            } else {
                Uri uri = Uri.parse(string);
                for (String str5 : uri.getQueryParameterNames()) {
                    if (!TextUtils.isEmpty(str5) && (queryParameter = uri.getQueryParameter(str5)) != null && (listA == null || listA.contains(str5))) {
                        jSONObject.put(str5, (Object) queryParameter);
                    }
                }
            }
            appRequestParams.params = jSONObject;
            appRequestParams.startParams = updateAppParam.getExtras();
        }
        if (updateAppParam.getQueryScene() != null) {
            appRequestParams.mainRequestType = updateAppParam.getQueryScene().name();
        }
        if (updateAppParam.getQueryScene() != null && updateAppParam.getQueryScene() != AppInfoScene.ONLINE) {
            appRequestParams.notOnline = true;
            appRequestParams.needCache = updateAppParam.getQueryScene() == AppInfoScene.TRIAL;
        }
        final String str6 = "get appInfo from net. request appId:" + str + " version:" + str2;
        b.a(appRequestParams, new com.alibaba.triver.appinfo.core.a() { // from class: com.alibaba.triver.appinfo.a.1
            @Override // com.alibaba.triver.appinfo.core.a
            public void a(String str7, List<AppModel> list) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.J, str6, "AppInfo", str, null, null);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                try {
                    if (appRequestParams.needCache) {
                        ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).saveAppModelList(list);
                    }
                } catch (Exception e) {
                    RVLogger.e("AppInfoCenter", "saveAppModelList error", e);
                }
                if (updateAppCallback != null) {
                    for (AppModel appModel : list) {
                        if (appModel != null) {
                            com.alibaba.triver.appinfo.a.a.a(appModel.getAppInfoModel());
                            ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).refreshUpdateTime(appModel.getAppId(), System.currentTimeMillis());
                        }
                    }
                    updateAppCallback.onSuccess(list);
                }
                com.alibaba.triver.appinfo.a.b.a(str, str2, str7, jCurrentTimeMillis, jCurrentTimeMillis2, updateAppParam.getExtras());
            }

            @Override // com.alibaba.triver.appinfo.core.a
            public void a(String str7, String str8, String str9, JSONObject jSONObject2) {
                HashMap map;
                List<TriverAppModel> list;
                AppModel appModel;
                String str10 = str8;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                HashMap map2 = new HashMap();
                map2.put("errorCode", str10);
                map2.put("errorMsg", str9);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog(c.K, str6, "AppInfo", str, null, map2);
                com.alibaba.triver.appinfo.a.b.a(str, str2, str7, jCurrentTimeMillis, jCurrentTimeMillis2, str8, str9, updateAppParam.getExtras());
                if (updateAppCallback != null) {
                    if (!com.alibaba.triver.appinfo.a.a.c() && a.b().contains(str10) && !TextUtils.isEmpty(str) && (appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(new AppInfoQuery(str))) != null) {
                        updateAppCallback.onSuccess(Collections.singletonList(appModel));
                        return;
                    }
                    if (!com.alibaba.triver.appinfo.a.a.d() && com.alibaba.triver.appinfo.a.a.b(str8) && !TextUtils.isEmpty(str)) {
                        com.alibaba.triver.appinfo.channel.c cVar = new com.alibaba.triver.appinfo.channel.c();
                        String str11 = appRequestParams.oriUrl;
                        String queryParameter2 = !TextUtils.isEmpty(str11) ? Uri.parse(str11).getQueryParameter("templateId") : "";
                        CommonResponse<List<TriverAppModel>, JSONObject> commonResponseA = cVar.a(appRequestParams);
                        if (commonResponseA != null && commonResponseA.success && (list = commonResponseA.successData) != null && !list.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<TriverAppModel> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            updateAppCallback.onSuccess(arrayList);
                            com.alibaba.triver.appinfo.a.b.a(Boolean.TRUE, str, str11, queryParameter2, (String) null, (String) null);
                            return;
                        }
                        if (commonResponseA != null) {
                            com.alibaba.triver.appinfo.a.b.a(Boolean.FALSE, str, str11, queryParameter2, TextUtils.isEmpty(commonResponseA.errorCode) ? "UNKNOWN_ERROR" : commonResponseA.errorCode, TextUtils.isEmpty(commonResponseA.errorMsg) ? "unknown error" : commonResponseA.errorMsg);
                        } else {
                            com.alibaba.triver.appinfo.a.b.a(Boolean.FALSE, str, str11, queryParameter2, "UNKNOWN_ERROR", "unknown error");
                        }
                    }
                    if (jSONObject2 != null) {
                        map = new HashMap();
                        for (String str12 : jSONObject2.keySet()) {
                            String string2 = jSONObject2.getString(str12);
                            if (!TextUtils.isEmpty(string2)) {
                                map.put(str12, string2);
                            }
                        }
                    } else {
                        map = null;
                    }
                    if (TextUtils.isEmpty(str8)) {
                        str10 = "ERR_UNKNOWN_ERROR";
                    }
                    updateAppCallback.onError(new UpdateAppException(str10, str9, map));
                }
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.appinfo.IAppUpdater
    public void updatePlugin(UpdatePluginParam updatePluginParam, @Nullable UpdatePluginCallback updatePluginCallback) {
        String str;
        String str2;
        if (updatePluginParam == null || updatePluginParam.getHostAppId() == null || TextUtils.isEmpty(updatePluginParam.getPluginId())) {
            if (updatePluginCallback != null) {
                updatePluginCallback.onError(new UpdateAppException("ERR_PARAMS_EMPTY", "缺少必要的参数"));
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String hostAppId = updatePluginParam.getHostAppId();
        String pluginId = updatePluginParam.getPluginId();
        String requiredVersion = updatePluginParam.getRequiredVersion();
        App app = updatePluginParam.getApp();
        HashMap map = new HashMap();
        PluginModel pluginModelA = PluginInfoCenter.a(hostAppId, pluginId, requiredVersion, app, updatePluginParam.getApiContext(), map);
        if (pluginModelA != null) {
            try {
                ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).savePluginModelList(Collections.singletonList(pluginModelA));
            } catch (Exception e) {
                RVLogger.e("AppInfoCenter", "savePluginModelList error", e);
            }
            if (updatePluginCallback != null) {
                updatePluginCallback.onSuccess(pluginModelA);
            }
        } else if (updatePluginCallback != null) {
            if (map.isEmpty()) {
                str = "";
                str2 = "";
            } else {
                str = (String) map.get("errorCode");
                str2 = (String) map.get("errorMsg");
            }
            if (TextUtils.isEmpty(str)) {
                str = "ERR_UNKNOWN_ERROR";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "ERR_UNKNOWN_ERROR";
            }
            UpdateAppException updateAppException = new UpdateAppException(str, str2);
            if (com.alibaba.triver.appinfo.a.a.f() || !com.alibaba.triver.appinfo.a.a.d(str)) {
                RVLogger.d("AppInfoCenter", "errorCode not match");
                com.alibaba.triver.appinfo.a.b.a(false, pluginId, requiredVersion, hostAppId, "INVALID_ERROR_CODE", "error code isn't in white list");
                updatePluginCallback.onError(updateAppException);
            } else {
                PluginModel pluginModelA2 = a(pluginId, requiredVersion, hostAppId);
                if (pluginModelA2 != null) {
                    updatePluginCallback.onSuccess(pluginModelA2);
                } else {
                    updatePluginCallback.onError(updateAppException);
                }
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        RVLogger.d("AppInfoCenter", "pluginModel request coast:" + jCurrentTimeMillis2);
        com.alibaba.triver.appinfo.a.b.a(pluginId, requiredVersion, app, map, pluginModelA, jCurrentTimeMillis2, AppInfoStrategy.SYNC_LOAD);
    }

    private static PluginModel a(String str, String str2, String str3) {
        String str4;
        PluginModel pluginModelA = PluginInfoCenter.a(str, str2);
        if (pluginModelA == null) {
            pluginModelA = com.alibaba.triver.appinfo.a.a.a(str, str2);
            str4 = "orange";
        } else {
            str4 = "cache";
        }
        if (pluginModelA != null) {
            RVLogger.d("AppInfoCenter", "request pluginModel from " + str4);
            com.alibaba.triver.appinfo.a.b.a(true, str, str2, str3, (String) null, (String) null);
        } else {
            RVLogger.d("AppInfoCenter", "request pluginModel from local failed");
            com.alibaba.triver.appinfo.a.b.a(false, str, str2, str3, "BACKUP_FAILED", "can't match local backup");
        }
        return pluginModelA;
    }
}
