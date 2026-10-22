package cj.mobile.jt.common.track;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class e {
    public static final int d;
    public static final int e;
    public static final LinkedBlockingQueue f;
    public static final c g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22368a;
    public final ThreadPoolExecutor b;
    public final ConcurrentHashMap c;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        d = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        e = iAvailableProcessors != 1 ? (iAvailableProcessors * 2) + 1 : 4;
        f = new LinkedBlockingQueue(50);
        g = new c();
    }

    public e(Context context) {
    }

    public static String a(String str, a aVar) {
    }

    public e(Context context, int i, int i2) {
    }
}
