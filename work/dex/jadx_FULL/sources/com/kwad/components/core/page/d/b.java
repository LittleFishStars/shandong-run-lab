package com.kwad.components.core.page.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends Presenter {
    private int adO;
    private FeedVideoView adP;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) SB();
        KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.adP = feedVideoView;
        feedVideoView.d(com.kwad.sdk.core.response.helper.c.ez(eVar.adTemplate));
        this.adP.a(ksAdVideoPlayConfigBuild, eVar.QS);
        this.adP.setVisibility(0);
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(eVar.adTemplate);
        this.adP.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.d.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
                        if (eVar.QS != null) {
                            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(b.this.getActivity()).as(false).at(false).ax(true).aJ(eVar.adTemplate).av(false));
                            com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, b.this.adP.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.afs;
                    if (recyclerView == null || recyclerView.getAdapter() == null || eVar.afs.getAdapter().getItemCount() <= 1) {
                        return;
                    }
                    eVar.afs.scrollToPosition(1);
                    com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, 50, b.this.adP.getTouchCoords());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.helper.a.aw(adInfoEO)) {
            this.adP.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.d.b.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
                            if (eVar.QS != null) {
                                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(b.this.getActivity()).as(false).at(false).ax(true).aJ(eVar.adTemplate).av(false));
                                com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, b.this.adP.getTouchCoords());
                                return;
                            }
                            return;
                        }
                        RecyclerView recyclerView = eVar.afs;
                        if (recyclerView == null || recyclerView.getAdapter() == null || eVar.afs.getAdapter().getItemCount() <= 1) {
                            return;
                        }
                        eVar.afs.scrollToPosition(1);
                        com.kwad.sdk.core.adlog.c.a(eVar.adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, b.this.adP.getTouchCoords());
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            });
        }
        this.adP.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.d.b.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void uh() {
                RecyclerView recyclerView = eVar.afs;
                if (recyclerView != null) {
                    b.this.adO = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void ui() {
                RecyclerView recyclerView = eVar.afs;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(b.this.adO);
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.adP.release();
    }
}
