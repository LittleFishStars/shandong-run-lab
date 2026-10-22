package com.kc.dw.player;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.x1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: com.kc.dw.player.a$a, reason: collision with other inner class name */
    @Keep
    public class C1092a implements x1.a<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39563a;

        /* JADX INFO: renamed from: com.kc.dw.player.a$a$a, reason: collision with other inner class name */
        @Keep
        public class C1093a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1092a f39564a;

            public C1093a(C1092a c1092a) {
                this.f39564a = c1092a;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                b bVar = this.f39564a.f39563a;
                if (bVar != null) {
                    bVar.onStartDownload();
                }
            }
        }

        /* JADX INFO: renamed from: com.kc.dw.player.a$a$b */
        @Keep
        public class b extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1092a f39565a;

            public b(C1092a c1092a) {
                this.f39565a = c1092a;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                b bVar = this.f39565a.f39563a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        public C1092a(b bVar) {
            this.f39563a = bVar;
        }

        @Override // com.kc.dw.core.utils.x1.a
        public void a(int i, String str) {
            SdkHandler.runOnMainThread(new b(this));
        }

        @Override // com.kc.dw.core.utils.x1.a
        public void a(String str, File file, boolean z) {
            SdkHandler.runOnMainThread(new com.kc.dw.player.b(this, str, z));
        }

        @Override // com.kc.dw.core.utils.x1.a
        public void onStartDownload() {
            SdkHandler.runOnMainThread(new C1093a(this));
        }
    }

    @Keep
    public interface b {
        void a();

        void a(String str, MediaPlayer mediaPlayer, boolean z);

        void onStartDownload();
    }

    public static void a(String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            ((com.kc.dw.player.utils.a) bVar).b();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ExecutorService executorService = f0.f39362a;
        if (f0.b.f39363a.a(new c(0, 0, jCurrentTimeMillis, bVar, str))) {
            return;
        }
        SdkHandler.runOnMainThread(new d(bVar));
    }

    public static boolean a(boolean z, MediaPlayer mediaPlayer, int i, int i2) {
        if (z) {
            if (i2 > 0) {
                int duration = mediaPlayer.getDuration();
                int i3 = (duration * i) / 100;
                LogUtil.d("CacheMediaPlayerHelper", "videoPrepareProgress:" + duration + " percent:" + i + " curCacheDur:" + i3 + " minCacheDuration:" + i2);
                if (i3 >= i2 || i == 100) {
                }
            }
            return true;
        }
        return false;
    }
}
