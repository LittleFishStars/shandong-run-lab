package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    private View ks;
    private View kt;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            c.this.j(false);
        }
    };

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    private void dp() {
        com.kwad.components.ad.reward.g gVar = this.uj;
        if (gVar.sQ || gVar.sP) {
            return;
        }
        this.ks.setVisibility(0);
        this.kt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        com.kwad.components.ad.reward.g gVar = this.uj;
        if ((gVar.sQ || gVar.sP) && !z) {
            this.ks.setVisibility(8);
            this.kt.setVisibility(8);
        } else {
            this.ks.setVisibility(8);
            this.kt.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().a(this);
        this.ks.setVisibility(0);
        this.kt.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        dp();
        if (this.uj.sP && this.kt.getVisibility() == 0) {
            this.kt.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
        j(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ks = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.kt = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().b(this);
    }
}
