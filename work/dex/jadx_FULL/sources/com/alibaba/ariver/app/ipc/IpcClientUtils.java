package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcClientUtils {
    public static final String LOG_TAG = "AriverInt:IpcClient";

    public static void sendMsgToServerByApp(App app, int i, @Nullable Bundle bundle) {
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putLong(RVConstants.EXTRA_START_TOKEN, app.getStartToken());
        bundle2.putString("appId", app.getAppId());
        IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, i, bundle2);
    }
}
