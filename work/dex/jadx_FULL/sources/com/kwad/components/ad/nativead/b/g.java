package com.kwad.components.ad.nativead.b;

import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends com.kwad.components.ad.nativead.a.a {
    private ImageView qs;

    /* JADX INFO: Access modifiers changed from: private */
    public void fM() {
        KSImageLoader.loadImage(this.qs, com.kwad.sdk.core.response.helper.a.aa(com.kwad.sdk.core.response.helper.e.eO(this.pW.mAdTemplate)), this.pW.mAdTemplate);
        this.qs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN() {
        if (this.qs.getVisibility() == 0) {
            this.qs.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.g.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                g.this.fM();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                g.this.fN();
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pW.pX.b((l) mVar);
        this.qs.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_cover_image);
        this.qs = imageView;
        com.kwad.components.ad.nativead.a.a.a(imageView, "NativePlayEndCoverPresenter R.id.ksad_video_cover_image is null");
    }
}
