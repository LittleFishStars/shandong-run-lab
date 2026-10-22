package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.k.a<i> implements g.a {
    private com.kwad.components.core.h.c CB;

    public b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long jO = com.kwad.sdk.core.response.helper.a.O(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        com.kwad.components.core.h.c cVar = new com.kwad.components.core.h.c();
        this.CB = cVar;
        cVar.H(jO);
    }

    public final FrameLayout T(Context context) {
        FrameLayout imagePlayerView = this.CB.getImagePlayerView(context);
        this.CB.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.k.a
    public final void a(i iVar) {
        this.CB.d(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void b(i iVar) {
        this.CB.c(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.CB.getPlayDuration();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hp() {
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hq() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hr() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hs() {
        this.CB.destroy();
    }

    public final void lo() {
        this.CB.setURLs(com.kwad.sdk.core.response.helper.a.bg(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate)));
        this.CB.play();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.CB.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        this.CB.destroy();
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.CB.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.CB.skipToEnd();
    }
}
