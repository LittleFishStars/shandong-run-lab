package com.kc.dw.core.router.helper;

import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    public static void a(com.kc.dw.core.router.service.a.InterfaceC1044a interfaceC1044a) {
        com.kc.dw.core.router.service.a aVar = (com.kc.dw.core.router.service.a) com.kc.dw.core.router.a.a(com.kc.dw.core.router.service.a.class);
        if (aVar == null) {
            Log.e("ServiceHelper", "IAppStateNotifyService is null");
        }
        if (aVar != null) {
            aVar.a(interfaceC1044a);
        }
    }

    public static void b(com.kc.dw.core.router.service.a.InterfaceC1044a interfaceC1044a) {
        com.kc.dw.core.router.service.a aVar = (com.kc.dw.core.router.service.a) com.kc.dw.core.router.a.a(com.kc.dw.core.router.service.a.class);
        if (aVar == null) {
            Log.e("ServiceHelper", "IAppStateNotifyService is null");
        }
        if (aVar != null) {
            aVar.b(interfaceC1044a);
        }
    }
}
