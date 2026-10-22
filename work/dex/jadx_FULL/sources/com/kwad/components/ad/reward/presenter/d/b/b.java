package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View Ak;
    private boolean Al;
    private final Runnable Am = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.kb();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.uj.ts + ", needHideCloseButton: " + this.Al);
        if (this.uj.ts && this.Al) {
            return;
        }
        this.Ak.setVisibility(0);
        this.Ak.setAlpha(0.0f);
        this.Ak.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Al = com.kwad.sdk.core.response.helper.b.eH(e.eO(this.uj.mAdTemplate));
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void ka() {
        g gVar = this.uj;
        if (gVar.tb) {
            return;
        }
        long j = gVar.tm;
        if (j == 0) {
            this.Am.run();
        } else {
            by.runOnUiThreadDelay(this.Am, j);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Ak) {
            PlayableSource playableSourceHb = this.uj.hb();
            if (playableSourceHb == null || !(playableSourceHb.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || playableSourceHb.equals(PlayableSource.PENDANT_CLICK_AUTO) || playableSourceHb.equals(PlayableSource.PENDANT_AUTO) || playableSourceHb.equals(PlayableSource.ACTIONBAR_CLICK))) {
                f.v(this.uj);
            } else {
                com.kwad.components.ad.reward.a.gs().gt();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewFindViewById = findViewById(R.id.ksad_end_close_btn);
        this.Ak = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Ak.setVisibility(8);
        by.b(this.Am);
    }
}
