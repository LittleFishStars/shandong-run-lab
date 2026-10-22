package com.alibaba.ariver.integration;

import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements RVManifest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RVManifest> f24079a;
    private RVProxy.Printer b;
    private AccessController c;
    private RemoteController d;
    private boolean e = false;
    private final List<RVManifest.IProxyManifest> f = new ArrayList();
    private boolean g = false;
    private final List<RVManifest.BridgeExtensionManifest> h = new ArrayList();
    private final List<BridgeDSL> i = new ArrayList();
    private boolean j = false;
    private final Map<String, EmbedViewMetaInfo> k = new HashMap();
    private boolean l = false;
    private final List<ExtensionMetaInfo> m = new ArrayList();
    private boolean n = false;
    private final List<RVManifest.ServiceBeanManifest> o = new ArrayList();
    private boolean p = false;
    private final List<AppUpdaterFactory.Rule> q = new ArrayList();

    public c(List<RVManifest> list, RVProxy.Printer printer) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f24079a = list;
        this.b = printer;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    @Nullable
    public AccessController getAccessController() {
        for (RVManifest rVManifest : this.f24079a) {
            if (rVManifest != null) {
                try {
                    AccessController accessController = rVManifest.getAccessController();
                    if (accessController != null) {
                        this.c = accessController;
                    }
                } catch (Throwable th) {
                    this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                }
            }
        }
        return this.c;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        synchronized (this.q) {
            try {
                if (this.p) {
                    return this.q;
                }
                this.p = true;
                for (RVManifest rVManifest : this.f24079a) {
                    if (rVManifest != null) {
                        try {
                            List<AppUpdaterFactory.Rule> appUpdaterRules = rVManifest.getAppUpdaterRules();
                            if (appUpdaterRules != null) {
                                this.q.addAll(appUpdaterRules);
                            }
                        } catch (Throwable th) {
                            this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                        }
                    }
                }
                return this.q;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        for (RVManifest rVManifest : this.f24079a) {
            if (rVManifest != null) {
                try {
                    List<BridgeDSL> bridgeDSLs = rVManifest.getBridgeDSLs();
                    if (bridgeDSLs != null) {
                        this.i.addAll(bridgeDSLs);
                    }
                } catch (Throwable th) {
                    this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                }
            }
        }
        return this.i;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        synchronized (this.h) {
            try {
                if (this.g) {
                    return this.h;
                }
                this.g = true;
                for (RVManifest rVManifest : this.f24079a) {
                    if (rVManifest != null) {
                        try {
                            List<RVManifest.BridgeExtensionManifest> bridgeExtensions = rVManifest.getBridgeExtensions();
                            if (bridgeExtensions != null) {
                                this.h.addAll(bridgeExtensions);
                            }
                        } catch (Throwable th) {
                            this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                        }
                    }
                }
                return this.h;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    @Nullable
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        synchronized (this.k) {
            try {
                if (this.j) {
                    return this.k;
                }
                this.j = true;
                for (RVManifest rVManifest : this.f24079a) {
                    if (rVManifest != null) {
                        try {
                            Map<String, EmbedViewMetaInfo> embedViews = rVManifest.getEmbedViews();
                            if (embedViews != null) {
                                this.k.putAll(embedViews);
                            }
                        } catch (Throwable th) {
                            this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                        }
                    }
                }
                return this.k;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        synchronized (this.m) {
            try {
                if (this.l) {
                    return this.m;
                }
                this.l = true;
                for (RVManifest rVManifest : this.f24079a) {
                    if (rVManifest != null) {
                        try {
                            List<ExtensionMetaInfo> extensions = rVManifest.getExtensions();
                            if (extensions != null) {
                                this.m.addAll(extensions);
                            }
                        } catch (Throwable th) {
                            this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                        }
                    }
                }
                return this.m;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        synchronized (this.f) {
            try {
                if (this.e) {
                    return this.f;
                }
                this.e = true;
                for (RVManifest rVManifest : this.f24079a) {
                    if (rVManifest != null) {
                        try {
                            List<RVManifest.IProxyManifest> proxies = rVManifest.getProxies();
                            if (proxies != null) {
                                this.f.addAll(proxies);
                            }
                        } catch (Throwable th) {
                            this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                        }
                    }
                }
                return this.f;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    @Nullable
    public RemoteController getRemoteController() {
        for (RVManifest rVManifest : this.f24079a) {
            if (rVManifest != null) {
                try {
                    RemoteController remoteController = rVManifest.getRemoteController();
                    if (remoteController != null) {
                        this.d = remoteController;
                    }
                } catch (Throwable th) {
                    this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                }
            }
        }
        return this.d;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        synchronized (this.o) {
            try {
                if (this.n) {
                    return this.o;
                }
                this.n = true;
                for (RVManifest rVManifest : this.f24079a) {
                    if (rVManifest != null) {
                        try {
                            List<RVManifest.ServiceBeanManifest> serviceBeans = rVManifest.getServiceBeans(extensionManager);
                            if (serviceBeans != null) {
                                this.o.addAll(serviceBeans);
                            }
                        } catch (Throwable th) {
                            this.b.print("compose RVManifest " + rVManifest + " error! " + Log.getStackTraceString(th));
                        }
                    }
                }
                return this.o;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
