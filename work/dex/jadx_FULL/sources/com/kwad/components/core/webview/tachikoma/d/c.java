package com.kwad.components.core.webview.tachikoma.d;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class c extends a {
    private String Cd;
    private FrameLayout akX;
    private e asx;
    private p auI;
    private az auJ;
    private com.kwad.components.core.webview.tachikoma.f.e auK = new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.c.2
        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void hm() {
            if (c.this.auJ != null) {
                c.this.auJ.yx();
                c.this.auJ.yy();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void hu() {
            if (c.this.auJ != null) {
                c.this.auJ.yz();
                c.this.auJ.yA();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void zx() {
        e.a aVar = this.auC.auH;
        if (aVar != null) {
            aVar.ho();
        }
        com.kwad.components.core.webview.tachikoma.e.c.zG().x(getTkTemplateId(), getTKReaderScene());
        l lVar = this.auC.auE;
        if (lVar != null) {
            lVar.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        l lVar = this.auC.auE;
        if (lVar != null) {
            lVar.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
        super.aF();
        b bVar = this.auC;
        if (bVar.auG) {
            com.kwad.components.core.webview.tachikoma.f.c cVar = bVar.akL;
            if (cVar != null) {
                cVar.H(true);
                return;
            }
            return;
        }
        e eVar = this.asx;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.f.c cVar2 = this.auC.akL;
        if (cVar2 != null) {
            cVar2.hv();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        e eVar = this.asx;
        if (eVar != null) {
            eVar.a(this.auK);
        }
        if (this.auC.auE != null) {
            this.go.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.d.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.auC.auE.callTKBridge(str);
                }
            });
            this.auC.auE.a(this.go);
            this.go.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.akX;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        StyleTemplate styleTemplate = this.auC.akN;
        return styleTemplate != null ? styleTemplate.templateId : this.Cd;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.akX = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a
    public final void a(b bVar) {
        super.a(bVar);
        b bVar2 = this.auC;
        this.Cd = bVar2.Cd;
        this.asx = bVar2.asx;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        FrameLayout frameLayout = this.akX;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.akX.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height != 0.0f && width != 0.0f) {
            aVar.width = (int) ((width / fBB) + 0.5f);
            aVar.height = (int) ((height / fBB) + 0.5f);
        } else {
            aVar.width = (int) ((bt.getScreenWidth(getContext()) / fBB) + 0.5f);
            aVar.height = (int) ((bt.getScreenHeight(getContext()) / fBB) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.auI = pVar;
        long j = this.auC.Cj;
        if (pVar == null || j <= 0) {
            return;
        }
        z zVar = new z();
        zVar.rq = (int) ((j / 1000.0f) + 0.5f);
        this.auI.a(zVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.auJ = azVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        e eVar = this.asx;
        if (eVar != null) {
            eVar.dismiss();
        }
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.auC.akL;
        if (cVar != null) {
            cVar.H(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        l lVar = this.auC.auE;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.asx;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.asx.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.d.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.asx.e(this);
                        c.this.zx();
                    }
                });
            } else {
                zx();
            }
            this.asx.dismiss();
            return;
        }
        zx();
    }
}
