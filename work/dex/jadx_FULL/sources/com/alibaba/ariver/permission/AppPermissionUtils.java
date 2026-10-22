package com.alibaba.ariver.permission;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.model.ApiPermissionInfo;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AppPermissionUtils {
    public static final String ALIPAY_WEB_COMMON_APPID = "20000067";
    public static final String TAG = "AriverPermission:AppPermissionUtils";

    public static ApiPermissionInfo convert2ApiPermissionInfo(PermissionModel permissionModel) {
        JSONArray jSONArray;
        try {
            RVLogger.debug(TAG, "convert2ApiPermissionInfo " + permissionModel);
            if (permissionModel != null) {
                ApiPermissionInfo apiPermissionInfo = new ApiPermissionInfo();
                apiPermissionInfo.setApiLevelStr(b.d, permissionModel.getEnableProxy());
                Set<String> jsapiList = permissionModel.getJsapiList();
                if (jsapiList != null && !jsapiList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : jsapiList) {
                        if (str instanceof String) {
                            arrayList.add(str);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(b.e, arrayList);
                }
                Set<String> eventList = permissionModel.getEventList();
                if (eventList != null && !eventList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (String str2 : eventList) {
                        if (str2 instanceof String) {
                            arrayList2.add(str2);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(b.f, arrayList2);
                }
                Set<String> validDomains = permissionModel.getValidDomains();
                if (validDomains != null && !validDomains.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList();
                    for (String str3 : validDomains) {
                        if (str3 instanceof String) {
                            arrayList3.add(str3);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(b.g, arrayList3);
                }
                JSONObject specialConfigs = permissionModel.getSpecialConfigs();
                if (specialConfigs != null && !specialConfigs.isEmpty()) {
                    for (String str4 : specialConfigs.keySet()) {
                        JSONObject jSONObject = JSONUtils.getJSONObject(specialConfigs, str4, null);
                        if (jSONObject != null) {
                            ArrayList arrayList4 = new ArrayList();
                            for (String str5 : jSONObject.keySet()) {
                                arrayList4.add(str5);
                                JSONArray jSONArray2 = JSONUtils.getJSONArray(jSONObject, str5, null);
                                if (jSONArray2 != null && !jSONArray2.isEmpty()) {
                                    ArrayList arrayList5 = new ArrayList();
                                    for (Object obj : jSONArray2) {
                                        if (obj instanceof String) {
                                            arrayList5.add((String) obj);
                                        }
                                    }
                                    apiPermissionInfo.setApiLevelList("JSAPI_SP_Config_" + str4 + LoginConstants.UNDER_LINE + str5, arrayList5);
                                }
                            }
                            apiPermissionInfo.setApiLevelList("JSAPI_SP_Config_" + str4, arrayList4);
                        }
                    }
                }
                Set<String> validSubResMimeList = permissionModel.getValidSubResMimeList();
                if (validSubResMimeList != null && !validSubResMimeList.isEmpty()) {
                    ArrayList arrayList6 = new ArrayList();
                    for (String str6 : validSubResMimeList) {
                        if (str6 instanceof String) {
                            arrayList6.add(str6);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(b.i, arrayList6);
                }
                Set<String> httpLinkSubResMimeList = permissionModel.getHttpLinkSubResMimeList();
                if (httpLinkSubResMimeList != null && !httpLinkSubResMimeList.isEmpty()) {
                    ArrayList arrayList7 = new ArrayList();
                    for (String str7 : httpLinkSubResMimeList) {
                        if (str7 instanceof String) {
                            arrayList7.add(str7);
                        }
                    }
                    apiPermissionInfo.setApiLevelList(b.j, arrayList7);
                }
                JSONObject webviewConfigs = permissionModel.getWebviewConfigs();
                if (!webviewConfigs.isEmpty() && (jSONArray = webviewConfigs.getJSONArray(b.l)) != null) {
                    ArrayList arrayList8 = new ArrayList();
                    for (Object obj2 : jSONArray) {
                        if (obj2 instanceof String) {
                            arrayList8.add((String) obj2);
                        }
                    }
                    apiPermissionInfo.setApiLevelList("Webview_Config_allowedDomain", arrayList8);
                }
                apiPermissionInfo.setApiLevelStr(b.o, permissionModel.getForceUseSsl());
                apiPermissionInfo.setHasPermissionFile(true);
                return apiPermissionInfo;
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
        return null;
    }

    public static String getAggregationMainAppId(AppModel appModel) {
        JSONObject jSONObject;
        if (appModel == null || appModel.getExtendInfos() == null || (jSONObject = JSONUtils.getJSONObject(appModel.getExtendInfos(), RVConstants.EXTRA_RES_LAUNCH_PARAMS, null)) == null) {
            return null;
        }
        return JSONUtils.getString(jSONObject, "aggregationMainAppId");
    }

    public static String getAggregationMainAppIdForH5Page(String str, String str2) {
        if (TextUtils.isEmpty(str) || !ALIPAY_WEB_COMMON_APPID.equals(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + LoginConstants.UNDER_LINE + UrlUtils.getHost(str2);
    }

    public static App getApp(Accessor accessor) {
        if (!(accessor instanceof Node)) {
            return null;
        }
        Node parentNode = (Node) accessor;
        int i = 5;
        while (parentNode != null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            if (parentNode instanceof App) {
                return (App) parentNode;
            }
            parentNode = parentNode.getParentNode();
            i = i2;
        }
        return null;
    }

    public static String getPermissionAppId(Accessor accessor) {
        App app = getApp(accessor);
        if (app != null) {
            return app.getAppId();
        }
        return null;
    }

    public static PermissionModel getPermissionModel(App app) {
        AppModel appModel = (AppModel) BundleUtils.getParcelable(app.getSceneParams(), "appInfo");
        if (appModel != null) {
            return appModel.getPermissionModel();
        }
        return null;
    }

    public static boolean isAppPermission(Accessor accessor) {
        String permissionAppId = getPermissionAppId(accessor);
        if (permissionAppId != null) {
            return ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getPermissionModel(permissionAppId) != null || isNoPermissionConfigAndAllow(accessor, permissionAppId);
        }
        RVLogger.d(TAG, "isAppPermission getAppId return null!!! accessor: " + accessor);
        return false;
    }

    public static boolean isNoPermissionConfigAndAllow(Accessor accessor, String str) {
        if (accessor instanceof Page) {
            boolean z = BundleUtils.getBoolean(((Page) accessor).getStartParams(), RVParams.isTinyApp, false);
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (z && rVConfigService != null && !"no".equals(rVConfigService.getConfig("h5_enableTinyIgnorePermission", "yes"))) {
                return true;
            }
        }
        return false;
    }

    public static List<Permission> parseJsApiPermission(PermissionModel permissionModel) {
        Set<String> jsapiList = permissionModel.getJsapiList();
        if (jsapiList == null || jsapiList.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : jsapiList) {
            arrayList.add(new BridgePermission(str, str));
        }
        return arrayList;
    }

    public static PermissionModel parsePermissionJson(byte[] bArr) {
        return PermissionModel.generateFromJSON(bArr);
    }

    public static PermissionModel parsePermissionModel(App app) {
        AppInfoQuery appInfoQuery = new AppInfoQuery(app.getAppId());
        if (AppInfoScene.isDevSource(app.getStartParams())) {
            appInfoQuery.scene(AppInfoScene.extractScene(app.getStartParams()));
            appInfoQuery.version(AppInfoScene.extractSceneVersion(app.getStartParams()));
        }
        AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(appInfoQuery);
        if (appModel != null) {
            return appModel.getPermissionModel();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x0020  */
    public static PermissionModel getPermissionModel(Accessor accessor) {
        App app;
        if (!(accessor instanceof Node)) {
            return null;
        }
        Node parentNode = (Node) accessor;
        int i = 5;
        while (parentNode != null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            if (parentNode instanceof App) {
                app = (App) parentNode;
            } else {
                parentNode = parentNode.getParentNode();
                i = i2;
            }
            if (app == null) {
                return null;
            }
            return getPermissionModel(app);
        }
        app = null;
        if (app == null) {
            return null;
        }
        return getPermissionModel(app);
    }
}
