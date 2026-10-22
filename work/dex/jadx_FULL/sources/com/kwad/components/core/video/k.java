package com.kwad.components.core.video;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k {
    private static Map<String, Integer> anV = new ConcurrentHashMap();

    public static boolean a(@NonNull String str, String str2, com.kwad.sdk.core.network.a.a.C1286a c1286a) {
        String strMd5 = an.md5(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + strMd5 + "--url:" + str);
        boolean zB = com.kwad.sdk.core.diskcache.b.a.Lx().b(str, str2, c1286a);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "finish cache video key:" + strMd5 + "--cache time:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--success:" + zB);
        return zB;
    }

    public static boolean bh(@NonNull AdTemplate adTemplate) {
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        return fileCO != null && fileCO.exists();
    }

    private static int bq(String str) {
        Integer num = anV.get(str);
        return num != null ? num.intValue() : com.kwad.sdk.core.config.e.Ga();
    }

    public static String j(Context context, @NonNull AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.helper.e.fe(adTemplate), com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
    }

    public static String k(Context context, String str) {
        return a(context, bq(str), str);
    }

    public static void n(String str, int i) {
        anV.put(str, Integer.valueOf(i));
    }

    private static String a(Context context, int i, String str) {
        if (i >= 0) {
            return i > 0 ? com.kwad.sdk.core.videocache.c.a.cm(context).fx(str) : str;
        }
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(str);
        return (fileCO == null || !fileCO.exists()) ? str : fileCO.getAbsolutePath();
    }
}
