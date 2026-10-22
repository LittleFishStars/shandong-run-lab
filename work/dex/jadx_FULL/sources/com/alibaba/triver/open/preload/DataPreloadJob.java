package com.alibaba.triver.open.preload;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.point.DataPreloadPoint;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DataPreloadJob implements IPreloadJob<DataPreloadResultModel>, Serializable {

    public static class DataPreloadResultModel implements Serializable {
        List<JSONObject> orgData;
    }

    private DataPreloadResultModel configProcessFilter(AppModel appModel, PluginModel pluginModel, String str, Bundle bundle, JSONArray jSONArray, PreloadScheduler.PointType pointType) {
        DataPreloadResultModel dataPreloadResultModel = new DataPreloadResultModel();
        boolean z = appModel.getPermissionModel() != null;
        ArrayList arrayList = new ArrayList();
        for (Object obj : jSONArray) {
            if (obj != null) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    String preloadType = getPreloadType(jSONObject);
                    if (pointConditionFilter(jSONObject, pointType)) {
                        if ("http".equals(preloadType)) {
                            if (z) {
                                if (!hasHttpPermission((pluginModel == null || pluginModel.getPermission() == null) ? appModel.getPermissionModel().getValidDomains() : pluginModel.getPermission().getJSONArray(com.alibaba.ariver.permission.b.g), jSONObject)) {
                                }
                            }
                            jSONObject.put("appModel", (Object) appModel);
                            jSONObject.put("pluginId", (Object) str);
                            jSONObject.put(RVConstants.EXTRA_START_PARAMS, (Object) bundle);
                            arrayList.add(jSONObject);
                        } else if ("mtop".equals(preloadType)) {
                            jSONObject.put("appModel", (Object) appModel);
                            jSONObject.put("pluginId", (Object) str);
                            jSONObject.put(RVConstants.EXTRA_START_PARAMS, (Object) bundle);
                            arrayList.add(jSONObject);
                        }
                    }
                } catch (Exception e) {
                    RVLogger.e("DataPreloadJob", "preload config merge error", e);
                }
            }
        }
        dataPreloadResultModel.orgData = arrayList;
        return dataPreloadResultModel;
    }

    private JSONArray getAvailableConfig(String str) {
        JSONArray array;
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_DATA_PREFETCH_CONFIG);
        if (configsByGroup == null) {
            return null;
        }
        String str2 = configsByGroup.get(str);
        if (TextUtils.isEmpty(str2) || (array = JSON.parseArray(str2)) == null) {
            return null;
        }
        return array;
    }

    private String getPreloadType(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.getString("type") == null) {
            return null;
        }
        return jSONObject.getString("type");
    }

    private boolean hasHttpPermission(Collection collection, @NonNull JSONObject jSONObject) {
        if (collection != null && !collection.isEmpty()) {
            String host = Uri.parse(jSONObject.getJSONObject("params").getString("url")).getHost();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (Pattern.compile(it.next().toString()).matcher(host).find()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean pointConditionFilter(@NonNull JSONObject jSONObject, PreloadScheduler.PointType pointType) {
        return jSONObject.getJSONObject("params") != null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "open-data-prefetch";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<DataPreloadResultModel> getResultClazz() {
        return DataPreloadResultModel.class;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public /* bridge */ /* synthetic */ DataPreloadResultModel preLoad(Map map, PreloadScheduler.PointType pointType) {
        return preLoad((Map<String, Object>) map, pointType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:46:0x00f0 A[Catch: all -> 0x00f5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00f5, blocks: (B:26:0x00a0, B:46:0x00f0), top: B:66:0x00a0 }] */
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public DataPreloadResultModel preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        String queryParameter;
        JSONArray availableConfig;
        PluginModel next;
        DataPreloadResultModel dataPreloadResultModelConfigProcessFilter;
        List<JSONObject> list;
        if (pointType == PreloadScheduler.PointType.DATA_PREFETCH && map != null && map.get("appInfo") != null && map.get("url") != null) {
            String string = map.get("url").toString();
            AppModel appModel = (AppModel) map.get("appInfo");
            Bundle bundle = (Bundle) map.get(RVConstants.EXTRA_START_PARAMS);
            long jLongValue = ((Long) map.get(RVConstants.EXTRA_START_TOKEN)).longValue();
            try {
                Uri uri = Uri.parse(string);
                String queryParameter2 = uri.getQueryParameter("page");
                String queryParameter3 = uri.getQueryParameter("query");
                if (TextUtils.isEmpty(queryParameter2)) {
                    queryParameter2 = uri.getQueryParameter("path");
                }
                if (TextUtils.isEmpty(queryParameter2)) {
                    if (TextUtils.isEmpty(queryParameter3)) {
                        queryParameter = null;
                        availableConfig = null;
                    } else {
                        queryParameter = Uri.parse("dynamic-plugin://query?" + queryParameter3).getQueryParameter(MediationConstant.KEY_USE_POLICY_PAGE_ID);
                        try {
                            if (TextUtils.isEmpty(queryParameter)) {
                                availableConfig = null;
                            } else {
                                availableConfig = getAvailableConfig(queryParameter);
                                next = null;
                            }
                            if (availableConfig == null) {
                                availableConfig = getAvailableConfig(appModel);
                            }
                        } catch (Throwable th) {
                            th = th;
                            availableConfig = null;
                            next = availableConfig;
                            RVLogger.w(th.getMessage());
                        }
                    }
                    next = availableConfig;
                    if (availableConfig == null) {
                        availableConfig = getAvailableConfig(appModel);
                    }
                } else {
                    Uri uri2 = Uri.parse(queryParameter2);
                    if ("plugin-private".equals(uri2.getScheme())) {
                        String host = uri2.getHost();
                        List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
                        if (plugins != null) {
                            availableConfig = getAvailableConfig(host);
                            try {
                                Iterator<PluginModel> it = plugins.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        queryParameter = null;
                                        next = null;
                                        break;
                                    }
                                    next = it.next();
                                    if (TextUtils.equals(host, next.getAppId())) {
                                        try {
                                            queryParameter = next.getAppId();
                                            try {
                                                string = com.alibaba.alibctriver.b.a.a(uri, uri2.getQuery()).toString();
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                RVLogger.w(th.getMessage());
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            queryParameter = null;
                                            RVLogger.w(th.getMessage());
                                        }
                                    }
                                }
                                if (availableConfig == null) {
                                    availableConfig = getAvailableConfig(appModel);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                queryParameter = null;
                                next = null;
                            }
                        }
                    }
                    queryParameter = null;
                    availableConfig = null;
                    next = availableConfig;
                    if (availableConfig == null) {
                        availableConfig = getAvailableConfig(appModel);
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                queryParameter = null;
                availableConfig = null;
            }
            PluginModel pluginModel = next;
            JSONArray jSONArray = availableConfig;
            String str = queryParameter;
            if (jSONArray != null && (list = (dataPreloadResultModelConfigProcessFilter = configProcessFilter(appModel, pluginModel, str, bundle, jSONArray, pointType)).orgData) != null && !list.isEmpty() && ((DataPreloadPoint) ExtensionPoint.as(DataPreloadPoint.class).create()).onPreload(string, jLongValue, list)) {
                return dataPreloadResultModelConfigProcessFilter;
            }
        }
        return null;
    }

    private JSONArray getAvailableConfig(AppModel appModel) {
        JSONArray array;
        JSONObject launchParams;
        JSONArray jSONArray;
        if (appModel.getContainerInfo() != null && (launchParams = appModel.getContainerInfo().getLaunchParams()) != null && (jSONArray = launchParams.getJSONArray("preloadConfig")) != null) {
            return jSONArray;
        }
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_DATA_PREFETCH_CONFIG);
        if (configsByGroup == null) {
            return null;
        }
        String str = configsByGroup.get(appModel.getAppId());
        if (TextUtils.isEmpty(str) || (array = JSON.parseArray(str)) == null) {
            return null;
        }
        return array;
    }
}
