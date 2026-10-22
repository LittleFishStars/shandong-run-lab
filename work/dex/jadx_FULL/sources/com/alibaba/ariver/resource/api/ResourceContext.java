package com.alibaba.ariver.resource.api;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceProvider;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.network.OnlineResourceFetcher;
import com.alibaba.ariver.resource.api.storage.TabBarDataStorage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.zj.adlib.bv9;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24419a = "AriverRes:ResourceContext";
    public String appType;
    private WeakReference<App> b;
    private String c;
    private Bundle d;
    private Bundle e;
    private String f;

    @Nullable
    private AppModel g;

    @Nullable
    private ResourcePackage k;
    private ResourceProvider m;
    private String o;
    public TabBarDataStorage tabBarDataStorage = new TabBarDataStorage();
    public boolean hasPageEntered = false;
    public boolean cubeEngineInitFailed = false;
    public boolean startWithNBUrl = false;
    private final Set<String> h = new HashSet();
    private final Object i = new Object();
    private String j = null;
    private final Map<String, ResourcePackage> l = new ConcurrentHashMap();
    private Map<String, byte[]> n = new ConcurrentHashMap();
    private final OnlineResourceFetcher p = new OnlineResourceFetcher();

    public void addPackage(@NonNull ResourcePackage resourcePackage) {
        if (!this.l.containsKey(resourcePackage.appId())) {
            this.l.put(resourcePackage.appId(), resourcePackage);
            attachResourcePackage(resourcePackage.appId());
        }
        RVLogger.d(f24419a, "addPackage " + resourcePackage + " to " + this);
    }

    public void attachResourcePackage(String str) {
        synchronized (this.h) {
            this.h.add(str);
        }
    }

    public boolean containsPackage(String str) {
        return this.h.contains(str);
    }

    public App getApp() {
        WeakReference<App> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getAppId() {
        return this.c;
    }

    public String getAppVersion() {
        return this.f;
    }

    public ResourceProvider getContentProvider() {
        return this.m;
    }

    @Nullable
    public ResourcePackage getMainPackage() {
        return this.k;
    }

    @Nullable
    public AppModel getMainPackageInfo() {
        return this.g;
    }

    public OnlineResourceFetcher getOnlineResourceFetcher() {
        return this.p;
    }

    public String getPackageBrief(boolean z) {
        synchronized (this.i) {
            String str = this.j;
            if (str != null && !z) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            HashSet<ResourcePackage> hashSet = new HashSet();
            hashSet.add(this.k);
            synchronized (this.h) {
                Iterator<String> it = this.h.iterator();
                while (it.hasNext()) {
                    ResourcePackage resourcePackage = ResourcePackagePool.getInstance().getPackage(it.next());
                    if (resourcePackage != null) {
                        hashSet.add(resourcePackage);
                    }
                }
            }
            Collection<ResourcePackage> packages = GlobalPackagePool.getInstance().getPackages();
            if (packages != null) {
                hashSet.addAll(packages);
            }
            for (ResourcePackage resourcePackage2 : hashSet) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                if (resourcePackage2 != null) {
                    sb.append(resourcePackage2.appId());
                    sb.append(LoginConstants.UNDER_LINE);
                    sb.append(resourcePackage2.count() > 0 ? "Y_" : "N_");
                    sb.append(resourcePackage2.version());
                }
            }
            String string = sb.toString();
            this.j = string;
            return string;
        }
    }

    @Nullable
    public Resource getRawResource(@NonNull ResourceQuery resourceQuery) {
        Resource resource;
        ResourcePackage resourcePackage = this.k;
        if (resourcePackage != null && (resource = resourcePackage.get(resourceQuery)) != null) {
            return resource;
        }
        Iterator<ResourcePackage> it = this.l.values().iterator();
        while (it.hasNext()) {
            Resource resource2 = it.next().get(resourceQuery);
            if (resource2 != null) {
                return resource2;
            }
        }
        return null;
    }

    public Set<String> getResourcePackages() {
        return this.h;
    }

    public Bundle getSceneParams() {
        return this.e;
    }

    public byte[] getSnapshotIndex(String str) {
        if (this.n.containsKey(str)) {
            return this.n.get(str);
        }
        return null;
    }

    public String getSnapshotTitleBarParams() {
        return this.o;
    }

    public Bundle getStartParams() {
        return this.d;
    }

    public void releaseResourcePackages() {
        ResourceProvider resourceProvider = this.m;
        if (resourceProvider != null) {
            resourceProvider.releaseContent();
            this.m = null;
        }
        ResourcePackage resourcePackage = this.k;
        if (resourcePackage != null) {
            resourcePackage.teardown();
            this.k = null;
        }
        Iterator<ResourcePackage> it = this.l.values().iterator();
        while (it.hasNext()) {
            it.next().teardown();
        }
        this.l.clear();
        synchronized (this.h) {
            this.h.clear();
        }
    }

    public void setApp(App app) {
        this.b = new WeakReference<>(app);
    }

    public void setAppId(String str) {
        this.c = str;
    }

    public void setAppVersion(String str) {
        this.f = str;
    }

    public void setContentProvider(ResourceProvider resourceProvider) {
        this.m = resourceProvider;
    }

    public void setMainPackage(@Nullable ResourcePackage resourcePackage) {
        this.k = resourcePackage;
    }

    public void setMainPackageInfo(@Nullable AppModel appModel) {
        if (appModel != null) {
            this.g = appModel;
            setAppVersion(appModel.getAppVersion());
        }
    }

    public void setSceneParams(Bundle bundle) {
        this.e = bundle;
    }

    public void setSnapshotIndex(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        this.n.put(str, bArr);
    }

    public void setSnapshotTitleBarParams(String str) {
        this.o = str;
    }

    public void setStartParams(Bundle bundle) {
        this.d = bundle;
    }

    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceContext{appId=");
        sb.append(this.c);
        sb.append(", startParam=");
        sb.append(this.d);
        sb.append(", sceneParam=");
        sb.append(this.e);
        sb.append(", appVersion=");
        sb.append(this.f);
        sb.append(", appType=");
        sb.append(this.appType);
        sb.append(", mainPackageInfo=");
        AppModel appModel = this.g;
        sb.append(appModel != null ? appModel.toString() : null);
        sb.append(", contentProvider=");
        sb.append(this.m);
        sb.append(", mainPackage=");
        sb.append(this.k);
        sb.append(", resourcePackages=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }

    public String toString() {
        return "ResourceContext@" + hashCode() + bv9.b + "appId=" + this.c + ", appVersion=" + this.f + ", appType=" + this.appType + '}';
    }

    public void updatePackageBrief() {
        App app = this.b.get();
        if (app != null) {
            String packageBrief = getPackageBrief(true);
            RVLogger.d(f24419a, "updatePackageBrief: " + packageBrief);
            app.putStringValue(RVConstants.KEY_PACKAGE_BRIEF, packageBrief);
        }
    }
}
