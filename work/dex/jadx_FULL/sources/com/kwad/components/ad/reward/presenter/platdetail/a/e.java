package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            e.this.jP();
        }
    };
    private View zR;
    private View zS;
    private ImageView zT;

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.d.a());
    }

    private void jO() {
        if (!this.uj.sQ) {
            this.zS.setVisibility(8);
        }
        this.zR.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.S(this.uj.mAdTemplate) && as.VM()) {
            this.zT.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.zR.setVisibility(0);
        this.zS.setVisibility(8);
        this.uj.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        jO();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
        jP();
    }

    public final void jP() {
        if (this.uj.sQ) {
            this.zR.setVisibility(8);
        } else {
            this.zR.setVisibility(8);
            this.zS.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.S(this.uj.mAdTemplate) && as.VM()) {
            this.zT.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zR = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.zS = findViewById(R.id.ksad_play_end_top_toolbar);
        this.zT = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        jO();
        this.uj.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().b(this);
        this.zS.setVisibility(8);
    }
}
