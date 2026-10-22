package com.kc.dw.ad.nativ;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kc.dw.activity.SsdDetailActivity;
import com.kc.dw.ad.a0;
import com.kc.dw.ad.view.SsdVideoTextureView;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.kc.dw.core.safe.SafeBroadcastReceiver;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.view.RoundImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class NormalMediaView extends FrameLayout implements a0 {
    public static final int W = 0;
    public MediaPlayer.OnInfoListener A;
    public com.kc.dw.ad.nativ.a B;
    public boolean C;
    public com.kc.dw.ad.lifecycle.c D;
    public volatile boolean E;
    public volatile boolean F;
    public volatile boolean G;
    public volatile boolean H;
    public boolean I;
    public boolean J;
    public Handler K;
    public int L;
    public int M;
    public boolean N;
    public RecylcerAdInteractionListener O;
    public String P;
    public ImageView Q;
    public boolean R;
    public List<a0.a> S;
    public BroadcastReceiver T;
    public IPreparedListener U;
    public com.kc.dw.ad.nativ.c V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39125a;
    public SsdVideoTextureView b;
    public com.kc.dw.core.bquery.d c;
    public TextView d;
    public TextView e;
    public ProgressBar f;
    public boolean g;
    public int h;
    public int i;
    public long j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public d p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public float v;
    public float w;
    public a0.c x;
    public a0.b y;
    public h z;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NormalMediaView f39126a;

        public a(NormalMediaView normalMediaView) {
            this.f39126a = normalMediaView;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.ad.nativ.a aVar;
            NormalMediaView normalMediaView = this.f39126a;
            if (!normalMediaView.C && (aVar = normalMediaView.B) != null) {
                aVar.onADExposure();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.f39126a.O;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
        }
    }

    @Keep
    public class b extends SafeBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NormalMediaView f39127a;

        public b(NormalMediaView normalMediaView) {
            this.f39127a = normalMediaView;
        }

        @Override // com.kc.dw.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            com.kc.dw.core.utils.f.b(this.f39127a.getContext(), this.f39127a.p);
        }
    }

    @Keep
    public class c extends com.kc.dw.core.safe.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NormalMediaView f39128a;

        public c(NormalMediaView normalMediaView) {
            this.f39128a = normalMediaView;
        }

        @Override // com.kc.dw.core.safe.b
        public void a(Message message) {
            super.a(message);
            int currentPosition = this.f39128a.b.getCurrentPosition();
            NormalMediaView normalMediaView = this.f39128a;
            normalMediaView.a(normalMediaView.d, currentPosition);
            this.f39128a.f.setProgress(currentPosition);
            long duration = this.f39128a.b.getDuration();
            NormalMediaView normalMediaView2 = this.f39128a;
            if (normalMediaView2.j > duration) {
                normalMediaView2.j = duration - 100;
            }
            h hVar = normalMediaView2.z;
            if (hVar != null && normalMediaView2.o == 1 && currentPosition > 0 && duration > 0) {
                long j = currentPosition;
                NativeAdMediaListener nativeAdMediaListener = ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f39488a;
                if (nativeAdMediaListener != null) {
                    nativeAdMediaListener.onProgressUpdate(j, duration);
                }
            }
            NormalMediaView normalMediaView3 = this.f39128a;
            long j2 = normalMediaView3.j;
            if (j2 > 0 && currentPosition >= j2 && !normalMediaView3.E) {
                this.f39128a.E = true;
                a0.b bVar = this.f39128a.y;
                if (bVar != null) {
                    bVar.onKeepTimeFinished();
                }
            }
            double d = (currentPosition * 1.0f) / duration;
            if (d < 0.25d || d >= 0.5d) {
                if (d < 0.5d || d >= 0.75d) {
                    if (d >= 0.75d && d < 1.0d && !this.f39128a.H) {
                        h hVar2 = this.f39128a.z;
                        if (hVar2 != null) {
                            ((com.kc.dw.platform.ad_adapter.recycler.d) hVar2).g();
                        }
                        this.f39128a.H = true;
                    }
                } else if (!this.f39128a.G) {
                    h hVar3 = this.f39128a.z;
                    if (hVar3 != null) {
                        ((com.kc.dw.platform.ad_adapter.recycler.d) hVar3).b();
                    }
                    this.f39128a.G = true;
                }
            } else if (!this.f39128a.F) {
                h hVar4 = this.f39128a.z;
                if (hVar4 != null) {
                    ((com.kc.dw.platform.ad_adapter.recycler.d) hVar4).c();
                }
                this.f39128a.F = true;
            }
            this.f39128a.K.sendEmptyMessageDelayed(1, 100L);
        }
    }

    public NormalMediaView(Context context) {
        super(context);
        this.f39125a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.o = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.C = false;
        this.K = new c(this);
        this.S = new ArrayList();
        this.T = new b(this);
        a(context);
    }

    public NormalMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39125a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.o = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.C = false;
        this.K = new c(this);
        this.S = new ArrayList();
        this.T = new b(this);
        a(context);
    }

    public NormalMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39125a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.o = 0;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.C = false;
        this.K = new c(this);
        this.S = new ArrayList();
        this.T = new b(this);
        a(context);
    }

    public final void a(Context context) {
        setTag("meishu_media_view");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.ssd_normal_video_player_layout, (ViewGroup) null);
        addView(viewInflate, -1, -2);
        this.b = (SsdVideoTextureView) viewInflate.findViewById(R.id.ms_video_view);
        this.Q = (ImageView) viewInflate.findViewById(R.id.ms_video_cover);
        com.kc.dw.core.bquery.d dVar = new com.kc.dw.core.bquery.d(this);
        this.c = dVar;
        this.d = (TextView) dVar.b(R.id.ms_video_currentTime).d;
        this.e = (TextView) this.c.b(R.id.ms_video_endTime).d;
        this.f = (ProgressBar) this.c.b(R.id.ms_video_seekBar).d;
        com.kc.dw.core.bquery.d dVarB = this.c.b(R.id.ms_center_play_button);
        l lVar = new l(this);
        View view = dVarB.d;
        if (view != null) {
            view.setOnClickListener(lVar);
        }
        com.kc.dw.core.bquery.d dVarB2 = this.c.b(R.id.ms_controlbar_video_play_button);
        m mVar = new m(this);
        View view2 = dVarB2.d;
        if (view2 != null) {
            view2.setOnClickListener(mVar);
        }
        com.kc.dw.core.bquery.d dVarB3 = this.c.b(R.id.ms_controlbar_video_pause_button);
        n nVar = new n(this);
        View view3 = dVarB3.d;
        if (view3 != null) {
            view3.setOnClickListener(nVar);
        }
        com.kc.dw.core.bquery.d dVarB4 = this.c.b(R.id.ms_video_volume_mute);
        o oVar = new o(this);
        View view4 = dVarB4.d;
        if (view4 != null) {
            view4.setOnClickListener(oVar);
        }
        com.kc.dw.core.bquery.d dVarB5 = this.c.b(R.id.ms_video_volume);
        p pVar = new p(this);
        View view5 = dVarB5.d;
        if (view5 != null) {
            view5.setOnClickListener(pVar);
        }
        this.b.setOnErrorListener(new q(this));
        this.b.setOnCachePreparedListener(new r(this));
        this.b.setOnCompletionListener(new s(this));
        this.b.setOnInfoListener(new j(this));
        if (getContext() instanceof Activity) {
            com.kc.dw.ad.lifecycle.c cVar = new com.kc.dw.ad.lifecycle.c();
            this.D = cVar;
            cVar.b = (Activity) getContext();
        }
    }

    public final void a(TextView textView, int i) {
        int i2 = i / 1000;
        textView.setText(String.format(Locale.CHINA, "%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)));
    }

    @Override // com.kc.dw.ad.a0
    public void a(a0.a aVar) {
        this.S.add(aVar);
    }

    @Override // com.kc.dw.ad.a0
    public void a(a0.b bVar, long j) {
        this.y = bVar;
        if (j > 0) {
            this.j = j;
        }
    }

    public void a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || str.equals(this.P)) {
            LogUtil.dev(this.f39125a, "setVideoPath same");
        } else {
            this.P = str;
            this.b.a(str, new com.kc.dw.ad.view.a(j, j2));
        }
    }

    public void a(boolean z) {
        this.n = true;
        i iVarA = this.p.a();
        SsdDetailActivity.setOwnVideoView(this);
        SsdDetailActivity.setNativeAdData(this.p);
        Intent intent = new Intent(getContext(), (Class<?>) SsdDetailActivity.class);
        intent.setFlags(TTAdConstant.KEY_CLICK_AREA);
        intent.putExtra("EXTRA_INTERACTION_TYPE", iVarA.getInteractionType());
        intent.putExtra("EXTRA_DURL", iVarA.getdUrl());
        intent.putExtra("EXTRA_APP_NAME", iVarA.getAppName());
        intent.putExtra("EXTRA_ICON_URL", iVarA.iconUrl);
        intent.putExtra("EXTRA_CONTENT", iVarA.c);
        intent.putExtra("EXTRA_SCORE", iVarA.getScore());
        intent.putExtra("EXTRA_DOWN_NUM", iVarA.getDownNum());
        intent.putExtra("EXTRA_VIDEO_WIDTH", iVarA.f39132a);
        intent.putExtra("EXTRA_VIDEO_HEIGHT", iVarA.b);
        intent.putExtra("EXTRA_STRONG_ACTION", z);
        intent.putExtra("EXTRA_VIDEO_COVER", iVarA.getVideo_cover());
        intent.putExtra("EXTRA_VIDEO_END_COVER", iVarA.h);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        getContext().startActivity(intent);
    }

    @Override // com.kc.dw.ad.a0
    public boolean a() {
        return this.b.j;
    }

    public void b() {
        try {
            ImageView imageView = this.Q;
            if (imageView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            if (getOwnVideoView() == null) {
                return;
            }
            layoutParams.width = getOwnVideoView().getMeasuredWidth();
            layoutParams.height = getOwnVideoView().getMeasuredHeight();
            this.Q.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #2 {all -> 0x002c, blocks: (B:5:0x000c, B:7:0x0010, B:11:0x0024, B:13:0x0028, B:10:0x0021), top: B:35:0x000c, inners: #0 }] */
    public void c() {
        SurfaceTexture surfaceTexture;
        SsdVideoTextureView ssdVideoTextureView = this.b;
        if (ssdVideoTextureView != null) {
            LogUtil.d(ssdVideoTextureView.f39180a, "destroy");
            try {
                MediaPlayer mediaPlayer = ssdVideoTextureView.b;
                if (mediaPlayer != null) {
                    try {
                        mediaPlayer.stop();
                        ssdVideoTextureView.b.reset();
                        ssdVideoTextureView.b.release();
                        ssdVideoTextureView.b = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    surfaceTexture = ssdVideoTextureView.q;
                    if (surfaceTexture != null) {
                        surfaceTexture.release();
                    }
                } else {
                    surfaceTexture = ssdVideoTextureView.q;
                    if (surfaceTexture != null) {
                        surfaceTexture.release();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            if (this.K.hasMessages(1)) {
                this.K.removeMessages(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.kc.dw.ad.lifecycle.c cVar = this.D;
        if (cVar != null) {
            cVar.b = null;
        }
        List<a0.a> list = this.S;
        if (list != null) {
            list.clear();
        }
        setNativeAdMediaListener(null);
        setOnVideoLoadedListener(null);
        this.y = null;
    }

    public boolean d() {
        try {
            return this.b.getMediaPlayer() != null && this.b.getMediaPlayer().isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void e() {
        Bitmap bitmap;
        try {
            try {
                this.o = 3;
                String str = !TextUtils.isEmpty(this.l) ? this.l : this.k;
                if (str != null) {
                    if (!this.R) {
                        b();
                    }
                    this.c.b(R.id.ms_video_cover).a(str, false).d(0);
                } else {
                    SsdVideoTextureView ssdVideoTextureView = this.b;
                    if (ssdVideoTextureView != null && (bitmap = ssdVideoTextureView.getBitmap()) != null) {
                        if (!this.R) {
                            b();
                        }
                        com.kc.dw.core.bquery.d dVarB = this.c.b(R.id.ms_video_cover);
                        View view = dVarB.d;
                        if (view instanceof ImageView) {
                            ((ImageView) view).setImageBitmap(bitmap);
                        }
                        dVarB.d(0);
                    }
                }
                View view2 = this.c.b(R.id.ms_video_cover).d;
                if ((view2 != null && view2.getVisibility() == 0) && this.s) {
                    this.c.b(R.id.ms_video_view).d(8);
                }
                g();
                int duration = this.b.getDuration();
                a(this.d, duration);
                this.f.setProgress(duration);
                if (!this.g) {
                    this.c.b(R.id.ms_center_play_button).d(0);
                }
                if (this.N) {
                    return;
                }
                if (this.j <= 0 && this.y != null && !this.E) {
                    this.E = true;
                    this.y.onKeepTimeFinished();
                }
                Iterator<a0.a> it = this.S.iterator();
                while (it.hasNext()) {
                    it.next().onCompleted();
                }
                h hVar = this.z;
                if (hVar != null) {
                    ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            c();
        }
    }

    public void f() {
        if (this.b.getMediaPlayer() != null) {
            try {
                this.b.getMediaPlayer().setVolume(0.0f, 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.c.b(R.id.ms_video_volume_mute).d(0);
            this.c.b(R.id.ms_video_volume).d(8);
            h hVar = this.z;
            if (hVar != null) {
                com.kc.dw.platform.ad_adapter.recycler.d dVar = (com.kc.dw.platform.ad_adapter.recycler.d) hVar;
                try {
                    LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoMute");
                    String[] strArr = dVar.c.q;
                    if (strArr != null) {
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(dVar.b, g0.a(str), new com.kc.dw.core.utils.j());
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void g() {
        if (this.K.hasMessages(1)) {
            this.K.removeMessages(1);
        }
    }

    public int getCurrentPosition() {
        try {
            this.M = this.b.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.M;
    }

    public int getDuration() {
        return this.b.getDuration();
    }

    public SsdVideoTextureView getOwnVideoView() {
        return this.b;
    }

    public int getPlayState() {
        return this.o;
    }

    public Bitmap getVideoThumb() {
        try {
            if (TextUtils.isEmpty(this.P)) {
                return null;
            }
            Bitmap bitmapA = com.kc.dw.player.utils.c.a(this.P, false);
            if (bitmapA != null) {
                return bitmapA;
            }
            LogUtil.d(this.f39125a, "getVideoThumb by web");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.P);
            return mediaMetadataRetriever.getFrameAtTime(0L);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.ad.a0
    public View getVideoView() {
        return this;
    }

    public final void h() {
        String str = this.f39125a;
        StringBuilder sbA = com.kc.dw.activity.a.a("onPlay ");
        sbA.append(hashCode());
        LogUtil.d(str, sbA.toString());
        if (this.r && !this.q && !this.t) {
            this.q = true;
            this.b.post(new k(this));
        }
        this.c.b(R.id.ms_center_play_button).d(8);
        if (this.r) {
            this.c.b(R.id.ms_video_cover).d(4);
            this.c.b(R.id.ms_progress_loading).d(8);
        }
        this.f.setMax(this.b.getDuration());
        a(this.e, this.b.getDuration());
        if (this.K.hasMessages(1)) {
            return;
        }
        this.K.sendEmptyMessage(1);
    }

    public void i() {
        if (this.b.getMediaPlayer() != null) {
            try {
                this.b.getMediaPlayer().setVolume(1.0f, 1.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.c.b(R.id.ms_video_volume_mute).d(8);
            this.c.b(R.id.ms_video_volume).d(0);
            h hVar = this.z;
            if (hVar != null) {
                com.kc.dw.platform.ad_adapter.recycler.d dVar = (com.kc.dw.platform.ad_adapter.recycler.d) hVar;
                try {
                    LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoUnmute");
                    String[] strArr = dVar.c.r;
                    if (strArr != null) {
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(dVar.b, g0.a(str), new com.kc.dw.core.utils.j());
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void j() {
        try {
            MediaPlayer mediaPlayer = this.b.getMediaPlayer();
            String str = this.f39125a;
            StringBuilder sb = new StringBuilder();
            sb.append("stop(), mediaPlayer=");
            sb.append(mediaPlayer);
            sb.append(",isPlaying=");
            sb.append(mediaPlayer != null && mediaPlayer.isPlaying());
            LogUtil.d(str, sb.toString());
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                try {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        g();
    }

    @Override // com.kc.dw.ad.a0
    public void mute() {
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
        if (this.t) {
            if (!this.q) {
                SsdVideoTextureView ssdVideoTextureView = this.b;
                if (ssdVideoTextureView.j) {
                    this.q = true;
                    ssdVideoTextureView.post(new a(this));
                }
            }
            int i = this.o;
            if (i == 0 && this.g) {
                start();
            } else if (i == 1 || (i == 2 && this.g)) {
                resume();
            }
        }
        if (this.g) {
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.T, new IntentFilter("ACTION_DOWNLOAD_CLICKED"));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = false;
        if (this.t && this.o == 1 && !this.n && this.g) {
            pause();
        }
        if (this.g) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.T);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:22:0x0044 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051 A[ADDED_TO_REGION] */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        float f;
        float f2;
        int i5;
        int i6;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f3 = this.v;
        if (0.0f < f3) {
            float f4 = this.w;
            if (0.0f >= f4) {
                i3 = this.h;
                if (i3 > 0 && (i4 = this.i) > 0) {
                    if (size <= 0 && size2 == 0) {
                        f = i4 * size;
                        f2 = i3;
                    } else if (size != 0 && size2 > 0) {
                        i5 = (int) ((i3 * size2) / i4);
                        i = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                    } else if (size > 0 && size2 > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        f = this.i * size;
                        f2 = this.h;
                    }
                    i6 = (int) (f / f2);
                    i2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                }
            } else if (size > 0 && size2 == 0) {
                i6 = (int) ((f4 * size) / f3);
                i2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else if (size == 0 && size2 > 0) {
                i5 = (int) ((f3 * size2) / f4);
                i = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            }
        } else {
            i3 = this.h;
            if (i3 > 0) {
                if (size <= 0) {
                    if (size != 0) {
                    }
                    if (size > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        f = this.i * size;
                        f2 = this.h;
                        i6 = (int) (f / f2);
                        i2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                    }
                } else {
                    if (size != 0) {
                    }
                    if (size > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        f = this.i * size;
                        f2 = this.h;
                        i6 = (int) (f / f2);
                        i2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        int i;
        super.onWindowFocusChanged(z);
        if (this.I) {
            return;
        }
        if (!z && (i = this.o) != 3 && i != 0 && this.m && !this.n && this.L != 1) {
            LogUtil.d(this.f39125a, "onWindowFocusChanged,onPause");
            pause();
            return;
        }
        if (z) {
            int i2 = this.o;
            if (i2 == 2 || (this.n && i2 != 3 && this.m)) {
                String str = this.f39125a;
                StringBuilder sbA = com.kc.dw.activity.a.a("onResume,playState=");
                sbA.append(this.o);
                LogUtil.d(str, sbA.toString());
                resume();
            }
        }
    }

    @Override // com.kc.dw.ad.a0
    public void pause() {
        int i;
        h hVar;
        if ((this.s && this.o == 3) || (i = this.o) == 0) {
            return;
        }
        this.u = true;
        this.o = 2;
        this.b.c();
        g();
        if (i == 2 || (hVar = this.z) == null) {
            return;
        }
        ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).d();
    }

    @Override // com.kc.dw.ad.a0
    public void replay() {
        if (this.s && this.o == 3) {
            return;
        }
        this.o = 0;
        this.u = false;
        this.J = false;
        start();
    }

    @Override // com.kc.dw.ad.a0
    public void resume() {
        if ((this.s && this.o == 3) || this.o == 0) {
            return;
        }
        this.u = false;
        this.o = 1;
        this.b.d();
        h();
        h hVar = this.z;
        if (hVar != null) {
            ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).e();
        }
    }

    public void setActivityForLifecycle(Activity activity) {
        if (this.D == null) {
            com.kc.dw.ad.lifecycle.c cVar = new com.kc.dw.ad.lifecycle.c();
            this.D = cVar;
            cVar.b = activity;
        }
    }

    public void setAdListener(com.kc.dw.ad.nativ.a aVar) {
        this.B = aVar;
        this.C = false;
    }

    public void setAutoStart(boolean z) {
        this.g = z;
        if (z) {
            return;
        }
        this.c.b(R.id.ms_center_play_button).d(0);
    }

    public void setConfigHeight(int i) {
        this.i = i;
    }

    public void setConfigWidth(int i) {
        this.h = i;
    }

    public void setContainerHeight(float f) {
        this.w = f;
    }

    public void setContainerWidth(float f) {
        this.v = f;
    }

    public void setDisplayMode(int i) {
        this.b.setDisplayMode(i);
    }

    public void setFromLogo(String str) {
        if (str != null) {
            this.c.b(R.id.ssd_img_ad_tag).a(str, false);
        }
    }

    public void setFromLogoVisibility(int i) {
        com.kc.dw.core.bquery.d dVarB = this.c.b(R.id.ssd_img_ad_tag);
        View view = dVarB.d;
        if (view == null || view.getVisibility() == i) {
            return;
        }
        dVarB.d.setVisibility(i);
    }

    public void setInitMute(boolean z) {
        com.kc.dw.core.bquery.d dVarB = this.c.b(R.id.ms_video_volume_mute);
        if (z) {
            dVarB.d(0);
            this.c.b(R.id.ms_video_volume).d(8);
        } else {
            dVarB.d(8);
            this.c.b(R.id.ms_video_volume).d(0);
        }
        this.b.setInitMute(z);
    }

    public void setIsEyes(int i) {
        this.L = i;
    }

    public void setMsAd(d dVar) {
        this.p = dVar;
    }

    @Override // com.kc.dw.ad.a0
    public void setNativeAdMediaListener(h hVar) {
        this.z = hVar;
    }

    public void setOnExposureListener(RecylcerAdInteractionListener recylcerAdInteractionListener) {
        this.O = recylcerAdInteractionListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.A = onInfoListener;
    }

    public void setOnPreparedListener(IPreparedListener iPreparedListener) {
        this.U = iPreparedListener;
    }

    public void setOnVideoLoadedListener(a0.c cVar) {
        this.x = cVar;
    }

    public void setPlayOnce(boolean z) {
        this.s = z;
    }

    @Override // com.kc.dw.ad.a0
    public void setPreparedStartPlayListener(com.kc.dw.ad.nativ.c cVar) {
        this.V = cVar;
    }

    public void setProgressLoadingVisible(boolean z) {
        com.kc.dw.core.bquery.d dVarB;
        int i;
        if (z) {
            dVarB = this.c.b(R.id.ms_progress_loading);
            i = 0;
        } else {
            dVarB = this.c.b(R.id.ms_progress_loading);
            i = 8;
        }
        dVarB.d(i);
    }

    public void setRadius(int i) {
        try {
            ImageView imageView = this.Q;
            if (imageView instanceof RoundImageView) {
                ((RoundImageView) imageView).setCornerRadius(i);
            }
            this.b.setRadius((int) DimensionUtils.dip2px(getContext(), i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRecycler(boolean z) {
        this.t = z;
    }

    public void setRewardWeb(boolean z) {
        this.I = z;
    }

    public void setUseTransform(boolean z) {
        this.b.setUseTransform(z);
    }

    public void setVideoCover(String str) {
        this.k = str;
        this.c.b(R.id.ms_video_cover).a(str, false);
    }

    public void setVideoCoverScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.Q;
        if (imageView == null || scaleType == null) {
            return;
        }
        imageView.setScaleType(scaleType);
    }

    public void setVideoEndCover(String str) {
        this.l = str;
    }

    @Override // com.kc.dw.ad.a0
    public void setVideoPath(String str) {
        a(str, -1L, -1L);
    }

    @Override // com.kc.dw.ad.a0
    public void start() {
        int i = this.o;
        if (i == 0 || i == 3) {
            if (this.s && i == 3) {
                return;
            }
            this.o = 1;
            this.F = false;
            this.G = false;
            this.H = false;
            if (this.u) {
                return;
            }
            this.b.e();
            h();
            h hVar = this.z;
            if (hVar == null || !this.b.j || this.J) {
                return;
            }
            this.J = true;
            ((com.kc.dw.platform.ad_adapter.recycler.d) hVar).f();
        }
    }

    @Override // com.kc.dw.ad.a0
    public void unmute() {
        i();
    }
}
