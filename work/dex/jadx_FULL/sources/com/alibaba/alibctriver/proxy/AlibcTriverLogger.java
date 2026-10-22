package com.alibaba.alibctriver.proxy;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.baichuan.log.TLog;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTriverLogger implements RVLogger.Proxy {
    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void d(final String str, final String str2) {
        AlibcLogger.runOnLogThread(new Runnable() { // from class: com.alibaba.alibctriver.proxy.AlibcTriverLogger.4
            @Override // java.lang.Runnable
            public void run() {
                TLog.logd(str, str2);
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void debug(final String str, final String str2) {
        AlibcLogger.runOnLogThread(new Runnable() { // from class: com.alibaba.alibctriver.proxy.AlibcTriverLogger.1
            @Override // java.lang.Runnable
            public void run() {
                TLog.logd(str, str2);
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void e(final String str, final String str2, final Throwable th) {
        AlibcLogger.runOnLogThread(new Runnable() { // from class: com.alibaba.alibctriver.proxy.AlibcTriverLogger.2
            @Override // java.lang.Runnable
            public void run() {
                TLog.loge(str, str2, th);
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
    public void w(final String str, final String str2, final Throwable th) {
        AlibcLogger.runOnLogThread(new Runnable() { // from class: com.alibaba.alibctriver.proxy.AlibcTriverLogger.3
            @Override // java.lang.Runnable
            public void run() {
                TLog.logw(str, str2, th);
            }
        });
    }
}
