package com.alibaba.ariver.permission.extension.auth;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.R;
import com.alibaba.ariver.permission.api.OnGetAuthListener;
import com.alibaba.ariver.permission.api.RVFlag;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.api.proxy.H5OpenAuthProxy;
import com.alibaba.ariver.permission.api.proxy.Oauth2AuthCodeService;
import com.alibaba.ariver.permission.model.AuthProtocol;
import com.alibaba.ariver.permission.openauth.model.request.AuthExecuteRequestModel;
import com.alibaba.ariver.permission.openauth.model.request.AuthSkipRequestModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthAgreementModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthExecuteResultModel;
import com.alibaba.ariver.permission.openauth.model.result.AuthSkipResultModel;
import com.alibaba.ariver.permission.openauth.model.result.H5AuthParamsModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24355a = "TB";
    public static final String b = "AP";
    public static final String c = "11";
    private static final String d = "AriverPermission:RVOpenAuthHelper";
    private static final String e = "mobilegw_android";
    private static final String f = "QnJpbmcgc21hbGwgYW5kIGJlYXV0aWZ1bCBjaGFuZ2VzIHRvIHRoZSB3b3JsZA==";
    private static final String g = "auth_user";
    private static boolean h = false;
    private OnGetAuthListener i;
    private BridgeCallback j;
    private String k;
    private List<String> l;
    private Context m;
    private App n;

    /* JADX INFO: renamed from: com.alibaba.ariver.permission.extension.auth.a$a, reason: collision with other inner class name */
    public class RunnableC0146a implements Runnable {
        private AuthSkipResultModel b;
        private String c;
        private String d;
        private List<String> e;
        private boolean f;
        private String g;
        private Map<String, String> h;
        private Map<String, String> i;
        private Page j;
        private App k;
        private String l;

        public RunnableC0146a(App app, @Nullable Page page, AuthSkipResultModel authSkipResultModel, String str, String str2, String str3, List<String> list, boolean z, String str4, Map<String, String> map, Map<String, String> map2) {
            this.b = authSkipResultModel;
            this.k = app;
            this.j = page;
            this.l = str;
            this.c = str2;
            this.d = str3;
            this.e = list;
            this.f = z;
            this.g = str4;
            this.h = map;
            this.i = map2;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> authText = this.b.getAuthContentResult().getAuthText();
            String appName = this.b.getAuthContentResult().getAppName();
            String appLogoLink = this.b.getAuthContentResult().getAppLogoLink();
            List<AuthAgreementModel> agreements = this.b.getAuthContentResult().getAgreements();
            if (((AuthDialogProxy) RVProxy.get(this.k, AuthDialogProxy.class)) == null) {
                RVLogger.e(a.d, "get authdialogproxy is null");
            }
            if (authText != null && !authText.isEmpty()) {
                RVLogger.e("authText is Empty");
            }
            App app = this.k;
            if (app == null || app.isDestroyed() || this.k.isExited()) {
                return;
            }
            AppContext appContext = this.k.getAppContext();
            Page page = this.j;
            if ((page != null && (page.isDestroyed() || this.j.isExited())) || appContext == null) {
                RVLogger.w(a.d, "auth should show dailog but page is exited!");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", (Object) "11");
                jSONObject.put("message", (Object) "页面已退出");
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) "页面已退出");
                a.this.j.sendJSONResponse(jSONObject);
                return;
            }
            final com.alibaba.ariver.permission.b.a openAuthDialog = ((AuthDialogProxy) RVProxy.get(this.k, AuthDialogProxy.class)).getOpenAuthDialog(appContext.getContext());
            if (agreements == null || agreements.isEmpty()) {
                openAuthDialog.a(appName, appLogoLink, this.k, this.e, authText, null, this.b.getAuthContentResult().getIsvAgent().booleanValue() ? this.b.getAuthContentResult().getIsvAgentDesc() : null, this.b.getAuthContentResult().getExtInfo());
            } else {
                ArrayList arrayList = new ArrayList(agreements.size());
                for (AuthAgreementModel authAgreementModel : agreements) {
                    arrayList.add(new AuthProtocol(authAgreementModel.getName(), authAgreementModel.getLink()));
                }
                openAuthDialog.a(appName, appLogoLink, this.k, this.e, authText, arrayList, this.b.getAuthContentResult().getIsvAgent().booleanValue() ? this.b.getAuthContentResult().getIsvAgentDesc() : null, this.b.getAuthContentResult().getExtInfo());
            }
            openAuthDialog.b(new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RVLogger.d(a.d, "h5OpenAuthDialog click begin invoke auth");
                    openAuthDialog.b();
                    ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.permission.extension.auth.a.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC0146a runnableC0146a = RunnableC0146a.this;
                            a.this.a(runnableC0146a.l, RunnableC0146a.this.k, RunnableC0146a.this.j, RunnableC0146a.this.c, RunnableC0146a.this.d, (List<String>) RunnableC0146a.this.e, RunnableC0146a.this.f, RunnableC0146a.this.g, (Map<String, String>) RunnableC0146a.this.h, (Map<String, String>) RunnableC0146a.this.i);
                        }
                    });
                }
            });
            openAuthDialog.a(new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RVLogger.d(a.d, "h5OpenAuthDialog click close");
                    openAuthDialog.b();
                    RunnableC0146a runnableC0146a = RunnableC0146a.this;
                    a.this.a(runnableC0146a.k, RunnableC0146a.this.j, RunnableC0146a.this.b, RunnableC0146a.this.l, RunnableC0146a.this.c, RunnableC0146a.this.d, (List<String>) RunnableC0146a.this.e, RunnableC0146a.this.f, RunnableC0146a.this.g, (Map<String, String>) RunnableC0146a.this.h, (Map<String, String>) RunnableC0146a.this.i);
                }
            });
            try {
                openAuthDialog.a();
            } catch (Throwable th) {
                RVLogger.e(a.d, th);
            }
        }
    }

    public a(Context context, App app, BridgeCallback bridgeCallback, String str) {
        this.m = context;
        this.n = app;
        this.j = bridgeCallback;
        this.k = str;
    }

    private boolean b() {
        JSONObject object = JSONUtils.parseObject(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_newGetAuthCodeConfig", ""));
        if (object == null || object.isEmpty()) {
            return false;
        }
        return JSONUtils.getBoolean(object, "callbackErrorAtDuplicate", false);
    }

    public void a(final String str, @Nullable final Page page, String str2, String str3, List<String> list, String str4, Map<String, String> map, final boolean z, Map<String, String> map2, Bundle bundle) {
        AuthSkipResultModel authSkipResult;
        AuthSkipRequestModel authSkipRequestModel = new AuthSkipRequestModel();
        authSkipRequestModel.setAppId(str2);
        authSkipRequestModel.setCurrentPageUrl(str3);
        authSkipRequestModel.setFromSystem(e);
        authSkipRequestModel.setScopeNicks(list);
        authSkipRequestModel.setState(f);
        authSkipRequestModel.setIsvAppId(str4);
        authSkipRequestModel.setExtInfo(map);
        authSkipRequestModel.setAppExtInfo(map2);
        this.l = list;
        try {
            if (TextUtils.equals("TB", str)) {
                authSkipResult = b.a(str, this.n, authSkipRequestModel);
            } else {
                authSkipResult = ((Oauth2AuthCodeService) RVProxy.get(Oauth2AuthCodeService.class)).getAuthSkipResult(str, this.n, authSkipRequestModel);
            }
            final AuthSkipResultModel authSkipResultModel = authSkipResult;
            if (authSkipResultModel != null) {
                if (authSkipResultModel.getSuccess() != null && !authSkipResultModel.getSuccess().booleanValue()) {
                    RVLogger.d(d, "getAuthContentOrAutoAuth rpc !isSuccess" + authSkipResultModel.getErrorCode() + " " + authSkipResultModel.getErrorMsg());
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.extension.auth.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(page, str, authSkipResultModel.getErrorCode(), authSkipResultModel.getErrorMsg(), authSkipResultModel.getData(), z);
                        }
                    });
                } else if ((authSkipResultModel.getCanSkipAuth() != null && authSkipResultModel.getCanSkipAuth().booleanValue()) || (authSkipResultModel.getShowType() != null && authSkipResultModel.getShowType().equalsIgnoreCase("CALLBACK"))) {
                    RVLogger.d(d, "getAuthContentOrAutoAuth rpc canSkipAuth");
                    if (authSkipResultModel.getAuthExecuteResult() != null) {
                        String authCode = authSkipResultModel.getAuthExecuteResult().getAuthCode();
                        RVLogger.d(d, "getAuthContentOrAutoAuth rpc authCode is " + authCode);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("authCode", (Object) authCode);
                        jSONObject.put("authcode", (Object) authCode);
                        JSONArray jSONArray = new JSONArray();
                        if (authSkipResultModel.getAuthExecuteResult() != null && !CollectionUtils.isEmpty(authSkipResultModel.getAuthExecuteResult().getSuccessScopes())) {
                            Iterator<String> it = authSkipResultModel.getAuthExecuteResult().getSuccessScopes().iterator();
                            while (it.hasNext()) {
                                jSONArray.add(it.next());
                            }
                        }
                        jSONObject.put("authSuccessScopes", (Object) jSONArray);
                        JSONObject jSONObject2 = new JSONObject();
                        if (authSkipResultModel.getAuthExecuteResult() != null && !CollectionUtils.isEmpty(authSkipResultModel.getAuthExecuteResult().getErrorScopes())) {
                            for (Map.Entry<String, String> entry : authSkipResultModel.getAuthExecuteResult().getErrorScopes().entrySet()) {
                                jSONObject2.put(entry.getKey(), (Object) entry.getValue());
                            }
                        }
                        jSONObject.put("authErrorScopes", (Object) jSONObject2);
                        if ("TB".equals(str) && authSkipResultModel.getAuthExecuteResult().getExtInfo() != null) {
                            jSONObject.put("accessToken", authSkipResultModel.getAuthExecuteResult().getExtInfo().get("accessToken"));
                        }
                        if (this.j != null && list != null && list.contains(g)) {
                            RVFlag.setOpenAuthGrantFlag(this.k, true);
                        }
                        a(page, jSONObject);
                    }
                } else {
                    RVLogger.d(d, "getAuthContentOrAutoAuth rpc !canSkipAuth");
                    H5OpenAuthProxy h5OpenAuthProxy = (H5OpenAuthProxy) RVProxy.get(H5OpenAuthProxy.class);
                    if (authSkipResultModel.getShowType() != null && authSkipResultModel.getShowType().equalsIgnoreCase("H5") && h5OpenAuthProxy != null) {
                        a(h5OpenAuthProxy, page, authSkipResultModel.getH5AuthParams(), bundle);
                        App app = this.n;
                        if (app != null) {
                            app.putStringValue("lastCalledJsApi", "getAuthCode");
                        }
                    } else if (authSkipResultModel.getAuthContentResult() != null) {
                        RVLogger.d(d, "getAuthContentOrAutoAuth rpc begin present auth dialog");
                        try {
                            ExecutorUtils.runOnMain(new RunnableC0146a(this.n, page, authSkipResultModel, str, str2, str3, list, z, str4, map, map2));
                        } catch (Exception e2) {
                            e = e2;
                            RVLogger.e(d, "getAuthContentOrAutoAuth rpc exception ", e);
                            a(page, e);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public a(Context context, App app, BridgeCallback bridgeCallback, String str, OnGetAuthListener onGetAuthListener) {
        this.m = context;
        this.n = app;
        this.j = bridgeCallback;
        this.k = str;
        this.i = onGetAuthListener;
    }

    public void a() {
        List<String> list = this.l;
        if (list == null || !list.contains(g)) {
            return;
        }
        RVFlag.setOpenAuthGrantFlag(this.k, true);
    }

    public void a(@Nullable Page page, JSONObject jSONObject) {
        if (13 == JSONUtils.getInt(jSONObject, "error")) {
            h = true;
        } else {
            h = false;
        }
        if (this.i != null) {
            RVLogger.d(d, "result for provider: " + jSONObject.toString());
            this.i.onResult(jSONObject);
        } else if (this.j != null) {
            RVLogger.d(d, "result for jsbridge: " + jSONObject.toString());
            this.j.sendJSONResponse(jSONObject);
        }
        if (page == null || page.getRender() == null) {
            return;
        }
        EngineUtils.sendToRender(page.getRender(), "alipayAuthChange", jSONObject, null);
    }

    private void a(Page page, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        if (exc.getClass().getName().contains("RpcException")) {
            jSONObject.put("error", (Object) 12);
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, "Network Error");
        } else {
            jSONObject.put("error", (Object) 10);
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) exc.toString());
        }
        a(page, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final App app, @Nullable final Page page, final AuthSkipResultModel authSkipResultModel, final String str, final String str2, final String str3, final List<String> list, final boolean z, final String str4, final Map<String, String> map, final Map<String, String> map2) {
        if (app == null || app.isDestroyed() || app.isExited() || app.getAppContext() == null) {
            return;
        }
        final com.alibaba.ariver.permission.b.b authNoticeDialog = ((AuthDialogProxy) RVProxy.get(app, AuthDialogProxy.class)).getAuthNoticeDialog(app.getAppContext().getContext());
        authNoticeDialog.a(new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RVLogger.d(a.d, "h5OpenAuthNoticeDialog click auth again");
                authNoticeDialog.b();
                if (authSkipResultModel.getAuthContentResult() != null) {
                    ExecutorUtils.runOnMain(a.this.new RunnableC0146a(app, page, authSkipResultModel, str, str2, str3, list, z, str4, map, map2));
                }
            }
        });
        authNoticeDialog.b(new View.OnClickListener() { // from class: com.alibaba.ariver.permission.extension.auth.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RVLogger.d(a.d, "h5OpenAuthNoticeDialog click exit auth");
                authNoticeDialog.b();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", (Object) "11");
                jSONObject.put("message", (Object) LangResourceUtil.getString(R.string.tiny_user_cancel_authorization));
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) LangResourceUtil.getString(R.string.tiny_user_cancel_authorization));
                a.this.a(page, jSONObject);
            }
        });
        authNoticeDialog.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, App app, @Nullable final Page page, String str2, String str3, List<String> list, final boolean z, String str4, Map<String, String> map, Map<String, String> map2) {
        final AuthExecuteResultModel authExecuteResultModelExecuteAuth;
        AuthExecuteRequestModel authExecuteRequestModel = new AuthExecuteRequestModel();
        authExecuteRequestModel.setAppId(str2);
        authExecuteRequestModel.setCurrentPageUrl(str3);
        authExecuteRequestModel.setFromSystem(e);
        authExecuteRequestModel.setScopeNicks(list);
        authExecuteRequestModel.setState(f);
        authExecuteRequestModel.setIsvAppId(str4);
        authExecuteRequestModel.setExtInfo(map);
        authExecuteRequestModel.setAppExtInfo(map2);
        try {
            if (TextUtils.equals("TB", str)) {
                authExecuteResultModelExecuteAuth = b.a(app, authExecuteRequestModel);
            } else {
                authExecuteResultModelExecuteAuth = ((Oauth2AuthCodeService) RVProxy.get(Oauth2AuthCodeService.class)).executeAuth(authExecuteRequestModel);
            }
            if (authExecuteResultModelExecuteAuth != null) {
                if (authExecuteResultModelExecuteAuth.getSuccess() != null && !authExecuteResultModelExecuteAuth.getSuccess().booleanValue()) {
                    RVLogger.d(d, "executeAuth rpc !isSuccess " + authExecuteResultModelExecuteAuth.getErrorCode() + " " + authExecuteResultModelExecuteAuth.getErrorMsg());
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.permission.extension.auth.a.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(page, str, authExecuteResultModelExecuteAuth.getErrorCode(), authExecuteResultModelExecuteAuth.getErrorMsg(), authExecuteResultModelExecuteAuth.getData(), z);
                        }
                    });
                    return;
                }
                RVLogger.d(d, "executeAuth rpc isSuccess");
                String authCode = authExecuteResultModelExecuteAuth.getAuthCode();
                RVLogger.d(d, "executeAuth rpc authCode is " + authCode);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("authCode", (Object) authCode);
                jSONObject.put("authcode", (Object) authCode);
                JSONArray jSONArray = new JSONArray();
                if (authExecuteResultModelExecuteAuth.getSuccessScopes() != null && !authExecuteResultModelExecuteAuth.getSuccessScopes().isEmpty()) {
                    jSONArray.addAll(authExecuteResultModelExecuteAuth.getSuccessScopes());
                }
                jSONObject.put("authSuccessScopes", (Object) jSONArray);
                JSONObject jSONObject2 = new JSONObject();
                if (authExecuteResultModelExecuteAuth.getErrorScopes() != null && !authExecuteResultModelExecuteAuth.getErrorScopes().isEmpty()) {
                    for (Map.Entry<String, String> entry : authExecuteResultModelExecuteAuth.getErrorScopes().entrySet()) {
                        jSONObject2.put(entry.getKey(), (Object) entry.getValue());
                    }
                }
                if (authExecuteResultModelExecuteAuth.getExtInfo() != null && TextUtils.equals("TB", str)) {
                    jSONObject.put("accessToken", authExecuteResultModelExecuteAuth.getExtInfo().get("accessToken"));
                    try {
                        if (authExecuteResultModelExecuteAuth.getExtInfo().get("publicInfo") != null) {
                            JSONObject object = JSON.parseObject(authExecuteResultModelExecuteAuth.getExtInfo().get("publicInfo"));
                            for (String str5 : object.keySet()) {
                                jSONObject.put(str5, object.get(str5));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                jSONObject.put("authErrorScopes", (Object) jSONObject2);
                if (this.j != null && list != null && list.contains(g)) {
                    RVLogger.d(d, "executeAuth setOpenAuthGrantFlag " + this.k);
                    RVFlag.setOpenAuthGrantFlag(this.k, true);
                }
                a(page, jSONObject);
            }
        } catch (Exception e3) {
            RVLogger.e(d, "executeAuth rpc exception ", e3);
            a(page, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable Page page, String str, String str2, String str3, byte[] bArr, boolean z) {
        App app = this.n;
        if (app == null || app.isExited() || this.n.isDestroyed()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) 15);
        jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str2);
        jSONObject.put("errorDesc", (Object) str3);
        if (TextUtils.equals("TB", str)) {
            jSONObject.put("errorCode", (Object) str2);
            jSONObject.put("message", (Object) str3);
            jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) str3);
            if (bArr != null && bArr.length > 0) {
                String str4 = new String(bArr, Charset.forName("UTF-8"));
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.putAll(JSON.parseObject(str4));
                    jSONObject.remove("api");
                }
            }
        }
        a(page, jSONObject);
        RVLogger.d(d, "showBusinessFailedDialog showErrorTip: " + z);
        if (z) {
            AuthDialogProxy authDialogProxy = (AuthDialogProxy) RVProxy.get(AuthDialogProxy.class);
            Context context = this.m;
            authDialogProxy.showErrorTipDialog(context, LangResourceUtil.getString(context, R.string.tiny_server_busy_error), LangResourceUtil.getString(this.m, R.string.tiny_apologize_for_the_delay));
        }
    }

    private void a(H5OpenAuthProxy h5OpenAuthProxy, @Nullable Page page, H5AuthParamsModel h5AuthParamsModel, Bundle bundle) {
        String appId = h5AuthParamsModel.getAppId();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, String> entry : h5AuthParamsModel.getParams().entrySet()) {
            bundle2.putString(entry.getKey(), entry.getValue());
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        if ("YES".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_passStartParamInGetAuthCode", null)) && bundle != null && !bundle.isEmpty()) {
            bundle2.putAll(bundle);
        }
        h5OpenAuthProxy.addOpenAuthHelper(strValueOf, this, page);
        if (h) {
            if (b()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", (Object) 13);
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) LangResourceUtil.getString(R.string.tiny_being_init_authorization_panel));
                a(page, jSONObject);
                return;
            }
            return;
        }
        h = true;
        RVLogger.d(d, "startH5OpenAuth,key is :" + strValueOf);
        h5OpenAuthProxy.startH5OpenAuth(strValueOf, appId, bundle2);
    }
}
