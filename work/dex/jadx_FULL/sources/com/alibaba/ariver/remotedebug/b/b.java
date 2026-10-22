package com.alibaba.ariver.remotedebug.b;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.console.DebugConsolePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.core.DebugMessageType;
import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;
import com.alibaba.fastjson.JSONObject;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24380a = "AriverRemoteDebug:RemoteDebugUtils";

    public static boolean a(Bundle bundle) {
        return "true".equalsIgnoreCase(BundleUtils.getString(bundle, RVStartParams.KEY_IS_REMOTE_DEBUG_MODE));
    }

    public static boolean b(Page page) {
        App app = (App) page.bubbleFindNode(App.class);
        if (app != null) {
            return ((DebugConsolePoint) ExtensionPoint.as(DebugConsolePoint.class).node(app).create()).isDebugPanelExists();
        }
        return false;
    }

    public static boolean c(Page page) {
        try {
            com.alibaba.ariver.remotedebug.worker.b bVarD = d(page);
            if (bVarD != null) {
                return bVarD.a();
            }
            return false;
        } catch (Exception e) {
            RVLogger.e(f24380a, "isRemoteDebugConnected error.", e);
            return false;
        }
    }

    @Nullable
    private static com.alibaba.ariver.remotedebug.worker.b d(Page page) {
        WorkerStore workerStore = (WorkerStore) page.getData(WorkerStore.class);
        if (workerStore == null) {
            RVLogger.e(f24380a, "getRemoteDebugWorker workerStore is null.");
            return null;
        }
        RVLogger.d(f24380a, "getRemoteDebugWorker.....");
        try {
            Worker workerById = page.getRender().getEngine().getEngineRouter().getWorkerById(workerStore.workerId);
            if (workerById instanceof com.alibaba.ariver.remotedebug.worker.b) {
                return (com.alibaba.ariver.remotedebug.worker.b) workerById;
            }
        } catch (Exception e) {
            RVLogger.e(f24380a, "getRemoteDebugWorker error.", e);
        }
        return null;
    }

    public static boolean a(String str) {
        return ((RVRemoteDebugProxy) RVProxy.get(RVRemoteDebugProxy.class)).supportRemoteDebug(str);
    }

    public static String a(String str, String str2) {
        String remoteDebugWebSocketUrlForDebug = ((RVRemoteDebugProxy) RVProxy.get(RVRemoteDebugProxy.class)).getRemoteDebugWebSocketUrlForDebug(str, str2);
        if (TextUtils.isEmpty(remoteDebugWebSocketUrlForDebug)) {
            return null;
        }
        RVLogger.d(f24380a, "Debug WebSocket url: " + remoteDebugWebSocketUrlForDebug);
        return remoteDebugWebSocketUrlForDebug + str2;
    }

    private static void b(Page page, String str, String str2) {
        try {
            com.alibaba.ariver.remotedebug.worker.b bVarD = d(page);
            if (bVarD != null) {
                bVarD.a(str + u15.f19942b + str2);
            }
        } catch (Exception e) {
            RVLogger.e(f24380a, "sendMessageToRemoteDebugOrVConsole error.", e);
        }
    }

    private static JSONObject b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) str);
        jSONObject.put("content", (Object) str2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        return jSONObject2;
    }

    public static boolean a() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(com.alibaba.ariver.remotedebug.b.o, null));
    }

    public static void a(Page page) {
        com.alibaba.ariver.remotedebug.worker.b bVarD = d(page);
        if (bVarD == null) {
            return;
        }
        bVarD.b();
    }

    public static void a(Page page, DebugMessageType debugMessageType, String str) {
        a(page, debugMessageType.getType(), str);
    }

    public static void a(Page page, String str, String str2) {
        if (page == null) {
            RVLogger.e(f24380a, String.format("sendMessageToRemoteDebugOrVConsole [%s] [%s] page is null!", str, str2));
            return;
        }
        RVLogger.d(f24380a, String.format("sendMessageToRemoteDebugOrVConsole [%s] [%s]", str, str2));
        if (BundleUtils.getBoolean(page.getStartParams(), com.alibaba.ariver.remotedebug.b.d, false)) {
            JSONObject jSONObjectB = b(str, str2);
            if (page.getRender() != null) {
                RVLogger.d(f24380a, "remoteX direct send msg to worker.");
                EngineUtils.sendToRender(page.getRender(), com.alibaba.ariver.remotedebug.b.e, jSONObjectB, null);
                return;
            } else {
                RVLogger.e(f24380a, "remoteX direct send msg to worker fail. render is null.");
                return;
            }
        }
        if (c(page)) {
            b(page, str, str2);
            return;
        }
        App app = (App) page.bubbleFindNode(App.class);
        if (app != null) {
            ((DebugConsolePoint) ExtensionPoint.as(DebugConsolePoint.class).node(app).create()).sendMsgToConsoleView(b(str, str2));
        }
    }
}
