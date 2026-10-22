package com.alibaba.ariver.jsapi.resource;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.jsapi.R;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.DownloadInstallCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceJsApiBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24160a = "AriverRes:ResourceJsApi";
    private static final String b = "urls";
    private static final int c = 10;
    private static final int d = 11;
    private static final int e = 12;
    private static final int f = 5;
    private static final int g = 6;
    private final Map<String, FutureTask<JSONObject>> h = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(final String str, final ResourceContext resourceContext) throws InterruptedException {
        JSONObject configJSONObject;
        final AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str));
        boolean z = appModel == null;
        if (appModel != null && (configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("ta_addPkgResStricklyMatch")) != null) {
            String string = JSONUtils.getString(configJSONObject, str);
            if (!TextUtils.isEmpty(string)) {
                boolean z2 = RVResourceUtils.compareVersion(appModel.getAppVersion(), string) < 0;
                RVLogger.d(f24160a, "updateAndAddPkgRes got minVersion from cfg: " + string + ", current: " + appModel.getAppVersion());
                z = z2;
            }
        }
        RVLogger.d(f24160a, "updateAndAddPkgRes needForceUpdate: " + z);
        UpdateAppParam updateAppParam = new UpdateAppParam(str, null);
        updateAppParam.setForce(z);
        updateAppParam.setUpdateMode(z ? UpdateMode.SYNC_FORCE : UpdateMode.ASYNC);
        HashMap map = new HashMap();
        map.put(str, "*");
        updateAppParam.setRequestApps(map);
        IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(str, null);
        final JSONObject jSONObject = new JSONObject();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (iAppUpdaterCreateUpdater == null) {
            return b(str, resourceContext);
        }
        iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension.3
            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public void onError(UpdateAppException updateAppException) {
                RVLogger.d(ResourceJsApiBridgeExtension.f24160a, "updateAndAddPkgRes onError: " + updateAppException);
                if (appModel != null) {
                    jSONObject.putAll(ResourceJsApiBridgeExtension.this.b(str, resourceContext));
                } else {
                    jSONObject.putAll(BridgeResponse.newError(5, "update exception").get());
                }
                countDownLatch.countDown();
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public void onSuccess(List<AppModel> list) {
                RVLogger.d(ResourceJsApiBridgeExtension.f24160a, "updateAndAddPkgRes onSuccess");
                if (list != null) {
                    Iterator<AppModel> it = list.iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().getAppId(), str)) {
                            jSONObject.putAll(ResourceJsApiBridgeExtension.this.b(str, resourceContext));
                            countDownLatch.countDown();
                            return;
                        }
                    }
                }
                onError(new UpdateAppException("1", ""));
            }
        });
        countDownLatch.await(3L, TimeUnit.SECONDS);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(String str, ResourceContext resourceContext) {
        ResourcePackage resourcePackageAttach = ResourcePackagePool.getInstance().attach(str, resourceContext);
        if (resourcePackageAttach != null) {
            resourcePackageAttach.waitForSetup();
        }
        if (resourcePackageAttach == null || TextUtils.isEmpty(resourcePackageAttach.version())) {
            return BridgeResponse.newError(10, "resourcePackage == null").get();
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.addAll(resourcePackageAttach.keySet());
        jSONObject.put(b, (Object) jSONArray);
        return jSONObject;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse addPkgRes(@BindingNode(App.class) App app, @BindingParam(required = true, value = {"resAppId"}) final String str) {
        FutureTask<JSONObject> futureTask;
        final ResourceContext resourceContext = ResourceContextManager.getInstance().get(app.getAppId());
        if (resourceContext.containsPackage(str)) {
            RVLogger.d(f24160a, "addPkgRes but already contains package!");
            return BridgeResponse.SUCCESS;
        }
        synchronized (this.h) {
            if (this.h.get(str) != null) {
                futureTask = this.h.get(str);
            } else {
                FutureTask<JSONObject> futureTask2 = new FutureTask<>(new Callable<JSONObject>() { // from class: com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public JSONObject call() throws InterruptedException {
                        JSONObject jSONObjectA = ResourceJsApiBridgeExtension.this.a(str, resourceContext);
                        if (jSONObjectA == null) {
                            RVLogger.d(ResourceJsApiBridgeExtension.f24160a, "updateAndAddPkgRes return null, invalidate futureMap!");
                            ResourceJsApiBridgeExtension.this.h.remove(str);
                            return BridgeResponse.newError(10, "unknown error!").get();
                        }
                        if (jSONObjectA.get("error") != null) {
                            return jSONObjectA;
                        }
                        JSONArray jSONArray = jSONObjectA.getJSONArray(ResourceJsApiBridgeExtension.b);
                        if (jSONArray != null && jSONArray.size() != 0) {
                            return jSONObjectA;
                        }
                        RVLogger.d(ResourceJsApiBridgeExtension.f24160a, "updateAndAddPkgRes return urls empty, invalidate futureMap!");
                        ResourceJsApiBridgeExtension.this.h.remove(str);
                        return BridgeResponse.newError(11, "urls empty!").get();
                    }
                });
                ExecutorUtils.execute(ExecutorType.URGENT, futureTask2);
                this.h.put(str, futureTask2);
                futureTask = futureTask2;
            }
        }
        try {
            JSONObject jSONObject = futureTask.get();
            RVLogger.d(f24160a, "addPkgRes result: " + jSONObject);
            ExecutorUtils.execute(ExecutorType.IDLE, new Runnable() { // from class: com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension.2
                @Override // java.lang.Runnable
                public void run() {
                    resourceContext.updatePackageBrief();
                }
            });
            return new BridgeResponse(jSONObject);
        } catch (Throwable th) {
            return BridgeResponse.newError(10, "future get exception!" + th.getMessage());
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public JSONObject checkApp(@BindingParam({"appId"}) String str, @BindingParam({"stageCode"}) String str2) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            jSONObject.put("error", (Object) 2);
            return jSONObject;
        }
        RVAppInfoManager rVAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        if (rVAppInfoManager == null) {
            jSONObject.put("error", (Object) 10);
            return jSONObject;
        }
        AppModel appModel = rVAppInfoManager.getAppModel(AppInfoQuery.make(str));
        if (appModel == null) {
            jSONObject.put("error", (Object) "could not find appModel!");
            return jSONObject;
        }
        String appVersion = appModel.getAppVersion();
        String developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
        if (!TextUtils.isEmpty(developerVersion)) {
            jSONObject.put("package_nick", (Object) developerVersion);
        }
        jSONObject.put("version", (Object) appVersion);
        jSONObject.put("pkgstatus", (Object) (((RVResourceManager) RVProxy.get(RVResourceManager.class)).isAvailable(appModel) ? "installed" : "uninstall"));
        return jSONObject;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void installApp(@BindingParam({"appId"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_BridgeExtension_installApp_ + str);
            if (((RVResourceManager) RVProxy.get(RVResourceManager.class)) == null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(6, "NXResourceAppManager == null"));
            } else {
                a(str, bridgeCallback);
            }
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_BridgeExtension_installApp_ + str);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private void a(String str, final BridgeCallback bridgeCallback) {
        RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str));
        if (appModel == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(5, "NXResourceAppManager == null"));
            return;
        }
        if (rVResourceManager.isAvailable(appModel)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            return;
        }
        PackageInstallCallback packageInstallCallback = new PackageInstallCallback() { // from class: com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension.4
            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
            public void onResult(boolean z, String str2) {
                if (z) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                } else {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(6, LangResourceUtil.getString(R.string.ariver_jsapi_install_fail)));
                }
            }
        };
        if (rVResourceManager.isDownloaded(appModel)) {
            rVResourceManager.installApp(appModel, packageInstallCallback);
        } else {
            rVResourceManager.downloadApp(appModel, true, new DownloadInstallCallback(appModel, true, true, packageInstallCallback) { // from class: com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension.5
                @Override // com.alibaba.ariver.resource.api.DownloadInstallCallback, com.alibaba.ariver.resource.api.PackageDownloadCallback
                public void onFailed(String str2, int i, String str3) {
                    super.onFailed(str2, i, str3);
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(6, LangResourceUtil.getString(R.string.ariver_jsapi_download_fail) + str3));
                }
            });
        }
    }
}
