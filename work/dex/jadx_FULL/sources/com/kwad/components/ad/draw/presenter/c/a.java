package com.kwad.components.ad.draw.presenter.c;

import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.draw.b.a {

    @Nullable
    private com.kwad.components.ad.l.b dW;
    private DrawVideoTailFrame fs;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.c.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.dW == null || !a.this.dW.bc()) {
                a.this.bt();
            } else {
                a.this.fs.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bt() {
        this.fs.cc();
        this.fs.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.draw.b.b bVar = this.dQ;
        this.dW = bVar.dW;
        this.fs.n(bVar.mAdTemplate);
        this.fs.setAdBaseFrameLayout(this.dQ.mRootContainer);
        this.fs.setApkDownloadHelper(this.dQ.mApkDownloadHelper);
        this.fs.setVisibility(8);
        this.fs.setAdInteractionListener(this.dQ.dB);
        this.dQ.dS.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fs = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dQ.dS.a(this.mVideoPlayStateListener);
        this.fs.release();
    }
}
