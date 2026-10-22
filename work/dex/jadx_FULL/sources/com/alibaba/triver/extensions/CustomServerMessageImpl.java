package com.alibaba.triver.extensions;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.extensions.CustomServerMsgExtension;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.triver.point.OnPreloadPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomServerMessageImpl implements CustomServerMsgExtension {
    public static final int CUSTOM_SERVER_MSG_DATA_PREFETCH = 1;
    public static final String SUBTYPE = "customServerMsgSubtype";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24948a = "CustomServerMessageImpl";

    private void a(AppNode appNode, Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("appInfo");
        String string = bundle.getString("url");
        long j = bundle.getLong(RVConstants.EXTRA_START_TOKEN);
        Bundle bundle2 = bundle.getBundle(RVConstants.EXTRA_START_PARAMS);
        if (parcelable instanceof AppModel) {
            ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).dataPrefetch(appNode, string, j, (AppModel) parcelable, bundle2);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.app.extensions.CustomServerMsgExtension
    public void onGetMessage(AppNode appNode, IpcMessage ipcMessage) {
        try {
            Message message = ipcMessage.bizMsg;
            RVLogger.d(f24948a, "onGetMessage handle ipc msg: " + message.what + " " + message.arg1 + " data: " + message.getData() + " fromPending: ");
            Bundle data = message.getData();
            if (data.getInt(SUBTYPE) != 1) {
                return;
            }
            a(appNode, data);
        } catch (Exception e) {
            RVLogger.e(f24948a, e);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
