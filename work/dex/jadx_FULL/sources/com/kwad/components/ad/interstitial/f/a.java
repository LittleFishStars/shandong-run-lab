package com.kwad.components.ad.interstitial.f;

import android.text.TextUtils;
import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private ComplianceTextView mI;
    private OrientationEventListener mJ;
    private KsAutoCloseView mK;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        h(this.mI);
        if (as.isOrientationPortrait()) {
            com.kwad.sdk.c.a.a.c(this.mK, 0, com.kwad.sdk.c.a.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.c.a.a.c(this.mK, 0, 0, 0, 0);
        }
        if (c(cVar)) {
            this.mI.setVisibility(0);
            this.mI.setAdTemplate(cVar.mAdTemplate);
        }
    }

    private static boolean c(c cVar) {
        try {
            return !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.e.eO(cVar.mAdTemplate).downloadSafeInfo.appName);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    private void h(View view) {
        int iA = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        int iA2 = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
        com.kwad.sdk.c.a.a.c(view, iA2, iA, iA2, 0);
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) SB();
        b(cVar);
        a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mI = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.mK = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.mJ;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    private void a(final c cVar) {
        OrientationEventListener orientationEventListener = new OrientationEventListener(cVar.lx.getContext()) { // from class: com.kwad.components.ad.interstitial.f.a.1
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i) {
                a.this.b(cVar);
            }
        };
        this.mJ = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.mJ.enable();
        } else {
            this.mJ.disable();
        }
    }
}
