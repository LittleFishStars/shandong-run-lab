package com.byazt.omf;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public static volatile gu<com.byazt.ddx.c> c;
    public static volatile com.byazt.ogz.sl tt;
    public static volatile Context uj;
    public static final AtomicBoolean ve = new AtomicBoolean(false);

    @com.byazt.zqa.c(c = {0, 1, 31, 703})
    public static class c {

        @SuppressLint({"StaticFieldLeak"})
        public static volatile Application c;

        static {
            try {
                Object objTt = tt();
                c = (Application) objTt.getClass().getMethod("getApplication", new Class[0]).invoke(objTt, new Object[0]);
                com.byazt.nr.m.tt("MyApplication", "application get success");
            } catch (Throwable th) {
                com.byazt.nr.m.tt("MyApplication", "application get failed", th);
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
                com.byazt.nr.m.tt("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static synchronized void c(Context context) {
        if (uj == null && context != null) {
            uj = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        if (uj == null) {
            uj = c.c();
        }
        return uj;
    }

    public static com.byazt.ogz.sl tt() {
        if (tt == null) {
            synchronized (com.byazt.ogz.sl.class) {
                if (tt == null) {
                    tt = new com.byazt.ogz.sl();
                }
            }
        }
        return tt;
    }

    public static gu<com.byazt.ddx.c> c() {
        if (c == null) {
            synchronized (gt.class) {
                if (c == null) {
                    c = new gr(getContext());
                }
            }
        }
        return c;
    }

    public static Function<SparseArray<Object>, Object> c(int i) {
        return eo.c().c(i);
    }
}
