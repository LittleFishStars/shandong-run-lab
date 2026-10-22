package com.alibaba.triver.extensions;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.jsapi.security.TBAccessToken;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.PermissionSettingPoint;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.network.SendMtopRequestClient;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.support.ui.b;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PermissionSettingPointImpl implements NodeAware<App>, PermissionSettingPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<App> f24952a;

    private JSONObject a(App app, String str) {
        String str2;
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        DynamicPluginInfo dynamicPluginInfo = (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        SendMtopRequestClient.CommonParam commonParam = new SendMtopRequestClient.CommonParam();
        JSONArray jSONArray = new JSONArray();
        for (String str3 : b.a(appModel, dynamicPluginInfo)) {
            if (!TextUtils.isEmpty(((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, str3 + "scope")))) {
                jSONArray.add(str3);
            }
        }
        commonParam.addData("scopes", jSONArray.toJSONString());
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
        JSONArray jSONArray2 = null;
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        if (tBAccessToken != null) {
            commonParam.addData("accessToken", tBAccessToken.accessToken);
        }
        commonParam.addData("withSubscriptions", "true");
        commonParam.api = "mtop.taobao.miniapp.auth.check";
        commonParam.v = "1.0";
        commonParam.needLogin = true;
        SendMtopRequestClient.CommonResponse commonResponseExecuteSync = new SendMtopRequestClient().executeSync(app, str, commonParam);
        if (!commonResponseExecuteSync.success || (str2 = commonResponseExecuteSync.data) == null) {
            if (TextUtils.equals(commonResponseExecuteSync.errorCode, "FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR")) {
                ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(appModel.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
            }
            String str4 = commonResponseExecuteSync.data;
            if (str4 != null && TextUtils.equals("[\"FAIL_SYS_AUTH_CHECK_FAILED::TOPAUTH_ACCESSTOKEN_EXPIRED\"]", JSON.parseObject(str4).getString("ret"))) {
                ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(appModel.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
            }
        } else {
            JSONObject object = JSON.parseObject(str2);
            if (object != null && !object.isEmpty()) {
                JSONObject jSONObject3 = object.getJSONObject("authStatus");
                if (jSONObject3 != null && !jSONObject3.isEmpty()) {
                    for (String str5 : jSONObject3.keySet()) {
                        if (jSONObject3.getBoolean(str5).booleanValue()) {
                            jSONObject2.put(str5, (Object) Boolean.TRUE);
                        }
                    }
                }
                jSONArray2 = object.getJSONArray("domainItems");
            }
        }
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            if (!jSONObject2.containsKey(jSONArray.getString(i))) {
                jSONObject2.put(jSONArray.getString(i), (Object) Boolean.FALSE);
            }
        }
        jSONObject.put("authSetting", (Object) jSONObject2);
        jSONObject.put("subscriptionsSetting", (Object) jSONArray2);
        return jSONObject;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.permission.api.extension.PermissionSettingPoint
    public JSONObject getSetting(String str) {
        return getSetting(str, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_SUBSCRIBE_SETTING_SWITCH, "true")));
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.f24952a = weakReference;
    }

    public JSONObject getSetting(String str, boolean z) {
        if (z) {
            return null;
        }
        WeakReference<App> weakReference = this.f24952a;
        App app = weakReference != null ? weakReference.get() : null;
        if (app == null) {
            return null;
        }
        Map<String, Boolean> allPermissions = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getAllPermissions(((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app), app.getAppId(), (AppModel) app.getData(AppModel.class), app, app.getActivePage());
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putAll(allPermissions);
        try {
            JSONObject jSONObjectA = a(app, str);
            jSONObject2.putAll(jSONObjectA.getJSONObject("authSetting"));
            jSONObject.put("subscriptionsSetting", (Object) jSONObjectA.getJSONArray("subscriptionsSetting"));
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        jSONObject.put("authSetting", (Object) jSONObject2);
        return jSONObject;
    }
}
