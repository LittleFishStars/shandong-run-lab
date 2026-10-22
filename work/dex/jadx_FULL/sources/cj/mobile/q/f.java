package cj.mobile.q;

import android.content.Context;
import cj.mobile.utils.videocache.ProxyCacheException;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22650a;
    public final ExecutorService b;
    public final Map<String, g> c;
    public final ServerSocket d;
    public final int e;
    public final Thread f;
    public final cj.mobile.q.c g;
    public final i h;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f22651a;
        public cj.mobile.r.c b;
        public cj.mobile.r.a c;
        public cj.mobile.s.c d;

        public b(Context context) {
        }

        public b a(long j) {
        }

        public final cj.mobile.q.c b() {
        }

        public b a(int i) {
        }

        public f a() {
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Socket f22652a;
        public final /* synthetic */ f b;

        public c(f fVar, Socket socket) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f22653a;
        public final /* synthetic */ f b;

        public d(f fVar, CountDownLatch countDownLatch) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public final void a(Throwable th) {
    }

    public final File b(String str) {
    }

    public final g c(String str) throws ProxyCacheException {
    }

    public String d(String str) {
    }

    public boolean e(String str) {
    }

    public f(cj.mobile.q.c cVar) {
    }

    public final void d(Socket socket) {
    }

    public String a(String str, boolean z) {
    }

    public final void e(Socket socket) {
    }

    public final void b() {
    }

    public final void c(Socket socket) {
    }

    public final boolean a() {
    }

    public final void b(Socket socket) {
    }

    public final String a(String str) {
    }

    public final void a(File file) {
    }

    public final void a(Socket socket) {
    }
}
