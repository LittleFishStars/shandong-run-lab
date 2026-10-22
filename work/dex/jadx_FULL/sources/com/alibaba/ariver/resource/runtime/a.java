package com.alibaba.ariver.resource.runtime;

import android.os.Bundle;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.model.AppxVersionStore;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.NetworkStream;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceProvider;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.network.OnlineResourceFetcher;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements NetworkStream.Listener, ResourceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24465a = "AriverRes:ContentProvider";
    public static final String b = "https://appx";
    public static final String c = "https://appx-ng";
    private String d;
    private Map<String, String> e;
    private final List<NetworkStream> f;
    private final List<InputStream> g;
    private Map<String, String> i;
    private String m;
    private String n;
    private ResourceContext p;
    private OnlineResourceFetcher q;
    private RVAppInfoManager r;
    private ResourceProviderPoint s;
    private String t;
    private App u;
    private boolean v;
    private boolean w;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean o = false;
    private HashMap<String, Resource> h = new HashMap<>();

    public a(ResourceContext resourceContext) {
        this.r = null;
        this.v = false;
        this.w = false;
        this.p = resourceContext;
        this.q = resourceContext.getOnlineResourceFetcher();
        this.s = (ResourceProviderPoint) ExtensionPoint.as(ResourceProviderPoint.class).node(resourceContext.getApp()).create();
        if (resourceContext.getMainPackageInfo() != null) {
            this.t = resourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
            this.d = resourceContext.getMainPackageInfo().getAppInfoModel().getFallbackBaseUrl();
        }
        this.f = Collections.synchronizedList(new ArrayList());
        this.g = Collections.synchronizedList(new ArrayList());
        this.e = Collections.synchronizedMap(new HashMap());
        this.r = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        this.u = this.p.getApp();
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            this.v = "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_enableUseAppxHtmlNebulaX", ""));
            this.w = "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_enableInlineAppxJsFile", ""));
        }
        c();
    }

    private void c() {
        Set<String> setKeySet;
        this.i = new ConcurrentHashMap();
        if ("YES".equalsIgnoreCase(BundleUtils.getString(this.u.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK)) && BundleUtils.contains(this.u.getStartParams(), RVParams.APPX_ROUTE_BIZPREFIX)) {
            String string = BundleUtils.getString(this.u.getStartParams(), RVParams.APPX_ROUTE_BIZPREFIX);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.i.put(FileUtils.combinePath(this.t, "index.js"), FileUtils.combinePath(this.t, string + "index.js"));
            this.i.put(FileUtils.combinePath(this.t, "index.html"), FileUtils.combinePath(this.t, string + "index.html"));
            this.i.put(FileUtils.combinePath(this.t, "index.worker.js"), FileUtils.combinePath(this.t, string + "index.worker.js"));
            AppModel appModel = (AppModel) this.u.getData(AppModel.class);
            if (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getSubPackages() == null || (setKeySet = appModel.getAppInfoModel().getSubPackages().keySet()) == null || setKeySet.isEmpty()) {
                return;
            }
            for (String str : setKeySet) {
                if (!TextUtils.isEmpty(str) && !"whole".equalsIgnoreCase(str) && !"main".equalsIgnoreCase(str)) {
                    this.i.put(FileUtils.combinePath(this.t, str + "/index.worker.js"), FileUtils.combinePath(this.t, str + WVNativeCallbackUtil.SEPERATER + string + "index.worker.js"));
                    this.i.put(FileUtils.combinePath(this.t, str + "/index.js"), FileUtils.combinePath(this.t, str + WVNativeCallbackUtil.SEPERATER + string + "index.js"));
                }
            }
        }
    }

    public void b() {
        try {
            RVLogger.debug(f24465a, "disconnect connList " + this.f.size());
            synchronized (this.f) {
                for (int i = 0; i < this.f.size(); i++) {
                    NetworkStream networkStream = this.f.get(i);
                    if (networkStream != null) {
                        try {
                            networkStream.close();
                        } catch (Exception e) {
                            RVLogger.e(f24465a, "close connection exception.", e);
                        }
                    }
                }
                this.f.clear();
            }
            RVLogger.debug(f24465a, "disconnect inputStreamList " + this.g.size());
            synchronized (this.g) {
                Iterator<InputStream> it = this.g.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().close();
                    } catch (Exception e2) {
                        RVLogger.e(f24465a, e2);
                    }
                }
                this.g.clear();
            }
        } catch (Exception e3) {
            RVLogger.e(f24465a, e3);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getContent(ResourceQuery resourceQuery) {
        String strReplace;
        try {
            a();
            String str = resourceQuery.pureUrl;
            if (TextUtils.isEmpty(str)) {
                RVLogger.e(f24465a, "invalid url parameter");
                return null;
            }
            if (!str.startsWith("file://") && !str.startsWith("http://") && !str.startsWith("https://")) {
                RVLogger.d(f24465a, "skip load resource for " + str);
                return null;
            }
            boolean zIsMainDoc = resourceQuery.isMainDoc();
            String strPurifyUrl = UrlUtils.purifyUrl(str);
            if (strPurifyUrl.startsWith(b) && resourceQuery.isAppxNgRoute()) {
                strReplace = strPurifyUrl.replace(b, c);
                resourceQuery.pureUrl = resourceQuery.pureUrl.replace(b, c);
                RVLogger.d(f24465a, "appx-ng replace " + resourceQuery.pureUrl);
                resourceQuery.setCanUseFallback(false);
            } else {
                strReplace = strPurifyUrl;
            }
            if (this.i.containsKey(strPurifyUrl) && resourceQuery.isAppxNgRoute()) {
                strReplace = this.i.get(strPurifyUrl);
                resourceQuery.pureUrl = strReplace;
            }
            if (strPurifyUrl.startsWith(b)) {
                if (strPurifyUrl.startsWith("https://appx/af-appx.min.js")) {
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_JS_RenderFrameworkStart);
                } else if (strPurifyUrl.startsWith("https://appx/af-appx.worker.min.js")) {
                    this.u.putBooleanValue("appxRouteWorker", resourceQuery.isAppxNgRoute());
                    RVLogger.d(f24465a, "appx-ng set appxRouteWorker is " + resourceQuery.isAppxNgRoute());
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.u, "appxRoute", resourceQuery.isAppxNgRoute() ? "yes" : "no");
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_JS_WorkerFrameworkStart);
                }
                RVLogger.d(f24465a, "app " + this.u.getNodeId() + "load " + strPurifyUrl);
            }
            if (this.l && strPurifyUrl.startsWith(b)) {
                RVLogger.d(f24465a, "hasTinyGoOnline true use tinyRes again " + strPurifyUrl);
                String strA = a(resourceQuery);
                if (!TextUtils.isEmpty(strA)) {
                    String strReplace2 = strReplace.replace("https://", strA);
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_Resource_Fallback);
                    return this.q.getOnlineResource(strReplace2, true, this.p.getAppId());
                }
            }
            if (strPurifyUrl.equalsIgnoreCase(FileUtils.combinePath(this.t, "index.html"))) {
                byte[] snapshotIndex = this.p.getSnapshotIndex(resourceQuery.originUrl);
                if (snapshotIndex == null && this.p.getApp() != null) {
                    snapshotIndex = RVSnapshotUtils.loadSnapshotFile(this.p.getApp(), resourceQuery.originUrl);
                }
                if (snapshotIndex != null && snapshotIndex.length > 100) {
                    RVLogger.d(f24465a, "SnapshotProvider use snapshotData success! " + strPurifyUrl);
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_Use_Snapshot);
                    OfflineResource offlineResource = new OfflineResource(strPurifyUrl, snapshotIndex);
                    offlineResource.setSourceType(ResourceSourceType.SNAPSHOT);
                    return offlineResource;
                }
            }
            Bundle startParams = this.p.getStartParams();
            if (this.v && strPurifyUrl.equalsIgnoreCase(FileUtils.combinePath(this.t, "index.html")) && BundleUtils.getBoolean(startParams, RVParams.isTinyApp, false) && !AppInfoScene.isDevSource(startParams)) {
                RVLogger.d(f24465a, "use appx html:\t" + strPurifyUrl);
                if (resourceQuery.isAppxNgRoute()) {
                    resourceQuery.pureUrl = FileUtils.combinePath(c, "index.html");
                } else {
                    resourceQuery.pureUrl = FileUtils.combinePath(b, "index.html");
                }
                Resource rawResource = getRawResource(resourceQuery);
                if (rawResource == null) {
                    resourceQuery.pureUrl = strReplace;
                    RVLogger.d(f24465a, "replace html file fail , global package is null");
                } else if (this.w) {
                    byte[] bArrA = b.a((byte[]) rawResource.getBytes().clone(), b.b, b.c, this.t, this);
                    if (bArrA != null && bArrA.length > 1) {
                        RVLogger.d(f24465a, "replaceJsFile success");
                        rawResource.setBytes(bArrA);
                    }
                    return rawResource;
                }
            }
            Resource rawResource2 = getRawResource(resourceQuery);
            if (rawResource2 == null) {
                rawResource2 = null;
            }
            if (!zIsMainDoc) {
                ExecutorUtils.execute(ExecutorType.IDLE, new Runnable() { // from class: com.alibaba.ariver.resource.runtime.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.p.updatePackageBrief();
                    }
                });
            }
            if (rawResource2 != null) {
                if (zIsMainDoc) {
                    RVLogger.d(f24465a, "H5_AL_SESSION_MAP_SUCCESS");
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_Resource_MainDoc_Offline);
                } else if (!this.k) {
                    this.k = true;
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_Resource_SubRes_Offline);
                }
                if ("https://appx/af-appx.min.js".equals(strPurifyUrl)) {
                    try {
                        String strSubstring = new String(rawResource2.getBytes(), 0, 100, "UTF-8").split("\\r?\\n")[2].substring(3);
                        RVLogger.e(f24465a, "detect render appx version is: " + strSubstring);
                        ((AppxVersionStore) this.p.getApp().getData(AppxVersionStore.class, true)).renderVersion = strSubstring;
                    } catch (Throwable th) {
                        RVLogger.e(f24465a, "detect render appx version exception: ", th);
                    }
                }
                RVLogger.d(f24465a, "load response from offline: " + strReplace);
                return rawResource2;
            }
            Resource resourceRemove = this.h.remove(strReplace);
            if (resourceRemove != null) {
                RVLogger.d(f24465a, "load response from map local.");
                return resourceRemove;
            }
            if (!strPurifyUrl.endsWith("/favicon.ico") && !strPurifyUrl.endsWith("/favicon.png") && !strPurifyUrl.endsWith("/favicon2.ico")) {
                if (strPurifyUrl.startsWith(b)) {
                    String strA2 = a(resourceQuery);
                    if (!TextUtils.isEmpty(strA2)) {
                        this.l = true;
                        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_Resource_Fallback);
                        return this.q.getOnlineResource(strReplace.replace("https://", strA2), true, this.p.getAppId());
                    }
                }
                String strA3 = a(strReplace);
                if (!TextUtils.isEmpty(strA3)) {
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.u, TrackId.Stub_Resource_Fallback);
                }
                if (!TextUtils.isEmpty(strA3) && resourceQuery.isCanUseFallback()) {
                    return this.q.getOnlineResource(strA3, true, this.p.getAppId());
                }
                Resource resource = this.s.getResource(resourceQuery);
                if (resource != null) {
                    RVLogger.d(f24465a, "load response from provider point");
                    return resource;
                }
                RVLogger.d(f24465a, "load response from web " + strReplace);
                return null;
            }
            RVLogger.d(f24465a, "favicon request intercepted");
            return new OfflineResource(strPurifyUrl, new byte[0], "image/x-icon");
        } catch (Throwable th2) {
            RVLogger.e(f24465a, "load response from web catch exception ", th2);
            return null;
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public String getFallbackUrl(String str) {
        Map<String, String> map;
        String strPurifyUrl = UrlUtils.purifyUrl(str);
        if (TextUtils.isEmpty(strPurifyUrl) || (map = this.e) == null) {
            return null;
        }
        return map.get(strPurifyUrl);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getLocalResource(String str) {
        ResourceQuery resourceQueryAsUrl = ResourceQuery.asUrl(str);
        ResourceContext resourceContext = this.p;
        Resource rawResource = resourceContext != null ? resourceContext.getRawResource(resourceQueryAsUrl) : null;
        return rawResource == null ? GlobalPackagePool.getInstance().get(resourceQueryAsUrl) : rawResource;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getRawResource(@NonNull ResourceQuery resourceQuery) {
        ResourceContext resourceContext = this.p;
        Resource rawResource = resourceContext != null ? resourceContext.getRawResource(resourceQuery) : null;
        if (rawResource == null) {
            rawResource = ResourcePackagePool.getInstance().get(resourceQuery);
        }
        if (rawResource == null) {
            rawResource = GlobalPackagePool.getInstance().get(resourceQuery);
        }
        this.j = rawResource != null;
        return rawResource;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public boolean hasInputException() {
        return this.o;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public boolean isLocal() {
        return this.j;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public void mapContent(String str, Resource resource) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24465a, "map Content url null!!!", new Throwable("Just Print"));
        } else {
            this.h.put(str, resource);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onInputClose(NetworkStream networkStream) {
        RVLogger.debug(f24465a, "on input stream close.");
        this.f.remove(networkStream);
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onInputException() {
        this.o = true;
        RVLogger.d(f24465a, "h5InputStream exception");
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onInputOpen(NetworkStream networkStream) {
        RVLogger.debug(f24465a, "on input stream open.");
        this.f.add(networkStream);
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onResourceError(NetworkStream networkStream, int i) {
        this.f.remove(networkStream);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public void releaseContent() {
        RVLogger.d(f24465a, "releaseContent");
        b();
        Map<String, String> map = this.e;
        if (map != null) {
            try {
                map.clear();
            } catch (Throwable th) {
                RVLogger.e(f24465a, "clear mFallbackUrlMap exception ", th);
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public void setFallbackCache(String str, byte[] bArr) {
        if (this.p.getMainPackage() != null) {
            this.p.getMainPackage().add(new OfflineResource(UrlUtils.purifyUrl(str), bArr));
        }
    }

    private String a(ResourceQuery resourceQuery) {
        if (resourceQuery.isAppxNgRoute()) {
            if (TextUtils.isEmpty(this.n) && this.r != null) {
                AppInfoQuery appInfoQuery = new AppInfoQuery(RVConstants.TINY_APPX_NG_APPID);
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_APPX_NG_APPID);
                if (resourcePackage != null && !TextUtils.isEmpty(resourcePackage.version())) {
                    appInfoQuery.version(resourcePackage.version());
                }
                AppModel appModel = this.r.getAppModel(appInfoQuery);
                if (appModel == null) {
                    return null;
                }
                this.n = appModel.getAppInfoModel().getFallbackBaseUrl();
                RVLogger.d(f24465a, "getAppNgTinyResFallbackUrl " + this.n);
            }
            return this.n;
        }
        if (TextUtils.isEmpty(this.m) && this.r != null) {
            AppInfoQuery appInfoQuery2 = new AppInfoQuery(RVConstants.TINY_WEB_COMMON_APPID);
            ResourcePackage resourcePackage2 = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
            if (resourcePackage2 != null && !TextUtils.isEmpty(resourcePackage2.version())) {
                appInfoQuery2.version(resourcePackage2.version());
            }
            AppModel appModel2 = this.r.getAppModel(appInfoQuery2);
            if (appModel2 == null) {
                return null;
            }
            this.m = appModel2.getAppInfoModel().getFallbackBaseUrl();
            RVLogger.d(f24465a, "getTinyResFallbackUrl " + this.m);
        }
        return this.m;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(this.d) || !str.startsWith(this.t)) {
            return null;
        }
        String strCombinePath = FileUtils.combinePath(this.d, str.replace(this.t, ""));
        RVLogger.d(f24465a, "fallback final url " + strCombinePath);
        return strCombinePath;
    }

    public void a() {
        this.o = false;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getContent(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24465a, "getContent url null!!!", new Throwable("Just Print"));
            return null;
        }
        ResourceQuery resourceQuery = new ResourceQuery(str);
        App app = this.u;
        if (app != null) {
            resourceQuery.setAppxNgRoute("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), RVParams.APPX_ROUTE_FRAMEWORK)));
        }
        resourceQuery.setCanUseFallback(false);
        resourceQuery.setMainDoc(false);
        return getContent(resourceQuery);
    }
}
