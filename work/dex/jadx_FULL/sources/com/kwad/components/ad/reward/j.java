package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j extends com.kwad.components.ad.l.b {

    @Nullable
    private com.kwad.components.ad.reward.c.d tZ;
    private WeakReference<g> ua;

    public j(g gVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.ua = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gH() {
        WeakReference<g> weakReference = this.ua;
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, (weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gI() {
        WeakReference<g> weakReference = this.ua;
        boolean z = (weakReference != null ? weakReference.get() : null) != null;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, "end_card", O(adTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gJ() {
        WeakReference<g> weakReference = this.ua;
        boolean z = (weakReference != null ? weakReference.get() : null) != null;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, "end_card", O(adTemplate), System.currentTimeMillis() - getLoadTime());
    }

    public final void a(@Nullable com.kwad.components.ad.reward.c.d dVar) {
        this.tZ = dVar;
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.ff.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.tZ != null) {
                    j.this.tZ.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.j(new com.kwad.components.core.webview.jshandler.p() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    jVar.a(com.kwad.components.ad.reward.c.a.ih().ii());
                }
            }
        }));
        WeakReference<g> weakReference = this.ua;
        aVar.b(new com.kwad.components.ad.reward.k.p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.fi));
    }
}
