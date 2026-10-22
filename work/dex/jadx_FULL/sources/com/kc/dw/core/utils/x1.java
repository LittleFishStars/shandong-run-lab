package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class x1 {

    @Keep
    public interface a<T> {
        void a(int i, String str);

        void a(String str, T t, boolean z);

        void onStartDownload();
    }

    public static <T> void a(String str, int i, boolean z, a<T> aVar) {
        if (z) {
            try {
                try {
                    File fileA = com.kc.dw.core.bquery.c.a(com.kc.dw.base.a.getContext());
                    if (com.kc.dw.core.bquery.c.d == null) {
                        com.kc.dw.core.bquery.c.d = Executors.newSingleThreadScheduledExecutor();
                    }
                    com.kc.dw.core.bquery.c.d.schedule(new com.kc.dw.core.bquery.b(fileA, 86400000L), 0L, TimeUnit.MILLISECONDS);
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
                aVar.a(9, "mediaPlayer loadVideo error");
                return;
            }
        }
        File file = null;
        File fileA2 = com.kc.dw.core.bquery.c.a(com.kc.dw.core.bquery.c.a(com.kc.dw.base.a.getContext()), str, (String) null);
        if (fileA2 != null && fileA2.exists()) {
            file = fileA2;
        }
        if (file != null && file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLastModified = file.lastModified();
            if (file.length() > 0 && jCurrentTimeMillis - jLastModified < i) {
                SdkHandler.runOnMainThread(new t1(aVar, str, file));
                return;
            } else {
                try {
                    file.delete();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        u1 u1Var = new u1(aVar);
        try {
            com.kc.dw.cache.media.download.h.a(str, new v1(u1Var, str));
        } catch (Throwable unused2) {
            u1Var.a(9, "unknown3. download video error");
        }
    }
}
