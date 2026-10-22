package com.alibaba.ariver.commonability.core.ipc;

import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RemoteExtension implements RemotePoint {
    @Override // com.alibaba.ariver.commonability.core.ipc.RemotePoint
    @Remote
    public void initEnvironment() {
        RVLogger.d(RVRemoteUtils.TAG, "initEnvironment");
        c.f23947a.a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
