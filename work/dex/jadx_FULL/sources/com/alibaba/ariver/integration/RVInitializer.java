package com.alibaba.ariver.integration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.NodeInstance;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.ipc.ServerMsgReceiver;
import com.alibaba.ariver.commonability.integration.ManifestManager;
import com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher;
import com.alibaba.ariver.ipc.RemoteCallClient;
import com.alibaba.ariver.kernel.BuildConfig;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.DefaultExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.BridgeDSLRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.DefaultExtensionRegistry;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionRegistry;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RVInitializer {
    private static final String MANIFEST_CLZ = "com.alibaba.ariver.AriverManifest";
    private static final String MANIFEST_COMMONABILITY_CLZ = "com.alibaba.ariver.commonability.integration.ManifestManager";
    private static final String MANIFEST_META_KEY = "ariver_manifest";
    private static boolean alreadyInited = false;
    private static boolean alreadySetupProxy = false;
    private static ExtensionManager sExtensionManager;
    private static RVProxy.Printer sPrinter;
    private static RVManifest sProjectManifest;
    private static String[] optPackages = {BuildConfig.APPLICATION_ID, com.alibaba.ariver.kernel.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.app.BuildConfig.APPLICATION_ID, com.alibaba.ariver.app.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.resource.a.b, com.alibaba.ariver.resource.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.engine.BuildConfig.APPLICATION_ID, com.alibaba.ariver.engine.api.BuildConfig.APPLICATION_ID, com.alibaba.ariver.jsapi.a.b, a.b, com.alibaba.ariver.permission.a.b, "com.alibaba.ariver.permission.api", com.alibaba.ariver.commonability.file.b.b, "com.alibaba.ariver.commonability.device", "com.alipay.mobile.aompfilemanager", "com.alipay.mobile.nebulax.resource.biz", "com.alipay.mobile.nebulax.integration.base", "com.alipay.mobile.nebulax.integration.wallet"};
    private static AtomicBoolean sOptOptimizeInited = new AtomicBoolean(false);

    private static void ensureManifestFile(Context context) {
        RVManifest rVManifest;
        Bundle bundle;
        if (sProjectManifest != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        getPrinter().print("ensureManifestFile " + Log.getStackTraceString(new Throwable()));
        RVManifest rVManifest2 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(MANIFEST_META_KEY)) {
                rVManifest = null;
            } else {
                Class<?> cls = Class.forName(applicationInfo.metaData.getString(MANIFEST_META_KEY));
                getPrinter().print("got Manifest class from metaData: " + cls);
                rVManifest = (RVManifest) cls.newInstance();
            }
        } catch (Throwable th) {
            getPrinter().print("getStringValueFromMetaData!" + Log.getStackTraceString(th));
        }
        if (rVManifest == null) {
            try {
                Class<?> cls2 = Class.forName(MANIFEST_CLZ);
                getPrinter().print("got Manifest class: " + cls2);
                rVManifest = (RVManifest) cls2.newInstance();
            } catch (Throwable th2) {
                getPrinter().print("generate manifest exception!" + Log.getStackTraceString(th2));
            }
        }
        if (rVManifest == null) {
            throw new IllegalStateException("Cannot find com.alibaba.ariver.AriverManifest");
        }
        arrayList.add(rVManifest);
        try {
            getPrinter().print("got commonAbility Manifest class: " + ManifestManager.class);
            rVManifest2 = (RVManifest) ManifestManager.class.newInstance();
        } catch (Throwable th3) {
            getPrinter().print("generate commonAbility manifest exception!" + Log.getStackTraceString(th3));
        }
        if (rVManifest2 == null) {
            getPrinter().print("commonAbilityManifest null!!");
        } else {
            arrayList.add(rVManifest2);
        }
        sProjectManifest = new c(arrayList, getPrinter());
        getPrinter().print("got mainManifest file: " + rVManifest);
    }

    public static ExtensionManager getExtensionManager() {
        return sExtensionManager;
    }

    private static synchronized RVProxy.Printer getPrinter() {
        if (sPrinter == null) {
            sPrinter = new RVProxy.EmptyPrinter();
        }
        return sPrinter;
    }

    public static RVManifest getProjectManifest() {
        return sProjectManifest;
    }

    public static synchronized void init(Context context) {
        init(context, null);
    }

    private static String initClassNameFromPkgName(String str) {
        String[] strArr = {"com.alipay.mobile.nebulax.integration.wallet", "com.alibaba.ariver.commonability.device", com.alibaba.ariver.commonability.file.b.b};
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            if (str.startsWith(str2)) {
                str = str2;
            }
        }
        String[] strArrSplit = str.split("\\.");
        int i2 = str.startsWith("com.alipay.mobile.nebulax") ? 6 : str.startsWith(com.alibaba.ariver.commonability.a.b) ? 5 : 4;
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (String str3 : strArrSplit) {
            if (i3 > i2 || (i3 > i2 - 1 && !"api".equalsIgnoreCase(str3))) {
                break;
            }
            if (i3 > 0) {
                sb.append(LoginConstants.UNDER_LINE);
            }
            sb.append(str3);
            i3++;
        }
        sb.append("_ExtOpt");
        String string = sb.toString();
        System.out.println("get final class name: " + string);
        return string;
    }

    public static void registerBizHandler() {
        ServerMsgReceiver.getInstance().registerBizHandler(IpcMessageConstants.BIZ_APP, new com.alibaba.ariver.integration.ipc.server.a());
        ServerMsgReceiver.getInstance().registerBizHandler(IpcMessageConstants.BIZ_APP, new com.alibaba.ariver.integration.ipc.server.c(sExtensionManager));
        IpcChannelManager.getInstance().registerServerChannel(new IIpcChannel.Stub() { // from class: com.alibaba.ariver.integration.RVInitializer.1
            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public boolean isFinishing() {
                return false;
            }

            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public void sendMessage(IpcMessage ipcMessage) {
                ServerMsgReceiver.getInstance().handleMessage(ipcMessage);
            }
        });
        List<RVManifest.ServiceBeanManifest> serviceBeans = sProjectManifest.getServiceBeans(sExtensionManager);
        if (serviceBeans != null) {
            for (RVManifest.ServiceBeanManifest serviceBeanManifest : serviceBeans) {
                ((RVRemoteCallerProxy) RVProxy.get(RVRemoteCallerProxy.class)).registerServiceBean(serviceBeanManifest.beanClass, serviceBeanManifest.beanObject.get());
            }
        }
    }

    private static void registerExtensionsForFinalExecute(List<ExtensionMetaInfo> list) {
        list.add(new ExtensionMetaInfo("ariver-build", "com.alibaba.ariver.jsapi.logging.RVPerfLogLifeCycleExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.page.PageInitPoint", "com.alibaba.ariver.app.api.point.page.PageExitPoint", "com.alibaba.ariver.app.api.point.app.AppExitPoint"), (Class<? extends Scope>) App.class));
    }

    public static synchronized void reset() {
        alreadyInited = false;
        alreadySetupProxy = false;
    }

    public static void setPrinter(RVProxy.Printer printer) {
        sPrinter = printer;
    }

    public static void setProjectManifest(RVManifest rVManifest) {
        sProjectManifest = rVManifest;
    }

    public static void setupOptimize() {
        if (!((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_apt", true)) {
            ExtensionPoint.clearProxyGenerator();
            ExtensionOpt.clearAllMethodInvokeOptimizer();
            sOptOptimizeInited.getAndSet(false);
            return;
        }
        if (sOptOptimizeInited.getAndSet(true)) {
            return;
        }
        for (String str : optPackages) {
            try {
                String strInitClassNameFromPkgName = initClassNameFromPkgName(str);
                getPrinter().print("RVInitializer.setupOptimize get final class name: " + strInitClassNameFromPkgName + " for packageName: " + str);
                StringBuilder sb = new StringBuilder();
                sb.append("com.alibaba.ariver.apt.");
                sb.append(strInitClassNameFromPkgName);
                Class<?> cls = Class.forName(sb.toString());
                ReflectUtils.invokeMethod((Class) cls, "opt1");
                ReflectUtils.invokeMethod((Class) cls, "opt2");
                ReflectUtils.invokeMethod((Class) cls, "opt3");
            } catch (Throwable th) {
                getPrinter().print("RVInitializer.setupOptimize error: " + th.getMessage());
            }
        }
    }

    public static synchronized void setupProxy(Context context) {
        if (alreadySetupProxy) {
            return;
        }
        getPrinter().print("begin setupProxy");
        alreadySetupProxy = true;
        ensureManifestFile(context);
        try {
            RVProxy.setPrinter(getPrinter());
            List<RVManifest.IProxyManifest> proxies = sProjectManifest.getProxies();
            int size = proxies == null ? 0 : proxies.size();
            getPrinter().print("setupProxy size " + size);
            if (proxies != null) {
                for (RVManifest.IProxyManifest iProxyManifest : proxies) {
                    try {
                        InstanceType instanceType = iProxyManifest.getInstanceType();
                        if (iProxyManifest instanceof RVManifest.ProxyManifest) {
                            RVProxy.set(instanceType, ((RVManifest.ProxyManifest) iProxyManifest).proxiableClass, ((RVManifest.ProxyManifest) iProxyManifest).implObject);
                        } else if (iProxyManifest instanceof RVManifest.LazyProxyManifest) {
                            RVProxy.setLazy(instanceType, ((RVManifest.LazyProxyManifest) iProxyManifest).proxiableClass, ((RVManifest.LazyProxyManifest) iProxyManifest).implObject);
                        }
                    } catch (Throwable th) {
                        getPrinter().print("setupProxy item exception!" + Log.getStackTraceString(th));
                    }
                }
            }
            RVProxy.sHasSetupProxy = true;
        } catch (Throwable th2) {
            getPrinter().print("setupProxy error!" + Log.getStackTraceString(th2));
            throw new IllegalStateException("setupProxy error!", th2);
        }
    }

    public static synchronized void init(Context context, @Nullable ExtensionManager extensionManager) {
        ExtensionRegistry defaultExtensionRegistry;
        BridgeDSLRegistry bridgeDSLRegistry;
        int size;
        try {
            if (alreadyInited) {
                return;
            }
            getPrinter().print("begin RVInitializer.init");
            alreadyInited = true;
            ensureManifestFile(context);
            setupProxy(context);
            try {
                getPrinter().print("RVInitializer.init step 1");
                if (extensionManager != null) {
                    defaultExtensionRegistry = extensionManager.getExtensionRegistry();
                } else {
                    defaultExtensionRegistry = new DefaultExtensionRegistry();
                }
                if (extensionManager != null) {
                    bridgeDSLRegistry = extensionManager.getBridgeDSLRegistry();
                } else {
                    bridgeDSLRegistry = new BridgeDSLRegistry();
                }
                getPrinter().print("RVInitializer.init step 2");
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                List<RVManifest.BridgeExtensionManifest> bridgeExtensions = sProjectManifest.getBridgeExtensions();
                if (bridgeExtensions != null) {
                    size = bridgeExtensions.size();
                    for (RVManifest.BridgeExtensionManifest bridgeExtensionManifest : bridgeExtensions) {
                        if (bridgeExtensionManifest.isRawType) {
                            defaultExtensionRegistry.register(bridgeExtensionManifest.extensionMetaInfo);
                        } else {
                            defaultExtensionRegistry.register(bridgeExtensionManifest.target, bridgeExtensionManifest.scope, bridgeExtensionManifest.instanceType);
                        }
                        List<BridgeDSL> list = bridgeExtensionManifest.bridgeDSLs;
                        if (list != null && !list.isEmpty()) {
                            bridgeDSLRegistry.register(bridgeExtensionManifest.bridgeDSLs);
                        }
                    }
                } else {
                    size = 0;
                }
                getPrinter().print("register bridge done with size: " + size + ", cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                List<ExtensionMetaInfo> extensions = sProjectManifest.getExtensions();
                registerExtensionsForFinalExecute(extensions);
                if (extensions != null) {
                    size = extensions.size();
                    Iterator<ExtensionMetaInfo> it = extensions.iterator();
                    while (it.hasNext()) {
                        defaultExtensionRegistry.register(it.next());
                    }
                }
                getPrinter().print("register extension done with size: " + size + ", cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                if (extensionManager == null) {
                    extensionManager = new DefaultExtensionManager(sProjectManifest.getAccessController(), sProjectManifest.getRemoteController(), defaultExtensionRegistry, bridgeDSLRegistry);
                }
                getPrinter().print("register bridge done with jsapi count: " + defaultExtensionRegistry.getActionCount());
                BridgeDispatcher.getInstance().bindExtensionManager(extensionManager);
                ExtensionPoint.bind(extensionManager);
                NodeInstance.bindExtensionManager(extensionManager);
                sExtensionManager = extensionManager;
                List<AppUpdaterFactory.Rule> appUpdaterRules = sProjectManifest.getAppUpdaterRules();
                if (appUpdaterRules != null) {
                    Iterator<AppUpdaterFactory.Rule> it2 = appUpdaterRules.iterator();
                    while (it2.hasNext()) {
                        AppUpdaterFactory.registerRule(it2.next());
                    }
                }
                if (ProcessUtils.isMainProcess()) {
                    registerBizHandler();
                } else {
                    RemoteCallClient.prepare();
                }
                setupOptimize();
                getPrinter().print("end RVInitializer.init");
            } catch (Throwable th) {
                getPrinter().print("setup ExtensionManager exception!" + Log.getStackTraceString(th));
                throw new IllegalStateException("setup ExtensionManager exception!", th);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
