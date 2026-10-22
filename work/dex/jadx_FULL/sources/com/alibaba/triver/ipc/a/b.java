package com.alibaba.triver.ipc.a;

import android.app.ActivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.Triver;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.utils.CommonUtils;
import com.byazt.hv.TTDownloadField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25003a = "Triver:ServerIpcCommonHandler";
    private final Bundle b = new Bundle();

    private int a(long j) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        RVAppRecord appRecord = RVMain.getAppRecord(j);
        if (appRecord != null && appRecord.getActivityClz() != null) {
            if (appRecord.getRunningTaskInfo() != null) {
                return appRecord.getRunningTaskInfo().id;
            }
            String name = appRecord.getActivityClz().getName();
            ActivityManager activityManager = (ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE)) == null) {
                return -1;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.topActivity != null && TextUtils.equals(name, runningTaskInfo.topActivity.getClassName())) {
                    return runningTaskInfo.id;
                }
            }
        }
        return -1;
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        Object obj;
        Message message = ipcMessage.bizMsg;
        Bundle data = message.getData();
        if (data == null) {
            data = this.b;
        }
        long j = data.getLong(RVConstants.EXTRA_START_TOKEN);
        String string = data.getString("appId");
        int i = message.what;
        boolean z = true;
        if (i == 1) {
            Bundle bundle = (Bundle) BundleUtils.getParcelable(data, RVConstants.EXTRA_START_PARAMS);
            if (bundle != null && (obj = bundle.get(TRiverConstants.KEY_SUB_PROCESS)) != null) {
                z = true ^ Boolean.parseBoolean(obj.toString());
            }
            if (!z) {
                com.alibaba.triver.container.a.a().a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), 7500L);
            }
            com.alibaba.triver.container.a.a(string, a(j));
        }
        if (i == 2) {
            com.alibaba.triver.container.a.a().a(string, false);
            Bundle bundle2 = (Bundle) BundleUtils.getParcelable(data, RVConstants.EXTRA_START_PARAMS);
            if (TROrangeController.closeAppInfoUpdateOptimization()) {
                if (Triver.isDataSynced()) {
                    return;
                }
                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.ipc.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.alibaba.triver.appinfo.core.b.b();
                        Triver.setDataSynced(true);
                        long cacheClearCheckTime = CommonUtils.getCacheClearCheckTime();
                        com.alibaba.triver.appinfo.core.b.a(cacheClearCheckTime);
                        PluginInfoCenter.a(cacheClearCheckTime);
                    }
                });
                return;
            } else {
                if (TextUtils.isEmpty(string) || bundle2 == null) {
                    return;
                }
                new com.alibaba.triver.resource.a(string, bundle2).a();
                return;
            }
        }
        if (i == 105) {
            com.alibaba.triver.container.a.a().a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), data.getBundle(com.alibaba.triver.container.a.e));
            return;
        }
        if (i == 202) {
            com.alibaba.triver.container.a.d(string);
            return;
        }
        if (i == 203) {
            a(data);
            return;
        }
        switch (i) {
            case 101:
                com.alibaba.triver.container.a.a().a(string);
                break;
            case 102:
                com.alibaba.triver.container.a.a().b(string);
                break;
            case 103:
                Triver.openApp(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), (Uri) data.getParcelable("openUri"), data.getBundle("openParams"));
                break;
        }
    }

    private void a(final Bundle bundle) {
        if (bundle == null || !bundle.containsKey("stage")) {
            return;
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.ipc.a.b.2
            /* JADX WARN: Code duplicated, block: B:71:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                String stackTraceString;
                try {
                    if (new File("/data/local/tmp/.apm_online").exists()) {
                        String string = bundle.getString("stage");
                        String string2 = bundle.getString("extra");
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        JSONArray array = JSON.parseArray(string);
                        FileOutputStream fileOutputStream = null;
                        JSONObject object = !TextUtils.isEmpty(string) ? JSON.parseObject(string2) : null;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", (Object) TriverLogProxyImpl.TLOG_MODULE);
                        jSONObject.put("stage", (Object) array);
                        jSONObject.put("extra", (Object) object);
                        jSONObject.put("url", (Object) "");
                        jSONObject.put("pageName", (Object) "");
                        File file = new File(Environment.getExternalStorageDirectory(), AlibcProtocolConstant.APPLINK_PACKAGE_NAME);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(file, "APM_ONLINE");
                        if (!file2.exists()) {
                            try {
                                file2.createNewFile();
                            } catch (IOException e) {
                                RVLogger.e(b.f25003a, "log2TMQ error", e);
                            }
                        }
                        try {
                            if (file2.exists()) {
                                try {
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, true);
                                    try {
                                        String property = System.getProperty("line.separator");
                                        fileOutputStream2.write(property.getBytes());
                                        fileOutputStream2.write(jSONObject.toString().getBytes());
                                        fileOutputStream2.write(property.getBytes());
                                        fileOutputStream2.flush();
                                        fileOutputStream2.close();
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e2) {
                                            stackTraceString = Log.getStackTraceString(e2);
                                            RVLogger.w(stackTraceString);
                                            return;
                                        }
                                    } catch (FileNotFoundException e3) {
                                        e = e3;
                                        fileOutputStream = fileOutputStream2;
                                        RVLogger.e(b.f25003a, "log2TMQ error", e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e4) {
                                                stackTraceString = Log.getStackTraceString(e4);
                                                RVLogger.w(stackTraceString);
                                                return;
                                            }
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        fileOutputStream = fileOutputStream2;
                                        RVLogger.e(b.f25003a, "log2TMQ error", e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e6) {
                                                stackTraceString = Log.getStackTraceString(e6);
                                                RVLogger.w(stackTraceString);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e7) {
                                                RVLogger.w(Log.getStackTraceString(e7));
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (FileNotFoundException e8) {
                                    e = e8;
                                } catch (IOException e9) {
                                    e = e9;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e10) {
                    RVLogger.e(b.f25003a, "log2TMQ error", e10);
                }
            }
        });
    }
}
