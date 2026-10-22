package com.alibaba.ariver.ipc.uniform;

import android.os.DeadObjectException;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResultDesc;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IPCCallable {
    private static final String TAG = "AriverKernel:RemoteCall";
    private Lock callLock = new ReentrantLock();
    private IIPCManager ipcManager;

    public IPCCallable(IIPCManager iIPCManager) {
        this.ipcManager = iIPCManager;
    }

    public IPCResult call(IPCParameter iPCParameter) {
        try {
            this.callLock.lock();
            try {
                IPCResult iPCResultCall = this.ipcManager.call(iPCParameter);
                this.callLock.unlock();
                if (iPCResultCall != null) {
                    return iPCResultCall;
                }
                throw new IllegalStateException("remote return ipcResult is null!");
            } catch (Throwable th) {
                this.callLock.unlock();
                throw th;
            }
        } catch (Exception e) {
            RVLogger.e("AriverKernel:RemoteCall", "IPCCallable call exception!", e);
            IPCResult iPCResult = new IPCResult();
            if (e instanceof DeadObjectException) {
                iPCResult.resultCode = 201;
                iPCResult.resultMsg = IPCResultDesc.DEAD_OBJECT_MSG;
            } else {
                iPCResult.resultCode = 200;
                iPCResult.resultMsg = e.getMessage();
            }
            return iPCResult;
        }
    }
}
