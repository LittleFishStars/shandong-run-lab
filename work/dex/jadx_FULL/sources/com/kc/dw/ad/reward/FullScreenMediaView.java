package com.kc.dw.ad.reward;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.dw.ad.a0;
import com.kc.dw.ad.view.SsdVideoTextureView;
import com.kc.dw.core.utils.LogUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FullScreenMediaView extends FrameLayout implements a0 {
    public static final int s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SsdVideoTextureView f39151a;
    public com.kc.dw.core.bquery.d b;
    public CircleProcessBar c;
    public MediaPlayer d;
    public com.kc.dw.ad.nativ.c e;
    public a0.b f;
    public long g;
    public com.kc.dw.ad.nativ.h h;
    public com.kc.dw.ad.nativ.a i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Handler p;
    public boolean q;
    public List<a0.a> r;

    @Keep
    public class a extends com.kc.dw.core.safe.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FullScreenMediaView f39152a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FullScreenMediaView fullScreenMediaView, Looper looper) {
            super(looper);
            this.f39152a = fullScreenMediaView;
        }

        @Override // com.kc.dw.core.safe.b
        public void a(Message message) {
            super.a(message);
            int currentPosition = this.f39152a.f39151a.getCurrentPosition();
            this.f39152a.c.a(currentPosition);
            FullScreenMediaView fullScreenMediaView = this.f39152a;
            long j = fullScreenMediaView.g;
            if (j > 0 && currentPosition >= j && !fullScreenMediaView.j) {
                fullScreenMediaView.j = true;
                a0.b bVar = this.f39152a.f;
                if (bVar != null) {
                    bVar.onKeepTimeFinished();
                }
            }
            double duration = ((double) currentPosition) / ((double) this.f39152a.f39151a.getDuration());
            if (duration >= 0.25d && duration < 0.5d) {
                FullScreenMediaView fullScreenMediaView2 = this.f39152a;
                if (!fullScreenMediaView2.k) {
                    com.kc.dw.ad.nativ.h hVar = fullScreenMediaView2.h;
                    if (hVar != null) {
                        ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).c();
                    }
                    this.f39152a.k = true;
                }
            } else if (duration >= 0.5d && duration < 0.75d) {
                FullScreenMediaView fullScreenMediaView3 = this.f39152a;
                if (!fullScreenMediaView3.l) {
                    com.kc.dw.ad.nativ.h hVar2 = fullScreenMediaView3.h;
                    if (hVar2 != null) {
                        ((com.kc.dw.platform.ad_adapter.recycler.d) hVar2).b();
                    }
                    this.f39152a.l = true;
                }
            } else if (duration >= 0.75d && duration < 1.0d) {
                FullScreenMediaView fullScreenMediaView4 = this.f39152a;
                if (!fullScreenMediaView4.m) {
                    com.kc.dw.ad.nativ.h hVar3 = fullScreenMediaView4.h;
                    if (hVar3 != null) {
                        ((com.kc.dw.platform.ad_adapter.recycler.d) hVar3).g();
                    }
                    this.f39152a.m = true;
                }
            }
            this.f39152a.p.sendEmptyMessageDelayed(1, 100L);
        }
    }

    public FullScreenMediaView(Context context) {
        super(context);
        this.g = -1L;
        this.n = false;
        this.o = false;
        this.p = new a(this, Looper.getMainLooper());
        this.r = new ArrayList();
        a(context);
    }

    public FullScreenMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1L;
        this.n = false;
        this.o = false;
        this.p = new a(this, Looper.getMainLooper());
        this.r = new ArrayList();
        a(context);
    }

    public FullScreenMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = -1L;
        this.n = false;
        this.o = false;
        this.p = new a(this, Looper.getMainLooper());
        this.r = new ArrayList();
        a(context);
    }

    public final void a(Context context) {
        setTag("meishu_media_view");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.ssd_full_screen_video_player_layout, (ViewGroup) null);
        addView(viewInflate);
        SsdVideoTextureView ssdVideoTextureView = (SsdVideoTextureView) viewInflate.findViewById(R.id.ms_video_view);
        this.f39151a = ssdVideoTextureView;
        ssdVideoTextureView.setUseTransform(false);
        com.kc.dw.core.bquery.d dVar = new com.kc.dw.core.bquery.d(this);
        this.b = dVar;
        CircleProcessBar circleProcessBar = (CircleProcessBar) dVar.b(R.id.ms_process_bar).d;
        this.c = circleProcessBar;
        circleProcessBar.setVisibility(8);
        com.kc.dw.core.bquery.d dVarB = this.b.b(R.id.ms_center_play_button);
        com.kc.dw.ad.reward.a aVar = new com.kc.dw.ad.reward.a(this);
        View view = dVarB.d;
        if (view != null) {
            view.setOnClickListener(aVar);
        }
        com.kc.dw.core.bquery.d dVarB2 = this.b.b(R.id.ms_controlbar_video_play_button);
        b bVar = new b(this);
        View view2 = dVarB2.d;
        if (view2 != null) {
            view2.setOnClickListener(bVar);
        }
        com.kc.dw.core.bquery.d dVarB3 = this.b.b(R.id.ms_controlbar_video_pause_button);
        c cVar = new c(this);
        View view3 = dVarB3.d;
        if (view3 != null) {
            view3.setOnClickListener(cVar);
        }
        com.kc.dw.core.bquery.d dVarB4 = this.b.b(R.id.ms_video_volume_mute);
        d dVar2 = new d(this);
        View view4 = dVarB4.d;
        if (view4 != null) {
            view4.setOnClickListener(dVar2);
        }
        com.kc.dw.core.bquery.d dVarB5 = this.b.b(R.id.ms_video_volume);
        e eVar = new e(this);
        View view5 = dVarB5.d;
        if (view5 != null) {
            view5.setOnClickListener(eVar);
        }
        this.f39151a.setOnErrorListener(new f(this));
        this.f39151a.setOnCachePreparedListener(new g(this));
        this.f39151a.setOnCompletionListener(new h(this));
    }

    @Override // com.kc.dw.ad.a0
    public void a(a0.a aVar) {
        this.r.add(aVar);
    }

    @Override // com.kc.dw.ad.a0
    public void a(a0.b bVar, long j) {
        this.f = bVar;
        if (j > 0) {
            this.g = j;
        }
    }

    @Override // com.kc.dw.ad.a0
    public boolean a() {
        return this.f39151a.j;
    }

    public final void b() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            this.b.b(R.id.ms_video_volume_mute).d(0);
            this.b.b(R.id.ms_video_volume).d(8);
        }
    }

    public final void c() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1.0f, 1.0f);
            this.b.b(R.id.ms_video_volume_mute).d(8);
            this.b.b(R.id.ms_video_volume).d(0);
        }
    }

    public final void d() {
        this.b.b(R.id.ms_controlbar_video_play_button).d(0);
        this.b.b(R.id.ms_center_play_button).d(0);
        this.b.b(R.id.ms_controlbar_video_pause_button).d(8);
        if (this.p.hasMessages(1)) {
            this.p.removeMessages(1);
        }
    }

    public final void e() {
        if (!this.n && this.o) {
            com.kc.dw.ad.nativ.h hVar = this.h;
            if (hVar != null) {
                ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f();
            }
            com.kc.dw.ad.nativ.a aVar = this.i;
            if (aVar != null) {
                aVar.onADExposure();
            }
            this.n = true;
        }
        this.q = true;
        this.b.b(R.id.ms_controlbar_video_play_button).d(8);
        this.b.b(R.id.ms_center_play_button).d(8);
        this.b.b(R.id.ms_controlbar_video_pause_button).d(0);
        long j = this.g;
        this.c.setmTotalTime((j <= 0 || j >= ((long) this.f39151a.getDuration())) ? this.f39151a.getDuration() : (int) this.g);
        if (this.p.hasMessages(1)) {
            return;
        }
        this.p.sendEmptyMessage(1);
    }

    @Override // com.kc.dw.ad.a0
    public View getVideoView() {
        return this;
    }

    @Override // com.kc.dw.ad.a0
    public void mute() {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        LogUtil.d("FullScreenMediaView", "onDetachedFromWindow: ");
        super.onDetachedFromWindow();
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kc.dw.ad.a0
    public void pause() {
        this.f39151a.c();
        d();
        com.kc.dw.ad.nativ.h hVar = this.h;
        if (hVar != null) {
            ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).d();
        }
    }

    @Override // com.kc.dw.ad.a0
    public void replay() {
        if (this.q) {
            return;
        }
        start();
    }

    @Override // com.kc.dw.ad.a0
    public void resume() {
        this.f39151a.e();
        e();
        com.kc.dw.ad.nativ.h hVar = this.h;
        if (hVar != null) {
            ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).e();
        }
    }

    public void setAdListener(com.kc.dw.ad.nativ.a aVar) {
        this.i = aVar;
    }

    @Override // com.kc.dw.ad.a0
    public void setNativeAdMediaListener(com.kc.dw.ad.nativ.h hVar) {
        this.h = hVar;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f39151a.setOnInfoListener(onInfoListener);
    }

    public void setOnVideoLoadedListener(a0.c cVar) {
    }

    @Override // com.kc.dw.ad.a0
    public void setPreparedStartPlayListener(com.kc.dw.ad.nativ.c cVar) {
        this.e = cVar;
    }

    public void setVideoCover(String str) {
    }

    @Override // com.kc.dw.ad.a0
    public void setVideoPath(String str) {
        this.f39151a.setVideoPath(str);
    }

    @Override // com.kc.dw.ad.a0
    public void start() {
        this.f39151a.e();
        e();
    }

    @Override // com.kc.dw.ad.a0
    public void unmute() {
        c();
    }
}
