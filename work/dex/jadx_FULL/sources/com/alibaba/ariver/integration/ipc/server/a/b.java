package com.alibaba.ariver.integration.ipc.server.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.BaseEngineImpl;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback;
import com.alibaba.ariver.kernel.api.node.Node;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends BaseEngineImpl {
    public b(App app) {
        super(app.getAppId(), app);
    }

    @Override // com.alibaba.ariver.engine.BaseEngineImpl
    public NativeBridge createNativeBridge() {
        return new a((App) getNode());
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render createRender(Activity activity, Node node, CreateParams createParams) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Worker createWorker(Context context, Node node, String str, String str2) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.BaseEngineImpl, com.alibaba.ariver.engine.api.RVEngine
    public String getEngineType() {
        return "SERVER";
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getInstanceId() {
        return "0";
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isReady() {
        return true;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void setup(Bundle bundle, Bundle bundle2, EngineSetupCallback engineSetupCallback) {
    }
}
