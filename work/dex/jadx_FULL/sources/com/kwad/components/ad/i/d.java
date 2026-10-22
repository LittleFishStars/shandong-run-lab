package com.kwad.components.ad.i;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.j.c {
    public static String rI = "PUSH_VIEW_TAG";
    private az fk;
    private final com.kwad.components.core.widget.a.c fx;
    private i go;
    private AdTemplate rJ;
    private com.kwad.components.ad.b.a.b rK;
    private boolean rL;
    private ViewGroup rM;
    private boolean rN;

    public d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.rL = false;
        setTag(rI);
        this.rJ = adTemplate;
        this.fx = new com.kwad.components.core.widget.a.c(this, 100);
        this.go = new i(-1L, getContext()) { // from class: com.kwad.components.ad.i.d.1
            {
                super(-1L, context);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, t tVar, ViewGroup viewGroup) {
                super.a(bVar, dVar, tVar, viewGroup);
                tVar.c(new z(bVar, dVar, this) { // from class: com.kwad.components.ad.i.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.z
                    public final void ai(int i) {
                        super.ai(i);
                        if (i == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.go.a((Activity) null, com.kwad.sdk.core.response.helper.c.ez(this.rJ), this);
    }

    private void destroy() {
        this.go.kV();
        ViewGroup viewGroup = this.rM;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl() {
        if (this.rN) {
            return;
        }
        this.rN = true;
        go();
        destroy();
    }

    private void gm() {
        com.kwad.components.ad.b.a.b bVar = this.rK;
        if (bVar != null) {
            bVar.Y();
        }
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yx();
            this.fk.yy();
        }
    }

    private void go() {
        com.kwad.components.ad.b.a.b bVar = this.rK;
        if (bVar != null) {
            bVar.Z();
        }
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yz();
            this.fk.yA();
        }
    }

    private boolean gp() {
        try {
            com.kwad.sdk.core.c.b.LW();
            final Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View viewFindViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
                if (!(viewFindViewById instanceof ViewGroup)) {
                    return false;
                }
                this.rM = (ViewGroup) viewFindViewById;
                this.rM.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.i.d.2
                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* JADX INFO: renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.LW();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.gl();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadSuccess");
        this.rL = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        this.fx.a(this);
        this.fx.Aa();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        this.fx.release();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageInvisible: ");
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yC();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageVisible: ");
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yB();
        }
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.rK = bVar;
        if (!this.rL || !gp()) {
            return false;
        }
        gm();
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.eu(this.rJ);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final g getTouchCoordsView() {
        return this;
    }

    public final boolean gn() {
        return this.rL;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadFailed");
        this.rL = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((screenHeight / fBB) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.fk = azVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable WebCloseStatus webCloseStatus) {
        gl();
    }
}
