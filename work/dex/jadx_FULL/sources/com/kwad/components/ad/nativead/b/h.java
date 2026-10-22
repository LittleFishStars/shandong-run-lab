package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private MotionEvent qp;
    private ViewGroup qu;
    private TextView qv;

    /* JADX INFO: Access modifiers changed from: private */
    public void fI() {
        try {
            this.qv.setText(com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(this.pW.mAdTemplate)));
            this.qu.setOnClickListener(this);
            this.qu.setOnTouchListener(this);
            this.qu.setVisibility(0);
            this.qv.setVisibility(0);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ() {
        try {
            this.qu.setVisibility(8);
            this.qv.setVisibility(8);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void fK() {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.pW.mAdTemplate).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.b.h.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.pW.mAdTemplate, 2, h.this.pW.pR.getTouchCoords());
            }
        }));
    }

    private void fL() {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.pW.mAdTemplate).b(this.pW.mApkDownloadHelper).D(this.pW.pX.getPlayDuration()).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.b.h.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.pW.mAdTemplate, 153, h.this.pW.pR.getTouchCoords());
            }
        }));
    }

    private void m(View view) {
        if (view == this.qu) {
            fL();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        ViewGroup viewGroup = this.qu;
        if (viewGroup != null) {
            this.pW.pD.l(viewGroup);
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.h.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                h.this.fI();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                h.this.fJ();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pW.pX.b((l) mVar);
        ViewGroup viewGroup = this.qu;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pW.qd) {
            fK();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qu = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.qv = (TextView) findViewById(R.id.ksad_h5_open);
        com.kwad.components.ad.nativead.a.a.a(this.qu, "NativePlayEndH5Presenter: R.id.ksad_video_complete_h5_container is null");
        com.kwad.components.ad.nativead.a.a.a(this.qv, "NativePlayEndH5Presenter: R.id.ksad_h5_open is null");
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.qp = MotionEvent.obtain(motionEvent);
        } else if (action == 1 || action == 3) {
            if (com.kwad.sdk.utils.b.a(this.qp, motionEvent)) {
                com.kwad.components.ad.nativead.a.b bVar = this.pW;
                if (bVar.qc && (motionEvent2 = this.qp) != null && com.kwad.sdk.utils.b.a(motionEvent2, motionEvent, bVar.mAdTemplate)) {
                    m(view);
                }
                z = true;
            }
            this.qp = null;
        }
        return z;
    }
}
