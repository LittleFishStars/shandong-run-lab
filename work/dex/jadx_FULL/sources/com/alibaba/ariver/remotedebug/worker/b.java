package com.alibaba.ariver.remotedebug.worker;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.sdk.m.y.l;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends BaseWorkerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24414a;
    private final com.alibaba.ariver.remotedebug.core.b b;
    private final a c;

    public b(Context context, Node node, String str, String str2) {
        App app = (App) node.bubbleFindNode(App.class);
        app.getStartParams();
        this.b = new com.alibaba.ariver.remotedebug.core.b(context, this, app, str);
        this.mStartupParams = app.getStartParams();
        this.f24414a = "AriverRemoteDebug:RemoteDebugWorker:" + app.getAppId();
        this.c = new a(this, app.getEngineProxy().getEngineRouter());
        a(str2, this.mStartupParams);
    }

    private String d() {
        return "__appxStartupParams=" + BundleUtils.toJSONObject(this.mStartupParams).toJSONString() + l.b + "var __workerjs=\"self.__appxStartupParams=\" + JSON.stringify(__appxStartupParams) + \";importScripts('" + this.mWorkerId + "');\";worker.postMessage({action:'exec',data:__workerjs});";
    }

    public void a(String str, Bundle bundle) {
        this.b.a(str, bundle);
    }

    public void b() {
        RVLogger.d(this.f24414a, "exitRemoteDebug");
        this.b.a();
    }

    public a c() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return this.f24414a;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(null, null, str, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback) {
        this.b.b(com.alibaba.ariver.remotedebug.b.k + b(str3));
        sendPushCallBack(str, str2, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        RVLogger.e(this.f24414a, "tryToInjectStartupParamsAndPushWorker");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.b.a(com.alibaba.ariver.remotedebug.b.k + d());
        } catch (Throwable th) {
            RVLogger.e(this.f24414a, "tryToInjectStartupParamsAndPushWorker error: ", th);
        }
        RVLogger.e(this.f24414a, "tryToInjectStartupParamsAndPushWorker cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        setWorkerReady();
    }

    public void a(String str) {
        this.b.b(str);
    }

    private String b(String str) {
        return "window.worker.postMessage({\"action\":\"callBridge\",\"data\":" + str + "})";
    }

    public boolean a() {
        RVLogger.d(this.f24414a, "isRemoteDebugConnected.");
        return this.b.b();
    }
}
