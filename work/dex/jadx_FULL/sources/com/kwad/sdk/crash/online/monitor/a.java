package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.crash.online.monitor.a.c;
import com.kwad.sdk.crash.online.monitor.block.e;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static volatile boolean hasInit = false;

    private static c Qv() {
        c cVar = new c();
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.bfC = aVar;
        aVar.bft = 5;
        return cVar;
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        hasInit = true;
        return true;
    }

    public static void dC(final String str) {
        i.execute(new bi() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorManager", "configStr:" + str);
                c cVarGt = a.gt(str);
                com.kwad.sdk.core.d.c.d("perfMonitor.MonitorManager", cVarGt.toJson().toString());
                e.d(cVarGt.bfC);
                a.access$002(true);
            }
        });
    }

    public static c gt(String str) {
        if (TextUtils.isEmpty(str)) {
            return Qv();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("perfMonitor.MonitorManager", e);
            return Qv();
        }
    }
}
