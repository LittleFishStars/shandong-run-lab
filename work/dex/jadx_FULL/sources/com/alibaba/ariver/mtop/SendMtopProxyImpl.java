package com.alibaba.ariver.mtop;

import android.content.Context;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.jsapi.security.TBAccessToken;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.monitor.RVCountDispatcher;
import com.alibaba.ariver.mtop.monitor.TRVMonitor;
import com.alibaba.ariver.permission.extension.auth.b;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.ApiTypeEnum;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopAccountSiteUtils;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.xstate.XState;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SendMtopProxyImpl implements IMtopProxy {
    public static final String MTOP_NEEDLOGIN_FORCE = "mtop_needLoginForce";
    public static final String MTOP_SET_INNER_PAGE_INFO_KEY = "mtop_setInnerPageInfoNull";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24345a = "SendMtopProxyImpl";
    private static final String b = "AutoLoginOnly";
    private static final String c = "____";
    private static final String d = "mtop_auth_downgrade";

    /* JADX INFO: renamed from: com.alibaba.ariver.mtop.SendMtopProxyImpl$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24348a;

        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            f24348a = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24348a[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24348a[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(App app, SendMtopParams sendMtopParams, float f) {
        AppModel appModel;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeCost", (Object) Float.valueOf(f));
        String str = "";
        jSONObject.put("apiName", (Object) (sendMtopParams != null ? sendMtopParams.api : ""));
        jSONObject.put("miniAppId", (Object) ((sendMtopParams == null || sendMtopParams.getHeaders() == null) ? "" : sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.f)));
        if (sendMtopParams != null && sendMtopParams.getExtraDataMap() != null) {
            str = sendMtopParams.getExtraDataMap().get("pluginId");
        }
        jSONObject.put("pluginId", (Object) str);
        if (app != null && (appModel = (AppModel) app.getData(AppModel.class)) != null && appModel.getAppInfoModel() != null) {
            jSONObject.put("deployVersion", (Object) appModel.getAppInfoModel().getVersion());
            jSONObject.put("developerVersion", (Object) appModel.getAppInfoModel().getDeveloperVersion());
            if (appModel.getAppInfoModel().getTemplateConfig() != null) {
                jSONObject.put("templateId", (Object) appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
            }
            if (appModel.getExtendInfos() != null) {
                jSONObject.put("bizType", (Object) String.valueOf(appModel.getExtendInfos().getInteger("bizType")));
                jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) String.valueOf(appModel.getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE)));
            }
        }
        ((TRVMonitor) RVProxy.get(TRVMonitor.class)).trackAlarm(true, TriverLogProxyImpl.TLOG_MODULE, "mtop", null, null, jSONObject.toString());
        if (!a(sendMtopParams) || sendMtopParams.getHeaders() == null || sendMtopParams.getDataMap() == null) {
            return;
        }
        a(sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.f), sendMtopParams.getDataMap().get("fcName"), sendMtopParams.getDataMap().get("handler"), f);
    }

    public MtopBusiness buildMtopBusiness(App app, SendMtopParams sendMtopParams) {
        String instanceId;
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(sendMtopParams.api);
        mtopRequest.setVersion(sendMtopParams.v);
        boolean z = true;
        if (TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("mtop_needLoginForce", null), "true")) {
            if (!sendMtopParams.needLogin && !sendMtopParams.needAuth) {
                z = false;
            }
            mtopRequest.setNeedEcode(z);
        } else if (sendMtopParams.needAuth) {
            Boolean bool = sendMtopParams.forceLogin;
            mtopRequest.setNeedEcode(bool != null ? bool.booleanValue() : true);
        } else {
            mtopRequest.setNeedEcode(sendMtopParams.needLogin);
        }
        mtopRequest.setNeedSession(sendMtopParams.needLogin);
        mtopRequest.dataParams = sendMtopParams.getDataMap();
        if (sendMtopParams.getDataMap() != null) {
            mtopRequest.setData(JSON.toJSONString(sendMtopParams.getDataMap()));
        }
        try {
            instanceId = MtopAccountSiteUtils.getInstanceId(sendMtopParams.accountSite);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            instanceId = null;
        }
        if (TextUtils.isEmpty(instanceId)) {
            if (!TextUtils.isEmpty(sendMtopParams.accountSite)) {
                return null;
            }
            instanceId = "INNER";
        }
        Mtop mtopInstance = getMtopInstance(instanceId, sendMtopParams);
        String str = mtopInstance.getMtopConfig().ttid;
        if (!TextUtils.isEmpty(sendMtopParams.ttid)) {
            str = sendMtopParams.ttid;
        }
        MtopBusiness mtopBusinessBuild = MtopBusiness.build(mtopInstance, mtopRequest, str);
        configMtopBussiness(app, mtopBusinessBuild, sendMtopParams);
        return mtopBusinessBuild;
    }

    public MtopBusiness buildMtopBusinessInner(SendMtopParams sendMtopParams) {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setData(JSON.toJSONString(sendMtopParams.getDataMap()));
        mtopRequest.setApiName(sendMtopParams.api);
        mtopRequest.setVersion(sendMtopParams.v);
        mtopRequest.setNeedEcode(sendMtopParams.needLogin);
        mtopRequest.setNeedSession(sendMtopParams.needLogin);
        Mtop mtopInstance = getMtopInstance("INNER", sendMtopParams);
        String str = mtopInstance.getMtopConfig().ttid;
        if (!TextUtils.isEmpty(sendMtopParams.ttid)) {
            str = sendMtopParams.ttid;
        }
        MtopBusiness mtopBusinessBuild = MtopBusiness.build(mtopInstance, mtopRequest, str);
        configMtopBusinessInner(mtopBusinessBuild, sendMtopParams);
        return mtopBusinessBuild;
    }

    public SendMtopResponse buildResponse(MtopResponse mtopResponse) {
        SendMtopResponse sendMtopResponse = new SendMtopResponse();
        if (mtopResponse == null) {
            sendMtopResponse.success = false;
            sendMtopResponse.errorCode = "MTOP_RESPONSE_NULL";
            sendMtopResponse.errorMsg = "网络请求异常";
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "MTOP_RESPONSE_NULL", "Mtop", "", "", null);
            return sendMtopResponse;
        }
        if (mtopResponse.getBytedata() == null) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "mtop response data is null", "Mtop", "", "", null);
            RVLogger.d("[mtop]", "response data is null");
            sendMtopResponse.success = false;
            sendMtopResponse.errorCode = mtopResponse.getRetCode();
            sendMtopResponse.errorMsg = mtopResponse.getRetMsg();
            return sendMtopResponse;
        }
        if (mtopResponse.isApiSuccess()) {
            sendMtopResponse.success = true;
            sendMtopResponse.data = mtopResponse.getBytedata();
        } else {
            sendMtopResponse.success = false;
            sendMtopResponse.errorCode = mtopResponse.getRetCode();
            sendMtopResponse.errorMsg = mtopResponse.getRetMsg();
            sendMtopResponse.data = mtopResponse.getBytedata();
        }
        return sendMtopResponse;
    }

    public void configMtopBusinessInner(MtopBusiness mtopBusiness, SendMtopParams sendMtopParams) {
        mtopBusiness.setCustomDomain("guide-acs.m.taobao.com", "guide-acs.wapa.taobao.com", "");
        if (TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(MTOP_SET_INNER_PAGE_INFO_KEY, null), "yes")) {
            mtopBusiness.setPageUrl("");
            mtopBusiness.setPageName("");
        }
        mtopBusiness.setJsonType(JsonTypeEnum.valueOf(JsonTypeEnum.ORIGINALJSON.name().toUpperCase()));
        mtopBusiness.setBizId(60);
    }

    public void configMtopBussiness(App app, MtopBusiness mtopBusiness, SendMtopParams sendMtopParams) {
        if (TextUtils.isEmpty(sendMtopParams.accountSite) || "taobao".equalsIgnoreCase(sendMtopParams.accountSite)) {
            mtopBusiness.setCustomDomain(getDomain(EnvModeEnum.ONLINE, mtopBusiness.getMtopInstance()), getDomain(EnvModeEnum.PREPARE, mtopBusiness.getMtopInstance()), getDomain(EnvModeEnum.TEST, mtopBusiness.getMtopInstance()));
        }
        RVLogger.d(f24345a, "startParams:" + sendMtopParams.getStartParams() + " userInfo:" + ((MtopBuilder) mtopBusiness).mtopProp.userInfo);
        if (sendMtopParams.getParameterMap() != null) {
            for (Map.Entry<String, String> entry : sendMtopParams.getParameterMap().entrySet()) {
                mtopBusiness.addHttpQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        mtopBusiness.setPageUrl(sendMtopParams.pageUrl);
        if ("AliApp".equalsIgnoreCase(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getAppGroup()) && !TextUtils.isEmpty(sendMtopParams.mpHost)) {
            mtopBusiness.setCustomDomain(sendMtopParams.mpHost);
        }
        if (!TextUtils.isEmpty(sendMtopParams.dataType) && ("json".equals(sendMtopParams.dataType) || "originaljson".equals(sendMtopParams.dataType))) {
            mtopBusiness.setJsonType(JsonTypeEnum.valueOf(sendMtopParams.dataType.toUpperCase()));
        }
        mtopBusiness.setBizId(60);
        long j = sendMtopParams.timer;
        if (j > 0) {
            mtopBusiness.setSocketTimeoutMilliSecond((int) j);
            mtopBusiness.setConnectionTimeoutMilliSecond((int) sendMtopParams.timer);
        }
        mtopBusiness.showLoginUI(!b.equals(sendMtopParams.sessionOption));
        if (sendMtopParams.wuaFlag > 0) {
            mtopBusiness.useWua();
        }
        String str = sendMtopParams.getHeaders().get("x-mini-appkey");
        mtopBusiness.setOpenBiz("mini-app");
        MethodEnum methodEnum = MethodEnum.GET;
        if (!TextUtils.equals(methodEnum.getMethod(), sendMtopParams.method)) {
            methodEnum = MethodEnum.POST;
        }
        mtopBusiness.reqMethod(methodEnum);
        if (sendMtopParams.getHeaders() != null) {
            mtopBusiness.setMiniAppKey(str);
            mtopBusiness.setRequestSourceAppKey(sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.c));
            mtopBusiness.setOpenBizData(sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.e));
            mtopBusiness.headers(sendMtopParams.getHeaders());
        }
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(sendMtopParams.userAgent)) {
            map.put("x-ua", getUserAgent(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()));
        } else {
            map.put("x-ua", sendMtopParams.userAgent);
        }
        mtopBusiness.headers(map);
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(app != null ? app.getAppId() : sendMtopParams.getAppId(), b.a(app, sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.b) + "token"));
        TBAccessToken tBAccessToken = !TextUtils.isEmpty(string) ? new TBAccessToken(string) : null;
        if (TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(d, null), "true")) {
            if (sendMtopParams.needAuth) {
                MtopNetworkProp mtopNetworkProp = ((MtopBuilder) mtopBusiness).mtopProp;
                mtopNetworkProp.apiType = ApiTypeEnum.ISV_OPEN_API;
                mtopNetworkProp.isInnerOpen = true;
                if (!TextUtils.isEmpty(str)) {
                    ((MtopBuilder) mtopBusiness).mtopProp.openAppKey = str;
                }
                mtopBusiness.addOpenApiParams(str, "");
            }
        } else if (sendMtopParams.needAuth) {
            if (!sendMtopParams.ignoreAuth) {
                ((MtopBuilder) mtopBusiness).mtopProp.apiType = ApiTypeEnum.ISV_OPEN_API;
            }
            MtopNetworkProp mtopNetworkProp2 = ((MtopBuilder) mtopBusiness).mtopProp;
            mtopNetworkProp2.isInnerOpen = true;
            mtopNetworkProp2.openAppKey = str;
            mtopNetworkProp2.accessToken = "";
        }
        String strConcatStr = StringUtils.concatStr(mtopBusiness.getMtopInstance().getInstanceId(), str);
        if (tBAccessToken == null || TextUtils.isEmpty(tBAccessToken.accessToken) || tBAccessToken.isFailure()) {
            XState.removeKey(strConcatStr, "accessToken");
        } else {
            XState.setValue(strConcatStr, "accessToken", tBAccessToken.accessToken);
        }
    }

    public String getDomain(EnvModeEnum envModeEnum, Mtop mtop) {
        int i = AnonymousClass5.f24348a[envModeEnum.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "guide-acs.wapa.taobao.com";
        }
        return (mtop == null || !"guide-acs.m.taobao.com".equals(mtop.getMtopConfig().mtopDomain.getDomain(envModeEnum))) ? "acs4miniapp-inner.m.taobao.com" : "guide-acs4miniapp-inner.m.taobao.com";
    }

    public Mtop getMtopInstance(String str, SendMtopParams sendMtopParams) {
        return Mtop.instance(str, ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    public String getRequestCache(App app, String str, String str2, Map<String, String> map) {
        return null;
    }

    public String getUserAgent(Context context) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        String productVersion = rVEnvironmentService.getProductVersion();
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        String appName = rVEnvironmentService.getAppName();
        return str + "(Android" + WVNativeCallbackUtil.SEPERATER + str2 + ") " + rVEnvironmentService.getAppGroup() + "(" + appName + WVNativeCallbackUtil.SEPERATER + productVersion + ") " + EngineUtils.getUserAgentSuffix();
    }

    public void putRequestCache(App app, String str, String str2, Map<String, String> map, byte[] bArr) {
    }

    @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy
    public void requestAsync(final App app, final SendMtopParams sendMtopParams, final IMtopProxy.Callback callback) {
        String requestCache;
        if (callback == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final SendMtopResponse sendMtopResponse = new SendMtopResponse();
        if (sendMtopParams == null || TextUtils.isEmpty(sendMtopParams.api)) {
            sendMtopResponse.errorMsg = String.valueOf(2);
            sendMtopResponse.errorCode = "invalid parameter!";
            callback.onResult(sendMtopResponse);
            return;
        }
        if (app != null) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).performanceLog("start sendMtopAsync, api = " + sendMtopParams.api, "sendMtopAsync", app.getAppId(), app.getActivePage() != null ? app.getActivePage().getPageURI() : "", new HashMap());
        }
        if (app == null || (requestCache = getRequestCache(app, sendMtopParams.api, sendMtopParams.v, sendMtopParams.getDataMap())) == null) {
            final MtopBusiness mtopBusinessBuildMtopBusiness = buildMtopBusiness(app, sendMtopParams);
            if (mtopBusinessBuildMtopBusiness != null) {
                mtopBusinessBuildMtopBusiness.registerListener(new IRemoteBaseListener() { // from class: com.alibaba.ariver.mtop.SendMtopProxyImpl.3
                    public void onError(int i, MtopResponse mtopResponse, Object obj) {
                        sendMtopResponse.errorCode = mtopResponse.getRetCode();
                        sendMtopResponse.errorMsg = mtopResponse.getRetMsg();
                        sendMtopResponse.data = mtopResponse.getBytedata();
                        sendMtopResponse.success = mtopResponse.isApiSuccess();
                        callback.onResult(sendMtopResponse);
                        SendMtopProxyImpl sendMtopProxyImpl = SendMtopProxyImpl.this;
                        App app2 = app;
                        SendMtopResponse sendMtopResponse2 = sendMtopResponse;
                        sendMtopProxyImpl.a(app2, sendMtopResponse2.errorCode, sendMtopResponse2.data, sendMtopParams);
                        SendMtopProxyImpl.this.a(app, sendMtopParams, mtopResponse);
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQEUST_FAILED", sendMtopParams.api + "____" + sendMtopParams.v + "____" + sendMtopResponse.errorCode + sendMtopResponse.errorMsg, "Api", "", null, null);
                        SendMtopProxyImpl.this.a(app, sendMtopParams, sendMtopResponse, (float) (System.currentTimeMillis() - jCurrentTimeMillis));
                    }

                    public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                        sendMtopResponse.errorCode = mtopResponse.getRetCode();
                        sendMtopResponse.errorMsg = mtopResponse.getRetMsg();
                        sendMtopResponse.data = mtopResponse.getBytedata();
                        sendMtopResponse.success = mtopResponse.isApiSuccess();
                        SendMtopProxyImpl sendMtopProxyImpl = SendMtopProxyImpl.this;
                        App app2 = app;
                        SendMtopParams sendMtopParams2 = sendMtopParams;
                        sendMtopProxyImpl.putRequestCache(app2, sendMtopParams2.api, sendMtopParams2.v, sendMtopParams2.getDataMap(), mtopResponse.getBytedata());
                        callback.onResult(sendMtopResponse);
                        if (app != null) {
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).performanceLog("end sendMtopAsync, api = " + sendMtopParams.api, "sendMtopAsync", app.getAppId(), app.getActivePage() != null ? app.getActivePage().getPageURI() : "", new HashMap());
                        }
                        RVCountDispatcher.c cVar = new RVCountDispatcher.c();
                        cVar.h = 1;
                        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                        cVar.h = 3;
                        cVar.i = System.currentTimeMillis() - jCurrentTimeMillis;
                        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQUEST_SUCCESS", "async____" + sendMtopParams.api + "____" + sendMtopParams.v + "____TimeCost= " + cVar.i, "Api", "", null, null);
                        SendMtopProxyImpl.this.a(mtopBusinessBuildMtopBusiness);
                        SendMtopProxyImpl.this.a(app, sendMtopParams, (float) cVar.i);
                    }

                    public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                        onError(i, mtopResponse, obj);
                        SendMtopProxyImpl.this.a(app, sendMtopResponse.errorCode, mtopResponse.getBytedata(), sendMtopParams);
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQEUST_FAILED", "async____" + sendMtopParams.api + "____" + sendMtopParams.v + "____" + sendMtopResponse.errorCode + sendMtopResponse.errorMsg, "Api", "", null, null);
                    }
                });
                mtopBusinessBuildMtopBusiness.startRequest();
                return;
            } else {
                sendMtopResponse.success = false;
                sendMtopResponse.errorCode = "20";
                sendMtopResponse.errorMsg = "不支持的账号实例";
                callback.onResult(sendMtopResponse);
                return;
            }
        }
        sendMtopResponse.data = requestCache.getBytes();
        sendMtopResponse.success = true;
        ((RVMonitor) RVProxy.get(RVMonitor.class)).performance("sendMtopHintCache", new HashMap<String, Object>(sendMtopParams) { // from class: com.alibaba.ariver.mtop.SendMtopProxyImpl.2
            final /* synthetic */ SendMtopParams val$params;

            {
                this.val$params = sendMtopParams;
                put("api", sendMtopParams.api);
                put("method", "sendMtopAsync");
            }
        }, null, null, null);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).performanceLog("end sendMtopAsync, hit cache, api = " + sendMtopParams.api, "sendMtopAsync", app.getAppId(), app.getActivePage() != null ? app.getActivePage().getPageURI() : "", new HashMap());
        callback.onResult(sendMtopResponse);
    }

    @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy
    public void requestInnerAsync(SendMtopParams sendMtopParams, final IMtopProxy.Callback callback) {
        final MtopBusiness mtopBusinessBuildMtopBusinessInner = buildMtopBusinessInner(sendMtopParams);
        if (mtopBusinessBuildMtopBusinessInner == null) {
            SendMtopResponse sendMtopResponse = new SendMtopResponse();
            sendMtopResponse.success = false;
            sendMtopResponse.errorCode = "20";
            sendMtopResponse.errorMsg = "不支持的账号实例";
            callback.onResult(sendMtopResponse);
            a();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        RVLogger.d(RVLogger.makeLogTag(f24345a), "mtop async request , api:" + sendMtopParams.api);
        mtopBusinessBuildMtopBusinessInner.registerListener(new IRemoteBaseListener() { // from class: com.alibaba.ariver.mtop.SendMtopProxyImpl.4
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                RVLogger.e(RVLogger.makeLogTag(SendMtopProxyImpl.f24345a), "mtop async failed , api: " + mtopResponse.getApi() + ", code: " + mtopResponse.getRetCode() + ", msg: " + mtopResponse.getRetMsg() + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                try {
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "[Mtop Error] " + mtopResponse.getRetCode() + ", " + mtopResponse.getRetMsg(), "Mtop", "", "", null);
                    callback.onResult(SendMtopProxyImpl.this.buildResponse(mtopResponse));
                    SendMtopProxyImpl.this.a();
                } catch (Exception e) {
                    SendMtopResponse sendMtopResponse2 = new SendMtopResponse();
                    sendMtopResponse2.success = false;
                    sendMtopResponse2.errorCode = e.getMessage();
                    sendMtopResponse2.errorMsg = e.getMessage();
                    callback.onResult(sendMtopResponse2);
                    SendMtopProxyImpl.this.a();
                }
            }

            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                RVLogger.d(RVLogger.makeLogTag(SendMtopProxyImpl.f24345a), "mtop async success , api: " + mtopResponse.getApi() + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                try {
                    SendMtopResponse sendMtopResponseBuildResponse = SendMtopProxyImpl.this.buildResponse(mtopResponse);
                    if (sendMtopResponseBuildResponse.success) {
                        callback.onResult(sendMtopResponseBuildResponse);
                        RVCountDispatcher.c cVar = new RVCountDispatcher.c();
                        cVar.h = 1;
                        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                        cVar.h = 3;
                        cVar.i = System.currentTimeMillis() - jCurrentTimeMillis;
                        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                        SendMtopProxyImpl.this.a(mtopBusinessBuildMtopBusinessInner);
                    } else {
                        callback.onResult(sendMtopResponseBuildResponse);
                        SendMtopProxyImpl.this.a();
                    }
                } catch (Exception e) {
                    SendMtopResponse sendMtopResponse2 = new SendMtopResponse();
                    sendMtopResponse2.success = false;
                    sendMtopResponse2.errorCode = e.getMessage();
                    sendMtopResponse2.errorMsg = e.getMessage();
                    callback.onResult(sendMtopResponse2);
                    SendMtopProxyImpl.this.a();
                }
            }

            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                onError(i, mtopResponse, obj);
            }
        });
        mtopBusinessBuildMtopBusinessInner.startRequest();
    }

    @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy
    public SendMtopResponse requestInnerSync(SendMtopParams sendMtopParams) {
        MtopBusiness mtopBusinessBuildMtopBusinessInner = buildMtopBusinessInner(sendMtopParams);
        if (mtopBusinessBuildMtopBusinessInner == null) {
            SendMtopResponse sendMtopResponse = new SendMtopResponse();
            sendMtopResponse.success = false;
            sendMtopResponse.errorCode = "20";
            sendMtopResponse.errorMsg = "不支持的账号实例";
            return sendMtopResponse;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            RVLogger.d(RVLogger.makeLogTag(f24345a), "mtop sync request , api: " + sendMtopParams.api);
            MtopResponse mtopResponseSyncRequest = mtopBusinessBuildMtopBusinessInner.syncRequest();
            RVLogger.d(RVLogger.makeLogTag(f24345a), "mtop sync success , api: " + sendMtopParams.api + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            SendMtopResponse sendMtopResponseBuildResponse = buildResponse(mtopResponseSyncRequest);
            if (sendMtopResponseBuildResponse.success) {
                RVCountDispatcher.c cVar = new RVCountDispatcher.c();
                cVar.h = 1;
                ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                cVar.h = 3;
                cVar.i = System.currentTimeMillis() - jCurrentTimeMillis;
                ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                a(mtopBusinessBuildMtopBusinessInner);
            } else {
                a();
            }
            return sendMtopResponseBuildResponse;
        } catch (Exception e) {
            RVLogger.e(RVLogger.makeLogTag(f24345a), "mtop sync failed , api: " + sendMtopParams.api + ", message: " + e.getMessage() + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            SendMtopResponse sendMtopResponse2 = new SendMtopResponse();
            sendMtopResponse2.success = false;
            sendMtopResponse2.errorCode = e.getMessage();
            sendMtopResponse2.errorMsg = e.getMessage();
            a();
            return sendMtopResponse2;
        }
    }

    @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy
    public SendMtopResponse requestSync(App app, SendMtopParams sendMtopParams) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SendMtopResponse sendMtopResponse = new SendMtopResponse();
        if (TextUtils.isEmpty(sendMtopParams.api)) {
            sendMtopResponse.errorMsg = String.valueOf(2);
            sendMtopResponse.errorCode = "invalid parameter!";
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQUEST_FAILED", sendMtopParams.api + "____" + sendMtopParams.v + "____" + sendMtopResponse.errorCode + sendMtopResponse.errorMsg, "Api", "", null, null);
            return sendMtopResponse;
        }
        if (app != null) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).performanceLog("start sendMtop, api = " + sendMtopParams.api, "sendMtop", app.getAppId(), app.getActivePage() != null ? app.getActivePage().getPageURI() : "", new HashMap());
            try {
                String requestCache = getRequestCache(app, sendMtopParams.api, sendMtopParams.v, sendMtopParams.getDataMap());
                if (requestCache != null) {
                    sendMtopResponse.data = requestCache.getBytes();
                    sendMtopResponse.success = true;
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).performance("sendMtopHintCache", new HashMap<String, Object>(sendMtopParams) { // from class: com.alibaba.ariver.mtop.SendMtopProxyImpl.1
                        final /* synthetic */ SendMtopParams val$mtopRequestModel;

                        {
                            this.val$mtopRequestModel = sendMtopParams;
                            put("api", sendMtopParams.api);
                            put("method", "requestSync");
                        }
                    }, null, null, null);
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).performanceLog("end sendMtop, hit cache, api = " + sendMtopParams.api, "sendMtop", app.getAppId(), app.getActivePage() != null ? app.getActivePage().getPageURI() : "", new HashMap());
                    return sendMtopResponse;
                }
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
            }
            RVLogger.e(f24345a, "mtop request miss : " + sendMtopParams.api + " version : " + sendMtopParams.v);
        }
        MtopBusiness mtopBusinessBuildMtopBusiness = buildMtopBusiness(app, sendMtopParams);
        if (mtopBusinessBuildMtopBusiness == null) {
            sendMtopResponse.success = false;
            sendMtopResponse.errorCode = "20";
            sendMtopResponse.errorMsg = "不支持的账号实例";
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQUEST_FAILED", sendMtopParams.api + "____" + sendMtopParams.v + "____" + sendMtopResponse.errorCode + sendMtopResponse.errorMsg, "Api", "", null, null);
            return sendMtopResponse;
        }
        MtopResponse mtopResponseSyncRequest = mtopBusinessBuildMtopBusiness.syncRequest();
        if (mtopResponseSyncRequest != null) {
            sendMtopResponse.errorCode = mtopResponseSyncRequest.getRetCode();
            sendMtopResponse.errorMsg = mtopResponseSyncRequest.getRetMsg();
            sendMtopResponse.data = mtopResponseSyncRequest.getBytedata();
            sendMtopResponse.success = mtopResponseSyncRequest.isApiSuccess();
            a(app, sendMtopResponse.errorCode, sendMtopResponse.data, sendMtopParams);
            if (mtopResponseSyncRequest.isApiSuccess()) {
                RVCountDispatcher.c cVar = new RVCountDispatcher.c();
                cVar.h = 1;
                ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                cVar.h = 3;
                cVar.i = System.currentTimeMillis() - jCurrentTimeMillis;
                ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQUEST_SUCCESS", "sync____" + sendMtopParams.api + "____" + sendMtopParams.v + "____TimeCost=" + cVar.i + "", "Api", "", null, null);
                a(mtopBusinessBuildMtopBusiness);
                a(app, sendMtopParams, (float) cVar.i);
            } else {
                a(app, sendMtopParams, mtopResponseSyncRequest);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MTOP_REQUEST_FAILED", "sync____" + sendMtopParams.api + "____" + sendMtopParams.v + "____" + sendMtopResponse.errorCode + sendMtopResponse.errorMsg, "Api", "", null, null);
                a(app, sendMtopParams, sendMtopResponse, (float) (System.currentTimeMillis() - jCurrentTimeMillis));
            }
        }
        if (app != null) {
            Page activePage = app.getActivePage();
            ((RVMonitor) RVProxy.get(RVMonitor.class)).performanceLog("end sendMtop, api = " + sendMtopParams.api, "sendMtop", app.getAppId(), activePage != null ? activePage.getPageURI() : "", new HashMap());
        }
        return sendMtopResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(App app, SendMtopParams sendMtopParams, SendMtopResponse sendMtopResponse, float f) {
        AppModel appModel;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeCost", (Object) Float.valueOf(f));
        String str = "";
        jSONObject.put("apiName", (Object) (sendMtopParams != null ? sendMtopParams.api : ""));
        jSONObject.put("miniAppId", (Object) ((sendMtopParams == null || sendMtopParams.getHeaders() == null) ? "" : sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.f)));
        if (sendMtopParams != null && sendMtopParams.getExtraDataMap() != null) {
            str = sendMtopParams.getExtraDataMap().get("pluginId");
        }
        jSONObject.put("pluginId", (Object) str);
        if (app != null && (appModel = (AppModel) app.getData(AppModel.class)) != null && appModel.getAppInfoModel() != null) {
            jSONObject.put("deployVersion", (Object) appModel.getAppInfoModel().getVersion());
            jSONObject.put("developerVersion", (Object) appModel.getAppInfoModel().getDeveloperVersion());
            if (appModel.getAppInfoModel().getTemplateConfig() != null) {
                jSONObject.put("templateId", (Object) appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
            }
            if (appModel.getExtendInfos() != null) {
                jSONObject.put("bizType", (Object) String.valueOf(appModel.getExtendInfos().getInteger("bizType")));
                jSONObject.put(TRiverConstants.KEY_SUB_BIZ_TYPE, (Object) String.valueOf(appModel.getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE)));
            }
        }
        ((TRVMonitor) RVProxy.get(TRVMonitor.class)).trackAlarm(false, TriverLogProxyImpl.TLOG_MODULE, "mtop", sendMtopResponse.errorCode, sendMtopResponse.errorMsg, jSONObject.toString());
        if (!a(sendMtopParams) || sendMtopParams.getHeaders() == null || sendMtopParams.getDataMap() == null) {
            return;
        }
        a(sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.f), sendMtopParams.getDataMap().get("fcName"), sendMtopParams.getDataMap().get("handler"), sendMtopResponse.errorCode, sendMtopResponse.errorMsg, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(App app, SendMtopParams sendMtopParams, MtopResponse mtopResponse) {
        if (mtopResponse == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("mtopApi", mtopResponse.getApi());
        map.put("mtopVersion", mtopResponse.getV());
        map.put("responseCode", Integer.valueOf(mtopResponse.getResponseCode()));
        HashMap map2 = new HashMap();
        map2.put("bizdata", sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.e));
        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(app != null ? app.getActivePage() : null, ErrId.RV_TYPE_MTOP_ERROR, mtopResponse.getRetCode(), mtopResponse.getRetMsg(), map2, map);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "[Mtop Error] " + mtopResponse.getRetCode() + ", " + mtopResponse.getRetMsg(), "Mtop", "", "", null);
        RVCountDispatcher.c cVar = new RVCountDispatcher.c();
        cVar.h = 2;
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(App app, String str, byte[] bArr, SendMtopParams sendMtopParams) {
        if (TextUtils.equals(str, "FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR")) {
            ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(app.getAppId(), b.a(app, sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.b) + "token"));
        }
        if (bArr != null) {
            try {
                JSONObject object = JSON.parseObject(new String(bArr));
                if (object == null || !TextUtils.equals("[\"FAIL_SYS_AUTH_CHECK_FAILED::TOPAUTH_ACCESSTOKEN_EXPIRED\"]", object.getString("ret"))) {
                    return;
                }
                ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).remove(app.getAppId(), b.a(app, sendMtopParams.getHeaders().get(com.alibaba.ariver.jsapi.mtop.a.b) + "token"));
            } catch (JSONException e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
        }
    }

    private boolean a(SendMtopParams sendMtopParams) {
        return sendMtopParams != null && TextUtils.equals(sendMtopParams.api, "mtop.miniapp.cloud.invoke.fc");
    }

    private void a(String str, String str2, String str3, double d2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) str);
        jSONObject.put("fcName", (Object) str2);
        jSONObject.put("handler", (Object) str3);
        jSONObject.put("errorCode", (Object) null);
        jSONObject.put("errorMsg", (Object) null);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("timeCost", (Object) Double.valueOf(d2));
        jSONObject2.put("status", (Object) Double.valueOf(1.0d));
        ((TRVMonitor) RVProxy.get(TRVMonitor.class)).trackStat(TriverLogProxyImpl.TLOG_MODULE, "CloudFunction", jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MtopBusiness mtopBusiness) {
        try {
            String str = ((MtopBuilder) mtopBusiness).mtopProp.userInfo;
            String multiAccountUserId = mtopBusiness.getMtopInstance().getMultiAccountUserId(str);
            if (!"DEFAULT".equals(str) && !TextUtils.equals(str, multiAccountUserId)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userInfo", (Object) str);
                jSONObject.put("userId", (Object) multiAccountUserId);
                ((TRVMonitor) RVProxy.get(TRVMonitor.class)).trackCounter(TriverLogProxyImpl.TLOG_MODULE, "MtopSession", 1, jSONObject.toJSONString());
            }
            RVLogger.d(f24345a, "mtop request userInfo:" + str + " userId:" + multiAccountUserId);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5, double d2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniAppId", (Object) str);
        jSONObject.put("fcName", (Object) str3);
        jSONObject.put("handler", (Object) str2);
        jSONObject.put("errorCode", (Object) str4);
        jSONObject.put("errorMsg", (Object) str5);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("timeCost", (Object) Double.valueOf(d2));
        jSONObject2.put("status", (Object) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        ((TRVMonitor) RVProxy.get(TRVMonitor.class)).trackStat(TriverLogProxyImpl.TLOG_MODULE, "CloudFunction", jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        RVCountDispatcher.c cVar = new RVCountDispatcher.c();
        cVar.h = 2;
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
    }
}
