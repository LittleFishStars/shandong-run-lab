package com.kc.dw.ad.view;

import android.media.MediaPlayer;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f39184a;
    public final long b;
    public boolean[] c = new boolean[2];
    public int[] d = new int[1];
    public boolean[] e = {false};
    public volatile boolean f = false;
    public final Object h = new Object();
    public volatile int i = 0;
    public final long g = System.currentTimeMillis();

    /* JADX INFO: renamed from: com.kc.dw.ad.view.a$a, reason: collision with other inner class name */
    @Keep
    public class C1019a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39185a;

        /* JADX INFO: renamed from: com.kc.dw.ad.view.a$a$a, reason: collision with other inner class name */
        @Keep
        public class C1020a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1019a f39186a;

            public C1020a(C1019a c1019a) {
                this.f39186a = c1019a;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                super.safeRun();
                this.f39186a.f39185a.a(1, "download video timeout15");
            }
        }

        public C1019a(a aVar) {
            this.f39185a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            this.f39185a.a(2);
            if (this.f39185a.i != 2) {
                return;
            }
            a aVar = this.f39185a;
            synchronized (aVar.h) {
                d dVar = aVar.f39184a;
                if (dVar != null) {
                    dVar.a();
                }
            }
            SdkHandler.getInstance().runOnUiThread(new C1020a(this));
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaPlayer f39187a;
        public final a b;

        public b(a aVar, MediaPlayer mediaPlayer) {
            this.b = aVar;
            this.f39187a = mediaPlayer;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            StringBuilder sbA = com.kc.dw.activity.a.a("cache video success:");
            sbA.append(System.currentTimeMillis() - this.b.g);
            LogUtil.dev("NotifyCacheStateHelper", sbA.toString());
            a aVar = this.b;
            a.a(aVar, this.f39187a, aVar.e[0]);
        }
    }

    public a(long j, long j2) {
        this.b = j;
        try {
            Timer timer = new Timer();
            C1019a c1019a = new C1019a(this);
            if (j2 <= 0) {
                j2 = 5000;
            }
            timer.schedule(c1019a, j2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(a aVar, MediaPlayer mediaPlayer, boolean z) {
        aVar.a(1);
        if (aVar.i != 1) {
            return;
        }
        synchronized (aVar.h) {
            d dVar = aVar.f39184a;
            if (dVar != null) {
                try {
                    dVar.a(mediaPlayer, z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                aVar.f39184a = null;
            }
        }
    }

    public void a() {
        a(1);
        if (this.i != 1) {
            return;
        }
        synchronized (this.h) {
            d dVar = this.f39184a;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public final void a(int i) {
        synchronized (this.h) {
            if (this.i == 0) {
                this.i = i;
            }
        }
    }

    public final void a(int i, String str) {
        synchronized (this.h) {
            d dVar = this.f39184a;
            if (dVar != null) {
                dVar.onPrepareError(i, str);
                this.f39184a = null;
            }
        }
    }

    public final void a(MediaPlayer mediaPlayer) {
        boolean[] zArr = this.c;
        if (zArr[1]) {
            return;
        }
        boolean z = false;
        boolean z2 = zArr[0];
        int i = this.d[0];
        long j = this.b;
        if (z2 && (j <= 0 || mediaPlayer == null || (mediaPlayer.getDuration() * i) / 100 >= j || i == 100)) {
            z = true;
        }
        if (z) {
            this.c[1] = true;
            SdkHandler.runOnMainThread(new b(this, mediaPlayer));
        }
    }

    public void b(int i, String str) {
        a(1);
        if (this.i != 1) {
            return;
        }
        a(i, str);
    }
}
