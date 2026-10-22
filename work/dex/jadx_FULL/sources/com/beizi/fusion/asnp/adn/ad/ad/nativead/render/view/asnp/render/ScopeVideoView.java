package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.VideoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.ff;
import com.beizi.fusion.gf;
import com.beizi.fusion.gn;
import com.beizi.fusion.he;
import com.beizi.fusion.le;
import com.beizi.fusion.me;
import com.beizi.fusion.ph;
import com.beizi.fusion.wi;
import com.beizi.fusion.xp;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeVideoView extends ScopeViewGroup {
    private VideoView e;
    private MediaPlayer f;
    private ImageView g;
    private ImageView h;
    private ProgressBar i;
    private i j;
    private ImageView k;
    private View l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private h r;
    private d s;
    private final j t;
    private final ff u;
    private final g v;
    private final Handler w;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoView videoView;
            VideoView videoView2;
            super.handleMessage(message);
            if (message.what == 1 && (videoView2 = ScopeVideoView.this.e) != null) {
                Object obj = message.obj;
                if (obj instanceof File) {
                    videoView2.setVideoPath(((File) obj).getAbsolutePath());
                    ScopeVideoView.this.a((File) message.obj);
                }
            }
            if (message.what != 2 || (videoView = ScopeVideoView.this.e) == null) {
                return;
            }
            Object obj2 = message.obj;
            if (obj2 instanceof String) {
                videoView.setVideoURI(Uri.parse((String) obj2));
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScopeVideoView.this.h();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements e {
            public a() {
            }

            @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.e
            public void a(boolean z) {
                if (z) {
                    ScopeVideoView.this.k.setImageResource(R.drawable.asnp_voice_off);
                } else {
                    ScopeVideoView.this.k.setImageResource(R.drawable.asnp_voice_on);
                }
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScopeVideoView.this.switchVoice(new a());
        }
    }

    public interface d {
        boolean a();

        boolean b();

        boolean c();

        int d();
    }

    public interface e {
        void a(boolean z);
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ScopeVideoView f27054a;

        private g(ScopeVideoView scopeVideoView) {
            this.f27054a = scopeVideoView;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaPlayer f27055a;
        private final ff c;
        private final b e;
        private View f;
        private Handler g;
        private final int b = 1;
        private boolean h = false;
        private final HandlerThread d = new HandlerThread("VideoProgressHandlerThread");

        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    h hVar = h.this;
                    MediaPlayer mediaPlayer = hVar.f27055a;
                    if (mediaPlayer != null) {
                        int iB = hVar.b(mediaPlayer);
                        h hVar2 = h.this;
                        ff ffVar = hVar2.c;
                        if (ffVar != null) {
                            ffVar.a(gf.a.VIDEO_PROCESS, hVar2.f, Integer.valueOf(iB));
                        }
                        b bVar = h.this.e;
                        if (bVar != null) {
                            bVar.a(iB);
                        }
                        if (iB < h.this.f27055a.getDuration()) {
                            h.this.c();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public interface b {
            void a(int i);
        }

        public h(View view, MediaPlayer mediaPlayer, ff ffVar, b bVar) {
            this.f27055a = mediaPlayer;
            this.f = view;
            this.c = ffVar;
            this.e = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Handler handler = this.g;
            if (handler == null || !handler.hasMessages(1)) {
                return;
            }
            this.g.removeMessages(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int b(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null) {
                return 0;
            }
            try {
                return mediaPlayer.getCurrentPosition();
            } catch (IllegalStateException unused) {
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            Handler handler;
            if (!a(this.f27055a) || (handler = this.g) == null) {
                return;
            }
            handler.sendEmptyMessageDelayed(1, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.h) {
                return;
            }
            this.h = true;
            this.d.start();
            this.g = new a(this.d.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.h = false;
            this.d.quitSafely();
            Handler handler = this.g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
        }

        private boolean a(MediaPlayer mediaPlayer) {
            if (mediaPlayer == null) {
                return false;
            }
            try {
                return mediaPlayer.isPlaying();
            } catch (IllegalStateException unused) {
                return false;
            }
        }
    }

    public enum i {
        VIDEO_PLAYING,
        VIDEO_PAUSE,
        VIDEO_STANDBY,
        VIDEO_IDLE,
        VIDEO_RESUME
    }

    public class j implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

        public class a implements h.b {

            /* JADX INFO: renamed from: com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView$j$a$a, reason: collision with other inner class name */
            public class RunnableC0297a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f27060a;

                public RunnableC0297a(int i) {
                    this.f27060a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ScopeVideoView.this.i.setProgress(this.f27060a);
                }
            }

            public a() {
            }

            @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeVideoView.h.b
            public void a(int i) {
                ScopeVideoView.this.i.post(new RunnableC0297a(i));
            }
        }

        private j() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            d dVar;
            ScopeVideoView scopeVideoView = ScopeVideoView.this;
            scopeVideoView.n = true;
            scopeVideoView.m = 0;
            scopeVideoView.u.a(gf.a.VIDEO_FINISHED, scopeVideoView, Integer.valueOf(mediaPlayer.getDuration()));
            ScopeVideoView scopeVideoView2 = ScopeVideoView.this;
            scopeVideoView2.j = i.VIDEO_STANDBY;
            if (scopeVideoView2.g.getVisibility() != 0 && ((dVar = ScopeVideoView.this.s) == null || dVar.b())) {
                ScopeVideoView.this.g.setVisibility(0);
                ScopeVideoView.this.g.setImageResource(R.drawable.asnp_video_replay_icon);
            }
            ScopeVideoView.this.e();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            ScopeVideoView.this.m();
            ScopeVideoView scopeVideoView = ScopeVideoView.this;
            scopeVideoView.u.a(gf.a.VIDEO_ERROR, scopeVideoView, Integer.valueOf(scopeVideoView.a(mediaPlayer)));
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            ScopeVideoView scopeVideoView = ScopeVideoView.this;
            View view = scopeVideoView.l;
            if (view != null) {
                scopeVideoView.removeView(view);
            }
            ScopeVideoView scopeVideoView2 = ScopeVideoView.this;
            scopeVideoView2.f = mediaPlayer;
            scopeVideoView2.r = new h(scopeVideoView2, mediaPlayer, scopeVideoView2.u, new a());
            ScopeVideoView.this.r.d();
            ScopeVideoView.this.i.setMax(mediaPlayer.getDuration());
            if (ScopeVideoView.this.o) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            ScopeVideoView scopeVideoView3 = ScopeVideoView.this;
            if (scopeVideoView3.j == i.VIDEO_IDLE) {
                scopeVideoView3.j = i.VIDEO_STANDBY;
            }
            scopeVideoView3.f.seekTo(scopeVideoView3.m, 3);
            ScopeVideoView scopeVideoView4 = ScopeVideoView.this;
            if (scopeVideoView4.j == i.VIDEO_RESUME) {
                scopeVideoView4.j = i.VIDEO_STANDBY;
                scopeVideoView4.i();
            } else if (!scopeVideoView4.d()) {
                ScopeVideoView.this.g.setImageResource(android.R.drawable.ic_media_play);
            } else {
                ScopeVideoView.this.c();
                ScopeVideoView.this.i();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeVideoView(Context context) {
        super(context);
        this.j = i.VIDEO_IDLE;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = new j();
        this.u = new ff();
        this.v = new g();
        this.w = new a(Looper.getMainLooper());
        f();
    }

    private void a() {
        ImageView imageView = new ImageView(getContext());
        this.g = imageView;
        imageView.setOnClickListener(new b());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(gn.a.a(getContext(), 50.0f), gn.a.a(getContext(), 50.0f));
        layoutParams.addRule(13, -1);
        addView(this.g, layoutParams);
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        this.k = imageView;
        imageView.setOnClickListener(new c());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(gn.a.a(getContext(), 20.0f), gn.a.a(getContext(), 20.0f));
        layoutParams.leftMargin = gn.a.a(getContext(), 5.0f);
        layoutParams.topMargin = gn.a.a(getContext(), 5.0f);
        this.k.setImageResource(R.drawable.asnp_voice_off);
        addView(this.k, layoutParams);
        this.k.setVisibility(8);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0006, B:8:0x000c, B:12:0x001e, B:14:0x002b, B:16:0x002f, B:18:0x0035, B:19:0x0042, B:21:0x0046, B:11:0x001c), top: B:29:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0046 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0006, B:8:0x000c, B:12:0x001e, B:14:0x002b, B:16:0x002f, B:18:0x0035, B:19:0x0042, B:21:0x0046, B:11:0x001c), top: B:29:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x000c A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0006, B:8:0x000c, B:12:0x001e, B:14:0x002b, B:16:0x002f, B:18:0x0035, B:19:0x0042, B:21:0x0046, B:11:0x001c), top: B:29:0x0004 }] */
    private synchronized void c(boolean z) {
        int currentPosition;
        h hVar;
        d dVar;
        if (!z) {
            if (this.j == i.VIDEO_PLAYING) {
                this.j = i.VIDEO_PAUSE;
                currentPosition = this.e.getCurrentPosition();
                if (this.m != 0) {
                    this.m = currentPosition;
                } else {
                    this.m = currentPosition;
                }
                this.e.pause();
                if (this.g.getVisibility() != 0) {
                    this.g.setImageResource(android.R.drawable.ic_media_play);
                    this.g.setVisibility(0);
                }
                hVar = this.r;
                if (hVar != null) {
                    hVar.a();
                    return;
                }
            }
            return;
        }
        this.p = false;
        if (this.j == i.VIDEO_PLAYING) {
            this.j = i.VIDEO_PAUSE;
            currentPosition = this.e.getCurrentPosition();
            if (this.m != 0 || currentPosition != 0) {
                this.m = currentPosition;
            }
            this.e.pause();
            if (this.g.getVisibility() != 0 && ((dVar = this.s) == null || dVar.b())) {
                this.g.setImageResource(android.R.drawable.ic_media_play);
                this.g.setVisibility(0);
            }
            hVar = this.r;
            if (hVar != null) {
                hVar.a();
                return;
            }
        }
        return;
        throw th;
    }

    private synchronized void d(boolean z) {
        if (z) {
            this.p = true;
        }
        if (!this.n && this.p) {
            i iVar = this.j;
            if (iVar == i.VIDEO_STANDBY) {
                c();
                i();
            } else if (iVar == i.VIDEO_PAUSE) {
                this.e.resume();
                this.j = i.VIDEO_RESUME;
                if (this.g.getVisibility() == 0) {
                    this.g.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        d dVar = this.s;
        if (dVar != null) {
            this.q = dVar.c();
        }
        if (!this.q) {
            this.h.setVisibility(0);
            return;
        }
        this.n = false;
        c();
        i();
    }

    private void f() {
        this.e = new VideoView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View view = new View(getContext());
        this.l = view;
        view.setBackgroundColor(-1);
        layoutParams.addRule(13, -1);
        addView(this.e, layoutParams);
        addView(this.l, new ViewGroup.LayoutParams(-1, -1));
        this.i = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, gn.a.a(getContext(), 2.0f));
        layoutParams2.addRule(12, -1);
        addView(this.i, layoutParams2);
        ImageView imageView = new ImageView(getContext());
        this.h = imageView;
        addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        this.h.setVisibility(8);
        a();
        b();
    }

    private boolean g() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (!this.n && this.p && this.j == i.VIDEO_STANDBY && gn.a.a(this.e, 50)) {
            l();
            if (this.g.getVisibility() == 0) {
                this.g.setVisibility(8);
            }
        }
    }

    private void j() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
        this.o = true;
    }

    private void k() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
        this.o = false;
    }

    private synchronized void l() {
        if (this.m == 0) {
            this.u.a(gf.a.VIDEO_START, this, 0);
        }
        this.h.setVisibility(8);
        this.e.start();
        this.j = i.VIDEO_PLAYING;
        h hVar = this.r;
        if (hVar != null) {
            hVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        this.e.stopPlayback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayVideoFilePath(File file) {
        if (!g()) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = file;
            this.w.sendMessage(messageObtain);
            return;
        }
        VideoView videoView = this.e;
        if (videoView != null) {
            videoView.setVideoPath(file.getAbsolutePath());
            a(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayVideoUrl(String str) {
        if (g()) {
            VideoView videoView = this.e;
            if (videoView != null) {
                videoView.setVideoURI(Uri.parse(str));
                return;
            }
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = str;
        this.w.sendMessage(messageObtain);
    }

    public boolean alreadyPlay() {
        return this.j == i.VIDEO_PLAYING;
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void bindRenderModel(RenderModel renderModel) {
        super.bindRenderModel(renderModel);
        ViewModel viewModel = renderModel.getViewModel();
        if (viewModel != null) {
            this.q = viewModel.getReplay() == 1;
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        a(aVar);
    }

    public g getVideoController() {
        return this.v;
    }

    public void h() {
        if (this.j == i.VIDEO_PLAYING) {
            c(true);
        }
        if (this.j == i.VIDEO_STANDBY) {
            if (this.n) {
                this.n = false;
            }
            c();
            i();
        }
        if (this.j == i.VIDEO_PAUSE) {
            d(true);
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewDestroy() {
        VideoView videoView = this.e;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        h hVar = this.r;
        if (hVar != null) {
            hVar.b();
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        c(false);
        this.u.b();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        d(false);
        this.u.a();
    }

    public void registerVideoObserver(gf gfVar) {
        ff ffVar = this.u;
        if (ffVar != null) {
            ffVar.a(gfVar);
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        super.setExpressRoot(scopeExpressContainer);
        ScopeExpressContainer.d.a(scopeExpressContainer, this);
    }

    public void setMediaConfig(d dVar) {
        if (dVar != null) {
            this.s = dVar;
            if (!dVar.b()) {
                this.g.setVisibility(8);
                this.i.setVisibility(8);
            }
            if (this.e != null) {
                if (dVar.a()) {
                    j();
                    this.k.setImageResource(R.drawable.asnp_voice_off);
                } else {
                    k();
                    this.k.setImageResource(R.drawable.asnp_voice_on);
                }
            }
        }
    }

    public void switchVoice(e eVar) {
        if (this.o) {
            k();
        } else {
            j();
        }
        if (eVar != null) {
            eVar.a(this.o);
        }
    }

    public class f implements le, me {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f27053a;

        private f() {
            this.f27053a = false;
        }

        @Override // com.beizi.fusion.le
        public synchronized void a(String str, File file) {
            if (file != null) {
                if (file.exists()) {
                    try {
                        file.setLastModified(System.currentTimeMillis());
                    } catch (IllegalArgumentException | SecurityException unused) {
                    }
                    if (!this.f27053a) {
                        ScopeVideoView.this.setPlayVideoFilePath(file);
                    }
                    ScopeVideoView scopeVideoView = ScopeVideoView.this;
                    scopeVideoView.u.a(gf.a.VIDEO_PREPARED, scopeVideoView, 0);
                }
            }
        }

        @Override // com.beizi.fusion.me
        public synchronized void b(String str) {
            this.f27053a = true;
            ScopeVideoView.this.setPlayVideoUrl(str);
        }

        @Override // com.beizi.fusion.le
        public void a(String str) {
            if (this.f27053a) {
                return;
            }
            ScopeVideoView scopeVideoView = ScopeVideoView.this;
            scopeVideoView.u.a(gf.a.VIDEO_ERROR, scopeVideoView, 0);
        }
    }

    private String a(AssetModel assetModel) {
        if (assetModel == null || assetModel.getVideo() == null) {
            return "";
        }
        VideoModel video = assetModel.getVideo();
        String url = video.getUrl();
        String adm = video.getAdm();
        String curl = video.getCurl();
        if (!TextUtils.isEmpty(url)) {
            return url;
        }
        if (TextUtils.isEmpty(adm)) {
            return !TextUtils.isEmpty(curl) ? curl : "";
        }
        return adm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        d dVar = this.s;
        if (dVar == null) {
            return false;
        }
        int iD = dVar.d();
        return iD == 0 || (iD == 1 && wi.b(getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = i.VIDEO_IDLE;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = new j();
        this.u = new ff();
        this.v = new g();
        this.w = new a(Looper.getMainLooper());
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(10000L, 2);
                if (frameAtTime != null) {
                    this.h.setImageBitmap(frameAtTime);
                    this.h.setVisibility(0);
                }
                mediaMetadataRetriever.close();
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    private void a(he.a aVar) {
        RenderModel renderModel = this.b;
        if (renderModel != null && renderModel.getViewModel() != null) {
            if (this.b.getViewModel().isMute()) {
                j();
            } else {
                k();
            }
        }
        VideoView videoView = this.e;
        if (videoView != null) {
            videoView.setOnPreparedListener(this.t);
            this.e.setOnCompletionListener(this.t);
            this.e.setOnErrorListener(this.t);
            String strA = a(this.c);
            if (TextUtils.isEmpty(strA)) {
                if (aVar != null) {
                    aVar.a(this.b.getId());
                }
            } else {
                if (aVar != null) {
                    aVar.b(this.b.getId());
                }
                f fVar = new f();
                xp.b().a(getContext(), strA, ph.TEMPORARY, fVar, fVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = i.VIDEO_IDLE;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = new j();
        this.u = new ff();
        this.v = new g();
        this.w = new a(Looper.getMainLooper());
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return 0;
        }
        try {
            return mediaPlayer.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeVideoView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.j = i.VIDEO_IDLE;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = new j();
        this.u = new ff();
        this.v = new g();
        this.w = new a(Looper.getMainLooper());
        f();
    }
}
