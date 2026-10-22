package android.taobao.windvane.c;

import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {
    private static String b = "WVThreadPool";
    private static final int c;
    private static final int d;
    private static final int e;
    private static final int f = 500;
    private static b g;
    private ExecutorService h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LinkedHashMap<String, Future> f21206a = new LinkedHashMap<>(d - 1);

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        c = iAvailableProcessors;
        d = iAvailableProcessors + 1;
        e = (iAvailableProcessors * 2) + 1;
    }

    private void c() {
        if (this.f21206a.size() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(((ThreadPoolExecutor) this.h).getActiveCount());
        for (Map.Entry<String, Future> entry : this.f21206a.entrySet()) {
            if (!entry.getValue().isDone()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.f21206a.clear();
        this.f21206a.putAll(linkedHashMap);
    }

    public void a(Executor executor) {
        if (this.h == null && executor != null && (executor instanceof ExecutorService)) {
            b += "tb";
            this.h = (ExecutorService) executor;
        }
    }

    public ExecutorService b() {
        if (this.h == null) {
            int i = d;
            this.h = new ThreadPoolExecutor(i, e, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i));
        }
        return this.h;
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    public void a(Runnable runnable) {
        a(runnable, null);
    }

    public void a(Runnable runnable, String str) {
        if (this.h == null) {
            int i = d;
            this.h = new ThreadPoolExecutor(i, e, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i));
        }
        if (runnable == null) {
            TaoLog.w(b, "execute task is null.");
            return;
        }
        c();
        if (!TextUtils.isEmpty(str)) {
            if (this.f21206a.size() != 0 && this.f21206a.size() == d - 1 && !this.f21206a.containsKey(str)) {
                String str2 = (String) this.f21206a.keySet().toArray()[0];
                Future futureRemove = this.f21206a.remove(str2);
                if (futureRemove != null) {
                    futureRemove.cancel(true);
                }
                this.f21206a.put(str, this.h.submit(runnable));
                TaoLog.d(b, "remove first task:[" + str2 + "]");
            } else {
                Future futurePut = this.f21206a.put(str, this.h.submit(runnable));
                if (futurePut != null) {
                    futurePut.cancel(true);
                }
                TaoLog.d(b, "overlap the same name task:[" + str + "]");
            }
        } else {
            this.h.execute(runnable);
        }
        TaoLog.d(b, "activeTask count after:" + ((ThreadPoolExecutor) this.h).getActiveCount());
    }
}
