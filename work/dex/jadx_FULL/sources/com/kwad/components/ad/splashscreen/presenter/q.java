package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.widget.KsSlideHandView;
import com.kwad.components.ad.splashscreen.widget.KsSlideRoundView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class q extends e {
    private com.kwad.components.ad.splashscreen.e.a HV;
    private com.kwad.components.core.e.d.d IP;
    private View IY;
    private TextView IZ;
    private KsSlideRoundView If;
    private KsSplashSlidePathView Ig;
    private double Im;
    private AdMatrixInfo.SplashSlideInfo In;
    private float Io;
    private float Ip;
    private float Iq;
    private float Ir;
    private float Is;
    private boolean It = false;
    private boolean Iu = false;
    private KsSlideHandView Ja;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void aq() {
        View view = this.IY;
        if (view == null || this.HC == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.zA().cl(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_combo_layout);
        if (viewStub != null) {
            this.IY = viewStub.inflate();
        } else {
            this.IY = findViewById(R.id.ksad_slide_combo_root);
        }
        this.Ja = (KsSlideHandView) findViewById(R.id.ksad_slide_combo_slide_hand);
        this.IZ = (TextView) findViewById(R.id.ksad_slide_combo_action_sub_text);
        this.If = (KsSlideRoundView) findViewById(R.id.ksad_slide_combo_round_bg);
        this.IZ.setText(mZ());
        this.If.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.q.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                int[] iArr = new int[2];
                q.this.If.getLocationOnScreen(iArr);
                q.this.Io = iArr[0];
                q.this.Ip = iArr[1];
                q qVar = q.this;
                qVar.Is = qVar.If.getWidth();
                q qVar2 = q.this;
                qVar2.mActionBarHeight = qVar2.If.getHeight();
                q.b(q.this, true);
            }
        });
    }

    private void jq() {
        KsSlideHandView ksSlideHandView = this.Ja;
        if (ksSlideHandView != null) {
            ksSlideHandView.fY();
        }
        KsSlideRoundView ksSlideRoundView = this.If;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.fY();
        }
    }

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
            hVar.c(1, mS(), 53, 3);
        }
    }

    private String mZ() {
        try {
            return TextUtils.isEmpty(com.kwad.sdk.core.response.helper.b.dV(this.mAdInfo)) ? com.kwad.sdk.core.response.helper.b.dV(this.mAdInfo) : "跳转详情页或第三方应用";
        } catch (Exception unused) {
            return "跳转详情页或第三方应用";
        }
    }

    private void na() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.HV;
        if (aVar != null) {
            aVar.setAdTemplate(this.HC.mAdTemplate);
            return;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(mS(), this.HC.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.q.5
            {
                super(adTemplate);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void k(int i, String str) {
                if (q.this.IZ != null) {
                    q.this.IZ.setText(str);
                }
            }
        };
        this.HV = aVar2;
        this.IP.b(aVar2);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar == null) {
            return;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(hVar.mAdTemplate);
        this.mAdInfo = adInfoEO;
        this.IP = this.HC.mApkDownloadHelper;
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
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    q qVar;
                    com.kwad.components.ad.splashscreen.h hVar2;
                    final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(q.this.mS(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                    if (!SlideConvertHelper.a(q.this.HC.mAdTemplate, f, f2, f3, f4) || (hVar2 = (qVar = q.this).HC) == null) {
                        return;
                    }
                    hVar2.a(1, qVar.mS(), 153, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.em(q.this.In.style);
                            bVar.en((int) fPx2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    if (q.this.It && q.this.Iu) {
                        float x = motionEvent.getX() + q.this.Iq;
                        float y = motionEvent.getY() + q.this.Ir;
                        if (x >= q.this.Io && x <= q.this.Io + q.this.Is && y >= q.this.Ip && y <= q.this.Ip + q.this.mActionBarHeight) {
                            q.this.mQ();
                            return;
                        }
                    }
                    if (com.kwad.components.ad.splashscreen.h.o(q.this.mAdInfo)) {
                        q.this.mR();
                    }
                }
            });
            this.Ig.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    int[] iArr = new int[2];
                    q.this.Ig.getLocationOnScreen(iArr);
                    q.this.Iq = iArr[0];
                    q.this.Ir = iArr[1];
                    q.a(q.this, true);
                }
            });
        }
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.q.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                q.this.HC.He = SystemClock.elapsedRealtime() - q.this.mStartTime;
            }
        });
        initView();
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            na();
        }
        aq();
        jq();
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
        return (context != null || (view = this.IY) == null) ? context : view.getContext();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    public static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.Iu = true;
        return true;
    }

    public static /* synthetic */ boolean b(q qVar, boolean z) {
        qVar.It = true;
        return true;
    }
}
