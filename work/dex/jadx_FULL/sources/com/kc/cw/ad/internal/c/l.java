package com.kc.cw.ad.internal.c;

import com.kc.cw.ad.model.SsLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l {
    private static l d;
    public SsLocation b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38951a = true;
    private int c = -1;

    private l() {
    }

    public static l a() {
        l lVar;
        synchronized (l.class) {
            try {
                if (d == null) {
                    d = new l();
                }
                lVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public int b() {
        return this.c;
    }
}
