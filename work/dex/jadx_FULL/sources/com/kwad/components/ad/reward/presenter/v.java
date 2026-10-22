package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class v extends b {
    private DetailVideoView xT;
    private ViewGroup xU;
    private FrameLayout xV;
    private ImageView xW;
    private ViewGroup.LayoutParams xX = null;
    private com.kwad.components.core.video.m kf = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.xT.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.xT.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void am(@LayoutRes int i) {
        this.xV.addView(com.kwad.sdk.wrapper.m.a(getContext(), i, this.xV, false), -1, -1);
    }

    private void jh() {
    }

    private void ji() {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
        getContext();
        boolean z = !as.VM();
        boolean zBQ = com.kwad.sdk.core.response.helper.a.bQ(adInfoEO);
        boolean z2 = com.kwad.sdk.core.response.helper.a.cQ(adInfoEO) && com.kwad.components.ad.reward.a.b.hY();
        boolean z3 = com.kwad.components.ad.reward.g.R(this.uj.mAdTemplate) || com.kwad.components.ad.reward.g.S(this.uj.mAdTemplate) || zBQ || z2;
        if (!z || !z3) {
            this.xU.setVisibility(8);
            return;
        }
        this.xU.setVisibility(z2 ? 4 : 0);
        if (zBQ) {
            this.xW.setVisibility(8);
            am(R.layout.ksad_playable_end_info);
        } else {
            am(R.layout.ksad_activity_apk_info_landscape);
        }
        if (!com.kwad.sdk.core.response.helper.a.be(adInfoEO)) {
            this.xT.updateTextureViewGravity(17);
        } else {
            this.xT.updateTextureViewGravity(21);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        jh();
        ViewGroup.LayoutParams layoutParams = this.xT.getLayoutParams();
        if (layoutParams != null) {
            this.xX = new ViewGroup.LayoutParams(layoutParams);
        }
        this.uj.sz.a(this.kf);
        ji();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xT = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.xU = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.xW = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.xV = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.uj.sz.b(this.kf);
        if (this.xX == null || (detailVideoView = this.xT) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.LayoutParams layoutParams2 = this.xX;
            layoutParams.width = layoutParams2.width;
            layoutParams.height = layoutParams2.height;
            this.xT.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.xT;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.xX = null;
    }
}
