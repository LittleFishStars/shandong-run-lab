package com.alibaba.triver;

import android.app.Application;
import android.os.Process;
import android.taobao.windvane.WindVaneSDK;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.V8Proxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.inside.impl.TriverEnvProxy;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IZCacheProxy;
import com.alibaba.triver.kit.api.utils.SPUtils;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.CommonUtils;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.JSEngine2;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRiverSDK implements Serializable {
    private static final String ORANGE_KEY_OPEN_PRELAUNCH_MODE = "openPreLaunchMode";
    private static volatile List<a> initListeners = new ArrayList();
    private static volatile boolean isInit = false;
    private static volatile boolean isInitUCJSEngine = false;
    private static volatile boolean isIniting = false;

    public interface a {
        void a();

        void b();
    }

    private static synchronized void doInit(final Application application, boolean z) {
        TriverEnvProxy.init(application);
        Triver.initNecessary(application);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Process", "process init start");
        new JSONObject().put("ProcessId", (Object) Integer.valueOf(Process.myPid()));
        com.alibaba.triver.trace.b.a(c.c, c.t, "", null);
        com.alibaba.triver.preload.a.a(application);
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.triver.TRiverSDK.1
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.initIfNeed();
                final IConfigProxy iConfigProxy = (IConfigProxy) RVProxy.get(IConfigProxy.class);
                if (!ProcessUtils.isMainProcess()) {
                    iConfigProxy.getConfigsByGroup("triver_common_config");
                    iConfigProxy.getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG);
                    iConfigProxy.getConfigsByGroup(TRiverConstants.ORANGE_GROUP_IMPORTANT_CONFIG);
                    iConfigProxy.getConfigsByGroup(TRiverConstants.ORANGE_GROUP_WINDMILL_COMMON);
                } else if (!CommonUtils.closeAppInfoRouter()) {
                    com.alibaba.triver.appinfo.channel.a.a().a(iConfigProxy.getCustomConfigsByGroup(TRiverConstants.ORANGE_GROUP_APP_INFO_ROUTER_CONFIG));
                    ((IConfigProxy) RVProxy.get(IConfigProxy.class)).registerListener(TRiverConstants.ORANGE_GROUP_APP_INFO_ROUTER_CONFIG, new IConfigProxy.ConfigListener() { // from class: com.alibaba.triver.TRiverSDK.1.1
                        @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy.ConfigListener
                        public void onConfigUpdate(Map<String, String> map) {
                            com.alibaba.triver.appinfo.channel.a.a().a(iConfigProxy.getCustomConfigsByGroup(TRiverConstants.ORANGE_GROUP_APP_INFO_ROUTER_CONFIG));
                        }
                    });
                }
                try {
                    Map<String, String> configsByGroup = iConfigProxy.getConfigsByGroup("triver_common_config");
                    String str = configsByGroup != null ? configsByGroup.get(TRiverConstants.ORANGE_KEY_ZCACHE_SWITCH) : "";
                    ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).setConfig(!"close".equalsIgnoreCase(str), configsByGroup != null ? configsByGroup.get(TRiverConstants.ORANGE_KEY_ZCACHE_BLACK_LIST) : "");
                } catch (Throwable th) {
                    RVLogger.e("TRiverSDK", "init error", th);
                }
                if (TRiverSDK.initTriverEngine()) {
                    for (a aVar : TRiverSDK.initListeners) {
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                    boolean unused = TRiverSDK.isInit = true;
                    return;
                }
                for (a aVar2 : TRiverSDK.initListeners) {
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
                boolean unused2 = TRiverSDK.isInit = false;
            }
        });
        if (z) {
            try {
                if (ProcessUtils.isMainProcess()) {
                    ((IConfigProxy) RVProxy.get(IConfigProxy.class)).registerListener(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG, new IConfigProxy.ConfigListener() { // from class: com.alibaba.triver.TRiverSDK.2
                        @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy.ConfigListener
                        public void onConfigUpdate(Map<String, String> map) {
                            String str = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG).get(TRiverSDK.ORANGE_KEY_OPEN_PRELAUNCH_MODE);
                            ((IConfigProxy) RVProxy.get(IConfigProxy.class)).unregisterListener(TRiverConstants.GROUP_ARIVER_COMMON_CONFIG, this);
                            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                                com.alibaba.triver.container.a.a().a(application, 0L);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                RVLogger.e("PreloadInitializer", "process preload error", th);
            }
        }
        isIniting = false;
    }

    public static synchronized void init(Application application) {
        if (!isInit && !isIniting) {
            isIniting = true;
            doInit(application, false);
        }
    }

    public static synchronized boolean initTriverEngine() {
        try {
            if (!isInitUCJSEngine) {
                if (!WindVaneSDK.isInitialized()) {
                    final Timer timer = new Timer();
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    timer.schedule(new TimerTask() { // from class: com.alibaba.triver.TRiverSDK.3
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            try {
                                if (WindVaneSDK.isInitialized()) {
                                    countDownLatch.countDown();
                                    timer.cancel();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 0L, 100L);
                    countDownLatch.await(8L, TimeUnit.SECONDS);
                }
                if (!JSEngine2.isInitialized() && RVProxy.get(V8Proxy.class, true) != null) {
                    Delegate delegateGenerateDelegate = ((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate();
                    if (delegateGenerateDelegate != null && JSEngine2.Initialize(delegateGenerateDelegate)) {
                        isInitUCJSEngine = true;
                    } else {
                        isInitUCJSEngine = false;
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e("initTriverEngine Fail: " + th.getMessage());
        }
        return isInitUCJSEngine;
    }

    public static synchronized boolean isInit() {
        return isInit;
    }

    public static synchronized void init(Application application, boolean z) {
        if (!isInit && !isIniting) {
            isIniting = true;
            doInit(application, z);
        }
    }

    public static synchronized void init(Application application, boolean z, a aVar) {
        if (!isInit && !isIniting) {
            isIniting = true;
            initListeners.add(aVar);
            doInit(application, z);
        } else if (isInit) {
            aVar.a();
        } else {
            initListeners.add(aVar);
        }
    }
}
