package com.alibaba.triver.support.ui.auth.settings;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.jsapi.security.TBAccessToken;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.extensions.PermissionSettingPointImpl;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.model.ResponseDO;
import com.alibaba.triver.kit.api.model.SubscribeDomainItemModel;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.support.ui.R;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f25188a;

    static {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        f25188a = concurrentHashMap;
        concurrentHashMap.put("getLocation", Integer.valueOf(R.string.triver_location));
        concurrentHashMap.put(com.alibaba.ariver.permission.service.a.c.b, Integer.valueOf(R.string.triver_location));
        concurrentHashMap.put(com.alibaba.ariver.permission.service.a.c.f, Integer.valueOf(R.string.triver_microphone));
        concurrentHashMap.put("scope.scan", Integer.valueOf(R.string.triver_camera));
        concurrentHashMap.put(com.alibaba.ariver.permission.service.a.c.h, Integer.valueOf(R.string.triver_camera));
        concurrentHashMap.put(com.alibaba.ariver.permission.service.a.c.g, Integer.valueOf(R.string.triver_photo));
        concurrentHashMap.put("scope.saveImage", Integer.valueOf(R.string.triver_photo));
        concurrentHashMap.put("scope.stopAudioRecord", Integer.valueOf(R.string.triver_microphone));
        concurrentHashMap.put("scope.cancelAudioRecord", Integer.valueOf(R.string.triver_microphone));
        concurrentHashMap.put("scope.saveVideoToPhotosAlbum", Integer.valueOf(R.string.triver_photo));
        concurrentHashMap.put("scope.shareTokenImageSilent", Integer.valueOf(R.string.triver_photo));
        concurrentHashMap.put(com.alibaba.ariver.permission.service.a.c.f24376a, Integer.valueOf(R.string.triver_userinfo));
        concurrentHashMap.put("scope.addressList", Integer.valueOf(R.string.triver_addresslist));
    }

    public static List<AuthStatusEntity> a(App app) {
        ArrayList arrayList = new ArrayList();
        PermissionSettingPointImpl permissionSettingPointImpl = new PermissionSettingPointImpl();
        permissionSettingPointImpl.setNode(new WeakReference<>(app));
        JSONObject setting = permissionSettingPointImpl.getSetting("", false);
        if (setting != null) {
            JSONObject jSONObject = setting.getJSONObject("authSetting");
            JSONArray jSONArray = setting.getJSONArray("subscriptionsSetting");
            Map<String, Boolean> allPermissions = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getAllPermissions(((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app), app.getAppId(), (AppModel) app.getData(AppModel.class), app, app.getActivePage());
            for (String str : allPermissions.keySet()) {
                AuthStatusEntity authStatusEntity = new AuthStatusEntity();
                authStatusEntity.a(AuthStatusEntity.AuthType.Device);
                authStatusEntity.b(allPermissions.get(str).booleanValue());
                authStatusEntity.a(str);
                authStatusEntity.b(a(str, (AppModel) app.getData(AppModel.class), (DynamicPluginInfo) app.getData(DynamicPluginInfo.class)));
                arrayList.add(authStatusEntity);
            }
            if (jSONObject != null) {
                for (String str2 : jSONObject.keySet()) {
                    if (!allPermissions.containsKey(str2)) {
                        AuthStatusEntity authStatusEntity2 = new AuthStatusEntity();
                        authStatusEntity2.a(AuthStatusEntity.AuthType.UserInfo);
                        authStatusEntity2.b(jSONObject.getBooleanValue(str2));
                        authStatusEntity2.a(str2);
                        authStatusEntity2.b(a(str2, (AppModel) app.getData(AppModel.class), (DynamicPluginInfo) app.getData(DynamicPluginInfo.class)));
                        arrayList.add(authStatusEntity2);
                    }
                }
            }
            if (jSONArray != null) {
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    SubscribeDomainItemModel subscribeDomainItemModel = (SubscribeDomainItemModel) JSON.parseObject(jSONArray.getString(i), SubscribeDomainItemModel.class);
                    AuthStatusEntity authStatusEntity3 = new AuthStatusEntity();
                    authStatusEntity3.b(subscribeDomainItemModel.getDomainName());
                    authStatusEntity3.a(AuthStatusEntity.AuthType.Subscribe);
                    authStatusEntity3.a(subscribeDomainItemModel.getDomainKey());
                    authStatusEntity3.b(SubscribeResouceItemModel.ACCEPT.equalsIgnoreCase(subscribeDomainItemModel.getStatus()));
                    authStatusEntity3.c(subscribeDomainItemModel.getTipLabel());
                    if (subscribeDomainItemModel.getResourceItems() != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (SubscribeResouceItemModel subscribeResouceItemModel : subscribeDomainItemModel.getResourceItems()) {
                            AuthStatusEntity authStatusEntity4 = new AuthStatusEntity();
                            authStatusEntity4.a(AuthStatusEntity.AuthType.Subscribe);
                            authStatusEntity4.b(subscribeResouceItemModel.getName());
                            authStatusEntity4.b(SubscribeResouceItemModel.ACCEPT.equalsIgnoreCase(subscribeResouceItemModel.getStatus()));
                            authStatusEntity4.a(subscribeResouceItemModel.getResourceKey());
                            arrayList2.add(authStatusEntity4);
                        }
                        authStatusEntity3.a(arrayList2);
                    }
                    arrayList.add(authStatusEntity3);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x004a  */
    @Deprecated
    public static List<StatusItemEntity> b(final AppModel appModel, @Nullable final DynamicPluginInfo dynamicPluginInfo, boolean z) {
        TBAccessToken tBAccessToken;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (z) {
            String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), a(appModel.getAppId(), appModel.getAppInfoModel().getAppKey() + "token"));
            if (TextUtils.isEmpty(string)) {
                tBAccessToken = null;
            } else {
                tBAccessToken = new TBAccessToken(string);
            }
        } else {
            tBAccessToken = null;
        }
        final TBAccessToken tBAccessToken2 = tBAccessToken;
        if (tBAccessToken2 != null && !tBAccessToken2.isFailure()) {
            final String appId = appModel.getAppId();
            final Bundle bundle = null;
            RequestParams requestParams = new RequestParams(appId, bundle) { // from class: com.alibaba.triver.support.ui.auth.settings.StatusGetter$1
                @Override // com.alibaba.triver.kit.api.model.RequestParams
                public Map<String, Object> toMap() {
                    HashMap map = new HashMap();
                    JSONArray jSONArray = new JSONArray();
                    for (String str : new HashSet(com.alibaba.triver.support.ui.b.a(appModel, dynamicPluginInfo))) {
                        if (!TextUtils.isEmpty(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), c.a(appModel.getAppId(), str + "scope")))) {
                            jSONArray.add(str);
                        }
                    }
                    map.put("scopes", jSONArray.toJSONString());
                    map.put("accessToken", tBAccessToken2.accessToken);
                    return map;
                }
            };
            requestParams.api = "mtop.taobao.miniapp.auth.check";
            requestParams.version = "1.0";
            ResponseDO responseDOExecute = ((INetworkProxy) RVProxy.get(INetworkProxy.class)).execute(requestParams);
            if (responseDOExecute.success) {
                try {
                    byte[] bArr = responseDOExecute.data;
                    if (bArr != null && bArr.length > 0) {
                        String str = new String(bArr, Charset.forName("UTF-8"));
                        if (!TextUtils.isEmpty(str) && (jSONObject = JSON.parseObject(str).getJSONObject("data")) != null && !jSONObject.isEmpty() && (jSONObject2 = jSONObject.getJSONObject("authStatus")) != null && !jSONObject2.isEmpty()) {
                            for (String str2 : jSONObject2.keySet()) {
                                StatusItemEntity statusItemEntity = new StatusItemEntity();
                                statusItemEntity.scopeName = str2;
                                statusItemEntity.displayName = a(str2, appModel, dynamicPluginInfo);
                                statusItemEntity.hasAccess = jSONObject2.getBoolean(str2).booleanValue();
                                statusItemEntity.isLocalApi = false;
                                arrayList.add(statusItemEntity);
                                hashSet.add(str2);
                            }
                        }
                    }
                } catch (Exception e) {
                    RVLogger.e("StatusGetter", "requestRecentlyApp onSuccess parseObject error", e);
                }
            } else {
                if (TextUtils.equals(responseDOExecute.errorCode, "FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR")) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(appModel.getAppId(), a(appModel.getAppId(), appModel.getAppInfoModel().getAppKey() + "token"));
                }
                byte[] bArr2 = responseDOExecute.data;
                if (bArr2 != null && TextUtils.equals("[\"FAIL_SYS_AUTH_CHECK_FAILED::TOPAUTH_ACCESSTOKEN_EXPIRED\"]", JSON.parseObject(new String(bArr2)).getString("ret"))) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(appModel.getAppId(), a(appModel.getAppId(), appModel.getAppInfoModel().getAppKey() + "token"));
                }
            }
        }
        for (String str3 : new HashSet(com.alibaba.triver.support.ui.b.a(appModel, dynamicPluginInfo))) {
            if (!hashSet.contains(str3)) {
                if (!TextUtils.isEmpty(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), a(appModel.getAppId(), str3 + "scope")))) {
                    StatusItemEntity statusItemEntity2 = new StatusItemEntity();
                    statusItemEntity2.scopeName = str3;
                    statusItemEntity2.displayName = a(str3, appModel, dynamicPluginInfo);
                    statusItemEntity2.hasAccess = false;
                    statusItemEntity2.isLocalApi = false;
                    arrayList.add(statusItemEntity2);
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public static List<StatusItemEntity> a(AppModel appModel, @Nullable DynamicPluginInfo dynamicPluginInfo) {
        return a(appModel, dynamicPluginInfo, true);
    }

    @Deprecated
    public static List<StatusItemEntity> a(AppModel appModel, @Nullable DynamicPluginInfo dynamicPluginInfo, boolean z) {
        Map<String, Boolean> allPermissions;
        ArrayList arrayList = new ArrayList();
        AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        if (authenticationProxy != null && (allPermissions = authenticationProxy.getAllPermissions(((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(null), appModel.getAppId(), appModel, (App) null, (Page) null)) != null && allPermissions.size() > 0) {
            for (String str : allPermissions.keySet()) {
                StatusItemEntity statusItemEntity = new StatusItemEntity();
                statusItemEntity.isLocalApi = true;
                statusItemEntity.appId = appModel.getAppId();
                statusItemEntity.hasAccess = allPermissions.get(str).booleanValue();
                statusItemEntity.scopeName = str;
                statusItemEntity.displayName = a(str, appModel, dynamicPluginInfo);
                arrayList.add(statusItemEntity);
            }
        }
        arrayList.addAll(b(appModel, dynamicPluginInfo, z));
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0033  */
    private static String a(String str, AppModel appModel, DynamicPluginInfo dynamicPluginInfo) {
        String string;
        PermissionModel permissionModelGenerateFromJSON;
        PermissionModel permissionModelGenerateFromJSON2;
        if (appModel != null) {
            try {
                if (appModel.getPermissionModel() == null || appModel.getPermissionModel().getNativeApiScopeConfig() == null || appModel.getPermissionModel().getNativeApiScopeConfig().getJSONObject(str) == null) {
                    string = null;
                } else {
                    string = appModel.getPermissionModel().getNativeApiScopeConfig().getJSONObject(str).getString("name");
                }
            } catch (Exception unused) {
                return InternationalUtil.getString(f25188a.get(str).intValue());
            }
        } else {
            string = null;
        }
        if (string == null && appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null) {
            for (PluginModel pluginModel : appModel.getAppInfoModel().getPlugins()) {
                if (pluginModel != null && pluginModel.getPermission() != null && (permissionModelGenerateFromJSON2 = PermissionModel.generateFromJSON(pluginModel.getPermission())) != null && permissionModelGenerateFromJSON2.getNativeApiScopeConfig() != null && permissionModelGenerateFromJSON2.getNativeApiScopeConfig().getJSONObject(str) != null) {
                    string = permissionModelGenerateFromJSON2.getNativeApiScopeConfig().getJSONObject(str).getString("name");
                    break;
                }
            }
        }
        if (string == null && dynamicPluginInfo != null && dynamicPluginInfo.getPluginModels() != null) {
            for (PluginModel pluginModel2 : dynamicPluginInfo.getPluginModels()) {
                if (pluginModel2 != null && pluginModel2.getPermission() != null && (permissionModelGenerateFromJSON = PermissionModel.generateFromJSON(pluginModel2.getPermission())) != null && permissionModelGenerateFromJSON.getNativeApiScopeConfig() != null && permissionModelGenerateFromJSON.getNativeApiScopeConfig().getJSONObject(str) != null) {
                    string = permissionModelGenerateFromJSON.getNativeApiScopeConfig().getJSONObject(str).getString("name");
                    break;
                }
            }
        }
        return string == null ? InternationalUtil.getString(f25188a.get(str).intValue()) : string;
    }

    public static String a(String str, String str2) {
        return ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(null) + "_appid_" + str + "_key_" + str2;
    }
}
