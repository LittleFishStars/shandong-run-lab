package com.kwad.components.core.webview.tachikoma.a;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class f implements m {
    private Handler aqd = new Handler(Looper.getMainLooper());

    public abstract void a(al.a aVar);

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    final al.a aVar = new al.a();
                    aVar.parseJson(objArr[0] instanceof String ? new JSONObject((String) objArr[0]) : null);
                    this.aqd.post(new bi() { // from class: com.kwad.components.core.webview.tachikoma.a.f.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            f.this.a(aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        return null;
    }
}
