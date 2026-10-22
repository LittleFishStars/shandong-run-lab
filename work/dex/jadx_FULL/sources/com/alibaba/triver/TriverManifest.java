package com.alibaba.triver;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageCreateRenderPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.ServerMsgReceiver;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.console.RVDebugConsoleProxy;
import com.alibaba.ariver.console.jsapi.DebugPanelBridgeExtension;
import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.integration.BaseManifest;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.remote.internal.DefaultRemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.rpc.RVRpcProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.legacy.v8worker.V8Proxy;
import com.alibaba.ariver.legacy.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.legacy.v8worker.extension.V8JSErrorPoint;
import com.alibaba.ariver.legacy.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.ariver.mtop.monitor.RVCountDispatcher;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy;
import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;
import com.alibaba.ariver.remoterpc.DefaultRpcCallServerImpl;
import com.alibaba.ariver.remoterpc.IRpcCaller;
import com.alibaba.ariver.remoterpc.serivce.RVRpcEnviromentService;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.extension.AppModelInitPoint;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.ariver.rpc.RpcServiceHolder;
import com.alibaba.ariver.v8worker.extension.V8WorkerJSErrorTracker;
import com.alibaba.triver.app.TriverLoadingController;
import com.alibaba.triver.appinfo.TriverAppInfoManager;
import com.alibaba.triver.appinfo.TriverAppInfoRequestEngine;
import com.alibaba.triver.appinfo.core.AppInfoClient;
import com.alibaba.triver.appinfo.storage.TriverDBProxy;
import com.alibaba.triver.audio.AudioRecorderBridgeExtension;
import com.alibaba.triver.audio.BackGroundAudioBridgeExtension;
import com.alibaba.triver.audio.ForeGroundAudioBridgeExtension;
import com.alibaba.triver.basic.api.AriverPerfromanceLogBridgeExtension;
import com.alibaba.triver.basic.api.LocationBridgeExtension;
import com.alibaba.triver.basic.api.MemoryWarningBridgeExtension;
import com.alibaba.triver.basic.api.OriginRouteUrlBridgeExtension;
import com.alibaba.triver.basic.api.PopPlayerBridgeExtension;
import com.alibaba.triver.basic.api.ServerTimeBridgeExtension;
import com.alibaba.triver.basic.api.TRFileBridgeExtension;
import com.alibaba.triver.basic.api.TriverSystemInfoBridgeExtension;
import com.alibaba.triver.basic.canvas.CanvasBridgeExtension;
import com.alibaba.triver.basic.city.ChooseCityBridgeExtension;
import com.alibaba.triver.basic.keyboard.KeyboardBridgeExtension;
import com.alibaba.triver.basic.phone.PhoneBridgeExtension;
import com.alibaba.triver.basic.picker.PickerBridgeExtension;
import com.alibaba.triver.basic.remotelog.RemoteLogBridgeExtension;
import com.alibaba.triver.basic.storage.PluginStorageBridgeExtension;
import com.alibaba.triver.basic.storage.StorageBridgeExtension;
import com.alibaba.triver.bridge.BizBridge;
import com.alibaba.triver.bridge.MiniProgramBridge;
import com.alibaba.triver.bridge.PluginBridgeExtension;
import com.alibaba.triver.bridge.TitleBarBridge;
import com.alibaba.triver.bridge.TriverPullRefreshBridgeExtension;
import com.alibaba.triver.extensions.AppLifecycleExtension;
import com.alibaba.triver.extensions.AppxLoadExtension;
import com.alibaba.triver.extensions.AuthDialogExtention;
import com.alibaba.triver.extensions.BridgeAccessExtension;
import com.alibaba.triver.extensions.IgnorePermissionPointImpl;
import com.alibaba.triver.extensions.OnGetAppInfoExtension;
import com.alibaba.triver.extensions.PageBackExtension;
import com.alibaba.triver.extensions.TinyAppInnerProxyImpl;
import com.alibaba.triver.extensions.TitleBarExtension;
import com.alibaba.triver.extensions.TriverOnLoadResultExtension;
import com.alibaba.triver.flutter.canvas.GameInfoReportExtension;
import com.alibaba.triver.flutter.canvas.recording.GameRecorderBridgeExtension;
import com.alibaba.triver.impl.InitializerPrinter;
import com.alibaba.triver.impl.TriverEngineFactory;
import com.alibaba.triver.impl.TriverExecutorService;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.impl.TriverPageFactoryImpl;
import com.alibaba.triver.impl.TriverSnapshotProxyImpl;
import com.alibaba.triver.impl.TriverViewFactory;
import com.alibaba.triver.inside.impl.AccountSerivceImpl;
import com.alibaba.triver.inside.impl.DefDBProxy;
import com.alibaba.triver.inside.impl.EnvProxyImpl;
import com.alibaba.triver.inside.impl.InsideConfigProxy;
import com.alibaba.triver.inside.impl.MtopExtensionImpl;
import com.alibaba.triver.inside.impl.MtopProxyImpl;
import com.alibaba.triver.inside.impl.RVMonitorProxyImpl;
import com.alibaba.triver.inside.impl.RpcProxyImpl;
import com.alibaba.triver.inside.impl.SecurityStoreImpl;
import com.alibaba.triver.inside.impl.TBStorageProxyImpl;
import com.alibaba.triver.inside.impl.TransportService;
import com.alibaba.triver.inside.impl.TriverAppMonitorProxyImpl;
import com.alibaba.triver.inside.impl.TriverAuthenticationProxyImp;
import com.alibaba.triver.inside.impl.TriverCountDispatcher;
import com.alibaba.triver.inside.impl.TriverDebugConsoleProxyImpl;
import com.alibaba.triver.inside.impl.TriverEnvProxy;
import com.alibaba.triver.inside.impl.TriverEventTrackerProxy;
import com.alibaba.triver.inside.impl.TriverMonitorProxyImpl;
import com.alibaba.triver.inside.impl.TriverRemoteDebugProxyImpl;
import com.alibaba.triver.inside.impl.TriverResourceEnvProxy;
import com.alibaba.triver.inside.impl.TriverSecurityProxy;
import com.alibaba.triver.inside.impl.UserTrackProxyImpl;
import com.alibaba.triver.inside.impl.commonability.TRCommonAbilityProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;
import com.alibaba.triver.kit.api.proxy.ISecurityProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.proxy.IUserTrackProxy;
import com.alibaba.triver.monitor.TriverPerformanceAndErrorTracker;
import com.alibaba.triver.permission.AccountProxyImpl;
import com.alibaba.triver.permission.WVPermissionProxyImpl;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.preload.TriverOnPreloadExtension;
import com.alibaba.triver.resource.BasicPluginResourceDelegateImpl;
import com.alibaba.triver.resource.BasicPluginResourceManager;
import com.alibaba.triver.resource.BasicResourceManager;
import com.alibaba.triver.resource.PackageQueryExtension;
import com.alibaba.triver.resource.TriverResourcePreseter;
import com.alibaba.triver.support.ui.PageCreateExtension;
import com.alibaba.triver.support.ui.auth.settings.AuthorizeSettingBridge;
import com.alibaba.triver.triver_render.extension.RenderInitPoint;
import com.alibaba.triver.triver_worker.v8worker.GetShopPluginResourcePoint;
import com.alibaba.triver.triver_worker.v8worker.TriverV8ImportScriptErrorPoint;
import com.alibaba.triver.triver_worker.v8worker.TriverV8JSErrorPoint;
import com.alibaba.triver.triver_worker.v8worker.TriverV8Proxy;
import com.alibaba.triver.triver_worker.v8worker.TriverV8SendMsgErrorPoint;
import com.alibaba.triver.triver_worker.v8worker.jsi.TriverJSIProxy;
import com.alibaba.triver.triver_worker.v8worker.jsi.extensionImpl.JSErrorTracker;
import com.alibaba.triver.triver_worker.v8worker.jsi.extensionImpl.TRVJSIWorkerErrorPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class TriverManifest extends BaseManifest implements Serializable {
    private static final String[] sManifestCls = {"com.alibaba.triver.alibaba.AlibabaManifest", "com.alibaba.triver.ebiz.EbizManifest", "com.alibaba.triver.kit.alibaba.AlibabaManifest", "com.alibaba.triver.kit.zcache.ZcacheManifest", "com.alibaba.triver.triver_weex.WeexManifest", "com.alibaba.triver.triver_shop.TBShopManifest", "com.alibaba.triver.tools.ToolsManifest"};
    private List<RVManifest> mManifests;
    private RemoteController mRemoteController = null;

    private List<RVManifest> getManifest() {
        if (this.mManifests == null) {
            this.mManifests = new ArrayList();
            for (String str : sManifestCls) {
                try {
                    this.mManifests.add((RVManifest) Class.forName(str).newInstance());
                    RVLogger.d("generate enhance ability" + str);
                } catch (Throwable th) {
                    RVLogger.e("generate enhance ability fail", th);
                }
            }
        }
        return this.mManifests;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    @Nullable
    public synchronized AccessController getAccessController() {
        return super.getAccessController();
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.getBridgeExtensions());
        arrayList.add(RVManifest.BridgeExtensionManifest.make(LocationBridgeExtension.class, App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(CanvasBridgeExtension.class, App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(ChooseCityBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(StorageBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(TRFileBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(OriginRouteUrlBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(MemoryWarningBridgeExtension.class, App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(PluginBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(PluginStorageBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(AriverPerfromanceLogBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(TriverSystemInfoBridgeExtension.class));
        try {
            arrayList.add(RVManifest.BridgeExtensionManifest.make(DebugPanelBridgeExtension.class, App.class));
        } catch (Throwable unused) {
        }
        arrayList.add(RVManifest.BridgeExtensionManifest.make(PopPlayerBridgeExtension.class));
        RVManifest.BridgeExtensionManifest bridgeExtensionManifestMake = RVManifest.BridgeExtensionManifest.make(BizBridge.class);
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("setActionSheet", "setActionSheet", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("getDeviceId", "getDeviceId", "tb", BridgeDSL.INVOKE));
        arrayList.add(bridgeExtensionManifestMake);
        RVManifest.BridgeExtensionManifest bridgeExtensionManifestMake2 = RVManifest.BridgeExtensionManifest.make(TitleBarBridge.class);
        bridgeExtensionManifestMake2.addBridgeExtensionDSL(new BridgeDSL("addMenu", "addMenu", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake2.addBridgeExtensionDSL(new BridgeDSL("showGlobalMenu", "showGlobalMenu", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake2.addBridgeExtensionDSL(new BridgeDSL("hideGlobalMenu", "hideGlobalMenu", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake2.addBridgeExtensionDSL(new BridgeDSL("changeFavorStatus", "changeFavorStatus", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake2.addBridgeExtensionDSL(new BridgeDSL("registerFavorEvent", "registerFavorEvent", "tb", BridgeDSL.INVOKE));
        arrayList.add(bridgeExtensionManifestMake2);
        RVManifest.BridgeExtensionManifest bridgeExtensionManifestMakeRaw = RVManifest.BridgeExtensionManifest.makeRaw(RVConstants.ARIVER_BUNDLE_NAME, "com.alibaba.triver.kit.bridge.PriTitleBarBridge", Arrays.asList("showMenuTip"));
        bridgeExtensionManifestMakeRaw.addBridgeExtensionDSL(new BridgeDSL("showMenuTip", "showMenuTip", "tb", BridgeDSL.INVOKE));
        arrayList.add(bridgeExtensionManifestMakeRaw);
        try {
            arrayList.add(RVManifest.BridgeExtensionManifest.make(Class.forName("com.taobao.cameralink.miniapp.arcamera.api.ARBridgeExtension"), Page.class));
        } catch (Throwable unused2) {
            RVLogger.e("Can't get ar bridge extension");
        }
        arrayList.add(RVManifest.BridgeExtensionManifest.make(ServerTimeBridgeExtension.class));
        RVManifest.BridgeExtensionManifest bridgeExtensionManifestMake3 = RVManifest.BridgeExtensionManifest.make(MiniProgramBridge.class);
        bridgeExtensionManifestMake3.addBridgeExtensionDSL(new BridgeDSL("openBrandZone", "openBrandZone", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake3.addBridgeExtensionDSL(new BridgeDSL("preloadBrandZone", "preloadBrandZone", "tb", BridgeDSL.INVOKE));
        arrayList.add(bridgeExtensionManifestMake3);
        arrayList.add(RVManifest.BridgeExtensionManifest.make(KeyboardBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(TriverPullRefreshBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(BackGroundAudioBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(ForeGroundAudioBridgeExtension.class, Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(AudioRecorderBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(PickerBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(PhoneBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(RemoteLogBridgeExtension.class, Page.class));
        try {
            RVManifest.BridgeExtensionManifest bridgeExtensionManifestMake4 = RVManifest.BridgeExtensionManifest.make(GameRecorderBridgeExtension.class, App.class);
            bridgeExtensionManifestMake4.addBridgeExtensionDSL(new BridgeDSL("startGameRecorder", "startGameRecorder", "tb", BridgeDSL.INVOKE));
            bridgeExtensionManifestMake4.addBridgeExtensionDSL(new BridgeDSL("stopGameRecorder", "stopGameRecorder", "tb", BridgeDSL.INVOKE));
            bridgeExtensionManifestMake4.addBridgeExtensionDSL(new BridgeDSL("pauseGameRecorder", "pauseGameRecorder", "tb", BridgeDSL.INVOKE));
            bridgeExtensionManifestMake4.addBridgeExtensionDSL(new BridgeDSL("resumeGameRecorder", "resumeGameRecorder", "tb", BridgeDSL.INVOKE));
            bridgeExtensionManifestMake4.addBridgeExtensionDSL(new BridgeDSL("abortGameRecorder", "abortGameRecorder", "tb", BridgeDSL.INVOKE));
            bridgeExtensionManifestMake4.addBridgeExtensionDSL(new BridgeDSL("isGameFrameRecordSupported", "isGameFrameRecordSupported", "tb", BridgeDSL.INVOKE));
            arrayList.add(bridgeExtensionManifestMake4);
        } catch (Throwable th) {
            RVLogger.e("register GameRecorderBridgeExtension failed: " + th.getMessage());
        }
        try {
            arrayList.add(RVManifest.BridgeExtensionManifest.make(GameInfoReportExtension.class, App.class));
        } catch (Throwable th2) {
            RVLogger.e("register GameInfoReportExtension failed: " + th2.getMessage());
        }
        arrayList.add(RVManifest.BridgeExtensionManifest.make(AuthorizeSettingBridge.class));
        Iterator<RVManifest> it = getManifest().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getBridgeExtensions());
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        List<ExtensionMetaInfo> extensions = super.getExtensions();
        extensions.add(new ExtensionMetaInfo("ariver", PackageQueryExtension.class.getName(), Collections.singletonList(PackageQueryPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", TitleBarExtension.class.getName(), Arrays.asList(PageShowPoint.class.getName(), PageHidePoint.class.getName(), PageResumePoint.class.getName(), PagePausePoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", IgnorePermissionPointImpl.class.getName(), Arrays.asList(IgnorePermissionPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", BridgeAccessExtension.class.getName(), (List<String>) Collections.singletonList(BridgeAccessPoint.class.getName()), (Class<? extends Scope>) App.class));
        extensions.add(new ExtensionMetaInfo("ariver", AppLifecycleExtension.class.getName(), (List<String>) Arrays.asList(PageInitPoint.class.getName(), PageEnterPoint.class.getName(), PageExitPoint.class.getName(), PageShowPoint.class.getName(), PageHidePoint.class.getName(), PageResumePoint.class.getName(), PagePausePoint.class.getName(), PageBackPoint.class.getName(), PageDestroyPoint.class.getName(), BackPressedPoint.class.getName(), AppStartPoint.class.getName(), AppLoadPoint.class.getName(), AppRestartPoint.class.getName(), AppResumePoint.class.getName(), AppPausePoint.class.getName(), AppDestroyPoint.class.getName(), AppExitPoint.class.getName(), EngineInitFailedPoint.class.getName(), PushWindowPoint.class.getName()), (Class<? extends Scope>) App.class));
        extensions.add(new ExtensionMetaInfo("ariver", MiniProgramBridge.RestartAppExtension.class.getName(), Collections.singletonList(MiniProgramBridge.RestartAppPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", TriverLoadingController.DowngradeExtension.class.getName(), Collections.singletonList(TriverLoadingController.DowngradePoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", TriverOnLoadResultExtension.class.getName(), Collections.singletonList(AppOnLoadResultPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.wasm.WasmInitPoint", Arrays.asList(AppOnLoadResultPoint.class.getName(), AppDestroyPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", TriverOnPreloadExtension.class.getName(), Collections.singletonList(OnPreloadPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", TriverV8ImportScriptErrorPoint.class.getName(), (List<String>) Collections.singletonList(V8ImportScriptErrorPoint.class.getName()), (Class<? extends Scope>) App.class));
        extensions.add(new ExtensionMetaInfo("ariver", TriverV8JSErrorPoint.class.getName(), (List<String>) Collections.singletonList(V8JSErrorPoint.class.getName()), (Class<? extends Scope>) App.class));
        extensions.add(new ExtensionMetaInfo("ariver", TriverV8SendMsgErrorPoint.class.getName(), (List<String>) Collections.singletonList(V8SendMessageErrorPoint.class.getName()), (Class<? extends Scope>) App.class));
        extensions.add(new ExtensionMetaInfo("ariver", TRVJSIWorkerErrorPoint.class.getName(), (List<String>) Collections.singletonList(com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint.class.getName()), (Class<? extends Scope>) App.class));
        extensions.add(new ExtensionMetaInfo("ariver", TRVJSIWorkerErrorPoint.class.getName(), (List<String>) Collections.singletonList(com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint.class.getName()), (Class<? extends Scope>) App.class));
        for (RVManifest rVManifest : getManifest()) {
            if (rVManifest != null) {
                extensions.addAll(rVManifest.getExtensions());
            }
        }
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.embed.webview.WebViewInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.embed.aicamera.AICameraInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.embed.video.VideoInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.tblive.TBLiveInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.bundle.initpoint.TBUnityInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.acetiny.miniapp.AceTinyExtension", Collections.singletonList(PageExitPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.map.MapInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.embed.camera.CameraInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.triver_render.view.input.InputInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.triver_shop.weexview.EmbedWeexView", Arrays.asList(AppStartPoint.class.getName(), AppDestroyPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.triver_shop.tvideo.EmbedTVideo", Arrays.asList(AppStartPoint.class.getName(), AppDestroyPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.triver_shop.cache.OfficialPluginCache", Collections.singletonList(RenderInitPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.triver_shop.extension.ShopPluginResourcePoint", Collections.singletonList(GetShopPluginResourcePoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.audio.BackGroundAudioBridgeExtension", Arrays.asList(AppDestroyPoint.class.getName(), AppPausePoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.triver.extensions.TriverBackKeyDownExtension", Collections.singletonList(BackKeyDownPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", AppxLoadExtension.class.getName(), Collections.singletonList(AppLoadInterceptorPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", PageBackExtension.class.getName(), Arrays.asList(PageBackPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", PageCreateExtension.class.getName(), Collections.singletonList(PageCreateRenderPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("triver", OnGetAppInfoExtension.class.getName(), Collections.singletonList(AppModelInitPoint.class.getName())));
        return extensions;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        if (((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext() == null) {
            RVProxy.set(RVEnvironmentService.class, new TriverEnvProxy());
        }
        RVInitializer.setPrinter(new InitializerPrinter());
        RVProxy.set(IPerformanceAndErrorTracker.class, new TriverPerformanceAndErrorTracker());
        RVProxy.set(V8WorkerJSErrorTracker.class, new JSErrorTracker());
        RVProxy.set(RVMonitor.class, new RVMonitorProxyImpl());
        ServerMsgReceiver.getInstance().registerBizHandler(IpcMessageConstants.BIZ_APP, new com.alibaba.triver.ipc.a.b());
        ClientMsgReceiver.getInstance().registerBizHandler(com.alibaba.triver.ipc.b.f25006a, new com.alibaba.triver.ipc.a.a());
        AppUpdaterFactory.registerRule(new AppUpdaterFactory.Rule() { // from class: com.alibaba.triver.TriverManifest.1
            @Override // com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory.Rule
            public IAppUpdater findUpdater(String str, @Nullable Bundle bundle) {
                return new com.alibaba.triver.appinfo.a();
            }
        });
        List<RVManifest.IProxyManifest> proxies = super.getProxies();
        if (proxies == null) {
            proxies = new ArrayList<>();
        }
        proxies.add(new RVManifest.ProxyManifest(RVLogger.Proxy.class, new TriverLogProxyImpl()));
        proxies.add(new RVManifest.LazyProxyManifest(RVExecutorService.class, new RVProxy.LazyGetter<RVExecutorService>() { // from class: com.alibaba.triver.TriverManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVExecutorService get() {
                return new TriverExecutorService();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(EngineFactory.class, new RVProxy.LazyGetter<EngineFactory>() { // from class: com.alibaba.triver.TriverManifest.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public EngineFactory get() {
                return new TriverEngineFactory();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVClientStarter.class, new RVProxy.LazyGetter<RVClientStarter>() { // from class: com.alibaba.triver.TriverManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVClientStarter get() {
                return new TriverStartClientProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVViewFactory.class, new RVProxy.LazyGetter<RVViewFactory>() { // from class: com.alibaba.triver.TriverManifest.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVViewFactory get() {
                return new TriverViewFactory();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVCommonAbilityProxy.class, new RVProxy.LazyGetter<RVCommonAbilityProxy>() { // from class: com.alibaba.triver.TriverManifest.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVCommonAbilityProxy get() {
                return new TRCommonAbilityProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(TriverDBProxy.class, new RVProxy.LazyGetter<TriverDBProxy>() { // from class: com.alibaba.triver.TriverManifest.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public TriverDBProxy get() {
                return new DefDBProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVAppInfoManager.class, new RVProxy.LazyGetter<RVAppInfoManager>() { // from class: com.alibaba.triver.TriverManifest.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVAppInfoManager get() {
                return new TriverAppInfoManager();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVResourceManager.class, new RVProxy.LazyGetter<RVResourceManager>() { // from class: com.alibaba.triver.TriverManifest.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVResourceManager get() {
                return new BasicResourceManager();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVPluginResourceManager.class, new RVProxy.LazyGetter<RVPluginResourceManager>() { // from class: com.alibaba.triver.TriverManifest.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVPluginResourceManager get() {
                return new BasicPluginResourceManager(new BasicPluginResourceDelegateImpl());
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(AppInfoClient.class, new RVProxy.LazyGetter<AppInfoClient>() { // from class: com.alibaba.triver.TriverManifest.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public AppInfoClient get() {
                return new TriverAppInfoRequestEngine();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(INetworkProxy.class, new RVProxy.LazyGetter<INetworkProxy>() { // from class: com.alibaba.triver.TriverManifest.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public INetworkProxy get() {
                return new MtopProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IConfigProxy.class, new RVProxy.LazyGetter<IConfigProxy>() { // from class: com.alibaba.triver.TriverManifest.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IConfigProxy get() {
                return new InsideConfigProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IUserTrackProxy.class, new RVProxy.LazyGetter<IUserTrackProxy>() { // from class: com.alibaba.triver.TriverManifest.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IUserTrackProxy get() {
                return new UserTrackProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(ITriverMonitorProxy.class, new RVProxy.LazyGetter<ITriverMonitorProxy>() { // from class: com.alibaba.triver.TriverManifest.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public ITriverMonitorProxy get() {
                return new TriverMonitorProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVCountDispatcher.class, new RVProxy.LazyGetter<RVCountDispatcher>() { // from class: com.alibaba.triver.TriverManifest.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVCountDispatcher get() {
                return new TriverCountDispatcher();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IEnvProxy.class, new RVProxy.LazyGetter<IEnvProxy>() { // from class: com.alibaba.triver.TriverManifest.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IEnvProxy get() {
                return new EnvProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVRpcProxy.class, new RVProxy.LazyGetter<RVRpcProxy>() { // from class: com.alibaba.triver.TriverManifest.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVRpcProxy get() {
                return new RpcProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(AuthenticationProxy.class, new RVProxy.LazyGetter<AuthenticationProxy>() { // from class: com.alibaba.triver.TriverManifest.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public AuthenticationProxy get() {
                return new TriverAuthenticationProxyImp();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(EmbedWebViewJsApiPermissionProxy.class, new RVProxy.LazyGetter<EmbedWebViewJsApiPermissionProxy>() { // from class: com.alibaba.triver.TriverManifest.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public EmbedWebViewJsApiPermissionProxy get() {
                return new WVPermissionProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(TinyAppInnerProxy.class, new RVProxy.LazyGetter<TinyAppInnerProxy>() { // from class: com.alibaba.triver.TriverManifest.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public TinyAppInnerProxy get() {
                return new TinyAppInnerProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVAccountService.class, new RVProxy.LazyGetter<RVAccountService>() { // from class: com.alibaba.triver.TriverManifest.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVAccountService get() {
                return "true".equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_ACCOUNT_DOWNGRADE, "")) ? new AccountProxyImpl() : new AccountSerivceImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(KVStorageProxy.class, new RVProxy.LazyGetter<KVStorageProxy>() { // from class: com.alibaba.triver.TriverManifest.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public KVStorageProxy get() {
                return "true".equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_STORAGE_DOWNGRADE, "")) ? new SecurityStoreImpl() : new TBStorageProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVResourcePresetProxy.class, new RVProxy.LazyGetter<RVResourcePresetProxy>() { // from class: com.alibaba.triver.TriverManifest.24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVResourcePresetProxy get() {
                return new TriverResourcePreseter();
            }
        }));
        try {
            proxies.add(new RVManifest.LazyProxyManifest(RVRpcEnviromentService.class, new RVProxy.LazyGetter<RVRpcEnviromentService>() { // from class: com.alibaba.triver.TriverManifest.25
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public RVRpcEnviromentService get() {
                    return new com.alibaba.triver.inside.impl.b();
                }
            }));
        } catch (Throwable unused) {
        }
        proxies.add(new RVManifest.LazyProxyManifest(ITriverAppMonitorProxy.class, new RVProxy.LazyGetter<ITriverAppMonitorProxy>() { // from class: com.alibaba.triver.TriverManifest.26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public ITriverAppMonitorProxy get() {
                return new TriverAppMonitorProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVResourceEnviromentProxy.class, new RVProxy.LazyGetter<RVResourceEnviromentProxy>() { // from class: com.alibaba.triver.TriverManifest.27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVResourceEnviromentProxy get() {
                return new TriverResourceEnvProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVTransportService.class, new RVProxy.LazyGetter<RVTransportService>() { // from class: com.alibaba.triver.TriverManifest.28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVTransportService get() {
                return new TransportService();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(V8Proxy.class, new RVProxy.LazyGetter<V8Proxy>() { // from class: com.alibaba.triver.TriverManifest.29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public V8Proxy get() {
                return new TriverV8Proxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(com.alibaba.ariver.v8worker.V8Proxy.class, new RVProxy.LazyGetter<com.alibaba.ariver.v8worker.V8Proxy>() { // from class: com.alibaba.triver.TriverManifest.30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public com.alibaba.ariver.v8worker.V8Proxy get() {
                return new TriverJSIProxy();
            }
        }));
        try {
            proxies.add(new RVManifest.LazyProxyManifest(RVRemoteDebugProxy.class, new RVProxy.LazyGetter<RVRemoteDebugProxy>() { // from class: com.alibaba.triver.TriverManifest.31
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public RVRemoteDebugProxy get() {
                    return new TriverRemoteDebugProxyImpl();
                }
            }));
        } catch (Throwable unused2) {
        }
        proxies.add(new RVManifest.LazyProxyManifest(EventTracker.class, new RVProxy.LazyGetter<EventTracker>() { // from class: com.alibaba.triver.TriverManifest.32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public EventTracker get() {
                return new TriverEventTrackerProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(ISnapshotProxy.class, new RVProxy.LazyGetter<ISnapshotProxy>() { // from class: com.alibaba.triver.TriverManifest.33
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public ISnapshotProxy get() {
                return new TriverSnapshotProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVPageFactory.class, new RVProxy.LazyGetter<RVPageFactory>() { // from class: com.alibaba.triver.TriverManifest.34
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVPageFactory get() {
                return new TriverPageFactoryImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(ISecurityProxy.class, new RVProxy.LazyGetter<ISecurityProxy>() { // from class: com.alibaba.triver.TriverManifest.35
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public ISecurityProxy get() {
                return new TriverSecurityProxy();
            }
        }));
        try {
            proxies.add(new RVManifest.LazyProxyManifest(RVDebugConsoleProxy.class, new RVProxy.LazyGetter<RVDebugConsoleProxy>() { // from class: com.alibaba.triver.TriverManifest.36
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public RVDebugConsoleProxy get() {
                    return new TriverDebugConsoleProxyImpl();
                }
            }));
        } catch (Throwable unused3) {
        }
        proxies.add(new RVManifest.LazyProxyManifest(IMtopProxy.class, new RVProxy.LazyGetter<IMtopProxy>() { // from class: com.alibaba.triver.TriverManifest.37
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IMtopProxy get() {
                return new MtopExtensionImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(AuthDialogProxy.class, new RVProxy.LazyGetter<AuthDialogProxy>() { // from class: com.alibaba.triver.TriverManifest.38
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public AuthDialogProxy get() {
                return new AuthDialogExtention();
            }
        }));
        Iterator<RVManifest> it = getManifest().iterator();
        while (it.hasNext()) {
            proxies.addAll(it.next().getProxies());
        }
        return proxies;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    @Nullable
    public RemoteController getRemoteController() {
        if (this.mRemoteController == null) {
            this.mRemoteController = new DefaultRemoteController();
        }
        return this.mRemoteController;
    }

    @Override // com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        List<RVManifest.ServiceBeanManifest> serviceBeans = super.getServiceBeans(extensionManager);
        if (serviceBeans == null) {
            serviceBeans = new ArrayList<>();
        }
        try {
            serviceBeans.add(new RVManifest.ServiceBeanManifest(IRpcCaller.class, new RVProxy.LazyGetter<IRpcCaller>() { // from class: com.alibaba.triver.TriverManifest.39
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public IRpcCaller get() {
                    return new DefaultRpcCallServerImpl(RpcServiceHolder.get());
                }
            }));
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        return serviceBeans;
    }
}
