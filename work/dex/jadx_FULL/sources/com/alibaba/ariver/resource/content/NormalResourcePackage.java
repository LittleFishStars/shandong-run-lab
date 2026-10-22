package com.alibaba.ariver.resource.content;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.ariver.resource.parser.ParseContext;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NormalResourcePackage extends BaseResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24444a;

    public NormalResourcePackage(String str, ResourceContext resourceContext) {
        super(str, resourceContext);
        this.f24444a = false;
    }

    @WorkerThread
    private boolean a(String str) {
        String version;
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        String installedAppVersion = this.resourceManager.getInstalledAppVersion(this.appId);
        if (TextUtils.isEmpty(installedAppVersion)) {
            if (hitPresetResource()) {
                RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 0!");
                return true;
            }
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] failed - 0!");
            return false;
        }
        boolean z = (TextUtils.isEmpty(installedAppVersion) || TextUtils.equals(installedAppVersion, str)) ? false : true;
        AppModel appModel = this.mAppInfoManager.getAppModel(AppInfoQuery.make(this.appId).version(installedAppVersion));
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        if (rVResourcePresetProxy == null || (presetPackage = rVResourcePresetProxy.getPresetPackage()) == null || !presetPackage.containsKey(this.appId)) {
            version = null;
        } else {
            version = presetPackage.get(this.appId).getVersion();
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] found preset version: " + version);
        }
        if (appModel == null) {
            if (hitPresetResource()) {
                RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 2!");
                return true;
            }
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] failed!");
            return false;
        }
        if (TextUtils.equals(version, appModel.getAppVersion())) {
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 1-1!");
            return hitPresetResource();
        }
        if (!z) {
            if (!hitPresetResource()) {
                return false;
            }
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 1-2!");
            return true;
        }
        RVLogger.d(this.LOG_TAG, "[prepareForDegrade] degrade for current installed version: " + installedAppVersion);
        setAppModel(appModel);
        prepareContent(installedAppVersion);
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.onlineHost = null;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    public boolean canHotUpdate(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(@NonNull ResourceQuery resourceQuery) {
        if (resourceQuery.isDisableResourcePackage()) {
            RVLogger.d(this.LOG_TAG, "disable resource package!");
            return null;
        }
        if (!this.f24444a || !resourceQuery.isMainDoc()) {
            return super.get(resourceQuery);
        }
        RVLogger.d(this.LOG_TAG, "main url cannot degrade!");
        return null;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public boolean needWaitSetupWhenGet() {
        return false;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    public void onNotInstalled() {
        this.f24444a = false;
        boolean z = getAppModel() != null && this.resourceManager.isDownloaded(getAppModel());
        RVLogger.d(this.LOG_TAG, "onNotInstalled " + this.appId + " " + this.appVersion + " isDownloaded: " + z);
        if (z) {
            ResourceUtils.prepare(this.appId, this.appVersion, new BaseResourcePackage.HotUpdatePackageInstallCallback(!"NO".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("nebulax_hotUpdateInDownload", "YES"))));
            return;
        }
        boolean z2 = this.mResourceContext == null;
        final String str = this.appVersion;
        if (a(str)) {
            this.f24444a = true;
        } else {
            getParseLock().countDown();
        }
        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.resource.content.NormalResourcePackage.1
            @Override // java.lang.Runnable
            public void run() {
                NormalResourcePackage normalResourcePackage = NormalResourcePackage.this;
                ResourceUtils.prepare(normalResourcePackage.appId, str, new BaseResourcePackage.HotUpdatePackageInstallCallback());
            }
        };
        if (z2 || this.f24444a) {
            ExecutorUtils.getScheduledExecutor().schedule(runnable, 5L, TimeUnit.SECONDS);
        } else {
            ExecutorUtils.execute(ExecutorType.URGENT, runnable);
        }
    }
}
