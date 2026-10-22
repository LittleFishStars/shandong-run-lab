package com.kc.dw.ad.reward;

import android.media.MediaPlayer;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g implements com.kc.dw.ad.view.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FullScreenMediaView f39158a;

    public g(FullScreenMediaView fullScreenMediaView) {
        this.f39158a = fullScreenMediaView;
    }

    @Override // com.kc.dw.ad.view.d
    public void a() {
    }

    @Override // com.kc.dw.ad.view.d
    public void a(MediaPlayer mediaPlayer, boolean z) {
        NativeAdMediaListener nativeAdMediaListener;
        this.f39158a.d = mediaPlayer;
        mediaPlayer.setVideoScalingMode(1);
        this.f39158a.o = true;
        FullScreenMediaView fullScreenMediaView = this.f39158a;
        if (fullScreenMediaView.q) {
            fullScreenMediaView.e();
        } else {
            fullScreenMediaView.b.b(R.id.ms_controlbar_video_play_button).d(0);
            fullScreenMediaView.b.b(R.id.ms_center_play_button).d(0);
            fullScreenMediaView.b.b(R.id.ms_controlbar_video_pause_button).d(8);
            fullScreenMediaView.c.a(0);
            fullScreenMediaView.c.setmTotalTime(fullScreenMediaView.d.getDuration());
            if (fullScreenMediaView.p.hasMessages(1)) {
                fullScreenMediaView.p.removeMessages(1);
            }
        }
        this.f39158a.c.setVisibility(0);
        this.f39158a.q = false;
        com.kc.dw.ad.nativ.h hVar = this.f39158a.h;
        if (hVar != null && (nativeAdMediaListener = ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f39488a) != null) {
            nativeAdMediaListener.onVideoLoaded();
        }
        com.kc.dw.ad.nativ.c cVar = this.f39158a.e;
        if (cVar != null) {
            cVar.onPreparedStartPlay(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight(), z);
        }
    }

    @Override // com.kc.dw.ad.view.d
    public void onPrepareError(int i, String str) {
        com.kc.dw.ad.nativ.c cVar = this.f39158a.e;
        if (cVar != null) {
            cVar.onPrepareError(i, str);
        }
    }

    @Override // com.kc.dw.ad.view.d
    public void onPrepared(MediaPlayer mediaPlayer) {
    }

    @Override // com.kc.dw.ad.view.d
    public void onStartDownload() {
        com.kc.dw.ad.nativ.c cVar = this.f39158a.e;
        if (cVar != null) {
            cVar.onStartDownload();
        }
    }
}
