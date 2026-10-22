package com.alibaba.triver.appinfo.a;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f24629a;
    private static final List<String> b;

    static {
        ArrayList arrayList = new ArrayList();
        f24629a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        b = arrayList2;
        arrayList.add("ANDROID_SYS_NO_NETWORK");
        arrayList.add("ANDROID_SYS_NETWORK_ERROR");
        arrayList.add("ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT");
        arrayList.add("ANDROID_SYS_JSONDATA_PARSE_ERROR");
        arrayList.add("101");
        arrayList2.add("ANDROID_SYS_NO_NETWORK");
        arrayList2.add("ANDROID_SYS_NETWORK_ERROR");
        arrayList2.add("ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT");
        arrayList2.add("ANDROID_SYS_JSONDATA_PARSE_ERROR");
    }

    public static boolean a() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            String str = configsByGroup.get("useDeveloperVersionForDB");
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Boolean.parseBoolean(str);
                } catch (Exception e) {
                    RVLogger.e(TRiverConstants.TAG, "useDeveloperVersionForDB error", e);
                }
            }
        }
        return false;
    }

    public static boolean b() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closeAppInfoManagerDeepClone"));
        }
        return false;
    }

    public static boolean c() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup != null) {
            return "true".equals(configsByGroup.get("closeOfflineOpen"));
        }
        return false;
    }

    public static boolean d() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closeAssembleAppInfo");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static List<String> e() {
        List<String> list;
        List<String> listAsList = Arrays.asList("templateId");
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup != null) {
                String str = configsByGroup.get("necessaryParam");
                if (!TextUtils.isEmpty(str) && (list = (List) JSON.parseObject(str, new TypeReference<List<String>>() { // from class: com.alibaba.triver.appinfo.a.a.2
                }, new Feature[0])) != null) {
                    list.addAll(listAsList);
                    return list;
                }
            }
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "get necessaryParam failed", e);
        }
        return listAsList;
    }

    public static boolean f() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("closePluginInfoBackUp");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean g() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
        if (configsByGroup == null) {
            return false;
        }
        String str = configsByGroup.get("downgradePluginRelationCheck");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }

    public static boolean b(String str) {
        List list;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup != null) {
                String str2 = configsByGroup.get("templateErrorCodes");
                if (!TextUtils.isEmpty(str2) && (list = (List) JSON.parseObject(str2, new TypeReference<List<String>>() { // from class: com.alibaba.triver.appinfo.a.a.1
                }, new Feature[0])) != null) {
                    list.addAll(f24629a);
                    return list.contains(str);
                }
            }
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "get ErrorCodes failed", e);
        }
        return f24629a.contains(str);
    }

    public static boolean c(String str) {
        JSONArray array;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup == null) {
                return true;
            }
            String str2 = configsByGroup.get("templateIdWhiteList");
            if (TextUtils.isEmpty(str2) || (array = JSON.parseArray(str2)) == null) {
                return true;
            }
            return array.contains(str);
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "get templateIdWhiteList error", e);
            return true;
        }
    }

    public static boolean d(String str) {
        List list;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup != null) {
                String str2 = configsByGroup.get("pluginInfoErrorCodes");
                if (!TextUtils.isEmpty(str2) && (list = (List) JSON.parseObject(str2, new TypeReference<List<String>>() { // from class: com.alibaba.triver.appinfo.a.a.4
                }, new Feature[0])) != null) {
                    list.addAll(b);
                    return list.contains(str);
                }
            }
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "get PluginInfo ErrorCodes failed", e);
        }
        return b.contains(str);
    }

    public static void a(AppInfoModel appInfoModel) {
        if (appInfoModel != null) {
            if (TROrangeController.enableRenderPreload(appInfoModel.getAppId(), appInfoModel.getTemplateConfig() != null ? appInfoModel.getTemplateConfig().getTemplateId() : null)) {
                Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
                if (configsByGroup == null || !"true".equals(configsByGroup.get("closeChangeVHost"))) {
                    appInfoModel.setVhost(TROrangeController.RENDER_PRELOAD_V_HOST);
                }
            }
        }
    }

    public static AppModel a(String str) {
        JSONObject object;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup == null) {
                return null;
            }
            String str2 = configsByGroup.get("templateInfo");
            if (TextUtils.isEmpty(str2) || (object = JSON.parseObject(str2)) == null || !object.containsKey(str)) {
                return null;
            }
            return (AppModel) JSON.parseObject(JSON.toJSONString(object.get(str)), AppModel.class);
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "get templateInfo error", e);
            return null;
        }
    }

    public static PluginModel a(String str, String str2) {
        PluginModel pluginModel;
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup != null) {
                String str3 = configsByGroup.get("pluginInfo");
                if (!TextUtils.isEmpty(str3)) {
                    Map map = (Map) JSON.parseObject(str3, new TypeReference<Map<String, PluginModel>>() { // from class: com.alibaba.triver.appinfo.a.a.3
                    }, new Feature[0]);
                    if (map != null && (pluginModel = (PluginModel) map.get(str)) != null) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "*";
                        }
                        if ("*".equals(str2) || str2.equals(pluginModel.getRequireVersion())) {
                            return pluginModel;
                        }
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e(TRiverConstants.TAG, "get pluginInfo error", e);
        }
        return null;
    }
}
