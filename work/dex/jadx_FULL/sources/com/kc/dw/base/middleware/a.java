package com.kc.dw.base.middleware;

import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.kc.dw.core.router.service.b f39216a;

    public static void a(Throwable th) {
        try {
            if (f39216a == null) {
                f39216a = (com.kc.dw.core.router.service.b) com.kc.dw.core.router.a.a(com.kc.dw.core.router.service.b.class);
            }
            com.kc.dw.core.router.service.b bVar = f39216a;
            if (bVar != null) {
                bVar.a(th);
            } else {
                Log.e("", "CatchUploadService is`not init");
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
