package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.widget.KsRotateTypeTwoView;
import com.kwad.components.ad.splashscreen.widget.KsSlideArrowView;
import com.kwad.components.ad.splashscreen.widget.KsSlideRoundView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView Ie;
    private KsSlideRoundView If;
    private KsSplashSlidePathView Ig;
    private KsRotateTypeTwoView Ih;
    private View Ii;
    private com.kwad.components.ad.splashscreen.d Ij;
    private KsSlideArrowView Ik;
    private KsSlideArrowView Il;
    private double Im;
    private AdMatrixInfo.SplashSlideInfo In;
    private float Io;
    private float Ip;
    private float Iq;
    private float Ir;
    private float Is;
    private boolean It = false;
    private boolean Iu = false;
    private com.kwad.sdk.core.g.c hv;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ() {
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.c(1, mS(), 53, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR() {
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.c(1, mS(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        View rootView;
        this.mStartTime = SystemClock.elapsedRealtime();
        super.ay();
        if (this.HC == null || (rootView = getRootView()) == null) {
            return;
        }
        rootView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.ad.splashscreen.h hVar = l.this.HC;
                if (hVar != null) {
                    hVar.He = SystemClock.elapsedRealtime() - l.this.mStartTime;
                }
            }
        });
        this.HC.a(this);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        this.mAdInfo = adInfoEO;
        try {
            AdMatrixInfo.SplashSlideInfo splashSlideInfo = adInfoEO.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
            this.In = splashSlideInfo;
            this.Im = splashSlideInfo.convertDistance;
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
            if (viewStub != null) {
                this.Ig = (KsSplashSlidePathView) viewStub.inflate();
            } else {
                this.Ig = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
            }
            KsSplashSlidePathView ksSplashSlidePathView = this.Ig;
            if (ksSplashSlidePathView != null) {
                ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2
                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void a(float f, float f2, float f3, float f4) {
                        l lVar;
                        com.kwad.components.ad.splashscreen.h hVar;
                        final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(l.this.mS(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                        if (!SlideConvertHelper.a(l.this.HC.mAdTemplate, f, f2, f3, f4) || (hVar = (lVar = l.this).HC) == null) {
                            return;
                        }
                        hVar.a(1, lVar.mS(), 153, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2.1
                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                                bVar.em(l.this.In.style);
                                bVar.en((int) fPx2dip);
                            }
                        });
                    }

                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void c(MotionEvent motionEvent) {
                        if (l.this.It && l.this.Iu) {
                            float x = motionEvent.getX() + l.this.Iq;
                            float y = motionEvent.getY() + l.this.Ir;
                            if (x >= l.this.Io && x <= l.this.Io + l.this.Is && y >= l.this.Ip && y <= l.this.Ip + l.this.mActionBarHeight) {
                                l.this.mQ();
                                return;
                            }
                        }
                        if (com.kwad.components.ad.splashscreen.h.o(l.this.mAdInfo)) {
                            l.this.mR();
                        }
                    }
                });
                this.Ig.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.3
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        int[] iArr = new int[2];
                        l.this.Ig.getLocationOnScreen(iArr);
                        l.this.Iq = iArr[0];
                        l.this.Ir = iArr[1];
                        l.a(l.this, true);
                    }
                });
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void ck() {
        com.kwad.sdk.core.adlog.c.cw(this.HC.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void fY() {
        KsSlideArrowView ksSlideArrowView = this.Ik;
        if (ksSlideArrowView != null && this.Il != null) {
            ksSlideArrowView.postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.5
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    l.this.Ik.fY();
                }
            }, 200L);
            this.Il.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.6
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    l.this.Il.fY();
                }
            });
        }
        KsRotateTypeTwoView ksRotateTypeTwoView = this.Ih;
        if (ksRotateTypeTwoView != null) {
            ksRotateTypeTwoView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.7
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    l.this.Ih.fY();
                }
            });
        }
        KsSlideRoundView ksSlideRoundView = this.If;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.8
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    l.this.If.fY();
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_combo_layout);
        if (viewStub != null) {
            this.Ii = viewStub.inflate();
        } else {
            this.Ii = findViewById(R.id.ksad_rotate_combo_root);
        }
        this.If = (KsSlideRoundView) findViewById(R.id.ksad_rotate_combo_slide_round_img);
        this.Ie = (TextView) findViewById(R.id.ksad_rotate_combo_action_text);
        this.Ih = (KsRotateTypeTwoView) findViewById(R.id.ksad_rotate_combo_rotate_view);
        this.Ik = (KsSlideArrowView) findViewById(R.id.ksad_rotate_combo_slide_arrow_top);
        this.Il = (KsSlideArrowView) findViewById(R.id.ksad_rotate_combo_slide_arrow_bottom);
        this.Ik.setAnimationDelayTime(200);
        this.Il.setAnimationDelayTime(200);
        this.If.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.l.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                int[] iArr = new int[2];
                l.this.If.getLocationOnScreen(iArr);
                l.this.Io = iArr[0];
                l.this.Ip = iArr[1];
                l lVar = l.this;
                lVar.Is = lVar.If.getWidth();
                l lVar2 = l.this;
                lVar2.mActionBarHeight = lVar2.If.getHeight();
                l.b(l.this, true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mJ() {
        AdTemplate adTemplate = this.HC.mAdTemplate;
        com.kwad.components.ad.splashscreen.d dVarA = com.kwad.components.ad.splashscreen.d.a(adTemplate, com.kwad.sdk.core.response.helper.e.eO(adTemplate), this.HC.mApkDownloadHelper, 10);
        this.Ij = dVarA;
        TextView textView = this.Ie;
        if (textView != null) {
            textView.setText(dVarA.lW());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mK() {
        View view = this.Ii;
        if (view == null || this.HC == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, 200, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(200);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mL() {
        AdMatrixInfo.RotateInfo rotateInfoDL = com.kwad.sdk.core.response.helper.b.dL(this.HC.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(rotateInfoDL);
            this.hv = cVar2;
            cVar2.a(this);
        } else {
            cVar.b(rotateInfoDL);
        }
        KsRotateTypeTwoView ksRotateTypeTwoView = this.Ih;
        if (ksRotateTypeTwoView != null) {
            ksRotateTypeTwoView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mM() {
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.cb(mS());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void mN() {
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.cc(mS());
        }
    }

    @Nullable
    public final Context mS() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.Ii) == null) ? context : view.getContext();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
        com.kwad.sdk.core.g.c cVar = this.hv;
        if (cVar != null) {
            cVar.cc(mS());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.c(1, mS(), 162, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotateComboPresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.b(this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void t(final String str) {
        boolean zAe = this.HC.GP.Ae();
        boolean zPG = com.kwad.components.core.e.c.b.pG();
        if (!zAe || zPG) {
            return;
        }
        this.Ik.oc();
        this.Il.oc();
        this.If.oc();
        this.Ih.oc();
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.a(1, mS(), 161, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.9
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.ef(str);
                }
            });
        }
        mP();
        mN();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void j(int i, String str) {
        if (this.Ie != null) {
            if (i != 2) {
                str = "扭动或点击" + str;
            }
            this.Ie.setText(str);
        }
    }

    public static /* synthetic */ boolean a(l lVar, boolean z) {
        lVar.Iu = true;
        return true;
    }

    public static /* synthetic */ boolean b(l lVar, boolean z) {
        lVar.It = true;
        return true;
    }
}
