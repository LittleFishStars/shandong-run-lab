package com.alibaba.alibctriver.extensions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibcprotocol.BCErrorEnum;
import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.business.ParseSclickBusiness;
import com.alibaba.alibcprotocol.business.TBLiteJudgeBusiness;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.alibctriver.AlibcNavigateCenter;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.prefetch.mtop.c;
import com.alibaba.triver.utils.PageUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23660a = "AlibcBridgeExtension";

    public class a {
        private String b;
        private String c;
        private String d;
        private boolean e = true;

        public a(String str) {
            this.b = str;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        JSONObject f23675a;

        private b(JSONObject jSONObject) {
            this.f23675a = jSONObject;
        }
    }

    private String a(Bundle bundle, boolean z, String str, String str2) {
        String triverParam = "";
        if (bundle == null) {
            return "";
        }
        if (z) {
            triverParam = AlibcProtocolUtils.parseTriverParam(str, AlibcProtocolConstant.RECOVER_ID);
        } else if (!TextUtils.isEmpty(str2)) {
            triverParam = AlibcProtocolUtils.parseTriverParam(str2, AlibcProtocolConstant.RECOVER_ID);
        }
        return TextUtils.isEmpty(triverParam) ? String.valueOf(bundle.get(AlibcProtocolConstant.RECOVER_ID)) : triverParam;
    }

    private Context b(Page page) {
        AppContext appContext;
        if (page == null || page.getApp() == null || (appContext = page.getApp().getAppContext()) == null) {
            return null;
        }
        return appContext.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        AlibcLogger.i(f23660a, "code = " + str + ", msg = " + str2);
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void bcConvertUrl(@BindingParam(name = {"url"}) String str, @BindingParam(name = {"params"}) Map<String, String> map, @BindingCallback final BridgeCallback bridgeCallback) {
        if (!TextUtils.isEmpty(str)) {
            ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).commitTaokeInfo(str, map, new CpsCommitCallback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.7
                @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
                public void onFail(String str2, String str3) {
                    AlibcLogger.e(AlibcBridgeExtension.f23660a, "json parse exception: code = " + str2 + ", msg = " + str3);
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "convert service call fail"));
                }

                @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
                public void onSuccess(Map<String, String> map2) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse(new JSONObject(new HashMap(map2))));
                }
            });
        } else {
            AlibcLogger.e(f23660a, "url is empty");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "url is empty"));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void bcGetClickId(@BindingParam(name = {"url"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newValue("clickId", a(AlibcProtocolUtils.verifyMiniappUrl(str), str)));
        } catch (Exception e) {
            AlibcLogger.e(f23660a, "get clickId fail: " + e.getMessage());
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "get clickId exception"));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void bcGetPageUrl(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        String pageUrl = PageUtils.getPageUrl(page);
        if (TextUtils.isEmpty(pageUrl) || "null".equals(pageUrl)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) pageUrl);
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void bcNavigateToOutside(@BindingNode(Page.class) Page page, @BindingParam(name = {"url"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        Context contextB = b(page);
        Iterator<AlibcNavigateCenter.IUrlNavigate> it = AlibcNavigateCenter.getNavigateUrlList().iterator();
        while (it.hasNext()) {
            if (it.next().openUrl(contextB, str)) {
                AlibcLogger.i(f23660a, "url load by third app");
                bridgeCallback.sendBridgeResponse(new BridgeResponse.NamedValue(AliyunLogCommon.LogLevel.INFO, "url load by third app"));
                return;
            }
        }
        AlibcLogger.i(f23660a, "url load by default webview");
        Bundle startParams = (page == null || page.getApp() == null) ? null : page.getApp().getStartParams();
        AlibcContainerManager.loadUrl("h5", str, startParams != null ? startParams.getString(RVParams.SESSION_ID) : "", AlibcProtocolConstant.THIRD_WEBVIEW, contextB);
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void bcNotify(@BindingParam(name = {"name"}) String str, @BindingParam(name = {"content"}) Object obj, @BindingCallback BridgeCallback bridgeCallback) {
        Set<EventCenter.NotifyListener> set = EventCenter.listenerSet;
        if (set != null) {
            Iterator<EventCenter.NotifyListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onNotify(str, obj);
            }
        }
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void getAlibcSuiteConfig(@BindingNode(App.class) final App app, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        b bVar = (b) app.getData(b.class);
        if (bVar != null) {
            a(bVar, bridgeCallback);
            return;
        }
        try {
            MiscDO misc = AlibcConfigService.getInstance().getConfig().getMisc();
            String extConfigApi = misc != null ? misc.getExtConfigApi() : "";
            if (TextUtils.isEmpty(extConfigApi)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.FORBIDDEN_ERROR);
                return;
            }
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            String appId = appModel != null ? appModel.getAppId() : "";
            Uri uri = Uri.parse(extConfigApi);
            SendMtopParams sendMtopParams = new SendMtopParams(appId, app.getStartParams());
            sendMtopParams.api = uri.getHost();
            sendMtopParams.v = uri.getQueryParameter("version");
            sendMtopParams.addData("hostAppId", app.getAppId());
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = c.a(sendMtopParams.api, sendMtopParams.v, sendMtopParams.getDataMap());
            if (!TextUtils.isEmpty(strA)) {
                try {
                    b bVar2 = new b(JSON.parseObject(strA, Feature.OrderedField).getJSONObject("data").getJSONObject("data"));
                    app.setData(b.class, bVar2);
                    a(bVar2, bridgeCallback);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                    jSONObject.put("appId", (Object) app.getAppId());
                    AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_SUITE_CONFIG_PREFETCH, "", "", jSONObject);
                    return;
                } catch (Exception unused) {
                }
            }
            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("costTime", (Object) String.valueOf(jCurrentTimeMillis3));
            jSONObject2.put("status", (Object) "miss");
            jSONObject2.put("appId", (Object) app.getAppId());
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_SUITE_CONFIG_PREFETCH, "code_miss", "missconfig", jSONObject2);
            IMtopProxy iMtopProxy = (IMtopProxy) RVProxy.get(IMtopProxy.class);
            if (iMtopProxy != null) {
                iMtopProxy.requestInnerAsync(sendMtopParams, new IMtopProxy.Callback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.5
                    @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy.Callback
                    public void onResult(SendMtopResponse sendMtopResponse) {
                        byte[] bArr;
                        if (!sendMtopResponse.success || (bArr = sendMtopResponse.data) == null || bArr.length <= 0) {
                            BridgeCallback bridgeCallback2 = bridgeCallback;
                            byte[] bArr2 = sendMtopResponse.data;
                            bridgeCallback2.sendBridgeResponse(BridgeResponse.newError(-1, bArr2 != null ? new String(bArr2, Charset.forName("UTF-8")) : sendMtopResponse.errorMsg));
                            return;
                        }
                        String str = new String(bArr, Charset.forName("UTF-8"));
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            b bVar3 = new b(JSON.parseObject(str, Feature.OrderedField).getJSONObject("data").getJSONObject("data"));
                            app.setData(b.class, bVar3);
                            AlibcBridgeExtension.this.a(bVar3, bridgeCallback);
                        } catch (Exception e) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, e.getMessage()));
                        }
                    }
                });
            } else {
                bridgeCallback.sendBridgeResponse(BridgeResponse.NOT_FOUND);
            }
        } catch (Exception e) {
            RVLogger.e(f23660a, "getSuiteConfig error", e);
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, e.getMessage()));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void getApplinkKey(@BindingNode(Page.class) Page page, @BindingParam(name = {ALPParamConstant.ITMEID}) String str, @BindingCallback final BridgeCallback bridgeCallback) {
        AlibcLogger.i(f23660a, "itemId=" + str);
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        TBLiteJudgeBusiness tBLiteJudgeBusiness = new TBLiteJudgeBusiness();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ALPParamConstant.ITMEID, (Object) str);
        tBLiteJudgeBusiness.sendRequest(jSONObject, new NetworkRequestListener() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.8
            @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
            public void onError(int i, NetworkResponse networkResponse) {
                Map<String, Object> map = networkResponse.data;
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1001, "获取唤端类型为空"));
            }

            @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
            public void onSuccess(int i, NetworkResponse networkResponse) {
                Map<String, Object> map = networkResponse.data;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appType", (Object) "");
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        });
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

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbGetBizParam(@BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Set<String> setKeySet;
        Bundle bundleA = a(page);
        JSONObject jSONObject = new JSONObject();
        if (bundleA != null && (setKeySet = bundleA.keySet()) != null && setKeySet.size() > 0) {
            for (String str : setKeySet) {
                Object obj = bundleA.get(str);
                if (!TextUtils.isEmpty(str) && obj != null) {
                    jSONObject.put(str, (Object) String.valueOf(obj));
                }
            }
        }
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbIsLogin(@BindingCallback BridgeCallback bridgeCallback) {
        if (!AlibcSdkManager.getInstance().verifySdkExist("login_sdk")) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "login sdk not exits"));
            return;
        }
        boolean zIsLogin = ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).isLogin();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isLogin", (Object) Boolean.valueOf(zIsLogin));
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbJumpNative(@BindingNode(Page.class) final Page page, @BindingParam(name = {"url"}) final String str, @BindingParam(name = {"linkKey"}) final String str2, @BindingCallback final BridgeCallback bridgeCallback) {
        AlibcLogger.i(f23660a, "linkKey = " + str2 + ", url = " + str);
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String pageUrl = PageUtils.getPageUrl(page);
        final boolean zVerifyMiniappUrl = AlibcProtocolUtils.verifyMiniappUrl(str);
        final String bizType = AlibcProtocolUtils.getBizType(str);
        Bundle bundleA = a(page);
        final Context contextB = b(page);
        final String strA = a(bundleA, zVerifyMiniappUrl, str, pageUrl);
        if ("shop".equals(bizType) || "detail".equals(bizType)) {
            try {
                String strA2 = a(zVerifyMiniappUrl, str, bizType);
                if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                    a(bridgeCallback, zVerifyMiniappUrl, bizType, strA2, strA, contextB, str2, page);
                } else {
                    a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, str2, page, strA);
                }
                return;
            } catch (Exception e) {
                AlibcLogger.e(f23660a, "found exception: " + e.getMessage());
                return;
            }
        }
        if ("taobaolite".equals(bizType)) {
            try {
                String strA3 = com.alibaba.alibctriver.b.a.a(Uri.parse(str).getQueryParameter("id"));
                TBLiteJudgeBusiness tBLiteJudgeBusiness = new TBLiteJudgeBusiness();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ALPParamConstant.ITMEID, (Object) strA3);
                tBLiteJudgeBusiness.sendRequest(jSONObject, new NetworkRequestListener() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.9
                    @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                    public void onError(int i, NetworkResponse networkResponse) {
                        String str3 = networkResponse.errorCode;
                        String str4 = networkResponse.errorMsg;
                        AlibcLogger.e(AlibcBridgeExtension.f23660a, "code=" + str3 + ", msg=" + str4);
                        try {
                            String strA4 = AlibcBridgeExtension.this.a(zVerifyMiniappUrl, str, bizType);
                            if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                                AlibcBridgeExtension.this.a(bridgeCallback, zVerifyMiniappUrl, bizType, strA4, strA, contextB, str2, page);
                            } else {
                                AlibcBridgeExtension.this.a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, str2, page, strA);
                            }
                        } catch (Exception e2) {
                            AlibcLogger.e(AlibcBridgeExtension.f23660a, "found exception: " + e2);
                        }
                    }

                    @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                    public void onSuccess(int i, NetworkResponse networkResponse) {
                        try {
                            String strValueOf = String.valueOf(networkResponse.data.get("data"));
                            if ("taobaolite".equals(strValueOf)) {
                                String strA4 = AlibcBridgeExtension.this.a(zVerifyMiniappUrl, str, bizType);
                                if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                                    AlibcBridgeExtension.this.a(bridgeCallback, zVerifyMiniappUrl, bizType, strA4, strA, contextB, strValueOf, page);
                                } else {
                                    AlibcBridgeExtension.this.a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, strValueOf, page, strA);
                                }
                            } else {
                                String strA5 = AlibcBridgeExtension.this.a(zVerifyMiniappUrl, str, bizType);
                                if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                                    AlibcBridgeExtension.this.a(bridgeCallback, zVerifyMiniappUrl, bizType, strA5, strA, contextB, strValueOf, page);
                                } else {
                                    AlibcBridgeExtension.this.a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, strValueOf, page, strA);
                                }
                            }
                        } catch (Exception e2) {
                            AlibcLogger.e(AlibcBridgeExtension.f23660a, "found exception: " + e2);
                        }
                    }
                });
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (!AlibcUrlCheck.regularCheck(AlibcProtocolConstant.SCLICK_URL_PATTERNS, str)) {
            a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, str2, page, strA);
            return;
        }
        ParseSclickBusiness parseSclickBusiness = new ParseSclickBusiness();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("floorId", (Object) "43676");
        HashMap map = new HashMap();
        map.put("invokerName", "baichuan");
        if (str.startsWith("https") || str.startsWith("http")) {
            map.put("url", str);
        } else {
            map.put("url", "https:" + str);
        }
        map.put("invokeType", "MTOP");
        jSONObject2.put("variableMap", (Object) JSON.toJSONString(map));
        parseSclickBusiness.sendRequest(jSONObject2, new NetworkRequestListener() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.10
            @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
            public void onError(int i, NetworkResponse networkResponse) {
                String str3 = networkResponse.errorCode;
                String str4 = networkResponse.errorMsg;
                AlibcLogger.e(AlibcBridgeExtension.f23660a, "code=" + str3 + ", msg=" + str4);
                AlibcBridgeExtension.this.a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, str2, page, strA);
            }

            @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
            public void onSuccess(int i, NetworkResponse networkResponse) {
                Map<String, Object> map2 = networkResponse.data;
                String str3 = str2;
                if (map2 != null) {
                    try {
                        JSONArray jSONArray = (JSONArray) map2.get("resultList");
                        if (jSONArray != null && jSONArray.size() > 0) {
                            Iterator<Object> it = jSONArray.iterator();
                            while (it.hasNext()) {
                                JSONObject jSONObject3 = ((JSONObject) it.next()).getJSONObject("paramMap");
                                if (jSONObject3 != null && "103".equals(jSONObject3.getString("ut"))) {
                                    str3 = "taobaolite";
                                    break;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        AlibcLogger.e(AlibcBridgeExtension.f23660a, "parse exception: " + e2);
                    }
                }
                AlibcBridgeExtension.this.a(str, contextB, bridgeCallback, zVerifyMiniappUrl, false, bizType, str3, page, strA);
            }
        });
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbLogin(@BindingCallback final BridgeCallback bridgeCallback) {
        if (AlibcSdkManager.getInstance().verifySdkExist("login_sdk")) {
            ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).showLogin(new AlibcLoginCallback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.1
                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public void onFailure(int i, String str) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(i, str));
                }

                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public void onSuccess(String str, String str2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userId", (Object) str);
                    jSONObject.put("nick", (Object) str2);
                    bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
                }
            });
        } else {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "login sdk not exits"));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbLogout(@BindingCallback final BridgeCallback bridgeCallback) {
        if (AlibcSdkManager.getInstance().verifySdkExist("login_sdk")) {
            ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).logout(new AlibcLoginCallback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.6
                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public void onFailure(int i, String str) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(i, str));
                }

                @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
                public void onSuccess(String str, String str2) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                }
            });
        } else {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "login sdk not exits"));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbRebate(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        String pageUrl = PageUtils.getPageUrl(page);
        if (TextUtils.isEmpty(pageUrl) || "null".equals(pageUrl)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        boolean zVerifyMiniappUrl = AlibcProtocolUtils.verifyMiniappUrl(pageUrl);
        String bizType = AlibcProtocolUtils.getBizType(pageUrl);
        Bundle bundleA = a(page);
        if (!"detail".equals(bizType) && !"shop".equals(bizType)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "url is not shop or detail"));
            return;
        }
        try {
            String strA = a(bundleA, zVerifyMiniappUrl, pageUrl, "");
            String strA2 = a(zVerifyMiniappUrl, pageUrl);
            String strB = b(zVerifyMiniappUrl, strA2, pageUrl);
            if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                a(bridgeCallback, zVerifyMiniappUrl, bizType, strB, strA, strA2);
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "ad component not exist"));
            }
        } catch (Exception e) {
            AlibcLogger.e(f23660a, "[BridgeExtension]url is invalid");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, e.getMessage()));
        }
    }

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    public void tbSetBizParam(@BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page, @BindingParam(name = {"params"}) Map<String, String> map) {
        if (map == null) {
            AlibcLogger.e(f23660a, "params is empty");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "params is empty"));
            return;
        }
        Bundle bundleA = a(page);
        if (bundleA == null) {
            bundleA = new Bundle();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                bundleA.putString(key, value);
            }
        }
        page.getApp().getStartParams().putBundle(TRiverConstants.KEY_OVER_PARAMS, bundleA);
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clickid", (Object) str);
        jSONObject.put("url", (Object) str2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("detailUrl", (Object) str2);
        String jSONString = jSONObject2.toJSONString();
        jSONObject.put(LoginConstants.EXT, (Object) jSONString);
        AlibcLogger.i(f23660a, "union convert fail: url = " + str2 + ", ext = " + jSONString);
        return jSONObject;
    }

    private Bundle a(Page page) {
        Bundle startParams;
        if (page == null || page.getApp() == null || (startParams = page.getApp().getStartParams()) == null) {
            return null;
        }
        return startParams.getBundle(TRiverConstants.KEY_OVER_PARAMS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(boolean z, String str, String str2) {
        String strA = a(z, str);
        HashMap map = new HashMap(16);
        if (!TextUtils.isEmpty(strA)) {
            map.put("clickid", strA);
        }
        if (z) {
            HashMap map2 = new HashMap();
            map2.put("shop", str2);
            return AlibcProtocolUtils.reAssembleUrl(str, map, true, map2);
        }
        return a(str, str2);
    }

    private String b(boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        AlibcLogger.i(f23660a, "clickid = " + str);
        HashMap map = new HashMap(16);
        map.put("clickid", str);
        return z ? AlibcProtocolUtils.reAssembleUrl(str2, map, false, null) : str2;
    }

    private String a(String str, String str2) {
        AlibcBizParams alibcBizParams;
        if (!"shop".equals(str2) || (alibcBizParams = AlibcTradeContext.getInstance().bizParams) == null) {
            return str;
        }
        String sellerId = alibcBizParams.getSellerId();
        if (!str.contains("shop_id")) {
            return str;
        }
        return str.replaceFirst("shop_id=\\d+", "user_id=" + sellerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BridgeCallback bridgeCallback, final boolean z, final String str, final String str2, final String str3, final Context context, final String str4, final Page page) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ExecutorManager.getTaskExecutor(com.alibaba.baichuan.trade.common.executor.ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.11
            @Override // java.lang.Runnable
            public void run() {
                ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).executeConvert(z, str, str2, str3, new CpsCommitCallback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.11.1
                    @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
                    public void onFail(String str5, String str6) {
                        AlibcLogger.e(AlibcBridgeExtension.f23660a, "union convert fail: cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", code = " + str5 + ", msg = " + str6);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                        AlibcBridgeExtension.this.a(str2, context, bridgeCallback, z, false, str, str4, page, str3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str2);
                        jSONObject.put("costTime", (Object) String.valueOf(j));
                        AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_UNION, str5, str6, jSONObject);
                        HashMap map = new HashMap();
                        map.put("【方法名】", "tbJumpNative@executeAdConvert");
                        map.put("【入参】", "url: " + str2 + "\nrecoveryId: " + str3 + "\nbizType: " + str + "\nminiappType: " + z);
                        StringBuilder sb = new StringBuilder();
                        sb.append("code: ");
                        sb.append(str5);
                        sb.append("\n");
                        sb.append("msg: ");
                        sb.append(str6);
                        map.put("【返回】", sb.toString());
                        map.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.EXECUTE_APPLINK_FAIL);
                        AlibcProtocolUtils.sendTraceLog(false, "baichuan", "BRIDGE_EXTENSION@EXECUTE_ADCONVERT_FAIL", "BC_API_CALL", "执行转链", map);
                    }

                    @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
                    public void onSuccess(Map<String, String> map) {
                        String str5 = map.get("url");
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        String str6 = map.get("status");
                        AlibcLogger.i(AlibcBridgeExtension.f23660a, "union convert success:  cost time = " + jCurrentTimeMillis2 + ", url = " + str5);
                        HashMap map2 = new HashMap();
                        map2.put("【方法名】", "tbJumpNative@executeAdConvert");
                        map2.put("【入参】", "url: " + str2 + "\nrecoveryId: " + str3 + "\nbizType: " + str + "\nminiappType: " + z);
                        StringBuilder sb = new StringBuilder();
                        sb.append("result: ");
                        sb.append(JSON.toJSONString(map));
                        map2.put("【返回】", sb.toString());
                        AlibcProtocolUtils.sendTraceLog(true, "baichuan", "BRIDGE_EXTENSION@EXECUTE_ADCONVERT_SUCCESS", "BC_API_CALL", "执行转链", map2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str2);
                        jSONObject.put(UserTrackConstant.RESULT_URL, (Object) str5);
                        jSONObject.put("status", (Object) str6);
                        jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                        if (!TextUtils.isEmpty(str5)) {
                            AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                            AlibcBridgeExtension.this.a(str5, context, bridgeCallback, z, true, str, str4, page, str3);
                            AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_UNION, "", "", jSONObject);
                        } else {
                            boolean z2 = "3".equals(str6) && AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str2);
                            AnonymousClass11 anonymousClass12 = AnonymousClass11.this;
                            AlibcBridgeExtension.this.a(str2, context, bridgeCallback, z, false, str, str4, page, str3);
                            AlibcUserTracker.getInstance().trackAlarm(z2, UserTrackConstant.E_CONVERT_UNION, "code_empty", "empty url", jSONObject);
                        }
                    }
                });
            }
        });
    }

    private void a(final BridgeCallback bridgeCallback, final boolean z, final String str, final String str2, final String str3, final String str4) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ExecutorManager.getTaskExecutor(com.alibaba.baichuan.trade.common.executor.ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.2
            @Override // java.lang.Runnable
            public void run() {
                ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).executeConvert(z, str, str2, str3, new CpsCommitCallback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.2.1
                    @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
                    public void onFail(String str5, String str6) {
                        AlibcLogger.e(AlibcBridgeExtension.f23660a, "union convert fail: code = " + str5 + ", msg = " + str6);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        bridgeCallback.sendBridgeResponse(new BridgeResponse(AlibcBridgeExtension.this.b(str4, str2)));
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        HashMap map = new HashMap();
                        map.put("【方法名】", "AlibcBridgeExtension@executeAdConvert");
                        map.put("【入参】", "url: " + str2 + "\nrecoveryId: " + str3 + "\nbizType: " + str + "\nminiappType: " + z);
                        StringBuilder sb = new StringBuilder();
                        sb.append("code: ");
                        sb.append(str5);
                        sb.append("\n");
                        sb.append("msg: ");
                        sb.append(str6);
                        map.put("【返回】", sb.toString());
                        map.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.EXECUTE_APPLINK_FAIL);
                        AlibcProtocolUtils.sendTraceLog(false, "baichuan", "BRIDGE_EXTENSION@EXECUTE_ADCONVERT_FAIL", "BC_API_CALL", "执行转链", map);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str2);
                        jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                        AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_UNION, str5, str6, jSONObject);
                    }

                    @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
                    public void onSuccess(Map<String, String> map) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
                        a aVar = AlibcBridgeExtension.this.new a(str2);
                        AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                        JSONObject jSONObjectA = AlibcBridgeExtension.this.a(map, str4, aVar);
                        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObjectA));
                        TRiverConstant.BC_LINK_CODE = BCErrorEnum.DETAIL_CPS_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
                        HashMap map2 = new HashMap();
                        map2.put("【方法名】", "tbRebate@executeAdConvert");
                        map2.put("【入参】", "url: " + str2 + "\nrecoveryId: " + str3 + "\nbizType: " + str + "\nminiappType: " + z);
                        StringBuilder sb = new StringBuilder();
                        sb.append("result: ");
                        sb.append(jSONObjectA.toJSONString());
                        map2.put("【返回】", sb.toString());
                        AlibcProtocolUtils.sendTraceLog(true, "baichuan", "BRIDGE_EXTENSION@EXECUTE_ADCONVERT_SUCCESS", "BC_API_CALL", "执行转链", map2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) aVar.b);
                        jSONObject.put(UserTrackConstant.RESULT_URL, (Object) aVar.c);
                        jSONObject.put("status", (Object) aVar.d);
                        jSONObject.put("costTime", (Object) String.valueOf(j));
                        AlibcUserTracker.getInstance().trackAlarm(aVar.e, UserTrackConstant.E_CONVERT_UNION, aVar.e ? "" : "code_empty", "", jSONObject);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(Map<String, String> map, String str, a aVar) {
        String str2;
        String jSONString;
        if (map != null) {
            AlibcLogger.i(f23660a, "union convert success: data = " + map.toString());
            str2 = map.get("url");
            jSONString = map.get(LoginConstants.EXT);
            aVar.d = map.get("status");
        } else {
            str2 = "";
            jSONString = "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clickid", (Object) str);
        if (TextUtils.isEmpty(str2) || "null".equals(str2)) {
            aVar.e = false;
            str2 = aVar.b;
        }
        aVar.c = str2;
        jSONObject.put("url", (Object) str2);
        if (TextUtils.isEmpty(jSONString)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("detailUrl", (Object) aVar.b);
            jSONString = jSONObject2.toJSONString();
        }
        jSONObject.put(LoginConstants.EXT, (Object) jSONString);
        AlibcLogger.i(f23660a, "union convert success: url = " + str2 + ", ext = " + jSONString);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final Context context, final BridgeCallback bridgeCallback, boolean z, boolean z2, String str2, String str3, final Page page, String str4) {
        final Map<String, Object> mapA = a(str2, z, str3, page, str4);
        boolean zRegularCheck = AlibcUrlCheck.regularCheck(com.alibaba.alibctriver.a.a.c, str);
        final String applinkType = AlibcProtocolUtils.getApplinkType(z2, z);
        if (zRegularCheck) {
            a(bridgeCallback, context, mapA, str, applinkType, (page == null || page.getApp() == null) ? null : page.getApp().getStartParams());
        } else if (z && !z2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            AlibcProtocolUtils.convertUrl(str, new NetworkRequestListener() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.3
                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public void onError(int i, NetworkResponse networkResponse) {
                    AlibcLogger.e(AlibcBridgeExtension.f23660a, "covert h5 fail: code = " + networkResponse.errorCode + ", msg = " + networkResponse.errorMsg);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                    jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, networkResponse.errorCode, networkResponse.errorMsg, jSONObject);
                    AlibcBridgeExtension alibcBridgeExtension = AlibcBridgeExtension.this;
                    BridgeCallback bridgeCallback2 = bridgeCallback;
                    Context context2 = context;
                    Map map = mapA;
                    String str5 = str;
                    String str6 = applinkType;
                    Page page2 = page;
                    alibcBridgeExtension.a(bridgeCallback2, context2, (Map<String, Object>) map, str5, str6, (page2 == null || page2.getApp() == null) ? null : page.getApp().getStartParams());
                }

                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public void onSuccess(int i, NetworkResponse networkResponse) {
                    if (networkResponse != null) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                        AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, "", "", jSONObject);
                        Map<String, Object> map = networkResponse.data;
                        if (map != null) {
                            String strValueOf = String.valueOf(map.get("result"));
                            AlibcLogger.i(AlibcBridgeExtension.f23660a, "convert h5 url: " + strValueOf);
                            AlibcBridgeExtension alibcBridgeExtension = AlibcBridgeExtension.this;
                            BridgeCallback bridgeCallback2 = bridgeCallback;
                            Context context2 = context;
                            Map map2 = mapA;
                            String str5 = applinkType;
                            Page page2 = page;
                            alibcBridgeExtension.a(bridgeCallback2, context2, (Map<String, Object>) map2, strValueOf, str5, (page2 == null || page2.getApp() == null) ? null : page.getApp().getStartParams());
                        }
                    }
                }
            });
        } else {
            a(bridgeCallback, context, mapA, str, applinkType, (page == null || page.getApp() == null) ? null : page.getApp().getStartParams());
        }
    }

    private Map<String, Object> a(String str, boolean z, String str2, Page page, String str3) {
        Set<String> setKeySet;
        Map<String, Object> map = new HashMap<>();
        if (z) {
            Bundle bundle = page.getApp().getStartParams().getBundle(TRiverConstants.KEY_OVER_PARAMS);
            if (bundle != null && (setKeySet = bundle.keySet()) != null && setKeySet.size() > 0) {
                for (String str4 : setKeySet) {
                    Object obj = bundle.get(str4);
                    if (!TextUtils.isEmpty(str4) && obj != null) {
                        map.put(str4, obj);
                    }
                }
            }
        } else {
            AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
            map = AlibcProtocolUtils.obj2Map(alibcTradeContext.showParams, alibcTradeContext.taokeParams, str, false, null);
        }
        map.put("clientType", str2);
        map.put(AlibcProtocolConstant.RECOVER_ID, str3);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BridgeCallback bridgeCallback, final Context context, final Map<String, Object> map, final String str, final String str2, final Bundle bundle) {
        if (AlibcSdkManager.getInstance().verifySdkExist("applink_sdk")) {
            ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(context, str, map, new AppLinkOpenCallback() { // from class: com.alibaba.alibctriver.extensions.AlibcBridgeExtension.4
                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public void getLinkUrl(boolean z, String str3, String str4, int i) {
                    AlibcBridgeExtension.this.a(z, bridgeCallback, i, str3, context, str2, bundle);
                    HashMap map2 = new HashMap();
                    map2.put("【方法名】", "AlibcBridgeExtension@executeApplink");
                    map2.put("【入参】", "url: " + str + "\nparams: " + JSON.toJSONString(map));
                    StringBuilder sb = new StringBuilder();
                    sb.append("targetClient: ");
                    sb.append(str3);
                    sb.append("\n");
                    sb.append("code: ");
                    sb.append(i);
                    sb.append("\n");
                    sb.append("msg: ");
                    sb.append(z ? "唤端成功" : "唤端失败");
                    map2.put("【返回】", sb.toString());
                    AlibcProtocolUtils.sendTraceLog(z, "baichuan", z ? "BRIDGE_EXTENSION@EXECUTE_APPLINK_SUCCESS" : "BRIDGE_EXTENSION@EXECUTE_APPLINK_FAIL", "BC_API_CALL", "执行唤端", map2);
                }

                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public void supportFail(String str3, String str4) {
                    AlibcBridgeExtension.this.c(str3, str4);
                }
            });
        } else {
            AlibcLogger.i(f23660a, "applink sdk not exist");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, BridgeCallback bridgeCallback, int i, String str, Context context, String str2, Bundle bundle) {
        UserTrackUtils.sendApplinkUserTrack(null, z, i, str2, -1);
        if (z) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            return;
        }
        AlibcLogger.e(f23660a, "launch app fail: code = " + i);
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(i, "唤端失败"));
        if ("taobao".equals(str)) {
            AlibcTradeContext.getInstance().context = context;
            AlibcContainerManager.loadUrl("h5", AlibcProtocolConstant.TAOBAO_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        } else if ("tmall".equals(str)) {
            AlibcTradeContext.getInstance().context = context;
            AlibcContainerManager.loadUrl("h5", AlibcProtocolConstant.TMALL_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        } else {
            AlibcTradeContext.getInstance().context = context;
            AlibcContainerManager.loadUrl("h5", AlibcProtocolConstant.TAOBAO_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        }
    }

    private String a(boolean z, String str) {
        return z ? ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).getClickId(str, true) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, BridgeCallback bridgeCallback) {
        JSONObject jSONObject;
        if (bVar != null && (jSONObject = bVar.f23675a) != null) {
            bridgeCallback.sendJSONResponse(jSONObject);
        } else {
            bridgeCallback.sendJSONResponse(new JSONObject());
        }
    }
}
