package android.taobao.windvane.c;

import android.taobao.windvane.util.TaoLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f21204a = 4096;
    private static ExecutorService b = null;
    private static a c = null;
    private static final int d = 1;
    private C0008a e = null;

    /* JADX INFO: renamed from: android.taobao.windvane.c.a$a, reason: collision with other inner class name */
    public static class C0008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f21205a;
        private boolean b = false;

        public C0008a() {
            this.f21205a = null;
            this.f21205a = new byte[a.f21204a];
        }

        public boolean a() {
            return this.b;
        }

        public void a(boolean z) {
            this.b = z;
        }
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public C0008a b() {
        if (this.e == null) {
            this.e = new C0008a();
        }
        return this.e;
    }

    public void c() {
        C0008a c0008a = this.e;
        if (c0008a != null || c0008a.b) {
            C0008a c0008a2 = this.e;
            c0008a2.f21205a = null;
            c0008a2.b = false;
            this.e = null;
        }
    }

    public void a(Runnable runnable) {
        if (b == null) {
            b = Executors.newFixedThreadPool(1);
        }
        if (runnable == null) {
            TaoLog.w("WVThreadPool", "executeSingle is null.");
        } else {
            b.execute(runnable);
        }
    }
}
