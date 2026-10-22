package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class p extends am {
    private long Cc;
    private String Cd;
    private WeakReference<com.kwad.components.ad.reward.g> ua;

    public p(com.kwad.components.ad.reward.g gVar, String str, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.Cd = str;
        this.Cc = j;
        if (gVar != null) {
            this.ua = new WeakReference<>(gVar);
        }
    }

    private static boolean ab(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void b(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z, adTemplate, null, bVar);
    }

    private boolean b(am.b bVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (bVar.getActionType() != 140 || !com.kwad.sdk.core.config.e.FZ() || !ab(bVar.yv()) || (weakReference = this.ua) == null || weakReference.get() == null) {
            return false;
        }
        final com.kwad.components.ad.reward.g gVar = this.ua.get();
        by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.ad.reward.k.p.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                gVar.E(p.this.Cd);
            }
        }, com.igexin.push.config.c.j);
        return true;
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void a(@NonNull am.b bVar) {
        if (b(bVar)) {
            return;
        }
        super.a(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.am
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.ua;
        if (weakReference != null && weakReference.get() != null) {
            bVar.aC(this.ua.get().sz.getPlayDuration());
            return;
        }
        long j = this.Cc;
        if (j > 0) {
            bVar.aC(j);
        }
    }
}
