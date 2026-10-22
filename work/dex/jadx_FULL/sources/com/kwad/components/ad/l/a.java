package com.kwad.components.ad.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private KsAdWebView ND;
    private boolean NE;
    private boolean NF;
    protected AdBaseFrameLayout NG;
    private InterfaceC1154a NH;
    private c.a NL;
    private b NM;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a fl;
    private FrameLayout fu;
    private AdBaseFrameLayout gN;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean NC = true;
    private Handler jk = new Handler(Looper.getMainLooper());
    private boolean NI = false;
    private boolean NJ = false;
    private boolean NK = false;

    /* JADX INFO: renamed from: com.kwad.components.ad.l.a$a, reason: collision with other inner class name */
    public interface InterfaceC1154a {
        void T(boolean z);
    }

    public interface b {
        void jS();
    }

    private static String O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.a.aY(e.eO(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cN() {
        if (this.NK) {
            return !this.NC;
        }
        return (this.NC || this.NI || this.NJ) ? false : true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void gE() {
        this.fu.removeAllViews();
        this.fu.setVisibility(4);
        this.NG = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.c.a.a.a((ViewGroup) this.fu, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.fu.findViewById(R.id.ksad_web_card_webView);
        this.ND = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        c.a aVarB = this.ND.getClientConfig().bR(false).bV(true).bU(false).bQ(true).fo(this.mAdTemplate).a(oq()).b(jG());
        this.NL = aVarB;
        this.ND.setClientConfig(aVarB);
        this.ND.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.l.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.a(a.this, true);
                if (a.this.NH != null) {
                    a.this.NH.T(a.this.cN());
                }
            }
        });
        ImageView imageView = (ImageView) this.NG.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.l.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.NM != null) {
                    a.this.NM.jS();
                }
            }
        });
    }

    private KsAdWebView.e jG() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.l.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.NH != null) {
                    a.this.NH.T(a.this.cN());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                a.b(a.this, true);
                if (a.this.NH != null) {
                    a.this.NH.T(a.this.cN());
                }
            }
        };
    }

    private KsAdWebView.b oq() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.l.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.NH != null) {
                    a.this.NH.T(a.this.cN());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.NH != null) {
                    a.this.NH.T(a.this.cN());
                }
            }
        };
    }

    private boolean or() {
        if (!cN()) {
            FrameLayout frameLayout = this.fu;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            return false;
        }
        FrameLayout frameLayout2 = this.fu;
        if (frameLayout2 == null) {
            return true;
        }
        frameLayout2.setVisibility(0);
        return true;
    }

    public final a ai(boolean z) {
        this.NF = true;
        return this;
    }

    public final boolean bc() {
        boolean zOr = or();
        this.NK = true;
        if (zOr && this.mActivity != null) {
            if (this.ND.getClientConfig() != null) {
                this.ND.getClientConfig().bR(true);
                this.ND.getClientConfig().bU(true);
            }
            this.NG.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.l.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.d.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && jElapsedRealtime > 30 && jElapsedRealtime < 500) {
                            com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.gN.getTouchCoords());
                            if (!a.this.NE) {
                                a.d(a.this, true);
                                if (a.this.fl != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.ara = 3;
                                    a.this.fl.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long jAq = com.kwad.sdk.core.response.helper.a.aq(e.eO(this.mAdTemplate));
            if (jAq == 0 || !this.NF) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.jk.postDelayed(new Runnable() { // from class: com.kwad.components.ad.l.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, jAq);
            }
            KsAdWebView ksAdWebView = this.ND;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return zOr;
    }

    public final void bj() {
        this.fu.setVisibility(4);
        String strO = O(this.mAdTemplate);
        if (TextUtils.isEmpty(strO)) {
            return;
        }
        this.ND.loadUrl(strO);
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.NC = true;
        return true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.NI = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.NE = true;
        return true;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.NJ = true;
        return true;
    }

    public final void a(InterfaceC1154a interfaceC1154a) {
        this.NH = interfaceC1154a;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.fu = frameLayout;
        this.gN = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        gE();
        this.NC = false;
    }

    public final void a(b bVar) {
        this.NM = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.fl = aVar;
    }
}
