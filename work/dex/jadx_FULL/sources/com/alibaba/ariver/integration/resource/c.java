package com.alibaba.ariver.integration.resource;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.proxy.RVSinglePageAppProxy;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.content.ResourceUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends a {
    private static final String e = "AriverInt:PrepareSPACallbackImpl";
    private com.alibaba.ariver.integration.b f;
    private Activity g;

    public c(Activity activity, RVAppRecord rVAppRecord, PrepareContext prepareContext, com.alibaba.ariver.integration.b bVar) {
        super(rVAppRecord, prepareContext);
        this.f = bVar;
        this.g = activity;
    }

    @Override // com.alibaba.ariver.integration.resource.a, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFail(PrepareData prepareData, PrepareException prepareException) {
        if (this.f != null) {
            RVLogger.e(e, "PrepareSPACallbackImpl prepareFail: ", prepareException);
            if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_createPageCallbackNull", "yes"))) {
                this.f.a(null);
            }
        }
    }

    @Override // com.alibaba.ariver.integration.resource.a, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void showLoading(boolean z, EntryInfo entryInfo) {
    }

    @Override // com.alibaba.ariver.integration.resource.a, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        if (this.c) {
            return;
        }
        this.c = true;
        Bundle sceneParams = this.b.getSceneParams();
        AppModel appModel = prepareCallbackParam.appInfo;
        if (appModel != null) {
            sceneParams.putParcelable("appInfo", appModel);
            this.b.setAppModel(prepareCallbackParam.appInfo);
        }
        if (!TextUtils.isEmpty(this.d.appType)) {
            sceneParams.putString("appType", this.d.appType);
        }
        EntryInfo entryInfo = this.d.getEntryInfo();
        if (entryInfo == null) {
            entryInfo = ResourceUtils.getEntryInfo(prepareCallbackParam.appInfo);
        }
        if (entryInfo != null) {
            sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        }
        sceneParams.putLong(RVConstants.EXTRA_PREPARE_START_CLIENT_TIME, SystemClock.elapsedRealtime());
        Bundle bundle = prepareCallbackParam.startParams;
        Bundle sceneParams2 = this.b.getSceneParams();
        App appStartApp = ((AppManager) RVProxy.get(AppManager.class)).startApp(BundleUtils.getString(bundle, "appId"), bundle, sceneParams2);
        appStartApp.addPageReadyListener(new App.PageReadyListener() { // from class: com.alibaba.ariver.integration.resource.c.1
            @Override // com.alibaba.ariver.app.api.App.PageReadyListener
            public void onPageReady(Page page) {
                RVLogger.d(c.e, "startApp PageReadyListener onPageReady " + page);
                if (c.this.f != null) {
                    c.this.f.a(page);
                }
            }
        });
        appStartApp.bindContext(((RVSinglePageAppProxy) RVProxy.get(RVSinglePageAppProxy.class)).createAppContext(appStartApp, this.g));
        appStartApp.start();
    }
}
