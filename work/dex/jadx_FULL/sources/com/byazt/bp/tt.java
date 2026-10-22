package com.byazt.bp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 896, 13})
public class tt {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context c;
    public static volatile com.byazt.qe.ve tt;
    public static volatile com.byazt.le.c<com.byazt.ng.c> ve;

    @com.byazt.zqa.c(c = {0, 1, 896, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {

        @SuppressLint({"StaticFieldLeak"})
        public static volatile Application c;

        static {
            try {
                Object objTt = tt();
                c = (Application) objTt.getClass().getMethod("getApplication", new Class[0]).invoke(objTt, new Object[0]);
                com.byazt.eu.tt.uj("MyApplication", "application get success");
            } catch (Throwable th) {
                com.byazt.eu.tt.tt("MyApplication", "application get failed", th);
            }
        }

        public static Application c() {
            return c;
        }

        private static Object tt() {
            try {
                Method method = Class.forName(ProcessUtils.ACTIVITY_THREAD).getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.byazt.eu.tt.tt("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static com.byazt.le.c<com.byazt.ng.c> c() {
        if (ve == null) {
            synchronized (tt.class) {
                if (ve == null) {
                    ve = new com.byazt.le.tt();
                }
            }
        }
        return ve;
    }

    public static Context getContext() {
        if (c == null) {
            c(null);
        }
        return c;
    }

    public static com.byazt.qe.ve tt() {
        if (tt == null) {
            synchronized (com.byazt.qe.ve.class) {
                if (tt == null) {
                    tt = new com.byazt.qe.ve();
                }
            }
        }
        return tt;
    }

    public static synchronized void c(Context context) {
        if (c == null) {
            synchronized (tt.class) {
                if (c.c() != null) {
                    try {
                        Application applicationC = c.c();
                        c = applicationC;
                        if (applicationC != null) {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (context != null) {
                    c = context.getApplicationContext();
                }
            }
        }
    }
}
