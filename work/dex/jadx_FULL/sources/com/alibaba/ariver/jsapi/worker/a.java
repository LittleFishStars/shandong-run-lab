package com.alibaba.ariver.jsapi.worker;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginParam;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24191a = "AriverAPI:PluginLoader";
    private static final long b = 86400000;
    private static final String c = "requestPluginModel_";
    private PluginModel d;

    public PluginModel a(String str, String str2, String str3, App app, ApiContext apiContext) {
        String string = ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(str, c + str2);
        RVLogger.d(f24191a, "requestPluginModel got rate: " + string);
        PluginModel pluginModelA = a(str2, str3, string);
        if (pluginModelA != null) {
            return pluginModelA;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(app.getAppId(), app.getStartParams());
        if (iAppUpdaterCreateUpdater == null) {
            return null;
        }
        UpdatePluginParam updatePluginParam = new UpdatePluginParam(app.getAppId(), str2);
        updatePluginParam.setRequiredVersion(str3);
        updatePluginParam.setApp(app);
        updatePluginParam.setApiContext(apiContext);
        iAppUpdaterCreateUpdater.updatePlugin(updatePluginParam, new UpdatePluginCallback() { // from class: com.alibaba.ariver.jsapi.worker.a.1
            @Override // com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback
            public void onError(UpdateAppException updateAppException) {
                countDownLatch.countDown();
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback
            public void onSuccess(PluginModel pluginModel) {
                a.this.d = pluginModel;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (Throwable unused) {
            RVLogger.w(f24191a, "AWAIT EXCEPTION!");
        }
        RVLogger.d(f24191a, "requestPlugin pluginId: " + str2 + " requiredVersion: " + str3 + " result: " + this.d);
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(str2);
        kVStorageProxy.putString(str, sb.toString(), str3 + "," + System.currentTimeMillis());
        return this.d;
    }

    @Nullable
    private PluginModel a(String str, String str2, String str3) {
        if (a()) {
            RVLogger.d(f24191a, "plugin " + str + " downgrade relation check" + str2);
            PluginModel requiredPlugin = ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).getRequiredPlugin(str, str2);
            if (requiredPlugin != null) {
                RVLogger.d(f24191a, "requestPluginModel in req rate, just use requiredVersion: " + str2);
                return requiredPlugin;
            }
            RVLogger.d(f24191a, "requestPluginModel in req rate, but not found version: " + str2);
            return null;
        }
        if (str3 != null && str3.length() != 0) {
            String[] strArrSplit = str3.split(",");
            if (strArrSplit.length < 2) {
                return null;
            }
            String str4 = strArrSplit[0];
            long jLongValue = Long.valueOf(strArrSplit[1]).longValue();
            if (TextUtils.equals(str2, str4)) {
                if (System.currentTimeMillis() - jLongValue > 86400000) {
                    RVLogger.d(f24191a, "requestPluginModel out of req rate, just request!");
                } else {
                    PluginModel requiredPlugin2 = ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).getRequiredPlugin(str, str2);
                    if (requiredPlugin2 != null) {
                        RVLogger.d(f24191a, "requestPluginModel in req rate, just use requiredVersion: " + str2);
                        return requiredPlugin2;
                    }
                    RVLogger.d(f24191a, "requestPluginModel in req rate, but not found version: " + str2);
                }
            }
        }
        return null;
    }

    private boolean a() {
        return "true".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("downgradePluginRelationCheck", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
    }
}
