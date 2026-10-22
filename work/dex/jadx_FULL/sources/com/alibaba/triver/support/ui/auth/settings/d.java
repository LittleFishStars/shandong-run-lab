package com.alibaba.triver.support.ui.auth.settings;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.jsapi.security.TBAccessToken;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.alibaba.triver.kit.api.network.SendMtopRequestClient;
import com.alibaba.triver.support.ui.R;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    public interface a {
        void a(boolean z, String str);
    }

    public void a(final App app, final List<AuthStatusEntity> list, final a aVar) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.triver.support.ui.auth.settings.d.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    if (list != null) {
                        ArrayList<AuthStatusEntity> arrayList = new ArrayList();
                        ArrayList<AuthStatusEntity> arrayList2 = new ArrayList();
                        Iterator it = list.iterator();
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        while (true) {
                            z = true;
                            if (!it.hasNext()) {
                                break;
                            }
                            AuthStatusEntity authStatusEntity = (AuthStatusEntity) it.next();
                            if (authStatusEntity.e()) {
                                if (authStatusEntity.c() != AuthStatusEntity.AuthType.Device) {
                                    if (authStatusEntity.c() != AuthStatusEntity.AuthType.UserInfo) {
                                        if (authStatusEntity.c() == AuthStatusEntity.AuthType.Subscribe) {
                                            arrayList2.add(authStatusEntity);
                                            z4 = true;
                                            break;
                                        }
                                    } else {
                                        authStatusEntity.a(false);
                                        z3 = true;
                                    }
                                } else {
                                    arrayList.add(authStatusEntity);
                                    authStatusEntity.a(false);
                                }
                            } else if (authStatusEntity.d() != null && !authStatusEntity.d().isEmpty()) {
                                Iterator<AuthStatusEntity> it2 = authStatusEntity.d().iterator();
                                while (it2.hasNext()) {
                                    if (it2.next().e()) {
                                        arrayList2.add(authStatusEntity);
                                        z4 = true;
                                        break;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
                            String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(app);
                            for (AuthStatusEntity authStatusEntity2 : arrayList) {
                                authenticationProxy.setPermissionState(userId, app.getAppId(), app, authStatusEntity2.a(), null, authStatusEntity2.g());
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        if (z3) {
                            for (AuthStatusEntity authStatusEntity3 : list) {
                                if (authStatusEntity3.c() == AuthStatusEntity.AuthType.UserInfo) {
                                    if (authStatusEntity3.g()) {
                                        arrayList3.add(authStatusEntity3.a());
                                    } else {
                                        arrayList4.add(authStatusEntity3.a());
                                    }
                                }
                            }
                        }
                        if (arrayList3.isEmpty()) {
                            if (!arrayList4.isEmpty() && !d.this.a(app)) {
                                for (AuthStatusEntity authStatusEntity4 : list) {
                                    if (arrayList4.contains(authStatusEntity4.a())) {
                                        authStatusEntity4.b(true);
                                    }
                                }
                                z = false;
                            }
                        } else if (!d.this.a(app, arrayList3, arrayList4)) {
                            for (AuthStatusEntity authStatusEntity5 : list) {
                                if (arrayList4.contains(authStatusEntity5.a())) {
                                    authStatusEntity5.b(true);
                                } else if (arrayList3.contains(authStatusEntity5.a())) {
                                    authStatusEntity5.b(false);
                                }
                            }
                            z = false;
                        }
                        JSONArray jSONArray = new JSONArray();
                        if (z4) {
                            for (AuthStatusEntity authStatusEntity6 : arrayList2) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("domainKey", authStatusEntity6.a());
                                if (authStatusEntity6.g()) {
                                    jSONObject.put("status", SubscribeResouceItemModel.ACCEPT);
                                } else {
                                    jSONObject.put("status", SubscribeResouceItemModel.REJECT);
                                }
                                jSONArray.add(jSONObject);
                                if (authStatusEntity6.e()) {
                                    authStatusEntity6.a(false);
                                }
                                if (authStatusEntity6.d() != null && !authStatusEntity6.d().isEmpty()) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (AuthStatusEntity authStatusEntity7 : authStatusEntity6.d()) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("resourceKey", (Object) authStatusEntity7.a());
                                        if (authStatusEntity7.g()) {
                                            jSONObject2.put("status", (Object) SubscribeResouceItemModel.ACCEPT);
                                        } else {
                                            jSONObject2.put("status", (Object) SubscribeResouceItemModel.REJECT);
                                        }
                                        jSONArray2.add(jSONObject2);
                                        if (authStatusEntity7.e()) {
                                            authStatusEntity7.a(false);
                                        }
                                    }
                                    jSONObject.put("resourceItems", (Object) jSONArray2);
                                }
                            }
                        }
                        if (jSONArray.isEmpty() || d.this.a(app, jSONArray)) {
                            z2 = z;
                        }
                        aVar.a(z2, ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getResources().getString(R.string.triver_system_error_and_retry));
                    }
                } catch (Throwable th) {
                    RVLogger.w(Log.getStackTraceString(th));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(App app, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.isEmpty() || app == null || app.getData(AppModel.class) == null) {
            return false;
        }
        SendMtopRequestClient.CommonParam commonParam = new SendMtopRequestClient.CommonParam();
        commonParam.addData("domainItems", jSONArray.toJSONString());
        commonParam.api = "mtop.taobao.openlink.miniapp.resource.authChange";
        commonParam.v = "1.0";
        commonParam.needLogin = true;
        return new SendMtopRequestClient().executeSync(app, null, commonParam).success;
    }

    public boolean a(App app) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            return false;
        }
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(appModel.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        String str = tBAccessToken != null ? tBAccessToken.accessToken : null;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        SendMtopParams sendMtopParams = new SendMtopParams(app.getAppId(), app.getStartParams());
        sendMtopParams.addData("accessToken", str);
        sendMtopParams.addData("appKey", appModel.getAppInfoModel().getAppKey());
        sendMtopParams.api = "mtop.taobao.openlink.auth.accesstoken.invalid";
        sendMtopParams.needLogin = true;
        sendMtopParams.v = "1.0";
        HashMap map = new HashMap();
        map.put(com.alibaba.ariver.jsapi.mtop.a.f, app.getAppId());
        sendMtopParams.setHeaders(map);
        SendMtopResponse sendMtopResponseRequestInnerSync = ((IMtopProxy) RVProxy.get(IMtopProxy.class)).requestInnerSync(sendMtopParams);
        if (sendMtopResponseRequestInnerSync != null && sendMtopResponseRequestInnerSync.success) {
            ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(appModel.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
        }
        return sendMtopResponseRequestInnerSync != null && sendMtopResponseRequestInnerSync.success;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(App app, List<String> list, List<String> list2) {
        String str;
        JSONObject object;
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            return false;
        }
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        if (tBAccessToken != null && !tBAccessToken.isFailure()) {
            String str2 = tBAccessToken.accessToken;
            SendMtopRequestClient.CommonParam commonParam = new SendMtopRequestClient.CommonParam();
            JSONObject jSONObject = new JSONObject();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), (Object) Boolean.TRUE);
            }
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                jSONObject.put(it2.next(), (Object) Boolean.FALSE);
            }
            commonParam.addData("scopeAuthDiffs", jSONObject.toJSONString());
            commonParam.addData("accessToken", str2);
            commonParam.api = "mtop.taobao.miniapp.auth.change";
            commonParam.needLogin = true;
            commonParam.v = "1.0";
            SendMtopRequestClient.CommonResponse commonResponseExecuteSync = new SendMtopRequestClient().executeSync(app, null, commonParam);
            if (commonResponseExecuteSync.success) {
                for (String str3 : list) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, str3 + "scope"), "true");
                }
                for (String str4 : list2) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).putString(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, str4 + "scope"), AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                }
            } else {
                if (TextUtils.equals(commonResponseExecuteSync.errorCode, "FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR")) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
                }
                String str5 = commonResponseExecuteSync.data;
                if (str5 != null && TextUtils.equals("[\"FAIL_SYS_AUTH_CHECK_FAILED::TOPAUTH_ACCESSTOKEN_EXPIRED\"]", JSON.parseObject(str5).getString("ret"))) {
                    ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"));
                }
            }
            return commonResponseExecuteSync.success;
        }
        SendMtopRequestClient.CommonParam commonParam2 = new SendMtopRequestClient.CommonParam();
        JSONArray jSONArray = new JSONArray();
        jSONArray.addAll(list);
        commonParam2.addData("authScopes", jSONArray.toJSONString());
        commonParam2.api = "mtop.taobao.openlink.miniapp.auth.token.get";
        commonParam2.needLogin = true;
        commonParam2.v = "1.0";
        SendMtopRequestClient.CommonResponse commonResponseExecuteSync2 = new SendMtopRequestClient().executeSync(app, null, commonParam2);
        if (!commonResponseExecuteSync2.success || (str = commonResponseExecuteSync2.data) == null || (object = JSON.parseObject(str)) == null || object.isEmpty()) {
            return false;
        }
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        if (kVStorageProxy != null) {
            kVStorageProxy.putString(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, appModel.getAppInfoModel().getAppKey() + "token"), object.toJSONString());
            for (String str6 : list) {
                kVStorageProxy.putString(app.getAppId(), com.alibaba.ariver.permission.extension.auth.b.a(app, str6 + "scope"), "true");
            }
        }
        return true;
    }
}
