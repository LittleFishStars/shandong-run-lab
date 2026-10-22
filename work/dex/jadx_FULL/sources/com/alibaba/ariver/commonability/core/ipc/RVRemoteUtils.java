package com.alibaba.ariver.commonability.core.ipc;

import android.os.Bundle;
import android.os.Message;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RVRemoteUtils {
    public static final String BIZ_COMMON_ABILITY = "common-ability";
    public static final String PARAM_CALL_BY_MAIN_PROCESS = "call_by_main_process";
    public static final String PARAM_REMOTE_HANDLER = "remote_handler";
    public static final String PARAM_REMOTE_TOKEN = "remote_token";
    public static final String TAG = "RVRemoteUtils";
    public static final Bundle UNKNOWN_ERROR = Bundle.EMPTY;
    public static final int WHAT_REMOTE = 109915;

    public static void call(Page page, Class<? extends RemoteHandler> cls, RemoteCallback remoteCallback) {
        call(page != null ? page.getApp() : null, cls, remoteCallback);
    }

    public static void call(App app, Class<? extends RemoteHandler> cls, RemoteCallback remoteCallback) {
        call(app, new Bundle(), cls, remoteCallback);
    }

    public static void call(Page page, Bundle bundle, Class<? extends RemoteHandler> cls, RemoteCallback remoteCallback) {
        call(page != null ? page.getApp() : null, bundle, cls, remoteCallback);
    }

    public static void call(App app, Bundle bundle, Class<? extends RemoteHandler> cls, RemoteCallback remoteCallback) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (cls != null) {
            bundle.putString(PARAM_REMOTE_HANDLER, cls.getName());
        }
        call(app, bundle, remoteCallback);
    }

    public static void call(Page page, Bundle bundle, RemoteCallback remoteCallback) {
        call(page != null ? page.getApp() : null, bundle, remoteCallback);
    }

    public static void call(App app, Bundle bundle, RemoteCallback remoteCallback) {
        if (app == null || bundle == null) {
            if (remoteCallback != null) {
                remoteCallback.callback(UNKNOWN_ERROR);
                return;
            }
            return;
        }
        if (!bundle.containsKey(PARAM_REMOTE_HANDLER)) {
            if (remoteCallback != null) {
                remoteCallback.callback(UNKNOWN_ERROR);
                return;
            }
            return;
        }
        b bVar = b.f23946a;
        long jIncrementAndGet = bVar.d.incrementAndGet();
        bVar.c.put(Long.valueOf(jIncrementAndGet), remoteCallback);
        bundle.putLong(PARAM_REMOTE_TOKEN, jIncrementAndGet);
        bundle.putLong(RVConstants.EXTRA_START_TOKEN, app.getStartToken());
        bundle.putString("appId", app.getAppId());
        if (ProcessUtils.isMainProcess()) {
            bundle.putBoolean(PARAM_CALL_BY_MAIN_PROCESS, true);
            IpcMessage ipcMessage = new IpcMessage();
            Message message = new Message();
            ipcMessage.bizMsg = message;
            message.setData(bundle);
            c.f23947a.handleMessage(ipcMessage);
            return;
        }
        if (!bVar.b.get()) {
            bVar.b.set(true);
            ClientMsgReceiver.getInstance().registerBizHandler(BIZ_COMMON_ABILITY, a.f23945a);
            ((RemotePoint) ExtensionPoint.as(RemotePoint.class).node(app).create()).initEnvironment();
        }
        IpcClientKernelUtils.sendMsgToServer(BIZ_COMMON_ABILITY, WHAT_REMOTE, bundle);
    }
}
