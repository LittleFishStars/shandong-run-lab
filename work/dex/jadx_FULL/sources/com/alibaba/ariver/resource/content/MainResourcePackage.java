package com.alibaba.ariver.resource.content;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventAttr;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.DownloadInstallCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.network.OnlineResourceFetcher;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MainResourcePackage extends BaseResourcePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f24443a;
    private boolean b;
    private AtomicInteger c;
    protected String mOnlineHost;

    public class MainResourceDownloadCallback extends DownloadInstallCallback {
        public MainResourceDownloadCallback() {
            super(MainResourcePackage.this.getAppModel(), true, true, new BaseResourcePackage.HotUpdatePackageInstallCallback());
        }
    }

    public MainResourcePackage(@NonNull ResourceContext resourceContext) {
        super(resourceContext.getAppId(), resourceContext);
        this.mOnlineHost = null;
        this.f24443a = new AtomicBoolean(false);
        this.b = false;
        this.c = new AtomicInteger(3);
        if (resourceContext.getMainPackageInfo() != null) {
            OnlineResourceFetcher onlineResourceFetcher = resourceContext.getOnlineResourceFetcher();
            final String fallbackBaseUrl = resourceContext.getMainPackageInfo().getAppInfoModel().getFallbackBaseUrl();
            final String vhost = resourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
            onlineResourceFetcher.setFallbackListener(new OnlineResourceFetcher.FallbackListener() { // from class: com.alibaba.ariver.resource.content.MainResourcePackage.1
                @Override // com.alibaba.ariver.resource.api.network.OnlineResourceFetcher.FallbackListener
                public void onFailed(String str) {
                    RVLogger.d(MainResourcePackage.this.getLogTag(), "onResource fallback failed! " + str);
                }

                @Override // com.alibaba.ariver.resource.api.network.OnlineResourceFetcher.FallbackListener
                public void onSuccess(String str, Resource resource) {
                    MainResourcePackage.this.b = true;
                    if (str.endsWith(RVConstants.FILE_APP_CONFIG) || str.endsWith(RVConstants.FILE_API_PERMISSION) || str.endsWith(RVConstants.FILE_TABBAR)) {
                        String strCombinePath = FileUtils.combinePath(vhost, str.replace(fallbackBaseUrl, ""));
                        RVLogger.d(MainResourcePackage.this.getLogTag(), "replace url [" + str + "] to [" + strCombinePath + "]");
                        MainResourcePackage.this.add(new OfflineResource(strCombinePath, resource.getBytes()));
                        if (MainResourcePackage.this.c.decrementAndGet() == 0) {
                            RVLogger.d(MainResourcePackage.this.getLogTag(), "all key resource onSuccess, just release setup lock!");
                            MainResourcePackage.this.getSetupLock().countDown();
                            MainResourcePackage.this.a();
                        }
                    }
                }
            });
            this.mOnlineHost = resourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f24443a.getAndSet(true)) {
            return;
        }
        b();
        ((PackageParsedPoint) ExtensionPoint.as(PackageParsedPoint.class).node(this.mResourceContext.getApp()).create()).onResourceParsed(this.mResourceContext.getMainPackageInfo(), this);
    }

    private void b() {
        TemplateConfigModel templateConfig;
        ResourceContext resourceContext = this.mResourceContext;
        if (resourceContext == null || resourceContext.getMainPackageInfo() == null || (templateConfig = this.mResourceContext.getMainPackageInfo().getAppInfoModel().getTemplateConfig()) == null || !templateConfig.isTemplateValid()) {
            return;
        }
        Resource resource = get(ResourceQuery.asUrl(RVConstants.FILE_API_PERMISSION).setNeedAutoCompleteHost());
        if (resource != null) {
            try {
                add(new OfflineResource(resource.getUrl(), new String(resource.getBytes(), "UTF-8").replace(templateConfig.getTemplateId(), this.appId).getBytes()));
            } catch (UnsupportedEncodingException e) {
                RVLogger.e(this.LOG_TAG, "change api_permission error!", e);
            }
        }
        RVLogger.d(this.LOG_TAG, "change api_permission to template: " + templateConfig.getTemplateId());
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        if (this.mResourceContext == null) {
            throw new IllegalStateException("MainResource parse need resource context");
        }
        super.afterParsePackage(parseContext);
        a();
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mResourceContext.getApp(), TrackId.Stub_PkgParse);
        if (parseContext.fromCache) {
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mResourceContext.getApp(), "parseFromCache", "1");
        } else {
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mResourceContext.getApp(), "parseFromCache", "0");
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        if (this.mResourceContext == null) {
            throw new IllegalStateException("MainResource parse need resource context");
        }
        super.beforeParsePackage(parseContext);
        parseContext.needCache = true;
        parseContext.adaptAppModel(this.mResourceContext.getMainPackageInfo());
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    public boolean canHotUpdate(String str) {
        return str == null || TextUtils.equals(str, this.appVersion);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(@NonNull ResourceQuery resourceQuery) {
        if (resourceQuery.isNeedAutoCompleteHost() && !TextUtils.isEmpty(this.mOnlineHost)) {
            resourceQuery.pureUrl = FileUtils.combinePath(this.mOnlineHost, resourceQuery.pureUrl);
        }
        if (resourceQuery.isLanguageAware()) {
            String appLanguage = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getAppLanguage();
            if (!TextUtils.isEmpty(appLanguage)) {
                String str = resourceQuery.pureUrl;
                String str2 = this.mOnlineHost;
                String strReplace = str.replace(str2, FileUtils.combinePath(str2, appLanguage));
                if (contains(strReplace)) {
                    resourceQuery.pureUrl = strReplace;
                    RVLogger.d(getLogTag(), "replace query to language awared url: " + strReplace);
                }
            }
        }
        return super.get(resourceQuery);
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        ResourceContext resourceContext = this.mResourceContext;
        return (resourceContext == null || resourceContext.getApp() == null || !this.mResourceContext.getApp().isTinyApp()) ? false : true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public boolean needWaitSetupWhenGet() {
        return false;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    public void onNotInstalled() {
        long j;
        if (this.mResourceContext == null) {
            return;
        }
        if (this.resourceManager.isAvailable(getAppModel())) {
            this.resourceManager.installApp(getAppModel(), new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.content.MainResourcePackage.2
                @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                public void onResult(boolean z, String str) {
                    MainResourcePackage mainResourcePackage = MainResourcePackage.this;
                    mainResourcePackage.parseContent(mainResourcePackage.appId, str);
                }
            });
            return;
        }
        getParseLock().countDown();
        if (this.b || this.mResourceContext.getSceneParams().getBoolean(RVConstants.EXTRA_USING_FALLBACK_START)) {
            RVLogger.d(this.LOG_TAG, "already fallback, just release setupLock!");
            j = 5000;
        } else {
            j = 0;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.resource.content.MainResourcePackage.3
            @Override // java.lang.Runnable
            public void run() {
                MainResourcePackage mainResourcePackage = MainResourcePackage.this;
                mainResourcePackage.resourceManager.downloadApp(mainResourcePackage.getAppModel(), false, MainResourcePackage.this.new MainResourceDownloadCallback());
            }
        }, j);
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone() {
        if (this.mResourceContext == null) {
            RVLogger.w("MainResource parse need resource context");
        }
        super.onPrepareDone();
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        super.onVerifyError(parseFailedException);
        ResourceContext resourceContext = this.mResourceContext;
        Event eventError = ((EventTracker) RVProxy.get(EventTracker.class)).error(resourceContext != null ? resourceContext.getApp() : null, "ResVerifyFail", "mainPkgParseFailed");
        if (eventError != null) {
            eventError.putAttr(EventAttr.Key_resourceDBFailMsg, parseFailedException.getCode());
            eventError.putAttr(EventAttr.Key_resourceParseFailMsg, parseFailedException.getMessage());
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        ResourceContext resourceContext = this.mResourceContext;
        if (resourceContext == null) {
            throw new IllegalStateException("main resource cannot setup without app context");
        }
        if (resourceContext.getMainPackageInfo() == null) {
            throw new IllegalStateException("main resource cannot setup without app main packageInfo");
        }
        this.mOnlineHost = this.mResourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
        super.setup(z);
    }
}
