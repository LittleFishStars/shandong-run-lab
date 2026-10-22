package com.alibaba.alibctriver;

import androidx.annotation.Keep;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibctriver.api.AlibcTriverLiveProxy;
import com.alibaba.alibctriver.extensions.AlibcAccountServiceImpl;
import com.alibaba.alibctriver.extensions.AlibcAppLifecycleExtension;
import com.alibaba.alibctriver.extensions.AlibcAppLoadedExtension;
import com.alibaba.alibctriver.extensions.AlibcBridgeExtension;
import com.alibaba.alibctriver.extensions.AlibcMtopExtensionImpl;
import com.alibaba.alibctriver.extensions.AlibcMtopProxyImpl;
import com.alibaba.alibctriver.extensions.AlibcRenderPreloadExtension;
import com.alibaba.alibctriver.extensions.AlibcTriverMonitorExtension;
import com.alibaba.alibctriver.extensions.AlibcWorkerExtension;
import com.alibaba.alibctriver.extensions.BcLifeCycleExtension;
import com.alibaba.alibctriver.extensions.DynamicPluginResourcePoint;
import com.alibaba.alibctriver.live.AlibcTriverLiveModule;
import com.alibaba.alibctriver.proxy.AliBcTriverConfigProxy;
import com.alibaba.alibctriver.proxy.AliBcTriverEnvProxy;
import com.alibaba.alibctriver.proxy.AlibcMonitorProxy;
import com.alibaba.alibctriver.proxy.AlibcMtopParamProxy;
import com.alibaba.alibctriver.proxy.AlibcTRiverLaunch;
import com.alibaba.alibctriver.proxy.AlibcTriverLogger;
import com.alibaba.alibctriver.proxy.AlibcTriverOpenModeExtension;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.remote.internal.DefaultRemoteController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.monitor.TRVMonitor;
import com.alibaba.triver.extension.TriverMonitorPub;
import com.alibaba.triver.kit.api.point.FirstScreenLoadedPoint;
import com.alibaba.triver.kit.api.point.PushPagePoint;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.open.TriverManifest;
import com.alibaba.triver.open.proxy.IMonitorProxy;
import com.alibaba.triver.open.proxy.IMtopParamProxy;
import com.alibaba.triver.open.proxy.IRouterProxy;
import com.alibaba.triver.point.RenderPreloadPoint;
import com.alibaba.triver.point.TriverLifecyclePoint;
import com.alibaba.triver.point.TriverOpenModeProxy;
import com.alibaba.triver.point.WorkerPreloadPoint;
import com.alibaba.triver.preload.IDynamicPluginParam;
import com.alibaba.triver.triver_worker.v8worker.GetShopPluginResourcePoint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AlibcTriverManifest extends TriverManifest implements RVManifest {
    private RemoteController mRemoteController = null;

    private void appendDynamicProxy(List<RVManifest.IProxyManifest> list) {
        try {
            final Object objNewInstance = AlibcTriverLiveModule.class.newInstance();
            list.add(new RVManifest.LazyProxyManifest(AlibcTriverLiveProxy.class, new RVProxy.LazyGetter<AlibcTriverLiveProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.16
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public AlibcTriverLiveProxy get() {
                    return (AlibcTriverLiveProxy) objNewInstance;
                }
            }));
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.triver.open.TriverManifest, com.alibaba.triver.TriverManifest, com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        List<RVManifest.BridgeExtensionManifest> bridgeExtensions = super.getBridgeExtensions();
        RVManifest.BridgeExtensionManifest bridgeExtensionManifestMake = RVManifest.BridgeExtensionManifest.make(AlibcBridgeExtension.class);
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbIsLogin", "isLogin", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbLogin", "login", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbLogout", AlibcProtocolConstant.LOGOUT, "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbRebate", "rebate", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbJumpNative", "jumpNative", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbGetBizParam", "getAlibcBizParam", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("tbSetBizParam", "setBizParam", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("bcGetPageUrl", "getPageUrl", RVParams.BACKGROUND_COLOR, BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("bcGetClickId", "getClickId", RVParams.BACKGROUND_COLOR, BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("bcConvertUrl", "convertUrl", RVParams.BACKGROUND_COLOR, BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("bcNavigateToOutside", AlibcProtocolConstant.NAVIGATE_TO_OUTSIDE_TYPE, RVParams.BACKGROUND_COLOR, BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("getAlibcSuiteConfig", "getAlibcSuiteConfig", "tb", BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("bcNotify", "notify", RVParams.BACKGROUND_COLOR, BridgeDSL.INVOKE));
        bridgeExtensionManifestMake.addBridgeExtensionDSL(new BridgeDSL("getApplinkKey", "getApplinkKey", RVParams.BACKGROUND_COLOR, BridgeDSL.INVOKE));
        try {
            RVManifest.BridgeExtensionManifest bridgeExtensionManifestMakeRaw = RVManifest.BridgeExtensionManifest.makeRaw("ariver", "com.alibaba.triver.tblive.TLiveMiniBridgeExtension", Arrays.asList("showFloatingWindow", "isShowingFloatingWindow"));
            bridgeExtensionManifestMakeRaw.addBridgeExtensionDSL(new BridgeDSL("showFloatingWindow", "showFloatingWindow", "tb", BridgeDSL.INVOKE));
            bridgeExtensionManifestMakeRaw.addBridgeExtensionDSL(new BridgeDSL("isShowingFloatingWindow", "isShowingFloatingWindow", "tb", BridgeDSL.INVOKE));
            bridgeExtensions.add(bridgeExtensionManifestMakeRaw);
        } catch (Throwable th) {
            RVLogger.e("AriverManifest", "TLiveMiniBridgeExtension register error", th);
        }
        bridgeExtensions.add(bridgeExtensionManifestMake);
        return bridgeExtensions;
    }

    @Override // com.alibaba.triver.open.TriverManifest, com.alibaba.triver.TriverManifest, com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        List<ExtensionMetaInfo> extensions = super.getExtensions();
        extensions.add(new ExtensionMetaInfo("ariver", AlibcTRiver.PushPagePointImpl.class.getName(), Arrays.asList(PushPagePoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", AlibcTriverMonitorExtension.class.getName(), Arrays.asList(TriverMonitorPub.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", AlibcWorkerExtension.class.getName(), Arrays.asList(WorkerPreloadPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", AlibcAppLoadedExtension.class.getName(), Arrays.asList(FirstScreenLoadedPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", AlibcAppLifecycleExtension.class.getName(), Arrays.asList(AppDestroyPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", AlibcRenderPreloadExtension.class.getName(), Arrays.asList(RenderPreloadPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", DynamicPluginResourcePoint.class.getName(), Arrays.asList(GetShopPluginResourcePoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", "com.alibaba.alibctriver.live.TBLiveInitPoint", Collections.singletonList(AppStartPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", BcLifeCycleExtension.class.getName(), Collections.singletonList(TriverLifecyclePoint.class.getName())));
        return extensions;
    }

    @Override // com.alibaba.triver.open.TriverManifest, com.alibaba.triver.TriverManifest, com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        RVProxy.set(RVLogger.Proxy.class, new AlibcTriverLogger());
        List<RVManifest.IProxyManifest> proxies = super.getProxies();
        proxies.add(new RVManifest.LazyProxyManifest(IRouterProxy.class, new RVProxy.LazyGetter<IRouterProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IRouterProxy get() {
                return new AlibcTRiverLaunch();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IMonitorProxy.class, new RVProxy.LazyGetter<IMonitorProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IMonitorProxy get() {
                return new AlibcMonitorProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IMtopParamProxy.class, new RVProxy.LazyGetter<IMtopParamProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IMtopParamProxy get() {
                return new AlibcMtopParamProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IDynamicPluginParam.class, new RVProxy.LazyGetter<IDynamicPluginParam>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IDynamicPluginParam get() {
                return new AlibcDynamicPluginProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(com.alibaba.triver.kit.api.proxy.IRouterProxy.class, new RVProxy.LazyGetter<com.alibaba.triver.kit.api.proxy.IRouterProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public com.alibaba.triver.kit.api.proxy.IRouterProxy get() {
                return new AlibcTRiverLaunch();
            }
        }));
        proxies.add(new RVManifest.ProxyManifest(RVLogger.Proxy.class, new AlibcTriverLogger()));
        proxies.add(new RVManifest.LazyProxyManifest(IEnvProxy.class, new RVProxy.LazyGetter<IEnvProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IEnvProxy get() {
                return new AliBcTriverEnvProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(ITriverAppMonitorProxy.class, new RVProxy.LazyGetter<ITriverAppMonitorProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public ITriverAppMonitorProxy get() {
                return new AlibcMonitorProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(TRVMonitor.class, new RVProxy.LazyGetter<TRVMonitor>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public TRVMonitor get() {
                return new AlibcMonitorProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(TriverOpenModeProxy.class, new RVProxy.LazyGetter<TriverOpenModeProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public TriverOpenModeProxy get() {
                return new AlibcTriverOpenModeExtension();
            }
        }));
        List<IImageProxy> imageList = AlibcImageCenter.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            proxies.add(new RVManifest.LazyProxyManifest(IImageProxy.class, new RVProxy.LazyGetter<IImageProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                public IImageProxy get() {
                    return new AlibcImageProxy();
                }
            }));
        } else {
            for (final IImageProxy iImageProxy : imageList) {
                proxies.add(new RVManifest.LazyProxyManifest(IImageProxy.class, new RVProxy.LazyGetter<IImageProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.10
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
                    public IImageProxy get() {
                        return iImageProxy;
                    }
                }));
            }
        }
        proxies.add(new RVManifest.LazyProxyManifest(IConfigProxy.class, new RVProxy.LazyGetter<IConfigProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IConfigProxy get() {
                return new AliBcTriverConfigProxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IMtopProxy.class, new RVProxy.LazyGetter<IMtopProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IMtopProxy get() {
                return new AlibcMtopExtensionImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVAccountService.class, new RVProxy.LazyGetter<RVAccountService>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVAccountService get() {
                return new AlibcAccountServiceImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(INetworkProxy.class, new RVProxy.LazyGetter<INetworkProxy>() { // from class: com.alibaba.alibctriver.AlibcTriverManifest.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public INetworkProxy get() {
                return new AlibcMtopProxyImpl();
            }
        }));
        appendDynamicProxy(proxies);
        return proxies;
    }

    public RemoteController getmRemoteController() {
        if (this.mRemoteController == null) {
            DefaultRemoteController defaultRemoteController = new DefaultRemoteController();
            this.mRemoteController = defaultRemoteController;
            defaultRemoteController.setRemoteControlManagement(new a());
        }
        return this.mRemoteController;
    }
}
