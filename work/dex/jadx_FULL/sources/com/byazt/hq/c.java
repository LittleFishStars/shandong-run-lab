package com.byazt.hq;

import android.text.TextUtils;
import com.alipay.sdk.m.t.e;
import com.byazt.aas.eo;
import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.ete.nb;
import com.byazt.hm.tt;
import com.byazt.nr.a;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.va.uj;
import com.byazt.va.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 20})
public class c {
    public static String c = "";
    public static String tt = "";

    /* JADX INFO: renamed from: com.byazt.hq.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 44})
    public static class RunnableC0426c implements Runnable {
        public WeakReference<Runnable> c;

        public RunnableC0426c(Runnable runnable) {
            if (runnable != null) {
                this.c = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.c;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void c(final RunnableC0426c runnableC0426c) {
        nb nbVarDz = gt.tt().dz();
        final String strC = nbVarDz == null ? null : nbVarDz.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        if (TextUtils.isEmpty(tt)) {
            tt = strC;
        }
        n.tt(new sp("loadPfJs") { // from class: com.byazt.hq.c.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0426c runnableC0426c2;
                String str = strC;
                if (str != null && str.equalsIgnoreCase(c.tt)) {
                    if (TextUtils.isEmpty(c.c)) {
                        c.c = eo.c("js_pform").get(a.tt(strC), "");
                    }
                    if (!TextUtils.isEmpty(c.c) && (runnableC0426c2 = runnableC0426c) != null) {
                        runnableC0426c2.run();
                        return;
                    }
                }
                ve veVarVe = com.byazt.hy.n.c().tt().ve();
                veVarVe.c(strC);
                HashMap map = new HashMap();
                map.put(e.f, "application/json; charset=utf-8");
                veVarVe.uj(map);
                veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.hq.c.1.1
                    @Override // com.byazt.mh.c
                    public void c(uj ujVar, tt ttVar) {
                        try {
                            c.c = ttVar.n();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.tt = strC;
                            RunnableC0426c runnableC0426c3 = runnableC0426c;
                            if (runnableC0426c3 != null) {
                                runnableC0426c3.run();
                            }
                            eo.c("js_pform").clear();
                            eo.c("js_pform").put(a.tt(strC), c.c);
                        } catch (Throwable th) {
                            m.ve("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }

                    @Override // com.byazt.mh.c
                    public void c(uj ujVar, IOException iOException) {
                    }
                });
            }
        });
    }

    public static void c(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }
}
