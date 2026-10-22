package com.alibaba.ariver.engine.api;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLogConfigProxy;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.EventLog;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.webview.b;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.igexin.push.config.c;
import com.zj.adlib.c49;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EngineUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24047a = "AriverEngine:EngineUtils";
    private static final Set<String> b;
    private static final Set<String> c;

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        HashSet hashSet2 = new HashSet();
        c = hashSet2;
        hashSet.add(b.f24908a);
        hashSet.add("message");
        hashSet2.add(RVEvents.FIRE_PULL_TO_REFRESH);
        hashSet2.add(RVEvents.PULL_INTERCEPT);
        hashSet2.add("onShare");
        hashSet2.add("promotionClose");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        if (sendToWorkerCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", (Object) str);
            jSONObject.put("result", "2");
            jSONObject.put("messageId", (Object) str2);
            sendToWorkerCallback.onCallBack(jSONObject);
        }
    }

    public static String getUserAgentSuffix() {
        return "Ariver/1.0.12.50-bc";
    }

    @Nullable
    public static Worker getWorker(RVEngine rVEngine) {
        if (rVEngine.isDestroyed() || rVEngine.getEngineRouter() == null) {
            return null;
        }
        return rVEngine.getEngineRouter().getWorkerById(null);
    }

    public static String getWorkerId(Render render) {
        WorkerStore workerStore = (WorkerStore) render.getPage().getData(WorkerStore.class);
        return workerStore != null ? workerStore.workerId : "";
    }

    public static void postOnWorker(Worker worker, Runnable runnable) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if ((rVConfigService != null ? "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("ariver_disable_postOnWorker", "yes")) : true) || Looper.myLooper() == worker.getWorkerHandler().getLooper()) {
            runnable.run();
        } else {
            worker.getWorkerHandler().post(runnable);
        }
    }

    public static void sendPushWorkMessage(Render render, String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        sendPushWorkMessage(render, null, str, jSONObject, sendToWorkerCallback);
    }

    public static void sendToRender(Render render, String str, @Nullable JSONObject jSONObject, @Nullable SendToRenderCallback sendToRenderCallback) {
        sendToRender(render, null, str, jSONObject, sendToRenderCallback);
    }

    public static void sendPushWorkMessage(final Render render, Worker worker, final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        Worker workerById;
        if (render == null || render.getPage() == null) {
            RVLogger.e(f24047a, "sendPushWorkMessage but render or render.getPage() == null");
            return;
        }
        final String str2 = System.currentTimeMillis() + "";
        if (worker == null) {
            workerById = render.getEngine().getEngineRouter().getWorkerById(getWorkerId(render));
        } else {
            workerById = worker;
        }
        if (workerById != null) {
            final String currentUri = render.getCurrentUri();
            final String renderId = render.getRenderId();
            final Worker worker2 = workerById;
            postOnWorker(workerById, new Runnable() { // from class: com.alibaba.ariver.engine.api.EngineUtils.2
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = null;
                    if (worker2.isDestroyed()) {
                        RVLogger.w(EngineUtils.f24047a, "sendPushWorkerMessage but worker destroyed!");
                        EngineUtils.a((String) null, str2, sendToWorkerCallback);
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("func", str);
                    JSONObject jSONObject4 = jSONObject;
                    if (jSONObject4 != null) {
                        try {
                            jSONObject2 = jSONObject4.getJSONObject("data");
                        } catch (Throwable th) {
                            RVLogger.e(EngineUtils.f24047a, "data is not a jsonobj ", th);
                        }
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                            if (str.startsWith("syncMessage")) {
                                jSONObject2.put("syncMessage", (Object) jSONObject.getString("data"));
                            }
                            jSONObject.put("data", (Object) jSONObject2);
                        }
                        jSONObject2.put("NBPageUrl", (Object) currentUri);
                        jSONObject3.put("param", jSONObject);
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("NBPageUrl", (Object) currentUri);
                        jSONObject5.put("data", (Object) jSONObject6);
                        jSONObject3.put("param", (Object) jSONObject5);
                    }
                    jSONObject3.put("viewId", renderId);
                    jSONObject3.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, Integer.valueOf(render.getPageId()));
                    final JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("handlerName", c.x);
                    jSONObject7.put("data", (Object) jSONObject3);
                    RVLogger.d(EngineUtils.f24047a, " workerReady: " + worker2.isWorkerReady());
                    if (worker2.isWorkerReady()) {
                        worker2.sendJsonToWorker(jSONObject7, sendToWorkerCallback);
                    } else {
                        worker2.registerWorkerReadyListener(new Worker.WorkerReadyListener() { // from class: com.alibaba.ariver.engine.api.EngineUtils.2.1
                            @Override // com.alibaba.ariver.engine.api.Worker.WorkerReadyListener
                            public void onWorkerReady() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                worker2.sendJsonToWorker(jSONObject7, sendToWorkerCallback);
                            }
                        });
                    }
                }
            });
            return;
        }
        RVLogger.w(f24047a, "sendPushWorkerMessage action: " + str + ", param: " + jSONObject + ", but worker == null!");
        a((String) null, str2, sendToWorkerCallback);
    }

    public static void sendToRender(Render render, Worker worker, String str, @Nullable JSONObject jSONObject, @Nullable SendToRenderCallback sendToRenderCallback) {
        sendToRender(render, worker, str, jSONObject, sendToRenderCallback, true);
    }

    public static void sendToRender(Render render, Worker worker, String str, @Nullable JSONObject jSONObject, @Nullable final SendToRenderCallback sendToRenderCallback, boolean z) {
        final boolean z2;
        if (render == null) {
            RVLogger.w(f24047a, "sendToRender but render == null!!");
            return;
        }
        if (worker == null) {
            worker = render.getEngine().getEngineRouter().getWorkerById(getWorkerId(render));
        }
        if (worker == null || b.contains(str)) {
            z2 = false;
        } else {
            z2 = !c.contains(str);
            sendPushWorkMessage(render, worker, str, jSONObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.engine.api.EngineUtils.1
                @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                public void onCallBack(JSONObject jSONObject2) {
                    SendToRenderCallback sendToRenderCallback2 = sendToRenderCallback;
                    if (sendToRenderCallback2 == null || !z2) {
                        return;
                    }
                    sendToRenderCallback2.onCallBack(jSONObject2);
                }
            });
        }
        if (render.getRenderBridge() == null) {
            RVLogger.w(f24047a, "sendToRender but render.getRenderBridge == null!!");
            return;
        }
        RenderCallContext.Builder builderParam = RenderCallContext.newBuilder(render).type("call").action(str).param(jSONObject);
        RenderBridge renderBridge = render.getRenderBridge();
        RenderCallContext renderCallContextBuild = builderParam.build();
        if (z2) {
            sendToRenderCallback = null;
        }
        renderBridge.sendToRender(renderCallContextBuild, sendToRenderCallback, z);
        try {
            a(render, str, jSONObject);
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    private static void a(Render render, String str, JSONObject jSONObject) {
        RVLogger.d(f24047a, "logEvent");
        try {
            String string = JSONUtils.toString(jSONObject);
            DataNode page = render.getPage();
            if (page == null) {
                return;
            }
            Set<String> ignoreEventList = ((AppLogConfigProxy) RVProxy.get(AppLogConfigProxy.class)).getIgnoreEventList();
            if (ignoreEventList != null && ignoreEventList.contains(str)) {
                RVLogger.d(f24047a, String.format("logEvent Event[%s] ignore.", str));
            } else {
                AppLogger.log(new EventLog.Builder().setParentId(AppLogUtils.getParentId(page)).setGroupId(c49.f40900a).setData(string).setEventName(str).build());
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }
}
