package com.alibaba.triver.jsengine;

import android.content.Context;
import android.taobao.windvane.extra.core.WVCore;
import com.alibaba.ariver.kernel.common.io.ProcessLock;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.LogData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends Delegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25015a = "AriverEngine:V8EngineDelegate";
    private final String b;
    private Context c;

    public b(Context context) {
        this.c = context;
        if ("aarch64".equalsIgnoreCase(System.getProperty("os.arch"))) {
            this.b = "libwebviewuc_64.so";
        } else {
            this.b = "libwebviewuc.so";
        }
        RVLogger.d(f25015a, "got soname: " + this.b);
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public String getConfig(String str, String str2) {
        return str2;
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public Context getContext() {
        return this.c;
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
