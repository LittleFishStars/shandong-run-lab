package com.alibaba.ariver.jsapi.security;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.jsapi.R;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.APAccountService;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.api.RVFlag;
import com.alibaba.ariver.permission.api.extension.PermissionGuildePoint;
import com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.constant.PermissionConstants;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.xh9;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OpenAuthExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24173a = "AriverPermission:OpenAuthExtension";
    private static final Set<String> b;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("SELFSTARTING");
        hashSet.add("ADDRESSBOOK");
        hashSet.add(PermissionConstants.b);
        hashSet.add("PHOTO");
        hashSet.add("LBS");
        hashSet.add("NOTIFICATION");
        hashSet.add(PermissionConstants.e);
        hashSet.add("SHINFO");
        hashSet.add("SHORTCUT");
        hashSet.add("BACKGROUNDER");
    }

    private void a(final App app, final ApiContext apiContext, final BridgeCallback bridgeCallback) {
        ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.jsapi.security.OpenAuthExtension.1
            @Override // java.lang.Runnable
            public void run() {
                bridgeCallback.sendJSONResponse(a.a(app, apiContext));
            }
        });
    }

    public void auth(String str, JSONArray jSONArray, JSONObject jSONObject, String str2, String str3, boolean z, Map<String, String> map, App app, @Nullable Page page, BridgeCallback bridgeCallback, Bundle bundle) {
        String strConvertPlatform;
        Bundle startParams;
        String startUrl;
        String str4;
        String str5;
        String str6;
        if (app == null || app.getStartParams() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (page != null && (page.isExited() || page.isDestroyed())) {
            RVLogger.w(f24173a, "auth but page is exited!");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error", "11");
            jSONObject2.put("message", (Object) LangResourceUtil.getString(R.string.ariver_jsapi_page_exited));
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, (Object) LangResourceUtil.getString(R.string.ariver_jsapi_page_exited));
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            strConvertPlatform = rVEnvironmentService == null ? "AP" : (appModel == null || appModel.getAppInfoModel() == null) ? str : rVEnvironmentService.convertPlatform(appModel.getAppInfoModel().getOrigin());
            if (TextUtils.isEmpty(strConvertPlatform)) {
                strConvertPlatform = rVEnvironmentService.defaultPlatform();
            }
        } else {
            strConvertPlatform = str;
        }
        if (page != null) {
            startParams = page.getStartParams();
            startUrl = page.getPageURI();
        } else {
            startParams = app.getStartParams();
            startUrl = app.getStartUrl();
        }
        boolean z2 = BundleUtils.getBoolean(startParams, RVParams.isTinyApp, false);
        boolean zContains = BundleUtils.contains(startParams, "MINI-PROGRAM-WEB-VIEW-TAG");
        String string = BundleUtils.getString(startParams, "appId");
        if (z2 && TextUtils.isEmpty(string)) {
            string = BundleUtils.getString(startParams, "MINI-PROGRAM-WEB-VIEW-TAG");
            RVLogger.d(f24173a, "try get appId from MINI_PROGRAM_WEBVIEW_TAG: " + string);
        }
        boolean zEquals = "miniservice".equals(BundleUtils.getString(startParams, "tinySource"));
        String string2 = zEquals ? BundleUtils.getString(startParams, RVConstants.EXTRA_PARENT_APP_ID) : string;
        String str7 = string;
        RVLogger.d(f24173a, "appId is " + string2 + ", appVersion is " + BundleUtils.getString(startParams, "appVersion") + ", thirdPlatform is " + string2 + ", isTinyEmbedH5Page " + zContains);
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && !jSONArray.isEmpty()) {
            RVLogger.d(f24173a, "scopeNicksArray is " + jSONArray.toJSONString());
            for (int i = 0; i < jSONArray.size(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        if (zContains || !z2) {
            RVLogger.d(f24173a, "isTinyEmbedH5Page || !isTinyApp");
            String str8 = !TextUtils.isEmpty(str2) ? str2 : string2;
            if (TextUtils.isEmpty(str8)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
                return;
            }
            str4 = str8;
        } else {
            str4 = string2;
        }
        RVLogger.d(f24173a, "isvAppId is " + str3);
        Map<String, String> mapJsonToMap = JSONUtils.jsonToMap(jSONObject, new HashMap());
        if (mapJsonToMap != null) {
            RVLogger.d(f24173a, "extInfo is " + mapJsonToMap.toString());
        }
        HashMap map2 = new HashMap();
        map2.put(xh9.WEBSITE_PARAMS_CHANNEL, (!z2 || zContains) ? "h5" : "tinyapp");
        map2.put("clientAppId", (!z2 || zContains) ? str4 : string2);
        String string3 = BundleUtils.getString(startParams, "authBizId");
        String string4 = BundleUtils.getString(startParams, "authBizType");
        if (!TextUtils.isEmpty(string3)) {
            map2.put("bizId", string3);
            RVLogger.d(f24173a, "put bizId AuthBizId = " + string3 + "in appExtInfo");
        }
        if (!TextUtils.isEmpty(string4)) {
            map2.put("bizType", string4);
            RVLogger.d(f24173a, "put bizType authBizType = " + string4 + "in appExtInfo");
        }
        if (map != null) {
            map2.putAll(map);
        }
        RVLogger.d(f24173a, "appExtInfo is " + map2.toString());
        if (zEquals) {
            str6 = null;
            str5 = str7;
        } else {
            str5 = str3;
        }
        if (z2) {
            str6 = startUrl;
            if (TextUtils.isEmpty(str6)) {
                RVLogger.d(f24173a, "url is empty use default url");
                str6 = "https://" + string2 + ".hybrid.alipay-eco.com";
            }
        }
        str6 = startUrl;
        if (app.getAppContext() == null || app.getAppContext().getContext() == null) {
            RVLogger.w(f24173a, "auth but context  == null!");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("error", "11");
            jSONObject3.put("message", (Object) LangResourceUtil.getString(R.string.ariver_jsapi_page_exited));
            bridgeCallback.sendJSONResponse(jSONObject3);
            return;
        }
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null && !TextUtils.isEmpty(str6) && "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_enableEncodeAuthUrl", "yes"))) {
            try {
                new URI(str6);
            } catch (URISyntaxException e) {
                String strEncodeOffilineUrlForAuth = UrlUtils.encodeOffilineUrlForAuth(str6);
                RVLogger.e(f24173a, "auth url = " + strEncodeOffilineUrlForAuth, e);
                str6 = strEncodeOffilineUrlForAuth;
            }
        }
        new com.alibaba.ariver.permission.extension.auth.a(app.getAppContext().getContext(), app, bridgeCallback, BundleUtils.getString(startParams, RVParams.SESSION_ID)).a(strConvertPlatform, page, str4, str6, arrayList, str5, mapJsonToMap, z, map2, bundle);
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getAuthCode(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({com.alipay.sdk.m.w.a.A}) JSONObject jSONObject, @BindingParam({"appId"}) String str2, @BindingParam({"isvAppId"}) String str3, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingParam({"landscape"}) String str4, @BindingParam({RVStartParams.KEY_GAME_MODE}) String str5, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingRequest JSONObject jSONObject2, @BindingApiContext ApiContext apiContext) {
        String pluginId;
        if (((GetAuthCodeInterceptPoint) ExtensionPoint.as(GetAuthCodeInterceptPoint.class).node(app).create()).interceptGetAuthCode(page, apiContext, jSONObject2, bridgeCallback)) {
            return;
        }
        if (TextUtils.isEmpty(apiContext.getPluginId())) {
            pluginId = str3;
        } else {
            RVLogger.d(f24173a, "getAuthCode get isvAppId from pluginId: " + apiContext.getPluginId());
            pluginId = apiContext.getPluginId();
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString("landscape", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            bundle.putString(RVStartParams.KEY_GAME_MODE, str5);
        }
        auth(str, jSONArray, jSONObject, str2, pluginId, z, null, app, page, bridgeCallback, bundle);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getAuthUserInfo(@BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({com.alipay.sdk.m.w.a.A}) JSONObject jSONObject, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingNode(App.class) App app, @BindingParam({"platform"}) String str, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        String string = BundleUtils.getString(app.getStartParams(), RVParams.SESSION_ID);
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (TextUtils.isEmpty(str)) {
            str = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).defaultPlatform();
        }
        if (appModel != null && appModel.getAppInfoModel() != null && rVEnvironmentService != null) {
            str = rVEnvironmentService.convertPlatform(appModel.getAppInfoModel().getOrigin());
        }
        if (TextUtils.equals("TB", str)) {
            a(app, apiContext, bridgeCallback);
            return;
        }
        if (RVFlag.getOpenAuthGrantFlag(string)) {
            a(bridgeCallback);
            return;
        }
        RVLogger.d(f24173a, "getAuthUserInfo not granted, sessionId is " + string);
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(10, LangResourceUtil.getString(R.string.ariver_jsapi_unauthorized_user_info)));
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getAuthorize(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({com.alipay.sdk.m.w.a.A}) JSONObject jSONObject, @BindingParam({"appId"}) String str2, @BindingParam({"isvAppId"}) String str3, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        String pluginId;
        if (!BundleUtils.getBoolean(app.getStartParams(), RVParams.isTinyApp, false)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
            return;
        }
        HashMap map = new HashMap();
        map.put("callMethod", "getAuthorize");
        if (TextUtils.isEmpty(apiContext.getPluginId())) {
            pluginId = str3;
        } else {
            RVLogger.d(f24173a, "getAuthorize get isvAppId from pluginId: " + apiContext.getPluginId());
            pluginId = apiContext.getPluginId();
        }
        auth(str, jSONArray, jSONObject, str2, pluginId, z, map, app, page, bridgeCallback, null);
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getBusinessAuth(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({com.alipay.sdk.m.w.a.A}) JSONObject jSONObject, @BindingParam({"appId"}) String str2, @BindingParam({"isvAppId"}) String str3, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        String pluginId;
        if (!BundleUtils.getBoolean(app.getStartParams(), RVParams.isTinyApp, false)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
            return;
        }
        HashMap map = new HashMap();
        map.put("callMethod", "getBusinessAuth");
        if (TextUtils.isEmpty(apiContext.getPluginId())) {
            pluginId = str3;
        } else {
            RVLogger.d(f24173a, "getBusinessAuth get isvAppId from pluginId: " + apiContext.getPluginId());
            pluginId = apiContext.getPluginId();
        }
        auth(str, jSONArray, jSONObject, str2, pluginId, z, map, app, page, bridgeCallback, null);
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getComponentAuth(@BindingParam({"platform"}) String str, @BindingParam({"scopeNicks"}) JSONArray jSONArray, @BindingParam({com.alipay.sdk.m.w.a.A}) JSONObject jSONObject, @BindingParam({"appId"}) String str2, @BindingParam({"isvAppId"}) String str3, @BindingParam(booleanDefault = true, value = {"showErrorTip"}) boolean z, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingApiContext ApiContext apiContext) {
        String pluginId;
        if (!BundleUtils.getBoolean(app.getStartParams(), RVParams.isTinyApp, false)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
            return;
        }
        HashMap map = new HashMap();
        map.put("callMethod", "getComponentAuth");
        if (TextUtils.isEmpty(apiContext.getPluginId())) {
            pluginId = str3;
        } else {
            RVLogger.d(f24173a, "getComponentAuth get isvAppId from pluginId: " + apiContext.getPluginId());
            pluginId = apiContext.getPluginId();
        }
        auth(str, jSONArray, jSONObject, str2, pluginId, z, map, app, page, bridgeCallback, null);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void showAuthGuide(@BindingParam({"issue"}) String str, @BindingParam({"source"}) String str2, @BindingParam({"option"}) String str3, @BindingParam({"authType"}) String str4, @BindingParam({"bizType"}) String str5, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str4) || !b.contains(str4) || TextUtils.isEmpty(str5)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        RVLogger.d(f24173a, "showAuthGuide bizType = " + str5);
        boolean zStartPermissionGuide = ((PermissionGuildePoint) ExtensionPoint.as(PermissionGuildePoint.class).node(app).create()).startPermissionGuide(str4, str5);
        RVLogger.d(f24173a, "showAuthGuide, isShown: " + zStartPermissionGuide);
        jSONObject.put("shown", (Object) Boolean.valueOf(zStartPermissionGuide));
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private void a(BridgeCallback bridgeCallback) {
        APAccountService aPAccountService = (APAccountService) RVProxy.get(APAccountService.class);
        if (aPAccountService == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(UserConstants.USER_PARAMS.b, (Object) aPAccountService.getNick());
        jSONObject.put("avatar", (Object) aPAccountService.getUserAvatar());
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
