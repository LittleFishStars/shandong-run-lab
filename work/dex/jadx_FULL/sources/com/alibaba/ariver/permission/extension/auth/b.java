package com.alibaba.ariver.permission.extension.auth;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.permission.openauth.model.request.AuthExecuteRequestModel;
import com.alibaba.ariver.permission.openauth.model.request.AuthSkipRequestModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthAgreementModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthContentResultModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthExecuteResultModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.content.PluginResourcePackage;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static AuthSkipResultModel a(String str, App app, AuthSkipRequestModel authSkipRequestModel) {
        byte[] bArr;
        JSONObject jSONObject;
        AuthSkipResultModel authSkipResultModel = new AuthSkipResultModel();
        String str2 = authSkipRequestModel.getAppExtInfo().get("callMethod");
        if (authSkipRequestModel.getScopeNicks() == null || authSkipRequestModel.getScopeNicks().size() != 1) {
            authSkipResultModel.setSuccess(Boolean.FALSE);
            authSkipResultModel.setErrorCode(String.valueOf(((BridgeResponse.Error) BridgeResponse.INVALID_PARAM).getErrorCode()));
            authSkipResultModel.setErrorMsg(((BridgeResponse.Error) BridgeResponse.INVALID_PARAM).getErrorMessage());
            return authSkipResultModel;
        }
        if (TextUtils.equals("getAuthCode", str2)) {
            authSkipResultModel.setSuccess(Boolean.FALSE);
            BridgeResponse.Error error = (BridgeResponse.Error) BridgeResponse.FORBIDDEN_ERROR;
            authSkipResultModel.setErrorCode(String.valueOf(error.getErrorCode()));
            authSkipResultModel.setErrorMsg(error.getErrorMessage());
            return authSkipResultModel;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (!a(appModel, authSkipRequestModel.getIsvAppId())) {
            Boolean bool = Boolean.TRUE;
            authSkipResultModel.setSuccess(bool);
            authSkipResultModel.setCanSkipAuth(bool);
            authSkipResultModel.setAuthExecuteResult(new AuthExecuteResultModel());
            authSkipResultModel.getAuthExecuteResult().setSuccessScopes(authSkipRequestModel.getScopeNicks());
            return authSkipResultModel;
        }
        if (((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(authSkipRequestModel.getIsvAppId())) {
            Boolean bool2 = Boolean.TRUE;
            authSkipResultModel.setSuccess(bool2);
            authSkipResultModel.setCanSkipAuth(bool2);
            authSkipResultModel.setAuthExecuteResult(new AuthExecuteResultModel());
            authSkipResultModel.getAuthExecuteResult().setSuccessScopes(authSkipRequestModel.getScopeNicks());
            return authSkipResultModel;
        }
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        if (kVStorageProxy != null) {
            String string = kVStorageProxy.getString(authSkipRequestModel.getAppId(), a(app, appModel.getAppInfoModel().getAppKey() + "token"));
            if (TextUtils.isEmpty(string)) {
                a(app);
            } else {
                JSONObject object = JSON.parseObject(string);
                String string2 = object.getString("accessToken");
                long jLongValue = object.getLong("expirationTime").longValue();
                if (TextUtils.isEmpty(string2) || jLongValue <= System.currentTimeMillis()) {
                    a(app);
                } else {
                    boolean zEquals = true;
                    for (String str3 : authSkipRequestModel.getScopeNicks()) {
                        zEquals &= TextUtils.equals("true", ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(authSkipRequestModel.getAppId(), a(app, str3 + "scope")));
                    }
                    if (zEquals) {
                        Boolean bool3 = Boolean.TRUE;
                        authSkipResultModel.setSuccess(bool3);
                        authSkipResultModel.setCanSkipAuth(bool3);
                        authSkipResultModel.setAuthExecuteResult(new AuthExecuteResultModel());
                        authSkipResultModel.getAuthExecuteResult().setSuccessScopes(authSkipRequestModel.getScopeNicks());
                        Map<String, String> extInfo = authSkipResultModel.getAuthExecuteResult().getExtInfo();
                        if (extInfo == null) {
                            extInfo = new HashMap<>();
                        }
                        extInfo.put("accessToken", string2);
                        authSkipResultModel.getAuthExecuteResult().setExtInfo(extInfo);
                        return authSkipResultModel;
                    }
                }
            }
        }
        String appId = appModel.getAppId();
        if (appModel.getAppInfoModel().getTemplateConfig() != null && appModel.getAppInfoModel().getTemplateConfig().getTemplateId() != null) {
            appId = appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
        }
        if (!TextUtils.isEmpty(authSkipRequestModel.getIsvAppId())) {
            appId = authSkipRequestModel.getIsvAppId();
        }
        SendMtopParams sendMtopParams = new SendMtopParams(appModel.getAppId(), app.getStartParams());
        sendMtopParams.addData("mainAppId", appModel.getAppId());
        sendMtopParams.addData("invokerAppId", appId);
        if (authSkipRequestModel.getScopeNicks() != null && authSkipRequestModel.getScopeNicks().size() > 0) {
            sendMtopParams.addData("scopeName", authSkipRequestModel.getScopeNicks().get(0));
        }
        if (TextUtils.equals("getComponentAuth", str2) || TextUtils.equals("getBusinessAuth", str2) || TextUtils.equals("authorize", str2) || TextUtils.equals("getAuthorize", str2)) {
            sendMtopParams.addData("authChannel", str2);
        } else {
            sendMtopParams.addData("authChannel", "getAuthorize");
        }
        sendMtopParams.api = "mtop.taobao.openlink.miniapp.auth.alert";
        sendMtopParams.needLogin = true;
        sendMtopParams.v = "1.0";
        HashMap map = new HashMap();
        map.put("appId", appId);
        sendMtopParams.setHeaders(map);
        SendMtopResponse sendMtopResponseRequestInnerSync = ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerSync(sendMtopParams);
        if (sendMtopResponseRequestInnerSync != null) {
            if (sendMtopResponseRequestInnerSync.success && (bArr = sendMtopResponseRequestInnerSync.data) != null && bArr.length > 0) {
                String str4 = new String(bArr, Charset.forName("UTF-8"));
                if (!TextUtils.isEmpty(str4) && (jSONObject = JSON.parseObject(str4).getJSONObject("data")) != null && !jSONObject.isEmpty()) {
                    Boolean bool4 = Boolean.TRUE;
                    authSkipResultModel.setSuccess(bool4);
                    authSkipResultModel.setAuthContentResult(new AuthContentResultModel());
                    authSkipResultModel.getAuthContentResult().setAppName(jSONObject.getString("appName"));
                    authSkipResultModel.getAuthContentResult().setAppLogoLink(jSONObject.getString("appLogoLink"));
                    authSkipResultModel.getAuthContentResult().setAgreements(new ArrayList());
                    authSkipResultModel.getAuthContentResult().setIsvAgent(Boolean.FALSE);
                    String string3 = jSONObject.getString("appAlias");
                    if (!TextUtils.isEmpty(string3)) {
                        Map<String, String> extInfo2 = authSkipResultModel.getAuthContentResult().getExtInfo();
                        if (extInfo2 == null) {
                            extInfo2 = new HashMap<>();
                        }
                        extInfo2.put("appAlias", string3);
                        authSkipResultModel.getAuthContentResult().setExtInfo(extInfo2);
                    }
                    authSkipResultModel.getAuthContentResult().setAuthText(JSONUtils.toStringArray(jSONObject.getJSONArray("authText")));
                    authSkipResultModel.getAuthContentResult().setSuccess(bool4);
                    JSONArray jSONArray = jSONObject.getJSONArray("agreements");
                    if (jSONArray != null) {
                        int size = jSONArray.size();
                        for (int i = 0; i < size; i++) {
                            AuthAgreementModel authAgreementModel = new AuthAgreementModel();
                            authAgreementModel.setLink(jSONArray.getJSONObject(i).getString("link"));
                            authAgreementModel.setName(jSONArray.getJSONObject(i).getString("name"));
                            authSkipResultModel.getAuthContentResult().getAgreements().add(authAgreementModel);
                        }
                    }
                    authSkipResultModel.setSuccess(Boolean.TRUE);
                    return authSkipResultModel;
                }
            }
            authSkipResultModel.setSuccess(Boolean.FALSE);
            authSkipResultModel.setErrorCode(sendMtopResponseRequestInnerSync.errorCode);
            authSkipResultModel.setErrorMsg(sendMtopResponseRequestInnerSync.errorMsg);
            authSkipResultModel.setData(sendMtopResponseRequestInnerSync.data);
        }
        return authSkipResultModel;
    }

    private static void a(App app) {
        JSONObject nativeApiScopeConfig;
        PermissionModel permissionModel = ((AppModel) app.getData(AppModel.class)).getPermissionModel();
        if (permissionModel == null || (nativeApiScopeConfig = permissionModel.getNativeApiScopeConfig()) == null) {
            return;
        }
        for (String str : nativeApiScopeConfig.keySet()) {
            if ("true".equals(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(app.getAppId(), a(app, str + "scope")))) {
                ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(app.getAppId(), a(app, str + "scope"));
            }
        }
    }

    public static AuthExecuteResultModel a(App app, AuthExecuteRequestModel authExecuteRequestModel) {
        String string;
        long jLongValue;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        AuthExecuteResultModel authExecuteResultModel = new AuthExecuteResultModel();
        if (TextUtils.equals("getAuthCode", authExecuteRequestModel.getAppExtInfo().get("callMethod"))) {
            authExecuteResultModel.setSuccess(Boolean.FALSE);
            BridgeResponse.Error error = (BridgeResponse.Error) BridgeResponse.FORBIDDEN_ERROR;
            authExecuteResultModel.setErrorCode(String.valueOf(error.getErrorCode()));
            authExecuteResultModel.setErrorMsg(error.getErrorMessage());
            return authExecuteResultModel;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        String appId = appModel.getAppId();
        if (appModel.getAppInfoModel().getTemplateConfig() != null && appModel.getAppInfoModel().getTemplateConfig().getTemplateId() != null) {
            appId = appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
        }
        if (!TextUtils.isEmpty(authExecuteRequestModel.getIsvAppId())) {
            appId = authExecuteRequestModel.getIsvAppId();
        }
        String string2 = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), a(app, appModel.getAppInfoModel().getAppKey() + "token"));
        if (TextUtils.isEmpty(string2)) {
            string = null;
            jLongValue = 0;
        } else {
            JSONObject object = JSON.parseObject(string2);
            string = object.getString("accessToken");
            jLongValue = object.getLong("expirationTime").longValue();
        }
        String str = "true";
        String str2 = "scope";
        String str3 = "publicInfo";
        if (!TextUtils.isEmpty(string) && jLongValue > System.currentTimeMillis()) {
            SendMtopParams sendMtopParams = new SendMtopParams(appModel.getAppId(), app.getStartParams());
            sendMtopParams.addData("accessToken", string);
            JSONObject jSONObject3 = new JSONObject();
            Iterator<String> it = authExecuteRequestModel.getScopeNicks().iterator();
            while (it.hasNext()) {
                jSONObject3.put(it.next(), (Object) Boolean.TRUE);
                it = it;
                str3 = str3;
            }
            String str4 = str3;
            sendMtopParams.addData("mainAppId", appModel.getAppId());
            sendMtopParams.addData("invokerAppId", appId);
            sendMtopParams.addData("scopeAuthDiffs", jSONObject3.toJSONString());
            sendMtopParams.api = "mtop.taobao.miniapp.auth.change";
            sendMtopParams.v = "1.0";
            sendMtopParams.needLogin = true;
            HashMap map = new HashMap();
            map.put("appId", appId);
            sendMtopParams.setHeaders(map);
            SendMtopResponse sendMtopResponseRequestInnerSync = ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerSync(sendMtopParams);
            if (sendMtopResponseRequestInnerSync != null && sendMtopResponseRequestInnerSync.success) {
                try {
                    byte[] bArr = sendMtopResponseRequestInnerSync.data;
                    if (bArr != null && bArr.length > 0) {
                        String str5 = new String(bArr, Charset.forName("UTF-8"));
                        if (!TextUtils.isEmpty(str5) && (jSONObject2 = JSON.parseObject(str5).getJSONObject("data")) != null && !jSONObject2.isEmpty()) {
                            authExecuteResultModel.setSuccess(Boolean.TRUE);
                            for (String str6 : authExecuteRequestModel.getScopeNicks()) {
                                KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
                                String appId2 = authExecuteRequestModel.getAppId();
                                StringBuilder sb = new StringBuilder();
                                sb.append(str6);
                                String str7 = str2;
                                sb.append(str7);
                                String str8 = str;
                                kVStorageProxy.putString(appId2, a(app, sb.toString()), str8);
                                str2 = str7;
                                str = str8;
                            }
                            try {
                                Map<String, String> extInfo = authExecuteResultModel.getExtInfo();
                                if (extInfo == null) {
                                    extInfo = new HashMap<>();
                                }
                                extInfo.put("accessToken", string);
                                if (jSONObject2.containsKey(str4)) {
                                    extInfo.put(str4, jSONObject2.getJSONObject(str4).toJSONString());
                                }
                                authExecuteResultModel.setExtInfo(extInfo);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            authExecuteResultModel.setSuccessScopes(authExecuteRequestModel.getScopeNicks());
                        }
                    }
                } catch (Exception e2) {
                    authExecuteResultModel.setSuccess(Boolean.FALSE);
                    authExecuteResultModel.setErrorCode(String.valueOf(6));
                    authExecuteResultModel.setErrorMsg(e2.getMessage());
                    RVLogger.e("TRVLink", "requestRecentlyApp onSuccess parseObject error", e2);
                }
            } else if (sendMtopResponseRequestInnerSync != null) {
                authExecuteResultModel.setSuccess(Boolean.FALSE);
                authExecuteResultModel.setErrorCode(sendMtopResponseRequestInnerSync.errorCode);
                authExecuteResultModel.setErrorMsg(sendMtopResponseRequestInnerSync.errorMsg);
                authExecuteResultModel.setData(sendMtopResponseRequestInnerSync.data);
            }
        } else {
            SendMtopParams sendMtopParams2 = new SendMtopParams(appModel.getAppId(), app.getStartParams());
            JSONArray jSONArray = new JSONArray();
            jSONArray.addAll(authExecuteRequestModel.getScopeNicks());
            sendMtopParams2.addData("mainAppId", appModel.getAppId());
            sendMtopParams2.addData("invokerAppId", appId);
            sendMtopParams2.addData("authScopes", jSONArray.toJSONString());
            sendMtopParams2.api = "mtop.taobao.openlink.miniapp.auth.token.get";
            sendMtopParams2.v = "1.0";
            sendMtopParams2.needLogin = true;
            HashMap map2 = new HashMap();
            map2.put("appId", appId);
            sendMtopParams2.setHeaders(map2);
            SendMtopResponse sendMtopResponseRequestInnerSync2 = ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerSync(sendMtopParams2);
            if (sendMtopResponseRequestInnerSync2 != null && sendMtopResponseRequestInnerSync2.success) {
                try {
                    byte[] bArr2 = sendMtopResponseRequestInnerSync2.data;
                    if (bArr2 != null && bArr2.length > 0) {
                        String str9 = new String(bArr2, Charset.forName("UTF-8"));
                        if (!TextUtils.isEmpty(str9) && (jSONObject = JSON.parseObject(str9).getJSONObject("data")) != null && !jSONObject.isEmpty()) {
                            authExecuteResultModel.setSuccess(Boolean.TRUE);
                            ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(authExecuteRequestModel.getAppId(), a(app, ((AppModel) app.getData(AppModel.class)).getAppInfoModel().getAppKey() + "token"), jSONObject.toJSONString());
                            for (String str10 : authExecuteRequestModel.getScopeNicks()) {
                                ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(authExecuteRequestModel.getAppId(), a(app, str10 + str2), str);
                            }
                            authExecuteResultModel.setSuccessScopes(authExecuteRequestModel.getScopeNicks());
                            try {
                                String string3 = jSONObject.getString("accessToken");
                                Map<String, String> extInfo2 = authExecuteResultModel.getExtInfo();
                                if (extInfo2 == null) {
                                    extInfo2 = new HashMap<>();
                                }
                                extInfo2.put("accessToken", string3);
                                if (jSONObject.containsKey("publicInfo")) {
                                    extInfo2.put("publicInfo", jSONObject.getJSONObject("publicInfo").toJSONString());
                                }
                                authExecuteResultModel.setExtInfo(extInfo2);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e4) {
                    authExecuteResultModel.setSuccess(Boolean.FALSE);
                    authExecuteResultModel.setErrorCode(String.valueOf(6));
                    authExecuteResultModel.setErrorMsg(e4.getMessage());
                    RVLogger.e("TRVLink", "requestRecentlyApp onSuccess parseObject error", e4);
                }
            } else if (sendMtopResponseRequestInnerSync2 != null) {
                authExecuteResultModel.setSuccess(Boolean.FALSE);
                authExecuteResultModel.setErrorCode(sendMtopResponseRequestInnerSync2.errorCode);
                authExecuteResultModel.setErrorMsg(sendMtopResponseRequestInnerSync2.errorMsg);
                authExecuteResultModel.setData(sendMtopResponseRequestInnerSync2.data);
            }
        }
        return authExecuteResultModel;
    }

    private static boolean a(AppModel appModel, String str) {
        PluginModel pluginModel;
        if (appModel == null) {
            return false;
        }
        if (appModel.getPermissionModel() != null) {
            return true;
        }
        if (TextUtils.equals(appModel.getAppId(), str) || TextUtils.isEmpty(str)) {
            return false;
        }
        List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
        if (plugins != null) {
            for (PluginModel pluginModel2 : plugins) {
                if (TextUtils.equals(pluginModel2.getAppId(), str)) {
                    if (pluginModel2.getPermission() == null) {
                        break;
                    }
                    return true;
                }
            }
        }
        ResourcePackage resourcePackage = ResourcePackagePool.getInstance().getPackage(str);
        return (resourcePackage instanceof PluginResourcePackage) && (pluginModel = ((PluginResourcePackage) resourcePackage).getPluginModel()) != null && TextUtils.equals(pluginModel.getAppId(), str) && pluginModel.getPermission() != null;
    }

    public static String a(App app, String str) {
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app);
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append("_appid_");
        sb.append(app != null ? app.getAppId() : "");
        sb.append("_key_");
        sb.append(str);
        return sb.toString();
    }
}
