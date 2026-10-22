package com.kc.dw.player;

import android.media.MediaPlayer;
import com.kc.dw.core.safe.f;
import com.kc.dw.core.safe.h;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39567a;
    public final int b;
    public final long c;
    public final com.kc.dw.player.a.b d;
    public final String e;

    @Keep
    public class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f39568a;
        public final boolean[] b;
        public final com.kc.dw.player.datasource.b[] c;
        public final MediaPlayer d;
        public final int[] e;
        public final c f;

        /* JADX INFO: renamed from: com.kc.dw.player.c$a$a, reason: collision with other inner class name */
        @Keep
        public class C1094a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39569a;

            public C1094a(a aVar) {
                this.f39569a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                StringBuilder sbA = com.kc.dw.activity.a.a("cache video success:");
                sbA.append(System.currentTimeMillis() - this.f39569a.f.c);
                LogUtil.dev("CacheMediaPlayerHelper", sbA.toString());
                a aVar = this.f39569a;
                c cVar = aVar.f;
                cVar.d.a(cVar.e, aVar.d, aVar.f39568a[0]);
            }
        }

        public a(c cVar, boolean[] zArr, boolean[] zArr2, com.kc.dw.player.datasource.b[] bVarArr, MediaPlayer mediaPlayer, int[] iArr) {
            this.f = cVar;
            this.f39568a = zArr;
            this.b = zArr2;
            this.c = bVarArr;
            this.d = mediaPlayer;
            this.e = iArr;
        }

        @Override // com.kc.dw.core.safe.h
        public void a(MediaPlayer mediaPlayer) {
            StringBuilder sbA = com.kc.dw.activity.a.a("onPrepared ");
            sbA.append(this.f39568a[0]);
            LogUtil.d("CacheMediaPlayerHelper", sbA.toString());
            this.b[0] = true;
            try {
                c cVar = this.f;
                int i = cVar.f39567a;
                if (i > 0 && i > cVar.b && this.c[0] != null) {
                    int duration = this.d.getDuration();
                    long size = this.c[0].getSize();
                    if (duration > 0 && size > 0) {
                        long j = (long) ((((double) this.f.f39567a) / ((double) duration)) * size);
                        com.kc.dw.cache.media.download.b bVar = this.c[0].f39579a.j;
                        if (bVar != null) {
                            bVar.a(j);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            boolean[] zArr = this.b;
            if (zArr[1] || !com.kc.dw.player.a.a(zArr[0], mediaPlayer, this.e[0], this.f.b)) {
                return;
            }
            this.b[1] = true;
            SdkHandler.runOnMainThread(new C1094a(this));
        }
    }

    @Keep
    public class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f39570a;
        public final c b;

        @Keep
        public class a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f39571a;

            public a(b bVar) {
                this.f39571a = bVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.f39571a.b.d.a();
            }
        }

        public b(c cVar, boolean[] zArr) {
            this.b = cVar;
            this.f39570a = zArr;
        }

        @Override // com.kc.dw.core.safe.f
        public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtil.w("CacheMediaPlayerHelper", "onError: what:" + i + "  extra:" + i2);
            boolean[] zArr = this.f39570a;
            if (zArr[1]) {
                return false;
            }
            zArr[1] = true;
            SdkHandler.runOnMainThread(new a(this));
            return false;
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.player.c$c, reason: collision with other inner class name */
    @Keep
    public class C1095c implements com.kc.dw.cache.media.datasouce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f39572a;
        public final int[] b;
        public final boolean[] c;
        public final MediaPlayer d;
        public final c e;

        /* JADX INFO: renamed from: com.kc.dw.player.c$c$a */
        @Keep
        public class a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1095c f39573a;

            public a(C1095c c1095c) {
                this.f39573a = c1095c;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                StringBuilder sbA = com.kc.dw.activity.a.a("onStartBuffer");
                sbA.append(System.currentTimeMillis() - this.f39573a.e.c);
                LogUtil.d("CacheMediaPlayerHelper", sbA.toString());
                this.f39573a.e.d.onStartDownload();
            }
        }

        /* JADX INFO: renamed from: com.kc.dw.player.c$c$b */
        @Keep
        public class b extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f39574a;
            public final C1095c b;

            public b(C1095c c1095c, boolean z) {
                this.b = c1095c;
                this.f39574a = z;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                StringBuilder sbA = com.kc.dw.activity.a.a("cache success  :");
                sbA.append(System.currentTimeMillis() - this.b.e.c);
                LogUtil.dev("CacheMediaPlayerHelper", sbA.toString());
                C1095c c1095c = this.b;
                c cVar = c1095c.e;
                cVar.d.a(cVar.e, c1095c.d, this.f39574a);
            }
        }

        /* JADX INFO: renamed from: com.kc.dw.player.c$c$c, reason: collision with other inner class name */
        @Keep
        public class C1096c extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1095c f39575a;

            public C1096c(C1095c c1095c) {
                this.f39575a = c1095c;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.f39575a.e.d.a();
            }
        }

        public C1095c(c cVar, boolean[] zArr, int[] iArr, boolean[] zArr2, MediaPlayer mediaPlayer) {
            this.e = cVar;
            this.f39572a = zArr;
            this.b = iArr;
            this.c = zArr2;
            this.d = mediaPlayer;
        }

        @Override // com.kc.dw.cache.media.datasouce.c
        public void a() {
            StringBuilder sbA = com.kc.dw.activity.a.a("onBufferError:");
            sbA.append(this.e.e);
            LogUtil.e("CacheMediaPlayerHelper", sbA.toString());
            boolean[] zArr = this.c;
            if (zArr[1]) {
                return;
            }
            zArr[1] = true;
            SdkHandler.runOnMainThread(new C1096c(this));
        }

        @Override // com.kc.dw.cache.media.datasouce.c
        public void a(int i, boolean z) {
            this.b[0] = i;
            this.f39572a[0] = z;
            boolean[] zArr = this.c;
            if (zArr[1] || !com.kc.dw.player.a.a(zArr[0], this.d, i, this.e.b)) {
                return;
            }
            this.c[1] = true;
            SdkHandler.runOnMainThread(new b(this, z));
        }

        @Override // com.kc.dw.cache.media.datasouce.c
        public void a(boolean z) {
            this.f39572a[0] = z;
            if (z) {
                return;
            }
            SdkHandler.runOnMainThread(new a(this));
        }
    }

    @Keep
    public class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f39576a;

        public d(c cVar) {
            this.f39576a = cVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39576a.d.a();
        }
    }

    public c(int i, int i2, long j, com.kc.dw.player.a.b bVar, String str) {
        this.f39567a = i;
        this.b = i2;
        this.c = j;
        this.d = bVar;
        this.e = str;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            boolean[] zArr = new boolean[2];
            int[] iArr = new int[1];
            boolean[] zArr2 = new boolean[1];
            zArr2[0] = false;
            com.kc.dw.player.datasource.b[] bVarArr = new com.kc.dw.player.datasource.b[1];
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnPreparedListener(new a(this, zArr2, zArr, bVarArr, mediaPlayer, iArr));
            mediaPlayer.setOnErrorListener(new b(this, zArr));
            com.kc.dw.player.datasource.b bVar = new com.kc.dw.player.datasource.b(this.e, new C1095c(this, zArr2, iArr, zArr, mediaPlayer));
            bVarArr[0] = bVar;
            mediaPlayer.setDataSource(bVar);
            mediaPlayer.prepareAsync();
        } catch (Throwable th) {
            th.printStackTrace();
            SdkHandler.runOnMainThread(new d(this));
        }
    }
}
