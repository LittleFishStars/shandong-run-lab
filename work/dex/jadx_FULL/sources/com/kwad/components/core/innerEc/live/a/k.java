package com.kwad.components.core.innerEc.live.a;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Activity> TG;

    public k(Activity activity) {
        this.TG = new WeakReference<>(activity);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openMerchantPage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final com.kwad.components.core.webview.tachikoma.c.o oVar = new com.kwad.components.core.webview.tachikoma.c.o();
            oVar.parseJson(new JSONObject(str));
            by.runOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.a.k.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    Activity activity = (Activity) k.this.TG.get();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    boolean zH = com.kwad.components.core.offline.b.a.a.h(activity, oVar.url);
                    com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                    if (cVar2 != null) {
                        if (zH) {
                            cVar2.b(null);
                        } else {
                            cVar2.onError(-1, "jump failed");
                        }
                    }
                }
            });
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
