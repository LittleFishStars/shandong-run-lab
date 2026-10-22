package com.alibaba.triver.kit.api.common;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.b;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DomainNameController {
    public static final String ERROR_URL_NOT_IN_WHITE_LIST = "please insure your url  is in domain whitelist";
    public static final String TAG = "DomainNameController";
    private static final String[] mDefaultWhiteList = {".mappcloud.com", ".aliimg.com", ".alibaba.com", ".aliyun.com", ".tbcdn.cn", ".taobaocdn.com", ".taobao.com", ".mmcdn.cn", ".hpcdn.net", ".alicdn.com", ".1688.com", ".umeng.com", ".tb.cn", ".aliyun.com", ".alitrip.com", ".alitrip.hk", ".lazada.sg", ".aliyuncs.com", ".alimmdn.com", ".alibabausercontent.com"};

    public static boolean embedViewPermissionCheck(String str, App app) {
        return isLocalURL(str) || urlBothInOfficialDomainListAndPermissionModelList(str, app, (String) null) || urlInAllPluginPermission(str, app, false);
    }

    public static boolean isLocalURL(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(g.e);
    }

    public static boolean urlBothInOfficialDomainListAndPermissionModelList(String str, App app, String str2) {
        if (isLocalURL(str)) {
            return true;
        }
        if (TRiverUtils.isPluginInvokeThisApi(str2)) {
            return urlInOfficialDomainList(str) || urlInPluginPermission(str, TRiverUtils.getPluginModelByPluginId(app, str2), true) || urlInPermissionModel(str, app);
        }
        return urlInOfficialDomainList(str) || urlInPermissionModel(str, app);
    }

    public static boolean urlInAllPluginPermission(String str, App app, boolean z) {
        AppModel appModel;
        AppInfoModel appInfoModel;
        List<PluginModel> plugins;
        if (str == null || app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (appInfoModel = appModel.getAppInfoModel()) == null || (plugins = appInfoModel.getPlugins()) == null) {
            return false;
        }
        Iterator<PluginModel> it = plugins.iterator();
        while (it.hasNext()) {
            if (urlInPluginPermission(str, it.next(), z)) {
                return true;
            }
        }
        return false;
    }

    public static boolean urlInOfficialDomainList(String str) {
        if (!TROrangeController.openSrcDomainCheck()) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            JSONArray resourceDomainNameWhiteList = TROrangeController.getResourceDomainNameWhiteList();
            for (String str2 : mDefaultWhiteList) {
                if (host.endsWith(str2)) {
                    RVLogger.e(TAG, "in default white list : " + str);
                    return true;
                }
            }
            if (resourceDomainNameWhiteList != null) {
                for (Object obj : resourceDomainNameWhiteList) {
                    if ((obj instanceof String) && host.endsWith((String) obj)) {
                        RVLogger.e(TAG, "in white list : " + str);
                        return true;
                    }
                }
            }
            RVLogger.e(TAG, "not in white list : " + str);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            RVLogger.e(TAG, "check url error : " + e.getMessage() + " url is : " + str);
        }
    }

    public static boolean urlInPermissionModel(String str, App app) {
        AppModel appModel;
        JSONObject specialConfigs;
        JSONArray jSONArray;
        String host;
        if (!TROrangeController.openSrcDomainCheck()) {
            return true;
        }
        if (app == null || TextUtils.isEmpty(str) || (appModel = (AppModel) app.getData(AppModel.class)) == null || (specialConfigs = appModel.getPermissionModel().getSpecialConfigs()) == null || (jSONArray = specialConfigs.getJSONObject(b.m).getJSONArray(b.l)) == null) {
            return false;
        }
        try {
            host = new URL(str).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            host = null;
        }
        if (host == null) {
            return false;
        }
        for (Object obj : jSONArray) {
            if ((obj instanceof String) && Pattern.compile((String) obj).matcher(host).find()) {
                RVLogger.e(TAG, "in httpRequest white list : " + str);
                return true;
            }
        }
        RVLogger.e(TAG, "not in httpRequest white list : " + str);
        return false;
    }

    public static boolean urlInPluginPermission(String str, PluginModel pluginModel, boolean z) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        String host;
        if (pluginModel == null || str == null) {
            return false;
        }
        if (z && TRiverUtils.isSecondPartyPlugin(pluginModel)) {
            return true;
        }
        JSONObject permission = pluginModel.getPermission();
        if (permission == null || (jSONObject = permission.getJSONObject("jsapiSpConfig")) == null || (jSONObject2 = jSONObject.getJSONObject(b.m)) == null || (jSONArray = jSONObject2.getJSONArray(b.l)) == null) {
            return false;
        }
        try {
            host = new URL(str).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            host = null;
        }
        if (host == null) {
            return false;
        }
        for (Object obj : jSONArray) {
            if ((obj instanceof String) && Pattern.compile((String) obj).matcher(host).find()) {
                RVLogger.e(TAG, "in plugin httpRequest white list : " + str);
                return true;
            }
        }
        return false;
    }

    public static boolean urlBothInOfficialDomainListAndPermissionModelList(String str, Page page, String str2) {
        if (isLocalURL(str)) {
            return true;
        }
        return urlBothInOfficialDomainListAndPermissionModelList(str, page == null ? null : page.getApp(), str2);
    }
}
