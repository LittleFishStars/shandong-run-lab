package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IPCManagerService extends IIPCManager.Stub {
    private static final String TAG = "AriverKernel:RemoteCall";
    private LocalCallManager localCallManager;

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IIPCManager
    public IPCResult call(IPCParameter iPCParameter) {
        RVLogger.d("AriverKernel:RemoteCall", "IPCManagerService IPCParameter=[" + iPCParameter.toString() + "]");
        return this.localCallManager.call(iPCParameter);
    }

    public void setLocalCallManager(LocalCallManager localCallManager) {
        this.localCallManager = localCallManager;
    }
}
