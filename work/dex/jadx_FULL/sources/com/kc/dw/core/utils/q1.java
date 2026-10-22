package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f39399a;

    public q1(r1 r1Var) {
        this.f39399a = r1Var;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        while (true) {
            try {
                if (this.f39399a.f39403a.isEmpty()) {
                    break;
                } else {
                    this.f39399a.a();
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    this.f39399a.d = false;
                }
            }
        }
    }
}
