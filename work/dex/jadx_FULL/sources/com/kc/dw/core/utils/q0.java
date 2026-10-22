package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q0 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f39397a;

    @Keep
    public class a implements i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f39398a;

        public a(q0 q0Var, CountDownLatch countDownLatch) {
            this.f39398a = countDownLatch;
        }

        @Override // com.kc.dw.core.utils.i.b
        public void a(String str) {
        }

        @Override // com.kc.dw.core.utils.i.b
        public void b(String str) {
            try {
                this.f39398a.countDown();
            } catch (Throwable unused) {
            }
        }
    }

    public q0(List list) {
        this.f39397a = list;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        int i = 0;
        while (i < this.f39397a.size()) {
            String str = (String) this.f39397a.get(i);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            i.a(str, i == 0, new a(this, countDownLatch));
            try {
                if (countDownLatch.getCount() > 0) {
                    countDownLatch.await(10L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
            i++;
        }
    }
}
