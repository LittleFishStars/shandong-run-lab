package com.alibaba.ariver.apt;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;
import com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class e {

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.e$3, reason: invalid class name */
    public static class AnonymousClass3 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23915a;

        public AnonymousClass3(Method method) {
            this.f23915a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new GetAuthCodeInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_ExtOpt$3$1
                @Override // com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint
                public boolean interceptGetAuthCode(Page page, ApiContext apiContext, JSONObject jSONObject, BridgeCallback bridgeCallback) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23915a, new Object[]{page, apiContext, jSONObject, bridgeCallback})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.e$4, reason: invalid class name */
    public static class AnonymousClass4 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23916a;

        public AnonymousClass4(Method method) {
            this.f23916a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new IgnorePermissionPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_permission_ExtOpt$4$1
                @Override // com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint
                public boolean ignoreAppPermission(String str) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23916a, new Object[]{str})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    public static void a() {
        ExtensionOpt.setupMethodInvokeOptimizer(GetAuthCodeInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.e.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("interceptGetAuthCode".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((GetAuthCodeInterceptPoint) extension).interceptGetAuthCode((Page) objArr[0], (ApiContext) objArr[1], (JSONObject) objArr[2], (BridgeCallback) objArr[3]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(IgnorePermissionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.e.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("ignoreAppPermission".equals(str) && objArr.length == 1) {
                    return Boolean.valueOf(((IgnorePermissionPoint) extension).ignoreAppPermission((String) objArr[0]));
                }
                return null;
            }
        });
    }

    public static void b() {
    }

    public static void c() {
        try {
            ExtensionPoint.registerProxyGenerator(GetAuthCodeInterceptPoint.class, new AnonymousClass3(GetAuthCodeInterceptPoint.class.getDeclaredMethod("interceptGetAuthCode", Page.class, ApiContext.class, JSONObject.class, BridgeCallback.class)));
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.permission.extension.auth.GetAuthCodeInterceptPoint error, ignored", th);
        }
        try {
            ExtensionPoint.registerProxyGenerator(IgnorePermissionPoint.class, new AnonymousClass4(IgnorePermissionPoint.class.getDeclaredMethod("ignoreAppPermission", String.class)));
        } catch (Throwable th2) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint error, ignored", th2);
        }
    }
}
