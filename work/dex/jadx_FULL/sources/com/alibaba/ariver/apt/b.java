package com.alibaba.ariver.apt;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b {

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.b$2, reason: invalid class name */
    public static class AnonymousClass2 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23897a;
        final /* synthetic */ Method b;

        public AnonymousClass2(Method method, Method method2) {
            this.f23897a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new NativeCallTimeoutHandlerPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_ExtOpt$2$1
                @Override // com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint
                public void monitorTimeout(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23897a, new Object[]{nativeCallContext, bridgeResponseHelper});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint
                public void removeMonitor(NativeCallContext nativeCallContext) {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[]{nativeCallContext});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    public static void a() {
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallTimeoutHandlerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.b.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("monitorTimeout".equals(str) && objArr.length == 2) {
                    ((NativeCallTimeoutHandlerPoint) extension).monitorTimeout((NativeCallContext) objArr[0], (BridgeResponseHelper) objArr[1]);
                }
                if (!"removeMonitor".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((NativeCallTimeoutHandlerPoint) extension).removeMonitor((NativeCallContext) objArr[0]);
                return null;
            }
        });
    }

    public static void b() {
    }

    public static void c() {
        try {
            ExtensionPoint.registerProxyGenerator(NativeCallTimeoutHandlerPoint.class, new AnonymousClass2(NativeCallTimeoutHandlerPoint.class.getDeclaredMethod("monitorTimeout", NativeCallContext.class, BridgeResponseHelper.class), NativeCallTimeoutHandlerPoint.class.getDeclaredMethod("removeMonitor", NativeCallContext.class)));
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.common.bridge.NativeCallTimeoutHandlerPoint error, ignored", th);
        }
    }
}
