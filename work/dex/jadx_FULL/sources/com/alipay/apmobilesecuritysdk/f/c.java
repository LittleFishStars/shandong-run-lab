package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f25347a;

    public c(b bVar) {
        this.f25347a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f25347a.c.isEmpty()) {
                Runnable runnable = (Runnable) this.f25347a.c.get(0);
                this.f25347a.c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f25347a.b = null;
            throw th;
        }
        this.f25347a.b = null;
    }
}
