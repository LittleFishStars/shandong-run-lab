package com.kc.cw.ad;

import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.util.FileTypes;
import com.kc.cw.ad.internal.b.f;
import com.kc.cw.ad.internal.c.p;
import com.kc.cw.ad.internal.e.h;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.internal.video.VideoStateListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, com.kc.cw.ad.internal.e.c {
    private int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.cw.ad.internal.e.b f38760a;
    protected MediaPlayer b;
    protected c.b c;
    private final com.kc.cw.ad.internal.e.a d;
    private final f e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private h s;
    private VideoStateListener t;
    private com.kc.cw.ad.b.a u;
    private com.kc.cw.ad.b.a v;
    private String w;
    private Handler x;
    private Runnable y;
    private a z;

    @Keep
    public enum a {
        NRF_NONE,
        NRF_START,
        NRF_PAUSE
    }

    public d(com.kc.cw.ad.internal.e.b bVar) {
        super(bVar.a());
        this.f = false;
        this.g = false;
        this.h = false;
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.z = a.NRF_NONE;
        this.c = c.b.FIT_CENTER;
        this.A = 0;
        this.f38760a = bVar;
        com.kc.cw.ad.internal.e.a aVar = bVar.f39020a;
        this.d = aVar;
        this.e = bVar.b;
        if (aVar != null) {
            aVar.setAdVideoView(this);
            this.t = aVar.getVideoStateListener();
        }
    }

    private void a(int i, int i2) {
        Matrix matrixA;
        if (i == 0 || i2 == 0 || (matrixA = new c(new c.C0970c(getWidth(), getHeight()), new c.C0970c(i, i2)).a(this.c)) == null) {
            return;
        }
        setTransform(matrixA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kc.cw.ad.a.d dVar) {
        com.kc.cw.ad.internal.e.a aVar = this.d;
        if (aVar == null || aVar.getAdDispatcher() == null) {
            return;
        }
        com.kc.cw.ad.internal.e.a aVar2 = this.d;
        aVar2.j++;
        if (aVar2.g()) {
            this.d.getAdDispatcher().b();
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(this.d.getOpensNativeBrowser());
            this.e.a(this, this.A, this.d.g(), dVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:88:0x013b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(HashMap map) {
        String str;
        byte b;
        c.b bVar;
        if (map.isEmpty() || !map.containsKey("SCALE") || (str = (String) map.get("SCALE")) == null) {
            return;
        }
        switch (str.hashCode()) {
            case -2092301763:
                if (!str.equals("RIGHT_TOP_CROP")) {
                    b = -1;
                } else {
                    b = 19;
                }
                break;
            case -1943089714:
                if (!str.equals("RIGHT_BOTTOM")) {
                    b = -1;
                } else {
                    b = 12;
                }
                break;
            case -1923874824:
                if (!str.equals("RIGHT_CENTER")) {
                    b = -1;
                } else {
                    b = 11;
                }
                break;
            case -1792626435:
                if (!str.equals("LEFT_TOP")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -1629510025:
                if (!str.equals("RIGHT_CENTER_CROP")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.x;
                }
                break;
            case -1130639214:
                if (!str.equals("LEFT_TOP_CROP")) {
                    b = -1;
                } else {
                    b = 13;
                }
                break;
            case -1092027392:
                if (!str.equals("END_INSIDE")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.B;
                }
                break;
            case -1025888925:
                if (!str.equals("LEFT_BOTTOM")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -1006674035:
                if (!str.equals("LEFT_CENTER")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -440887238:
                if (!str.equals("CENTER_CROP")) {
                    b = -1;
                } else {
                    b = 17;
                }
                break;
            case -438941894:
                if (!str.equals("CENTER_BOTTOM_CROP")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.u;
                }
                break;
            case -188276732:
                if (!str.equals("CENTER_TOP_CROP")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.r;
                }
                break;
            case -172377086:
                if (!str.equals("LEFT_CENTER_CROP")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.p;
                }
                break;
            case -128849043:
                if (!str.equals("FIT_END")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 378209945:
                if (!str.equals("START_INSIDE")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.z;
                }
                break;
            case 384437857:
                if (!str.equals("RIGHT_BOTTOM_CROP")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.y;
                }
                break;
            case 743229044:
                if (!str.equals("FIT_START")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 1093733475:
                if (!str.equals("FIT_CENTER")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 1218764914:
                if (!str.equals("RIGHT_TOP")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 1477882197:
                if (!str.equals("CENTER_BOTTOM")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case 1648362059:
                if (!str.equals("CENTER_TOP")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 1677322022:
                if (!str.equals("CENTER_INSIDE")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.A;
                }
                break;
            case 1841570796:
                if (!str.equals("LEFT_BOTTOM_CROP")) {
                    b = -1;
                } else {
                    b = com.google.common.base.a.q;
                }
                break;
            case 1984282709:
                if (!str.equals("CENTER")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case 2074054159:
                if (!str.equals("FIT_XY")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                bVar = c.b.FIT_XY;
                break;
            case 1:
                bVar = c.b.FIT_START;
                break;
            case 2:
            default:
                bVar = c.b.FIT_CENTER;
                break;
            case 3:
                bVar = c.b.FIT_END;
                break;
            case 4:
                bVar = c.b.LEFT_TOP;
                break;
            case 5:
                bVar = c.b.LEFT_CENTER;
                break;
            case 6:
                bVar = c.b.LEFT_BOTTOM;
                break;
            case 7:
                bVar = c.b.CENTER_TOP;
                break;
            case 8:
                bVar = c.b.CENTER;
                break;
            case 9:
                bVar = c.b.CENTER_BOTTOM;
                break;
            case 10:
                bVar = c.b.RIGHT_TOP;
                break;
            case 11:
                bVar = c.b.RIGHT_CENTER;
                break;
            case 12:
                bVar = c.b.RIGHT_BOTTOM;
                break;
            case 13:
                bVar = c.b.LEFT_TOP_CROP;
                break;
            case 14:
                bVar = c.b.LEFT_CENTER_CROP;
                break;
            case 15:
                bVar = c.b.LEFT_BOTTOM_CROP;
                break;
            case 16:
                bVar = c.b.CENTER_TOP_CROP;
                break;
            case 17:
                bVar = c.b.CENTER_CROP;
                break;
            case 18:
                bVar = c.b.CENTER_BOTTOM_CROP;
                break;
            case 19:
                bVar = c.b.RIGHT_TOP_CROP;
                break;
            case 20:
                bVar = c.b.RIGHT_CENTER_CROP;
                break;
            case 21:
                bVar = c.b.RIGHT_BOTTOM_CROP;
                break;
            case 22:
                bVar = c.b.START_INSIDE;
                break;
            case 23:
                bVar = c.b.CENTER_INSIDE;
                break;
            case 24:
                bVar = c.b.END_INSIDE;
                break;
        }
        this.c = bVar;
    }

    private void b(int i, int i2) {
        this.p = i == 0 && i2 == 0;
    }

    private void p() {
        if (this.b != null) {
            e();
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.b = mediaPlayer;
        mediaPlayer.setOnVideoSizeChangedListener(this);
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.v == null) {
            com.kc.cw.ad.b.a aVar = new com.kc.cw.ad.b.a(10000L, 50L);
            this.v = aVar;
            aVar.a(new com.kc.cw.ad.b.b(this) { // from class: com.kc.cw.ad.d.4

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f38764a;

                {
                    this.f38764a = this;
                }

                @Override // com.kc.cw.ad.b.b
                public void a() {
                    if (this.f38764a.u != null) {
                        this.f38764a.u.c();
                        return;
                    }
                    d dVar = this.f38764a;
                    if (dVar.f38760a == null || !dVar.d.d()) {
                        return;
                    }
                    this.f38764a.r();
                }

                @Override // com.kc.cw.ad.b.b
                public void a(long j) {
                }

                @Override // com.kc.cw.ad.b.b
                public void b() {
                }
            });
        }
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.g) {
            return;
        }
        this.g = true;
        if (this.f38760a != null && this.d.d() && this.u == null) {
            if (this.n <= 0) {
                this.n = 10;
                this.o = true;
            }
            this.d.a(this.n, this.f38760a.g(), this.f38760a.h());
        }
    }

    private void s() {
        this.x = new Handler();
        this.y = new Runnable(this) { // from class: com.kc.cw.ad.d.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final d f38765a;

            {
                this.f38765a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                MediaPlayer mediaPlayer = this.f38765a.b;
                if (mediaPlayer == null || !mediaPlayer.isPlaying() || this.f38765a.b.getDuration() <= 0) {
                    return;
                }
                int duration = this.f38765a.b.getDuration();
                int currentPosition = this.f38765a.b.getCurrentPosition();
                com.kc.cw.ad.d.b.f.a("OctopusAd", "currentPosition:" + currentPosition + WVNativeCallbackUtil.SEPERATER + duration);
                int i2 = currentPosition / 1000;
                if (i2 == duration / 4000) {
                    i = 1;
                } else if (i2 == duration / 2000) {
                    i = 2;
                } else {
                    i = i2 == (duration * 3) / 4000 ? 3 : 0;
                }
                if (i > 0 && this.f38765a.e != null) {
                    this.f38765a.e.c(i);
                }
                com.kc.cw.ad.d.b.f.a("OctopusAd", "video progress:" + i);
                this.f38765a.t();
            }
        };
        a(new MediaPlayer.OnPreparedListener(this) { // from class: com.kc.cw.ad.d.6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final d f38766a;

            {
                this.f38766a = this;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                this.f38766a.setScalableType(c.b.FIT_CENTER);
                this.f38766a.n = mediaPlayer.getDuration() / 1000;
                Log.d("OctopusAd", "mPlayTime:" + this.f38766a.n);
                if (this.f38766a.p) {
                    com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Video start called!");
                    this.f38766a.c();
                    this.f38766a.z = a.NRF_START;
                    if (this.f38766a.e != null) {
                        this.f38766a.e.ah();
                    }
                    if (this.f38766a.t != null) {
                        this.f38766a.t.onVideoStart();
                    }
                    if (this.f38766a.d != null) {
                        this.f38766a.d.m();
                    }
                    this.f38766a.t();
                } else {
                    this.f38766a.z = a.NRF_PAUSE;
                }
                if (this.f38766a.n <= 0) {
                    Log.e("OctopusAd_Video", "Video Play Time = 0");
                    if (this.f38766a.d != null) {
                        this.f38766a.d.b(80202);
                    }
                }
            }
        });
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        a(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Handler handler = this.x;
        if (handler == null || this.y == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.x.postDelayed(this.y, 1000L);
    }

    public void a(float f, float f2) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.b.setOnPreparedListener(onPreparedListener);
        this.b.prepareAsync();
        VideoStateListener videoStateListener = this.t;
        if (videoStateListener != null) {
            videoStateListener.onVideoReady();
        }
    }

    public void a(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        p();
        this.b.setDataSource(fileDescriptor, j, j2);
    }

    public void a(String str) {
        int creativeWidth;
        int creativeHeight;
        if (p.a(str)) {
            i();
            com.kc.cw.ad.internal.e.a aVar = this.d;
            if (aVar != null) {
                aVar.b(80200);
                return;
            }
            return;
        }
        if (str.endsWith(FileTypes.F) || str.endsWith(".jpeg") || str.endsWith(".png")) {
            i();
            com.kc.cw.ad.internal.e.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.b(80201);
                return;
            }
            return;
        }
        com.kc.cw.ad.internal.e.b bVar = this.f38760a;
        if (bVar != null) {
            this.l = bVar.getCreativeHeight();
            this.k = this.f38760a.getCreativeWidth();
            this.j = this.f38760a.f();
            this.i = this.f38760a.e();
            this.m = this.f38760a.s();
        }
        try {
            new URI(str);
            this.c = c.b.FIT_CENTER;
            com.kc.cw.ad.internal.e.b bVar2 = this.f38760a;
            if (bVar2 != null) {
                a(bVar2.b());
                this.q = this.f38760a.i() && q.a().h();
            }
            this.w = str;
            p();
            float fG = q.a().g();
            if (this.q) {
                a(0.0f, 0.0f);
            } else {
                if (fG <= 0.0f) {
                    fG = 1.0f;
                }
                a(fG, fG);
            }
            float fO = q.a().o();
            float fP = q.a().p();
            if (getCreativeWidth() == 1 && getCreativeHeight() == 1) {
                creativeHeight = -1;
                creativeWidth = -1;
            } else {
                creativeWidth = (int) ((getCreativeWidth() * fO) + 0.5f);
                creativeHeight = (int) ((getCreativeHeight() * fP) + 0.5f);
            }
            if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                setLayoutParams(new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17));
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                layoutParams.setMargins((int) ((getCreativeLeft() * fO) + 0.5f), (int) ((getCreativeTop() * fP) + 0.5f), 0, 0);
                setLayoutParams(layoutParams);
            }
            setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) { // from class: com.kc.cw.ad.d.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f38761a;

                {
                    this.f38761a = this;
                }

                /* JADX WARN: Code duplicated, block: B:25:0x0082  */
                /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    String str2;
                    this.f38761a.h = true;
                    if (this.f38761a.e != null) {
                        this.f38761a.e.aj();
                    }
                    if (this.f38761a.d != null) {
                        this.f38761a.d.p();
                    }
                    if (this.f38761a.t != null) {
                        this.f38761a.t.onVideoCompleted();
                    }
                    com.kc.cw.ad.internal.e.b bVar3 = this.f38761a.f38760a;
                    if (bVar3 == null || bVar3.a(1)) {
                        if (this.f38761a.d instanceof com.kc.cw.ad.internal.e.f) {
                            if (((com.kc.cw.ad.internal.e.f) this.f38761a.d).getAdImplementation() != null) {
                                ((e) ((com.kc.cw.ad.internal.e.f) this.f38761a.d).getAdImplementation()).f();
                            } else {
                                str2 = "Error in incentive video ad adaptation model !";
                            }
                        }
                        if (this.f38761a.d != null) {
                            this.f38761a.d.t();
                        }
                    }
                    str2 = "We can't go next, just stand here";
                    Log.d("OctopusAd", str2);
                    if (this.f38761a.d != null) {
                        this.f38761a.d.t();
                    }
                }
            });
            setOnInfoListener(new MediaPlayer.OnInfoListener(this) { // from class: com.kc.cw.ad.d.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f38762a;

                {
                    this.f38762a = this;
                }

                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    if (i != 3 && i != 702) {
                        if (this.f38762a.u == null || !this.f38762a.u.f()) {
                            return false;
                        }
                        this.f38762a.u.b();
                        if (this.f38762a.t != null) {
                            this.f38762a.t.onVideoStart();
                        }
                        if (this.f38762a.d != null) {
                            this.f38762a.d.a(this.f38762a);
                        }
                        this.f38762a.q();
                        return false;
                    }
                    if (this.f38762a.d != null && this.f38762a.d.getAdDispatcher() != null) {
                        this.f38762a.r();
                        this.f38762a.d.i();
                        this.f38762a.d.getAdDispatcher().d();
                    }
                    if (this.f38762a.u != null) {
                        this.f38762a.u.c();
                    }
                    if (this.f38762a.v == null) {
                        return false;
                    }
                    this.f38762a.v.e();
                    return false;
                }
            });
            setOnErrorListener(new MediaPlayer.OnErrorListener(this) { // from class: com.kc.cw.ad.d.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f38763a;

                {
                    this.f38763a = this;
                }

                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    Log.e("OctopusAd_Video", "MediaPlayer OnErrorListener: what: " + i + " extra: " + i2);
                    if (i == -38) {
                        this.f38763a.c();
                    } else if (this.f38763a.d != null) {
                        this.f38763a.d.b(80202);
                    }
                    if (this.f38763a.t == null) {
                        return false;
                    }
                    this.f38763a.t.onVideoError(i, i2);
                    return false;
                }
            });
        } catch (NullPointerException | URISyntaxException unused) {
            i();
            com.kc.cw.ad.internal.e.a aVar3 = this.d;
            if (aVar3 != null) {
                aVar3.b(80201);
            }
        }
    }

    public boolean a() {
        return this.b.isPlaying();
    }

    public void b() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void c() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void d() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void e() {
        this.b.reset();
    }

    public void f() {
        e();
        Handler handler = this.x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.x = null;
        }
        this.y = null;
        this.b.release();
        this.b = null;
    }

    public boolean g() {
        boolean z = !this.q;
        this.q = z;
        float f = z ? 0.0f : 1.0f;
        a(f, f);
        return this.q;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public com.kc.cw.ad.internal.e.b getAdWebView() {
        return this.f38760a;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public int getCreativeHeight() {
        return this.l;
    }

    public int getCreativeLeft() {
        return this.i;
    }

    public int getCreativeTop() {
        return this.j;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public int getCreativeWidth() {
        return this.k;
    }

    public int getCurrentPosition() {
        return this.b.getCurrentPosition();
    }

    public int getDuration() {
        return this.b.getDuration();
    }

    public int getRefreshInterval() {
        return this.m;
    }

    public int getVideoHeight() {
        return this.b.getVideoHeight();
    }

    public String getVideoUrl() {
        return this.w;
    }

    public int getVideoWidth() {
        return this.b.getVideoWidth();
    }

    @Override // com.kc.cw.ad.internal.e.c
    public View getView() {
        return this;
    }

    public void h() {
        f fVar;
        if (TextUtils.isEmpty(this.w)) {
            return;
        }
        try {
            com.kc.cw.ad.internal.d.h hVarB = q.a().b();
            setDataSource((hVarB == null || !hVarB.b(this.w)) ? this.w : hVarB.a(this.w));
            s();
            com.kc.cw.ad.internal.e.a aVar = this.d;
            if (aVar == null || aVar.getMediaType() == com.kc.cw.ad.internal.p.SPLASH || (fVar = this.e) == null) {
                return;
            }
            fVar.a(this.d.g(), new com.kc.cw.ad.a(this) { // from class: com.kc.cw.ad.d.7

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f38767a;

                {
                    this.f38767a = this;
                }

                @Override // com.kc.cw.ad.a
                public void a(boolean z) {
                    if (this.f38767a.d.getAdDispatcher() != null) {
                        this.f38767a.d.getAdDispatcher().a(z);
                    }
                }
            });
        } catch (Exception e) {
            Log.e("OctopusAd_Video", "video play fail：" + e.getMessage());
            com.kc.cw.ad.internal.e.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.b(80202);
            }
        }
    }

    public void i() {
        com.kc.cw.ad.internal.e.b bVar = this.f38760a;
        if (bVar != null) {
            bVar.p();
        }
        this.f = true;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public boolean j() {
        return this.f;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public void k() {
        d();
        com.kc.cw.ad.b.a aVar = this.v;
        if (aVar != null) {
            aVar.d();
        }
        ViewUtil.removeChildFromParent(this);
    }

    @Override // com.kc.cw.ad.internal.e.c
    public void l() {
        if (this.d != null) {
            f fVar = this.e;
            if (fVar != null) {
                this.r = fVar.S();
            }
            this.s = new h(this, this.r, new h.a(this) { // from class: com.kc.cw.ad.d.8

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final d f38768a;

                {
                    this.f38768a = this;
                }

                @Override // com.kc.cw.ad.internal.e.h.a
                public void a(View view, com.kc.cw.ad.a.d dVar) {
                    this.f38768a.a(dVar);
                }
            });
            this.d.d(this);
            this.d.c(this);
            this.d.e(this);
            com.kc.cw.ad.internal.e.b bVar = this.f38760a;
            if (bVar != null && bVar.d()) {
                if (this.d.getMediaType() == com.kc.cw.ad.internal.p.INTERSTITIAL || this.d.getMediaType() == com.kc.cw.ad.internal.p.FULLSCREEN) {
                    this.d.a(this.f38760a.g(), this.f38760a.h(), this);
                } else if (this.d.getMediaType() == com.kc.cw.ad.internal.p.REWARD) {
                    this.d.a(this.n, this.f38760a.g(), Math.min(this.f38760a.h(), this.n));
                }
                this.d.a(this, this.q);
                this.d.setAdWebView(this.f38760a);
                this.d.a(this);
            }
            if (this.f38760a == null || !this.d.d()) {
                return;
            }
            q();
        }
    }

    public void m() {
        if (this.o) {
            com.kc.cw.ad.b.a aVar = this.u;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (this.h || this.z != a.NRF_START) {
            return;
        }
        b();
        com.kc.cw.ad.b.a aVar2 = this.u;
        if (aVar2 != null) {
            aVar2.b();
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.ai();
        }
        VideoStateListener videoStateListener = this.t;
        if (videoStateListener != null) {
            videoStateListener.onVideoPause();
        }
        this.z = a.NRF_PAUSE;
    }

    public void n() {
        if (this.o) {
            com.kc.cw.ad.b.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        if (this.h || this.z != a.NRF_PAUSE) {
            return;
        }
        c();
        com.kc.cw.ad.b.a aVar2 = this.u;
        if (aVar2 != null) {
            aVar2.c();
        }
        VideoStateListener videoStateListener = this.t;
        if (videoStateListener != null) {
            videoStateListener.onVideoResume();
        }
        this.z = a.NRF_START;
    }

    @Override // com.kc.cw.ad.internal.e.c
    public void o() {
        k();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b == null) {
            return;
        }
        if (a()) {
            d();
        }
        f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
            h();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h hVar = this.s;
        return hVar != null ? hVar.onTouch(this, motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        b(getWindowVisibility(), i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b(i, getVisibility());
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setCountDownTimer(com.kc.cw.ad.b.a aVar) {
        this.u = aVar;
    }

    public void setCreativeLeft(int i) {
        this.i = i;
    }

    public void setCreativeTop(int i) {
        this.j = i;
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        p();
        this.b.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) throws IOException {
        p();
        this.b.setDataSource(str);
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.b.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.b.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.b.setOnInfoListener(onInfoListener);
    }

    public void setOpt(int i) {
        this.A = i;
    }

    public void setRawData(int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setRefreshInterval(int i) {
        this.m = i;
    }

    public void setScalableType(c.b bVar) {
        this.c = bVar;
        a(getVideoWidth(), getVideoHeight());
    }
}
