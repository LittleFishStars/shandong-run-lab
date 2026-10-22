package com.kwad.components.ad.nativead.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener {
    private KsAdVideoPlayConfig ce;
    private AdInfo mAdInfo;
    private ViewGroup qe;
    private ImageView qf;
    private TextView qg;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.ce = ksAdVideoPlayConfig;
    }

    private boolean e(AdInfo adInfo) {
        if (adInfo.isAllowVideoAutoPlay) {
            return true;
        }
        if (!aq.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.ce;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return aq.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return aq.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && aq.isMobileConnected(getContext()));
            }
        }
        if (com.kwad.sdk.core.response.helper.a.cj(adInfo)) {
            return true;
        }
        return com.kwad.sdk.core.response.helper.a.ck(adInfo) && aq.isWifiConnected(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG() {
        if (this.qe.getVisibility() != 0) {
            return;
        }
        this.qe.setVisibility(8);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.pW.mAdTemplate);
        this.mAdInfo = adInfoEO;
        if (e(adInfoEO)) {
            this.qe.setVisibility(8);
        } else {
            this.qg.setText(bw.aw(com.kwad.sdk.core.response.helper.a.N(this.mAdInfo) * 1000));
            this.qf.setOnClickListener(this);
            this.pW.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.qe.setVisibility(0);
        }
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.a.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.fG();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.fG();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pW.pX.b((l) mVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.qf) {
            this.pW.pX.fX();
            this.mAdInfo.isAllowVideoAutoPlay = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qe = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.qf = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.qg = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}
