package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView kE;
    private ImageView zN;
    private j.a kF = new j.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeOccupied() {
            if (d.this.kE == null || com.kwad.components.ad.reward.a.b.hO()) {
                return;
            }
            d.this.kE.post(new bi() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    d.this.kE.setSelected(false);
                    d.this.uj.sz.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.ad.reward.m.c zO = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.ad.reward.m.c
        public final void jN() {
            d.this.jL();
        }
    };

    private void ds() {
        ImageView imageView;
        int i = 8;
        if (iN()) {
            this.kE.setVisibility(8);
            imageView = this.zN;
        } else {
            this.kE.setVisibility(g.T(this.mAdTemplate) ? 8 : 0);
            imageView = this.zN;
            if (g.T(this.mAdTemplate)) {
                i = 0;
            }
        }
        imageView.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL() {
        g gVar = this.uj;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        boolean zIsVideoSoundEnable = true;
        if (!gVar.sx && com.kwad.components.core.t.a.aO(getContext()).wD()) {
            this.zN.setSelected(true);
            this.uj.e(false, false);
            zIsVideoSoundEnable = false;
        } else if (ksVideoPlayConfig != null) {
            zIsVideoSoundEnable = ksVideoPlayConfig.isVideoSoundEnable();
            this.zN.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.uj.e(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.zN.setSelected(true);
            this.uj.e(true, true);
        }
        this.kE.setSelected(zIsVideoSoundEnable);
        this.uj.sz.setAudioEnabled(zIsVideoSoundEnable, false);
    }

    private void jM() {
        this.kE.setOnClickListener(this);
        this.zN.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.a(this.zO);
        this.uj.sz.a(this.kF);
        ds();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView = this.kE;
        if (view == imageView) {
            this.uj.sz.setAudioEnabled(!imageView.isSelected(), true);
            ImageView imageView2 = this.kE;
            imageView2.setSelected(!imageView2.isSelected());
        } else {
            ImageView imageView3 = this.zN;
            if (view == imageView3) {
                this.uj.sz.setAudioEnabled(!imageView3.isSelected(), true);
                ImageView imageView4 = this.zN;
                imageView4.setSelected(!imageView4.isSelected());
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kE = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.zN = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        jM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.kF);
        this.uj.b(this.zO);
    }
}
