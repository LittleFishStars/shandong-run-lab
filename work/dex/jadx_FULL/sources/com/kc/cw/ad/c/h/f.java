package com.kc.cw.ad.c.h;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements com.kc.cw.ad.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38752a = false;

    @Override // com.kc.cw.ad.c.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f38752a) {
            e.a(context);
            this.f38752a = true;
        }
        if (e.a()) {
            return e.b(context);
        }
        return null;
    }
}
