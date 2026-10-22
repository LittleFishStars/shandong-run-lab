package com.alibaba.triver.triver_worker.v8worker;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.g;
import com.alibaba.ariver.legacy.v8worker.n;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25261a = "TRJsApiHandler";
    private JSONArray b;

    public a(App app, n nVar) {
        super(app, nVar);
        this.b = null;
    }

    private boolean b(String str) {
        Map<String, String> configsByGroup;
        if (this.b == null && (configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.ORANGE_GROUP_IMPORTANT_CONFIG)) != null) {
            String str2 = configsByGroup.get("monitorAPIList");
            if (TextUtils.isEmpty(str2)) {
                this.b = new JSONArray();
                a();
            } else {
                try {
                    this.b = JSON.parseArray(str2);
                } catch (Exception e) {
                    RVLogger.e(f25261a, "parse monitorAPIList error, use default white list", e);
                    a();
                }
            }
        }
        JSONArray jSONArray = this.b;
        if (jSONArray != null) {
            return jSONArray.contains(str);
        }
        return false;
    }

    @Override // com.alibaba.ariver.legacy.v8worker.g
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
            RVLogger.e(f25261a, th);
        }
        super.a(j, nativeCallContext);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0039  */
    @Override // com.alibaba.ariver.legacy.v8worker.g
    public void a(long j, NativeCallContext nativeCallContext, JSONObject jSONObject) {
        long j2;
        String str;
        CharSequence charSequence;
        try {
            Render render = nativeCallContext.getRender();
            String name = nativeCallContext.getName();
            JSONObject params = nativeCallContext.getParams();
            Page page = render.getPage() instanceof Page ? (Page) render.getPage() : null;
            boolean z = false;
            int i = JSONUtils.getInt(jSONObject, "error", 0);
            if (jSONObject.containsKey("error")) {
                try {
                    if (jSONObject.getInteger("error").intValue() == 0) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
            } else {
                z = true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            try {
                if (i == 0 && z) {
                    String strA = a(nativeCallContext.getName(), params);
                    a(page, strA, params);
                    if (!((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen() || page == null) {
                        str = strA;
                        charSequence = "internalAPI";
                    } else {
                        str = strA;
                        charSequence = "internalAPI";
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("WORKER_API_SUCCESS", nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + name + TRiverConstants.TOOL_SPLIT + params + TRiverConstants.TOOL_SPLIT + render.getCurrentUri() + TRiverConstants.TOOL_SPLIT + "TimeCost=" + jCurrentTimeMillis, "Api", render.getAppId() != null ? render.getAppId() : "", page.getPageURI(), jSONObject);
                    }
                    if (page != null) {
                        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(page.getApp()).setStartParams(page.getApp() != null ? page.getApp().getStartParams() : null).setStage("JSAPI").setStatus(Double.valueOf(1.0d)).create(), str, Double.valueOf(i), "");
                    }
                    if (TextUtils.equals(name, charSequence) && params != null && params.containsKey("method") && TextUtils.equals(params.getString("method"), "loadPlugin")) {
                        a(params, page, jCurrentTimeMillis, null, null, true);
                    }
                } else {
                    String strA2 = a(nativeCallContext.getName(), params);
                    try {
                        a(page, strA2, i + "", JSONUtils.getString(jSONObject, SendToNativeCallback.KEY_MESSAGE, "UNKNOWN"), params);
                        if (!((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen() || page == null) {
                            j2 = jCurrentTimeMillis;
                        } else {
                            j2 = jCurrentTimeMillis;
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("WORKER_API_FAILED", nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + name + TRiverConstants.TOOL_SPLIT + params + TRiverConstants.TOOL_SPLIT + page.getPageURI() + TRiverConstants.TOOL_SPLIT + "TimeCost=" + jCurrentTimeMillis, "Api", render.getAppId() != null ? render.getAppId() : "", page.getPageURI(), jSONObject);
                        }
                        if (page != null) {
                            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(page.getApp()).setStartParams(page.getApp() != null ? page.getApp().getStartParams() : null).setStage("JSAPI").setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).create(), strA2, Double.valueOf(i), jSONObject.toJSONString());
                        }
                        if (TextUtils.equals(name, "internalAPI") && params != null && params.containsKey("method") && TextUtils.equals(params.getString("method"), "loadPlugin")) {
                            a(params, page, j2, jSONObject.getString("error"), jSONObject.getString("message"), false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        RVLogger.e(f25261a, th);
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

    private String a(String str, JSONObject jSONObject) {
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
                RVLogger.e(f25261a, e);
            }
        }
        return str;
    }

    private void a(Page page, String str, JSONObject jSONObject) {
        try {
            if (b(str)) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitMajorAPIAlarm(true, page != null ? page.getApp() : null, str, null, null, jSONObject);
            }
        } catch (Exception e) {
            RVLogger.e(f25261a, e);
        }
    }

    private void a(Page page, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            if (b(str)) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitMajorAPIAlarm(false, page != null ? page.getApp() : null, str, str2, str3, jSONObject);
            }
        } catch (Exception e) {
            RVLogger.e(f25261a, e);
        }
    }

    private void a() {
        this.b.add("chooseAddress");
        this.b.add("addToCart");
        this.b.add("favorShop");
        this.b.add("checkShopFavoredStatus");
        this.b.add("checkGoodsCollectedStatus");
        this.b.add("unCollectGoods");
    }
}
