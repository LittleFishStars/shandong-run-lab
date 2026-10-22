package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class r extends e {
    private com.kwad.components.ad.splashscreen.e.a HV;
    private com.kwad.components.core.e.d.d IP;
    private com.kwad.components.ad.splashscreen.widget.d IU;
    private KsSplashSlidePathView Ig;
    private double Im;
    private AdMatrixInfo.SplashSlideInfo In;
    private TextView Jd;
    private ImageView Je;
    private TextView kO;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.In = splashSlideInfo;
        this.Im = splashSlideInfo.convertDistance;
        int i = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.d dVar = new com.kwad.components.ad.splashscreen.widget.d(getContext(), i);
        this.IU = dVar;
        this.Je.setImageDrawable(dVar);
        this.Je.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.r.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                r.this.ne();
                if (r.this.IU != null) {
                    r.this.IU.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.In.title)) {
            this.kO.setText(this.In.title);
        } else if (i == 0) {
            this.kO.setText("向上滑动");
        } else if (i == 1) {
            this.kO.setText("向左滑动");
        } else if (i == 2) {
            this.kO.setText("向右滑动");
        }
        if (!TextUtils.isEmpty(this.In.subtitle)) {
            this.Jd.setText(this.In.subtitle);
        } else if (!com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            this.Jd.setText("跳转详情页或者第三方应用");
        } else {
            this.Jd.setText(com.kwad.components.ad.splashscreen.d.a(this.HC.mAdTemplate, this.mAdInfo, this.IP.qn(), 0));
        }
    }

    private void na() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.HV;
        if (aVar != null) {
            aVar.setAdTemplate(this.HC.mAdTemplate);
            return;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HC.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.r.4
            {
                super(adTemplate);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void k(int i, String str) {
                r.this.Jd.setText(str);
            }
        };
        this.HV = aVar2;
        this.IP.b(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne() {
        if (this.In != null) {
            com.kwad.sdk.core.adlog.c.d(this.HC.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().em(this.In.style).ee(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME));
            com.kwad.components.core.webview.tachikoma.e.a.zA().cl(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.HC == null) {
            return;
        }
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.r.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                r.this.HC.He = SystemClock.elapsedRealtime() - r.this.mStartTime;
            }
        });
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        this.IP = this.HC.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            na();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_layout);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.kO = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.Jd = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.Je = (ImageView) findViewById(R.id.ksad_splash_slideView);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub2 != null) {
            this.Ig = (KsSplashSlidePathView) viewStub2.inflate();
        } else {
            this.Ig = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.Ig;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.r.1
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    r rVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(r.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                    if (!SlideConvertHelper.a(r.this.HC.mAdTemplate, f, f2, f3, f4) || (hVar = (rVar = r.this).HC) == null) {
                        return;
                    }
                    hVar.a(1, rVar.getContext(), 153, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.r.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.em(r.this.In.style);
                            bVar.en((int) fPx2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    r rVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    if (!com.kwad.components.ad.splashscreen.h.o(r.this.mAdInfo) || (hVar = (rVar = r.this).HC) == null) {
                        return;
                    }
                    hVar.c(1, rVar.getContext(), 53, 3);
                }
            });
        }
    }
}
