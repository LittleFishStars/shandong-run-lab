package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
public final class p extends e {
    private com.kwad.components.ad.splashscreen.e.a HV;
    private com.kwad.components.core.e.d.d IP;
    private View IQ;
    private TextView IR;
    private TextView IS;
    private ImageView IT;
    private com.kwad.components.ad.splashscreen.widget.d IU;
    private boolean IV = false;
    private boolean IW = false;
    private KsSlideRoundView If;
    private KsSplashSlidePathView Ig;
    private double Im;
    private AdMatrixInfo.SplashSlideInfo In;
    private float Io;
    private float Ip;
    private float Iq;
    private float Ir;
    private float Is;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void jq() {
        com.kwad.components.ad.splashscreen.widget.d dVar = this.IU;
        if (dVar != null) {
            dVar.start();
        }
        KsSlideRoundView ksSlideRoundView = this.If;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.fY();
        }
    }

    @Nullable
    private Context mS() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.IQ) == null) ? context : view.getContext();
    }

    private boolean mT() {
        try {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
            this.mAdInfo = adInfoEO;
            this.IP = this.HC.mApkDownloadHelper;
            AdMatrixInfo.SplashSlideInfo splashSlideInfo = adInfoEO.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
            this.In = splashSlideInfo;
            this.Im = splashSlideInfo.convertDistance;
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    private void mU() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub != null) {
            this.Ig = (KsSplashSlidePathView) viewStub.inflate();
        } else {
            this.Ig = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.Ig;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.2
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    p.this.b(f, f2, f3, f4);
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    p.this.d(motionEvent);
                }
            });
            this.Ig.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.p.3
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    int[] iArr = new int[2];
                    p.this.Ig.getLocationOnScreen(iArr);
                    p.this.Iq = iArr[0];
                    p.this.Ir = iArr[1];
                    p.a(p.this, true);
                    com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "SlidePathView position: x=" + p.this.Iq + ", y=" + p.this.Ir);
                }
            });
        }
    }

    private void mV() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_backup_layout);
        if (viewStub != null) {
            this.IQ = viewStub.inflate();
        } else {
            this.IQ = findViewById(R.id.ksad_slide_backup_root);
        }
        this.IR = (TextView) findViewById(R.id.ksad_slide_backup_title);
        this.IS = (TextView) findViewById(R.id.ksad_slide_backup_sub_title);
        this.IT = (ImageView) findViewById(R.id.ksad_slide_backup_hand);
        this.If = (KsSlideRoundView) findViewById(R.id.ksad_slide_backup_round_bg);
        mW();
        mX();
        KsSlideRoundView ksSlideRoundView = this.If;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.p.4
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    int[] iArr = new int[2];
                    p.this.If.getLocationOnScreen(iArr);
                    p.this.Io = iArr[0];
                    p.this.Ip = iArr[1];
                    p pVar = p.this;
                    pVar.Is = pVar.If.getWidth();
                    p pVar2 = p.this;
                    pVar2.mActionBarHeight = pVar2.If.getHeight();
                    p.b(p.this, true);
                    com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "ActionBar position: x=" + p.this.Io + ", y=" + p.this.Ip + ", width=" + p.this.Is + ", height=" + p.this.mActionBarHeight);
                }
            });
        }
    }

    private void mW() {
        if (this.IT != null) {
            com.kwad.components.ad.splashscreen.widget.d dVar = new com.kwad.components.ad.splashscreen.widget.d(mS(), 0);
            this.IU = dVar;
            this.IT.setImageDrawable(dVar);
        }
    }

    private void mX() {
        if (this.IR != null) {
            this.IR.setText(TextUtils.isEmpty(this.In.title) ? mY() : this.In.title);
        }
        TextView textView = this.IS;
        if (textView != null) {
            textView.setText(mZ());
        }
    }

    private String mY() {
        int i = this.In.style;
        if (i != 1) {
            return i != 2 ? "向上滑动" : "向右滑动";
        }
        return "向左滑动";
    }

    private String mZ() {
        com.kwad.components.core.e.d.d dVar;
        if (!TextUtils.isEmpty(this.In.subtitle)) {
            return this.In.subtitle;
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo) || (dVar = this.IP) == null) {
            String strDV = com.kwad.sdk.core.response.helper.b.dV(this.mAdInfo);
            return TextUtils.isEmpty(strDV) ? "跳转详情页或第三方应用" : strDV;
        }
        int iQn = dVar.qn();
        AdMatrixInfo.DownloadTexts downloadTexts = this.In.downloadTexts;
        if (iQn != 8) {
            return iQn != 12 ? downloadTexts.adActionDescription : downloadTexts.openAppLabel;
        }
        return downloadTexts.installAppLabel;
    }

    private void na() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.HV;
        if (aVar != null) {
            aVar.setAdTemplate(this.HC.mAdTemplate);
            return;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(mS(), this.HC.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.p.5
            {
                super(adTemplate);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void k(int i, String str) {
                if (p.this.IS != null) {
                    p.this.IS.setText(str);
                }
            }
        };
        this.HV = aVar2;
        this.IP.b(aVar2);
    }

    private void nb() {
        View view = this.IQ;
        if (view != null && this.HC != null) {
            view.setVisibility(0);
            com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, (JSONObject) null);
            com.kwad.components.core.webview.tachikoma.e.a.zA().cl(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE);
        }
        jq();
    }

    private void nc() {
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.c(1, mS(), 53, 1);
        }
    }

    private void nd() {
        com.kwad.components.ad.splashscreen.h hVar = this.HC;
        if (hVar != null) {
            hVar.c(1, mS(), 53, 3);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.HC == null) {
            com.kwad.sdk.core.d.c.w("SplashSlideBackupPresenter", "onBind: mCallerContext is null");
            return;
        }
        if (mT()) {
            mU();
            mV();
            if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
                na();
            }
            nb();
            by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    p.this.HC.He = SystemClock.elapsedRealtime() - p.this.mStartTime;
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.core.e.d.d dVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.a aVar = this.HV;
        if (aVar == null || (dVar = this.IP) == null) {
            return;
        }
        dVar.c(aVar);
    }

    public static /* synthetic */ boolean b(p pVar, boolean z) {
        pVar.IV = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MotionEvent motionEvent) {
        if (e(motionEvent)) {
            com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "handleSingleTouchUp: click on ActionBar area");
            nc();
        } else if (com.kwad.components.ad.splashscreen.h.o(this.mAdInfo)) {
            com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "handleSingleTouchUp: full screen click enabled");
            nd();
        } else {
            com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "handleSingleTouchUp: full screen click disabled, no action");
        }
    }

    private boolean e(MotionEvent motionEvent) {
        boolean z = false;
        if (this.IV && this.IW) {
            float x = motionEvent.getX() + this.Iq;
            float y = motionEvent.getY() + this.Ir;
            float f = this.Io;
            if (x >= f && x <= f + this.Is) {
                float f2 = this.Ip;
                if (y >= f2 && y <= f2 + this.mActionBarHeight) {
                    z = true;
                }
            }
            com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "isClickOnActionBar: touchX=" + x + ", touchY=" + y + ", inRange=" + z);
            return z;
        }
        com.kwad.sdk.core.d.c.w("SplashSlideBackupPresenter", "isClickOnActionBar: position not ready");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, float f2, float f3, float f4) {
        final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(mS(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
        com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "handleSlideTouchUp: distance=" + fPx2dip + "dp, minDistance=" + this.Im + com.kuaishou.weapon.p0.t.q);
        if (SlideConvertHelper.a(this.HC.mAdTemplate, f, f2, f3, f4)) {
            com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "handleSlideTouchUp: slide convert allowed, executing conversion");
            this.HC.a(1, mS(), 153, 1, new com.kwad.components.ad.splashscreen.h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.6
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.em(p.this.In.style);
                    bVar.en((int) fPx2dip);
                }
            });
        } else {
            com.kwad.sdk.core.d.c.d("SplashSlideBackupPresenter", "handleSlideTouchUp: slide convert not allowed");
        }
    }

    public static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.IW = true;
        return true;
    }
}
