package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends b implements com.kwad.sdk.widget.d {
    private com.kwad.sdk.core.video.videoview.a cB;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC1290a cK;

    @NonNull
    private KsAdVideoPlayConfig ce;
    private List<Integer> cv;
    private KSFrameLayout fT;
    private ImageView ik;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    @NonNull
    protected Context mContext;
    private c mN;
    private KSFrameLayout nM;
    private com.kwad.components.core.video.f nN;

    @Nullable
    private boolean mIsAudioEnable = false;
    private final com.kwad.components.core.video.a.InterfaceC1231a iq = new com.kwad.components.core.video.a.InterfaceC1231a() { // from class: com.kwad.components.ad.interstitial.f.f.4
        /* JADX WARN: Code duplicated, block: B:15:0x0024  */
        @Override // com.kwad.components.core.video.a.InterfaceC1231a
        public final void a(int i, al.a aVar) {
            final int i2;
            int i3;
            boolean z = false;
            if (i == 1) {
                i2 = 13;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        i2 = 108;
                    } else {
                        i2 = 83;
                        z = true;
                        i3 = 1;
                    }
                    f.this.getContext();
                    int i4 = as.VM() ? 2 : 1;
                    com.kwad.components.ad.interstitial.report.a.eV().a(f.this.mAdTemplate, 1L, i2);
                    com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(f.this.getContext()).aJ(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).aN(i3).as(z).au(true).aM(i2).d(aVar).aO(i4).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.f.4.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            f.this.o(i2);
                        }
                    }));
                }
                i2 = 82;
            }
            i3 = 2;
            f.this.getContext();
            if (as.VM()) {
            }
            com.kwad.components.ad.interstitial.report.a.eV().a(f.this.mAdTemplate, 1L, i2);
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(f.this.getContext()).aJ(f.this.mAdTemplate).b(f.this.mApkDownloadHelper).aN(i3).as(z).au(true).aM(i2).d(aVar).aO(i4).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.f.4.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    f.this.o(i2);
                }
            }));
        }
    };

    private void eE() {
        String strFx;
        this.mIsAudioEnable = this.ce.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.ik.setVisibility(8);
        } else {
            this.ik.setImageDrawable(null);
            KSImageLoader.loadImage(this.ik, url, this.mAdTemplate);
            this.ik.setVisibility(0);
        }
        int iGa = com.kwad.sdk.core.config.e.Ga();
        String strM = com.kwad.sdk.core.response.helper.a.M(this.mAdInfo);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        if (iGa < 0) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strM);
            if (fileCO == null || !fileCO.exists()) {
                strM = null;
            } else {
                strFx = fileCO.getAbsolutePath();
                strM = strFx;
            }
        } else if (iGa != 0) {
            com.kwad.sdk.core.videocache.f fVarCm = com.kwad.sdk.core.videocache.c.a.cm(this.mContext);
            if (com.kwad.sdk.core.config.e.Jp()) {
                int iGa2 = com.kwad.sdk.core.config.e.Ga();
                if (fVarCm.fz(strM)) {
                    strFx = fVarCm.fx(strM);
                } else {
                    if (fVarCm.a(strM, iGa2 * 1024, new com.kwad.sdk.core.network.a.a.C1286a(), null)) {
                        strFx = fVarCm.fx(strM);
                    }
                }
                strM = strFx;
            } else {
                strM = fVarCm.fx(strM);
            }
        }
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        this.cB.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(strM).dR(h.b(com.kwad.sdk.core.response.helper.e.eP(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).IG(), null);
        com.kwad.sdk.core.video.videoview.a.InterfaceC1290a interfaceC1290a = new com.kwad.sdk.core.video.videoview.a.InterfaceC1290a() { // from class: com.kwad.components.ad.interstitial.f.f.1
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1290a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQr)).booleanValue()) {
                    return null;
                }
                com.kwad.components.core.video.g gVar = new com.kwad.components.core.video.g(bVar, f.this.mAdTemplate);
                if (com.kwad.components.core.video.g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cK = interfaceC1290a;
        this.cB.setExternalPlayerListener(interfaceC1290a);
        this.cB.setVideoSoundEnable(this.mIsAudioEnable);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.components.ad.interstitial.report.d.fb().I(this.mAdTemplate);
        this.nN.setVideoPlayCallback(new com.kwad.components.core.video.f.a() { // from class: com.kwad.components.ad.interstitial.f.f.2
            private boolean eV = false;

            @Override // com.kwad.components.core.video.a.c
            public final void as() {
                if (!this.eV) {
                    this.eV = true;
                    com.kwad.components.core.p.a.vL().a(f.this.mAdTemplate, System.currentTimeMillis(), 0);
                }
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mN.mX.iterator();
                while (it.hasNext()) {
                    it.next().as();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void at() {
                com.kwad.sdk.core.adlog.c.cu(f.this.mAdTemplate);
                if (!f.this.mN.mR && f.this.mN.ls != null) {
                    f.this.mN.ls.onVideoPlayEnd();
                }
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mN.mX.iterator();
                while (it.hasNext()) {
                    it.next().at();
                }
                f.this.mN.mZ = true;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                f.this.c(j);
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mN.mX.iterator();
                while (it.hasNext()) {
                    it.next().d(j);
                }
            }

            @Override // com.kwad.components.core.video.f.a
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.interstitial.report.d.fb().b(f.this.mAdTemplate, i, String.valueOf(i2));
                if (f.this.mN.ls != null) {
                    f.this.mN.ls.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.ct(f.this.mAdTemplate);
                com.kwad.components.ad.interstitial.report.d.fb().b(f.this.mAdTemplate, System.currentTimeMillis() - jCurrentTimeMillis);
                com.kwad.components.ad.interstitial.report.b.eX().B(f.this.mAdTemplate);
                if (!f.this.mN.mR && f.this.mN.ls != null) {
                    f.this.mN.ls.onVideoPlayStart();
                }
                Iterator<com.kwad.components.core.video.a.c> it = f.this.mN.mX.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayStart();
                }
                f.this.mN.mZ = false;
            }
        });
        this.cB.setController(this.nN);
        this.fT.setClickable(true);
        new com.kwad.sdk.widget.h(this.fT.getContext(), this.fT, this);
        this.fT.addView(this.cB);
        this.mN.mV = new c.e() { // from class: com.kwad.components.ad.interstitial.f.f.3
            @Override // com.kwad.components.ad.interstitial.f.c.e
            public final void ej() {
                if (f.this.cB != null) {
                    f.this.cB.restart();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j) {
        c cVar = this.mN;
        cVar.mP = true;
        cVar.c(1L, j);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) SB();
        this.mN = cVar;
        this.ce = cVar.ce;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.mAdInfo = adInfoEO;
        List<Integer> listBv = com.kwad.sdk.core.response.helper.a.bv(adInfoEO);
        this.cv = listBv;
        com.kwad.sdk.core.video.videoview.a aVar = this.mN.cB;
        this.cB = aVar;
        aVar.setTag(listBv);
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.cB);
        this.nN = fVar;
        fVar.setDataFlowAutoStart(this.ce.isDataFlowAutoStart());
        this.nN.setAdClickListener(this.iq);
        this.nN.xl();
        this.mApkDownloadHelper = this.mN.mApkDownloadHelper;
        eE();
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        this.fT.setRadius(dimension, dimension, 0.0f, 0.0f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nM = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.fT = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.ik = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.fT.setVisibility(4);
        this.mContext = getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mN.mV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cv.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.mN.a(c(view, true));
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.mN.mAdTemplate, f, f2, f3, f4)) {
            this.mN.a(c(view, false));
        }
    }

    private c.C1150c c(View view, boolean z) {
        return new c.C1150c(view.getContext()).l(z).a(this.nM.getTouchCoords()).W(3).X(85);
    }
}
