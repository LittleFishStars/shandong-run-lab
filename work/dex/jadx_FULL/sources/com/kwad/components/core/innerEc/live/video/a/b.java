package com.kwad.components.core.innerEc.live.video.a;

import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IHostLivePlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    private final IHostLivePlayer XQ;

    public b(IHostLivePlayer iHostLivePlayer) {
        this.XQ = iHostLivePlayer;
        com.kwad.sdk.core.d.c.d("LivePlayerController", "LivePlayerController create instance:" + iHostLivePlayer);
    }

    public final void a(a aVar) {
        this.XQ.addOnCompletionListener(aVar);
    }

    public final void b(a aVar) {
        this.XQ.removeOnCompletionListener(aVar);
    }

    public final void destroy() {
        try {
            this.XQ.stopPlay();
            this.XQ.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final boolean isBuffering() {
        com.kwad.sdk.core.d.c.d("LivePlayerController", "isBuffering:" + this.XQ);
        IHostLivePlayer iHostLivePlayer = this.XQ;
        if (iHostLivePlayer == null) {
            return false;
        }
        try {
            return iHostLivePlayer.isBuffering();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.d.c.d("LivePlayerController", "isPlaying:" + this.XQ);
        IHostLivePlayer iHostLivePlayer = this.XQ;
        if (iHostLivePlayer == null) {
            return false;
        }
        try {
            return iHostLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    public final void setPlayerReleaseReason(int i) {
        try {
            this.XQ.setPlayerReleaseReason(i);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void a(c cVar) {
        this.XQ.addStateChangeListener(cVar);
    }

    public final void b(c cVar) {
        try {
            this.XQ.removeStateChangeListener(cVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
