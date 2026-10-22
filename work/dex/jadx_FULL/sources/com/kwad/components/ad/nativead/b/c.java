package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.nativead.a.a {
    private List<Integer> cv;
    private volatile boolean eV = false;

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.cv = com.kwad.sdk.core.response.helper.a.bv(com.kwad.sdk.core.response.helper.e.eO(this.pW.mAdTemplate));
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.c.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.cu(c.this.pW.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                c.this.eV = false;
                if (!c.this.pW.mAdTemplate.mPvReported) {
                    c.this.pW.pD.fy();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.pW.pR.getParent();
                if (view != null) {
                    bVar.z(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.t.b.wF().a(c.this.pW.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.ct(c.this.pW.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                if (c.this.eV) {
                    return;
                }
                c.this.eV = true;
                com.kwad.components.core.p.a.vL().a(c.this.pW.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pW.pX.b((l) mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cv) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.pW.mAdTemplate, iCeil, (JSONObject) null);
                this.cv.remove(num);
                return;
            }
        }
    }
}
