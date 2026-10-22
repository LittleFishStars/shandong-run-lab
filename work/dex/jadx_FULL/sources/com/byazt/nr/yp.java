package com.byazt.nr;

import android.annotation.TargetApi;
import android.os.Looper;
import android.webkit.WebView;
import com.alibaba.ariver.remotedebug.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 215})
public class yp {
    public static final c c = new tt();

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE})
    public static class c {
        private c() {
        }

        public void c(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            yp.tt(new Runnable() { // from class: com.byazt.nr.yp.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 2052})
    @TargetApi(19)
    public static class tt extends c {
        private tt() {
            super();
        }

        @Override // com.byazt.nr.yp.c
        public void c(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            yp.tt(new Runnable() { // from class: com.byazt.nr.yp.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    boolean z = false;
                    if (str2 != null && str2.startsWith(b.k)) {
                        try {
                            webView.evaluateJavascript(str, null);
                            z = true;
                        } catch (Throwable th) {
                            boolean z2 = th instanceof IllegalStateException;
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            da.tt().post(runnable);
        }
    }

    @Deprecated
    public static void c(WebView webView, String str) {
        c.c(webView, str);
    }

    public static void c(com.byazt.nl.uj ujVar, String str) {
        c.c(ujVar.getWebView(), str);
    }
}
