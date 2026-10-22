package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.draw.a.d;
import com.kwad.components.ad.draw.presenter.livecard.KsLiveAuthorView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends KSFrameLayout implements View.OnClickListener {
    private List<Integer> cv;
    private KsDrawAd.AdInteractionListener dB;
    private com.kwad.sdk.core.j.b dH;
    private com.kwad.components.ad.draw.b.b dQ;
    private IAdLivePlayModule dT;
    private final AdLivePlayStateListener ey;
    private boolean fA;
    private final com.kwad.sdk.core.j.c fF;
    private IAdLiveOfflineView fH;
    private com.kwad.components.core.offline.a.c.a fI;
    private boolean fJ;
    private KsLiveAuthorView fK;
    private TextView fL;
    private TextView fM;
    private TextView fN;
    private KsLogoView fO;
    private View fP;
    private ViewGroup fQ;
    private String fR;
    private KsLogoView fS;
    private KSFrameLayout fT;
    private com.kwad.components.core.l.a.b fU;
    private int fV;
    private View fW;
    private long fX;
    private boolean fY;
    private boolean fZ;
    private com.kwad.components.core.widget.a.c fx;
    private boolean ga;
    private boolean gb;
    private Runnable gc;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bx mTimerHelper;

    public a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        super(context);
        this.fV = -1;
        this.fF = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.draw.view.a.2
            @Override // com.kwad.sdk.core.j.c
            public final void bA() {
                if (a.this.gb) {
                    if (a.this.dT != null) {
                        a.this.dT.onPause();
                    }
                    com.kwad.components.core.l.a.tm().c(a.this.fU);
                    a.this.gb = false;
                }
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                try {
                    a.this.gb = true;
                    if (a.this.dT == null) {
                        a aVar = a.this;
                        aVar.dT = aVar.bG();
                    }
                    com.kwad.components.core.l.a.tm().a(a.this.getCurrentVoiceItem());
                    a.this.dT.onResume();
                    a.this.getTimerHelper().startTiming();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        };
        this.gc = new Runnable() { // from class: com.kwad.components.ad.draw.view.a.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.c.a.a.a(a.this.fM, a.this.fR, KsLogoView.a(a.this.fS));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    a.this.fM.setText(a.this.fR);
                    a.this.fM.setVisibility(0);
                }
            }
        };
        this.ey = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.draw.view.a.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                bVar.el(24);
                bVar.b(c1273a);
                com.kwad.components.core.t.b.wF().a(a.this.mAdTemplate, null, bVar);
                a.this.fQ.setVisibility(8);
                a.this.fW.setVisibility(0);
                if (a.this.ga) {
                    return;
                }
                a.b(a.this, true);
                com.kwad.components.ad.draw.a.c.k(a.this.mAdTemplate);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                if (com.kwad.sdk.core.response.helper.a.cZ(a.this.mAdInfo)) {
                    com.kwad.sdk.core.adlog.c.q(a.this.mAdTemplate, (int) Math.ceil(a.this.getTimerHelper().getTime() / 1000.0f));
                }
                if (a.this.fY) {
                    return;
                }
                a.c(a.this, true);
                com.kwad.components.ad.draw.a.c.i(a.this.mAdTemplate);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                a.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.l.a.tm().a(a.this.getCurrentVoiceItem());
                a.this.dT.setAudioEnabled(a.this.isVideoSoundEnable(), false);
                if (a.this.fZ) {
                    return;
                }
                a.d(a.this, true);
                com.kwad.components.ad.draw.a.c.j(a.this.mAdTemplate);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                if (!a.this.mAdTemplate.mPvReported && a.this.dQ != null && a.this.dQ.dB != null) {
                    a.this.dQ.dB.onAdShow();
                    d.g(a.this.mAdTemplate, 1, com.kwad.sdk.core.response.helper.b.dF(a.this.mAdTemplate) ? 2 : 1);
                    d.a(a.this.mAdTemplate, 1);
                    com.kwad.components.ad.draw.a.c.a(a.this.mAdTemplate, SystemClock.elapsedRealtime() - a.this.fX);
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.b(new com.kwad.sdk.core.adlog.a.C1273a());
                com.kwad.components.core.t.b.wF().a(a.this.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.f(a.this.mAdTemplate, null);
                com.kwad.components.core.l.a.tm().a(a.this.getCurrentVoiceItem());
                a.this.dT.setAudioEnabled(a.this.isVideoSoundEnable(), false);
                a.this.fQ.setVisibility(0);
                a.this.fW.setVisibility(8);
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        this.fI = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
        final WeakReference weakReference = new WeakReference(m.getActivityFromContext(this.mContext));
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.draw.view.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                a.this.bH();
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
        initView();
        bD();
        bC();
        bB();
    }

    private void bB() {
        this.fQ.setOnClickListener(this);
        this.fN.setOnClickListener(this);
        this.fK.setOnClickListener(this);
        this.fM.setOnClickListener(this);
        this.fL.setOnClickListener(this);
        this.mRootContainer.setOnClickListener(this);
    }

    private void bC() {
        try {
            ViewGroup viewGroup = this.fQ;
            if (viewGroup == null) {
                return;
            }
            this.fK = (KsLiveAuthorView) viewGroup.findViewById(R.id.ksad_live_author_icon);
            this.fL = (TextView) this.fQ.findViewById(R.id.kwad_actionbar_title);
            this.fM = (TextView) this.fQ.findViewById(R.id.kwad_actionbar_des_text);
            this.fN = (TextView) this.fQ.findViewById(R.id.ksad_live_actionbar_btn);
            this.fO = (KsLogoView) this.fQ.findViewById(R.id.ksad_draw_live_kwai_logo);
            if (this.fJ) {
                return;
            }
            this.fP = this.fQ.findViewById(R.id.ksad_draw_origin_live_relative);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void bD() {
        if (this.mRootContainer == null) {
            return;
        }
        if (8 == com.kwad.sdk.core.response.helper.a.bm(this.mAdInfo)) {
            this.fQ = (ViewGroup) ((ViewStub) this.mRootContainer.findViewById(R.id.ksad_draw_live_shop_stub)).inflate();
            this.fJ = true;
        } else {
            this.fQ = (ViewGroup) ((ViewStub) this.mRootContainer.findViewById(R.id.ksad_draw_live_base_stub)).inflate();
            this.fJ = false;
        }
        this.fQ.setVisibility(4);
    }

    private void bF() {
        this.fL.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.fK.setVisibility(0);
        this.fK.n(this.mAdTemplate);
        this.fK.a(eVar);
        this.fN.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
        if (com.kwad.sdk.core.response.helper.a.bm(this.mAdInfo) == 8) {
            this.fO.setVisibility(0);
            this.fO.bl(this.mAdTemplate);
            this.fM.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        } else {
            this.fR = com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo);
            KsLogoView ksLogoView = new KsLogoView(this.fQ.getContext(), false);
            this.fS = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.draw.view.a.3
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void bK() {
                    a.this.fM.post(a.this.gc);
                }
            });
            this.fS.bl(this.mAdTemplate);
            this.fO.setVisibility(8);
        }
        com.kwad.components.ad.draw.a.c.h(this.mAdTemplate);
        this.fX = SystemClock.elapsedRealtime();
        this.dQ = bI();
        Presenter presenterBJ = bJ();
        this.mPresenter = presenterBJ;
        presenterBJ.N(this.mRootContainer);
        this.mPresenter.q(this.dQ);
        this.fx.a(this.dH);
        this.fx.a(this.fF);
        this.fx.Aa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bG() {
        try {
            IAdLivePlayModule iAdLivePlayModule = this.dT;
            if (iAdLivePlayModule != null) {
                return iAdLivePlayModule;
            }
            com.kwad.components.core.offline.a.c.a aVar = this.fI;
            if (aVar != null && aVar.tu() && com.kwad.sdk.core.response.helper.a.cY(e.eO(this.mAdTemplate))) {
                IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.fI, this.mContext, com.kwad.sdk.core.response.helper.a.bm(this.mAdInfo) == 8 ? 1 : 0);
                this.fH = iAdLiveOfflineViewA;
                if (iAdLiveOfflineViewA == null) {
                    return null;
                }
                IAdLivePlayModule adLivePlayModule = this.fI.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.helper.a.cw(this.mAdInfo)), com.kwad.sdk.core.response.helper.a.cx(this.mAdInfo), com.kwad.sdk.core.response.helper.a.cy(this.mAdInfo), e.eI(this.mAdTemplate));
                adLivePlayModule.setAudioEnabled(isVideoSoundEnable(), false);
                adLivePlayModule.registerAdLivePlayStateListener(this.ey);
                View view = this.fH.getView();
                if (this.fT.getTag() != null) {
                    KSFrameLayout kSFrameLayout = this.fT;
                    kSFrameLayout.removeView((View) kSFrameLayout.getTag());
                    this.fT.setTag(null);
                }
                this.fT.addView(view);
                this.fT.setTag(view);
                return adLivePlayModule;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH() {
        com.kwad.components.core.widget.a.c cVar = this.fx;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.draw.b.b bVar = this.dQ;
        if (bVar != null) {
            bVar.release();
        }
        if (this.dT != null) {
            this.dT = null;
        }
        if (this.fH != null) {
            this.fH = null;
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
        com.kwad.components.core.l.a.tm().c(this.fU);
    }

    private com.kwad.components.ad.draw.b.b bI() {
        com.kwad.components.ad.draw.b.b bVar = new com.kwad.components.ad.draw.b.b();
        bVar.dB = this.dB;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo) && bVar.mApkDownloadHelper == null) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        }
        if (this.dT == null) {
            this.dT = bG();
        }
        bVar.dT = this.dT;
        bVar.dU = this.fH;
        bVar.dV = new com.kwad.components.ad.draw.presenter.b.a(this.mAdTemplate);
        return bVar;
    }

    private static Presenter bJ() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.presenter.b());
        presenter.a(new com.kwad.components.ad.draw.presenter.livecard.b());
        presenter.a(new com.kwad.components.ad.draw.presenter.livecard.a());
        return presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.l.a.b getCurrentVoiceItem() {
        if (this.fU == null) {
            this.fU = new com.kwad.components.core.l.a.b(new com.kwad.components.core.l.a.c() { // from class: com.kwad.components.ad.draw.view.a.6
                @Override // com.kwad.components.core.l.a.c
                public final void bL() {
                    if (a.this.dT == null) {
                        a aVar = a.this;
                        aVar.dT = aVar.bG();
                    }
                    if (a.this.dT != null) {
                        a.this.dT.setAudioEnabled(a.this.isVideoSoundEnable(), false);
                    }
                }
            });
        }
        return this.fU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            bx bxVar = new bx();
            this.mTimerHelper = bxVar;
            bxVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private void initView() {
        m.a(this.mContext, R.layout.ksad_draw_ad_live_layout, this, true);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_live_container);
        this.mRootContainer = adBaseFrameLayout;
        this.fT = (KSFrameLayout) adBaseFrameLayout.findViewById(R.id.ksad_draw_video_container);
        this.fW = this.mRootContainer.findViewById(R.id.ksad_draw_live_frame_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVideoSoundEnable() {
        if (this.fV == 1) {
            return !this.fA;
        }
        return !com.kwad.sdk.core.response.helper.a.ci(e.eO(this.mAdTemplate));
    }

    public final void bE() {
        this.fx = new com.kwad.components.ad.draw.b(this);
        this.cv = com.kwad.sdk.core.response.helper.a.bv(this.mAdInfo);
        bF();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.fN)) {
            this.dQ.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.fK)) {
            this.dQ.a(1, view.getContext(), 30, 2);
            return;
        }
        if (view.equals(this.fM)) {
            this.dQ.a(1, view.getContext(), 32, 2);
            return;
        }
        if (view.equals(this.fL)) {
            this.dQ.a(1, view.getContext(), 31, 2);
            return;
        }
        if (view.equals(this.fQ)) {
            this.dQ.a(1, view.getContext(), 53, 2);
        } else if (view.equals(this.mRootContainer) || view.equals(this.fT)) {
            this.dQ.a(1, view.getContext(), 85, 3);
        }
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dB = adInteractionListener;
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dH = bVar;
    }

    public final void setVideoSound(boolean z) {
        IAdLivePlayModule iAdLivePlayModule = this.dT;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setAudioEnabled(z, false);
        }
        this.fA = !z;
        this.fV = 1;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.ga = true;
        return true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.fY = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.fZ = true;
        return true;
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
}
