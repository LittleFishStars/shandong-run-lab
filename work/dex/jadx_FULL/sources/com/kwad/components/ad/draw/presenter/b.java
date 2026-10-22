package com.kwad.components.ad.draw.presenter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.draw.b.a {
    private ImageView ea;
    private com.kwad.sdk.core.response.model.b eb;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (b.this.ea.getVisibility() == 0) {
                b.this.ea.setVisibility(8);
            }
        }
    };
    private Runnable ec = new Runnable() { // from class: com.kwad.components.ad.draw.presenter.b.2
        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.ea.getLayoutParams();
            int width2 = b.this.eb.getWidth();
            int height = b.this.eb.getHeight();
            if (width2 == 0 || height == 0 || height > width2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.ea.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.ea.setLayoutParams(layoutParams);
                b.this.ea.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.ea.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.ea, b.this.eb.getUrl(), b.this.dQ.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.response.model.b bVarBA = com.kwad.sdk.core.response.helper.a.bA(e.eO(this.dQ.mAdTemplate));
        this.eb = bVarBA;
        if (TextUtils.isEmpty(bVarBA.getUrl())) {
            return;
        }
        getRootView().post(this.ec);
        this.ea.setVisibility(0);
        com.kwad.components.ad.draw.c.a aVar = this.dQ.dS;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ea = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.ec);
        com.kwad.components.ad.draw.c.a aVar = this.dQ.dS;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }
}
