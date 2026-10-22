package com.kc.dw.ad.interstitial;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import com.kc.dw.core.ad.interstitial.InterstitialAdListener;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f39097a;

    @Keep
    public class a implements com.kc.dw.player.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean[] f39098a;
        public final CountDownLatch b;
        public final e c;

        public a(e eVar, boolean[] zArr, CountDownLatch countDownLatch) {
            this.c = eVar;
            this.f39098a = zArr;
            this.b = countDownLatch;
        }

        @Override // com.kc.dw.player.a.b
        public void a() {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c.f39097a.f39103a, new LoadResState().setFail(2));
            this.b.countDown();
        }

        @Override // com.kc.dw.player.a.b
        public void a(String str, MediaPlayer mediaPlayer, boolean z) {
            this.f39098a[0] = true;
            com.kc.dw.core.service.logrecord.a.a(5, "s4", this.c.f39097a.f39103a, new LoadResState().setSuccess(2, 1, z ? 1 : 0));
            this.b.countDown();
        }

        @Override // com.kc.dw.player.a.b
        public void onStartDownload() {
        }
    }

    @Keep
    public class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f39099a;

        public b(e eVar) {
            this.f39099a = eVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.ad.interstitial.a aVar = this.f39099a.f39097a.b;
            if (aVar != null) {
                ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar).onAdRenderFail("插屏视频渲染失败", com.kc.dw.core.exception.b.c.intValue());
            }
        }
    }

    @Keep
    public class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f39100a;
        public final long b;
        public final e c;

        public c(e eVar, Bitmap bitmap, long j) {
            this.c = eVar;
            this.f39100a = bitmap;
            this.b = j;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            InterstitialAdListener interstitialAdListener;
            Bitmap bitmap = this.f39100a;
            if (bitmap != null && this.b < 1000) {
                this.c.f39097a.f = bitmap.getHeight();
                this.c.f39097a.g = this.f39100a.getWidth();
                g gVar = this.c.f39097a;
                if (gVar.f > gVar.g) {
                    gVar.e = 2;
                }
            }
            com.kc.dw.ad.interstitial.a aVar = this.c.f39097a.b;
            if (aVar == null || (interstitialAdListener = ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar).f39478a) == null) {
                return;
            }
            interstitialAdListener.onAdReady(null);
        }
    }

    @Keep
    public class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f39101a;

        public d(e eVar) {
            this.f39101a = eVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.ad.interstitial.a aVar = this.f39101a.f39097a.b;
            if (aVar != null) {
                ((com.kc.dw.platform.ad_adapter.interstitial.a) aVar).onAdRenderFail("插屏视频渲染失败", com.kc.dw.core.exception.b.c.intValue());
            }
        }
    }

    public e(g gVar) {
        this.f39097a = gVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            String str = this.f39097a.a().getImageUrls()[0];
            boolean[] zArr = new boolean[1];
            zArr[0] = false;
            com.kc.dw.player.a.a(str, new com.kc.dw.player.utils.a(3000, new a(this, zArr, countDownLatch)));
            if (countDownLatch.getCount() != 0) {
                try {
                    countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
            if (!zArr[0]) {
                SdkHandler.runOnMainThread(new b(this));
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            SdkHandler.getInstance().runOnUiThread(new c(this, com.kc.dw.player.utils.c.a(str, true), System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th) {
            SdkHandler.runOnMainThread(new d(this));
            th.printStackTrace();
        }
    }
}
