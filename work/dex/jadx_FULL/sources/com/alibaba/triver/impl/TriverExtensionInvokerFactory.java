package com.alibaba.triver.impl;

import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.invoke.DefaultExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionCallback;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.extensions.AppLifecycleExtension;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverExtensionInvokerFactory extends DefaultExtensionInvokerFactory {

    public class a implements ExtensionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExtensionCallback f24976a;

        public a() {
        }

        @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeCallback
        public void onComplete(Object obj) {
            ExtensionCallback extensionCallback = this.f24976a;
            if (extensionCallback != null) {
                extensionCallback.onComplete(obj);
            }
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
        public void onException(Extension extension, Throwable th) {
            ExtensionCallback extensionCallback = this.f24976a;
            if (extensionCallback != null) {
                extensionCallback.onException(extension, th);
            }
            App currentApp = AppLifecycleExtension.getCurrentApp();
            if (currentApp != null) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setApp(currentApp).setStage(TriverAppMonitorConstants.KEY_STAGE_ERROR_PAGE).setStartParams(currentApp.getStartParams()).setErrorCode("999888").setErrorMsg(th.toString()).setStatus(Double.valueOf(1.0d)).create());
            }
        }

        @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker.InvokeCallback
        public void onFail(Throwable th) {
            ExtensionCallback extensionCallback = this.f24976a;
            if (extensionCallback != null) {
                extensionCallback.onFail(th);
            }
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
        public void onInterrupt(Extension extension) {
            ExtensionCallback extensionCallback = this.f24976a;
            if (extensionCallback != null) {
                extensionCallback.onInterrupt(extension);
            }
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
        public void onProgress(Extension extension, Object obj) {
            ExtensionCallback extensionCallback = this.f24976a;
            if (extensionCallback != null) {
                extensionCallback.onProgress(extension, obj);
            }
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionCallback
        public void onStart(List list) {
            ExtensionCallback extensionCallback = this.f24976a;
            if (extensionCallback != null) {
                extensionCallback.onStart(list);
            }
        }
    }

    @Override // com.alibaba.ariver.invoke.DefaultExtensionInvokerFactory, com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory
    public ExtensionInvoker createAwareExtensionInvoker(Node node, @Nullable ExtensionInvoker.InvokeCallback invokeCallback, Class<? extends Extension> cls) {
        if (!(invokeCallback instanceof ExtensionCallback)) {
            return super.createAwareExtensionInvoker(node, invokeCallback, cls);
        }
        a aVar = new a();
        aVar.f24976a = (ExtensionCallback) invokeCallback;
        return super.createAwareExtensionInvoker(node, aVar, cls);
    }
}
