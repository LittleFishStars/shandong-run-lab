package com.alibaba.ariver.kernel.api.scheduler.internal;

import com.alibaba.ariver.kernel.api.scheduler.Interruptor;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultInterruptor implements Interruptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24220a = "AriverKernel:ExtensionInvoker:Interruptor";
    private boolean b = false;

    @Override // com.alibaba.ariver.kernel.api.scheduler.Interruptor
    public void interrupt() {
        RVLogger.d(f24220a, "interrupt on " + this);
        this.b = true;
    }

    public boolean isInterrupted() {
        return this.b;
    }

    public void setInterrupted(boolean z) {
        this.b = z;
    }
}
