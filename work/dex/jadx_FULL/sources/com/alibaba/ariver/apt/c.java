package com.alibaba.ariver.apt;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.engine.api.extensions.ReceivedHeaderPoint;
import com.alibaba.ariver.engine.api.extensions.ResourceResponseInfo;
import com.alibaba.ariver.engine.api.extensions.ResourceResponsePoint;
import com.alibaba.ariver.engine.api.extensions.WorkerCreateConfigPoint;
import com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.point.JsErrorInterceptPoint;
import com.alibaba.ariver.engine.api.point.NativeCallDispatchPoint;
import com.alibaba.ariver.engine.api.point.NativeCallOnInvokePoint;
import com.alibaba.ariver.engine.api.point.NativeCallResultPoint;
import com.alibaba.ariver.engine.api.point.PageBackInterceptPoint;
import com.alibaba.ariver.engine.api.point.WorkerExceptionPoint;
import com.alibaba.ariver.engine.api.point.network.HttpRequestResponseHandlePoint;
import com.alibaba.ariver.engine.api.point.network.WebResourceResponseHandlePoint;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c {

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$10, reason: invalid class name */
    public static class AnonymousClass10 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23898a;

        public AnonymousClass10(Method method) {
            this.f23898a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ReceivedHeaderPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$18$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.engine.api.extensions.ReceivedHeaderPoint
                public void onReceivedResponseHeader(Map<String, List<String>> map) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23898a, new Object[]{map});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$11, reason: invalid class name */
    public static class AnonymousClass11 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23899a;

        public AnonymousClass11(Method method) {
            this.f23899a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new WorkerCreateConfigPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$19$1
                @Override // com.alibaba.ariver.engine.api.extensions.WorkerCreateConfigPoint
                public boolean isAsyncCreateWorker(Node node, String str, String str2) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23899a, new Object[]{node, str, str2})).booleanValue();
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$13, reason: invalid class name */
    public static class AnonymousClass13 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23900a;

        public AnonymousClass13(Method method) {
            this.f23900a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new WorkerStartParamInjectPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$20$1
                @Override // com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint
                public void injectStartParam(Bundle bundle) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23900a, new Object[]{bundle});
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
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$14, reason: invalid class name */
    public static class AnonymousClass14 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23901a;

        public AnonymousClass14(Method method) {
            this.f23901a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new CreateWorkerPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$21$1
                @Override // com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint
                public Worker createWorker(Context context, Node node, String str, String str2) {
                    try {
                        return (Worker) invocationHandler.invoke(this, this.this$0.f23901a, new Object[]{context, node, str, str2});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$15, reason: invalid class name */
    public static class AnonymousClass15 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23902a;

        public AnonymousClass15(Method method) {
            this.f23902a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceResponsePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$22$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.engine.api.extensions.ResourceResponsePoint
                public void onResourceResponse(ResourceResponseInfo resourceResponseInfo) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23902a, new Object[]{resourceResponseInfo});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$16, reason: invalid class name */
    public static class AnonymousClass16 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23903a;

        public AnonymousClass16(Method method) {
            this.f23903a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PageBackInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$23$1
                @Override // com.alibaba.ariver.engine.api.point.PageBackInterceptPoint
                public boolean interceptBackEvent(GoBackCallback goBackCallback) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23903a, new Object[]{goBackCallback})).booleanValue();
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$17, reason: invalid class name */
    public static class AnonymousClass17 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23904a;

        public AnonymousClass17(Method method) {
            this.f23904a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new NativeCallResultPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$24$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.engine.api.point.NativeCallResultPoint
                public void onSendBack(NativeCallContext nativeCallContext, JSONObject jSONObject) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23904a, new Object[]{nativeCallContext, jSONObject});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$18, reason: invalid class name */
    public static class AnonymousClass18 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23905a;

        public AnonymousClass18(Method method) {
            this.f23905a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new NativeCallOnInvokePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$25$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.engine.api.point.NativeCallOnInvokePoint
                public void onInvoke(NativeCallContext nativeCallContext) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23905a, new Object[]{nativeCallContext});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$19, reason: invalid class name */
    public static class AnonymousClass19 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23906a;

        public AnonymousClass19(Method method) {
            this.f23906a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new NativeCallDispatchPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$26$1
                @Override // com.alibaba.ariver.engine.api.point.NativeCallDispatchPoint
                public void onCallDispatch(NativeCallContext nativeCallContext) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23906a, new Object[]{nativeCallContext});
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
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$20, reason: invalid class name */
    public static class AnonymousClass20 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23907a;
        final /* synthetic */ Method b;

        public AnonymousClass20(Method method, Method method2) {
            this.f23907a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new JsErrorInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$27$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.engine.api.point.JsErrorInterceptPoint
                public void onJsEngineErrorIntercept(String str, String str2) {
                    try {
                        invocationHandler.invoke(this, this.this$0.b, new Object[]{str, str2});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.engine.api.point.JsErrorInterceptPoint
                public void onWorkerErrorIntercept(String str, String str2) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23907a, new Object[]{str, str2});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$21, reason: invalid class name */
    public static class AnonymousClass21 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23908a;

        public AnonymousClass21(Method method) {
            this.f23908a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new WorkerExceptionPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$28$1
                @Override // com.alibaba.ariver.engine.api.point.WorkerExceptionPoint
                public void onCreateWorkerException(String str) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23908a, new Object[]{str});
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
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$22, reason: invalid class name */
    public static class AnonymousClass22 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23909a;

        public AnonymousClass22(Method method) {
            this.f23909a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new WebResourceResponseHandlePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$29$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.engine.api.point.network.WebResourceResponseHandlePoint
                public void onHandleResponse(String str, boolean z, boolean z2, byte[] bArr, String str2, JSONObject jSONObject) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23909a, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), bArr, str2, jSONObject});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$24, reason: invalid class name */
    public static class AnonymousClass24 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23910a;

        public AnonymousClass24(Method method) {
            this.f23910a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new HttpRequestResponseHandlePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$30$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.engine.api.point.network.HttpRequestResponseHandlePoint
                public void onHandleResponse(String str, String str2, JSONObject jSONObject) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23910a, new Object[]{str, str2, jSONObject});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$25, reason: invalid class name */
    public static class AnonymousClass25 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23911a;
        final /* synthetic */ Method b;

        public AnonymousClass25(Method method, Method method2) {
            this.f23911a = method;
            this.b = method2;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceLoadPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$31$1
                @Override // com.alibaba.ariver.engine.api.resources.ResourceLoadPoint
                public Resource load(ResourceLoadContext resourceLoadContext) {
                    try {
                        return (Resource) invocationHandler.invoke(this, this.this$0.f23911a, new Object[]{resourceLoadContext});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.engine.api.resources.ResourceLoadPoint
                public Resource loadGlobalResource(String str) {
                    try {
                        return (Resource) invocationHandler.invoke(this, this.this$0.b, new Object[]{str});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$26, reason: invalid class name */
    public static class AnonymousClass26 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23912a;

        public AnonymousClass26(Method method) {
            this.f23912a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new NativeCallNotFoundPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$32$1
                @Override // com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint
                public boolean handleNotFound(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23912a, new Object[]{nativeCallContext, bridgeResponseHelper})).booleanValue();
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$27, reason: invalid class name */
    public static class AnonymousClass27 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23913a;
        final /* synthetic */ Method b;
        final /* synthetic */ Method c;
        final /* synthetic */ Method d;
        final /* synthetic */ Method e;

        public AnonymousClass27(Method method, Method method2, Method method3, Method method4, Method method5) {
            this.f23913a = method;
            this.b = method2;
            this.c = method3;
            this.d = method4;
            this.e = method5;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new BridgeAccessPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$33$1
                @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
                public boolean asyncCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.d, new Object[]{permission, accessor, nativeCallContext, bridgeResponseHelper})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
                public boolean bizCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.b, new Object[]{permission, accessor, nativeCallContext, bridgeResponseHelper})).booleanValue();
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return false;
                    }
                }

                @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
                public ApiPermissionCheckResult checkPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
                    try {
                        return (ApiPermissionCheckResult) invocationHandler.invoke(this, this.this$0.c, new Object[]{permission, accessor, nativeCallContext, bridgeResponseHelper});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
                public Group manageAccessorGroup(Accessor accessor) {
                    try {
                        return (Group) invocationHandler.invoke(this, this.this$0.e, new Object[]{accessor});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
                public boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23913a, new Object[]{accessor, list})).booleanValue();
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.c$28, reason: invalid class name */
    public static class AnonymousClass28 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23914a;

        public AnonymousClass28(Method method) {
            this.f23914a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new EventSendInterceptorPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_engine_api_ExtOpt$34$1
                @Override // com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint
                public boolean needIntercept(String str, JSONObject jSONObject) {
                    try {
                        return ((Boolean) invocationHandler.invoke(this, this.this$0.f23914a, new Object[]{str, jSONObject})).booleanValue();
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
        ExtensionOpt.setupMethodInvokeOptimizer(ReceivedHeaderPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onReceivedResponseHeader".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((ReceivedHeaderPoint) extension).onReceivedResponseHeader((Map) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WorkerCreateConfigPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("isAsyncCreateWorker".equals(str) && objArr.length == 3) {
                    return Boolean.valueOf(((WorkerCreateConfigPoint) extension).isAsyncCreateWorker((Node) objArr[0], (String) objArr[1], (String) objArr[2]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WorkerStartParamInjectPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.23
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"injectStartParam".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((WorkerStartParamInjectPoint) extension).injectStartParam((Bundle) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(CreateWorkerPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.29
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("createWorker".equals(str) && objArr.length == 4) {
                    return ((CreateWorkerPoint) extension).createWorker((Context) objArr[0], (Node) objArr[1], (String) objArr[2], (String) objArr[3]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceResponsePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.30
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onResourceResponse".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((ResourceResponsePoint) extension).onResourceResponse((ResourceResponseInfo) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PageBackInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.31
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("interceptBackEvent".equals(str) && objArr.length == 1) {
                    return Boolean.valueOf(((PageBackInterceptPoint) extension).interceptBackEvent((GoBackCallback) objArr[0]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallResultPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.32
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onSendBack".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((NativeCallResultPoint) extension).onSendBack((NativeCallContext) objArr[0], (JSONObject) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallOnInvokePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.33
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onInvoke".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((NativeCallOnInvokePoint) extension).onInvoke((NativeCallContext) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallDispatchPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.34
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onCallDispatch".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((NativeCallDispatchPoint) extension).onCallDispatch((NativeCallContext) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(JsErrorInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onWorkerErrorIntercept".equals(str) && objArr.length == 2) {
                    ((JsErrorInterceptPoint) extension).onWorkerErrorIntercept((String) objArr[0], (String) objArr[1]);
                }
                if (!"onJsEngineErrorIntercept".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((JsErrorInterceptPoint) extension).onJsEngineErrorIntercept((String) objArr[0], (String) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WorkerExceptionPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onCreateWorkerException".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((WorkerExceptionPoint) extension).onCreateWorkerException((String) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(WebResourceResponseHandlePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.4
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onHandleResponse".equals(str) || objArr.length != 6) {
                    return null;
                }
                ((WebResourceResponseHandlePoint) extension).onHandleResponse((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), (byte[]) objArr[3], (String) objArr[4], (JSONObject) objArr[5]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(HttpRequestResponseHandlePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.5
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onHandleResponse".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((HttpRequestResponseHandlePoint) extension).onHandleResponse((String) objArr[0], (String) objArr[1], (JSONObject) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.6
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (TrackLoadSettingsAtom.TYPE.equals(str) && objArr.length == 1) {
                    return ((ResourceLoadPoint) extension).load((ResourceLoadContext) objArr[0]);
                }
                if ("loadGlobalResource".equals(str) && objArr.length == 1) {
                    return ((ResourceLoadPoint) extension).loadGlobalResource((String) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(NativeCallNotFoundPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.7
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("handleNotFound".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((NativeCallNotFoundPoint) extension).handleNotFound((NativeCallContext) objArr[0], (BridgeResponseHelper) objArr[1]));
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(BridgeAccessPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.8
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("needPermissionCheck".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((BridgeAccessPoint) extension).needPermissionCheck((Accessor) objArr[0], (List) objArr[1]));
                }
                if ("bizCheckPermission".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((BridgeAccessPoint) extension).bizCheckPermission((Permission) objArr[0], (Accessor) objArr[1], (NativeCallContext) objArr[2], (BridgeResponseHelper) objArr[3]));
                }
                if ("checkPermission".equals(str) && objArr.length == 4) {
                    return ((BridgeAccessPoint) extension).checkPermission((Permission) objArr[0], (Accessor) objArr[1], (NativeCallContext) objArr[2], (BridgeResponseHelper) objArr[3]);
                }
                if ("asyncCheckPermission".equals(str) && objArr.length == 4) {
                    return Boolean.valueOf(((BridgeAccessPoint) extension).asyncCheckPermission((Permission) objArr[0], (Accessor) objArr[1], (NativeCallContext) objArr[2], (BridgeResponseHelper) objArr[3]));
                }
                if ("manageAccessorGroup".equals(str) && objArr.length == 1) {
                    return ((BridgeAccessPoint) extension).manageAccessorGroup((Accessor) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(EventSendInterceptorPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.c.9
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("needIntercept".equals(str) && objArr.length == 2) {
                    return Boolean.valueOf(((EventSendInterceptorPoint) extension).needIntercept((String) objArr[0], (JSONObject) objArr[1]));
                }
                return null;
            }
        });
    }

    public static void b() {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static void c() {
        try {
            ExtensionPoint.registerProxyGenerator(ReceivedHeaderPoint.class, new AnonymousClass10(ReceivedHeaderPoint.class.getDeclaredMethod("onReceivedResponseHeader", Map.class)));
        } catch (Throwable th) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.extensions.ReceivedHeaderPoint error, ignored", th);
        }
        try {
            ExtensionPoint.registerProxyGenerator(WorkerCreateConfigPoint.class, new AnonymousClass11(WorkerCreateConfigPoint.class.getDeclaredMethod("isAsyncCreateWorker", Node.class, String.class, String.class)));
        } catch (Throwable th2) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.extensions.WorkerCreateConfigPoint error, ignored", th2);
        }
        try {
            ExtensionPoint.registerProxyGenerator(WorkerStartParamInjectPoint.class, new AnonymousClass13(WorkerStartParamInjectPoint.class.getDeclaredMethod("injectStartParam", Bundle.class)));
        } catch (Throwable th3) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint error, ignored", th3);
        }
        try {
            ExtensionPoint.registerProxyGenerator(CreateWorkerPoint.class, new AnonymousClass14(CreateWorkerPoint.class.getDeclaredMethod("createWorker", Context.class, Node.class, String.class, String.class)));
        } catch (Throwable th4) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint error, ignored", th4);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ResourceResponsePoint.class, new AnonymousClass15(ResourceResponsePoint.class.getDeclaredMethod("onResourceResponse", ResourceResponseInfo.class)));
        } catch (Throwable th5) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.extensions.ResourceResponsePoint error, ignored", th5);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PageBackInterceptPoint.class, new AnonymousClass16(PageBackInterceptPoint.class.getDeclaredMethod("interceptBackEvent", GoBackCallback.class)));
        } catch (Throwable th6) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.PageBackInterceptPoint error, ignored", th6);
        }
        try {
            ExtensionPoint.registerProxyGenerator(NativeCallResultPoint.class, new AnonymousClass17(NativeCallResultPoint.class.getDeclaredMethod("onSendBack", NativeCallContext.class, JSONObject.class)));
        } catch (Throwable th7) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.NativeCallResultPoint error, ignored", th7);
        }
        try {
            ExtensionPoint.registerProxyGenerator(NativeCallOnInvokePoint.class, new AnonymousClass18(NativeCallOnInvokePoint.class.getDeclaredMethod("onInvoke", NativeCallContext.class)));
        } catch (Throwable th8) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.NativeCallOnInvokePoint error, ignored", th8);
        }
        try {
            ExtensionPoint.registerProxyGenerator(NativeCallDispatchPoint.class, new AnonymousClass19(NativeCallDispatchPoint.class.getDeclaredMethod("onCallDispatch", NativeCallContext.class)));
        } catch (Throwable th9) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.NativeCallDispatchPoint error, ignored", th9);
        }
        try {
            ExtensionPoint.registerProxyGenerator(JsErrorInterceptPoint.class, new AnonymousClass20(JsErrorInterceptPoint.class.getDeclaredMethod("onWorkerErrorIntercept", String.class, String.class), JsErrorInterceptPoint.class.getDeclaredMethod("onJsEngineErrorIntercept", String.class, String.class)));
        } catch (Throwable th10) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.JsErrorInterceptPoint error, ignored", th10);
        }
        try {
            ExtensionPoint.registerProxyGenerator(WorkerExceptionPoint.class, new AnonymousClass21(WorkerExceptionPoint.class.getDeclaredMethod("onCreateWorkerException", String.class)));
        } catch (Throwable th11) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.WorkerExceptionPoint error, ignored", th11);
        }
        try {
            Class cls = Boolean.TYPE;
            ExtensionPoint.registerProxyGenerator(WebResourceResponseHandlePoint.class, new AnonymousClass22(WebResourceResponseHandlePoint.class.getDeclaredMethod("onHandleResponse", String.class, cls, cls, byte[].class, String.class, JSONObject.class)));
        } catch (Throwable th12) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.network.WebResourceResponseHandlePoint error, ignored", th12);
        }
        try {
            ExtensionPoint.registerProxyGenerator(HttpRequestResponseHandlePoint.class, new AnonymousClass24(HttpRequestResponseHandlePoint.class.getDeclaredMethod("onHandleResponse", String.class, String.class, JSONObject.class)));
        } catch (Throwable th13) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.point.network.HttpRequestResponseHandlePoint error, ignored", th13);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ResourceLoadPoint.class, new AnonymousClass25(ResourceLoadPoint.class.getDeclaredMethod(TrackLoadSettingsAtom.TYPE, ResourceLoadContext.class), ResourceLoadPoint.class.getDeclaredMethod("loadGlobalResource", String.class)));
        } catch (Throwable th14) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.resources.ResourceLoadPoint error, ignored", th14);
        }
        try {
            ExtensionPoint.registerProxyGenerator(NativeCallNotFoundPoint.class, new AnonymousClass26(NativeCallNotFoundPoint.class.getDeclaredMethod("handleNotFound", NativeCallContext.class, BridgeResponseHelper.class)));
        } catch (Throwable th15) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.bridge.NativeCallNotFoundPoint error, ignored", th15);
        }
        try {
            ExtensionPoint.registerProxyGenerator(BridgeAccessPoint.class, new AnonymousClass27(BridgeAccessPoint.class.getDeclaredMethod("needPermissionCheck", Accessor.class, List.class), BridgeAccessPoint.class.getDeclaredMethod("bizCheckPermission", Permission.class, Accessor.class, NativeCallContext.class, BridgeResponseHelper.class), BridgeAccessPoint.class.getDeclaredMethod("checkPermission", Permission.class, Accessor.class, NativeCallContext.class, BridgeResponseHelper.class), BridgeAccessPoint.class.getDeclaredMethod("asyncCheckPermission", Permission.class, Accessor.class, NativeCallContext.class, BridgeResponseHelper.class), BridgeAccessPoint.class.getDeclaredMethod("manageAccessorGroup", Accessor.class)));
        } catch (Throwable th16) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.security.BridgeAccessPoint error, ignored", th16);
        }
        try {
            ExtensionPoint.registerProxyGenerator(EventSendInterceptorPoint.class, new AnonymousClass28(EventSendInterceptorPoint.class.getDeclaredMethod("needIntercept", String.class, JSONObject.class)));
        } catch (Throwable th17) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint error, ignored", th17);
        }
    }
}
