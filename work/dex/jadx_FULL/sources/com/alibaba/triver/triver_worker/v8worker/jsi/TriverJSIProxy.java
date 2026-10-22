package com.alibaba.triver.triver_worker.v8worker.jsi;

import android.os.Bundle;
import android.os.Handler;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.v8worker.V8Proxy;
import com.alipay.mobile.jsengine.Delegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverJSIProxy implements V8Proxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f25263a;
    Delegate mDelegate;

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public void addAssociatedThread(String str) {
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public Delegate generateDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new a();
        }
        this.f25263a = com.alibaba.ariver.a.a();
        return this.mDelegate;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public int getAllowCreatedWorkerMaxCount() {
        return 0;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public Handler getDispatchHandler(String str) {
        return this.f25263a;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String getPackageName() {
        return "Alibaba";
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String getSessionId(Render render) {
        return "";
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String[] getV8PluginNameList(String str, Bundle bundle) {
        return null;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String getWebViewCoreSoPath() {
        if (this.mDelegate == null) {
            generateDelegate();
        }
        return this.mDelegate.getWebViewCoreSoPath();
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public boolean hasSyncApiPermission(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public int quickVerifyWebViewCoreSo(String str) {
        return 1;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public boolean removeWebViewCore() {
        return true;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public boolean unzipWebViewCoreSo() {
        if (this.mDelegate == null) {
            generateDelegate();
        }
        this.mDelegate.unzipWebViewCoreSo();
        return true;
    }
}
