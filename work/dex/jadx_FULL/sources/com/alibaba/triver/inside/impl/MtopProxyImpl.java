package com.alibaba.triver.inside.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.SendMtopProxyImpl;
import com.alibaba.ariver.mtop.monitor.RVCountDispatcher;
import com.alibaba.ariver.mtop.monitor.TRVMonitor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.extensions.AppLifecycleExtension;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.model.ResponseDO;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MtopProxyImpl implements INetworkProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24982a = "TriverMtop";

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        RVCountDispatcher.c cVar = new RVCountDispatcher.c();
        cVar.h = 2;
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
    }

    public MtopBusiness buildMtopBusiness(RequestParams requestParams) {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setData(JSON.toJSONString(requestParams.toMap()));
        mtopRequest.setApiName(requestParams.api);
        mtopRequest.setVersion(requestParams.version);
        mtopRequest.setNeedEcode(requestParams.needLogin);
        mtopRequest.setNeedSession(requestParams.needLogin);
        Mtop mtopInstance = getMtopInstance("INNER", requestParams);
        MtopBusiness mtopBusinessBuild = MtopBusiness.build(mtopInstance, mtopRequest, mtopInstance.getMtopConfig().ttid);
        configMtopBusiness(mtopBusinessBuild, requestParams);
        return mtopBusinessBuild;
    }

    public ResponseDO buildResponse(MtopResponse mtopResponse) {
        ResponseDO responseDO = new ResponseDO();
        if (mtopResponse == null) {
            responseDO.success = false;
            responseDO.errorCode = "MTOP_RESPONSE_NULL";
            responseDO.errorMsg = "网络请求异常";
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "MTOP_RESPONSE_NULL", "Mtop", "", "", null);
            return responseDO;
        }
        if (mtopResponse.getBytedata() == null) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "mtop response data is null", "Mtop", "", "", null);
            RVLogger.d("[mtop]", "response data is null");
            responseDO.success = false;
            responseDO.errorCode = mtopResponse.getRetCode();
            responseDO.errorMsg = mtopResponse.getRetMsg();
            return responseDO;
        }
        if (mtopResponse.isApiSuccess()) {
            responseDO.success = true;
            responseDO.data = mtopResponse.getBytedata();
        } else {
            responseDO.success = false;
            responseDO.errorCode = mtopResponse.getRetCode();
            responseDO.errorMsg = mtopResponse.getRetMsg();
            responseDO.data = mtopResponse.getBytedata();
        }
        return responseDO;
    }

    public void configMtopBusiness(MtopBusiness mtopBusiness, RequestParams requestParams) {
        Map<String, String> map = requestParams.headers;
        if (map != null && map.size() > 0) {
            mtopBusiness.headers(requestParams.headers);
        }
        try {
            if (TROrangeController.enableTraceLog()) {
                mtopBusiness.setPTraceId(TRiverUtils.getSessionId(getStartParams(requestParams)));
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        mtopBusiness.setJsonType(JsonTypeEnum.valueOf(JsonTypeEnum.ORIGINALJSON.name().toUpperCase()));
        mtopBusiness.setBizId(60);
        mtopBusiness.setCustomDomain("guide-acs.m.taobao.com", "guide-acs.wapa.taobao.com", "");
        if (TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(SendMtopProxyImpl.MTOP_SET_INNER_PAGE_INFO_KEY, null), "yes")) {
            mtopBusiness.setPageUrl("");
            try {
                mtopBusiness.setPageName("");
            } catch (Throwable th2) {
                RVLogger.w(Log.getStackTraceString(th2));
            }
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy
    public ResponseDO execute(RequestParams requestParams) {
        MtopBusiness mtopBusinessBuildMtopBusiness = buildMtopBusiness(requestParams);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            RVLogger.d(RVLogger.makeLogTag(f24982a), "mtop sync request , api: " + requestParams.api);
            MtopResponse mtopResponseSyncRequest = mtopBusinessBuildMtopBusiness.syncRequest();
            RVLogger.d(RVLogger.makeLogTag(f24982a), "mtop sync success , api: " + requestParams.api + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            ResponseDO responseDOBuildResponse = buildResponse(mtopResponseSyncRequest);
            if (responseDOBuildResponse.success) {
                RVCountDispatcher.c cVar = new RVCountDispatcher.c();
                cVar.h = 1;
                ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                cVar.h = 3;
                cVar.i = System.currentTimeMillis() - jCurrentTimeMillis;
                ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                a(mtopBusinessBuildMtopBusiness);
            } else {
                a();
            }
            return responseDOBuildResponse;
        } catch (Exception e) {
            RVLogger.e(RVLogger.makeLogTag(f24982a), "mtop sync failed , api: " + requestParams.api + ", message: " + e.getMessage() + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            ResponseDO responseDO = new ResponseDO();
            responseDO.success = false;
            responseDO.errorCode = e.getMessage();
            responseDO.errorMsg = e.getMessage();
            a();
            return responseDO;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy
    public void executeAsync(RequestParams requestParams, final INetworkProxy.RequestListener requestListener) {
        final MtopBusiness mtopBusinessBuildMtopBusiness = buildMtopBusiness(requestParams);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        RVLogger.d(RVLogger.makeLogTag(f24982a), "mtop async request , api:" + requestParams.api);
        mtopBusinessBuildMtopBusiness.registerListener(new IRemoteBaseListener() { // from class: com.alibaba.triver.inside.impl.MtopProxyImpl.1
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                RVLogger.e(RVLogger.makeLogTag(MtopProxyImpl.f24982a), "mtop async failed , api: " + mtopResponse.getApi() + ", code: " + mtopResponse.getRetCode() + ", msg: " + mtopResponse.getRetMsg() + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                try {
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("Mtop", "[Mtop Error] " + mtopResponse.getRetCode() + ", " + mtopResponse.getRetMsg(), "Mtop", "", "", null);
                    requestListener.onFailure(MtopProxyImpl.this.buildResponse(mtopResponse));
                    MtopProxyImpl.this.a();
                } catch (Exception e) {
                    ResponseDO responseDO = new ResponseDO();
                    responseDO.success = false;
                    responseDO.errorCode = e.getMessage();
                    responseDO.errorMsg = e.getMessage();
                    requestListener.onFailure(responseDO);
                    MtopProxyImpl.this.a();
                }
            }

            public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                RVLogger.d(RVLogger.makeLogTag(MtopProxyImpl.f24982a), "mtop async success , api: " + mtopResponse.getApi() + ", duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                try {
                    ResponseDO responseDOBuildResponse = MtopProxyImpl.this.buildResponse(mtopResponse);
                    if (responseDOBuildResponse.success) {
                        requestListener.onSuccess(responseDOBuildResponse);
                        RVCountDispatcher.c cVar = new RVCountDispatcher.c();
                        cVar.h = 1;
                        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                        cVar.h = 3;
                        cVar.i = System.currentTimeMillis() - jCurrentTimeMillis;
                        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(cVar);
                        MtopProxyImpl.this.a(mtopBusinessBuildMtopBusiness);
                    } else {
                        requestListener.onFailure(responseDOBuildResponse);
                        MtopProxyImpl.this.a();
                    }
                } catch (Exception e) {
                    ResponseDO responseDO = new ResponseDO();
                    responseDO.success = false;
                    responseDO.errorCode = e.getMessage();
                    responseDO.errorMsg = e.getMessage();
                    requestListener.onFailure(responseDO);
                    MtopProxyImpl.this.a();
                }
            }

            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                onError(i, mtopResponse, obj);
            }
        });
        mtopBusinessBuildMtopBusiness.startRequest();
    }

    public Mtop getMtopInstance(String str, RequestParams requestParams) {
        return Mtop.instance(str, ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    public Bundle getStartParams(RequestParams requestParams) {
        if (requestParams.getStartParams() != null) {
            return requestParams.getStartParams();
        }
        App currentApp = AppLifecycleExtension.getCurrentApp();
        if (currentApp != null) {
            return currentApp.getStartParams();
        }
        RVAppRecord appRecord = RVMain.getAppRecord(com.alibaba.triver.container.a.a().c(requestParams.getAppId()));
        if (appRecord != null) {
            return appRecord.getStartParams();
        }
        return null;
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
            RVLogger.d(f24982a, "mtop request userInfo:" + str + " userId:" + multiAccountUserId);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }
}
