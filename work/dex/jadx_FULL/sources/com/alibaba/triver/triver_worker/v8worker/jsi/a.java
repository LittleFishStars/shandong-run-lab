package com.alibaba.triver.triver_worker.v8worker.jsi;

import android.content.Context;
import android.taobao.windvane.extra.core.WVCore;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ProcessLock;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.LogData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends Delegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25264a = "AriverEngine:AriverJSEngineDelegate";
    private static final String b = "libwebviewuc.so";
    private static final String c = "libjsi.so";
    private final String d;
    private final String e;

    public a() {
        if ("aarch64".equalsIgnoreCase(System.getProperty("os.arch"))) {
            this.d = "libwebviewuc_64.so";
            this.e = "libjsi_64.so";
        } else {
            this.d = b;
            this.e = c;
        }
        RVLogger.d(f25264a, "got webview name: " + this.d + " jsi name: " + this.e);
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public String getConfig(String str, String str2) {
        return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(str, str2);
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public Context getContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public String getWebViewCoreSoPath() {
        return WVCore.c().g();
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public void log(LogData logData) {
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public void releaseProcessLock(Object obj) {
        if (obj instanceof ProcessLock) {
            ((ProcessLock) obj).unlock();
        }
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public Object takeProcessLock(String str) {
        return Boolean.valueOf(new ProcessLock(str).tryLock());
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public void unzipWebViewCoreSo() {
    }
}
