package com.alibaba.ariver.permission.service;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgePermission;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.DefaultPermission;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.DomainConfigProxy;
import com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy;
import com.alibaba.ariver.permission.model.ApiPermissionInfo;
import com.alibaba.ariver.remotedebug.b;
import com.alibaba.ariver.remotedebug.b.c;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultAuthenticationProxyImpl implements AuthenticationProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f24367a = {"navigateTo", "navigateBack", "switchTab", "reLaunch", "redirectTo", "getCurrentLocation", "getLocation", "webViewShare"};
    private static final List<String> b;
    private static String c;
    private static List<String> d;
    private final Map<String, Integer> e = new ConcurrentHashMap();
    private final Map<String, Map<String, PermissionModel>> f = new ConcurrentHashMap();
    private final Map<String, Map<String, ApiPermissionInfo>> g = new ConcurrentHashMap();
    private Map<String, ApiPermissionInfo> h = new ConcurrentHashMap();
    private Map<String, PermissionModel> i = new ConcurrentHashMap();
    private a j = new a();

    /* JADX INFO: renamed from: com.alibaba.ariver.permission.service.DefaultAuthenticationProxyImpl$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24369a;

        static {
            int[] iArr = new int[AppInfoScene.values().length];
            f24369a = iArr;
            try {
                iArr[AppInfoScene.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24369a[AppInfoScene.INSPECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        c = "AriverPermission:DefaultAuthenticationProxyImpl";
        ArrayList arrayList2 = new ArrayList();
        d = arrayList2;
        arrayList2.add("showNetWorkCheckActivity");
        d.add("showUCFailDialog");
        d.add("setKeyboardType");
        d.add("monitorH5Performance");
        d.add("getStartupParams");
        d.add("inputBlurEvent");
        d.add("hideCustomKeyBoard");
        d.add("hideCustomInputMethod4NativeInput");
        d.add("updateNativeKeyBoardInput");
        d.add("setInputTextChanged");
        d.add(c.b);
        d.add(b.e);
        d.add("needShowAuthSettingEntry");
        arrayList.add("tel");
        arrayList.add("mailto");
        arrayList.add("sms");
        arrayList.add("geo");
    }

    private void a(String str) {
        if (!this.e.containsKey(str)) {
            this.e.put(str, 1);
        } else {
            Map<String, Integer> map = this.e;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        }
    }

    private boolean b(String str) {
        if (this.e.containsKey(str)) {
            int iIntValue = this.e.get(str).intValue() - 1;
            this.e.put(str, Integer.valueOf(iIntValue));
            boolean z = iIntValue == 0;
            if (z) {
                this.e.remove(str);
            }
            return z;
        }
        RVLogger.w(c, "cannot detach " + str + " because it not attached!");
        return true;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkEventPermission(String str, String str2, Page page) {
        return !this.h.containsKey(str) ? ApiPermissionCheckResult.IGNORE : hasPermission(str, str2, com.alibaba.ariver.permission.b.f, page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, @Nullable Page page) {
        RVLogger.d(c, "checkJSApi " + nativeCallContext.getName() + " source: " + nativeCallContext.getSource());
        if (page == null && app == null) {
            RVLogger.d(c, "checkJSApi,page is null");
            return ApiPermissionCheckResult.DENY_N22101;
        }
        if (a(app.getStartParams(), nativeCallContext.getName())) {
            return ApiPermissionCheckResult.DENY_N22102;
        }
        String appId = app.getAppId();
        if (!TextUtils.isEmpty(nativeCallContext.getPluginId())) {
            if (!"yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_checkAppxDomain", "yes"))) {
                return a(appId, nativeCallContext.getPluginId(), permission);
            }
            AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (!(appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) || (appConfigModel != null && "true".equalsIgnoreCase(appConfigModel.getUseDynamicPlugins()))) {
                RVLogger.d(c, "checkForPlugin because use plugins");
                return a(appId, nativeCallContext.getPluginId(), permission);
            }
        }
        if (page != null && a(nativeCallContext, page)) {
            RVLogger.d(c, "commonCheckIgnorePermission IGNORE by hasJsApiPermissionCallFromRender");
            return ApiPermissionCheckResult.IGNORE;
        }
        PermissionModel permissionModel = this.i.get(appId);
        if (permission == null || permission == DefaultPermission.ALL || permissionModel == null) {
            RVLogger.d(c, String.format("%s not have permission file", appId));
            return ApiPermissionCheckResult.IGNORE;
        }
        if (d.contains(permission.authority()) || ("sendMtop".equalsIgnoreCase(nativeCallContext.getName()) && page.getInstanceType() == InstanceType.TAOBAO)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("h5_white_jsapiList");
        if (configJSONArray != null && configJSONArray.contains(permission.authority())) {
            return ApiPermissionCheckResult.IGNORE;
        }
        if (a(page)) {
            RVLogger.d(c, permission.authority() + " call from webview");
            String appId2 = page.getApp().getAppId();
            String string = BundleUtils.getString(page.getStartParams(), "appId");
            EmbedWebViewJsApiPermissionProxy embedWebViewJsApiPermissionProxy = (EmbedWebViewJsApiPermissionProxy) RVProxy.get(EmbedWebViewJsApiPermissionProxy.class);
            if (embedWebViewJsApiPermissionProxy != null) {
                if (embedWebViewJsApiPermissionProxy.shouldInterceptJSApiCall(permission.authority(), page, appId2, string, nativeCallContext.getParams())) {
                    RVLogger.d(c, "embedwebviewjsapi_forbidden:EmbedWebViewJsApi interceptJSApiCall\t" + permission.authority());
                    return ApiPermissionCheckResult.DENY_N22201;
                }
                RVLogger.d(c, " EmbedWebViewJsApi ignore\t" + permission.authority());
                return ApiPermissionCheckResult.IGNORE;
            }
        } else {
            Set<String> jsapiList = permissionModel.getJsapiList();
            if (jsapiList != null && jsapiList.size() > 0) {
                Iterator<String> it = jsapiList.iterator();
                while (it.hasNext()) {
                    if (it.next().equalsIgnoreCase(permission.authority())) {
                        RVLogger.d(c, "permison is allowed \t " + permission.authority());
                        return ApiPermissionCheckResult.ALLOW;
                    }
                }
            }
        }
        RVLogger.d(c, "jsapi_forbidden:checkJSAPI deny \t" + permission.authority());
        return ApiPermissionCheckResult.DENY_N22104;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult checkSPJSApi(Permission permission, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, App app, @Nullable Page page) {
        ApiPermissionInfo apiPermissionInfo;
        boolean z;
        Uri url;
        ApiPermissionCheckResult apiPermissionCheckResultHasPermission;
        if (app == null) {
            return ApiPermissionCheckResult.DENY_N22207;
        }
        String appId = app.getAppId();
        String strAuthority = permission.authority();
        if (TextUtils.isEmpty(nativeCallContext.getPluginId())) {
            apiPermissionInfo = this.h.get(appId);
            z = false;
        } else {
            apiPermissionInfo = this.g.get(appId) == null ? null : this.g.get(appId).get(nativeCallContext.getPluginId());
            RVLogger.debug(c, "get ApiPermissionInfo from pluginId" + nativeCallContext.getPluginId());
            z = true;
        }
        if (apiPermissionInfo == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        String str = "JSAPI_SP_Config_" + strAuthority;
        List<String> apiLevelList = apiPermissionInfo.getApiLevelList(str);
        if (TextUtils.equals(strAuthority, com.alibaba.ariver.permission.b.m) || TextUtils.equals(strAuthority, com.alibaba.ariver.permission.b.n) || TextUtils.equals(strAuthority, "request")) {
            String string = JSONUtils.getString(nativeCallContext.getParams(), "url");
            Uri url2 = UrlUtils.parseUrl(string);
            if (url2 != null) {
                String host = url2.getHost();
                ApiPermissionCheckResult apiPermissionCheckResultA = z ? a(apiPermissionInfo, host, "JSAPI_SP_Config_httpRequest_allowedDomain") : hasPermission(appId, host, "JSAPI_SP_Config_httpRequest_allowedDomain", page);
                ApiPermissionCheckResult apiPermissionCheckResult = ApiPermissionCheckResult.IGNORE;
                if (apiPermissionCheckResultA != apiPermissionCheckResult) {
                    RVLogger.d(c, "jsapi_sp_forbidden:" + strAuthority + "\t is not allowed, in _allowedDomain: " + host);
                }
                if (TextUtils.equals(strAuthority, com.alibaba.ariver.permission.b.m) || TextUtils.equals(strAuthority, com.alibaba.ariver.permission.b.n) || TextUtils.equals(strAuthority, "request")) {
                    if (apiPermissionCheckResultA == apiPermissionCheckResult) {
                        if (!a(page, host)) {
                            return apiPermissionCheckResultA;
                        }
                        RVLogger.d(c, "jsapi_sp_forbidden:" + strAuthority + "\t is not allowed, in domain blacklist: " + host + " is not allowed");
                        return ApiPermissionCheckResult.DENY_N22111;
                    }
                    boolean zIsDevSource = AppInfoScene.isDevSource(app.getStartParams());
                    boolean z2 = BundleUtils.getBoolean(app.getStartParams(), com.alibaba.ariver.permission.b.q, false);
                    if (!zIsDevSource || !z2) {
                        return apiPermissionCheckResultA;
                    }
                    DomainConfigProxy domainConfigProxy = (DomainConfigProxy) RVProxy.get(DomainConfigProxy.class);
                    RVLogger.d(c, strAuthority + "\t ignoreHttpReqPermission: ");
                    return (domainConfigProxy == null || domainConfigProxy.isAlipayDomains(string) || domainConfigProxy.isSeriousAliDomains(string) || domainConfigProxy.isAliDomains(string)) ? apiPermissionCheckResultA : apiPermissionCheckResult;
                }
            }
        } else if (apiLevelList != null) {
            for (String str2 : apiLevelList) {
                String string2 = JSONUtils.getString(nativeCallContext.getParams(), str2, null);
                if (!TextUtils.isEmpty(string2)) {
                    ApiPermissionCheckResult apiPermissionCheckResultA2 = z ? a(apiPermissionInfo, string2, str + LoginConstants.UNDER_LINE + str2) : hasPermission(appId, string2, str + LoginConstants.UNDER_LINE + str2, page);
                    if (apiPermissionCheckResultA2 != ApiPermissionCheckResult.IGNORE) {
                        RVLogger.d(c, "jsapi_sp_forbidden:" + strAuthority + " paramKey: " + str2 + " content: " + string2 + " is not allowed");
                        return apiPermissionCheckResultA2;
                    }
                }
            }
            if (TextUtils.equals(strAuthority, RVStartParams.START_SCENE_START_APP) && (url = UrlUtils.parseUrl(JSONUtils.getString(JSONUtils.getJSONObject(nativeCallContext.getParams(), "param", null), "url"))) != null) {
                String host2 = url.getHost();
                String str3 = str + "_url";
                if (!z) {
                    apiPermissionCheckResultHasPermission = hasPermission(appId, host2, str3, page);
                } else {
                    if (apiPermissionInfo.getApiLevelList(str3) == null) {
                        return ApiPermissionCheckResult.IGNORE;
                    }
                    apiPermissionCheckResultHasPermission = a(apiPermissionInfo, host2, str3);
                }
                if (apiPermissionCheckResultHasPermission != ApiPermissionCheckResult.IGNORE) {
                    RVLogger.d(c, "jsapi_sp_forbidden:" + strAuthority + " host: " + host2 + " is not allowed");
                }
                return apiPermissionCheckResultHasPermission;
            }
        }
        return ApiPermissionCheckResult.IGNORE;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(Permission permission, final NativeCallContext nativeCallContext, final BridgeResponseHelper bridgeResponseHelper, final Page page) {
        return checkShowPermissionDialog(permission, nativeCallContext, new AuthenticationProxy.LocalPermissionCallback() { // from class: com.alibaba.ariver.permission.service.DefaultAuthenticationProxyImpl.1
            @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy.LocalPermissionCallback
            public void onNegative(boolean z) {
                if (z) {
                    bridgeResponseHelper.sendUserNotGrantPermission();
                } else {
                    bridgeResponseHelper.sendSilentDenyPermission();
                }
            }

            @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy.LocalPermissionCallback
            public void onPositive() {
                page.getApp().getEngineProxy().getBridge().sendToNative(nativeCallContext, bridgeResponseHelper.getInnerBridgeResponse(), false);
            }
        }, page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void clearPermissionModel(String str, boolean z) {
        if (b(str)) {
            if (this.i.containsKey(str)) {
                this.i.remove(str);
            }
            if (this.h.get(str) != null) {
                this.h.get(str).clear();
                this.h.remove(str);
            }
            if (z) {
                this.f.remove(str);
            }
        }
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public Map<String, Boolean> getAllPermissions(String str, String str2, @Nullable AppModel appModel, @Nullable App app, @Nullable Page page) {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j.a(str2, appModel, app, page, this.f);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public PermissionModel getPermissionModel(String str) {
        return this.i.get(str);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public List<Permission> getPermissions(String str) {
        Set<String> jsapiList;
        PermissionModel permissionModel = this.i.get(str);
        if (permissionModel == null || (jsapiList = permissionModel.getJsapiList()) == null || jsapiList.size() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsapiList.size());
        for (String str2 : jsapiList) {
            arrayList.add(new BridgePermission(str2, str2));
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult hasPermission(String str, String str2, String str3, Page page) {
        if (page != null && page.getApp() != null) {
            return hasPermission(str, str2, str3, page.getApp(), page);
        }
        RVLogger.d(c, "checkJSApi,page is null");
        return ApiPermissionCheckResult.DENY_N22101;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean hasPermissionModel(String str, Page page) {
        if (TextUtils.isEmpty(str)) {
            if (!a(page)) {
                return false;
            }
            str = page.getApp().getAppId();
        }
        return this.i.containsKey(str);
    }

    public ApiPermissionCheckResult hasPermissionOnScheme(String str, Page page) {
        Uri url;
        if (!a(page)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        String appId = page.getApp().getAppId();
        if (TextUtils.isEmpty(str)) {
            return ApiPermissionCheckResult.IGNORE;
        }
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return ApiPermissionCheckResult.IGNORE;
            }
        }
        try {
            boolean zEquals = "1".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_close_webviewSchemaWhiteList", "0"));
            String strExtractAppIdFromUrl = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).extractAppIdFromUrl(str);
            if (!zEquals && !TextUtils.isEmpty(strExtractAppIdFromUrl)) {
                ApiPermissionCheckResult apiPermissionCheckResult = ApiPermissionCheckResult.DENY;
                if (this.h == null) {
                    return apiPermissionCheckResult;
                }
                ApiPermissionCheckResult apiPermissionCheckResultHasPermission = hasPermission(appId, RVStartParams.START_SCENE_START_APP, com.alibaba.ariver.permission.b.e, page);
                ApiPermissionCheckResult apiPermissionCheckResult2 = ApiPermissionCheckResult.IGNORE;
                if (apiPermissionCheckResultHasPermission != apiPermissionCheckResult2) {
                    RVLogger.d(c, "start_app_forbidden: not have (startApp) ");
                    return ApiPermissionCheckResult.DENY_N22202;
                }
                ApiPermissionCheckResult apiPermissionCheckResultHasPermission2 = hasPermission(appId, strExtractAppIdFromUrl, "JSAPI_SP_Config_startApp_appId", page);
                if (apiPermissionCheckResultHasPermission2 != apiPermissionCheckResult2) {
                    RVLogger.d(c, "start_app_forbidden: not have startApp: " + strExtractAppIdFromUrl);
                    return ApiPermissionCheckResult.DENY_N22203;
                }
                Uri url2 = UrlUtils.parseUrl(str);
                String queryParameter = url2 != null ? url2.getQueryParameter("url") : null;
                if (TextUtils.isEmpty(queryParameter) || (url = UrlUtils.parseUrl(queryParameter)) == null) {
                    return apiPermissionCheckResultHasPermission2;
                }
                ApiPermissionCheckResult apiPermissionCheckResultHasPermission3 = hasPermission(appId, url.getHost(), "JSAPI_SP_Config_startApp_url", page);
                if (apiPermissionCheckResultHasPermission3 == apiPermissionCheckResult2) {
                    return apiPermissionCheckResultHasPermission3;
                }
                RVLogger.d(c, "start_app_forbidden: not have startApp: " + queryParameter);
                return ApiPermissionCheckResult.DENY_N22204;
            }
        } catch (Throwable th) {
            RVLogger.e(c, th);
        }
        if (str.startsWith("http")) {
            return ApiPermissionCheckResult.IGNORE;
        }
        RVLogger.d(c, "schema_forbidden: scheme is not http，https，alipay schema");
        RVLogger.d(c, "hasPermissionOnScheme...non-http url, no permission");
        return ApiPermissionCheckResult.DENY_N22205;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult interceptSchemeForTiny(String str, Page page) {
        if (str == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        ApiPermissionCheckResult apiPermissionCheckResultA = a(str, page);
        ApiPermissionCheckResult apiPermissionCheckResult = ApiPermissionCheckResult.IGNORE;
        if (apiPermissionCheckResultA != apiPermissionCheckResult) {
            return apiPermissionCheckResultA;
        }
        return (str.startsWith("http") || str.startsWith("javascript") || "no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_interceptSchemeForTiny", "")) || page == null || !hasPermissionModel(BundleUtils.getString(page.getStartParams(), "appId"), page)) ? apiPermissionCheckResult : hasPermissionOnScheme(str, page);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult interceptUrlForTiny(String str, String str2, Page page, boolean z) {
        String host;
        Uri url = UrlUtils.parseUrl(str);
        if (url != null) {
            String scheme = url.getScheme();
            if (scheme != null && b.contains(scheme.toLowerCase())) {
                return ApiPermissionCheckResult.IGNORE;
            }
            host = url.getHost();
        } else {
            host = "";
        }
        if (TextUtils.isEmpty(str2)) {
            if (!a(page)) {
                return ApiPermissionCheckResult.IGNORE;
            }
            str2 = page.getApp().getAppId();
        }
        PermissionModel permissionModel = this.i.get(str2);
        ApiPermissionCheckResult apiPermissionCheckResult = ApiPermissionCheckResult.IGNORE;
        if (permissionModel != null) {
            return z ? a(str2, host, com.alibaba.ariver.permission.b.g, page) : hasPermission(str2, host, com.alibaba.ariver.permission.b.g, page);
        }
        return apiPermissionCheckResult;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void removeAllPermissionInfo(String str, String str2, App app, String str3) {
        if (this.j == null) {
            this.j = new a();
        }
        this.j.a(app, str2, str3);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPermissionModel(String str, PermissionModel permissionModel) {
        if (!this.i.containsKey(str)) {
            this.i.put(str, permissionModel);
            this.h.put(str, AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
        }
        a(str);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPermissionState(String str, String str2, App app, String str3, String str4, boolean z) {
        if (this.j == null) {
            this.j = new a();
        }
        this.j.a(app, str2, str4, str3, z ? "1" : "0");
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public void setPluginPermissionModel(String str, PluginModel pluginModel, PermissionModel permissionModel) {
        RVLogger.d(c, "setPluginPermissionModel " + str + " plugin: " + pluginModel.getAppId());
        synchronized (this.f) {
            Map<String, PermissionModel> map = this.f.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f.put(str, map);
            }
            map.put(pluginModel.getAppId(), permissionModel);
        }
        synchronized (this.g) {
            Map<String, ApiPermissionInfo> map2 = this.g.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.g.put(str, map2);
            }
            map2.put(pluginModel.getAppId(), AppPermissionUtils.convert2ApiPermissionInfo(permissionModel));
        }
    }

    public boolean shouldInterceptWebViewNaviJsApi(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : f24367a) {
            if (str2.equals(str3)) {
                return false;
            }
        }
        List<String> stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_webviewAppIdWhiteList"));
        if (stringArray != null) {
            Iterator<String> it = stringArray.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next(), str)) {
                    RVLogger.d(c, "shouldInterceptWebViewNaviJsApi...appId in white list:" + str2);
                    return false;
                }
            }
        }
        RVLogger.d(c, "shouldInterceptWebViewNaviJsApi...not allowed: " + str2);
        return true;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public boolean checkShowPermissionDialog(Permission permission, NativeCallContext nativeCallContext, AuthenticationProxy.LocalPermissionCallback localPermissionCallback, Page page) {
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        if (tinyAppInnerProxy == null || page.getApp() == null || !tinyAppInnerProxy.isInner(page.getApp())) {
            return this.j.a(permission, nativeCallContext, localPermissionCallback, page);
        }
        RVLogger.d(c, "checkShowPermissionDialog isInner ");
        return false;
    }

    private boolean a(Page page, String str) {
        List<String> stringArray;
        if (page != null && !TextUtils.isEmpty(str) && (stringArray = JSONUtils.toStringArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_http_domain_blacklist"))) != null && !stringArray.isEmpty()) {
            Iterator<String> it = stringArray.iterator();
            while (it.hasNext()) {
                Matcher matcher = Pattern.compile(it.next()).matcher(str);
                if (matcher != null && matcher.matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public Map<String, Boolean> getAllPermissions(String str, String str2, @Nullable AppModel appModel, @Nullable App app, String str3) {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j.a(str2, appModel, app, this.f, str3);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthenticationProxy
    public ApiPermissionCheckResult hasPermission(String str, String str2, String str3, App app, @Nullable Page page) {
        Map<String, ApiPermissionInfo> map;
        RVLogger.d(c, "hasPermission " + str + " " + str2 + " " + str3);
        boolean zA = a(page);
        if (zA) {
            str = app.getAppId();
        }
        IgnorePermissionPoint ignorePermissionPoint = (IgnorePermissionPoint) ExtensionPoint.as(IgnorePermissionPoint.class).node(app).useCache(true).create();
        if (ignorePermissionPoint != null && ignorePermissionPoint.ignoreAppPermission(str)) {
            RVLogger.d(c, "ignore hasPermission appid\t " + str);
            return ApiPermissionCheckResult.IGNORE;
        }
        if (zA) {
            try {
                if (!(!"0".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_canUseWebview", "1")))) {
                    RVLogger.d(c, "hasPermission...webview is not supported!");
                    return ApiPermissionCheckResult.DENY;
                }
                if (str3.startsWith(com.alibaba.ariver.permission.b.g)) {
                    boolean z = BundleUtils.getBoolean(page.getStartParams(), com.alibaba.ariver.permission.b.r, false);
                    boolean zIsDevSource = AppInfoScene.isDevSource(page.getStartParams());
                    if (z && zIsDevSource) {
                        RVLogger.d(c, "ignore embed webview domain veriy.");
                        return ApiPermissionCheckResult.IGNORE;
                    }
                    str3 = "Webview_Config_allowedDomain";
                }
            } catch (Exception e) {
                RVLogger.e(c, "hasPermission Exception!", e);
                return ApiPermissionCheckResult.IGNORE;
            }
        }
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        if (tinyAppInnerProxy != null && app != null && tinyAppInnerProxy.isInner(app)) {
            RVLogger.d(c, "hasPermission...isInner just ignore!");
            return ApiPermissionCheckResult.IGNORE;
        }
        ApiPermissionInfo apiPermissionInfo = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (map = this.h) == null || map.get(str) == null || this.h.get(str).getApiLevelList(str3) == null || this.h.get(str).getApiLevelList(str3).isEmpty()) ? null : this.h.get(str);
        if (apiPermissionInfo == null) {
            return ApiPermissionCheckResult.IGNORE;
        }
        ApiPermissionCheckResult apiPermissionCheckResultA = a(apiPermissionInfo, str2, str3);
        RVLogger.debug(c, "hasPermission..." + str2 + " " + str3 + " result " + apiPermissionCheckResultA);
        return apiPermissionCheckResultA;
    }

    private boolean a(NativeCallContext nativeCallContext, @Nullable Page page) {
        if (((WorkerStore) page.getData(WorkerStore.class)) == null || NativeCallContext.FROM_WORKER.equals(nativeCallContext.getSource())) {
            return false;
        }
        String pageURI = page.getPageURI();
        String string = BundleUtils.getString(page.getStartParams(), "onlineHost");
        if (TextUtils.isEmpty(pageURI) || TextUtils.isEmpty(string) || !pageURI.startsWith(string)) {
            return false;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_renderJsapiBList");
        return configJSONArray == null || !configJSONArray.contains(nativeCallContext.getName());
    }

    private ApiPermissionCheckResult a(String str, String str2, Permission permission) {
        Map<String, PermissionModel> map = this.f.get(str);
        if (map != null && map.containsKey(str2)) {
            PermissionModel permissionModel = map.get(str2);
            if (permissionModel == null) {
                RVLogger.d(c, "permission is enabled by no permission file! " + permission.authority());
                return ApiPermissionCheckResult.ALLOW;
            }
            Set<String> jsapiList = permissionModel.getJsapiList();
            if (jsapiList != null && jsapiList.size() > 0) {
                Iterator<String> it = jsapiList.iterator();
                while (it.hasNext()) {
                    if (it.next().equalsIgnoreCase(permission.authority())) {
                        RVLogger.d(c, "permission is allowed by plugin \t " + permission.authority());
                        return ApiPermissionCheckResult.ALLOW;
                    }
                }
            }
            RVLogger.d(c, "plugin_forbidden:permission is disabled by plugin \t " + permission.authority());
            return ApiPermissionCheckResult.DENY_N22103;
        }
        RVLogger.d(c, String.format("plugin %s not have permission field, just ignore", str2));
        return ApiPermissionCheckResult.IGNORE;
    }

    private boolean a(Page page) {
        if (page == null) {
            return false;
        }
        return page.getEmbedType().isEmbedPage();
    }

    private ApiPermissionCheckResult a(ApiPermissionInfo apiPermissionInfo, String str, String str2) {
        if (!TextUtils.equals(str2, com.alibaba.ariver.permission.b.i) && !str2.startsWith(com.alibaba.ariver.permission.b.h) && !TextUtils.equals(str2, com.alibaba.ariver.permission.b.f) && !TextUtils.equals(str2, com.alibaba.ariver.permission.b.j) && !str2.startsWith(com.alibaba.ariver.permission.b.k) && !TextUtils.equals(str2, com.alibaba.ariver.permission.b.g)) {
            boolean zContains = apiPermissionInfo.getApiLevelList(str2).contains(str);
            if (!zContains) {
                RVLogger.d(c, "jsapi_sp_forbidden:" + str2 + " not have permssion");
            }
            return zContains ? ApiPermissionCheckResult.IGNORE : ApiPermissionCheckResult.DENY_N22104;
        }
        List<String> apiLevelList = apiPermissionInfo.getApiLevelList(str2);
        if (apiLevelList != null && !apiLevelList.isEmpty()) {
            Iterator<String> it = apiLevelList.iterator();
            while (it.hasNext()) {
                try {
                    if (PatternUtils.compile(it.next().trim()).matcher(str).find()) {
                        return ApiPermissionCheckResult.IGNORE;
                    }
                    continue;
                } catch (Exception e) {
                    RVLogger.e(c, "hasPermission Regex Exception", e);
                }
            }
        }
        RVLogger.d(c, "jsapi_sp_forbidden:" + str2 + " not have permssion ,not match regex");
        if (TextUtils.equals(str2, com.alibaba.ariver.permission.b.i)) {
            return ApiPermissionCheckResult.DENY_N22105;
        }
        if (str2.startsWith(com.alibaba.ariver.permission.b.h)) {
            return ApiPermissionCheckResult.DENY_N22106;
        }
        if (TextUtils.equals(str2, com.alibaba.ariver.permission.b.f)) {
            return ApiPermissionCheckResult.DENY_N22107;
        }
        if (TextUtils.equals(str2, com.alibaba.ariver.permission.b.j)) {
            return ApiPermissionCheckResult.DENY_N22108;
        }
        if (str2.startsWith(com.alibaba.ariver.permission.b.k)) {
            return ApiPermissionCheckResult.DENY_N22109;
        }
        if (TextUtils.equals(str2, com.alibaba.ariver.permission.b.g)) {
            return ApiPermissionCheckResult.DENY_N22110;
        }
        return ApiPermissionCheckResult.DENY;
    }

    private ApiPermissionCheckResult a(String str, String str2, String str3, Page page) {
        RVLogger.d(c, "hasPermissionOnIframe...url=" + str2);
        return hasPermission(str, str2, str3, page);
    }

    private ApiPermissionCheckResult a(String str, Page page) {
        if (page != null && page.getStartParams() != null && !TextUtils.isEmpty(str)) {
            String string = BundleUtils.getString(page.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
            if (Boolean.valueOf(BundleUtils.getBoolean(page.getStartParams(), RVParams.isTinyApp, false)).booleanValue() && !TextUtils.isEmpty(string)) {
                String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_webview_alipays_whitelist", "");
                if (TextUtils.isEmpty(configWithProcessCache)) {
                    configWithProcessCache = "none";
                }
                if (!"all".equalsIgnoreCase(configWithProcessCache)) {
                    try {
                        for (String str2 : configWithProcessCache.split(",")) {
                            if (string.equalsIgnoreCase(str2)) {
                                RVLogger.d(c, "interceptH5EmbedWebViewWithScheme appid in whiteList " + string);
                                return ApiPermissionCheckResult.IGNORE;
                            }
                        }
                        String strDecode = UrlUtils.decode(str);
                        if (!TextUtils.isEmpty(strDecode) && strDecode.contains("scheme=alipays://platformapi/startapp")) {
                            RVLogger.d(c, "start_app_forbidden:url contain alipay schema");
                            return ApiPermissionCheckResult.DENY_N22206;
                        }
                    } catch (Throwable th) {
                        RVLogger.e(c, "interceptH5EmbedWebViewWithScheme: ", th);
                    }
                    return ApiPermissionCheckResult.IGNORE;
                }
                return ApiPermissionCheckResult.IGNORE;
            }
            return ApiPermissionCheckResult.IGNORE;
        }
        return ApiPermissionCheckResult.IGNORE;
    }

    private boolean a(Bundle bundle, String str) {
        if (!"tyroRequest".equals(str) && !"showRemoteDebugPanel".equals(str) && !"showRemoteDebugMask".equals(str)) {
            return false;
        }
        int i = AnonymousClass2.f24369a[AppInfoScene.extractScene(bundle).ordinal()];
        return (i == 1 || i == 2) ? false : true;
    }
}
