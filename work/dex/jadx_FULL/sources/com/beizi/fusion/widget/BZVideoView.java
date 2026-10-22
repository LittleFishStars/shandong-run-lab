package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
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
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.beizi.fusion.R;
import com.beizi.fusion.of;
import com.beizi.fusion.q1;
import com.beizi.fusion.so;
import com.beizi.fusion.vp;
import com.beizi.fusion.w3;
import java.io.File;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BZVideoView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VideoView f27921a;
    private View b;
    private MediaPlayer c;
    private ImageView d;
    private ImageView e;
    private ProgressBar f;
    private l g;
    private ImageView h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private k n;
    private final m o;
    private final j p;
    private int q;
    private i r;
    private final Handler s;
    private int t;
    private long u;
    private ViewTreeObserver.OnScrollChangedListener v;
    private ScheduledFuture w;
    private ScheduledThreadPoolExecutor x;
    private boolean y;
    private Runnable z;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoView videoView;
            VideoView videoView2;
            super.handleMessage(message);
            try {
                if (message.what == 1 && (videoView2 = BZVideoView.this.f27921a) != null) {
                    Object obj = message.obj;
                    if (obj instanceof File) {
                        videoView2.setVideoPath(((File) obj).getAbsolutePath());
                        BZVideoView.this.a((File) message.obj);
                    }
                }
                if (message.what != 2 || (videoView = BZVideoView.this.f27921a) == null) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof String) {
                    videoView.setVideoURI(Uri.parse((String) obj2));
                }
            } catch (Exception unused) {
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BZVideoView.this.j();
        }
    }

    public class c implements of.f {
        public c() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            ImageView imageView;
            try {
                BZVideoView bZVideoView = BZVideoView.this;
                if (bZVideoView.g == l.VIDEO_PLAYING || bitmap == null || (imageView = bZVideoView.e) == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements vp.e {
        public d() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a(String str) {
            BZVideoView.this.setPlayVideoUrl(str);
        }

        @Override // com.beizi.fusion.vp.e
        public void a() {
            BZVideoView bZVideoView = BZVideoView.this;
            if (bZVideoView.e != null) {
                VideoView videoView = bZVideoView.f27921a;
                if (videoView != null) {
                    videoView.setVisibility(8);
                }
                BZVideoView.this.e.setVisibility(0);
            }
        }
    }

    public class e implements ViewTreeObserver.OnScrollChangedListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                long jA = so.a();
                BZVideoView bZVideoView = BZVideoView.this;
                if (jA - bZVideoView.u < 1000) {
                    return;
                }
                int[] iArr = new int[2];
                VideoView videoView = bZVideoView.f27921a;
                if (videoView != null) {
                    videoView.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    BZVideoView bZVideoView2 = BZVideoView.this;
                    if (i >= bZVideoView2.t || i <= 0) {
                        bZVideoView2.onViewPause(true);
                    } else {
                        bZVideoView2.onViewResume(true);
                    }
                }
                BZVideoView.this.u = so.a();
            } catch (Exception unused) {
            }
        }
    }

    public class f implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BZVideoView.this.onViewResume(true);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BZVideoView.this.onViewPause(true);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BZVideoView.this.onViewPause(true);
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            Handler handler2;
            Handler handler3;
            try {
                if (BZVideoView.this.h()) {
                    BZVideoView bZVideoView = BZVideoView.this;
                    if (!bZVideoView.y && (handler3 = bZVideoView.s) != null) {
                        handler3.post(new a());
                    }
                    BZVideoView.this.y = true;
                    return;
                }
                BZVideoView bZVideoView2 = BZVideoView.this;
                if (bZVideoView2.y && (handler2 = bZVideoView2.s) != null) {
                    handler2.post(new b());
                }
                BZVideoView bZVideoView3 = BZVideoView.this;
                bZVideoView3.y = false;
                if (bZVideoView3.g != l.VIDEO_PLAYING || (handler = bZVideoView3.s) == null) {
                    return;
                }
                handler.post(new c());
            } catch (Exception unused) {
            }
        }
    }

    public interface g {
        boolean a();

        boolean b();
    }

    public interface h {
        void a(boolean z);
    }

    public interface i {
        void a();

        void a(int i, int i2);

        void b();
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BZVideoView f27931a;

        private j(BZVideoView bZVideoView) {
            this.f27931a = bZVideoView;
        }
    }

    public enum l {
        VIDEO_PLAYING,
        VIDEO_PAUSE,
        VIDEO_STANDBY,
        VIDEO_IDLE,
        VIDEO_RESUME
    }

    public class m implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

        public class a implements k.b {

            /* JADX INFO: renamed from: com.beizi.fusion.widget.BZVideoView$m$a$a, reason: collision with other inner class name */
            public class RunnableC0329a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f27937a;

                public RunnableC0329a(int i) {
                    this.f27937a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ProgressBar progressBar = BZVideoView.this.f;
                    if (progressBar != null) {
                        progressBar.setProgress(this.f27937a);
                    }
                    BZVideoView bZVideoView = BZVideoView.this;
                    i iVar = bZVideoView.r;
                    if (iVar != null) {
                        iVar.a(bZVideoView.q, this.f27937a);
                    }
                }
            }

            public a() {
            }

            @Override // com.beizi.fusion.widget.BZVideoView.k.b
            public void a(int i) {
                try {
                    ProgressBar progressBar = BZVideoView.this.f;
                    if (progressBar != null) {
                        progressBar.post(new RunnableC0329a(i));
                    }
                } catch (Exception unused) {
                }
            }
        }

        private m() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                BZVideoView bZVideoView = BZVideoView.this;
                bZVideoView.j = true;
                bZVideoView.i = 0;
                bZVideoView.g = l.VIDEO_STANDBY;
                ImageView imageView = bZVideoView.d;
                if (imageView != null && imageView.getVisibility() != 0) {
                    BZVideoView.this.getClass();
                    BZVideoView.this.d.setVisibility(0);
                    BZVideoView.this.d.setImageResource(R.mipmap.beizi_icon_video_replay);
                }
                i iVar = BZVideoView.this.r;
                if (iVar != null) {
                    iVar.a();
                }
                BZVideoView.this.c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            BZVideoView.this.q();
            return true;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                BZVideoView bZVideoView = BZVideoView.this;
                bZVideoView.c = mediaPlayer;
                bZVideoView.n = new k(mediaPlayer, new a());
                k kVar = BZVideoView.this.n;
                if (kVar != null) {
                    kVar.d();
                }
                if (mediaPlayer != null) {
                    BZVideoView.this.q = mediaPlayer.getDuration();
                    BZVideoView bZVideoView2 = BZVideoView.this;
                    ProgressBar progressBar = bZVideoView2.f;
                    if (progressBar != null) {
                        progressBar.setMax(bZVideoView2.q);
                    }
                    if (BZVideoView.this.k) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        mediaPlayer.setVolume(1.0f, 1.0f);
                    }
                    i iVar = BZVideoView.this.r;
                    if (iVar != null) {
                        iVar.b();
                    }
                }
                BZVideoView bZVideoView3 = BZVideoView.this;
                if (bZVideoView3.g == l.VIDEO_IDLE) {
                    bZVideoView3.g = l.VIDEO_STANDBY;
                }
                if (mediaPlayer != null) {
                    mediaPlayer.seekTo(bZVideoView3.i, 3);
                }
                BZVideoView bZVideoView4 = BZVideoView.this;
                if (bZVideoView4.g == l.VIDEO_RESUME) {
                    bZVideoView4.g = l.VIDEO_STANDBY;
                    bZVideoView4.k();
                } else if (bZVideoView4.b()) {
                    BZVideoView.this.a();
                    BZVideoView.this.k();
                } else {
                    ImageView imageView = BZVideoView.this.d;
                    if (imageView != null) {
                        imageView.setImageResource(R.mipmap.beizi_icon_video_replay);
                    }
                }
                View view = BZVideoView.this.b;
                if (view != null) {
                    view.setVisibility(8);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BZVideoView(Context context) {
        super(context);
        this.g = l.VIDEO_IDLE;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
        this.o = new m();
        this.p = new j();
        this.s = new a(Looper.getMainLooper());
        this.v = new e();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (this.m) {
                this.j = false;
                a();
                k();
            } else {
                ImageView imageView = this.e;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private synchronized void d() {
        try {
            ScheduledFuture scheduledFuture = this.w;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.w = null;
            }
            this.z = null;
        } catch (Exception unused) {
        }
    }

    private synchronized void e() {
        d();
    }

    private void f() {
        try {
            this.f27921a = new VideoView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            addView(this.f27921a, layoutParams);
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.b = frameLayout;
            frameLayout.setBackgroundColor(Color.parseColor("#000000"));
            addView(this.b, layoutParams);
            this.f = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, so.a(getContext(), 2.0f));
            layoutParams2.addRule(12, -1);
            addView(this.f, layoutParams2);
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            this.e.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    private boolean g() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        try {
            VideoView videoView = this.f27921a;
            if (videoView != null && videoView.getVisibility() == 0 && this.f27921a.getParent() != null) {
                if (!q1.h().v() && !this.f27921a.hasWindowFocus()) {
                    return false;
                }
                Rect rect = new Rect();
                if (!this.f27921a.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int iHeight = rect.height() * rect.width();
                int height = this.f27921a.getHeight() * this.f27921a.getWidth();
                return height > 0 && iHeight * 100 >= height * 50;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void i() {
        try {
            if (this.g == l.VIDEO_PLAYING) {
                this.g = l.VIDEO_PAUSE;
                VideoView videoView = this.f27921a;
                if (videoView != null) {
                    int currentPosition = videoView.getCurrentPosition();
                    if (this.i == 0 || currentPosition != 0) {
                        this.i = currentPosition;
                    }
                    this.f27921a.pause();
                }
                ImageView imageView = this.d;
                if (imageView != null && imageView.getVisibility() != 0) {
                    this.d.setImageResource(R.mipmap.beizi_icon_video_replay);
                    this.d.setVisibility(0);
                }
                k kVar = this.n;
                if (kVar != null) {
                    kVar.a();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            if (!this.j && this.l && this.g == l.VIDEO_STANDBY && h()) {
                p();
                ImageView imageView = this.d;
                if (imageView != null && imageView.getVisibility() == 0) {
                    this.d.setVisibility(8);
                }
                k kVar = this.n;
                if (kVar != null) {
                    kVar.c();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void l() {
        try {
            if (!this.j && this.l && h()) {
                l lVar = this.g;
                if (lVar == l.VIDEO_STANDBY) {
                    a();
                    k();
                    return;
                }
                if (lVar == l.VIDEO_PAUSE) {
                    VideoView videoView = this.f27921a;
                    if (videoView != null) {
                        videoView.resume();
                    }
                    this.g = l.VIDEO_RESUME;
                    ImageView imageView = this.d;
                    if (imageView == null || imageView.getVisibility() != 0) {
                        return;
                    }
                    this.d.setVisibility(8);
                }
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void m() {
        try {
            d();
            if (this.x == null) {
                this.x = w3.c().d();
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.x;
            if (scheduledThreadPoolExecutor != null && (scheduledThreadPoolExecutor.isShutdown() || this.x.isTerminated())) {
                this.x = w3.c().d();
            }
            f fVar = new f();
            this.z = fVar;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = this.x;
            if (scheduledThreadPoolExecutor2 != null) {
                this.w = scheduledThreadPoolExecutor2.scheduleWithFixedDelay(fVar, 0L, 1000L, TimeUnit.MILLISECONDS);
            }
        } catch (Exception unused) {
        }
    }

    private void n() {
        try {
            MediaPlayer mediaPlayer = this.c;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            this.k = true;
        } catch (Exception unused) {
        }
    }

    private void o() {
        try {
            MediaPlayer mediaPlayer = this.c;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            this.k = false;
        } catch (Exception unused) {
        }
    }

    private void p() {
        try {
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            VideoView videoView = this.f27921a;
            if (videoView != null) {
                videoView.start();
            }
            this.g = l.VIDEO_PLAYING;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            VideoView videoView = this.f27921a;
            if (videoView != null) {
                videoView.stopPlayback();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setPlayVideoFilePath(File file) {
        try {
            if (!g()) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = file;
                this.s.sendMessage(messageObtain);
                return;
            }
            VideoView videoView = this.f27921a;
            if (videoView != null) {
                videoView.setVideoPath(file.getAbsolutePath());
                a(file);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayVideoUrl(String str) {
        try {
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (g()) {
                VideoView videoView = this.f27921a;
                if (videoView != null) {
                    videoView.setVideoURI(Uri.parse(str));
                    return;
                }
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = str;
            this.s.sendMessage(messageObtain);
        } catch (Exception unused) {
        }
    }

    public void addPlayButton() {
        try {
            ImageView imageView = new ImageView(getContext());
            this.d = imageView;
            imageView.setOnClickListener(new b());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(so.a(getContext(), 60.0f), so.a(getContext(), 60.0f));
            layoutParams.addRule(13, -1);
            addView(this.d, layoutParams);
        } catch (Exception unused) {
        }
    }

    public boolean alreadyPlay() {
        return this.g == l.VIDEO_PLAYING;
    }

    public j getVideoController() {
        return this.p;
    }

    public void initVideoResource(String str, String str2, boolean z) {
        try {
            if (z) {
                n();
            } else {
                o();
            }
            if (this.e != null && !TextUtils.isEmpty(str2)) {
                of.a(getContext()).a(str2, new c());
            }
            VideoView videoView = this.f27921a;
            if (videoView != null) {
                videoView.setOnPreparedListener(this.o);
                this.f27921a.setOnCompletionListener(this.o);
                this.f27921a.setOnErrorListener(this.o);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.f27921a != null) {
                    this.t = so.g(getContext());
                    this.f27921a.getViewTreeObserver().addOnScrollChangedListener(this.v);
                }
                vp.c().a(getContext(), str, new d());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j() {
        try {
            if (this.g == l.VIDEO_PLAYING) {
                i();
            }
            if (this.g == l.VIDEO_STANDBY) {
                if (this.j) {
                    this.j = false;
                }
                a();
                k();
            }
            if (this.g == l.VIDEO_PAUSE) {
                l();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onViewPause(true);
        d();
    }

    public void onViewDestroy() {
        try {
            VideoView videoView = this.f27921a;
            if (videoView != null) {
                videoView.stopPlayback();
                if (this.v != null) {
                    this.f27921a.getViewTreeObserver().removeOnScrollChangedListener(this.v);
                }
            }
            k kVar = this.n;
            if (kVar != null) {
                kVar.b();
            }
            e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onViewPause(boolean z) {
        i();
    }

    public void onViewResume(boolean z) {
        l();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            onViewResume(true);
        } else if (i2 == 4 || i2 == 8) {
            onViewPause(true);
        }
    }

    public void setMediaConfig(g gVar) {
        if (gVar != null) {
            try {
                if (!gVar.b()) {
                    ImageView imageView = this.d;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    ProgressBar progressBar = this.f;
                    if (progressBar != null) {
                        progressBar.setVisibility(8);
                    }
                }
                if (this.f27921a != null) {
                    if (gVar.a()) {
                        n();
                        ImageView imageView2 = this.h;
                        if (imageView2 != null) {
                            imageView2.setImageResource(R.drawable.beizi_voice_off);
                            return;
                        }
                        return;
                    }
                    o();
                    ImageView imageView3 = this.h;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.beizi_voice_on);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setPlayProgressCallback(i iVar) {
        this.r = iVar;
    }

    public void switchVoice(h hVar) {
        try {
            if (this.k) {
                o();
            } else {
                n();
            }
            if (hVar != null) {
                hVar.a(this.k);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaPlayer f27932a;
        private final b d;
        private Handler e;
        private final int b = 1;
        private boolean f = false;
        private final HandlerThread c = new HandlerThread("VideoProgressHandlerThread");

        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    MediaPlayer mediaPlayer = k.this.f27932a;
                    if (mediaPlayer != null) {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        b bVar = k.this.d;
                        if (bVar != null) {
                            bVar.a(currentPosition);
                        }
                        if (currentPosition < k.this.f27932a.getDuration()) {
                            k.this.c();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public interface b {
            void a(int i);
        }

        public k(MediaPlayer mediaPlayer, b bVar) {
            this.f27932a = mediaPlayer;
            this.d = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            try {
                Handler handler = this.e;
                if (handler == null || !handler.hasMessages(1)) {
                    return;
                }
                this.e.removeMessages(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            try {
                this.f = false;
                HandlerThread handlerThread = this.c;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                }
                Handler handler = this.e;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            Handler handler;
            try {
                if (!a(this.f27932a) || (handler = this.e) == null) {
                    return;
                }
                handler.sendEmptyMessageDelayed(1, 1000L);
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            try {
                if (this.f) {
                    return;
                }
                this.f = true;
                HandlerThread handlerThread = this.c;
                if (handlerThread != null) {
                    handlerThread.start();
                    this.e = new a(this.c.getLooper());
                }
            } catch (Exception unused) {
            }
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

    /* JADX WARN: Multi-variable type inference failed */
    public BZVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = l.VIDEO_IDLE;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
        this.o = new m();
        this.p = new j();
        this.s = new a(Looper.getMainLooper());
        this.v = new e();
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BZVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = l.VIDEO_IDLE;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = true;
        this.o = new m();
        this.p = new j();
        this.s = new a(Looper.getMainLooper());
        this.v = new e();
        f();
    }
}
