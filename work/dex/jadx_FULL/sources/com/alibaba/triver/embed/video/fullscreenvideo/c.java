package com.alibaba.triver.embed.video.fullscreenvideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24865a = "JiaoZiVideoPlayer";
    public static final int b = 0;
    public static final int c = 2;
    public static TBMiniAppTextureView d;
    public static SurfaceTexture e;
    public static Surface f;
    public static c g;
    public b i;
    public HandlerThread l;
    public a m;
    private Activity n;
    public int h = -1;
    public int j = 0;
    public int k = 0;
    private float o = 0.0f;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 0) {
                if (i != 2) {
                    return;
                }
                c.this.i.e();
                return;
            }
            c cVar = c.this;
            cVar.j = 0;
            cVar.k = 0;
            cVar.i.b();
            try {
                if (c.e != null) {
                    Surface surface = c.f;
                    if (surface != null) {
                        surface.release();
                    }
                    Surface surface2 = new Surface(c.e);
                    c.f = surface2;
                    c.this.i.a(surface2);
                }
                try {
                    Surface surface3 = new Surface(c.e);
                    c.f = surface3;
                    c.this.i.a(surface3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException e2) {
                RVLogger.w(Log.getStackTraceString(e2));
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread("JiaoZiVideoPlayer");
        this.l = handlerThread;
        handlerThread.start();
        this.m = new a(this.l.getLooper());
        if (this.i == null) {
            this.i = new d() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.c.1
                @Override // com.alibaba.triver.embed.video.fullscreenvideo.d, com.alibaba.triver.embed.video.fullscreenvideo.b
                public void c() {
                    TBMiniAppTextureView tBMiniAppTextureView = c.d;
                    if (tBMiniAppTextureView != null) {
                        Context context = tBMiniAppTextureView.getContext();
                        if (context instanceof Activity) {
                            c.this.n = (Activity) context;
                        }
                    }
                    super.c();
                    c.this.a(false);
                }

                @Override // com.alibaba.triver.embed.video.fullscreenvideo.d, com.alibaba.triver.embed.video.fullscreenvideo.b
                public void e() {
                    super.e();
                    c.this.a(true);
                }
            };
        }
    }

    public static com.alibaba.triver.embed.video.fullscreenvideo.a b() {
        return a().i.f24864a;
    }

    public static Object c() {
        if (a().i.f24864a == null) {
            return null;
        }
        return a().i.f24864a.a();
    }

    public static long d() {
        return a().i.f();
    }

    public static long e() {
        return a().i.g();
    }

    public static float f() {
        return a().o;
    }

    public static void g() {
        a().i.c();
    }

    public static void h() {
        a().i.a();
    }

    public static boolean i() {
        return a().i.d();
    }

    public static long j() {
        if (a().i != null) {
            return a().i.h();
        }
        return 0L;
    }

    public void k() {
        this.m.removeCallbacksAndMessages(null);
        Message message = new Message();
        message.what = 2;
        this.m.sendMessage(message);
    }

    public void l() {
        k();
        Message message = new Message();
        message.what = 0;
        this.m.sendMessage(message);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (h.c() == null) {
            return;
        }
        RVLogger.d("JiaoZiVideoPlayer", "onSurfaceTextureAvailable [" + h.c().hashCode() + "] ");
        SurfaceTexture surfaceTexture2 = e;
        if (surfaceTexture2 != null) {
            d.setSurfaceTexture(surfaceTexture2);
        } else {
            e = surfaceTexture;
            l();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return e == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public static void b(float f2) {
        a().o = f2;
        a().i.a(f2, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.n != null) {
                    c.this.n.getWindow().addFlags(128);
                    if (z) {
                        c.this.n = null;
                    }
                }
            }
        });
    }

    public static c a() {
        if (g == null) {
            g = new c();
        }
        return g;
    }

    public static void a(com.alibaba.triver.embed.video.fullscreenvideo.a aVar) {
        a().i.f24864a = aVar;
    }

    public static void a(long j) {
        a().i.a(j);
    }

    public static void a(float f2) {
        a().i.a(f2);
    }
}
