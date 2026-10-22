package com.alibaba.ariver.kernel.ipc.uniform;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UniformIpcUtils {
    public static final String TAG = "AriverKernel:RemoteCall";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IPCContextManager f24295a;
    private static IIPCManager b;

    @Nullable
    public static IPCContextManager getIpcContextManager() {
        if (f24295a == null) {
            synchronized (UniformIpcUtils.class) {
                if (f24295a == null) {
                    try {
                        f24295a = IPCApiFactory.getIPCContextManager();
                    } catch (Throwable th) {
                        RVLogger.e(TAG, Log.getStackTraceString(th));
                    }
                }
            }
        }
        return f24295a;
    }

    @Nullable
    public static IIPCManager getIpcManager() {
        if (b == null) {
            synchronized (UniformIpcUtils.class) {
                if (b == null) {
                    try {
                        b = IPCApiFactory.getIPCManager();
                    } catch (Throwable th) {
                        RVLogger.e(TAG, Log.getStackTraceString(th));
                    }
                }
            }
        }
        return b;
    }

    @Nullable
    public static ServiceBeanManager getServiceBeanManager() {
        IPCContextManager ipcContextManager = getIpcContextManager();
        if (ipcContextManager != null) {
            return ipcContextManager.getServiceBeanManager();
        }
        return null;
    }

    public static void init(Context context, IIPCManager iIPCManager) {
        IPCContextManager ipcContextManager = getIpcContextManager();
        if (ipcContextManager != null) {
            ipcContextManager.init(context, iIPCManager);
        }
    }
}
