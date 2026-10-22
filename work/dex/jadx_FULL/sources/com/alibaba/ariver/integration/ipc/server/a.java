package com.alibaba.ariver.integration.ipc.server;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.fastjson.JSONObject;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24081a = "AriverInt:IpcServer";
    private final Bundle b = new Bundle();

    private void a(long j, int i) {
        RVLogger.d("AriverInt:IpcServer", "handleAppStarted, token: " + j + " lpid: " + i);
        RVAppRecord appRecord = RVMain.getAppRecord(j);
        if (appRecord != null) {
            appRecord.setReceivedRemoteReady(i);
            a(appRecord);
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        RVAppRecord appRecord;
        Message message = ipcMessage.bizMsg;
        Bundle data = message.getData();
        if (data == null) {
            data = this.b;
        }
        int i = data.getInt(IpcMessageConstants.EXTRA_LPID);
        String string = data.getString("appId");
        long j = data.getLong(RVConstants.EXTRA_START_TOKEN);
        RVLogger.d("AriverInt:IpcServer", "MainAppBizHandler received msg what: " + message.what + " lpid: " + i + " token: " + j);
        int i2 = message.what;
        if (i2 == 1) {
            a(j, i);
            Bundle bundle = (Bundle) BundleUtils.getParcelable(data, RVConstants.EXTRA_START_PARAMS);
            BundleUtils.tryUnparcel(bundle);
            long j2 = BundleUtils.getLong(bundle, RVStartParams.KEY_RESTART_FROM_TOKEN);
            if (j2 <= 0 || (appRecord = RVMain.getAppRecord(j2)) == null) {
                return;
            }
            appRecord.finishClient();
            return;
        }
        if (i2 == 2) {
            a(j);
            return;
        }
        if (i2 != 7) {
            if (i2 != 8) {
                return;
            }
            Bundle bundle2 = (Bundle) BundleUtils.getParcelable(data, RVConstants.EXTRA_START_PARAMS);
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean(RVStartParams.KEY_RESTART, true);
            if (RVMain.getAppRecord(j) != null) {
                bundle2.putLong(RVStartParams.KEY_RESTART_FROM_TOKEN, j);
                bundle2.putInt(RVStartParams.KEY_RESTART_FROM_LPID, i);
            }
            RVMain.startApp(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get(), string, bundle2, null);
            return;
        }
        String string2 = data.getString("clientId");
        JSONObject jSONObjectUnmarshallJSONObject = JSONUtils.unmarshallJSONObject(data.getByteArray(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_DATA));
        boolean z = data.getBoolean(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_KEEP);
        SendToNativeCallback sendToNativeCallbackA = e.a().a(j, string2, z);
        RVLogger.d("AriverInt:IpcServer", "MainAppBizHandler, CLIENT_MSG_REMOTE_CALLBACK find callback for " + string2 + " " + sendToNativeCallbackA);
        if (sendToNativeCallbackA != null) {
            sendToNativeCallbackA.onCallback(jSONObjectUnmarshallJSONObject, z);
        }
    }

    private void a(RVAppRecord rVAppRecord) {
        try {
            if (rVAppRecord.getActivityClz() == null) {
                return;
            }
            String name = rVAppRecord.getActivityClz().getName();
            ActivityManager activityManager = (ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null) {
                return;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
                if (runningTaskInfo.topActivity != null && TextUtils.equals(name, runningTaskInfo.topActivity.getClassName())) {
                    rVAppRecord.runningTaskInfo = runningTaskInfo;
                    if (runningTaskInfo.baseActivity != null) {
                        rVAppRecord.isTaskRoot = TextUtils.equals(name, runningTaskInfo.baseActivity.getClassName());
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            RVLogger.w("AriverInt:IpcServer", "findRecordTaskForBaseActivity exception!", th);
        }
    }

    private void a(long j) {
        RVLogger.d("AriverInt:IpcServer", "handleAppDestroy, token: " + j);
        IpcChannelManager.getInstance().unRegisterClientChannel(j);
    }
}
