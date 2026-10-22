package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bj;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.by;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements p {
    private final KsAdWebView aiB;
    private long aiC;
    private int aiD;
    private PlayableSource aiE = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<as.b> aiF = new CopyOnWriteArrayList();
    private List<KsAdWebView.e> aiG = new CopyOnWriteArrayList();

    @Nullable
    private com.kwad.components.core.webview.a fh;
    private az fk;

    @Nullable
    private AdTemplate mAdTemplate;
    private d mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* JADX INFO: renamed from: com.kwad.components.core.playable.a$a, reason: collision with other inner class name */
    public static class C1228a implements bj.b {
        private final WeakReference<a> aiI;

        public C1228a(a aVar) {
            this.aiI = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.bj.b
        public final void ao(int i) {
            a aVar = this.aiI.get();
            if (aVar != null) {
                aVar.bP(i);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.aiB = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                a.this.aiC = SystemClock.elapsedRealtime();
                a.this.aiB.getClientConfig().bR(true);
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().fo(this.mAdTemplate).b(jG()));
        a(ksAdWebView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i) {
        if (getAdTemplate() == null) {
            return;
        }
        long jKk = e.Kk();
        if (jKk <= 0 || SystemClock.elapsedRealtime() - this.aiC <= jKk) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(this.mContext).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(false).aM(i).d(this.mRootContainer.getTouchCoords()).au(true));
        }
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.helper.a.bX(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
    }

    private KsAdWebView.e jG() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                Iterator it = a.this.aiG.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                Iterator it = a.this.aiG.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                Iterator it = a.this.aiG.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onReceivedHttpError(i, str, str2);
                }
            }
        };
    }

    private void uv() {
        if (com.kwad.sdk.core.response.helper.a.bT(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)) > 0) {
            by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.aiB.getClientConfig().bR(true);
                }
            }, com.kwad.sdk.core.response.helper.a.bT(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.helper.a.bT(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)) == 0) {
            this.aiB.getClientConfig().bR(true);
        }
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.aiE = playableSource;
        }
        if (this.aiB == null) {
            return;
        }
        uv();
        c.d("PlayableViewHelper", "showPlayable");
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yx();
        }
        this.aiB.setVisibility(0);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yy();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.aiB;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void iW() {
        c.d("PlayableViewHelper", "showPlayable");
        if (this.aiB == null) {
            return;
        }
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yz();
        }
        this.aiB.setVisibility(8);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yA();
        }
        this.aiB.reload();
    }

    public final void vx() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    public final void vy() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.aiB) == null) {
            return;
        }
        ksAdWebView.getClientConfig().bR(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.aiB.loadUrl(url);
        }
        com.kwad.sdk.core.adlog.c.cz(this.mAdTemplate);
    }

    public final boolean vz() {
        return this.aiB != null && this.aiD == 1;
    }

    public final void b(@Nullable as.b bVar) {
        this.aiF.remove(bVar);
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (e.Kj()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, d dVar) {
        if (this.aiB == null) {
            c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = dVar;
        this.aiD = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.bbV = adBaseFrameLayout2;
        bVar.adW = adBaseFrameLayout2;
        bVar.ade = this.aiB;
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.aiB);
        this.fh = aVar;
        a(bVar, aVar, dVar);
        this.aiB.addJavascriptInterface(this.fh, "KwaiAd");
    }

    public final void a(@Nullable as.b bVar) {
        this.aiF.add(bVar);
    }

    public final void a(@Nullable KsAdWebView.e eVar) {
        this.aiG.add(eVar);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, d dVar) {
        aVar.a(new bj(bVar, dVar, new C1228a(this)));
        aVar.a(new as(new as.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                a.this.aiD = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.adlog.c.cy(a.this.mAdTemplate);
                }
                Iterator it = a.this.aiF.iterator();
                while (it.hasNext()) {
                    ((as.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new am(bVar));
        aVar.b(new o(bVar));
        aVar.b(new n(bVar));
        this.fk = new az();
        aVar.a(new ah());
        aVar.a(new ag(bVar));
        aVar.a(new f());
        aVar.a(this.fk);
        aVar.a(new j(this));
    }

    @Override // com.kwad.components.core.webview.jshandler.p
    public final void a(j jVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            jVar.f(this.aiE);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        jVar.cc(adTemplate.adStyle);
    }
}
