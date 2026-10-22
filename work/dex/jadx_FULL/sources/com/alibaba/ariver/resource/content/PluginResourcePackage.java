package com.alibaba.ariver.resource.content;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.PluginPackageParsedPoint;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.parser.ParseContext;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginResourcePackage extends BaseStoragePackage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24445a;
    private boolean b;
    private PluginModel c;
    private ResourceContext d;
    private RVPluginResourceManager e = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
    private String f;

    public class MyPluginDownloadCallback implements PluginDownloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PluginModel f24446a;

        public MyPluginDownloadCallback(PluginModel pluginModel) {
            this.f24446a = pluginModel;
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onFailed(int i, String str) {
            RVLogger.w(PluginResourcePackage.this.f24445a, "onFailed " + i + " " + str);
            PluginResourcePackage.this.onPrepareDone();
            PluginResourcePackage.this.onParseDone();
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSuccess() {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.content.PluginResourcePackage.MyPluginDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).installPlugins(Collections.singletonList(MyPluginDownloadCallback.this.f24446a), new PluginInstallCallback() { // from class: com.alibaba.ariver.resource.content.PluginResourcePackage.MyPluginDownloadCallback.1.1
                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onFailed(int i, String str) {
                            RVLogger.w(PluginResourcePackage.this.f24445a, "installPlugins onFailed " + i + ", " + str);
                            PluginResourcePackage.this.onPrepareDone();
                            PluginResourcePackage.this.onParseDone();
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSuccess(List<Pair<PluginModel, String>> list) {
                            RVLogger.d(PluginResourcePackage.this.f24445a, "installPlugins onSuccess");
                            MyPluginDownloadCallback myPluginDownloadCallback = MyPluginDownloadCallback.this;
                            PluginResourcePackage.this.parseContent(myPluginDownloadCallback.f24446a.getAppId(), PluginResourcePackage.this.e.getInstallPath(MyPluginDownloadCallback.this.f24446a));
                        }
                    });
                }
            });
        }
    }

    public PluginResourcePackage(@NonNull PluginModel pluginModel, @NonNull ResourceContext resourceContext) {
        this.c = pluginModel;
        this.d = resourceContext;
        this.f24445a = "AriverRes:PluginPackage_" + pluginModel.getAppId() + LoginConstants.UNDER_LINE + pluginModel.getVersion();
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        App app;
        AppConfigModel fromJSON;
        super.afterParsePackage(parseContext);
        ResourceContext resourceContext = this.d;
        if (resourceContext == null || (app = resourceContext.getApp()) == null) {
            return;
        }
        Resource resource = get(ResourceQuery.asUrl(RVConstants.FILE_APP_CONFIG).setNeedAutoCompleteHost());
        if (resource != null && (fromJSON = AppConfigModel.parseFromJSON(resource.getBytes())) != null && fromJSON.getPageLaunchParams() != null) {
            ((PluginParamModel) app.getData(PluginParamModel.class, true)).putPluginConfig(this.c.getAppId(), fromJSON);
        }
        ((PluginPackageParsedPoint) ExtensionPoint.as(PluginPackageParsedPoint.class).node(app).create()).onPluginParsed(this.d.getMainPackageInfo(), this.c, this);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String appId() {
        return this.c.getAppId();
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.onlineHost = this.f;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(@NonNull ResourceQuery resourceQuery) {
        if (resourceQuery.isNeedAutoCompleteHost() && !TextUtils.isEmpty(this.f)) {
            resourceQuery.pureUrl = FileUtils.combinePath(this.f, resourceQuery.pureUrl);
        }
        return super.get(resourceQuery);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public String getLogTag() {
        return this.f24445a;
    }

    public PluginModel getPluginModel() {
        return this.c;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return false;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public boolean needWaitSetupWhenGet() {
        return true;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void reload() {
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        ResourceContext resourceContext = this.d;
        if (resourceContext == null) {
            throw new IllegalStateException("plugin resource cannot setup without app context");
        }
        if (resourceContext.getMainPackageInfo() == null) {
            throw new IllegalStateException("plugin resource cannot setup without app main packageInfo");
        }
        if (this.b) {
            RVLogger.w(this.f24445a, "already setupted!");
            return;
        }
        this.f = FileUtils.combinePath(this.d.getMainPackageInfo().getAppInfoModel().getVhost(), "__plugins__/" + this.c.getAppId());
        this.b = true;
        RVLogger.d(this.f24445a, "begin setup with lock: " + z);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            RVLogger.w(this.f24445a, "prepareContent with lock!");
        }
        List<PluginModel> listSingletonList = Collections.singletonList(this.c);
        boolean zIsAvailable = this.e.isAvailable(listSingletonList);
        RVLogger.d(this.f24445a, "prepareContent appId:" + this.c.getAppId() + " appVersion " + this.c.getVersion() + " installed:" + zIsAvailable);
        if (zIsAvailable) {
            parseContent(this.c.getAppId(), this.e.getInstallPath(this.c));
        } else {
            this.e.downloadPlugins(listSingletonList, new MyPluginDownloadCallback(this.c));
        }
        if (z) {
            try {
                getSetupLock().await(5L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                RVLogger.w(this.f24445a, "prepareContent block error", e);
            }
            RVLogger.d(this.f24445a, "prepareContent block " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String version() {
        return this.c.getDeveloperVersion();
    }
}
