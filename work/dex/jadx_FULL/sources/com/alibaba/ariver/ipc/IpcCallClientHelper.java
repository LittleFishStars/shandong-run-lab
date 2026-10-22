package com.alibaba.ariver.ipc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcCallClientHelper {
    private static final String TAG = "AriverKernel:RemoteCall";
    private ServiceConnection conn;
    private Class serviceClass;
    private Context context = ProcessUtils.getContext();
    private boolean bound = false;
    private int retryTimes = 0;

    public synchronized boolean bind() {
        if (this.serviceClass != null && this.conn != null && this.context != null) {
            if (isBind()) {
                return true;
            }
            RVLogger.d("AriverKernel:RemoteCall", this.serviceClass.getSimpleName() + " bind with context: " + this.context);
            Intent intent = new Intent(this.context, (Class<?>) this.serviceClass);
            try {
                try {
                    RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper start service begin!");
                    this.context.startService(intent);
                    RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper start service end!");
                    this.context.bindService(intent, this.conn, 0);
                    return true;
                } catch (Throwable th) {
                    RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper start service failed!", th);
                    return false;
                }
            } catch (Throwable th2) {
                RVLogger.e("AriverKernel:RemoteCall", Log.getStackTraceString(th2));
                return false;
            }
        }
        return false;
    }

    public void bindContext(Context context) {
        this.context = context;
    }

    public void bindService(Class cls, ServiceConnection serviceConnection) {
        this.serviceClass = cls;
        this.conn = serviceConnection;
    }

    public boolean isBind() {
        return this.bound;
    }

    public void rebind() {
        unbind();
        if (this.retryTimes < 3) {
            RVLogger.d("AriverKernel:RemoteCall", this.serviceClass.getSimpleName() + " retry bind " + this.retryTimes);
            this.retryTimes = this.retryTimes + 1;
            bind();
        }
    }

    public void setBind(boolean z) {
        this.bound = z;
    }

    public void unbind() {
        if (this.bound) {
            this.context.unbindService(this.conn);
            this.bound = false;
        }
    }
}
