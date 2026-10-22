package com.alibaba.ariver.resource.content;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.a.f;
import com.zj.adlib.o61;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseResourcePackage extends BaseStoragePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f24439a;
    String appId;
    String appVersion;

    @Nullable
    private AppModel d;

    @Nullable
    final ResourceContext mResourceContext;
    String LOG_TAG = "AriverRes:Package";
    private boolean b = false;
    private AtomicBoolean c = new AtomicBoolean(false);
    RVAppInfoManager mAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
    RVResourceManager resourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);

    public BaseResourcePackage(String str, @Nullable ResourceContext resourceContext) {
        this.appId = str;
        this.mResourceContext = resourceContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, @Nullable AppModel appModel) {
        AppModel appModel2;
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        if (this.b) {
            RVLogger.w(this.LOG_TAG, "already setupted!");
            return;
        }
        this.b = true;
        RVLogger.d(this.LOG_TAG, "begin setup with lock: " + z);
        this.f24439a = SystemClock.elapsedRealtime();
        if (appModel != null) {
            this.d = appModel;
        } else {
            this.d = prepareAppModel(AppInfoQuery.make(this.appId));
        }
        if (this.mAppInfoManager == null && this.d == null) {
            boolean zHitPresetResource = hitPresetResource();
            RVLogger.w(this.LOG_TAG, " cannot find local version for: " + this.appId);
            if (zHitPresetResource) {
                RVLogger.w(this.LOG_TAG, " hitPresetPkg!");
                onPrepareDone();
            } else {
                getSetupLock().countDown();
                getParseLock().countDown();
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            RVLogger.w(this.LOG_TAG, "prepareContent with lock!");
        }
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        Map<String, AppModel> presetAppInfos = rVResourcePresetProxy.getPresetAppInfos();
        if (presetAppInfos != null) {
            AppModel appModel3 = presetAppInfos.get(this.appId);
            if (appModel3 != null && (presetPackage = rVResourcePresetProxy.getPresetPackage()) != null && presetPackage.get(this.appId) != null && presetPackage.get(this.appId).isForceUse() && hitPresetResource()) {
                RVLogger.w(this.LOG_TAG, "prepareContent use preset force used flag!");
                return;
            }
            if (appModel3 != null && AppModel.COMPARATOR.compare(this.d, appModel3) < 0 && hitPresetResource()) {
                RVLogger.w(this.LOG_TAG, "prepareContent use preset because lower current AppInfo!");
                return;
            } else if (appModel3 != null && (appModel2 = this.d) != null && TextUtils.equals(appModel2.getAppVersion(), appModel3.getAppVersion()) && hitPresetResource()) {
                RVLogger.w(this.LOG_TAG, "prepareContent just hit presetResource!");
                return;
            }
        }
        AppModel appModel4 = this.d;
        prepareContent(appModel4 != null ? appModel4.getAppVersion() : null);
        if (z) {
            try {
                getSetupLock().await(5L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                RVLogger.w(this.LOG_TAG, "prepareContent block error", e);
            }
            RVLogger.d(this.LOG_TAG, "prepareContent block " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String appId() {
        return this.appId;
    }

    public abstract boolean canHotUpdate(String str);

    @Nullable
    public AppModel getAppModel() {
        return this.d;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public String getLogTag() {
        return this.LOG_TAG;
    }

    public boolean hitPresetResource() {
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        Map<String, AppModel> presetAppInfos;
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        if (rVResourcePresetProxy == null || (presetPackage = rVResourcePresetProxy.getPresetPackage()) == null || !presetPackage.containsKey(this.appId)) {
            return false;
        }
        RVLogger.d(this.LOG_TAG, "prepareForDegrade found preset pkg " + this.appId);
        RVResourcePresetProxy.PresetPackage presetPackage2 = presetPackage.get(this.appId);
        if (this.mAppInfoManager.getAppModel(AppInfoQuery.make(this.appId).version(presetPackage2.getVersion())) == null && (presetAppInfos = rVResourcePresetProxy.getPresetAppInfos()) != null && presetAppInfos.containsKey(this.appId)) {
            this.d = presetAppInfos.get(this.appId);
        }
        if (this.d == null) {
            return false;
        }
        RVLogger.d(this.LOG_TAG, "prepareForDegrade start install preset pkg!");
        String version = presetPackage2.getVersion();
        this.appVersion = version;
        a(this.appId, version);
        return a(presetPackage2.getInputStream());
    }

    public void hotUpdateApp(String str, @Nullable String str2) {
        if (this.mAppInfoManager == null) {
            RVLogger.e(this.LOG_TAG, "failed to get app provider!");
            return;
        }
        RVLogger.d(this.LOG_TAG, "hotUpdateApp hotVersion: " + str + " appVersion:" + this.appVersion);
        if (!this.resourceManager.isAvailable(this.d)) {
            RVLogger.w(this.LOG_TAG, "hot update but not installed!");
            getParseLock().countDown();
        } else {
            if (str2 == null) {
                str2 = this.resourceManager.getInstallPath(this.d);
            }
            parseContent(this.appId, str2);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return false;
    }

    public abstract void onNotInstalled();

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone() {
        super.onPrepareDone();
        RVLogger.d(this.LOG_TAG, "onPrepareDone cost: " + (SystemClock.elapsedRealtime() - this.f24439a));
    }

    public AppModel prepareAppModel(AppInfoQuery appInfoQuery) {
        ResourceContext resourceContext = this.mResourceContext;
        AppModel mainPackageInfo = (resourceContext == null || !this.appId.equalsIgnoreCase(resourceContext.getAppId())) ? null : this.mResourceContext.getMainPackageInfo();
        return mainPackageInfo == null ? this.mAppInfoManager.getAppModel(appInfoQuery) : mainPackageInfo;
    }

    public void prepareContent(@Nullable String str) {
        a(this.appId, str);
        boolean z = (TextUtils.isEmpty(this.appVersion) || TextUtils.isEmpty(str) || str.equalsIgnoreCase(this.appVersion)) ? false : true;
        AppModel appModel = this.d;
        boolean z2 = appModel != null && this.resourceManager.isAvailable(appModel);
        RVLogger.d(this.LOG_TAG, "prepareContent appId:" + this.appId + " appVersion " + str + " installed:" + z2);
        if (!z && count() != 0) {
            RVLogger.d(this.LOG_TAG, "!versionChanged return");
            onPrepareDone();
            return;
        }
        this.appVersion = str;
        if (z2) {
            parseContent(this.appId, this.resourceManager.getInstallPath(this.d));
        } else {
            onNotInstalled();
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void reload() {
        if (this.mSetupLock.getCount() > 0 || this.mParseLock.getCount() > 0 || this.c.get()) {
            RVLogger.d(this.LOG_TAG, "current setup and not do reload!");
            return;
        }
        RVLogger.d(this.LOG_TAG, "reload begin!");
        final AppModel appModelPrepareAppModel = prepareAppModel(AppInfoQuery.make(this.appId).disableCache());
        String appVersion = appModelPrepareAppModel == null ? null : appModelPrepareAppModel.getAppVersion();
        AppModel appModel = this.d;
        String appVersion2 = appModel != null ? appModel.getAppVersion() : null;
        RVLogger.d(this.LOG_TAG, "reload got new " + appVersion + ", current: " + appVersion2);
        if (appModelPrepareAppModel != null && AppModel.COMPARATOR.compare(appModelPrepareAppModel, this.d) <= 0) {
            RVLogger.d(this.LOG_TAG, "reload version compare fail, not refresh!");
            return;
        }
        this.b = false;
        this.c.set(true);
        ResourceUtils.downloadAndInstallApp(new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.content.BaseResourcePackage.1
            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
            public void onResult(boolean z, String str) {
                BaseResourcePackage.this.mSetupLock = new CountDownLatch(1);
                BaseResourcePackage.this.mParseLock = new CountDownLatch(1);
                BaseResourcePackage.this.a(true, appModelPrepareAppModel);
                BaseResourcePackage.this.c.set(false);
                RVLogger.d(BaseResourcePackage.this.LOG_TAG, "reload end!");
            }
        }, appModelPrepareAppModel);
    }

    public void setAppModel(@Nullable AppModel appModel) {
        this.d = appModel;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        a(z, (AppModel) null);
    }

    public String toString() {
        return "package {" + this.appId + LoginConstants.UNDER_LINE + this.appVersion + "} size: " + count();
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String version() {
        return this.appVersion;
    }

    public final class HotUpdatePackageInstallCallback implements PackageInstallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f24440a;

        public HotUpdatePackageInstallCallback() {
            this.f24440a = false;
        }

        @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
        public void onResult(boolean z, String str) {
            RVLogger.d(BaseResourcePackage.this.LOG_TAG, "HotUpdatePackageInstallCallback onResult install result: " + z + " installPath: " + str + " forceUpdate: " + this.f24440a);
            if (BaseResourcePackage.this.isDetached() || !z) {
                RVLogger.d(BaseResourcePackage.this.LOG_TAG, "HotUpdatePackageInstallCallback onResult already released!");
                BaseResourcePackage.this.getSetupLock().countDown();
                BaseResourcePackage.this.getParseLock().countDown();
                return;
            }
            if (BaseResourcePackage.this.d == null) {
                BaseResourcePackage baseResourcePackage = BaseResourcePackage.this;
                baseResourcePackage.d = baseResourcePackage.mAppInfoManager.getAppModel(AppInfoQuery.make(baseResourcePackage.appId).version(BaseResourcePackage.this.appVersion));
            }
            if (BaseResourcePackage.this.d == null) {
                RVLogger.e(BaseResourcePackage.this.LOG_TAG, "HotUpdatePackageInstallCallback onResult do not have AppModel!!!");
                BaseResourcePackage.this.onPrepareDone();
                return;
            }
            BaseResourcePackage baseResourcePackage2 = BaseResourcePackage.this;
            baseResourcePackage2.appVersion = baseResourcePackage2.d.getAppVersion();
            if (!this.f24440a) {
                BaseResourcePackage baseResourcePackage3 = BaseResourcePackage.this;
                if (!baseResourcePackage3.canHotUpdate(baseResourcePackage3.appVersion)) {
                    RVLogger.d(BaseResourcePackage.this.LOG_TAG, "canHotUpdate false");
                    return;
                }
            }
            BaseResourcePackage baseResourcePackage4 = BaseResourcePackage.this;
            baseResourcePackage4.a(baseResourcePackage4.d.getAppId(), BaseResourcePackage.this.d.getAppVersion());
            BaseResourcePackage baseResourcePackage5 = BaseResourcePackage.this;
            baseResourcePackage5.hotUpdateApp(baseResourcePackage5.d.getAppVersion(), str);
        }

        public HotUpdatePackageInstallCallback(boolean z) {
            this.f24440a = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        this.LOG_TAG = "AriverRes:Package_" + str + LoginConstants.UNDER_LINE + str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    private boolean a(InputStream inputStream) throws Throwable {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        RVLogger.d(this.LOG_TAG, "parsePresetStream start");
        ParseContext parseContext = new ParseContext();
        parseContext.appId = this.appId;
        beforeParsePackage(parseContext);
        String str = parseContext.mainFileName;
        if (str == null) {
            str = this.appId + ".tar";
        }
        byte[] buf = IOUtils.getBuf(2048);
        ?? r5 = 0;
        f fVar = null;
        boolean zHasNext = false;
        ZipInputStream zipInputStream = null;
        boolean z = false;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(inputStream));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains(o61.h) && !name.contains("%")) {
                            RVLogger.d(this.LOG_TAG, "parsePresetStream check target " + name);
                            if (TextUtils.equals(name, str)) {
                                z = true;
                                try {
                                    f fVar2 = new f(zipInputStream2);
                                    try {
                                        HashMap map = new HashMap();
                                        PackageParseUtils.readTarStreamIntoMemory(map, fVar2, parseContext);
                                        Iterator it = map.values().iterator();
                                        while (true) {
                                            zHasNext = it.hasNext();
                                            if (!zHasNext) {
                                                break;
                                            }
                                            Resource resource = (Resource) it.next();
                                            add(resource);
                                            if (resource instanceof OfflineResource) {
                                                ((OfflineResource) resource).setBelongsPackage(this);
                                            }
                                        }
                                        IOUtils.closeQuietly(fVar2);
                                        break;
                                    } catch (Throwable th) {
                                        th = th;
                                        fVar = fVar2;
                                        IOUtils.closeQuietly(fVar);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        } else {
                            RVLogger.d(this.LOG_TAG, "parsePresetStream entryName " + name + " not safe!");
                        }
                    } catch (Exception e) {
                        e = e;
                        zipInputStream = zipInputStream2;
                        RVLogger.e(this.LOG_TAG, "unZip exception", e);
                        getSetupLock().countDown();
                        getParseLock().countDown();
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(zipInputStream);
                        r5 = zipInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                        r5 = zipInputStream2;
                        getSetupLock().countDown();
                        getParseLock().countDown();
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(r5);
                        throw th;
                    }
                }
                getSetupLock().countDown();
                getParseLock().countDown();
                IOUtils.returnBuf(buf);
                IOUtils.closeQuietly(zipInputStream2);
                r5 = zHasNext;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (!TextUtils.isEmpty(parseContext.appId)) {
            afterParsePackage(parseContext);
        }
        if (!z) {
            RVLogger.w(this.LOG_TAG, "parsePresetStream end with exception!!! cannot found " + this.appId + ".tar !!!");
        } else {
            RVLogger.d(this.LOG_TAG, "parsePresetStream end cost " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
        return z;
    }
}
