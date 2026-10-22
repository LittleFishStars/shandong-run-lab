package com.alibaba.triver.ipc.client;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.triver.Triver;
import com.alibaba.triver.ipc.a;
import com.alibaba.triver.ipc.server.IpcMsgServerService;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.point.OnPreloadPoint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcMsgClientService extends Service {
    private static final String b = "AriverInt:IpcMsgClientService1";
    private static volatile boolean c = false;
    private static volatile boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ServiceConnection f25007a = null;
    private IIpcChannel e;

    public static class IpcMsgClientService1 extends IpcMsgClientService {
        @Override // com.alibaba.triver.ipc.client.IpcMsgClientService, android.app.Service
        public void onCreate() {
            super.onCreate();
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Process", "first process init finish");
        }
    }

    public static class IpcMsgClientService2 extends IpcMsgClientService {
    }

    public static class IpcMsgClientService3 extends IpcMsgClientService {
    }

    public static class IpcMsgClientService4 extends IpcMsgClientService {
    }

    public static class IpcMsgClientService5 extends IpcMsgClientService {
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        RVLogger.d(b, "onBind");
        return this.e.asBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        RVLogger.d(b, "onCreate");
        Triver.initNecessary(getApplication());
        this.e = new IIpcChannel.Stub() { // from class: com.alibaba.triver.ipc.client.IpcMsgClientService.1
            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public boolean isFinishing() {
                WeakReference<Activity> topActivity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity();
                return topActivity.get() != null && topActivity.get().isFinishing();
            }

            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public void sendMessage(IpcMessage ipcMessage) {
                ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
            }
        };
        a();
        a.a(this);
        ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).processCreatedPointPreload();
        try {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Process", "process init finish");
        } catch (Exception e) {
            RVLogger.e(b, e);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            unbindService(this.f25007a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        Bundle extras;
        RVLogger.d(b, "onStartCommand");
        super.onStartCommand(intent, i, i2);
        if (!c) {
            synchronized (RVInitializer.class) {
                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.ipc.client.IpcMsgClientService.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Intent intent2 = intent;
                            if (intent2 == null || intent2.getExtras() == null || !((Boolean) intent.getExtras().get(com.alibaba.triver.container.a.d)).booleanValue()) {
                                return;
                            }
                            RVLogger.d(IpcMsgClientService.b, "Pre launch in");
                            com.alibaba.triver.container.a.a().d();
                            WVCommonConfig.getInstance().init();
                            WVUCWebView.isWebViewMultiProcessEnabled();
                            RVLogger.d(IpcMsgClientService.b, "Pre init uc finish");
                        } catch (Exception e) {
                            TaoLog.e(IpcMsgClientService.b, "Pre init stub service exception:", e, new Object[0]);
                        }
                    }
                });
                c = true;
            }
        }
        if (intent != null && (extras = intent.getExtras()) != null) {
            extras.setClassLoader(getClassLoader());
            if (extras.containsKey(com.alibaba.triver.container.a.e)) {
                a(extras.getBundle(com.alibaba.triver.container.a.e));
            }
        }
        a();
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        try {
            unbindService(this.f25007a);
        } catch (Exception unused) {
        }
        return super.onUnbind(intent);
    }

    private synchronized void a() {
        if (IpcChannelManager.getInstance().getServerChannel() == null && !d) {
            try {
                d = true;
                Intent intent = new Intent();
                intent.setClass(this, IpcMsgServerService.class);
                ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.alibaba.triver.ipc.client.IpcMsgClientService.2
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        RVLogger.d(IpcMsgClientService.b, "onServiceConnected " + componentName);
                        IpcChannelManager.getInstance().registerServerChannel(IIpcChannel.Stub.asInterface(iBinder));
                        boolean unused = IpcMsgClientService.d = false;
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        RVLogger.d(IpcMsgClientService.b, "onServiceDisconnected " + componentName);
                        IpcChannelManager.getInstance().unRegisterServerChannel();
                        boolean unused = IpcMsgClientService.d = false;
                    }
                };
                bindService(intent, serviceConnection, 1);
                this.f25007a = serviceConnection;
                RVLogger.d(b, "Stub Service try bind finish");
            } catch (Exception e) {
                RVLogger.e(b, "checkConnection exception:", e);
                d = false;
            }
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            final String string = bundle.getString("loadingImage");
            String string2 = bundle.getString("loadingLogo");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (com.alibaba.triver.utils.a.a(string) == null) {
                ((IImageProxy) RVProxy.get(IImageProxy.class)).loadImage(string, null, new IImageProxy.ImageListener() { // from class: com.alibaba.triver.ipc.client.IpcMsgClientService.4
                    @Override // com.alibaba.triver.kit.api.proxy.IImageProxy.ImageListener
                    public void onImageFinish(Drawable drawable) {
                        if (drawable == null || !drawable.isVisible()) {
                            return;
                        }
                        com.alibaba.triver.utils.a.a(string, drawable);
                    }
                });
            }
            ((IImageProxy) RVProxy.get(IImageProxy.class)).loadImage(string2, null, null);
        }
    }
}
