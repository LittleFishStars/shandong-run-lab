package com.kc.cw.ad.internal.c;

import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class r {
    private static r d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.cw.ad.a.g.d f38953a;
    public com.kc.cw.ad.a.g.c b = com.kc.cw.ad.a.g.c.ISP_OTHER;
    public String c;

    private r() {
    }

    public static r a() {
        r rVar;
        synchronized (r.class) {
            try {
                if (d == null) {
                    d = new r();
                    f.a(f.f38946a, f.a(R.string.init));
                }
                rVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }
}
