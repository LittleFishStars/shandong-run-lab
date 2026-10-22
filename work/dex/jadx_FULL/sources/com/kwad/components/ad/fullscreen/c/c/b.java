package com.kwad.components.ad.fullscreen.c.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {
    private FrameLayout dG;
    private j lg = new j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable n nVar) {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dq() {
            b.this.dG.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dr() {
            b.this.dG.setVisibility(4);
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.sP = true;
        com.kwad.components.ad.reward.a.gs().a(this.lg);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dG;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.ek(this.uj.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dG = (FrameLayout) findViewById(R.id.ksad_js_full_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.a.gs().b(this.lg);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, tKRenderFailReason);
        this.dG.setVisibility(8);
        this.uj.sP = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        FrameLayout frameLayout = this.dG;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.dG.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height != 0.0f && width != 0.0f) {
            aVar.width = (int) ((width / fBB) + 0.5f);
            aVar.height = (int) ((height / fBB) + 0.5f);
        } else {
            super.a(aVar);
        }
    }
}
