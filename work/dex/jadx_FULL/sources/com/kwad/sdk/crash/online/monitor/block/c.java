package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    private static volatile boolean bfe;

    private static String a(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.LP().decode((bVar == null || TextUtils.isEmpty(bVar.bfx)) ? "b25SZXBvcnRJc3N1ZQ==" : bVar.bfx));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "report methodName:" + str);
        return str;
    }

    public static void b(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (bfe) {
            return;
        }
        try {
            com.kwad.sdk.crash.online.monitor.a.b bVarC = c(aVar);
            com.kwad.sdk.m.e.a(b(bVarC), a(bVarC), new com.kwad.sdk.m.e.a() { // from class: com.kwad.sdk.crash.online.monitor.block.c.1
                @Override // com.kwad.sdk.m.e.a
                public final void a(String str, long j, long j2, String str2, String str3) {
                    f.a(str, j, j2, str2, str3, false);
                }

                @Override // com.kwad.sdk.m.e.a
                public final void onError(String str) {
                    c.onError(str);
                }
            });
            bfe = true;
        } catch (Exception e) {
            onError(Log.getStackTraceString(e));
        }
    }

    private static com.kwad.sdk.crash.online.monitor.a.b c(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        h hVar = (h) ServiceProvider.get(h.class);
        String appId = hVar != null ? hVar.getAppId() : "";
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return aVar.gB(appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onError(String str) {
        f.gA(str);
        com.kwad.sdk.core.d.c.w("perfMonitor.Injector", str);
    }

    private static String b(com.kwad.sdk.crash.online.monitor.a.b bVar) {
        String str = new String(com.kwad.sdk.core.a.c.LP().decode((bVar == null || TextUtils.isEmpty(bVar.bfw)) ? "Y29tLnRlbmNlbnQubWF0cml4LnBsdWdpbi5QbHVnaW5MaXN0ZW5lcg==" : bVar.bfw));
        com.kwad.sdk.core.d.c.d("perfMonitor.Injector", "ListenerName:" + str);
        return str;
    }
}
