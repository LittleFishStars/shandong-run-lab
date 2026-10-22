package com.kc.dw.ad.nativ;

import android.media.MediaPlayer;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.kc.dw.core.utils.LogUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class r implements com.kc.dw.ad.view.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NormalMediaView f39142a;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f39143a;

        public a(r rVar) {
            this.f39143a = rVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.ad.nativ.a aVar;
            NormalMediaView normalMediaView = this.f39143a.f39142a;
            if (!normalMediaView.C && (aVar = normalMediaView.B) != null) {
                aVar.onADExposure();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.f39143a.f39142a.O;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
        }
    }

    public r(NormalMediaView normalMediaView) {
        this.f39142a = normalMediaView;
    }

    @Override // com.kc.dw.ad.view.d
    public void a() {
        try {
            c cVar = this.f39142a.V;
            if (cVar instanceof b) {
                ((b) cVar).a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.view.d
    public void a(MediaPlayer mediaPlayer, boolean z) {
        NativeAdMediaListener nativeAdMediaListener;
        String str = this.f39142a.f39125a;
        StringBuilder sbA = com.kc.dw.activity.a.a("MediaPlayer.onPrepared ");
        sbA.append(this.f39142a.r);
        sbA.append(" ");
        sbA.append(this.f39142a.hashCode());
        LogUtil.dev(str, sbA.toString());
        this.f39142a.r = true;
        NormalMediaView normalMediaView = this.f39142a;
        if (!normalMediaView.q && normalMediaView.m) {
            normalMediaView.q = true;
            this.f39142a.b.post(new a(this));
        }
        mediaPlayer.setVideoScalingMode(2);
        NormalMediaView normalMediaView2 = this.f39142a;
        if (normalMediaView2.o == 1) {
            mediaPlayer.start();
            this.f39142a.h();
            NormalMediaView normalMediaView3 = this.f39142a;
            if (normalMediaView3.z != null && !normalMediaView3.J) {
                normalMediaView3.J = true;
                ((com.kc.dw.platform.ad_adapter.recycler.d) this.f39142a.z).f();
            }
        } else {
            try {
                normalMediaView2.a(normalMediaView2.d, 0);
                normalMediaView2.a(normalMediaView2.e, normalMediaView2.b.getDuration());
                normalMediaView2.f.setProgress(0);
                if (normalMediaView2.K.hasMessages(1)) {
                    normalMediaView2.K.removeMessages(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f39142a.c.b(R.id.ms_progress_loading).d(8);
        IPreparedListener iPreparedListener = this.f39142a.U;
        if (iPreparedListener != null) {
            iPreparedListener.onPrepared();
        }
        c cVar = this.f39142a.V;
        if (cVar != null) {
            cVar.onPreparedStartPlay(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight(), z);
        }
        h hVar = this.f39142a.z;
        if (hVar != null && (nativeAdMediaListener = ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f39488a) != null) {
            nativeAdMediaListener.onVideoLoaded();
        }
        NormalMediaView normalMediaView4 = this.f39142a;
        MediaPlayer mediaPlayer2 = normalMediaView4.b.getMediaPlayer();
        if (mediaPlayer2 == null) {
            return;
        }
        if (normalMediaView4.h <= 0 || normalMediaView4.i <= 0) {
            normalMediaView4.h = mediaPlayer2.getVideoWidth();
            normalMediaView4.i = mediaPlayer2.getVideoHeight();
            normalMediaView4.requestLayout();
        }
    }

    @Override // com.kc.dw.ad.view.d
    public void onPrepareError(int i, String str) {
        c cVar = this.f39142a.V;
        if (cVar != null) {
            cVar.onPrepareError(i, str);
        }
    }

    @Override // com.kc.dw.ad.view.d
    public void onPrepared(MediaPlayer mediaPlayer) {
    }

    @Override // com.kc.dw.ad.view.d
    public void onStartDownload() {
        c cVar = this.f39142a.V;
        if (cVar != null) {
            cVar.onStartDownload();
        }
    }
}
