package com.alibaba.triver.triver_worker.v8worker.jsi;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.ariver.v8worker.g;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.alibaba.triver.kit.api.systemInfo.SystemInfoUtil;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25265a = "TRJsApiHandler";
    private static Set<String> d;
    private App b;
    private Set<String> c;
    private JSONArray e;

    static {
        HashSet hashSet = new HashSet();
        d = hashSet;
        hashSet.add("getClientInfo");
        d.add(JSApiCachePoint.GET_LOCAL_STORAGE);
        d.add(JSApiCachePoint.GET_SYSTEM_INFO);
        d.add("getConfig4Appx");
        d.add("onAppPerfEvent");
        d.add("getNetworkType");
        d.add("originalRouteUrl");
        d.add("handleLoggingAction");
        d.add("remoteLog");
    }

    public c(App app, V8Worker v8Worker) {
        super(app, v8Worker);
        this.c = new HashSet();
        this.e = null;
        this.b = app;
    }

    private String b(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            try {
                if (TextUtils.equals(str, "pushWindow")) {
                    if (jSONObject.containsKey("param") && jSONObject.getJSONObject("param") != null) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("param");
                        if (jSONObject2.containsKey("closeAllWindow") && jSONObject2.getBoolean("closeAllWindow").booleanValue()) {
                            return "reLaunch";
                        }
                        if (jSONObject2.containsKey("closeCurrentWindow") && jSONObject2.getBoolean("closeCurrentWindow").booleanValue()) {
                            return "redirectTo";
                        }
                    }
                } else if (TextUtils.equals(str, "switchTab")) {
                    if (jSONObject.containsKey("recreate") && jSONObject.getBoolean("recreate").booleanValue()) {
                        return "reLaunch";
                    }
                } else if (TextUtils.equals(str, "internalAPI") && jSONObject.containsKey("method")) {
                    String string = jSONObject.getString("method");
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
            } catch (Exception e) {
                RVLogger.e(f25265a, e);
            }
        }
        return str;
    }

    @Override // com.alibaba.ariver.v8worker.g
    public void a(App app) {
        super.a(app);
        this.b = app;
    }

    public Set<String> a() {
        return this.c;
    }

    @Override // com.alibaba.ariver.v8worker.g
    public void a(String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        String string;
        if (this.b == null) {
            if ("internalAPI".equals(str)) {
                try {
                    string = jSONObject.getJSONObject("data").getString("method");
                } catch (Exception e) {
                    e.printStackTrace();
                    string = str;
                }
            } else {
                string = str;
            }
            if (!d.contains(string)) {
                this.c.add(string);
            }
            if (CommonUtils.isApkDebug()) {
                try {
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("JSApiHandler", "preload worker , get api call : " + str + " param : " + jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            JSONObject jSONObject2 = null;
            if (JSApiCachePoint.GET_SYSTEM_INFO.equals(str)) {
                try {
                    jSONObject2 = JSON.parseObject(SystemInfoUtil.getSystemInfoInner(null));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else if ("getClientInfo".equals(str)) {
                jSONObject2 = SystemInfoUtil.getClientInfo(null);
            } else if (JSApiCachePoint.GET_LOCAL_STORAGE.equals(str)) {
                jSONObject2 = new JSONObject();
                jSONObject2.put("data", "");
            }
            if (CommonUtils.isApkDebug()) {
                try {
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("JSApiHandler", "preload worker , get api call : " + str + " param : " + jSONObject + " result : " + jSONObject2);
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MessageChannel::w2r", jSONObject.toJSONString(), "Worker", "", "", null);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            sendToWorkerCallback.onCallBack(jSONObject2);
            return;
        }
        super.a(str, jSONObject, sendToWorkerCallback, str2, z);
    }

    private void b() {
        this.e.add("chooseAddress");
        this.e.add("addToCart");
        this.e.add("favorShop");
        this.e.add("checkShopFavoredStatus");
        this.e.add("checkGoodsCollectedStatus");
        this.e.add("unCollectGoods");
    }

    private boolean b(String str) {
        Map<String, String> configsByGroup;
        if (this.e == null && (configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_IMPORTANT_CONFIG)) != null) {
            String str2 = configsByGroup.get("monitorAPIList");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.e = JSON.parseArray(str2);
                } catch (Exception e) {
                    RVLogger.e(f25265a, "parse monitorAPIList error, use default white list", e);
                    b();
                }
            } else {
                this.e = new JSONArray();
                b();
            }
        }
        JSONArray jSONArray = this.e;
        if (jSONArray != null) {
            return jSONArray.contains(str);
        }
        return false;
    }

    @Override // com.alibaba.ariver.v8worker.g
    public void a(long j, NativeCallContext nativeCallContext) {
        String str;
        try {
            String name = nativeCallContext.getName();
            if (TextUtils.equals(name, "watchShake")) {
                Render render = nativeCallContext.getRender();
                JSONObject params = nativeCallContext.getParams();
                Page page = render.getPage() instanceof Page ? (Page) render.getPage() : null;
                if (params.containsKey("monitorGyroscope") && params.getBoolean("monitorGyroscope").booleanValue()) {
                    str = "onGyroscopeChange";
                } else if (params.containsKey("monitorGyroscope") && !params.getBoolean("monitorGyroscope").booleanValue()) {
                    str = "offGyroscopeChange";
                } else if (params.containsKey("monitorAccelerometer") && params.getBoolean("monitorAccelerometer").booleanValue()) {
                    str = "onAccelerometerChange";
                } else if (params.containsKey("monitorAccelerometer") && !params.getBoolean("monitorAccelerometer").booleanValue()) {
                    str = "offAccelerometerChange";
                } else if (params.containsKey("monitorCompass") && params.getBoolean("monitorCompass").booleanValue()) {
                    str = "onCompassChange";
                } else {
                    str = (!params.containsKey("monitorCompass") || params.getBoolean("monitorCompass").booleanValue()) ? null : "offCompassChange";
                }
                if (str != null && page != null) {
                    ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(page.getApp()).setStartParams(page.getApp() != null ? page.getApp().getStartParams() : null).setStage("JSAPI").setStatus(Double.valueOf(1.0d)).create(), str, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), "");
                    if (((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen()) {
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("WORKER_API_SUCCESS", nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + name + TRiverConstants.TOOL_SPLIT + params + TRiverConstants.TOOL_SPLIT + render.getCurrentUri() + TRiverConstants.TOOL_SPLIT + "TimeCost=" + (System.currentTimeMillis() - j), "Api", render.getAppId() != null ? render.getAppId() : "", page.getPageURI(), null);
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e(f25265a, th);
        }
        super.a(j, nativeCallContext);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0039  */
    @Override // com.alibaba.ariver.v8worker.g
    public void a(long j, NativeCallContext nativeCallContext, JSONObject jSONObject) {
        JSONObject jSONObject2;
        long j2;
        String str;
        String str2;
        JSONObject jSONObject3 = jSONObject;
        try {
            Render render = nativeCallContext.getRender();
            String name = nativeCallContext.getName();
            JSONObject params = nativeCallContext.getParams();
            Page page = render.getPage() instanceof Page ? (Page) render.getPage() : null;
            boolean z = false;
            int i = JSONUtils.getInt(jSONObject3, "error", 0);
            if (jSONObject3.containsKey("error")) {
                try {
                    if (jSONObject3.getInteger("error").intValue() == 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
            } else {
                z = true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            String pluginId = nativeCallContext.getPluginId();
            String pluginVersion = !TextUtils.isEmpty(pluginId) ? CommonUtils.getPluginVersion(pluginId, page) : null;
            try {
                if (i == 0 && z) {
                    String strB = b(nativeCallContext.getName(), params);
                    a(page, strB, params);
                    if (!((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen() || page == null) {
                        str = strB;
                        str2 = "pluginVersion";
                    } else {
                        str = strB;
                        str2 = "pluginVersion";
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("WORKER_API_SUCCESS", nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + name + TRiverConstants.TOOL_SPLIT + params + TRiverConstants.TOOL_SPLIT + render.getCurrentUri() + TRiverConstants.TOOL_SPLIT + "TimeCost=" + jCurrentTimeMillis, "Api", render.getAppId() != null ? render.getAppId() : "", page.getPageURI(), jSONObject);
                    }
                    if (page != null) {
                        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(page.getApp()).setStartParams(page.getApp() != null ? page.getApp().getStartParams() : null).setStage("JSAPI").setStatus(Double.valueOf(1.0d)).putExtra("pluginId", pluginId).putExtra(str2, pluginVersion).create(), str, Double.valueOf(i), "");
                    }
                    if (TextUtils.equals(name, "internalAPI") && params != 0 && params.containsKey("method") && TextUtils.equals(params.getString("method"), "loadPlugin")) {
                        a(params, page, jCurrentTimeMillis, (String) null, (String) null, true);
                    }
                } else {
                    String strB2 = b(nativeCallContext.getName(), params);
                    jSONObject3 = jSONObject;
                    a(page, strB2, i + "", JSONUtils.getString(jSONObject3, SendToNativeCallback.KEY_MESSAGE, "UNKNOWN"), params);
                    if (!((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen() || page == null) {
                        jSONObject2 = params;
                        j2 = jCurrentTimeMillis;
                    } else {
                        j2 = jCurrentTimeMillis;
                        jSONObject2 = params;
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("WORKER_API_FAILED", nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + name + TRiverConstants.TOOL_SPLIT + params + TRiverConstants.TOOL_SPLIT + page.getPageURI() + TRiverConstants.TOOL_SPLIT + "TimeCost=" + jCurrentTimeMillis, "Api", render.getAppId() != null ? render.getAppId() : "", page.getPageURI(), jSONObject);
                    }
                    if (page != null) {
                        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(page.getApp()).setStartParams(page.getApp() != null ? page.getApp().getStartParams() : null).setStage("JSAPI").setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).putExtra("pluginId", pluginId).putExtra("pluginVersion", pluginVersion).create(), strB2, Double.valueOf(i), jSONObject.toJSONString());
                    }
                    if (TextUtils.equals(name, "internalAPI") && jSONObject2 != null && jSONObject2.containsKey("method") && TextUtils.equals(jSONObject2.getString("method"), "loadPlugin")) {
                        try {
                            a(jSONObject2, page, j2, jSONObject.getString("error"), jSONObject.getString("message"), false);
                        } catch (Throwable th) {
                            th = th;
                            RVLogger.e(f25265a, th);
                        }
                    }
                    super.a(j, nativeCallContext, jSONObject);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        super.a(j, nativeCallContext, jSONObject);
    }

    private void a(JSONObject jSONObject, Page page, long j, String str, String str2, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        String[] strArrSplit = jSONObject.getJSONObject("param").getString("plugin").split("@");
        String str3 = strArrSplit[0];
        String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "*";
        jSONObject2.put("pluginId", (Object) str3);
        jSONObject2.put("pluginVersion", (Object) str4);
        jSONObject2.put("timeCost", (Object) Long.valueOf(j));
        if (page != null && page.getApp() != null) {
            jSONObject2.putAll(CommonUtils.getBasicAppMonitorData(page.getApp()));
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).trackAlarm(z, TriverLogProxyImpl.TLOG_MODULE, "DynamicPluginTotal", str, str2, jSONObject2.toString());
    }

    private void a(Page page, String str, JSONObject jSONObject) {
        try {
            if (b(str)) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitMajorAPIAlarm(true, page != null ? page.getApp() : null, str, null, null, jSONObject);
            }
        } catch (Exception e) {
            RVLogger.e(f25265a, e);
        }
    }

    private void a(Page page, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            if (b(str)) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitMajorAPIAlarm(false, page != null ? page.getApp() : null, str, str2, str3, jSONObject);
            }
        } catch (Exception e) {
            RVLogger.e(f25265a, e);
        }
    }
}
