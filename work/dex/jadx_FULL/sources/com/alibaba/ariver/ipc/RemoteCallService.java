package com.alibaba.ariver.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteCallService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IIPCManager f24096a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return (IBinder) this.f24096a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        IIPCManager ipcManager = UniformIpcUtils.getIpcManager();
        this.f24096a = ipcManager;
        UniformIpcUtils.init(this, ipcManager);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
