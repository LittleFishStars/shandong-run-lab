package com.kwad.components.ad.reward.presenter;

import android.view.ViewStub;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private com.kwad.components.core.video.m kf = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.uj.te = j2;
        }
    };
    private DetailVideoView mDetailVideoView;

    public a(com.kwad.components.ad.reward.g gVar) {
        this.uj = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    private boolean iF() {
        return com.kwad.sdk.core.response.helper.e.n(this.mAdTemplate, com.kwad.components.ad.reward.a.b.l(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)));
    }

    private boolean iG() {
        return com.kwad.sdk.core.response.helper.e.S(this.mAdTemplate);
    }

    private void n(com.kwad.components.ad.reward.g gVar) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        com.kwad.components.ad.reward.m.e eVar = gVar.sz;
        if (com.kwad.sdk.core.response.helper.a.bj(adInfoEO)) {
            com.kwad.components.ad.reward.m.b bVar = new com.kwad.components.ad.reward.m.b(this.mAdTemplate);
            eVar.a(3, bVar);
            gVar.a(bVar);
        } else {
            com.kwad.components.ad.reward.m.d dVar = new com.kwad.components.ad.reward.m.d(gVar, this.mDetailVideoView);
            eVar.a(1, dVar);
            gVar.a(dVar);
        }
        eVar.a(this.kf);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        getContext();
        boolean z = !as.VM();
        if ((iF() || iG()) && z) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.g(true, com.kwad.sdk.core.config.e.Ky());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_native_container_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        n(this.uj);
        if (RewardRenderResult.DEFAULT.equals(this.uj.he())) {
            com.kwad.components.ad.reward.g.a(getContext(), this.uj, (FrameLayout) findViewById(R.id.ksad_reward_play_layout));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ad.reward.m.e eVar = this.uj.sz;
        if (eVar != null) {
            eVar.b(this.kf);
        }
    }
}
