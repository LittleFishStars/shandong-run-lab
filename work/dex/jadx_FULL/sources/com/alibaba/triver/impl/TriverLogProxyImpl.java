package com.alibaba.triver.impl;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.baichuan.log.TLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverLogProxyImpl implements RVLogger.Proxy {
    public static final String TLOG_MODULE = "Triver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f24977a = true;

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void d(String str, String str2) {
        if (f24977a) {
            TLog.loge("Triver." + str, str2);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void debug(String str, String str2) {
        if (f24977a) {
            TLog.logd("Triver." + str, str2);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void e(String str, String str2, Throwable th) {
        if (f24977a) {
            TLog.loge("Triver." + str, str2, th);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void w(String str, String str2, Throwable th) {
        if (f24977a) {
            TLog.logw("Triver." + str, str2, th);
        }
    }
}
