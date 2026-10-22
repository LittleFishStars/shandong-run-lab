package com.alibaba.ariver.integration.proxy.impl;

import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultLoggerProxyImpl implements RVLogger.Proxy {
    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void d(String str, String str2) {
        Log.d(str, "[" + Thread.currentThread().getName() + "] " + str2);
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void debug(String str, String str2) {
        Log.d(str, "[" + Thread.currentThread().getName() + "] " + str2);
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void e(String str, String str2, Throwable th) {
        Log.e(str, "[" + Thread.currentThread().getName() + "] " + str2, th);
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void w(String str, String str2, Throwable th) {
        Log.w(str, "[" + Thread.currentThread().getName() + "] " + str2, th);
    }
}
