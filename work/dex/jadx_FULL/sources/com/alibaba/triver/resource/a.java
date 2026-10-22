package com.alibaba.triver.resource;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.triver.Triver;
import com.alibaba.triver.appinfo.core.AppInfoStrategy;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IZCacheProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25153a;
    private Bundle b;

    public a(String str, Bundle bundle) {
        this.f25153a = str;
        this.b = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Bundle bundle = this.b;
            if (bundle != null && !CommonUtils.isMiniAppDebug(bundle)) {
                if (AppInfoStrategy.ASYNC_LOAD.getName().equals(this.b.getString("mainRequestStrategy"))) {
                    UpdateAppParam updateAppParam = new UpdateAppParam(this.f25153a, "*");
                    updateAppParam.setForce(true);
                    updateAppParam.setUpdateMode(UpdateMode.ASYNC);
                    updateAppParam.setQueryScene(AppInfoScene.ONLINE);
                    updateAppParam.setExtras(this.b);
                    IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(this.f25153a, this.b);
                    if (iAppUpdaterCreateUpdater != null) {
                        iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.triver.resource.a.2
                            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                            public void onError(UpdateAppException updateAppException) {
                                RVLogger.e("AriverTriver:AppInfoCenter", a.this.f25153a + " async update error!", updateAppException);
                            }

                            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                            public void onSuccess(List<AppModel> list) {
                                AppModel next;
                                if (list != null) {
                                    Iterator<AppModel> it = list.iterator();
                                    do {
                                        if (!it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                    } while (!TextUtils.equals(a.this.f25153a, next.getAppId()));
                                    if (next == null) {
                                        RVLogger.e("AriverTriver:AppInfoCenter", a.this.f25153a + " async update error!");
                                        return;
                                    }
                                    RVLogger.d("AriverTriver:AppInfoCenter", a.this.f25153a + " async update success!");
                                    IZCacheProxy iZCacheProxy = (IZCacheProxy) RVProxy.get(IZCacheProxy.class, true);
                                    if (iZCacheProxy != null) {
                                        iZCacheProxy.updatePackRemoteDiscOnly(next);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e("AriverTriver:AppInfoCenter", this.f25153a + " async update error!", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (TROrangeController.closeAppxUpdate()) {
            return;
        }
        AppInfoStrategy appInfoStrategyA = com.alibaba.triver.appinfo.core.b.a(RVConstants.TINY_WEB_COMMON_APPID, "*");
        if (appInfoStrategyA != null) {
            RVLogger.d("AriverTriver:appInfoCenter", "appxInfoStrategy:" + appInfoStrategyA.getName());
        }
        if (appInfoStrategyA != AppInfoStrategy.NONE) {
            UpdateAppParam updateAppParam = new UpdateAppParam(RVConstants.TINY_WEB_COMMON_APPID, "*");
            updateAppParam.setForce(true);
            updateAppParam.setExtras(this.b);
            updateAppParam.setUpdateMode(UpdateMode.SYNC_FORCE);
            IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(RVConstants.TINY_WEB_COMMON_APPID, this.b);
            if (iAppUpdaterCreateUpdater == null) {
                RVLogger.e(ResourceUtils.TAG, "cannot find app updater for 66666692!!!");
            } else {
                iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.triver.resource.a.3
                    @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                    public void onError(UpdateAppException updateAppException) {
                        RVLogger.e("AriverTriver:appInfoCenter", "appx async update error!");
                    }

                    @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                    public void onSuccess(List<AppModel> list) {
                        AppModel next;
                        if (list != null) {
                            Iterator<AppModel> it = list.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                            } while (!TextUtils.equals(RVConstants.TINY_WEB_COMMON_APPID, next.getAppId()));
                            if (next == null) {
                                RVLogger.e("AriverTriver:appInfoCenter", "appx async update error!");
                                return;
                            }
                            RVLogger.d("AriverTriver:appInfoCenter", "appx async update success!");
                            IZCacheProxy iZCacheProxy = (IZCacheProxy) RVProxy.get(IZCacheProxy.class, true);
                            if (iZCacheProxy != null) {
                                iZCacheProxy.updatePackRemoteDiscOnly(next);
                            }
                        }
                    }
                });
            }
        }
    }

    public void a() {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.resource.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    List<RVAppRecord> appRecords = RVMain.getAppRecords(a.this.f25153a);
                    if (appRecords == null || appRecords.size() <= 1) {
                        a.this.b();
                    }
                    a.this.c();
                    if (Triver.isDataSynced()) {
                        return;
                    }
                    com.alibaba.triver.appinfo.core.b.b();
                    Triver.setDataSynced(true);
                    long cacheClearCheckTime = com.alibaba.triver.utils.CommonUtils.getCacheClearCheckTime();
                    com.alibaba.triver.appinfo.core.b.a(cacheClearCheckTime);
                    PluginInfoCenter.a(cacheClearCheckTime);
                } catch (Exception e) {
                    RVLogger.e("AppDestroyChecker", "onDestroyInMainProcess error", e);
                }
            }
        });
    }
}
