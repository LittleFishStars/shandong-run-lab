package com.alibaba.ariver.engine;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.EngineStack;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.engine.common.bridge.DefaultNativeBridge;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseEngineImpl implements RVEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Node f24043a;
    private String b;
    private EngineRouter d;
    protected InitParams initParams;
    private boolean f = false;
    private Context e = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    private NativeBridge c = createNativeBridge();

    public BaseEngineImpl(String str, Node node) {
        this.f24043a = node;
        this.b = str;
        EngineRouter engineRouterCreateEngineRouter = createEngineRouter();
        this.d = engineRouterCreateEngineRouter;
        this.c.bindEngineRouter(engineRouterCreateEngineRouter);
    }

    public EngineRouter createEngineRouter() {
        return new DefaultEngineRouter();
    }

    public NativeBridge createNativeBridge() {
        return new DefaultNativeBridge();
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public final synchronized void destroy() {
        if (this.f) {
            return;
        }
        this.f = true;
        onDestroy();
        this.c.release();
        EngineStack.getInstance().removeProxy(this);
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getAppId() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Context getApplication() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public NativeBridge getBridge() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public EngineRouter getEngineRouter() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getEngineType() {
        return "WEB";
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Node getNode() {
        return this.f24043a;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Bundle getStartParams() {
        InitParams initParams = this.initParams;
        if (initParams == null) {
            return null;
        }
        return initParams.startParams;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render getTopRender() {
        return this.d.getRenderById(null);
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    @CallSuper
    public void init(InitParams initParams, EngineInitCallback engineInitCallback) {
        this.initParams = initParams;
        EngineStack.getInstance().pushEnginePorxy(this);
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isDestroyed() {
        return this.f;
    }

    public void onDestroy() {
        EngineRouter engineRouter = this.d;
        if (engineRouter != null) {
            engineRouter.destroy();
        }
    }

    public void setNativeBridge(@NonNull NativeBridge nativeBridge) {
        this.c = nativeBridge;
    }
}
