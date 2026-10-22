package com.alibaba.triver.inside.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.Triver;
import com.alibaba.triver.extension.TriverMonitorPub;
import com.alibaba.triver.extensions.AppLifecycleExtension;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.monitor.d;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.CommonUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.ut.mini.UTAnalytics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVMonitorProxyImpl implements RVMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24984a;
    private String b;
    private String c;

    private void a(Map<String, Long> map) {
        try {
            App currentApp = AppLifecycleExtension.getCurrentApp();
            if (map == null || currentApp == null || currentApp.getSceneParams() == null) {
                return;
            }
            String str = "";
            long jLongValue = 0;
            for (String str2 : map.keySet()) {
                if (map.get(str2).longValue() > jLongValue && !TextUtils.equals(str2, "appInfoStartStub")) {
                    jLongValue = map.get(str2).longValue();
                    str = str2;
                }
            }
            currentApp.getSceneParams().putString("currentStage", str);
        } catch (Exception e) {
            RVLogger.e("Triver:RVMonitor", "getLatestStage", e);
        }
    }

    private HashMap<String, String> b(Map<String, Object> map) {
        HashMap<String, String> map2 = new HashMap<>();
        if (map == null) {
            return map2;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            map2.put(str, obj != null ? obj.toString() : "");
        }
        return map2;
    }

    private void c(Map<String, Object> map) {
        if (map != null) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof String) {
                    map2.put(entry.getKey(), (String) entry.getValue());
                } else {
                    map2.put(entry.getKey(), entry.getValue().toString());
                }
            }
            UTAnalytics.getInstance().updateSessionProperties(map2);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void behavior(Page page, String str, Map<String, Object> map, Map<String, Object> map2, BridgeCallback bridgeCallback) {
        if (TRiverUrlUtils.isShop(page.getApp()) && map2 != null) {
            if (map2.containsKey("pageName") && map2.get("pageName").toString().contains("pages/index_v2")) {
                return;
            }
            if (map2.containsKey("spm-url") && map2.get("spm-url").toString().contains("MiniApp")) {
                return;
            }
            if (map2.containsKey("pageUrl") && map2.get("pageUrl").toString().contains("pages/index_v2")) {
                return;
            }
        }
        RVLogger.d(d.f25020a, "behavior: [type]" + str);
        if (TRiverUrlUtils.isShop(page.getApp())) {
            a(page, str, map, map2, bridgeCallback);
        } else {
            a(page, str, map, map2, bridgeCallback);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void error(Page page, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        AppModel appModel;
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map3 = map;
        if (page == null) {
            page = AppLifecycleExtension.getCurrentPage();
        }
        if (page != null) {
            if (!map3.containsKey("appId") && page.getApp() != null) {
                map3.put("appId", page.getApp().getAppId());
            }
            if (!map3.containsKey("url")) {
                map3.put("url", page.getPageURI());
            }
            if (Triver.currentAppxModel != null) {
                map3.put("appxVersion", Triver.currentAppxModel.getAppVersion());
            }
            try {
                if (page.getApp() != null && (appModel = (AppModel) page.getApp().getSceneParams().get("appInfo")) != null) {
                    if (!map3.containsKey("templateId")) {
                        map3.put("templateId", appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
                    }
                    if (!map3.containsKey("bizType") && appModel.getExtendInfos() != null) {
                        map3.put("bizType", appModel.getExtendInfos().getString("bizType"));
                    }
                    if (!map3.containsKey(TRiverConstants.KEY_SUB_BIZ_TYPE) && appModel.getExtendInfos() != null) {
                        map3.put(TRiverConstants.KEY_SUB_BIZ_TYPE, appModel.getExtendInfos().getString(TRiverConstants.KEY_SUB_BIZ_TYPE));
                    }
                }
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
            }
        }
        if (!map3.containsKey("version")) {
            map3.put("version", "");
        }
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).error(str, str2, str3, map3, map2);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void errorLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorCode", (Object) (TextUtils.isEmpty(str) ? "" : str));
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put("errorMsg", (Object) str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            jSONObject.put("subType", (Object) str3);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            jSONObject.put("appId", (Object) str4);
            if (TextUtils.isEmpty(str5)) {
                str5 = "";
            }
            jSONObject.put("pageName", (Object) str5);
            jSONObject.put("timeStamp", (Object) Long.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry != null) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception unused) {
            }
            if (c.K.equals(str)) {
                jSONObject2.put(AlibcCommonConstant.OPEN_ERROR_CODE, (Object) "TA1000");
                jSONObject2.put("技术支持", (Object) "请根据错误码到答疑群@答疑机器人");
            }
            jSONObject.put(LoginConstants.EXT, (Object) jSONObject2);
            jSONObject.put("processName", (Object) ProcessUtils.getProcessName());
            if (CommonUtils.isCatchToolsLogForRelease()) {
                RVLogger.e("Triver.errorLog", jSONObject.toJSONString());
            }
            RVLogger.e("errorLog", jSONObject.toJSONString());
        } catch (Throwable unused2) {
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void event(String str, String str2, int i, Map<String, String> map) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void flowLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        jSONObject.put(com.heytap.mcssdk.constant.b.k, (Object) str);
        jSONObject.put(AliyunLogCommon.LogLevel.INFO, TextUtils.isEmpty(str2) ? "" : str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        jSONObject.put("stage", (Object) str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        jSONObject.put("appId", (Object) str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        jSONObject.put("pageName", (Object) str5);
        jSONObject.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (CommonUtils.isApkDebug()) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        String strValueOf = String.valueOf(entry.getValue());
                        if (!TextUtils.isEmpty(str2) && (str2.contains("sendMtop") || str2.contains("getPrefetchData"))) {
                            if ("data".equals(key) && strValueOf.length() > 2000) {
                                strValueOf = "data字段返回数据过长不展示，端上过滤";
                            }
                            if ("result".equals(key) && strValueOf.length() > 2000) {
                                strValueOf = "result字段返回数据过长不展示，端上过滤";
                            }
                        }
                        jSONObject2.put(key, (Object) strValueOf);
                    }
                }
            }
        } catch (Exception unused) {
        }
        jSONObject.put(LoginConstants.EXT, (Object) jSONObject2);
        jSONObject.put("processName", ProcessUtils.getProcessName());
        if (CommonUtils.isCatchToolsLogForRelease()) {
            RVLogger.e("Triver.flowLog", jSONObject.toJSONString());
        }
        RVLogger.d("flowLog", jSONObject.toJSONString());
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void performance(String str, Map<String, Object> map, Map<String, Object> map2, Map<String, Long> map3, Map<String, Object> map4) {
        try {
            a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", (Object) "1.0");
            jSONObject.put("topic", (Object) str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("X-timestamp", (Object) Long.valueOf(System.currentTimeMillis()));
            jSONObject2.put("X-appKey", (Object) this.f24984a);
            jSONObject2.put("X-appVersion", (Object) this.b);
            jSONObject2.put("X-envIndex", (Object) this.c);
            jSONObject.put("headers", (Object) jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("commonDatas", JSON.toJSON(map));
            jSONObject3.put("extDatas", JSON.toJSON(map2));
            jSONObject3.put("stages", JSON.toJSON(map3));
            jSONObject3.put("events", JSON.toJSON(map4));
            jSONObject.put("value", (Object) jSONObject3);
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerf(a(str), jSONObject.toString());
            try {
                if (RVPerformanceTrackerImpl.RV_PERFORMANCE_APP_STARTUP_TYPE.equals(str)) {
                    if (new File("/data/local/tmp/.apm_online").exists()) {
                        JSONArray jSONArray = new JSONArray();
                        Long l = map3.get(PerfId.jumpAppStart);
                        Long l2 = map3.get(PerfId.firstScreen);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("stageName", (Object) PerfId.firstScreen);
                        jSONObject4.put("beginTime", (Object) l);
                        jSONObject4.put("endTime", (Object) l2);
                        jSONArray.add(jSONObject4);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.putAll(map);
                        jSONObject5.putAll(map2);
                        Bundle bundle = new Bundle();
                        bundle.putString("stage", jSONArray.toJSONString());
                        bundle.putString("extra", jSONObject5.toJSONString());
                        IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, 203, bundle);
                    }
                    a(map3);
                }
            } catch (Throwable th) {
                RVLogger.e("Triver:RVMonitor", "msg log for tmq error", th);
            }
        } catch (JSONException e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void performanceLog(String str, String str2, String str3, String str4, Map<String, Object> map) {
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(str2, str);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "default";
        }
        return "RV_APM/" + ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("utdId") + "/monitor/procedure/" + str;
    }

    private void b(Page page, BridgeCallback bridgeCallback) {
        if (page == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, "no page found"));
                return;
            }
            return;
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-2, "no pageContext found"));
                return;
            }
            return;
        }
        String pageSpmPre = UTAnalytics.getInstance().getDefaultTracker().getPageSpmPre(pageContext.getActivity());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("spmPre", (Object) pageSpmPre);
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f24984a)) {
            this.f24984a = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appKey");
        }
        if (TextUtils.isEmpty(this.b)) {
            this.b = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appVersion");
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_INDEX);
        }
    }

    private void a(Page page, BridgeCallback bridgeCallback) {
        if (page == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, "no page found"));
                return;
            }
            return;
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext == null) {
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-2, "no pageContext found"));
                return;
            }
            return;
        }
        String pageSpmUrl = UTAnalytics.getInstance().getDefaultTracker().getPageSpmUrl(pageContext.getActivity());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("spmUrl", (Object) pageSpmUrl);
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    private void a(Page page, String str, Map<String, Object> map, Map<String, Object> map2, BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null || page.getPageContext().getActivity() == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (d.k.equals(str)) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).pageAppear(page.getPageContext().getActivity());
            return;
        }
        if (d.l.equals(str)) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).pageDisappear(page.getPageContext().getActivity());
            return;
        }
        if (d.j.equals(str)) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).skipPage(page.getPageContext().getActivity());
            return;
        }
        if (d.i.equals(str)) {
            String str2 = (String) map2.get(com.heytap.mcssdk.constant.b.k);
            String str3 = (String) map2.get("pageName");
            String str4 = (String) map2.get("arg1");
            String str5 = (String) map2.get("arg2");
            String str6 = (String) map2.get("arg3");
            Map<String, String> mapJsonToMap = JSONUtils.jsonToMap((JSONObject) map2.get("args"), new HashMap());
            ((TriverMonitorPub) ExtensionPoint.as(TriverMonitorPub.class).create()).fillCustomBehaviorArgs(page, mapJsonToMap);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).customAdvance(str2, str3, str4, str5, str6, mapJsonToMap, map);
            return;
        }
        if (d.c.equals(str)) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageName(page.getPageContext().getActivity(), (String) map2.get("pageName"));
            return;
        }
        if (d.d.equals(str)) {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageUrl(page.getPageContext().getActivity(), (String) map2.get("pageUrl"));
            return;
        }
        if (d.e.equals(str)) {
            HashMap<String, String> mapB = b(map2);
            ((TriverMonitorPub) ExtensionPoint.as(TriverMonitorPub.class).create()).fillCustomBehaviorArgs(page, mapB);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageProperties(page.getPageContext().getActivity(), mapB);
            return;
        }
        if (d.f.equals(str)) {
            HashMap<String, String> mapB2 = b(map2);
            ((TriverMonitorPub) ExtensionPoint.as(TriverMonitorPub.class).create()).fillCustomBehaviorArgs(page, mapB2);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updateNextPageProperties(page.getPageContext().getActivity(), mapB2);
            return;
        }
        if (d.g.equals(str)) {
            HashMap<String, String> mapB3 = b(map2);
            ((TriverMonitorPub) ExtensionPoint.as(TriverMonitorPub.class).create()).fillCustomBehaviorArgs(page, mapB3);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageUtparam(page.getPageContext().getActivity(), JSON.toJSONString(mapB3));
        } else if (d.h.equals(str)) {
            HashMap<String, String> mapB4 = b(map2);
            ((TriverMonitorPub) ExtensionPoint.as(TriverMonitorPub.class).create()).fillCustomBehaviorArgs(page, mapB4);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updateNextPageUtparam(page.getPageContext().getActivity(), JSON.toJSONString(mapB4));
        } else if (d.m.equals(str)) {
            a(page, bridgeCallback);
        } else if (d.n.equals(str)) {
            b(page, bridgeCallback);
        } else if (d.o.equals(str)) {
            c(map2);
        }
    }
}
