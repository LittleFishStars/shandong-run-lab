package com.byazt.mq;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.byazt.uq.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 20})
public final class c {
    public static final ve c;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT})
    public static class n extends C0467c {
        private n() {
            super();
        }

        @Override // com.byazt.mq.c.C0467c, com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            Object objC = c(context, "mWhiteListMap");
            if (!(objC instanceof Map)) {
                return false;
            }
            Map map = (Map) objC;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt extends n {
        private tt() {
            super();
        }

        @Override // com.byazt.mq.c.n, com.byazt.mq.c.C0467c, com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            return false;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 187})
    public static class uj extends C0467c {
        private uj() {
            super();
        }

        @Override // com.byazt.mq.c.C0467c, com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            Object objC = c(context, "mWhiteList");
            if (!(objC instanceof List)) {
                return false;
            }
            ((List) objC).add(context.getPackageName());
            return true;
        }
    }

    public interface ve {
        boolean c(Context context) throws Throwable;
    }

    static {
        if (Build.VERSION.SDK_INT < 28) {
            c = new n();
        } else {
            c = new tt();
        }
    }

    public static void c(Application application) {
        if (application != null) {
            try {
                if (i.my()) {
                    c.c(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.mq.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 44})
    public static class C0467c implements ve {
        private C0467c() {
        }

        private Object tt(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            Object objTt = tt(context);
            Object objC = c(objTt, "mWhiteList");
            if (!(objC instanceof String[])) {
                if (objTt == null) {
                    return false;
                }
                FieldUtils.writeField(objTt, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objC);
            FieldUtils.writeField(objTt, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public Object c(Context context, String str) {
            return c(tt(context), str);
        }

        private Object c(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
