package cn.jy.ad.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f22772a = Executors.newSingleThreadExecutor();
    public static final Handler b = new Handler(Looper.getMainLooper());

    public static ExecutorService a() {
        return f22772a;
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                b.post(runnable);
            }
        }
    }
}
