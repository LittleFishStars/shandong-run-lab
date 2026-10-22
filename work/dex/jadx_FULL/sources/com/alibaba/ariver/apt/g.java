package com.alibaba.ariver.apt;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint;
import com.alibaba.ariver.resource.api.extension.AppModelInitPoint;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint;
import com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint;
import com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint;
import com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint;
import com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint;
import com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class g {

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$10, reason: invalid class name */
    public static class AnonymousClass10 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23917a;

        public AnonymousClass10(Method method) {
            this.f23917a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceInterceptRequestPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$18$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint
                public void shouldInterceptRequest(Page page, String str, String str2, Map<String, String> map, long j) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23917a, new Object[]{page, str, str2, map, Long.valueOf(j)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$11, reason: invalid class name */
    public static class AnonymousClass11 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23918a;

        public AnonymousClass11(Method method) {
            this.f23918a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PluginPackageParsedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$19$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint
                public void onPluginParsed(AppModel appModel, PluginModel pluginModel, ResourcePackage resourcePackage) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23918a, new Object[]{appModel, pluginModel, resourcePackage});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$13, reason: invalid class name */
    public static class AnonymousClass13 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23919a;

        public AnonymousClass13(Method method) {
            this.f23919a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppConfigModelInitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$20$1
                @Override // com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint
                public void onAppConfigModelInit(App app, AppConfigModel appConfigModel) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23919a, new Object[]{app, appConfigModel});
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$14, reason: invalid class name */
    public static class AnonymousClass14 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23920a;

        public AnonymousClass14(Method method) {
            this.f23920a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceInterceptPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$21$1
                @Override // com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint
                public Resource intercept(Resource resource) {
                    try {
                        return (Resource) invocationHandler.invoke(this, this.this$0.f23920a, new Object[]{resource});
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$15, reason: invalid class name */
    public static class AnonymousClass15 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23921a;

        public AnonymousClass15(Method method) {
            this.f23921a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new AppModelInitPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$22$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.AppModelInitPoint
                public void onGetAppInfo(AppModel appModel) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23921a, new Object[]{appModel});
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$16, reason: invalid class name */
    public static class AnonymousClass16 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23922a;

        public AnonymousClass16(Method method) {
            this.f23922a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceReceivedResponsePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$23$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint
                public void onResourceResponse(Page page, String str, int i, Map<String, String> map, long j) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23922a, new Object[]{page, str, Integer.valueOf(i), map, Long.valueOf(j)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$17, reason: invalid class name */
    public static class AnonymousClass17 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23923a;

        public AnonymousClass17(Method method) {
            this.f23923a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourcePerceptionResponsePoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$24$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint
                public void onResourceResponse(String str, int i, String str2, Map<String, String> map, long j, long j2) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23923a, new Object[]{str, Integer.valueOf(i), str2, map, Long.valueOf(j), Long.valueOf(j2)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$5, reason: invalid class name */
    public static class AnonymousClass5 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23924a;
        final /* synthetic */ Method b;
        final /* synthetic */ Method c;

        public AnonymousClass5(Method method, Method method2, Method method3) {
            this.f23924a = method;
            this.b = method2;
            this.c = method3;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PackageQueryPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$13$1
                @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
                public ResourcePackage createPluginPackage(PluginModel pluginModel, ResourceContext resourceContext) {
                    try {
                        return (ResourcePackage) invocationHandler.invoke(this, this.this$0.c, new Object[]{pluginModel, resourceContext});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
                public ResourcePackage getMainPackage(ResourceContext resourceContext) {
                    try {
                        return (ResourcePackage) invocationHandler.invoke(this, this.this$0.f23924a, new Object[]{resourceContext});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                        return null;
                    }
                }

                @Override // com.alibaba.ariver.resource.api.extension.PackageQueryPoint
                public Set<ResourcePackage> getResourcePackages(ResourceContext resourceContext) {
                    try {
                        return (Set) invocationHandler.invoke(this, this.this$0.b, new Object[]{resourceContext});
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

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$6, reason: invalid class name */
    public static class AnonymousClass6 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23925a;

        public AnonymousClass6(Method method) {
            this.f23925a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceFinishLoadPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$14$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint
                public void onResourceFinishLoad(Page page, String str, long j, long j2) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23925a, new Object[]{page, str, Long.valueOf(j), Long.valueOf(j2)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$7, reason: invalid class name */
    public static class AnonymousClass7 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23926a;

        public AnonymousClass7(Method method) {
            this.f23926a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourcePerceptionRequestPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$15$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint
                public void onResourceRequest(String str, String str2, Map<String, String> map, long j) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23926a, new Object[]{str, str2, map, Long.valueOf(j)});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$8, reason: invalid class name */
    public static class AnonymousClass8 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23927a;

        public AnonymousClass8(Method method) {
            this.f23927a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new PackageParsedPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$16$1
                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onFinalized() {
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Extension
                public void onInitialized() {
                }

                @Override // com.alibaba.ariver.resource.api.extension.PackageParsedPoint
                public void onResourceParsed(AppModel appModel, ResourcePackage resourcePackage) {
                    try {
                        invocationHandler.invoke(this, this.this$0.f23927a, new Object[]{appModel, resourcePackage});
                    } catch (Throwable th) {
                        ExtensionPoint.reportException(th);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.apt.g$9, reason: invalid class name */
    public static class AnonymousClass9 implements ExtensionPoint.ProxyGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23928a;

        public AnonymousClass9(Method method) {
            this.f23928a = method;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.ExtensionPoint.ProxyGenerator
        public Object createProxyInstance(final InvocationHandler invocationHandler) {
            return new ResourceProviderPoint() { // from class: com.alibaba.ariver.apt.com_alibaba_ariver_resource_api_ExtOpt$17$1
                @Override // com.alibaba.ariver.resource.api.extension.ResourceProviderPoint
                public Resource getResource(ResourceQuery resourceQuery) {
                    try {
                        return (Resource) invocationHandler.invoke(this, this.this$0.f23928a, new Object[]{resourceQuery});
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

    public static void a() {
        ExtensionOpt.setupMethodInvokeOptimizer(PackageQueryPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getMainPackage".equals(str) && objArr.length == 1) {
                    return ((PackageQueryPoint) extension).getMainPackage((ResourceContext) objArr[0]);
                }
                if ("getResourcePackages".equals(str) && objArr.length == 1) {
                    return ((PackageQueryPoint) extension).getResourcePackages((ResourceContext) objArr[0]);
                }
                if ("createPluginPackage".equals(str) && objArr.length == 2) {
                    return ((PackageQueryPoint) extension).createPluginPackage((PluginModel) objArr[0], (ResourceContext) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceFinishLoadPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onResourceFinishLoad".equals(str) || objArr.length != 4) {
                    return null;
                }
                ((ResourceFinishLoadPoint) extension).onResourceFinishLoad((Page) objArr[0], (String) objArr[1], ((Long) objArr[2]).longValue(), ((Long) objArr[3]).longValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourcePerceptionRequestPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.18
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onResourceRequest".equals(str) || objArr.length != 4) {
                    return null;
                }
                ((ResourcePerceptionRequestPoint) extension).onResourceRequest((String) objArr[0], (String) objArr[1], (Map) objArr[2], ((Long) objArr[3]).longValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PackageParsedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.19
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onResourceParsed".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((PackageParsedPoint) extension).onResourceParsed((AppModel) objArr[0], (ResourcePackage) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceProviderPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.20
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getResource".equals(str) && objArr.length == 1) {
                    return ((ResourceProviderPoint) extension).getResource((ResourceQuery) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceInterceptRequestPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.21
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"shouldInterceptRequest".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((ResourceInterceptRequestPoint) extension).shouldInterceptRequest((Page) objArr[0], (String) objArr[1], (String) objArr[2], (Map) objArr[3], ((Long) objArr[4]).longValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(PluginPackageParsedPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.22
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onPluginParsed".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((PluginPackageParsedPoint) extension).onPluginParsed((AppModel) objArr[0], (PluginModel) objArr[1], (ResourcePackage) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppConfigModelInitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.23
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onAppConfigModelInit".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((AppConfigModelInitPoint) extension).onAppConfigModelInit((App) objArr[0], (AppConfigModel) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceInterceptPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.24
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("intercept".equals(str) && objArr.length == 1) {
                    return ((ResourceInterceptPoint) extension).intercept((Resource) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(AppModelInitPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onGetAppInfo".equals(str) || objArr.length != 1) {
                    return null;
                }
                ((AppModelInitPoint) extension).onGetAppInfo((AppModel) objArr[0]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourceReceivedResponsePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onResourceResponse".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((ResourceReceivedResponsePoint) extension).onResourceResponse((Page) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (Map) objArr[3], ((Long) objArr[4]).longValue());
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizer(ResourcePerceptionResponsePoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.g.4
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"onResourceResponse".equals(str) || objArr.length != 6) {
                    return null;
                }
                ((ResourcePerceptionResponsePoint) extension).onResourceResponse((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], (Map) objArr[3], ((Long) objArr[4]).longValue(), ((Long) objArr[5]).longValue());
                return null;
            }
        });
    }

    public static void b() {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static void c() {
        Class cls;
        Class cls2;
        try {
            cls = ResourceInterceptRequestPoint.class;
            try {
                cls2 = ResourceProviderPoint.class;
                try {
                    ExtensionPoint.registerProxyGenerator(PackageQueryPoint.class, new AnonymousClass5(PackageQueryPoint.class.getDeclaredMethod("getMainPackage", ResourceContext.class), PackageQueryPoint.class.getDeclaredMethod("getResourcePackages", ResourceContext.class), PackageQueryPoint.class.getDeclaredMethod("createPluginPackage", PluginModel.class, ResourceContext.class)));
                } catch (Throwable th) {
                    th = th;
                    RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PackageQueryPoint error, ignored", th);
                }
            } catch (Throwable th2) {
                th = th2;
                cls2 = ResourceProviderPoint.class;
                RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PackageQueryPoint error, ignored", th);
                Class cls3 = Long.TYPE;
                ExtensionPoint.registerProxyGenerator(ResourceFinishLoadPoint.class, new AnonymousClass6(ResourceFinishLoadPoint.class.getDeclaredMethod("onResourceFinishLoad", Page.class, String.class, cls3, cls3)));
                ExtensionPoint.registerProxyGenerator(ResourcePerceptionRequestPoint.class, new AnonymousClass7(ResourcePerceptionRequestPoint.class.getDeclaredMethod("onResourceRequest", String.class, String.class, Map.class, Long.TYPE)));
                ExtensionPoint.registerProxyGenerator(PackageParsedPoint.class, new AnonymousClass8(PackageParsedPoint.class.getDeclaredMethod("onResourceParsed", AppModel.class, ResourcePackage.class)));
                Class cls4 = cls2;
                ExtensionPoint.registerProxyGenerator(cls4, new AnonymousClass9(cls4.getDeclaredMethod("getResource", ResourceQuery.class)));
                Class cls5 = cls;
                ExtensionPoint.registerProxyGenerator(cls5, new AnonymousClass10(cls5.getDeclaredMethod("shouldInterceptRequest", Page.class, String.class, String.class, Map.class, Long.TYPE)));
                ExtensionPoint.registerProxyGenerator(PluginPackageParsedPoint.class, new AnonymousClass11(PluginPackageParsedPoint.class.getDeclaredMethod("onPluginParsed", AppModel.class, PluginModel.class, ResourcePackage.class)));
                ExtensionPoint.registerProxyGenerator(AppConfigModelInitPoint.class, new AnonymousClass13(AppConfigModelInitPoint.class.getDeclaredMethod("onAppConfigModelInit", App.class, AppConfigModel.class)));
                ExtensionPoint.registerProxyGenerator(ResourceInterceptPoint.class, new AnonymousClass14(ResourceInterceptPoint.class.getDeclaredMethod("intercept", Resource.class)));
                ExtensionPoint.registerProxyGenerator(AppModelInitPoint.class, new AnonymousClass15(AppModelInitPoint.class.getDeclaredMethod("onGetAppInfo", AppModel.class)));
                ExtensionPoint.registerProxyGenerator(ResourceReceivedResponsePoint.class, new AnonymousClass16(ResourceReceivedResponsePoint.class.getDeclaredMethod("onResourceResponse", Page.class, String.class, Integer.TYPE, Map.class, Long.TYPE)));
                Class cls6 = Long.TYPE;
                ExtensionPoint.registerProxyGenerator(ResourcePerceptionResponsePoint.class, new AnonymousClass17(ResourcePerceptionResponsePoint.class.getDeclaredMethod("onResourceResponse", String.class, Integer.TYPE, String.class, Map.class, cls6, cls6)));
            }
        } catch (Throwable th3) {
            th = th3;
            cls = ResourceInterceptRequestPoint.class;
        }
        try {
            Class cls7 = Long.TYPE;
            ExtensionPoint.registerProxyGenerator(ResourceFinishLoadPoint.class, new AnonymousClass6(ResourceFinishLoadPoint.class.getDeclaredMethod("onResourceFinishLoad", Page.class, String.class, cls7, cls7)));
        } catch (Throwable th4) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceFinishLoadPoint error, ignored", th4);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ResourcePerceptionRequestPoint.class, new AnonymousClass7(ResourcePerceptionRequestPoint.class.getDeclaredMethod("onResourceRequest", String.class, String.class, Map.class, Long.TYPE)));
        } catch (Throwable th5) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint error, ignored", th5);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PackageParsedPoint.class, new AnonymousClass8(PackageParsedPoint.class.getDeclaredMethod("onResourceParsed", AppModel.class, ResourcePackage.class)));
        } catch (Throwable th6) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PackageParsedPoint error, ignored", th6);
        }
        try {
            Class cls8 = cls2;
            ExtensionPoint.registerProxyGenerator(cls8, new AnonymousClass9(cls8.getDeclaredMethod("getResource", ResourceQuery.class)));
        } catch (Throwable th7) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceProviderPoint error, ignored", th7);
        }
        try {
            Class cls9 = cls;
            ExtensionPoint.registerProxyGenerator(cls9, new AnonymousClass10(cls9.getDeclaredMethod("shouldInterceptRequest", Page.class, String.class, String.class, Map.class, Long.TYPE)));
        } catch (Throwable th8) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceInterceptRequestPoint error, ignored", th8);
        }
        try {
            ExtensionPoint.registerProxyGenerator(PluginPackageParsedPoint.class, new AnonymousClass11(PluginPackageParsedPoint.class.getDeclaredMethod("onPluginParsed", AppModel.class, PluginModel.class, ResourcePackage.class)));
        } catch (Throwable th9) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint error, ignored", th9);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppConfigModelInitPoint.class, new AnonymousClass13(AppConfigModelInitPoint.class.getDeclaredMethod("onAppConfigModelInit", App.class, AppConfigModel.class)));
        } catch (Throwable th10) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.AppConfigModelInitPoint error, ignored", th10);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ResourceInterceptPoint.class, new AnonymousClass14(ResourceInterceptPoint.class.getDeclaredMethod("intercept", Resource.class)));
        } catch (Throwable th11) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint error, ignored", th11);
        }
        try {
            ExtensionPoint.registerProxyGenerator(AppModelInitPoint.class, new AnonymousClass15(AppModelInitPoint.class.getDeclaredMethod("onGetAppInfo", AppModel.class)));
        } catch (Throwable th12) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.AppModelInitPoint error, ignored", th12);
        }
        try {
            ExtensionPoint.registerProxyGenerator(ResourceReceivedResponsePoint.class, new AnonymousClass16(ResourceReceivedResponsePoint.class.getDeclaredMethod("onResourceResponse", Page.class, String.class, Integer.TYPE, Map.class, Long.TYPE)));
        } catch (Throwable th13) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourceReceivedResponsePoint error, ignored", th13);
        }
        try {
            Class cls10 = Long.TYPE;
            ExtensionPoint.registerProxyGenerator(ResourcePerceptionResponsePoint.class, new AnonymousClass17(ResourcePerceptionResponsePoint.class.getDeclaredMethod("onResourceResponse", String.class, Integer.TYPE, String.class, Map.class, cls10, cls10)));
        } catch (Throwable th14) {
            RVLogger.e("registerProxyGenerator com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint error, ignored", th14);
        }
    }
}
