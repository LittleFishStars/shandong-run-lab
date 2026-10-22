package com.alibaba.triver.support.ui.auth.settings;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.jsapi.security.TBAccessToken;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.model.ResponseDO;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;
import com.alibaba.triver.support.ui.R;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class StatusUpdater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    App f25171a;

    public static class AuthorizeParams extends RequestParams {
        private JSONArray authScopes;
        private String invokerAppId;
        private String mainAppId;

        public AuthorizeParams(String str, Bundle bundle, String str2, List<String> list) {
            super(str, bundle);
            this.invokerAppId = str2;
            this.mainAppId = str;
            JSONArray jSONArray = new JSONArray();
            this.authScopes = jSONArray;
            jSONArray.addAll(list);
        }

        @Override // com.alibaba.triver.kit.api.model.RequestParams
        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("mainAppId", this.mainAppId);
            map.put("invokerAppId", this.invokerAppId);
            map.put("authScopes", this.authScopes.toJSONString());
            return map;
        }
    }

    public interface a {
        void a(boolean z, String str);
    }

    public StatusUpdater(App app) {
        this.f25171a = app;
    }

    public void a(List<StatusItemEntity> list, a aVar) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(null);
        for (StatusItemEntity statusItemEntity : list) {
            if (statusItemEntity.isLocalApi) {
                if (authenticationProxy != null && !TextUtils.isEmpty(userId)) {
                    authenticationProxy.setPermissionState(userId, statusItemEntity.appId, null, statusItemEntity.scopeName, null, statusItemEntity.hasAccess);
                }
            } else if (statusItemEntity.hasAccess) {
                arrayList.add(statusItemEntity.scopeName);
            } else {
                arrayList2.add(statusItemEntity.scopeName);
            }
        }
        if (arrayList.isEmpty()) {
            a();
        } else {
            a(arrayList, arrayList2, aVar);
        }
    }

    public String b(App app) {
        AppModel appModel;
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getTemplateConfig() == null) {
            return null;
        }
        return appModel.getAppInfoModel().getTemplateConfig().getTemplateId();
    }

    public BridgeResponse a() {
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(this.f25171a.getAppId(), c.a(this.f25171a.getAppId(), a(this.f25171a) + "token"));
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        final String str = tBAccessToken != null ? tBAccessToken.accessToken : null;
        if (TextUtils.isEmpty(str)) {
            return new BridgeResponse.Error(10, LangResourceUtil.getString(R.string.ariver_engine_api_unauthorized_user_info));
        }
        RequestParams requestParams = new RequestParams(this.f25171a.getAppId(), this.f25171a.getStartParams()) { // from class: com.alibaba.triver.support.ui.auth.settings.StatusUpdater.1
            @Override // com.alibaba.triver.kit.api.model.RequestParams
            public Map<String, Object> toMap() {
                HashMap map = new HashMap();
                map.put("accessToken", str);
                StatusUpdater statusUpdater = StatusUpdater.this;
                map.put("appKey", statusUpdater.a(statusUpdater.f25171a));
                return map;
            }
        };
        requestParams.api = "mtop.taobao.openlink.auth.accesstoken.invalid";
        requestParams.version = "1.0";
        ((INetworkProxy) RVProxy.get(INetworkProxy.class)).executeAsync(requestParams, new INetworkProxy.RequestListener() { // from class: com.alibaba.triver.support.ui.auth.settings.StatusUpdater.2
            @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
            public void onFailure(ResponseDO responseDO) {
            }

            @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
            public void onSuccess(ResponseDO responseDO) {
            }
        });
        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(this.f25171a.getAppId(), c.a(this.f25171a.getAppId(), a(this.f25171a) + "token"));
        return BridgeResponse.SUCCESS;
    }

    public void a(final List<String> list, final List<String> list2, final a aVar) {
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(this.f25171a.getAppId(), c.a(this.f25171a.getAppId(), a(this.f25171a) + "token"));
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        if (tBAccessToken != null && !tBAccessToken.isFailure()) {
            final String str = tBAccessToken.accessToken;
            RequestParams requestParams = new RequestParams(this.f25171a.getAppId(), this.f25171a.getStartParams()) { // from class: com.alibaba.triver.support.ui.auth.settings.StatusUpdater.4
                @Override // com.alibaba.triver.kit.api.model.RequestParams
                public Map<String, Object> toMap() {
                    String appId;
                    JSONObject jSONObject = new JSONObject();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        jSONObject.put((String) it.next(), (Object) Boolean.TRUE);
                    }
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        jSONObject.put((String) it2.next(), (Object) Boolean.FALSE);
                    }
                    HashMap map = new HashMap();
                    map.put("scopeAuthDiffs", jSONObject.toJSONString());
                    map.put("accessToken", str);
                    map.put("mainAppId", StatusUpdater.this.f25171a.getAppId());
                    StatusUpdater statusUpdater = StatusUpdater.this;
                    if (TextUtils.isEmpty(statusUpdater.b(statusUpdater.f25171a))) {
                        appId = StatusUpdater.this.f25171a.getAppId();
                    } else {
                        StatusUpdater statusUpdater2 = StatusUpdater.this;
                        appId = statusUpdater2.b(statusUpdater2.f25171a);
                    }
                    map.put("invokerAppId", appId);
                    return map;
                }
            };
            requestParams.api = "mtop.taobao.miniapp.auth.change";
            requestParams.version = "1.0";
            ((INetworkProxy) RVProxy.get(INetworkProxy.class)).executeAsync(requestParams, new INetworkProxy.RequestListener() { // from class: com.alibaba.triver.support.ui.auth.settings.StatusUpdater.5
                @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
                public void onFailure(ResponseDO responseDO) {
                    if (TextUtils.equals(responseDO.errorCode, "FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR")) {
                        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
                        String appId = StatusUpdater.this.f25171a.getAppId();
                        String appId2 = StatusUpdater.this.f25171a.getAppId();
                        StringBuilder sb = new StringBuilder();
                        StatusUpdater statusUpdater = StatusUpdater.this;
                        sb.append(statusUpdater.a(statusUpdater.f25171a));
                        sb.append("token");
                        kVStorageProxy.remove(appId, c.a(appId2, sb.toString()));
                    }
                    byte[] bArr = responseDO.data;
                    if (bArr != null && TextUtils.equals("[\"FAIL_SYS_AUTH_CHECK_FAILED::TOPAUTH_ACCESSTOKEN_EXPIRED\"]", JSON.parseObject(new String(bArr)).getString("ret"))) {
                        KVStorageProxy kVStorageProxy2 = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
                        String appId3 = StatusUpdater.this.f25171a.getAppId();
                        String appId4 = StatusUpdater.this.f25171a.getAppId();
                        StringBuilder sb2 = new StringBuilder();
                        StatusUpdater statusUpdater2 = StatusUpdater.this;
                        sb2.append(statusUpdater2.a(statusUpdater2.f25171a));
                        sb2.append("token");
                        kVStorageProxy2.remove(appId3, c.a(appId4, sb2.toString()));
                    }
                    aVar.a(false, responseDO.errorMsg);
                }

                @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
                public void onSuccess(ResponseDO responseDO) {
                    for (String str2 : list) {
                        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(StatusUpdater.this.f25171a.getAppId(), c.a(StatusUpdater.this.f25171a.getAppId(), str2 + "scope"), "true");
                    }
                    for (String str3 : list2) {
                        ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(StatusUpdater.this.f25171a.getAppId(), c.a(StatusUpdater.this.f25171a.getAppId(), str3 + "scope"), AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                    }
                    aVar.a(true, null);
                }
            });
            return;
        }
        AuthorizeParams authorizeParams = new AuthorizeParams(this.f25171a.getAppId(), this.f25171a.getStartParams(), !TextUtils.isEmpty(b(this.f25171a)) ? b(this.f25171a) : this.f25171a.getAppId(), list);
        authorizeParams.api = "mtop.taobao.openlink.miniapp.auth.token.get";
        authorizeParams.version = "1.0";
        ((INetworkProxy) RVProxy.get(INetworkProxy.class)).executeAsync(authorizeParams, new INetworkProxy.RequestListener() { // from class: com.alibaba.triver.support.ui.auth.settings.StatusUpdater.3
            @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
            public void onFailure(ResponseDO responseDO) {
            }

            @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
            public void onSuccess(ResponseDO responseDO) {
                JSONObject jSONObject;
                KVStorageProxy kVStorageProxy;
                if (responseDO == null || !responseDO.success) {
                    return;
                }
                try {
                    byte[] bArr = responseDO.data;
                    if (bArr == null || bArr.length <= 0) {
                        return;
                    }
                    String str2 = new String(bArr, Charset.forName("UTF-8"));
                    if (TextUtils.isEmpty(str2) || (jSONObject = JSON.parseObject(str2).getJSONObject("data")) == null || jSONObject.isEmpty() || (kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class)) == null) {
                        return;
                    }
                    String appId = StatusUpdater.this.f25171a.getAppId();
                    String appId2 = StatusUpdater.this.f25171a.getAppId();
                    StringBuilder sb = new StringBuilder();
                    StatusUpdater statusUpdater = StatusUpdater.this;
                    sb.append(statusUpdater.a(statusUpdater.f25171a));
                    sb.append("token");
                    kVStorageProxy.putString(appId, c.a(appId2, sb.toString()), jSONObject.toJSONString());
                    for (String str3 : list) {
                        kVStorageProxy.putString(StatusUpdater.this.f25171a.getAppId(), c.a(StatusUpdater.this.f25171a.getAppId(), str3 + "scope"), "true");
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public String a(App app) {
        AppModel appModel;
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || appModel.getAppInfoModel() == null) {
            return null;
        }
        return appModel.getAppInfoModel().getAppKey();
    }
}
