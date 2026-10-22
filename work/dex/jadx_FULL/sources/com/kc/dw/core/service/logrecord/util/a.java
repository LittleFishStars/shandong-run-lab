package com.kc.dw.core.service.logrecord.util;

import com.kc.dw.core.router.log.bean.LoadResState;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.core.loader.b f39321a;
    public final boolean b;

    public a(com.kc.dw.core.loader.b bVar, boolean z) {
        this.f39321a = bVar;
        this.b = z;
    }

    public void a(boolean z) {
        com.kc.dw.core.loader.b bVar;
        LoadResState fail;
        String str;
        if (z) {
            bVar = this.f39321a;
            fail = new LoadResState().setSuccess(2, 1, 0);
            str = "s4";
        } else {
            bVar = this.f39321a;
            fail = new LoadResState().setFail(2);
            str = "f4";
        }
        com.kc.dw.core.service.logrecord.a.a(5, str, bVar, fail);
    }
}
