package com.alibaba.triver.open;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.extensions.CustomServerMsgExtension;
import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.point.WorkerExceptionPoint;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.legacy.v8worker.V8Proxy;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.triver.extensions.CustomServerMessageImpl;
import com.alibaba.triver.image.TRImageBridgeExtension;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IAppLoadProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.proxy.IUserInfoExtension;
import com.alibaba.triver.open.api.AliNetworkBridgeExtension;
import com.alibaba.triver.open.api.OpenBridgeExtension;
import com.alibaba.triver.open.api.SnapshotBridgeExtension;
import com.alibaba.triver.open.impl.AppLoadProxyImpl;
import com.alibaba.triver.open.impl.EnvProxyImpl;
import com.alibaba.triver.open.impl.MonitorProxyImpl;
import com.alibaba.triver.open.impl.OfficialAppImpl;
import com.alibaba.triver.open.impl.OpenTriverEngineFactory;
import com.alibaba.triver.open.impl.OpenTriverMonitorProxyImpl;
import com.alibaba.triver.open.impl.PageLoadProxyImpl;
import com.alibaba.triver.open.impl.PerformanceAndErrorSender;
import com.alibaba.triver.open.impl.ResourceManager;
import com.alibaba.triver.open.impl.ResourceProviderImpl;
import com.alibaba.triver.open.impl.TriverRVConfigService;
import com.alibaba.triver.open.impl.UserInfoExtensionImpl;
import com.alibaba.triver.open.impl.WorkerExceptionImpl;
import com.alibaba.triver.open.preload.DataPreloadExtension;
import com.alibaba.triver.point.DataPreloadPoint;
import com.alibaba.triver.triver_worker.v8worker.TriverV8Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class TriverManifest extends com.alibaba.triver.TriverManifest {
    @Override // com.alibaba.triver.TriverManifest, com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.getBridgeExtensions());
        arrayList.add(RVManifest.BridgeExtensionManifest.make(OpenBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(AliNetworkBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(SnapshotBridgeExtension.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.make(TRImageBridgeExtension.class));
        return arrayList;
    }

    @Override // com.alibaba.triver.TriverManifest, com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        List<ExtensionMetaInfo> extensions = super.getExtensions();
        extensions.add(new ExtensionMetaInfo("ariver", UserInfoExtensionImpl.class.getName(), Collections.singletonList(IUserInfoExtension.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", DataPreloadExtension.class.getName(), Collections.singletonList(DataPreloadPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", WorkerExceptionImpl.class.getName(), Collections.singletonList(WorkerExceptionPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", ResourceProviderImpl.class.getName(), Collections.singletonList(ResourceProviderPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", OfficialAppImpl.class.getName(), Collections.singletonList(OfficialAppPoint.class.getName())));
        extensions.add(new ExtensionMetaInfo("ariver", CustomServerMessageImpl.class.getName(), Collections.singletonList(CustomServerMsgExtension.class.getName())));
        return extensions;
    }

    @Override // com.alibaba.triver.TriverManifest, com.alibaba.ariver.integration.BaseManifest, com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        List<RVManifest.IProxyManifest> proxies = super.getProxies();
        if (proxies == null) {
            proxies = new ArrayList<>();
        }
        RVProxy.set(IPerformanceAndErrorTracker.class, new PerformanceAndErrorSender());
        RVProxy.set(RVMonitor.class, new MonitorProxyImpl());
        proxies.add(new RVManifest.LazyProxyManifest(IEnvProxy.class, new RVProxy.LazyGetter<IEnvProxy>() { // from class: com.alibaba.triver.open.TriverManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IEnvProxy get() {
                return new EnvProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVConfigService.class, new RVProxy.LazyGetter<RVConfigService>() { // from class: com.alibaba.triver.open.TriverManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVConfigService get() {
                return new TriverRVConfigService();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(RVResourceManager.class, new RVProxy.LazyGetter<RVResourceManager>() { // from class: com.alibaba.triver.open.TriverManifest.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVResourceManager get() {
                return new ResourceManager();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IAppLoadProxy.class, new RVProxy.LazyGetter<IAppLoadProxy>() { // from class: com.alibaba.triver.open.TriverManifest.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IAppLoadProxy get() {
                return new AppLoadProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(IPageLoadProxy.class, new RVProxy.LazyGetter<IPageLoadProxy>() { // from class: com.alibaba.triver.open.TriverManifest.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public IPageLoadProxy get() {
                return new PageLoadProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(ITriverMonitorProxy.class, new RVProxy.LazyGetter<ITriverMonitorProxy>() { // from class: com.alibaba.triver.open.TriverManifest.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public ITriverMonitorProxy get() {
                return new OpenTriverMonitorProxyImpl();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(EngineFactory.class, new RVProxy.LazyGetter<EngineFactory>() { // from class: com.alibaba.triver.open.TriverManifest.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public EngineFactory get() {
                return new OpenTriverEngineFactory();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(V8Proxy.class, new RVProxy.LazyGetter<V8Proxy>() { // from class: com.alibaba.triver.open.TriverManifest.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public V8Proxy get() {
                return new TriverV8Proxy();
            }
        }));
        proxies.add(new RVManifest.LazyProxyManifest(EngineFactory.class, new RVProxy.LazyGetter<EngineFactory>() { // from class: com.alibaba.triver.open.TriverManifest.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public EngineFactory get() {
                return new OpenTriverEngineFactory();
            }
        }));
        return proxies;
    }
}
