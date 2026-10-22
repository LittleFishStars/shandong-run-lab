package com.byazt.ao;

import com.byazt.th.n;
import com.huachenjie.common.constants.UserConstants;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, UserConstants.LOGIN_ERROR.f33729a, 20})
public class c {
    public Throwable c;
    public final CountDownLatch tt;

    /* JADX INFO: renamed from: com.byazt.ao.c$c, reason: collision with other inner class name */
    public interface InterfaceC0347c {
        void c() throws Throwable;
    }

    private c(boolean z, InterfaceC0347c[] interfaceC0347cArr) {
        this.tt = new CountDownLatch(interfaceC0347cArr.length);
        for (final InterfaceC0347c interfaceC0347c : interfaceC0347cArr) {
            n.c(new Runnable() { // from class: com.byazt.ao.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0347c.c();
                    } catch (Throwable th) {
                        c.this.c = th;
                    }
                    c.this.tt.countDown();
                }
            }, z);
        }
    }

    public static void c(boolean z, InterfaceC0347c... interfaceC0347cArr) throws Throwable {
        new c(z, interfaceC0347cArr).c();
    }

    private void c() throws Throwable {
        try {
            this.tt.await();
            Throwable th = this.c;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
