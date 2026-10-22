package com.kc.cw.ad.d;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g {
    private static g c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f38813a;
    private String b = "OnLineState";

    private g(Context context) {
        if (context == null) {
            com.kc.cw.ad.d.b.f.c("OnLineState", "OnLineState init failed,because context cann't be null ");
            return;
        }
        h hVar = new h();
        this.f38813a = hVar;
        hVar.a(context);
    }

    public static g a(Context context) {
        if (c == null) {
            synchronized (g.class) {
                try {
                    if (c == null) {
                        c = new g(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public void a(f fVar) {
        h hVar = this.f38813a;
        if (hVar != null) {
            hVar.a(fVar);
        } else {
            com.kc.cw.ad.d.b.f.a(this.b, "please init OnLineState first ,you can init it with 'OnLineState.init(context);' in you BaseApplication ");
        }
    }
}
