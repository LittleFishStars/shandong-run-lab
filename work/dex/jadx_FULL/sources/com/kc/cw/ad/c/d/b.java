package com.kc.cw.ad.c.d;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements com.kc.cw.ad.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f38736a;
    private boolean b = false;
    private boolean c = false;

    @Override // com.kc.cw.ad.c.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            c cVar = new c();
            this.f38736a = cVar;
            this.c = cVar.a(context, (c.a<String>) null) == 1;
            this.b = true;
        }
        if (this.c && this.f38736a.b()) {
            return this.f38736a.a();
        }
        return null;
    }
}
