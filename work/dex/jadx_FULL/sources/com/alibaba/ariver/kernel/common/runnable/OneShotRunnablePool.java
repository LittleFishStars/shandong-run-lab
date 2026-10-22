package com.alibaba.ariver.kernel.common.runnable;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OneShotRunnablePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24270a = "AriverKernel:OneShotRunnablePool";
    private static OneShotRunnablePool b;
    private final Map<String, Runnable> c = new HashMap();

    private OneShotRunnablePool() {
        if (((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_oneShotRunnableWeakRef", false)) {
            OneShotRunnable.sUseWeakRef = true;
            RVLogger.d(f24270a, "OneShotRunnable.sUseWeakRef true");
        }
    }

    public static OneShotRunnablePool getInstance() {
        if (b == null) {
            synchronized (OneShotRunnablePool.class) {
                if (b == null) {
                    b = new OneShotRunnablePool();
                }
            }
        }
        return b;
    }

    public Runnable obtain(Runnable runnable) {
        return obtain(runnable.getClass().getName(), runnable);
    }

    public Runnable obtain(String str, Runnable runnable) {
        OneShotRunnable oneShotRunnable;
        Runnable runnable2 = this.c.get(str);
        if (runnable2 != null) {
            RVLogger.d(f24270a, "obtain hit pool " + str);
            return runnable2;
        }
        synchronized (this.c) {
            oneShotRunnable = new OneShotRunnable(str, runnable);
            this.c.put(str, oneShotRunnable);
        }
        return oneShotRunnable;
    }
}
