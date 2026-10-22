package com.zj.adlib;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class t72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44861a = 64;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f19718a = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, Long> f19719a = new ConcurrentHashMap(64);

    public t72() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(long j) {
        Map<String, Long> map = f19719a;
        if (map.size() < 64) {
            return;
        }
        Iterator<Map.Entry<String, Long>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (j >= it.next().getValue().longValue()) {
                it.remove();
            }
        }
    }

    public static boolean b(@NonNull View view) {
        return c(view, 1000L);
    }

    public static boolean c(@NonNull View view, long j) {
        return d(String.valueOf(view.hashCode()), j);
    }

    public static boolean d(@NonNull String str, long j) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        }
        if (j < 0) {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a(jElapsedRealtime);
        Map<String, Long> map = f19719a;
        Long l = map.get(str);
        if (l != null && jElapsedRealtime < l.longValue()) {
            return false;
        }
        map.put(str, Long.valueOf(jElapsedRealtime + j));
        return true;
    }
}
