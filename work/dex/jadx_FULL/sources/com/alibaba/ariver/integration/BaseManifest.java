package com.alibaba.ariver.integration;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestManager;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.track.JsApiStatTrackServiceImpl;
import com.alibaba.ariver.integration.ipc.server.ServerSideRemoteExtensionCaller;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.remote.internal.DefaultRemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.ariver.websocket.core.DefaultWebSocketProxyImpl;
import com.alibaba.ariver.websocket.proxy.RVWebSocketProxy;
import com.alipay.sdk.m.c0.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class BaseManifest implements RVManifest {
    private AccessController mAccessController = null;
    private RemoteController mRemoteController = null;

    private static boolean isInStandardCashierSDK() {
        try {
            Class.forName("com.alipay.sdk.app.PayTask");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    @Nullable
    public synchronized AccessController getAccessController() {
        if (this.mAccessController == null) {
            this.mAccessController = new DefaultAccessController();
        }
        return this.mAccessController;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.toast.ToastBridgeExtension", Arrays.asList("toast", "hideToast")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.DatePickerBridgeExtension", Arrays.asList("datePicker")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension", Arrays.asList("alert", "confirm", "prompt", "agreementConfirm")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.LoadingBridgeExtension", Arrays.asList(RVParams.LONG_SHOW_LOADING, "hideLoading"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.network.NetworkBridgeExtension", Arrays.asList("getNetworkType")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.android.playground.extensions.SystemInfoBridgeExtension", Arrays.asList(JSApiCachePoint.GET_SYSTEM_INFO)));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.AppRunTimeInfoBridgeExtension", Arrays.asList("getLocaleInfo", "getLayoutDirection")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension", Arrays.asList("registerWorker", com.alibaba.triver.embed.webview.b.f24908a, "loadPlugin"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.EmbedViewBridgeExtension", Arrays.asList("NBComponent.render", "NBComponent.sendMessage", "NBComponent.remove")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.EmbedWebViewBridgeExtension", Arrays.asList("postWebViewMessage", "getEmbedWebViewEnv")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.security.OpenAuthExtension", Arrays.asList("getAuthorize", "getAuthCode", "getAuthUserInfo", "getBusinessAuth", "getComponentAuth", "showAuthGuide")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.security.ProgramSettingExtension", Arrays.asList("getSetting")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.security.TBAuthorizeBridge", Arrays.asList("getTBCode", "authorize", "setTBSessionInfo", "getTBSessionInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.security.TBAuthorizeOpenSettingExtension", Arrays.asList("openSetting")).instanceType(InstanceType.TAOBAO));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.resource.template.TemplateBridgeExtension", Arrays.asList("getExtConfig")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension", Arrays.asList("addPkgRes", "checkApp", "installApp")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.resource.SnapshotBridgeExtension", Arrays.asList("saveSnapshot", "getSnapshotConfig", "deleteSnapshot")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.mtop.MtopBridgeExtention", Arrays.asList("sendMtop")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.GetClientInfoBridgeExtension", Arrays.asList("getClientInfo")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.engine.InputBridgeExtension", Arrays.asList("toggleSoftInput", "showSoftInput", "inputFocus4Android")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.engine.OrientationBridgeExtension", Arrays.asList("getScreenOrientation", "setScreenOrientation")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.engine.EngineBridgeExtension", Arrays.asList("checkJSAPI", "h5PageReload", "measureText")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.logging.AppPerformanceBridgeExtension", Arrays.asList("onAppPerfEvent", "onCubeAppPerfEvent", "monitorH5Performance")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.app.AppBridgeExtension", Arrays.asList("getSceneStackInfo"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.app.TitleBarBridgeExtension", Arrays.asList(d.p, "getTitleAndStatusbarHeight", "setTitleColor", "setBarBottomLineColor", "setTransparentTitle", "getTitleColor", RVParams.LONG_SHOW_TITLE_LOADING, "hideTitleLoading", RVParams.LONG_SHOW_OPTION_MENU, "hideOptionMenu", d.r, "hideBackButton"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.app.TabBarBridgeExtension", Arrays.asList("setTabBar", "switchTab", "removeTabBarItem", "addTabBarItem"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.internalapi.InternalApiBridgeExtension", Arrays.asList("internalAPI"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.resource.subpackage.SubPackageBridgeExtension", Arrays.asList("loadSubPackage"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.StartParamsBridgeExtension", Arrays.asList("getStartupParams", "setStartParam"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.actionsheet.ActionSheetBridgeExtension", Arrays.asList("actionSheet"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.NotificationBridgeExtension", Arrays.asList("addNotifyListener", "removeNotifyListener", "postNotification"), Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.rpc.RpcBridgeExtension", Arrays.asList("rpc"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.rpc.TinyAppxRpcBridgeExtension", Arrays.asList("appxrpc"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.rpc.TinyRpcBridgeExtension", Arrays.asList("tinyRpc"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.logging.HandleLoggingActionBridgeExtension", Arrays.asList("handleLoggingAction"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.app.WindowBridgeExtension", Arrays.asList("pushWindow", "popWindow", "popTo", "getRunScene"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.websocket.WebSocketBridgeExtension", Arrays.asList("connectSocket", "sendSocketMessage", "closeSocket"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.remotedebug.RemoteDebugBridgeExtension", Arrays.asList(com.alibaba.ariver.remotedebug.b.c.b, "tyroRequest"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.remotedebug.RemoteDebugViewBridgeExtension", Arrays.asList("showRemoteDebugMask", "showRemoteDebugPanel"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.security.PermissionConfigExtension", Arrays.asList("getPermissionConfig")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.tracedebug.jsapi.TraceDebugBridgeExtension", Arrays.asList("initialTraceDebug", "postMethodTrace"), App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.tools.extension.RVToolsResourceExtension", Arrays.asList("rvToolsFetchResource"), App.class));
        if (isInStandardCashierSDK()) {
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.pay.StdTradePayBridgeExtension", Arrays.asList("tradePay"), App.class));
        } else {
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.pay.ProTradePayBridgeExtension", Arrays.asList("tradePay"), App.class));
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.resource.runtime.ResourceLoadExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.app.AppStartPoint", "com.alibaba.ariver.app.api.point.app.AppCreatePoint", "com.alibaba.ariver.app.api.point.app.AppLoadPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint", "com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint", "com.alibaba.ariver.engine.api.resources.ResourceLoadPoint", "com.alibaba.ariver.app.api.point.view.TabBarInfoQueryPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.resource.api.snapshot.SnapshotSaveExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.page.PagePausePoint", "com.alibaba.ariver.app.api.point.app.PushWindowPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.app.extensions.AppRestartExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.app.AppRestartPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.logging.PerformancePubExtension", Arrays.asList("com.alibaba.ariver.app.api.monitor.RVPub")));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.permission.extension.AppPermissionInitExtension", (List<String>) Arrays.asList("com.alibaba.ariver.resource.api.extension.PackageParsedPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.permission.extension.EventSendInterceptorExtension", (List<String>) Arrays.asList("com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.integration.proxy.impl.CommonAppExitExtension", Arrays.asList("com.alibaba.ariver.app.api.point.app.AppExitPoint")));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.tools.extension.RVToolsActivityHelperOnCreateFinishedExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.tools.extension.RVToolsEngineInitSuccessExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.remotedebug.worker.CreateRemoteWorkerExtension", (List<String>) Arrays.asList("com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.tracedebug.extension.TraceDebugEngineExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.app.AppLoadPoint", "com.alibaba.ariver.app.api.point.page.PageExitPoint", "com.alibaba.ariver.app.api.point.page.PageEnterPoint", "com.alibaba.ariver.app.api.point.app.AppExitPoint", "com.alibaba.ariver.engine.api.point.NativeCallResultPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.tools.extension.RVToolsResourceInterceptExtension", (List<String>) Arrays.asList("com.alibaba.ariver.resource.api.extension.ResourceInterceptPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.jsapi.font.FontSizeSettingExtension", (List<String>) Arrays.asList("com.alibaba.ariver.app.api.point.app.AppStartPoint", "com.alibaba.ariver.app.api.point.app.AppDestroyPoint"), (Class<? extends Scope>) App.class));
        arrayList.add(new ExtensionMetaInfo(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.ariver.console.DebugConsoleExtension", (List<String>) Arrays.asList("com.alibaba.ariver.console.DebugConsolePoint"), (Class<? extends Scope>) App.class));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(RVPerformanceTracker.class, new RVProxy.LazyGetter<RVPerformanceTracker>() { // from class: com.alibaba.ariver.integration.BaseManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVPerformanceTracker get() {
                return new RVPerformanceTrackerImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(RVNativePermissionRequestProxy.class, new RVProxy.LazyGetter<RVNativePermissionRequestProxy>() { // from class: com.alibaba.ariver.integration.BaseManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVNativePermissionRequestProxy get() {
                return new RVNativePermissionRequestManager();
            }
        }));
        try {
            arrayList.add(new RVManifest.LazyProxyManifest(RVWebSocketProxy.class, new RVProxy.LazyGetter<RVWebSocketProxy>() { // from class: com.alibaba.ariver.integration.BaseManifest.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public RVWebSocketProxy get() {
                    return new DefaultWebSocketProxyImpl();
                }
            }));
        } catch (Throwable th) {
            RVLogger.e(Log.getStackTraceString(th));
        }
        arrayList.add(new RVManifest.LazyProxyManifest(RVJsStatTrackService.class, new RVProxy.LazyGetter<RVJsStatTrackService>() { // from class: com.alibaba.ariver.integration.BaseManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVJsStatTrackService get() {
                return new JsApiStatTrackServiceImpl();
            }
        }));
        arrayList.add(new RVManifest.ProxyManifest(RVNativePermissionRequestProxy.class, new RVNativePermissionRequestManager()));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    @Nullable
    public synchronized RemoteController getRemoteController() {
        if (this.mRemoteController == null) {
            this.mRemoteController = new DefaultRemoteController();
        }
        return this.mRemoteController;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(final ExtensionManager extensionManager) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.ServiceBeanManifest(IRemoteCaller.class, new RVProxy.LazyGetter<IRemoteCaller>() { // from class: com.alibaba.ariver.integration.BaseManifest.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IRemoteCaller get() {
                return new ServerSideRemoteExtensionCaller(extensionManager);
            }
        }));
        return arrayList;
    }
}
