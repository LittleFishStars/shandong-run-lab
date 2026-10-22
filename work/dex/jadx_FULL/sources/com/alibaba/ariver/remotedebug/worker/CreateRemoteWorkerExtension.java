package com.alibaba.ariver.remotedebug.worker;

import android.content.Context;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateRemoteWorkerExtension implements CreateWorkerPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24409a = "AriverRemoteDebug:CreateRemoteWorkerExtension";

    @Override // com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint
    @Nullable
    public Worker createWorker(Context context, Node node, String str, String str2) {
        App app = (App) node.bubbleFindNode(App.class);
        if (!com.alibaba.ariver.remotedebug.b.b.a(app.getStartParams()) || !com.alibaba.ariver.remotedebug.b.b.a(app.getAppId())) {
            return null;
        }
        RVLogger.d(f24409a, "CreateRemoteWorkerExtension create RemoteDebugWorker");
        return new b(context, node, str, str2);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
