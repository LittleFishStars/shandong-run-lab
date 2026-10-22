package com.alibaba.ariver.ipc;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class RemoteCallClient {
    private static final String TAG = "AriverKernel:RemoteCall";
    private static AtomicBoolean ipcInited = new AtomicBoolean(false);
    private static boolean hasPrepared = false;

    @SuppressLint({"StaticFieldLeak"})
    private static IpcCallClientHelper sIpcCallClientHelper = new IpcCallClientHelper();

    public static class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IIPCManager f24095a = null;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper onServiceConnected");
            if (iBinder == null) {
                RemoteCallClient.sIpcCallClientHelper.rebind();
                return;
            }
            this.f24095a = IIPCManager.Stub.asInterface(iBinder);
            RemoteCallClient.sIpcCallClientHelper.setBind(true);
            try {
                UniformIpcUtils.init(ProcessUtils.getContext(), this.f24095a);
                RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper init ipcManager " + this.f24095a);
            } catch (Exception e) {
                RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper init error " + Log.getStackTraceString(e));
            }
            RemoteCallClient.ipcInited.set(true);
            synchronized (RemoteCallClient.class) {
                RemoteCallClient.class.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper onServiceDisconnected");
            this.f24095a = null;
            RemoteCallClient.sIpcCallClientHelper.setBind(false);
            RemoteCallClient.sIpcCallClientHelper.rebind();
            RemoteCallClient.ipcInited.set(false);
        }
    }

    public static void bindContext(Context context) {
        if (!ProcessUtils.isMainProcess()) {
            sIpcCallClientHelper.bindContext(context);
            return;
        }
        RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper bindContext must be in lite process. " + Log.getStackTraceString(new Throwable()));
    }

    @WorkerThread
    public static <T> T getIpcProxy(Class<T> cls) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            IpcCallClientHelper ipcCallClientHelper = sIpcCallClientHelper;
            if (ipcCallClientHelper == null || !ipcCallClientHelper.isBind()) {
                throw new IllegalStateException("IpcCallClientHelper.getIpcProxy should not call on main thread!!!");
            }
            RVLogger.w("AriverKernel:RemoteCall", "IpcCallClientHelper.getIpcProxy should not call on main thread!!!");
        }
        if (!hasPrepared) {
            prepare();
        }
        waitBindedIfNeed();
        waitIpcIfNeed();
        IPCContextManager ipcContextManager = UniformIpcUtils.getIpcContextManager();
        if (ipcContextManager == null || ipcContextManager.getIpcCallManager() == null) {
            return null;
        }
        return (T) ipcContextManager.getIpcCallManager().getIpcProxy(cls);
    }

    public static synchronized void prepare() {
        if (ProcessUtils.isMainProcess()) {
            RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper prepare must be in lite process. " + Log.getStackTraceString(new Throwable()));
            return;
        }
        if (hasPrepared) {
            return;
        }
        hasPrepared = true;
        ipcInited.set(false);
        RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper prepare");
        sIpcCallClientHelper.bindService(RemoteCallService.class, new a());
        ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.ipc.RemoteCallClient.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteCallClient.sIpcCallClientHelper.bind();
            }
        });
        RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper prepare finish");
    }

    private static void waitBindedIfNeed() {
        IpcCallClientHelper ipcCallClientHelper = sIpcCallClientHelper;
        if (ipcCallClientHelper == null) {
            RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper waitBindedIfNeed but sIpcCallClientHelper is null");
            return;
        }
        if (ipcCallClientHelper.isBind()) {
            return;
        }
        synchronized (RemoteCallClient.class) {
            if (!sIpcCallClientHelper.isBind()) {
                if (!sIpcCallClientHelper.bind()) {
                    RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper bind failed!!!");
                    return;
                }
                try {
                    RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper begin wait bind");
                    RemoteCallClient.class.wait(5000L);
                    RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper end wait bind");
                } catch (Exception e) {
                    RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper wait error " + Log.getStackTraceString(e));
                }
            }
        }
    }

    private static void waitIpcIfNeed() {
        if (sIpcCallClientHelper == null) {
            RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper not need waitIpcIfNeed");
            return;
        }
        if (ipcInited.get()) {
            return;
        }
        synchronized (RemoteCallClient.class) {
            if (!ipcInited.get()) {
                try {
                    RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper begin wait ipc");
                    RemoteCallClient.class.wait();
                    RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper end wait ipc");
                } catch (Exception e) {
                    RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper wait ipc error " + Log.getStackTraceString(e));
                }
            }
        }
    }
}
