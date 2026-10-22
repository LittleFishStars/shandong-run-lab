package com.alibaba.triver.impl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.trace.b;
import com.alibaba.triver.trace.c;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverSnapshotProxyImpl implements ISnapshotProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24978a = "triver_snapshot";

    private static File a(App app) {
        if (app == null) {
            return null;
        }
        File file = new File(a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), app), app.getAppId());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy
    public String getSnapshotExtDir(App app) {
        if (app == null || TextUtils.isEmpty(app.getAppId())) {
            return null;
        }
        return a(app).getAbsolutePath();
    }

    @Override // com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy
    public boolean isSnapshotEnable(App app) {
        return TROrangeController.isSnapshotEnable(app);
    }

    @Override // com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy
    public boolean isSnapshotFileExist(App app) {
        if (TROrangeController.isSnapshotEnable(app) && app != null) {
            File file = new File(a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), app), app.getAppId());
            if (file.exists()) {
                return file.listFiles().length > 0 || !TBShopOrangeController.enableSnapshotRenderPreload();
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy
    public void snapshotHit(App app) {
        if (app != null) {
            app.putBooleanValue(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT, true);
        }
        b.a(c.h, c.ak, TRiverUtils.getSessionId(app), app, (JSONObject) null);
        final Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext == null || !CommonUtils.isApkDebug(applicationContext)) {
            return;
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.impl.TriverSnapshotProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(applicationContext, "命中Snapshot", 1).show();
            }
        });
    }

    private static String a(Context context, App app) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        String str = File.separator;
        sb.append(str);
        sb.append(f24978a);
        sb.append(str);
        sb.append(app.getAppId());
        sb.append(str);
        sb.append(((AppModel) app.getData(AppModel.class)).getAppVersion());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
