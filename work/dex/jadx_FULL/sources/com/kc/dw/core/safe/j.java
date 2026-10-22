package com.kc.dw.core.safe;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j implements Runnable {
    public void notifyRunnableCatch(Exception exc) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            safeRun();
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
            try {
                notifyRunnableCatch(e);
            } catch (Exception unused) {
            }
        }
    }

    public void safeRun() {
    }
}
