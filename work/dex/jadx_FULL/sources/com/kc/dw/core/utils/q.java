package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f39396a;
    public final int b;
    public final String c;

    public q(String[] strArr, int i, String str) {
        this.f39396a = strArr;
        this.b = i;
        this.c = str;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            String[] strArr = this.f39396a;
            if (strArr != null) {
                z.a(strArr[0], Integer.valueOf(this.b), this.c);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
