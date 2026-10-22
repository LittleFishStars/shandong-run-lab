package com.kwad.components.ad.nativead.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.nativead.a.a {
    private ImageView ea;
    private com.kwad.sdk.core.response.model.b eb;
    private Runnable ec = new Runnable() { // from class: com.kwad.components.ad.nativead.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.c.a.a.d(b.this.ea, b.this.eb.getWidth(), b.this.eb.getHeight());
            b.this.ea.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.ea, b.this.eb.getUrl(), b.this.pW.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.response.model.b bVarBA = com.kwad.sdk.core.response.helper.a.bA(com.kwad.sdk.core.response.helper.e.eO(this.pW.mAdTemplate));
        this.eb = bVarBA;
        if (TextUtils.isEmpty(bVarBA.getUrl())) {
            return;
        }
        getRootView().post(this.ec);
        this.ea.setVisibility(0);
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.b.b.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (b.this.ea.getVisibility() == 0) {
                    b.this.ea.setVisibility(8);
                }
            }
        };
        this.mVideoPlayStateListener = mVar;
        this.pW.pX.b((l) mVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ea = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.ec);
    }
}
