package com.kc.dw.player.utils;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.kc.dw.ad.view.d;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.x1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    @Keep
    public class a implements com.kc.dw.cache.media.datasouce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.view.a f39582a;
        public final SoftReference b;
        public final String c;

        /* JADX INFO: renamed from: com.kc.dw.player.utils.b$a$a, reason: collision with other inner class name */
        @Keep
        public class C1098a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39583a;

            public C1098a(a aVar) {
                this.f39583a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                d dVar;
                super.safeRun();
                com.kc.dw.ad.view.a aVar = this.f39583a.f39582a;
                if (aVar.i == 2 || (dVar = aVar.f39184a) == null) {
                    return;
                }
                dVar.onStartDownload();
            }
        }

        /* JADX INFO: renamed from: com.kc.dw.player.utils.b$a$b, reason: collision with other inner class name */
        @Keep
        public class C1099b extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39584a;

            public C1099b(a aVar) {
                this.f39584a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                super.safeRun();
                this.f39584a.f39582a.b(2, "download video error16");
            }
        }

        public a(com.kc.dw.ad.view.a aVar, SoftReference softReference, String str) {
            this.f39582a = aVar;
            this.b = softReference;
            this.c = str;
        }

        @Override // com.kc.dw.cache.media.datasouce.c
        public void a() {
            StringBuilder sbA = com.kc.dw.activity.a.a("onBufferError:");
            sbA.append(this.c);
            LogUtil.e("MediaPlayerUtil", sbA.toString());
            this.f39582a.a();
            SdkHandler.runOnMainThread(new C1099b(this));
        }

        @Override // com.kc.dw.cache.media.datasouce.c
        public void a(int i, boolean z) {
            com.kc.dw.ad.view.a aVar = this.f39582a;
            MediaPlayer mediaPlayer = (MediaPlayer) this.b.get();
            aVar.d[0] = i;
            aVar.e[0] = z;
            aVar.a(mediaPlayer);
        }

        @Override // com.kc.dw.cache.media.datasouce.c
        public void a(boolean z) {
            this.f39582a.e[0] = z;
            if (z) {
                return;
            }
            SdkHandler.runOnMainThread(new C1098a(this));
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.player.utils.b$b, reason: collision with other inner class name */
    @Keep
    public class C1100b implements x1.a<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.view.a f39585a;
        public final MediaPlayer b;

        /* JADX INFO: renamed from: com.kc.dw.player.utils.b$b$a */
        @Keep
        public class a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f39586a;
            public final C1100b b;

            public a(C1100b c1100b, String str) {
                this.b = c1100b;
                this.f39586a = str;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.b.f39585a.b(2, this.f39586a);
            }
        }

        public C1100b(com.kc.dw.ad.view.a aVar, MediaPlayer mediaPlayer) {
            this.f39585a = aVar;
            this.b = mediaPlayer;
        }

        @Override // com.kc.dw.core.utils.x1.a
        public void a(int i, String str) {
            this.f39585a.a();
            SdkHandler.runOnMainThread(new a(this, str));
        }

        @Override // com.kc.dw.core.utils.x1.a
        public void a(String str, File file, boolean z) {
            File file2 = file;
            try {
                this.f39585a.e[0] = z;
                this.b.setDataSource(file2.getAbsolutePath());
                this.b.prepareAsync();
            } catch (Throwable th) {
                th.printStackTrace();
                this.f39585a.b(3, "setDataSource1 error：" + th);
            }
        }

        @Override // com.kc.dw.core.utils.x1.a
        public void onStartDownload() {
            d dVar;
            com.kc.dw.ad.view.a aVar = this.f39585a;
            if (aVar.i == 2 || (dVar = aVar.f39184a) == null) {
                return;
            }
            dVar.onStartDownload();
        }
    }

    public static void a(MediaPlayer mediaPlayer, com.kc.dw.ad.view.a aVar, String str) {
        try {
            if ((TextUtils.isEmpty(str) || str.trim().toLowerCase().contains("m3u8") || !str.trim().toLowerCase().startsWith("http")) ? false : true) {
                aVar.f = true;
                mediaPlayer.setDataSource(new com.kc.dw.player.datasource.b(str, new a(aVar, new SoftReference(mediaPlayer), str)));
                mediaPlayer.prepareAsync();
                return;
            }
            if (aVar.b > 0) {
                if (!(!TextUtils.isEmpty(str) && str.toLowerCase().contains("m3u8"))) {
                    x1.a(str, 86400000, true, new com.kc.dw.core.timeout.c(-1L, new C1100b(aVar, mediaPlayer), false));
                    return;
                }
            }
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
                aVar.b(3, "setDataSource1 error：" + e);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.b(3, "setDataSource error：" + th);
        }
    }
}
