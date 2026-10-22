package com.kwad.components.core.innerEc.live.b.c;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.info.IHostLivePlayerState;
import com.kwad.sdk.utils.ae;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.core.innerEc.live.b.a.a {
    private com.kwad.components.core.innerEc.live.d.b UR;
    private boolean VB;
    private boolean VC;
    private final com.kwad.components.core.innerEc.live.video.a.c VD = new com.kwad.components.core.innerEc.live.video.a.c() { // from class: com.kwad.components.core.innerEc.live.b.c.d.1
        @Override // com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener.IHostLivePlayerStateChangeListener
        public final void onStateChange(@NonNull IHostLivePlayerState iHostLivePlayerState) {
            if (iHostLivePlayerState == IHostLivePlayerState.PLAYING) {
                d.a(d.this, true);
            }
        }
    };
    private final com.kwad.components.core.innerEc.live.d.a VE = new com.kwad.components.core.innerEc.live.d.a() { // from class: com.kwad.components.core.innerEc.live.b.c.d.2
        @Override // com.kwad.components.core.innerEc.live.d.a
        public final void aE() {
            d.b(d.this, true);
        }

        @Override // com.kwad.components.core.innerEc.live.d.a
        public final void sd() {
            ae.W(d.this.getContext(), "直播间加载失败，请稍后重试");
            d.this.getActivity().finish();
        }
    };

    public static /* synthetic */ boolean b(d dVar, boolean z) {
        dVar.VC = true;
        return true;
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.innerEc.live.b.a.b bVar = this.Ub;
        this.UR = bVar.UR;
        bVar.UI.a(this.VD);
        this.UR.a(this.VE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.UR.b(this.VE);
        this.Ub.UI.b(this.VD);
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.VB = true;
        return true;
    }
}
