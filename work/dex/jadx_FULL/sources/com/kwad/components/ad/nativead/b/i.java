package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private DetailVideoView mDetailVideoView;
    private MotionEvent qp;

    private void fK() {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.pW.mAdTemplate).b(this.pW.mApkDownloadHelper).D(this.pW.pX.getPlayDuration()).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.b.i.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.pW.mAdTemplate, 2, i.this.pW.pR.getTouchCoords());
            }
        }));
    }

    private void fL() {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.pW.mAdTemplate).b(this.pW.mApkDownloadHelper).D(this.pW.pX.getPlayDuration()).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.nativead.b.i.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.pW.mAdTemplate, 153, i.this.pW.pR.getTouchCoords());
            }
        }));
    }

    private void m(View view) {
        if (view == this.mDetailVideoView) {
            fL();
            notifyAdClick();
        }
    }

    private void notifyAdClick() {
        this.pW.pD.l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.i.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pW.pX.b((l) mVar);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(this);
            this.mDetailVideoView.setOnTouchListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pW.qd && view == this.mDetailVideoView) {
            fK();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
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

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(null);
            this.mDetailVideoView.setOnTouchListener(null);
        }
    }
}
